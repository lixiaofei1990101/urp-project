/*
 * COPYRIGHT. ShenZhen MinSiDa Technology Co., Ltd. 2016.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen MinSiDa Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2016年7月1日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.action.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.alibaba.fastjson.JSONObject;
import com.lixf.urp.common.Constants;
import com.lixf.urp.unit.FileUpload;

/**
 * @FileName FileUuploadAction.java
 * @Description: 文件上传action
 *
 * @Date 2016年7月1日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class FileUuploadAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	/**
	 * @Title: uploadFiles 
	 * @Description:上传文件方法,支持自定义保存目录
	 * @param request
	 * @param response
	 * @param pathFlag pathFlag pathFlag 是不需要全路径(1=需要，0=不需要,建议使用0）
	 * （全路径格式为http://xxxx.xxx.xxx:8080/upload/xxxx.jpg)
	 * @param youPath youPath 自定义保存目录
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年1月22日
	 */
	public List<String> uploadFiles(HttpServletRequest request,
			HttpServletResponse response, Integer pathFlag , String youPath) {
		String UPLOAD_FILE_ALLOW_TYPES = Constants.UPLOAD_FILE_ALLOW_TYPES;
		// path
		String UPLOAD_PATH = "";
		if(youPath!=null && !youPath.trim().equals("")){
			if(youPath.startsWith("/") || youPath.startsWith("\\")){
				youPath = youPath.substring(1,youPath.length());
			}
			if(youPath.startsWith("\\")){
				youPath = youPath.substring(1,youPath.length());
			}
			
			UPLOAD_PATH = Constants.UPLOAD_PATH + "/" + youPath;
		}else{
			UPLOAD_PATH = Constants.UPLOAD_PATH;
		}
		//访问路径
		String UPLOAD_FILE_ACCESS_PATH = Constants.UPLOAD_FILE_ACCESS_PATH;
		// 上传文件最大限制
		int UPLOAD_FILE_MAX_SIZE = Integer.valueOf(Constants.UPLOAD_FILE_MAX_SIZE);
		return this.doUpload(request, response, UPLOAD_PATH,
				UPLOAD_FILE_ALLOW_TYPES, UPLOAD_FILE_MAX_SIZE,
				UPLOAD_FILE_ACCESS_PATH, pathFlag);
	}
	/**
	 * @Title: uploadFiles 
	 * @Description:上传文件方法
	 * @param request
	 * @param response
	 * @param pathFlag pathFlag 是不需要全路径(1=需要，0=不需要）
	 * （全路径格式为http://xxxx.xxx.xxx:8080/upload/xxxx.jpg)
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年1月22日
	 */
	public List<String> uploadFiles(HttpServletRequest request,
			HttpServletResponse response, Integer pathFlag) {

		String UPLOAD_FILE_ALLOW_TYPES = Constants.UPLOAD_FILE_ALLOW_TYPES;
		// path
		String UPLOAD_PATH = Constants.UPLOAD_PATH;
		//访问路径
		String UPLOAD_FILE_ACCESS_PATH = Constants.UPLOAD_FILE_ACCESS_PATH;
		// 上传文件最大限制
		int UPLOAD_FILE_MAX_SIZE = Integer.valueOf(Constants.UPLOAD_FILE_MAX_SIZE);
		
		return this.doUpload(request, response, UPLOAD_PATH,
				UPLOAD_FILE_ALLOW_TYPES, UPLOAD_FILE_MAX_SIZE,
				UPLOAD_FILE_ACCESS_PATH, pathFlag);

	}
	public List<String> uploadImages(HttpServletRequest request,
			HttpServletResponse response, Integer pathFlag) {
		//允许上传格式
		String UPLOAD_IMG_ALLOW_TYPES = Constants.UPLOAD_IMG_ALLOW_TYPES;
		// path
		String UPLOAD_IMG_PATH = Constants.UPLOAD_IMG_PATH;
		//访问路径
		String UPLOAD_FILE_ACCESS_PATH = Constants.UPLOAD_FILE_ACCESS_PATH;
		// 上传文件最大限制
		int UPLOAD_IMG_MAX_SIZE = Integer.valueOf(Constants.UPLOAD_IMG_MAX_SIZE);
		return this.doUpload(request, response, UPLOAD_IMG_PATH,
				UPLOAD_IMG_ALLOW_TYPES, UPLOAD_IMG_MAX_SIZE,
				UPLOAD_FILE_ACCESS_PATH, pathFlag);

	}
	public List<String> uploadImages(HttpServletRequest request,
			HttpServletResponse response, Integer pathFlag , String youPath) {
		//允许上传格式
		String UPLOAD_IMG_ALLOW_TYPES = Constants.UPLOAD_IMG_ALLOW_TYPES;
		// path
		String UPLOAD_IMG_PATH = Constants.UPLOAD_IMG_PATH;
		// path
		if(youPath!=null && !youPath.trim().equals("")){
			if(youPath.startsWith("/") || youPath.startsWith("\\")){
				youPath = youPath.substring(1,youPath.length());
			}
			if(youPath.startsWith("\\")){
				youPath = youPath.substring(1,youPath.length());
			}
			
			UPLOAD_IMG_PATH = Constants.UPLOAD_PATH +  "/" + youPath;
		}else{
			UPLOAD_IMG_PATH = Constants.UPLOAD_PATH;
		}
		//访问路径
		String UPLOAD_FILE_ACCESS_PATH = Constants.UPLOAD_FILE_ACCESS_PATH;
		// 上传文件最大限制
		int UPLOAD_IMG_MAX_SIZE = Integer.valueOf(Constants.UPLOAD_IMG_MAX_SIZE);
		return this.doUpload(request, response, UPLOAD_IMG_PATH,
				UPLOAD_IMG_ALLOW_TYPES, UPLOAD_IMG_MAX_SIZE,
				UPLOAD_FILE_ACCESS_PATH, pathFlag);
	}
	/**
	 * @Title: doUpload 
	 * @Description: 上传图片方法
	 * @param request
	 * @param response
	  * @param UPLOAD_PATH 文件上传路径
	 * @param UPLOAD_ALLOW_TYPES 允许上传格式
	 * @param UPLOAD_FILE_MAX_SIZE 上传文件大小
	 * @param UPLOAD_FILE_ACCESS_PATH 访问路径
	 * @param pathFlag
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年1月22日
	 */
	private List<String> doUpload(HttpServletRequest request,
			HttpServletResponse response, String UPLOAD_PATH,
			String UPLOAD_ALLOW_TYPES, int UPLOAD_FILE_MAX_SIZE,
			String UPLOAD_FILE_ACCESS_PATH, Integer pathFlag) {
		MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) request;
		List<String> uploadSuccessList = new ArrayList<String>();

		File dir = new File(UPLOAD_PATH);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		if(pathFlag==null){
			pathFlag = 0;
		}
		File[] files = wrapper.getFiles("imgFile");
		for (int i = 0; i < files.length; i++) {
			// 获得上传的文件名
			String fileName = wrapper.getFileNames("imgFile")[i];// imgFile
			// 获得文件过滤器
			File file = files[i];
			// 检查扩展名
			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
					.toLowerCase();
			if (!UPLOAD_ALLOW_TYPES.contains(fileExt)) {
				this.makeErrorJson(1, "上传文件扩展名是不允许的扩展名。\n只允许"
						+ UPLOAD_ALLOW_TYPES + "格式。");
				return null;
			}
			// 检查文件大小
			if (file.length() > UPLOAD_FILE_MAX_SIZE) {
				this.makeErrorJson(1, "上传文件大小超过限制");
				return null;
			}
			// 允许上传
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String newFileName = df.format(new Date()) + "_"
					+ new Random().nextInt(1000) + "." + fileExt;
			// 保存后供下载的文件全路径
			String downloadPath = "";

			try {
				// 保存上载的临时文件
				if (!FileUpload.upload(file, UPLOAD_PATH, newFileName)) {
					throw new RuntimeException("保存图片时出错");
				}
				if(pathFlag.intValue()==1){
					downloadPath = UPLOAD_FILE_ACCESS_PATH + newFileName;
				}else{
					downloadPath =  newFileName;
				}
				uploadSuccessList.add(downloadPath);
			} catch (Exception e) {
				this.makeErrorJson(1, "上传文件失败");
				return null;
			}

		}
		return uploadSuccessList;
	}
	private void makeErrorJson(Integer status, String message) {
		JSONObject json = new JSONObject();
		json.put("error", status);
		json.put("message", message);
		this.outputJson(json.toJSONString());
	}
}
