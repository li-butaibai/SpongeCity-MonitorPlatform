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
    $('#dialogDiv').html("")
  }
</script>
<div id="windows-overlay" class="window-overlay">
  <div id="modal" class="modal"
       style="width: 800px; height: 800px; margin-left:-400px; margin-top: -400px; top:50%; left:50%; z-index: 1000; display: block ">
    <div class="modal-header" style="cursor: move;"><h4>设备详情<a href="javascript:void(0);" onclick="closeDialog()" class="close"><span
            class="icon-close icon-Large">X</span></a></h4></div>
    <div class="modal-content" id="">
      <div>
        <img src="/picture/c1.jpg">
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
      <div class="table_wrap">
        <h>运行日志(最近10条)</h>
        <table class="table table-bordered" style="border-radius:5px">
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
    <div class="modal-footer"></div>
  </div>
</div>

