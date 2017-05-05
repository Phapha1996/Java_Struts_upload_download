<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Struts上传测试</title>
	<meta http-equiv="content-type" content="text/html;charset='utf-8'"/>
  </head>
  <body>
  	
		<form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
			<table border="1" align="center">
				<tr>
					<td>上传文件的标题：</td><td><input type="text" name="title"/></td>
				</tr>
				<tr>
					<td>上传文件：</td><td><input type="file" name="file"/></td>
				</tr>	
				<tr><th colspan="2"><input type="submit" value="确认上传"/></th></tr>		
			</table>
		</form>
		<!-- 下载图片 -->
		<a href="download">下载</a>
		<!-- 直接显示图片 -->
		<!-- <img src="download"> -->
  </body>
</html>
