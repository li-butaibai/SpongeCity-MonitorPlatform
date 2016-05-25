<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<div id="allmap" style="margin-left: 20px; margin-right: 270px; "></div>
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
    <p class="devicetype"><input type="checkbox" id="dt_${dt.id}" name="deviceType" value="${dt.id}" onclick="onDTChange()">${dt.name}<img src="picture/d${dt.id}_Online.png" style="height:23px; margin-left: 5px;"/></p>
  </c:forEach>

</div>
<div style="display: none">
  <c:forEach items="${areaInfo.coordinates}" var="sa">
    <span>${sa.longitude}  ${sa.latitude}</span></br>
  </c:forEach>
</div>
<script type="text/javascript">
  var hashObject = GetHash();
  var devices=[];
  var markers=[];
  var infoWindows=[];
  var labels=[];
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
  var map = new BMap.Map("allmap",{mapType:BMAP_HYBRID_MAP});
  var point = new BMap.Point(<c:out value="${areaInfo.centerPoint.longitude}" />, <c:out value="${areaInfo.centerPoint.latitude}" />);
  var points = [
    <c:forEach items="${areaInfo.coordinates}" var="sa">
    new BMap.Point(${sa.longitude}, ${sa.latitude}),
    </c:forEach>
  ];
  map.setViewport(points);//map.centerAndZoom(point, 15);
  map.addControl(new BMap.MapTypeControl());
  map.enableScrollWheelZoom(true);
  var polygon = new BMap.Polygon(points, {strokeColor:"#91b4ad", strokeWeight:2, strokeOpacity:0.9, fillOpacity:0.2});  //创建多边形
  map.addOverlay(polygon);
  setInterval(getAllDevices, 10000)
  function getAllDevices()
  {
    $.ajax({
      url: "/devices/devices?"+location.hash.replace("#",""),
      type: "get",
      async: true,
      dataType: "json",
      data: { "rnd": Math.random() },
      success: function (data) {
        for(var i = 0; i < data.length; i++ ) {
          if ($.inArray(data[i].id, devices)<0) {
            devices.push(data[i].id);
            var myIcon = new BMap.Icon("picture/d"+data[i].deviceType.id+"_"+data[i].state+".png", new BMap.Size(18,18),{imageSize:new BMap.Size(18,18)});
            myIcon.images
            var marker = new BMap.Marker(new BMap.Point(parseFloat(data[i].coordinate.latitude), parseFloat(data[i].coordinate.longitude)), {icon:myIcon});
            console.log("marker"+data[i].coordinate.latitude);
            markers.push(marker);
            //alert(data[i].id);
            map.addOverlay(marker);
            //marker.setAttribute("alt",data[i].id);
            var content = "<div style='width: 500px; height: 300px'><div class='imgdiv' style=''><img src='picture/d"+data[i].deviceType.id+".jpg'/></div>";
            content = content + "<table  class='maptable' style=''>";
            content = content + "<tr><td> 设备编号：</td><td>" + data[i].id+"</td></tr>";
            content = content + "<tr><td> 设备类型：</td><td>" + data[i].deviceType.name + "</td></tr>";
            content = content + "<tr><td> 设备状态：</td><td>" + (data[i].state=="Offline"?"离线":"在线") + "</td></tr>";
            content = content + "<tr><td> 区    域：</td><td>" + data[i].areaName + "</td></tr>";
            content = content + "<tr><td> 地    块：</td><td>" +  (data[i].blockName==null?"——":data[i].blockName)+"</td></tr>";
            content = content + "<tr><td> 措    施：</td><td>"  + (data[i].measureName==null?"——":data[i].measureName) + "</td></tr>";
            content = content + "</table>";
            content = content + "<p style='clear: both; font-size: 12px; padding: 10px 20px; line-height: 200%; color:#3c3c3c; background: #f7f7f7'> 备注信息：" + data[i].comments + "</p>";
            content += "</div>";
            var labelContent = "";
            if(data[i].state=="Online") {
              for (var j = 0; j < data[i].dataList.length; j++) {
                labelContent += data[i].dataList[j].unit + ":" + data[i].dataList[j].datavalue.toFixed(2) + "</br>";
              }
              var label = new BMap.Label(labelContent, {offset: new BMap.Size(30, -10)});
              label.setStyle({
                color: "green",
                fontSize: "12px",
                border: "1px solid green",
                height: (20 * data[i].dataList.length) + "px",
                width: "auto",
                fontFamily: "微软雅黑"
              });
            }
            else
            {
              labelContent = "离线";
              var label = new BMap.Label(labelContent, {offset: new BMap.Size(30, -10)});
              label.setStyle({
                color: "red",
                fontSize: "12px",
                border: "1px solid red",
                height: "20px",
                width: "auto",
                fontFamily: "微软雅黑"
              });
            }
            //marker.setLabel(label);

            labels.push(label);
            (function () {
              var infoWindow = new BMap.InfoWindow(content);
              infoWindows.push(infoWindow);
              marker.addEventListener("click", function () {
                this.openInfoWindow(infoWindow);
              });
            })()
          }
          else{

            //marker.setAttribute("alt",data[i].id);
            var content = "<div style='width: 500px; height: 300px'><div class='imgdiv' style=''><img src='picture/d"+data[i].deviceType.id+".jpg'/></div>";
            content = content + "<table  class='maptable' style=''>";
            content = content + "<tr><td> 设备编号：</td><td>" + data[i].id+"</td></tr>";
            content = content + "<tr><td> 设备类型：</td><td>" + data[i].deviceType.name + "</td></tr>";
            content = content + "<tr><td> 设备状态：</td><td>" + (data[i].state=="Offline"?"离线":"在线") + "</td></tr>";
            content = content + "<tr><td> 区    域：</td><td>" + data[i].areaName + "</td></tr>";
            content = content + "<tr><td> 地    块：</td><td>" +  (data[i].blockName==null?"——":data[i].blockName)+"</td></tr>";
            content = content + "<tr><td> 措    施：</td><td>"  + (data[i].measureName==null?"——":data[i].measureName) + "</td></tr>";
            content = content + "</table>";
            content = content + "<p style='clear: both; font-size: 12px; padding: 10px 20px; line-height: 200%; color:#3c3c3c; background: #f7f7f7'> 备注信息：" + data[i].comments + "</p>";
            content += "</div>";
            var labelContent = "";
            if(data[i].state=="Online") {
              for (var j = 0; j < data[i].dataList.length; j++) {
                labelContent += data[i].dataList[j].unit + ":" + data[i].dataList[j].datavalue.toFixed(2) + "</br>";
              }
              var label = new BMap.Label(labelContent, {offset: new BMap.Size(30, -10)});
              label.setStyle({
                color: "green",
                fontSize: "12px",
                border: "1px solid green",
                height: (20 * data[i].dataList.length) + "px",
                width: "auto",
                fontFamily: "微软雅黑"
              });
            }
            else
            {
              labelContent = "离线";
              var label = new BMap.Label(labelContent, {offset: new BMap.Size(30, -10)});
              label.setStyle({
                color: "red",
                fontSize: "12px",
                border: "1px solid red",
                height: "20px",
                width: "auto",
                fontFamily: "微软雅黑"
              });
            }
            var idx = $.inArray(data[i].id, devices)
            map.removeOverlay(labels[idx]);
            labels[idx]=label;
            //markers[idx].setLabel(label);
            //infoWindows[idx].content=content;
          }
        }
      },
      error: function (data) {
        rtn = false;
      }
    });
  }
  getAllDevices();

</script>