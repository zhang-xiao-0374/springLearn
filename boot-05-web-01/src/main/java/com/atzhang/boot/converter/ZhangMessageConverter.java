package com.atzhang.boot.converter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.atzhang.boot.bean.Person;	

/**
 * 自定义的Converter
 */
public class ZhangMessageConverter  implements HttpMessageConverter<Person>{

	@Override
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		// 只要是Person类型，就可以对它进行读写
		return clazz.isAssignableFrom(Person.class);
	}

	/**
	 * server要统计所有的MessageConverter能写出哪些内容类型
	 * 能操作自定义的MessageConverter x-zhang
	 */
	@Override
	public List<MediaType> getSupportedMediaTypes() {
		
		return MediaType.parseMediaTypes("application/x-zhang");
	}

	@Override
	public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void write(Person t, MediaType contentType, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		// 自定义的MessageConverter数据的写出
		String data = t.getUserName()+ ";"
				+ t.getAge()+ ";"
				+t.getBirth();
		
		OutputStream body = outputMessage.getBody();
		
		body.write(data.getBytes());
		
	}

}
