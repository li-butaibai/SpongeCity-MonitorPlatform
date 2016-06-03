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
<script type="text/javascript">
  function onpageclick(pageIndex)
  {
    console.log("sethash");
    var hashObject = GetHash();
    hashObject["pageIndex"] = pageIndex;
    var hashurl = "";
    for( var key in hashObject ){
      hashurl += key + "=" + hashObject[key]+"&";
    }
    location.hash = hashurl.slice(0,-1);
  }
  function openDeviceDetail(deviceId){
    $.ajax({
      url:"/devices/detail?deviceId="+deviceId,
      type:"get",
      async:true,
      dataType:"text",
      beforeSend: function (XMLHttpRequest) {
        //$("#waiting").show();
      },
      success: function (data) {
        //$("#waiting").hide();
        $('#dialogDiv').html(data);
        $('#dialogDiv').dialog({ autoOpen: true, modal: true, width: "auto", show: "drop", hide: "drop", position: [295, 40] });
      },
      error: function (data) {
        //$("#waiting").hide();
        rtn = false;
      }
    });
  }
</script>
<div id="dialogDiv"></div>
<div style="height:0px; overflow:hidden;">&nbsp;</div>
<div class="table_wrap">
  <table class="table table-bordered devicelist" style="border-radius:5px">
    <tr style=" background:#f9f9f9">
      <%--<td >设备编号</td>--%>
      <td style="border-radius:5px">设备类型</td>
      <td>设备状态</td>
      <td>区域</td>
      <td>地块</td>
      <td>单项措施</td>
      <td>描述</td>
    </tr>
    <c:forEach items="${devices.data}" var="de">
      <tr>
        <%--<td>${de.id}</td>--%>
        <td><a href="javascript:void(0);" onclick="openDeviceDetail('${de.id}')">${de.deviceType.name}</a></td>
        <td>${de.state=="Online"?"在线":"离线"}</td>
        <td>${de.areaName}</td>
        <td>${de.blockName}</td>
        <td>${de.measureName}</td>
        <td>${de.comments}</td>
      </tr>
    </c:forEach>
  </table>
  <nav>
    <ul class="pagination">
      <c:if test="${alerts.pageCount>0}">
        <c:if test="${alerts.currentPageIndex==0}">
          <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
        </c:if>
        <c:if test="${alerts.currentPageIndex>0}">
          <li ><a href="javascript:void(0);" onclick="onpageclick('0')" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
        </c:if>
        <c:forEach var="i" begin="0" end="${alerts.pageCount-1}">
          <c:if test="${alerts.currentPageIndex==i}">
            <li class="active"><a href="javascript:void(0);" onclick="onpageclick('${i}')">${i+1} <span class="sr-only">(current)</span></a></li>
          </c:if>
          <c:if test="${alerts.currentPageIndex!=i}">
            <li><a href="javascript:void(0);" onclick="onpageclick('${i}')">${i+1}</a></li>
          </c:if>

        </c:forEach>
        <c:if test="${alerts.currentPageIndex==alerts.pageCount-1}">
          <li class="disabled">
            <a href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </c:if>
        <c:if test="${alerts.currentPageIndex<alerts.pageCount-1}">
          <li>
            <a href="javascript:void(0);" onclick="onpageclick('${alerts.pageCount-1}')" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </c:if>
      </c:if>
    </ul>
  </nav>
</div>