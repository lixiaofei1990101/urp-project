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
<title>角色管理</title>
<%@include file="/layout/script.jsp"%>
</head>
<body>
	<div class="easyui-layout" style="width:100%;height:100%;">
		<div id="p" data-options="region:'west'" title="组织机构" style="width:18%;padding:10px;height:100%;">
			<ul id="officetree"></ul>
		</div>
		<div data-options="region:'center'" title="角色维护" style="width:80%;">
			<div id="p" class="easyui-panel serach-panel" title="查询条件" data-options="collapsible:true" style="height:80px;width:100%;">   
			     <form action="" style="margin-top: 10px;" id="serachForm">
			     	<label class="serach-tag">角色名:</label>
			     	<input type="text" id="roleName" name="roleName"/>
			     	<label class="serach-tag">角色类型:</label>
			     	<input type="text" id="roletype" name="roletype"/>
			     	<label class="serach-tag">启用状态:</label>
			     	<select id="available" name="available">
			     		<option value="">全部</option>
			     		<option value="1">启用</option>
			     		<option value="0">禁用</option>
			     	</select>
			     </form>
			</div>
			<div class="easyui-steep"></div>
			<div class="button-toolber">
				<shiro:hasPermission name="sys:role:query">  
			    	<button class="button white btn-serach" id="btn-serach">查询</button> 
				</shiro:hasPermission>
				<shiro:hasPermission name="sys:role:add">
					<button class="button white btn-add" id="btn-add">新增</button> 
				</shiro:hasPermission>
				<shiro:hasPermission name="sys:role:edit">
					<button class="button white btn-edit" id="btn-update">修改</button> 
				</shiro:hasPermission>
				<shiro:hasPermission name="sys:role:delete">
					<button class="button white btn-delete" id="btn-delete">删除</button> 
				</shiro:hasPermission>
				<shiro:hasPermission name="sys:role:empower">
					<button class="button white btn-empower" id="btn-empower">资源分配</button> 
				</shiro:hasPermission>
			</div>
			<div class="easyui-steep"></div>
			<div style="width:100%;">
				<table id="role_dg" style="width:100%;"></table>
			</div>
	</div>
</body>
<script type="text/javascript">
		$(function(){
			$("#officetree").tree({
				url : "office/officeAction!queryTreeOffice.action",
				lines : true,
				onClick : function(node) {
					console.info(node);
				}
			});
			$("#role_dg").datagrid({
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
		            {sortable:true,field : 'roleId',title : '编号',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"} ,
				    {sortable:true,field : 'roleName',title : '角色名称',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"} ,
				    {sortable:true,field : 'available',title : '状态',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"} ,
				    {sortable:true,field : 'belongoffice',title : '所属机构',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"} ,
				    {sortable:true,field : 'englishname',title : '英文名', width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'roletype',title : '角色类型',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'createperson',title : '创建人',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'createdate',title : '创建时间',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
				    {sortable:true,field : 'remark',title : '备注',width : parseInt($(this).width()*0.1),align : 'center',editor : "text"},
	            ]] 
			});
			$('#btn-serach').click(function(){
				var obj = serializeForm($('#serachForm'));
				$("#role_dg").datagrid({
					url:'role/roleAction!queryRoleList.action',
					queryParams:obj
				});
			});
		})
	</script>
</html>