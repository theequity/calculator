# 	CALCULATOR

#### Clonar el proyecto 

Ejecutar desde terminal:

> git clone https://github.com/theequity/calculator.git

#### Compilar el microservicio 

Para construir el proyecto, ejecutar en un terminal:

> mvn clean install

#### Ejecutar el microservicio
Desde la raiz del proyecto, ejecutar en un terminal:

> mvn spring-boot:run

Una vez lanzado el microservicio se accede desde la siguiente URL: 
> http://localhost:8080/api/calculate?firstElement={value}&secondElement={value}&operation=div

**Nota** Operaciones disponibles 

add => suma

sub => resta