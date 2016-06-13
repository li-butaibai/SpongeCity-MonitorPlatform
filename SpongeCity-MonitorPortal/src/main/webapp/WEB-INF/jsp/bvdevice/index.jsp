<%--
  Created by IntelliJ IDEA.
  User: etadmin
  Date: 6/1/2016
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="shortcut icon" href="/picture/favicon.ico">
  <title>海绵城市数据监控平台</title>
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
  <script src="${pageContext.request.contextPath}/js/tree.jquery.js"></script>
</head>
<body>

<div id="mainBody">

</div>
<script type="text/javascript">
  var devices=[];

  function getAllDevices()
  {
    $.ajax({
      url: "/devices/devices?areaId=16",
      type: "get",
      async: false,
      dataType: "json",
      data: { "rnd": Math.random() },
      success: function (data) {
        devices = data;
      },
      error: function (data) {
        rtn = false;
      }
    });
  }
  function getDeviceInfo(deviceId)
  {
    $.ajax({
      url: "/data/getdevicebv?deviceId="+deviceId,
      type: "get",
      async: false,
      dataType: "text",
      data: { "rnd": Math.random() },
      success: function (data) {
        $('#mainBody').html(data);
      },
      error: function (data) {
        rtn = false;
      }
    });
  }

  function getDeviceInfo2(urlPath)
  {
    $.ajax({
      url: urlPath,
      type: "get",
      async: false,
      dataType: "text",
      data: { "rnd": Math.random() },
      success: function (data) {
        $('#mainBody').html(data);
      },
      error: function (data) {
        rtn = false;
      }
    });
  }

  //while(true) {
    //getAllDevices();
  var indx = 0;
var detaliUrl = ["/data/getdevicebv?deviceId=1008",
                    "/data/getdevicebv?deviceId=1009",
                    "/data/getdevicebv?deviceId=1010",
                    "/data/getSoilTemp?deviceId=46,47,1007",
                    "/data/getFulidLevel?deviceId=43,44,45"];
function upatediv() {
  for (indx; indx < devices.length; indx++) {
    if (devices[indx].state == "online" || devices[indx].state == "Online") {
      getDeviceInfo(devices[indx].id);
      break;
    }
  }
}
  console.log(detaliUrl);
function upatediv2() {
  getDeviceInfo2(detaliUrl[indx]);
  console.log(indx);
  indx+=1;
  if (indx > detaliUrl.length) indx = 0;
}
  upatediv2();
  var devicesTimeticket =  setInterval(upatediv2, 5000)
  //}
</script>
</body>
</html>
