<%--
  Created by IntelliJ IDEA.
  User: etadmin
  Date: 6/1/2016
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<style>
  h3.title {
    font-size: 4em;
    text-align: center;

    font-weight: 200;
    position:relative;
    margin-bottom: 1.6em;
    padding-bottom: 0.5em;
  }
  h3.title:before {
    content: '';
    width: 80px;
    height: 3px;
    background: #e0e0e0;
    position: absolute;
    bottom: 0;
    left: 46%;
    display: block;
  }
  h3.title:before {
    width: 88px;
    left: 44%;
  }
  h3.title {
    font-size: 1.4em;
  }
  a:hover{
    background:#09C;
  }
  .col-xs-1, .col-sm-1, .col-md-1, .col-lg-1, .col-xs-2, .col-sm-2, .col-md-2, .col-lg-2, .col-xs-3, .col-sm-3, .col-md-3, .col-lg-3, .col-xs-4, .col-sm-4, .col-md-4, .col-lg-4, .col-xs-5, .col-sm-5, .col-md-5, .col-lg-5, .col-xs-6, .col-sm-6, .col-md-6, .col-lg-6, .col-xs-7, .col-sm-7, .col-md-7, .col-lg-7, .col-xs-8, .col-sm-8, .col-md-8, .col-lg-8, .col-xs-9, .col-sm-9, .col-md-9, .col-lg-9, .col-xs-10, .col-sm-10, .col-md-10, .col-lg-10, .col-xs-11, .col-sm-11, .col-md-11, .col-lg-11, .col-xs-12, .col-sm-12, .col-md-12, .col-lg-12 {
    position: relative;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
  }
  .col-xs-1, .col-xs-2, .col-xs-3, .col-xs-4, .col-xs-5, .col-xs-6, .col-xs-7, .col-xs-8, .col-xs-9, .col-xs-10, .col-xs-11, .col-xs-12 {
    float: left;
  }
  .col-md-6{
    width:50%;
    float:left;
    margin-bottom: 20px;
  }
  .col-md-4{
    width:33.33%;
    float:left;
    margin-bottom: 20px;
  }
  .col-md-3{
    width:25%;
    float:left;
    margin-bottom: 20px;
  }
  .services-grids:hover span.glyphicon{
    color: #988AEE;
  }
  .services-grids:hover .services-left {
    background: none;
  }
  .services-grids:hover span.glyphicon{
    color: #f3f3f3;
  }
  .services-info.services-row2 {
    margin-top: 3.5em;
  }
  .clearfix:before,
  .clearfix:after,
  .dl-horizontal dd:before,
  .dl-horizontal dd:after,
  .container:before,
  .container:after,
  .container-fluid:before,
  .container-fluid:after,
  .row:before,
  .row:after,
  .form-horizontal .form-group:before,
  .form-horizontal .form-group:after,
  .btn-toolbar:before,
  .btn-toolbar:after,
  .btn-group-vertical > .btn-group:before,
  .btn-group-vertical > .btn-group:after,
  .nav:before,
  .nav:after,
  .navbar:before,
  .navbar:after,
  .navbar-header:before,
  .navbar-header:after,
  .navbar-collapse:before,
  .navbar-collapse:after,
  .pager:before,
  .pager:after,
  .panel-body:before,
  .panel-body:after,
  .modal-footer:before,
  .modal-footer:after {
    display: table;
    content: " ";
  }
  .clearfix:after,
  .dl-horizontal dd:after,
  .container:after,
  .container-fluid:after,
  .row:after,
  .form-horizontal .form-group:after,
  .btn-toolbar:after,
  .btn-group-vertical > .btn-group:after,
  .nav:after,
  .navbar:after,
  .navbar-header:after,
  .navbar-collapse:after,
  .pager:after,
  .panel-body:after,
  .modal-footer:after {
    clear: both;
  }


  .glyphicon-file:before {
    content: "\e022";
  }
  .glyphicon-time:before {
    content:url() no-repeat;
    visibility: hidden;
    display: block;

  }
  .glyphicon-time:after{
    content: ;
    color:#f00;
  }



  * {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
  }
  *:before,
  *:after {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
  }
  html {
    font-size: 10px;

    -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  }
  body {
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    font-size: 14px;
    line-height: 1.42857143;
    color: #333;
    width: 800px;
    background: #f3f3f3;
  }

  span.glyphicon {
    font-size: 3em;
    color: #fff;
  }
  .services-right {
    float: right;
    width: 70%;
    border: 1px solid #988AEE;
    padding: 1.5em;
  }
  .services-right h4 {
    font-size: 1.5em;
    color: #333;
    margin-bottom: 0.5em;
  }
  .services-grids:hover .services-left {
    background: none;
  }
  .services-grids:hover span.glyphicon{
    color: #f3f3f3;
  }
  .services-info.services-row2 {
    margin-top: 3.5em;
  }
  .glyphicon {
    position: relative;
    top: 1px;
    display: inline-block;
    font-family: 'Glyphicons Halflings';
    font-style: normal;
    font-weight: normal;
    line-height: 1;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
  }

  /*--services--*/
  .services-left {
    float: left;
    width: 30%;
    background:#007aff;
    text-align: center;
    padding: 2.9em 0;
    border: 2px solid #988AEE;
    -webkit-transition: .5s all;
    -moz-transition: .5s all;
    transition: .5s all;
    -o-transition: .5s all;
    -ms-transition: .5s all;
  }

  span.glyphicon {
    font-size: 3em;
    color: #fff;
  }
  .services-right {
    float: right;
    width: 70%;
    border: 1px solid #dedede;
    padding: 1.5em;
    background:#fff;
  }
  .services-right h4 {
    font-size: 3em;
    color: #828282;
    margin-bottom: 0.74em;
    text-align: center;
    margin-top: 35px;
  }
  .services-grids:hover .services-left {
    background: none;
  }
  .services-grids:hover span.glyphicon{
    color: #988AEE;
  }
  .services-info.services-row2 {
    margin-top: 3.5em;
  }
  /*--//services--*/
  .container {
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
  }
  @media (min-width: 768px) {
    .container {
      width: 750px;
    }
  }
  @media (min-width: 992px) {
    .container {
      width: 970px;
    }
  }
  @media (min-width: 1200px) {
    .container {
      width: 800px;
    }
  }
  .container-fluid {
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
  }
  * {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
  }
  *:before,
  *:after {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
  }
  .col-sm-6{
    position: relative;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
  }
  .col-xs-6{
    float: left;
    width: 50%;
  }
  .services-grids {
    float: left;
    width: 50%;
    padding: 0 0.5em;
  }
  .services-right {
    float: right;
    width: 60%;
    padding: 0em 0.89em;
    color:#FFF;
  }
  .portfolio-grids {
    padding: 0;
    float: left;
    width: 25%;
  }
  .b-wrapper h5 {
    font-size: 2.5em;
    padding: 38% 0;
  }
  .contact input[type="text"] {
    width: 30.7%;
  }
  .services-left{
    float: left;
    width: 50%;
    background:#000;
    text-align: center;
    padding: 1.93em 0;
    border: 1px solid #dedede;
    -webkit-transition: .5s all;
    -moz-transition: .5s all;
    transition: .5s all;
    -o-transition: .5s all;
    -ms-transition: .5s all;
  }
  .services-left1{
    height: 127px;
    float: left;
    width: 40%;
    background:#007aff;
    text-align: center;
    padding: 1.93em 0;
    border: 1px solid #dedede;
    -webkit-transition: .5s all;
    -moz-transition: .5s all;
    transition: .5s all;
    -o-transition: .5s all;
    -ms-transition: .5s all;
  }
  .services-left2{
    height: 127px;
    float: left;
    width: 40%;
    background:#f6525c;
    text-align: center;
    padding: 1.93em 0;
    border: 1px solid #dedede;
    -webkit-transition: .5s all;
    -moz-transition: .5s all;
    transition: .5s all;
    -o-transition: .5s all;
    -ms-transition: .5s all;
  }
  .services-left3{
    height: 127px;
    float: left;
    width: 40%;
    text-align: center;
    background:#13bd83;
    padding: 1.93em 0;
    border: 1px solid #dedede;
    -webkit-transition: .5s all;
    -moz-transition: .5s all;
    transition: .5s all;
    -o-transition: .5s all;
    -ms-transition: .5s all;
  }
  .services-left4{
    height: 127px;
    float: left;
    width: 40%;
    background:#ffb600;
    text-align: center;
    padding: 1.93em 0;
    border: 1px solid #dedede;
    -webkit-transition: .5s all;
    -moz-transition: .5s all;
    transition: .5s all;
    -o-transition: .5s all;
    -ms-transition: .5s all;
  }
  .services-grids:hover .services-left {
    background: #fff;
  }
  .services-left3:hover{
    background: #fff;
  }
  .services-left1:hover{
    background: #fff;
  }
  .services-left2:hover{
    background: #fff;
  }
  .services-left3:hover{
    background: #fff;
  }
  .services-left4:hover{
    background: #fff;

  }
  .services-grids:hover span.glyphicon{
    color: #656564;

  }
  .services-info.services-row2 {
    margin-top: 2.2em;
  }
  #services{
    background:#f3f3f3;
  }
</style>
<div id="services" class="services">
  <div class="container">
    <h3 class="title"><strong>${device.areaName}:${device.deviceTypeName}</strong></h3>
    <div class="about-text">
      <c:forEach items="${device.dataList}" var="dt">
        <div class="col-md-6">
        <div  class="services-left1">
          <span class="glyphicon glyphicon-time"><p style="font-size:24px"><strong>${dt.dataTypeName}</strong> </p></span>
        </div>
        <div  class="services-right">
          <h4>${dt.datas[0]}${dt.unit}</h4>
        </div>
      </div>
      </c:forEach>
    </div>
  </div>
</div>