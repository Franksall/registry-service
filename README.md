# Microservicio: Registro de Servicios (registry-service)

## 🎯 Propósito

Este servicio es el **"directorio telefónico"**  de toda la arquitectura. Utiliza **Spring Cloud Netflix Eureka Server**.

Su único trabajo es recibir "peticiones de registro" de los otros microservicios (como `ms-pedidos`, `ms-productos` y `gateway-service`).



## 🛠️ Configuración Clave

Este servicio obtiene su configuración del `ms-config-server`, basado en el archivo `registry-service.yml` de GitHub.

* **Puerto de Servicio:** `8099`. Puedes ver el panel de control (dashboard) de Eureka en `http://localhost:8099`.
* **Modo "Standalone":** La configuración clave en su `.yml` es:
    ```yaml
    eureka:
      client:
        registerWithEureka: false
        fetchRegistry: false
    ```
    Esto le dice a Eureka: "Tú eres el único servidor de registro, no intentes buscar ni registrarte con otros servidores de Eureka". Esto es fundamental para que arranque sin errores.

## 🐳 Docker

* **Dependencias:** Este servicio es el **segundo** en arrancar. Su `docker-compose.yml` está configurado con un `depends_on` para esperar a que `ms-config-server` esté en estado `healthy` (saludable) antes de iniciarse.
* **Healthcheck:** Este contenedor tiene un `healthcheck` que usa `curl` (instalado en su `Dockerfile`) para verificar la ruta `/actuator/health`.
* **Servicios Dependientes:** Todos los demás servicios (`ms-pedidos`, `ms-productos`, `gateway-service`) están configurados en `docker-compose.yml` para esperar a que `registry-service` esté `healthy` antes de que ellos puedan arrancar.