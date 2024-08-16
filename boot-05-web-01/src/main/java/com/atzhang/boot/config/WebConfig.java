package com.atzhang.boot.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import com.atzhang.boot.bean.Pet;
import com.atzhang.boot.converter.ZhangMessageConverter;

@Configuration(proxyBeanMethods = false)
public class WebConfig {
	
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
		methodFilter.setMethodParam("_m");
		return methodFilter;
	}
	
	 //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
	@Bean
	public WebMvcConfigurer webMvcConfigurer(){
		return new WebMvcConfigurer() {
			
			/**
			 * 自定义内容协商策略
			 */
			/*			@Override
						public void configureContentNegotiation(ContentNegotiationConfigurer configurer ) {
							Map<String, MediaType> mediaTypes = new HashMap<>();
							mediaTypes.put("json", MediaType.APPLICATION_JSON);
							mediaTypes.put("xml", MediaType.APPLICATION_XML);
							mediaTypes.put("zhang", MediaType.parseMediaType("application/x-zhang"));
							// 基于参数的，内容协商策略 ex:  localhost：8080/test/person?format=json
							ParameterContentNegotiationStrategy parameterStrategy = 
									new ParameterContentNegotiationStrategy(mediaTypes);
							
							// 基于请求头的，内容协商策略 accept= application/json 
							HeaderContentNegotiationStrategy headerStrategy = 
									new HeaderContentNegotiationStrategy();
							configurer.strategies(Arrays.asList(parameterStrategy, headerStrategy));
						}*/
			// 自定义消息转换器
			@Override
			public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
				converters.add(new ZhangMessageConverter());
			}
			@Override
			public void configurePathMatch (PathMatchConfigurer configurer) {
				UrlPathHelper urlPathHelper = new UrlPathHelper();
				// 
				urlPathHelper.setRemoveSemicolonContent(false);
				configurer.setUrlPathHelper(urlPathHelper);
				
			}
			
			/**
			 * 自定义转换器，用于页面参数，转换为POJO对象
			 */
			@Override
			public void addFormatters(FormatterRegistry registry){
				registry.addConverter(new Converter<String, Pet>(){
					
					@Override
					public Pet convert(String source) {
						
						if(!ObjectUtils.isEmpty(source)) {
							Pet pet = new Pet();
							String[] spilt = source.split(",");
							pet.setName(spilt[0]);
							pet.setAge(Integer.parseInt(spilt[1]));
							
							return pet;
							
						}
						
						return null;
						
					}
				});
				
			}
		};
	}
	
}
