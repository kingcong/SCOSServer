<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<script language="JavaScript">
	
	function getData(){
		var theForm;
		theForm = document.foodform;
		theForm.submit();
	}
	
function checkit(){
    var theForm;
    theForm=document.userform;


 if(theForm.username.value==""){
    alert("用户名不能为空!");
    theForm.username.focus();
    return false;
    }

    if(theForm.pwd.value==""){
    alert("密码不能为空!");
    theForm.pwd.focus();
    return false;
    }
 
    theForm.submit();
}
</script>

	<body style="text-align: center;">
		<p>默认用户名是:wangcong,密码是：123456。验证正确返回1，验证错误返回0</p><br/>
		<form name="userform" method="post"
			action="<%=request.getContextPath()%>/LoginValidator">
			POST方式
			<div>
				用户名&nbsp;&nbsp;
				<input type="text" name="userName" />
			</div>
			<div style="margin-top: 10px;">
				&nbsp;&nbsp;密码&nbsp;&nbsp;
				<input type="password" name="password" />
			</div>
			<div style="margin-top: 10px;">
				<input type="submit" value="登陆" onclick="checkit()" />
			</div>

		</form>



		<form name="userform" method="get"
			action="<%=request.getContextPath()%>/LoginValidator">
			GET方式
			<div>
				用户名&nbsp;&nbsp;
				<input type="text" name="userName" />
			</div>
			<div style="margin-top: 10px;">
				&nbsp;&nbsp;密码&nbsp;&nbsp;
				<input type="password" name="password" />
			</div>
			<div style="margin-top: 10px;">
				<input type="submit" value="登陆" onclick="checkit()" />
			</div>

		</form>
		
		<br/><br/>
		<form name="foodform" method="get" action="<%=request.getContextPath()%>/FoodUpdateService">
			Json方式获取用户数据
			<div>
				<input type="submit" value="json获取数据" onclick="getData()">
			</div>
		</form>
		
		<br/>
		<form name="foodform" method="get" action="<%=request.getContextPath()%>/FoodUpdateService">
			XML方式获取用户数据
			<div>
				<input type="hidden" name="type" value="xml">
			</div>
			<div>
				<input type="submit" value="xml获取数据" onclick="getData()">
			</div>
		</form>
		
	</body>
</html>
