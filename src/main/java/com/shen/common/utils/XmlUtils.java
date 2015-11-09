package com.shen.common.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Jaxb方式解析XML
 *
 * @author shen
 *
 */
public class XmlUtils {

	/**
	 * 把对象转换为xml
	 * @param obj
	 * @param encoding
	 * @throws JAXBException
	 */
	public static void toXMl(Object obj,String encoding) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		//编码格式
		marshaller.setProperty(Marshaller.JAXB_ENCODING,encoding);
		//是否格式化生成的xml串
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//是否省略xml头信息（<?xml version="1.0" encoding="utf-8" standalone="yes"?>）  
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
		marshaller.marshal(obj, System.out);
	}

	/**
	 * 解析xml到对象。
	 * @param in
	 * @return
	 * @throws JAXBException
	 * @throws UnsupportedEncodingException
	 */
	public static Object parseXml(Object obj , InputStream in, String encoding) throws JAXBException, UnsupportedEncodingException{
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Unmarshaller unmarshaller = context.createUnmarshaller();
		InputStreamReader reader = new InputStreamReader(in, encoding);
		return unmarshaller.unmarshal(reader);
	}


	public static void main(String[] args){
//		XmlUtils x = new XmlUtils();
//		MonadWebConfig m = new MonadWebConfig();
//		Resource m = new Resource();
//		try {
//			XmlUtils.toXMl(m, "utf-8");
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}
//		String xmlFileName = "/guhua.xml";
//		InputStream in = XmlUtils.class.getResourceAsStream(xmlFileName);
//		Resource mw = new Resource();
//		try {
//			mw = (Resource) XmlUtils.parseXml(mw, in, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(mw.log_file);
//		System.out.println(mw.jdbc);
//		System.out.println(mw.jdbc.driver);
	}

}
