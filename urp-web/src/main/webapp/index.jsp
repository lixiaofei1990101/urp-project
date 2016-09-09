<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎登陆</title>
<%@include file="/layout/script.jsp"%>
<script type="text/javascript">
	$(function() {
		//实例化树形菜单
		$("#tree").tree({
			url : "menu/menuAction!queryUserMenu.action",
			lines : true,
			onClick : function(node) {
				Open(node.text, node.url);
			}
		});
		function Open(text, url) {
			if ($("#tabs").tabs('exists', text)) {
				$('#tabs').tabs('select', text);
			} else {
				if(url!="null"){
					console.info(url);
					$('#tabs').tabs('add', {
						title : text,
						closable : true,
						content : "<iframe src="+url+" frameborder=\"0\" style=\"border:0;width:100%;height:100%;\"></iframe>",
						tools:[{    
					        iconCls:'icon-mini-refresh',    
					        handler:function(){    
					        	var href = $('#tabs').tabs('getSelected').panel('options').href;
				        		var index = $('#tabs').tabs('getTabIndex',$('#tabs').tabs('getSelected'));
				        		$('#tabs').tabs('getTab', index).panel('refresh');
					        }    
					    }],
					});
				}
			}
		}
		//绑定tabs的右键菜单
		$("#tabs").tabs({
			onContextMenu : function(e, title) {
				e.preventDefault();
				$('#tabsMenu').menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data("tabTitle", title);
			}
		});
		//实例化menu的onClick事件
		$("#tabsMenu").menu({
			onClick : function(item) {
				CloseTab(this, item.name);
			}
		});

		//几个关闭事件的实现
		function CloseTab(menu, type) {
			var curTabTitle = $(menu).data("tabTitle");
			var tabs = $("#tabs");
			if (type === "close") {
				tabs.tabs("close", curTabTitle);
				return;
			}
			var allTabs = tabs.tabs("tabs");
			var closeTabsTitle = [];
			$.each(allTabs, function() {
				var opt = $(this).panel("options");
				if (opt.closable && opt.title != curTabTitle
						&& type === "Other") {
					closeTabsTitle.push(opt.title);
				} else if (opt.closable && type === "All") {
					closeTabsTitle.push(opt.title);
				}
			});
			for (var i = 0; i < closeTabsTitle.length; i++) {
				tabs.tabs("close", closeTabsTitle[i]);
			}
		}
	});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #B3DFDA; padding: 10px">
		<div>
			<img src="images/logo.png" class="north-top">
		</div>
		<div class="north-top-right">
			<a href="javascript:void(0);">您好！${USER.name}</a>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="test();">测试</a>&nbsp;&nbsp; <a
				href="javascript:void(0);" onclick="updateUserPassword();">修改密码</a>&nbsp;&nbsp;
			<a href="${path }/logout.action">退出</a>
		</div>
	</div>

	<div data-options="region:'west',split:true,title:'菜单导航'"
		style="width: 215px; padding: 10px;">
		<ul id="tree"></ul>
	</div>

	<div data-options="region:'center',title:'Center'" >
		<div class="easyui-tabs" fit="true" id="tabs">
			<div title="首页"></div>
		</div>
	</div>

	<div id="tabsMenu" class="easyui-menu" style="width: 120px;">
		<div name="close">关闭</div>
		<div name="Other">关闭其他</div>
		<div name="All">关闭所有</div>
	</div>

	<div data-options="region:'south',border:false"
		style="height: 50px; background: #A9FACD; padding: 10px; text-align: center;">south
		region</div>
</body>
</html>