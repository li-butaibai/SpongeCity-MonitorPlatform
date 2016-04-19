<%--
  Created by IntelliJ IDEA.
  User: EriclLee
  Date: 15/12/29
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="shortcut icon" href="/picture/favicon.ico">
  <title>海绵城市数据监控平台</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cssreset-min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jqtree.css">
  <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
  <script src="${pageContext.request.contextPath}/js/tree.jquery.js"></script>
  <script src="http://api.map.baidu.com/api?v=2.0&ak=Fp5YoAmGiStTkpbGVKI8dQkA"></script>
  <script type="text/javascript">
    function onresize(){
      $('.conright').css("height",($(window).innerHeight())+"px");
      $('.r_con3').css("height",($(window).innerHeight()-207)+"px");
      $('.conright').css("width",($(window).innerWidth()-$('.conleft').innerWidth())+"px");
      $('.conright').css("margin-left",$('.conleft').innerWidth()+"px");
    }
  </script>
</head>

<body onload="onresize()" onresize="onresize()">
<div class="con">

  <div class="conleft">

  </div>
  <div class="conright">
    <div class="r_con1">
      <img src="img/logo.jpg" style="padding-top: 25px; padding-left: 25px;">
    </div>
    <div class="r_con2">
      <ul class="r_nav">
        <li class="nav_btn nav_btn1 active">首页</li>
        <li class="nav_btn nav_btn2">设备</li>
        <li class="nav_btn nav_btn3">告警</li>
        <li class="nav_btn nav_btn4">数据下载</li>
      </ul>
    </div>
    <div class="r_con3">

    </div>
  </div>
</div>
</body>
</html>
<script>
  $(function(){
    //init
    if( location.hash == "" ){
      $(".conleft").load('/menu/areamenu');
      location.hash = "#areaId=1&topmenu=0";
    }else{
      $(".conleft").load('/menu/areamenu');
      window.onhashchange();
      var hashObject = GetHash();
      if( hashObject.hasOwnProperty('topmenu') ){
        //hashObject["topmenu"] = 0;
        $(".nav_btn").removeClass("active");
        $(".nav_btn").eq(hashObject.topmenu).addClass("active");
      }

    }

    //topmenu
    $(".nav_btn").click(function(){
      var index = $(".nav_btn").index(this);
      $(".nav_btn").removeClass("active");
      $(this).addClass("active");
      SetHash({"topmenu":index,"pageIndex":0});
    })
  })

    //listen hash
    window.onhashchange = function(){
      var hashObject = GetHash();
      if( !hashObject.hasOwnProperty('topmenu') ){
        hashObject["topmenu"] = 0;
      }
      if( hashObject["topmenu"] == 0 ){
        $(".r_con3").load( "/home/areamap?areaId=" + hashObject.areaId );
      }else if( hashObject["topmenu"] == 1 ){
        if( !hashObject.hasOwnProperty('pageIndex') ){
          hashObject["pageIndex"] = 0;}
          $(".r_con3").load( "devices/index?areaId=" + hashObject.areaId  + "&pageIndex="+hashObject.pageIndex );
        console.log("topmenu1");
      }else if( hashObject["topmenu"] == 2 ){
        if( !hashObject.hasOwnProperty('pageIndex') ){
          hashObject["pageIndex"] = 0;
        }
        $(".r_con3").load( "alerts/index?areaId=" + hashObject.areaId  + "&pageIndex="+hashObject.pageIndex );
      }else if( hashObject["topmenu"] == 3 ){

        $(".r_con3").load( "data/datadownload?areaId=" + hashObject.areaId );
      }
    };
    //hash tools
    //sethash
    function SetHash(val) {
      console.log("sethash");
      var hashObject = GetHash();
      if( val.hasOwnProperty('areaId')){
        hashObject["areaId"] = val["areaId"];
      }
      if( val.hasOwnProperty('topmenu')){
        hashObject["topmenu"] = val["topmenu"];
      }
      if( val.hasOwnProperty('pageIndex')){
        hashObject["pageIndex"] = val["pageIndex"];
      }
      var hashurl = "";
      for( var key in hashObject ){
        hashurl += key + "=" + hashObject[key]+"&";
      }
      location.hash = hashurl.slice(0,-1);
    }

    //gethash
    function GetHash() {
      console.log("gethash");
      var url = location.hash; //获取url中"?"符后的字串
      var theRequest = new Object();
      if (url.indexOf("#") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
          theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
        }
      }
      return theRequest;
    }
   $(window).load(  function(){
    alert($(screen).innerHeight());
    $('.conright').css("height",$(screen).innerHeight());
  });
</script>