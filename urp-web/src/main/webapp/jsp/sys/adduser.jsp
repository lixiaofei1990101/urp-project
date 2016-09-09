<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"" http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>新增用户</title>
<%@include file="/layout/script.jsp"%>
</head>
<body>
	<!-- <form id="alipaysubmit" name="alipaysubmit" action="https://mapi.alipay.com/gateway.do?_input_charset=utf-8" method="post">
		<input type="hidden" name="sign"value="74834106c5c355dfc882e3afc678d366" />
		<input type="hidden" name="body" value="这是一条测试的广告信息" />
		<input type="hidden" name="trade_no" value="579" />
		<input type="hidden" name="_input_charset" value="utf-8" />
		<input type="hidden" name="subject" value="dota2影魔的至宝皮肤" />
		<input type="hidden" name="total_fee" value="0.01" />
		<input type="hidden" name="sign_type" value="MD5" />
		<input type="hidden" name="service" value="create_direct_pay_by_user" />
		<input type="hidden" name="notify_url" value="http://lixiaofei1990101.imwork.net/urp-web/zfb/alipayAction!logicHandler.action" />
		<input type="hidden" name="partner" value="2088911832183109" />
		<input type="hidden" name="seller_email" value="2881115558@qq.com" />
		<input type="hidden" name="out_trade_no" value="20160806001" />
		<input type="hidden" name="payment_type" value="1" />
		<input type="hidden" name="return_url" value="http://lixiaofei1990101.imwork.net/urp-web/zfb/alipayAction!skipPage.action" />
		<input type="submit" value="确认" style="display: none;">
	</form>
	<script>document.forms['alipaysubmit'].submit();</script> -->
</body>
</html>