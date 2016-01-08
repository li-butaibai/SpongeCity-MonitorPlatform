<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<div id="allmap"></div>
<div>
  <c:forEach items="${areaInfo.coordinates}" var="sa">
    <span>${sa.longitude}  ${sa.latitude}</span></br>
  </c:forEach>
</div>
<script type="text/javascript">
  // 百度地图API功能
  var map = new BMap.Map("allmap");
  <c:forEach var="sa" items="${areaInfo.coordinates}" begin="1" end="1">
    var point = new BMap.Point(${sa.longitude}, ${sa.latitude});
  </c:forEach>

  map.centerAndZoom(point, 18);

  var marker = new BMap.Marker(new BMap.Point(116.404, 39.915)); // 创建点
  map.addOverlay(marker);

  var polygon = new BMap.Polygon([
  <c:forEach items="${areaInfo.coordinates}" var="sa">
    new BMap.Point(${sa.longitude}, ${sa.latitude}),
  </c:forEach>
  ], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});  //创建多边形
  map.addOverlay(polygon);
</script>