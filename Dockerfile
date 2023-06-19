# Utilizar una imagen base con Java 8 y Maven
FROM maven:3.8.4-openjdk-8

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /checkin

# Copiar los archivos de configuración del proyecto
COPY pom.xml .
COPY src ./src

# Empaquetar la aplicación
RUN mvn package -DskipTests

# Exponer el puerto 8023
EXPOSE 8023

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "target/checkin-0.0.1-SNAPSHOT.jar"]
