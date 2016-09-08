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
 * 2016年7月14日    Li Xiao Fei         Create the class
 */

package com.lixf.urp.sys.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @FileName CaptchaUsernamePasswordToken.java
 * @Description:自定义登陆令牌
 *
 * @Date 2016年7月14日
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {
	
	private static final long serialVersionUID = 1L;
	private String captcha;

	public CaptchaUsernamePasswordToken(String username, char[] password, String host, String captcha) {
		super(username, password, host);
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}
