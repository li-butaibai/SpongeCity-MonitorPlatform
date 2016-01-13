<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<div id="allmap"></div>
<div id="checkwin">
  <p class="devicetitle">设备类型</p>
  <script type="text/javascript">
    function onDTChange(){
      var devciceTypes="";
      $("input[type=checkbox]").each(function(){
        if(this.checked){
          devciceTypes+=","+$(this).val();
        }
      });
      if(devciceTypes.length>0) devciceTypes=devciceTypes.substring(1,devciceTypes.length);
      var hashObject = GetHash();

      hashObject["deviceTypeIds"] = devciceTypes;
      var hashurl = "";
      for( var key in hashObject ){
        hashurl += key + "=" + hashObject[key]+"&";
      }
      location.hash = hashurl.slice(0,-1);
    }
  </script>
  <c:forEach items="${deviceTypes}" var="dt">
    <p class="devicetype"><input type="checkbox" id="dt_${dt.id}" name="deviceType" value="${dt.id}" onclick="onDTChange()">${dt.name}</p>
  </c:forEach>

</div>
<div style="display: none">
  <c:forEach items="${areaInfo.coordinates}" var="sa">
    <span>${sa.longitude}  ${sa.latitude}</span></br>
  </c:forEach>
</div>
<script type="text/javascript">
  var hashObject = GetHash();
  if( hashObject.hasOwnProperty('deviceTypeIds') ){
    var dtIds = hashObject['deviceTypeIds'].split(',');
    for(var i =0; i<dtIds.length; i++)
    {
      $("#dt_"+dtIds[i]).attr("checked","checked");
    }
  }
  else{

    $("input[type=checkbox]").each(function(){
        $(this).attr("checked","checked");
    });
  }
  // 百度地图API功能
  var map = new BMap.Map("allmap");
  <c:forEach var="sa" items="${areaInfo.coordinates}" begin="1" end="1">
    var point = new BMap.Point(${sa.longitude}, ${sa.latitude});
  </c:forEach>

  map.centerAndZoom(point, 18);
  map.addControl(new BMap.MapTypeControl());
  map.enableScrollWheelZoom(true);
  ///
  $.getJSON("/devices/devices?"+location.hash.replace("#",""), function (data) {
    console.log("data.length"+data.length);
    for(var i = 0; i < data.length; i++ ){
      var marker =new BMap.Marker(new BMap.Point(parseFloat(data[i].coordinate.latitude),parseFloat(data[i].coordinate.longitude)));
      //alert(data[i].id);
      //marker.setAttribute("alt",data[i].id);
      marker.addEventListener("click", function(e){
        //alert(e.target.attributes["alt"]);
      });
      map.addOverlay(marker);
    }
    //console.log(data.length);
      //var marker = new BMap.Marker(new BMap.Point(116.317449, 39.98615)); // 创建点
      //map.addOverlay(marker);
  });
  ///
  //var marker = new BMap.Marker(new BMap.Point(116.317449, 39.98615)); // 创建点
  //map.addOverlay(marker);

  var polygon = new BMap.Polygon([
  <c:forEach items="${areaInfo.coordinates}" var="sa">
    new BMap.Point(${sa.longitude}, ${sa.latitude}),
  </c:forEach>
  ], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});  //创建多边形
  map.addOverlay(polygon);
</script>