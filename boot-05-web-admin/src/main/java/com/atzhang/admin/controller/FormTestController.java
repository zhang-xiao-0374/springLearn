package com.atzhang.admin.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * ファイルをアップロードのテストクラス
 */
@Slf4j
@Controller
public class FormTestController {
	
	@GetMapping("form_layouts")
	public String form_layouts() {
		
		return "form/form_layouts";
	}
	
	/**
	 * MultipartFile自动封装上传来的文件
	 * @param email
	 * @param userName
	 * @param headerImage
	 * @param photos
	 * @return
	 */
	@PostMapping("/upload")
	public String upload(@RequestParam("email")String email,
									@RequestParam("userName")String userName,
									@RequestPart("headerImage")MultipartFile headerImage,
									@RequestPart("photos")MultipartFile[] photos)  throws IOException{
		
		log.info("アップロード情報：email={}, userName={}, headerImage={}, photos={}",
				email, userName, headerImage.getSize(), photos.length);
		
		if(!(headerImage.isEmpty())) {
			String headerFileName = headerImage.getOriginalFilename();
			headerImage.transferTo(
					new File("C:\\Users\\z4961\\OneDrive\\デスクトップ\\IT&Learn\\JAVA\\springBoot2\\upload\\"+headerFileName));
		}
		
		if(photos.length > 0) {
			for(MultipartFile photo : photos) {
				if(!(photo.isEmpty())) {
					String photoName = photo.getOriginalFilename();
					photo.transferTo(
							new File("C:\\Users\\z4961\\OneDrive\\デスクトップ\\IT&Learn\\JAVA\\springBoot2\\upload\\"+photoName));
				}
			}
		}
		
		return "main";
		
	}

}
