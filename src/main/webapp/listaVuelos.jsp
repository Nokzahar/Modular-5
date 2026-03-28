<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Asegúrate de que esta URI sea exactamente así para Tomcat 10 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Vuelos Disponibles</title>
</head>
<body>
<h2>Vuelos Disponibles</h2>
<table border="1">
  <thead>
  <tr>
    <th>Número</th>
    <th>Origen</th>
    <th>Destino</th>
    <th>Hora</th>
    <th>Acción</th>
  </tr>
  </thead>
  <tbody>
  <%-- Se elimina jsp:useBean. JSTL accede directo al atributo del request --%>
  <c:forEach var="v" items="${vuelosDisponibles}">
    <tr>
      <td>${v.numeroVuelo}</td>
      <td>${v.origen}</td>
      <td>${v.destino}</td>
      <td>${v.hora}</td>
      <td><a href="reservar?id=${v.id}">Reservar</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>