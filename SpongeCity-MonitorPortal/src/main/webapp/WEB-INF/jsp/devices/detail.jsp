<%--
  Created by IntelliJ IDEA.
  User: EriclLee
  Date: 15/12/29
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<script>
  function closeDialog(){
    $('#dialogDiv').css("display","none").html("")
  }
</script>
<div class="dialogbg"></div>
<div id="windows-overlay" class="window-overlay">
  <div class="d_up">
    <div class="d_img">
      <img src="/img/device1.jpg">
    </div>
    <div class="d_list">
      <h4 style="font-weight: bold; margin-bottom: 20px">设备详情</h4>
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
  <div class="table_wrap d_down" style="height: 200px; overflow: auto">
    <h>运行日志(最近10条)</h>
    <table class="table table-bordered" style="border-radius:5px; height: 200px; overflow: auto">
      <tr style=" background:#f9f9f9">
        <td style="border-radius:5px">ID</td>
        <td>记录时间</td>
        <td>日志</td>
        <td>概述</td>
      </tr>
      <c:forEach items="${device.deviceLogList}" var="log">
        <tr>
          <td>${log.id}</td>
          <td><fmt:formatDate value="${log.logTime}" pattern="yyyy年MM月dd日HH点mm分ss秒" /></td>
          <td>${log.logTitle}</td>
          <td>${log.comments}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>

