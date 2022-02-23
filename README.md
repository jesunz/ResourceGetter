#Proyecto ResourceGetter

### ResourceGetter

El microservicio ResourceGetter obtiene la información de los recursos de la siguiente URL:

>https://apidev.meep.me/tripplan/api/v1/routers/lisboa/resources?low
erLeftLatLon=38.711046,-9.160096&upperRightLatLon=38.739429,-9.13711
5&companyZoneIds=545,467,473

Para ello utiliza un cliente Feign parametrizado con las propiedades definidas en application.properties, donde también se definen los parametros utilizados. 
Además, este archivo de propiedades define la perioricidad con la que realizará dicha consulta.

* ¿Cómo de escalable es tu solución propuesta?
Es escalable, aunque para escalarlo también tendrían que escalarse el servicio con el que interacciona, para que se
integre en el ecosistema de microservicios. Utilizando Hystrix se aumenta la resiliencia del microservicio al 
proporcionar tratamiento a fallos que se puedan producir en el servicio que consume. Para integrarlo en ese
ecosistema de microservicios, sería necesario ajustar la configuración del microservicio, estableciendo la
dirección del servidor de registro y descubrimiento de microservicios, 
como eureka, además de el id de la instancia y un puerto que no esté fijado para evitar conflictos
* ¿Qué problemas a futuro podría presentar? Si has detectado alguno, ¿Qué
alternativa/s propones para solventar dichos problemas? Un posible problema podría ser el hecho de harcodear la 
url, el path y los parámetros que conforman la dirección del endpoint del que se consume la información. Para evitar este problema
y mantener la parametrización del cliente, se podría utilizar un servidor de configuraciones como Spring Cloud Config
