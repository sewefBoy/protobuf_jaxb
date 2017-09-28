
package com.jaxb.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.jaxb.pojo.PersonContext;  
  
public class JAXBUtil {  
    private static final String ENCODING = "UTF-8";  
  
    public static <T> T formXML(Class<T> clazz, String filePath) {  
        JAXBContext jaxbContext = null;  
        T object = null;  
        try {
        	File file = new File(filePath);
            jaxbContext = JAXBContext.newInstance(clazz);  
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();  
            PersonContext jaxbElement =  (PersonContext) unmarshaller.unmarshal(file);  
            object = (T) jaxbElement;  
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return object;  
    }  
  
    public static <T> String toXML(T object ,String filePath) {  
        String xml = "";  
        try {  
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());  
            Marshaller marshaller = jaxbContext.createMarshaller();  
            // 是否格式化生成xml  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
            // 设置编码方式  
            marshaller.setProperty(Marshaller.JAXB_ENCODING, ENCODING);  
  
            File file = new File(filePath);
            marshaller.marshal(object, file);
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
//            marshaller.marshal(object, byteArrayOutputStream);
//            byte[] buf = byteArrayOutputStream.toByteArray();  
//            xml = new String(buf, 0, buf.length, ENCODING);  
        } catch (Exception e) {  
        	e.printStackTrace();
        }  
        return xml;  
    }  
}  
