<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <form action="reservar" method="POST">
          <input type="hidden" name="idVuelo" value="${v.id}">
          <button type="submit">Reservar</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>