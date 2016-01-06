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
  <div class="zone-items">
<c:forEach items="${areamenus}" var="es">
    <ul class="level-1">
      <li class="cate no-items" id="home">
        <a href="#" data-permalink="">
          <span class="fa fa-overview"></span>
          <span class="text">${es.name}</span>
        </a>
      </li>
    </ul>
  </c:forEach>
  </div>
