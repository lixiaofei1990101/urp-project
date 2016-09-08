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
 * 2016年7月13日    Li Xiao Fei         Create the class
 */

package com.lixf.urp.sys.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * @FileName LoginFormFilter.java
 * @Description:登陆表单过滤器
 *
 * @Date 2016年7月13日
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class LoginFormFilter extends FormAuthenticationFilter {

	public static final String DEFAULT_CAPTCHA_PARAM = "validateCode";
	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		String captcha = getCaptcha(request);
		String host = getHost(request);
		return new CaptchaUsernamePasswordToken(username, password.toCharArray(), host, captcha);
	}

	public String getCaptchaParam() {
		return captchaParam;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		AuthenticationToken token = createToken(request, response);
		if (token == null) {
			throw new IllegalStateException("登陆令牌为空");
		}
		try {
			Subject subject = getSubject(request, response);
			subject.login(token);
			return onLoginSuccess(token, subject, request, response);
		} catch (AuthenticationException e) {
			return onLoginFailure(token, e, request, response);
		}
	}
}
