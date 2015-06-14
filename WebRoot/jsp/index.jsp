<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%@ include file="tag_var.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%--<c:set var="path" value="${pageContext.request.contextPath}"></c:set>--%>
    <title>Alarm System Index</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link rel="stylesheet" type="text/css" href="${path}/js/Metro-ui/modern.css">
	<%--
	--%>
	<link rel="stylesheet" type="text/css" href="${path}/js/Flat-UI-master/bootstrap/css/bootstrap.css">
	<%--<link rel="stylesheet" type="text/css" href="${path}/js/bootstrap-switch-master/docs/bootstrap-switch.css">
	--%>
	<%-- 
	<link rel="stylesheet" type="text/css" href="${path}/js/Flat-UI-master/css/flat-ui.css">
	 --%>
	
	<link rel="stylesheet" type="text/css" href="${path}/css/index.css">
	

  </head>
  
  <body class="bodyClass">
  	<div class="outterContain" align="center">
  	<!-- head begin  -->
  	<div class="headDiv">
  		<div class="loginUser">
  			<span>Welcome £º${pageContext.request.remoteUser } </span>
  		</div>
		<div class="span3 logoutBotton">
          <a href="javascript:alarmLogin.logout();" class="btn btn-block btn-warning">Logout</a>
        </div>
        <div class="clear"></div>
        <div>
        	<h1 class="pageTitle">Alarm System</h1>
        </div>
  	</div>
  	<!-- head end  -->
  	
  	<!-- main begin  -->
  	<div class="mainContain" align="center">
  		<div id="word_icon" class="tile outline-color-blue">Office - Word</div>
  		<div id="structure_icon" class="tile double bg-color-green outline-color-yellow">STRUCTURE</div>
  		<div id="spring_transaction" class="tile outline-color-blue">3</div>
  		<div class="tile double bg-color-purple outline-color-yellow">4</div>
  		<div class="tile double bg-color-yellow outline-color-green">5</div>
  		<div class="tile bg-color-orangeDark outline-color-white">6</div>
  		<div class="tile double bg-color-greenDark outline-color-yellow">7</div>
  		<div class="tile bg-color-pink outline-color-white">8</div>
  		<div class="tile outline-color-blue">9</div>
  		<div class="tile double bg-color-pinkDark outline-color-white">10</div>
  		<div class="tile double bg-color-blueDark outline-color-yellow">11</div>
  		<div class="tile outline-color-blue">12</div>
  	</div>
  	<!-- main end  -->
  	<div class="clear"></div>
  	<!-- foot begin -->
  	<div>
  	<hr class="cherry"/>
	<p>session time:<%=session.getMaxInactiveInterval() %> seconds.</p>
  	</div>
  	<!-- foot end -->
  	
  	</div>
<script type="text/javascript" src="${path}/js/jquery-1.8.3.min.js"></script>  	
<%--
<script type="text/javascript" src="${path}/js/Flat-UI-master/js/bootstrap.min.js"></script>  	
<script type="text/javascript" src="${path}/js/Flat-UI-master/js/bootstrap-switch.js"></script>
--%>
<script type="text/javascript" src="${path}/js/jsp/index.js"></script>
<script type="text/javascript" src="${path}/js/page/login.js"></script>
<script type="text/javascript">
var alarmLogin = new AlarmLogin();

</script>
  </body>
</html>
