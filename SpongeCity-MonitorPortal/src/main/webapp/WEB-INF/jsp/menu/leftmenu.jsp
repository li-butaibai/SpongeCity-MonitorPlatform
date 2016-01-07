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
    <c:forEach items="${areamenus}" var="es">
    {
      label: '${es.name}',
      children: [
              <c:forEach items="${es.subArea}" var="sa">
                { label: '${sa.name}' },
              </c:forEach>
      ]
    },
    </c:forEach>
  ];
  $(function() {
    $('#tree1').tree({
      closedIcon: '＞',
      openedIcon: '∨',
      data: data
    });
  });
</script>