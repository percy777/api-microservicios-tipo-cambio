# api-microservicios-tipo-cambio

Este proyecto se implmenta una api REST en springboot, que luego se dockeriza, para este proposito se creo un DockerFile con una receta para crear una imagen docker a partir de un JAR que contiene una app Java con un servidor autocontenido y ponerla en operación. 
Usa una tabla simple en una  BD in memory H2 


el api REST se implmento usando una arquitectura basica MVC para organizar los paquetes, 
tambien se uso dependencias de springJPA y para conectar a una BD in memory H2 



