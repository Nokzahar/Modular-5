<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Vuelos Disponibles</title>
</head>
<body>
<h2> Vuelos Disponibles</h2>

<c:if test="${param.mensaje == 'ReservaExitosa'}">
  <div style="color: green; font-weight: bold; margin-bottom: 10px;">
    ¡Su reserva se ha realizado con éxito!
  </div>
</c:if>
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
  <c:forEach var="v" items="${vuelos}">
    <tr>
      <td>${v.numeroVuelo}</td>
      <td>${v.origen}</td>
      <td>${v.destino}</td>
      <td>${v.hora}</td>
      <td>
        <form action="${pageContext.request.contextPath}/reservar" method="POST">
          <input type="hidden" name="idVuelo" value="${v.id}">
          <input type="hidden" name="numeroVuelo" value="${v.numeroVuelo}">
          <button type="submit">Reservar</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</html>