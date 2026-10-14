# Mandatvm

Sistema de escritorio para asignar practicantes a las empresas donde harán sus prácticas supervisadas, clasificadas por sector (banca, tecnología e industria). Proyecto del Taller B5, Fundación Kinal.

Tecnologías:

- Java
- JavaFX
- JDBC
- MySQL
- NetBeans (proyecto Java with Ant)

Qué hace:

- Inicio de sesión del coordinador de prácticas
- Registrar, actualizar y eliminar asignaciones (alumno, empresa, teléfono y sector)
- Tabla con todos los practicantes ubicados y el sector de cada uno

Cómo correrlo

1. Ejecutar DDL.sql en MySQL para crear la base de datos `mandatvm_db`.
2. Poner tu usuario y contraseña de MySQL en Enviroment.java.
3. Agregar JavaFX 21.0.11 de preferencia y el conector de MySQL al proyecto la ruta sería abrir la ventana derecha, entrar a l a ventana izquierda, dirigirse a properties, luego en run añadir la ruta donde esta su ruta de javafx y por ultimo añadir las librerias en libraries. 
5. Abrir el proyecto en NetBeans y ejecutarlo (Run).

Usuario de prueba

Usuario: `ludvinxd`
Clave: `1234`

Estructura

"config": conexión a la base de datos y script DDL.
"controller": controladores de las pantallas.
"model": entidades y el enum del login. `model/dto` tiene el DTO de la tabla.
"repository": acceso a la base de datos con JDBC.
"service": lógica entre el controller y el repository.
"utils": `SceneManager`, `ViewFactory` y `Validations`.
"view": pantallas FXML.
"resources/styles": hojas de estilo CSS.