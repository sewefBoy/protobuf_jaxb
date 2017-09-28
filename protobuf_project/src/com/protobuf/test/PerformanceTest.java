package com.protobuf.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.jaxb.pojo.PersonContext;
import com.jaxb.pojo.PersonJaxb;
import com.jaxb.pojo.PhoneJaxb;
import com.jaxb.util.JAXBUtil;
import com.protobuf.mode.PersonProto;
import com.protobuf.pojo.Person;
import com.protobuf.pojo.Phone;

public class PerformanceTest {
	private static int MAX = 1000000;
	
	public static void main(String[] args) {
		try {
			javaSerial();
			protoSerial();
			jaxbSerial();
			System.out.println("__结束1__");
			javaNoSerial();
			protoNoSerial();
			jaxbNoSerial();
			System.out.println("__结束2__");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * java serializable性能
	 * @throws Exception
	 */
	public static void javaSerial() throws Exception{
		System.out.println("javaSerial 开始");
		long startTime = System.currentTimeMillis();
		FileOutputStream fos = new FileOutputStream("D:/performance/javaSerial.xml");
		//ByteArrayOutputStream fos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		for(int i = 0;i < MAX;i++){
			Person person = new Person();
			person.setId(i);
			person.setEmail("email"+i);
			person.setName("name"+i);
			Phone phone = new Phone();
			phone.setPhoneNum("phone"+i);
			phone.setPhoneType(1);
			List<Phone> phones = new ArrayList<Phone>();
			phones.add(phone);
			person.setPhones(phones);
			oos.writeObject(person);
		}
		oos.close();
		System.out.println("javaSerial: "+(System.currentTimeMillis()-startTime));
	}
	
	/**
	 * protobuf 序列化性能
	 * @throws Exception
	 */
	public static void protoSerial() throws Exception{
		System.out.println("protoSerial 开始");
		long startTime = System.currentTimeMillis();
		FileOutputStream fos = new FileOutputStream("D:/performance/protoSerial.xml");
		
		for(int i = 0; i < MAX; i++){
			PersonProto.Person person = PersonProto.Person.newBuilder()
				.setId(i)
				.setEmail("email"+i)
				.setName("name"+i)
				.addPhone(PersonProto.Person.Phone.newBuilder().setPhoneNum("phoneNum"+i)
						.setPhoneType(0).build())
				.build();
			person.writeDelimitedTo(fos);
		}
		fos.close();
		System.out.println("protoSerial: "+(System.currentTimeMillis()-startTime));
	}
	
	/**
	 * java反序列化
	 * @throws Exception
	 */
	public static void javaNoSerial() throws Exception{
		System.out.println("javaNoSerial 开始");
		long startTime = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("D:/performance/javaSerial.xml");
		ObjectInputStream ois = new ObjectInputStream(fis);
		for(int i=0; i<MAX; i++){
			/*Person person = (Person) */ois.readObject();
			//System.out.println(person.toString());
		}
		ois.close();
		System.out.println("javaDeSerial: "+(System.currentTimeMillis()-startTime));
	}
	
	/**
	 * proto反序列化
	 * @throws Exception
	 */
	public static void protoNoSerial() throws Exception{
		System.out.println("protoNoSerial 开始");
		long startTime = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("D:/performance/protoSerial.xml");

		for(int i=0; i<MAX; i++){
			/*PersonProto.Person person = */PersonProto.Person.parseDelimitedFrom(fis);
			//System.out.println(person.toString());
		}
		fis.close();
		System.out.println("protoDeSerial: "+(System.currentTimeMillis()-startTime));
	}
	
	/**
	 * jaxb序列化
	 * @throws Exception
	 */
	public static void jaxbSerial() throws Exception{
		System.out.println("jaxbSerial 开始");
		long startTime = System.currentTimeMillis();
    	List<PersonJaxb> pset = new ArrayList<PersonJaxb>();  
    	for(int i=0;i<MAX;i++){
    		List<PhoneJaxb> set = new ArrayList<PhoneJaxb>();  
    		PhoneJaxb phone1 = new PhoneJaxb("phoneNum"+i , i);  
    		set.add(phone1);  
    		PersonJaxb p1 = new PersonJaxb(i,"name"+i,"email"+i,set);
    		pset.add(p1);
    	}
        PersonContext context = new PersonContext(pset);  
        JAXBUtil.toXML(context, "D:\\performance\\javxb.xml"); //序列化  
        System.out.println("jaxbSerial: "+(System.currentTimeMillis()-startTime));
	}
	
	/**
	 * jaxb反序列化
	 * @throws Exception
	 */
	public static void jaxbNoSerial() throws Exception{
		System.out.println("jaxbNoSerial 开始");
		long startTime = System.currentTimeMillis();
		JAXBUtil.formXML(PersonContext.class ,"D:\\performance\\javxb.xml"); //反序列化
        System.out.println("jaxbDeSerial: "+(System.currentTimeMillis()-startTime));
	}
}
