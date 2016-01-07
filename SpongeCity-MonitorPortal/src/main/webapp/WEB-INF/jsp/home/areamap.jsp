<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<div>
  <c:forEach items="${areaInfo.coordinates}" var="sa">
    <span>${sa.longitude}  ${sa.latitude}</span></br>
  </c:forEach>
</div>
