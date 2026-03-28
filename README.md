**✈️ Sistema de Reserva de Vuelos - AeroFly**
* Este es un proyecto de aplicación web desarrollado en Java EE utilizando el patrón de diseño MVC (Modelo-Vista-Controlador). La aplicación permite visualizar una lista de vuelos disponibles desde una base de datos MySQL y realizar reservas interactivas.

**📋 Requisitos Previos**
* **Java JDK**: 17 o superior.

* **Servidor de Aplicaciones**: Apache Tomcat 10.1.x (Jakarta EE).

* **Base de Datos**: MySQL 8.0 o superior.

* **IDE**: IntelliJ IDEA (recomendado) o Eclipse.

* **Gestor de Dependencias**: Maven.

🗄️ Configuración de la Base de Datos
Para que el proyecto funcione, es necesario recrear la base de datos en tu entorno local. Sigue estos pasos:

Abre MySQL Workbench o tu terminal de MySQL.

Crea la base de datos y las tablas ejecutando el siguiente script:

```sql
CREATE DATABASE aerofly_db;
USE aerofly_db;

-- Tabla de Vuelos
CREATE TABLE vuelos (
id INT AUTO_INCREMENT PRIMARY KEY,
numero_vuelo VARCHAR(10) NOT NULL,
origen VARCHAR(50) NOT NULL,
destino VARCHAR(50) NOT NULL,
hora TIME NOT NULL
);

-- Tabla de Reservas
CREATE TABLE reservas (
id INT AUTO_INCREMENT PRIMARY KEY,
vuelo_id INT,
nombre_pasajero VARCHAR(100),
email_pasajero VARCHAR(100),
fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (vuelo_id) REFERENCES vuelos(id)
);

-- Datos de prueba para Vuelos
INSERT INTO vuelos (numero_vuelo, origen, destino, hora) VALUES
('AF123', 'Santiago', 'Puerto Montt', '10:30:00'),
('AF456', 'Concepción', 'Antofagasta', '15:45:00'),
('AF101', 'Santiago', 'Concepción', '08:30:00'),
('AF202', 'Antofagasta', 'Santiago', '12:45:00'),
('AF303', 'Puerto Montt', 'Santiago', '18:20:00'); 
```

Importante: En las clases VueloDAO y ReservaDAO, asegúrate de actualizar la variable pass con tu contraseña local de MySQL.

🚀 Instrucciones de Ejecución
Clonar o importar el proyecto: Abre IntelliJ IDEA e importa el proyecto como un proyecto Maven.

Configurar Tomcat:

Ve a Edit Configurations.

Añade una nueva configuración de Tomcat Server (Local).

En la pestaña Deployment, añade el artefacto war exploded.

Compilar: Ejecuta mvn clean install para descargar las dependencias (JSTL, MySQL Connector, etc.).

Iniciar: Haz clic en el botón de Run o Debug. La aplicación se abrirá en http://localhost:8080/vuelos.

🛠️ Tecnologías Utilizadas
Backend: Java Servlets, JDBC.

Frontend: JSP (JavaServer Pages), JSTL, HTML5, CSS3.

Base de Datos: MySQL.

Arquitectura: MVC (Separación de lógica de negocio, acceso a datos y vistas).

* Considera que el código ya viene con un nombre y correo preestablecidos para reservar, los cuales se guardarán en la base de datos apenas presiones "Reservar"