<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户登陆</title>
<%@include file="/layout/script.jsp"%>
</head>
<body>
	<div id="loginWin" class="easyui-window" title="用户登录" style="width:350px;height:240px;padding:5px;"
   minimizable="false" maximizable="false" resizable="false" collapsible="false" data-options="modal:true">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 5px; background: #fff; border: 1px solid #ccc;">
				<form method="post" id="loginForm" style="margin-top: 5px;margin-left: 10px;" action="login.action">
					<div>
						<table style="margin-left: 30px;">
							<tr>
								<td><label for="login">帐号:</label></td>
								<td colspan="2"><input type="text" name="username" id="username" style="width: 170px;"></input></td>
							</tr>
							<tr>
								<td><label for="password">密码:</label></td>
								<td colspan="2"><input type="password" name="password" id="password" style="width: 170px;"></input></td>
							</tr>
							<tr>
								<td><label for="validateCode">验证码:</label></td>
								<td><input type="text" name="validateCode" id="validateCode" style="width: 100px;"></input></td>
								<td>
									<img src="${path}/layout/valicode.jsp" onclick="$('#replace').click();" width="60" height="25" id="validateImg">
									<a href="javascript:" id="replace" onclick="$('#validateImg').attr('src','${path}/layout/valicode.jsp?'+new Date().getTime());" >看不清</a>
								</td>
							</tr>
						</table>
					</div>
					<div style="padding: 5px 0; text-align: center; color: red;" id="showMsg">${error }</div>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: right; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0)" onclick="login()">登录</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="cleardata()">重置</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#username").focus();
	});
	function login() {
		if($("#username").val()==""||$("#password").val()==""){
			$("#showMsg").html("用户名或密码为空，请输入");
	        $("#username").focus();
		}else{
			$("#loginForm").submit();
		}
	}
	function cleardata(){
	    $('#loginForm').form('clear');
	}
</script>
</html>
