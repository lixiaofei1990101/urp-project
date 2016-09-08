<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>财务测试</title>
</head>
<body>
	<form action="${path }/alipay/payAction.action" method="post">
		<table style="margin: 20px;">
			<tr>
				<td>支付方式:</td>
				<td><input type="radio" name="paytype" id="zfb"
					style="margin-bottom: 8px;" checked="checked" value="0" /></td>
				<td><img src="../../images/zfb.png" width="40px;"
					height="30px;"></td>
				<td><input type="radio" name="paytype" id="wx"
					style="margin-bottom: 8px;" value="1" /></td>
				<td><img src="../../images/wx.png" width="40px;" height="30px;"></td>
			</tr>
			<tr>
				<td>充值金额:</td>
				<td colspan="4"><input type="text" id="payfee" name="payfee" />
				</td>
			</tr>
			<tr>
				<td colspan="5" align="center"><input type="submit" id="pay"
					value="立即支付" style="margin-top: 15px;" /></td>
				
				<td><a href="${path }/wx/wxPayAction.action?paytype=1&payfee=1">微信支付测试</a></td>
			</tr>
		</table>
	</form>
</body>
</html>