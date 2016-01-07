<%--
  Created by IntelliJ IDEA.
  User: EriclLee
  Date: 16/1/6
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<div class="l_con1">
  <h1>海绵城市监控平台</h1>
</div>
<div class="l_con2">
  <div id="tree1"></div>
</div>
<script>
  var data = [
    {
      label: '1#区域',
      children: [
        { label: '区块1' },
        { label: '区块2' }
      ]
    },
    {
      label: '2#区域',
      children: [
        { label: '区块1' },
        { label: '区块2' }
      ]
    },
    {
      label: '3#区域',
      children: [
        { label: '区块1' },
        { label: '区块2' }
      ]
    },
    {
      label: '4#区域',
      children: [
        { label: '区块1' },
        { label: '区块2' }
      ]
    },
    {
      label: '5#区域',
      children: [
        { label: '区块1' },
        { label: '区块2' }
      ]
    },
    {
      label: '6#区域',
      children: [
        { label: '区块1' },
        { label: '区块2' }
      ]
    }
  ];
  $(function() {
    $('#tree1').tree({
      closedIcon: '＞',
      openedIcon: '∨',
      data: data
    });
  });
</script>