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
<title>新增角色</title>
<%@include file="/layout/script.jsp"%>
</head>
<body>
	<form action="">
		<div>
			<label>角色名称:</label>
			<input id="roleName" name="roleName" class="easyui-validatebox" data-options="required:true"/>
		</div>
		<div>
			<label>所属机构:</label>
			<input id="roleName" name="roleName" class="easyui-validatebox" data-options="required:true"/>
		</div>
		<div>
			<label>英文名称:</label>
			<input id="roleName" name="roleName" class="easyui-validatebox" data-options="required:true"/>
		</div>
		<div>
			<label>角色类型:</label>
			<select>
				<option></option>
			</select>
		</div>
	</form>
</body>
</html>