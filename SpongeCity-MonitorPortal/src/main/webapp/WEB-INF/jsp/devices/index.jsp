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
</script>
<div style="height:0px; overflow:hidden;">&nbsp;</div>
<div class="table_wrap">
  <table class="table table-bordered" style="border-radius:5px">
    <tr style=" background:#f9f9f9">
      <td style="border-radius:5px">设备编号</td>
      <td>设备类型</td>
      <td>设备状态</td>
      <td>区域</td>
      <td>地块</td>
      <td>单项措施</td>
      <td>描述</td>
    </tr>
    <c:forEach items="${devices.data}" var="de">
      <tr>
        <td>${de.device_id}</td>
        <td>${de.deviceType.name}</td>
        <td>${de.state}</td>
        <td>${de.areaName}</td>
        <td>${de.blockName}</td>
        <td>${de.measureName}</td>
        <td>${de.comments}</td>
      </tr>
    </c:forEach>

  </table>
  <nav>
    <ul class="pagination">
      <c:if test="${devices.currentPageIndex==0}">
        <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
      </c:if>
      <c:if test="${devices.currentPageIndex>0}">
        <li ><a href="javascript:void(0);" onclick="onpageclick('0')" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
      </c:if>
      <c:forEach var="i" begin="0" end="${devices.pageCount-1}">
        <c:if test="${devices.currentPageIndex==i}">
          <li class="active"><a href="javascript:void(0);" onclick="onpageclick('${i}')">${i+1} <span class="sr-only">(current)</span></a></li>
        </c:if>
        <c:if test="${devices.currentPageIndex!=i}">
          <li><a href="javascript:void(0);" onclick="onpageclick('${i}')">${i+1}</a></li>
        </c:if>

      </c:forEach>
      <c:if test="${devices.currentPageIndex==devices.pageCount-1}">
        <li class="disabled">
          <a href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
      </c:if>
      <c:if test="${devices.currentPageIndex<devices.pageCount-1}">
        <li>
          <a href="javascript:void(0);" onclick="onpageclick('${devices.pageCount-1}')" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
      </c:if>
    </ul>
  </nav>
</div>