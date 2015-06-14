<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../tag_var.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alarm System -- Structure </title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
<link rel="stylesheet" type="text/css" href="${path}/js/Flat-UI-master/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${path}/js/Flat-UI-master/bootstrap/css/site.css"/>
<link rel="stylesheet" type="text/css" href="${path}/js/Cikonss-master/cikonss.css" />

<link rel="stylesheet" type="text/css" href="${path}/css/head.css" />
  <script>
    var _hmt = _hmt || [];
  </script>

</head>
<body style="height:110%;">
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm" href="${path}/jsp/index.jsp">Alarm System Index</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li>
            
            <a href="${path}/jsp/index.jsp">
            <span class="icon icon-mid">
			<span class="icon-home"></span>
			</span>
           	 首页
            </a>
            </li>
            <li class="dropdown">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">Department<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li class="">
                  <a href="javascript:void(0);" target="_blank">起步</a>
                </li>
                <li class="">
                  <a href="javascript:void(0);" target="_blank">脚手架</a>
                </li>
                <li class="">
                  <a href="javascript:void(0);" target="_blank">基本CSS样式</a>
                </li>
                <li class="">
                  <a href="javascript:void(0);" target="_blank">组件</a>
                </li>
                <li class="">
                  <a href="javascript:void(0);" target="_blank">JavaScript插件</a>
                </li>
                <li class="">
                  <a href="javascript:void(0);" target="_blank">定制</a>
                </li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">User<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="javascript:void(0);" target="_blank">起步</a>
                </li>
                <li>
                  <a href="javascript:void(0);" target="_blank">CSS</a>
                </li>
                <li>
                  <a href="javascript:void(0);" target="_blank">组件</a>
                </li>
                <li>
                  <a href="javascript:void(0);" target="_blank">JavaScript插件</a>
                </li>
                <li>
                  <a href="javascript:void(0);" target="_blank">定制</a>
                </li>
              </ul>
            </li>
            <li><a href="javascript:void(0);" target="_blank">Role</a></li>
            <li><a href="javascript:void(0);" target="_blank">Function</a></li>
            <li><a href="javascript:void(0);" target="_blank">Menu</a></li>
            <li><a href="javascript:void(0);">About</a></li>
          </ul>
        </div>
      </div>
    </div>         

<div style="margin: 50px 0 0 0">
	<form id="uploadForm" action="/alarm/rest/http/htmlGetMethod?v=sun" enctype="" target="">
	    <input type="text" id="elem" name="elem" value="find"/>
		<input type="file" id="firstFile" name="firstFile"/>
		<input type="submit" value="Submit" onclick="upload()"/>
	</form>
	<input type="button" id="testAjaxHttp" value="clickMe"/>
</div>
<iframe id="uploadAndDownFrame" name="uploadAndDownFrame" style="display: none;"></iframe>	
</body>

<script type="text/javascript" src="${path}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${path}/js/Flat-UI-master/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/Flat-UI-master/js/jquery_002.js"></script><!-- stickUp -->

<script type="text/javascript" src="${path}/js/Flat-UI-master/js/jquery_002.js"></script>

<script>
      $(document).ready(function(){
          
        //$("img.lazy").unveil();

        $.scrollUp({
              scrollName: 'scrollUp', // Element ID
              topDistance: '300', // Distance from top before showing element (px)
              topSpeed: 300, // Speed back to top (ms)
              animation: 'fade', // Fade, slide, none
              animationInSpeed: 200, // Animation in speed (ms)
              animationOutSpeed: 200, // Animation out speed (ms)
              scrollText: '', // Text for element
              activeOverlay: false  // Set CSS color to display scrollUp active point, e.g '#00FFFF'
        });
        
        $("#testAjaxHttp").click(function(){
        	var url = '/alarm/rest/http/ajaxPostMethod',
        	queryString = 'v=7854';
	        	url += '?' + queryString;
	        	$.ajax({
	        		url : url,
	        		type : 'post',
	        		data : {a:1,b:3},
	        		success : function(data, textStatus, jqXHR){
	        			alert("status:" + textStatus + ", jqXHR:" + jqXHR);
	        		},
	        		error : function(jqXHR, textStatus, errorThrown){
	        			alert("jqXHR:" + jqXHR + ", status:" + textStatus);
	        		}
	        	});
        });
      });

function upload(){
	//var url = "${path}/rest/http/submitForm?d=" + (new Date()).getTime();
	//var url = "/alarm/rest/http/htmlPostMethod?v=sun&d=" + (new Date()).getTime();
	var url = "/alarm/rest/uploadAndDown/upload";
	$("#uploadForm").attr("target", "uploadAndDownFrame");
	$("#uploadForm").attr("enctype","multipart/form-data");	
	$("#uploadForm").attr("action", url);
	$("#uploadForm").attr("method", "post");
	$("#uploadForm").submit();
}
function uploadCallback(re){
	alert(re);
}
</script>
