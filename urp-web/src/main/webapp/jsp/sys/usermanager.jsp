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
<title>用户管理</title>
<%@include file="/layout/script.jsp"%>
</head>
<body>
	<div id="p" class="easyui-panel serach-panel" title="查询条件" data-options="collapsible:true" style="height:80px;">   
	     <form action="" style="margin-top: 10px;" id="serachForm">
	     	<label class="serach-tag">登录名:</label>
	     	<input type="text" id="loginName" name="loginName"/>
	     	<label class="serach-tag">手机号:</label>
	     	<input type="text" id="phone" name="phone"/>
	     	<label class="serach-tag">所属部门:</label>
	     	<input type="text" id="officeId" name="officeId"/>
	     </form>
	</div>
	<div class="easyui-steep"></div>
	<div class="button-toolber">
		<shiro:hasPermission name="sys:user:query">  
	    	<button class="button white btn-serach" id="btn-serach">查询</button> 
		</shiro:hasPermission>
		<shiro:hasPermission name="sys:user:add">
			<button class="button white btn-add" id="btn-add">新增</button> 
		</shiro:hasPermission>
		<shiro:hasPermission name="sys:user:edit">
			<button class="button white btn-edit" id="btn-update">修改</button> 
		</shiro:hasPermission>
		<shiro:hasPermission name="sys:user:delete">
			<button class="button white btn-delete" id="btn-delete">删除</button> 
		</shiro:hasPermission>
	</div>
	<div class="easyui-steep"></div>
	<div>
		<table id="user_dg"></table>
	</div>
	<div id="adduserdialog"></div>
	<script type="text/javascript">
		$(function(){
			$("#user_dg").datagrid({
				width : 'auto',
				height :  $(this).height()-350,
				pagination:true,
				pageSize: 10 ,
				pageList:[5,10,15,20,50] ,
				rownumbers:true,
				border:false,
				singleSelect:true,
				striped:true,
				remoteSort:false,
				columns : [[
		            {sortable:true,field : 'id',title : 'ID',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"} ,
				    {sortable:true,field : 'userCode',title : '用户编号',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"} ,
				    {sortable:true,field : 'userName',title : '登陆账号',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"} ,
				    {sortable:true,field : 'password',title : '密码',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"} ,
				    {sortable:true,field : 'name',title : '姓名', width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'phone',title : '联系电话',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'email',title : '邮箱',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'salt',title : '用户私盐',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'locked',title : '是否禁用',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'departMent',title : '所属部门',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'birthday',title : '出生日期',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'address',title : '家庭住址',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'createDate',title : '创建日期日期',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'remark',title : '备注',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"}
	            ]] 
			});
			$('#btn-serach').click(function(){
				var obj = serializeForm($('#serachForm'));
				$("#user_dg").datagrid({
					url:'user/userAction!queryUserList.action',
					queryParams:obj
				});
			});
			$("#btn-add").click(function(){
				$('#adduserdialog').dialog({    
				    title: '新增员工',    
				    width: 400,    
				    height: 200,    
				    closed: false,    
				    href: 'jsp/sys/adduser.jsp',    
				    modal: true,
				    buttons:[{
				    	text:"保存",
				    	handler:function(){
				    		
				    	}
				    },{
				    	text:"取消",
				    	handler:function(){
				    		
				    	}
				    }]
				}); 
			});
		});
	</script>
</body>
</html>