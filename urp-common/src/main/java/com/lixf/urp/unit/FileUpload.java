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

package com.lixf.urp.unit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @FileName FileUpload.java
 * @Description:文件上传工具类
 *
 * @Date 2016年7月1日
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class FileUpload {
	public static boolean upload(File file, String absolutePath, String fileName) {
		try {
			if (file != null) {
				InputStream is = new FileInputStream(file);
				File dir = new File(absolutePath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				File destFile = new File(absolutePath, fileName);
				OutputStream os = new FileOutputStream(destFile);
				byte[] buffer = new byte[400];
				int length = 0;
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}
				is.close();
				os.close();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
