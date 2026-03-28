<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>AeroFly - Realizar Reserva</title></head>
<body>
<h2>Confirmar Reserva para el Vuelo #${param.id}</h2>

<p style="color:red;">${error}</p>

<form action="reservar" method="post">
  <input type="hidden" name="vueloId" value="${param.id}">

  <label>Nombre Completo:</label><br>
  <input type="text" name="nombre" required><br><br>

  <label>Correo Electrónico:</label><br>
  <input type="email" name="email" required><br><br>

  <button type="submit">Finalizar Reserva</button>
</form>

<br>
<a href="vuelos">Volver al listado</a>
</body>
</html>