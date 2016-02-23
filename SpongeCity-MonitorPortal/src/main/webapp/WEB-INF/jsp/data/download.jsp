<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EriclLee
  Date: 15/12/29
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<script type="text/javascript">
    function ondownloadclick(areaId, datatypeId) {
        var filename = "";
        $.ajax({
            url: "/data/exportdata?areaId=" + areaId + "&dataTypeId=" + datatypeId,
            type: "get",
            async: false,
            dataType: "text",
            success: function (data) {
                filename = data;
            },
            error: function (data) {
                alert("文件下载失败！");
            }
        });
        //var filePath = window.location.host + "/" + filename;
        var filePath = "/" + filename;
        downloadFile(filePath);
    }

    function downloadFile(filePath){
        var aLink = document.createElement('a');
        aLink.href = filePath;
        aLink.target = "_self";
        aLink.click();
    }
</script>
<div class="table_wrap">
    <table class="table table-bordered" style="border-radius:5px">
        <tr style=" background:#f9f9f9">
            <td style="border-radius:5px">数据类型</td>
            <td>设备数量</td>
            <td>数据数量</td>
            <td>下载</td>
        </tr>
        <c:forEach items="${data}" var="da">
            <tr>
                <td>${da.dataType}</td>
                <td>${da.deviceCount}</td>
                <td>${da.dataItemCount}</td>
                <td><a href="javascript:void(0);" onclick="ondownloadclick('${da.areaId}','${da.dataTypeId}')">下载</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
