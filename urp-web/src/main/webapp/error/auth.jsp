<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	if(request.getSession().getAttribute("USER") != null ) {
		response.sendRedirect("${path}/index.jsp");
	}
    else {
		%>
		<script type="text/javascript">
		  parent.location.href = 'login.jsp';
		</script>
		<%
    }
%>