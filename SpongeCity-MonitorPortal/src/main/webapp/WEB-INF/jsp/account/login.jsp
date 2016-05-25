<%--
  Created by IntelliJ IDEA.
  User: EriclLee
  Date: 15/12/29
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>海绵城市数据监控平台</title>
  <link rel="shortcut icon" href="/picture/favicon.ico">
  <link rel="stylesheet" href="/css/cssreset-min.css">
  <link rel="stylesheet" href="/css/login.css">
  <style type="text/css">
    .header{ width:1200px; height:100px; margin:0 auto}
    .header .logo{ margin-top:30px; margin-left:50px; padding-right:20px; border-right:1px solid #666; display:block; float:left}
    .header .headtitle{ line-height:100px; font-size:20px; color:#666; float:left; padding-left:20px; font-weight:bold}
    .bodycolor{ background:#f5f5f5;}
    .conbody {width:1200px; height:500px; margin:0 auto;}
    .js_slider{ margin:40px; width:600px; height:400px; float:left}
    .login_form{ height:350px; width:340px; background:#fff; margin-left:50px; float:left; margin-top:40px; color:#676767}
    .login_form h3{ font-size:16px; text-align:center; line-height:300%; border-bottom:1px solid #dce0e3; background:#fcfcfc}
    .formdiv{ width:80%; margin:30px auto; font-size:14px}
    .formdiv input,.formdiv label{ display:block; font-weight:bold}
    .formdiv label{ line-height:250%; margin-top:10px;}
    .formdiv input{text-indent:10px}
    .formdiv .user, .formdiv .password{ border:1px solid #dce0e3; width:100%; height:38px; line-height:38px;}
    .formdiv .submitbutton{ width:100%; height:40px; line-height:40px; background:#18cdc4; margin-top:30px; border:0; color:#fff; display:block}

  </style>
</head>

<body>
<div class="con">
  <div class="header">
    <img src="/img/logo.jpg" class="logo">
    <h1 class="headtitle">海绵城市监控平台</h1>
  </div>
</div>
<div class="con bodycolor">
  <div class="conbody">
    <div style="height:0px; overflow:hidden;">&nbsp;</div>
    <div class="js_slider">
      <img src="/img/js_slider.jpg">
    </div>
    <div class="login_form">
      <h3>登 录</h3>
      <form class="formdiv" action="/login" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <label>用户：</label>
        <input type="text" name="username" placeholder="UserName" class="user">
        <label>密码：</label>
        <input type="password" name="password" placeholder="Password" class="password">
        <input type="submit" value="登录" class="submitbutton" value="Login"/>
      </form>
    </div>
  </div>
</div>
</body>
</html>
