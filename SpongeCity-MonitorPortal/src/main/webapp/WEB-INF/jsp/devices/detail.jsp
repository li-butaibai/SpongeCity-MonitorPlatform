<%--
  Created by IntelliJ IDEA.
  User: EriclLee
  Date: 15/12/29
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<script>
  function closeDialog(){
    $('#dialogDiv').html("")
  }
</script>
<div class="dialogbg"></div>
<div id="windows-overlay" class="window-overlay">
  <div class="d_up" style="height: 166px;">
    <div class="d_img" style="height: 166px;">
      <img style="height: 166px;" src="/picture/d${device.deviceType.id}.jpg" >
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
  <h3 class="d_middle">设备数据(最近100条数据)</h3>
  <div class="table_wrap d_down" style="height: 200px; overflow: auto">
    <table class="table table-bordered" style="border-radius:5px; height: 200px; overflow: auto">
      <tr style=" background:#f9f9f9">
        <td>数据时间</td>
        <td>数据类型</td>
        <td>数据值</td>
        <td>数据单位</td>
      </tr>
      <c:forEach items="${device.dataList}" var="log">
        <tr>
          <%--<td><fmt:formatDate value="${log.datatime}" pattern="MM月dd日HH点mm分ss秒" /></td>--%>
          <td>${log.datatime}</td>
          <td>${log.datatype}</td>
          <td>${log.datavalue}</td>
          <td>${log.unit}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>

