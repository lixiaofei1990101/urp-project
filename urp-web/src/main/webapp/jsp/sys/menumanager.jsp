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
<title>资源管理</title>
<%@include file="/layout/script.jsp"%>
</head>
<body>
	<div id="tt" class="easyui-tabs" style="width: 100%; height: 100%;" >
		<div title="菜单列表" style="display: none;">
			<table id="menutreegrid" class="easyui-treegrid" style="height: 100%" data-options="
				iconCls: 'icon-ok',
				rownumbers: true,
				animate: true,
				collapsible: true,
				fitColumns: true,
				url: 'menu/menuAction!queryAllResource.action',
				method: 'get',
				idField: 'id',
				treeField: 'menuName'">
			<thead>
				<tr>
					<th data-options="field:'menuName',width:150,align:'left'">资源名称</th>
					<th data-options="field:'url',width:100">链接地址</th>
					<th data-options="field:'permission',width:80">权限标识</th>
					<th data-options="field:'order',width:30,align:'center'">排序</th>
					<th data-options="field:'createTime',width:80,align:'center'">创建时间</th>
					<th data-options="field:'icon',width:60,align:'center'">图标</th>
					<th data-options="field:'remark',width:100">备注</th>
					<th data-options="field:'opr',width:100,align:'center',formatter:formatAction" >操作</th>
				</tr>
			</thead>
			</table>
		</div>
		<div title="添加菜单"
			style="overflow: auto; padding: 20px; display: none;">
			这里放入菜单添加的表单</div>
	</div>
	<script type="text/javascript">
		function addDownMenu(){
			alert("123");
		}
		function formatAction(value,row,index){
			var spanValue = "<a href='javascript:addDownMenu()'>添加下级菜单</a>&nbsp;|&nbsp;<a href='javascript:updateMenu()'>编辑</a>&nbsp;|&nbsp;<a href='javascript:delMenu()'>删除</a>";
			return spanValue;
		}
	</script>
</body>
</html>