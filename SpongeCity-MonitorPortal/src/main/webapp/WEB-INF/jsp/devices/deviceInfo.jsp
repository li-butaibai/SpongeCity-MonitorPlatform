<%--
  Created by IntelliJ IDEA.
  User: etadmin
  Date: 5/22/2016
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cssreset-min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jqtree.css">
  <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
  <script src="${pageContext.request.contextPath}/js/tree.jquery.js"></script>
  <script src="http://api.map.baidu.com/api?v=2.0&ak=Fp5YoAmGiStTkpbGVKI8dQkA"></script>
</head>
<body>
<div class="d_up">
  <div class="d_img">
    <img src="/img/device1.jpg">
  </div>
  <div class="d_list">
    <h4 style="font-weight: bold; margin-bottom: 15px; font-size: 16px">设备详情</h4>
    <a href="javascript:void(0);" onclick="closeDialog()" class="close" style="position: absolute; top: 20px; right: 20px;">X</a>
    <table>
      <tr>
        <td>设备ID:</td>
        <td>${device.device_id}</td>
      </tr>
      <tr>
        <td>设备类型:</td>
        <td>${device.deviceType.displayName}</td>
      </tr>
      <tr>
        <td>区域:</td>
        <td>${device.areaName}</td>
      </tr>
      <tr>
        <td>概述:</td>
        <td>${device.comments}</td>
      </tr>
    </table>
  </div>
</div>
</body>
</html>
