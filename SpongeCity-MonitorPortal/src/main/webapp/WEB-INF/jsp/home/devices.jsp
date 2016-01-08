<%--
  Created by IntelliJ IDEA.
  User: EriclLee
  Date: 16/1/8
  Time: 10:41
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

  <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
  <script src="${pageContext.request.contextPath}/js/tree.jquery.js"></script>
  <script type="text/javascript">
    $().ready(function () {
      $.ajax({
        url:"/devices/devices?areaId=1",
        type:"get",
        async:true,
        dataType:"text",
        beforeSend: function (XMLHttpRequest) {
        },
        success: function (data) {
            alert(data);
        },
        error: function (data) {
          alert("error");
          $('#content').html("Load Failed!");
        }
      });
    });

  </script>
</head>
<body>
<div></div>

</body>
</html>
