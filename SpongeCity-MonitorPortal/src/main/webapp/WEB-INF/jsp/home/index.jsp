<%--
  Created by IntelliJ IDEA.
  User: EriclLee
  Date: 15/12/29
  Time: 22:14
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cssreset-min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jqtree.css">

  <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
  <script src="${pageContext.request.contextPath}/js/tree.jquery.js"></script>
</head>

<body>
<div class="con">
  <div class="conleft">

  </div>
  <div class="conright">
    <div class="r_con1">
      <img src="img/logo.jpg">
    </div>
    <div class="r_con2">
      <ul class="r_nav">
        <li class="nav_btn1 active">首页</li>
        <li class="nav_btn2">设备</li>
        <li class="nav_btn3">告警</li>
        <li class="nav_btn4">数据下载</li>
      </ul>
    </div>
    <div class="r_con3">

    </div>
  </div>
</div>
</body>
</html>
<script>
  $(function(){
    $(".conleft").load('/menu/areamenu');
    $(".r_con3").load("/devices/index?sortKey=0&sortDes=0");
    window.onhashchange = function(){
      var hash = location.hash;
      console.log(hash);

    };
    $(document).on("click","#tree1 li:eq(0)",function(){
      location.hash = "part5";
      location.hash = "part7";
      console.log(location.hash);
    })
  })
</script>