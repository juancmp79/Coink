# Coink
Prueba Coink

Se cumple con la prueba para realizar el buil deberan clonar los archivos en su disco y en el IDE de desarrollo 
![image](https://user-images.githubusercontent.com/104405326/166085330-d817023c-412d-44b0-bdda-ee26c917a0b9.png)

Una vez descargado en la pestaña File -> New -> Import Proyect..
![image](https://user-images.githubusercontent.com/104405326/166085392-f40c1524-6ec1-4751-968e-6df6c258ccd8.png)

se abre un cuadro de dialogo y ahi buscan la carpeta llamada Coink y le dan click en OK
![image](https://user-images.githubusercontent.com/104405326/166085426-3bfe3bf4-2f67-4730-91ec-747ad3ee332a.png)

Android studio abrira el el proyecto y no debera mostrar ningun error asi mismo si es necesario actualizara el Gradle y al dar click en el botón
Run App o Alt + F10 la aplicación sera compilada y si se tiene  un emulador instalado o creado en el entorno este comenzara a 
funcionar ejecutantdo la APP

Asi mismo dejo el ejecutable llamado Coink.apk en la carpeta principal, el diseño que intente plasmar fue:

Insersión de Splash Screen como presentación de la aplicación
![image](https://user-images.githubusercontent.com/104405326/166085645-325ac43a-b73c-451e-b91d-73c87338ea15.png)

Para rl Form de inicio de la App donde se realíza el código del Botón Regristate
![image](https://user-images.githubusercontent.com/104405326/166085689-754046e8-5e67-4f6f-95a1-b696cf3a9da8.png)

Al dar click en este botón la aplicación muestra:
![image](https://user-images.githubusercontent.com/104405326/166085798-637332a6-0128-4bb8-be2e-5486296e2edb.png)

Si se escribe correctamente el teléfono el botón se habilitará tal como se muestra:
![image](https://user-images.githubusercontent.com/104405326/166085822-48edbb00-c63d-4ab0-9a7c-96211acf70e4.png)

Al iniciar el Form  la forma que aparece es la de datos 
![image](https://user-images.githubusercontent.com/104405326/166085832-25954c54-5c63-45e0-8094-badaa231c3a6.png)

Esta forma tiene dentro de sus componentes un scrollBar el cual permite subir y bajar la información requerida de la forma, así mismo 
se colocaron spinner con las listas de datos como fueron el genero y el tipo de documento, hacia el final de la misma
se hace la validacion del correo y del PIN de logueo donde se confirma que los dos Pines sean iguales, ademas la aplicación verifica que todos los datos
fueron ingresados y habilita el botón Siguiente, los campos fechas se hicieron con un Datapicket tal como se muestra:

![image](https://user-images.githubusercontent.com/104405326/166085924-51cd6ac1-cf9a-4c04-a612-7b0d943d9f96.png)

Los campos de correo se verificá que la escritura del correo sea valida a medida que va ingresando la información
![image](https://user-images.githubusercontent.com/104405326/166085965-05a7d51f-ba19-45fb-98e8-36ebb029fb5d.png)

Asi mismo verifica que los dos correos coinsidan:
![image](https://user-images.githubusercontent.com/104405326/166086000-0ed34a80-9e10-4cb6-bf56-462f569d0d4b.png)

Una vez esto es correcto en el campo PIN de logueo hace el mismo procedimiento si este es correcto habilita el botón de Siguiente:
![image](https://user-images.githubusercontent.com/104405326/166086040-5f6d1dff-58a5-4349-a7c5-f41cb73e669c.png)

En todo este form se juega con los eventos de los EditText y se usan ayudas de diseño y otras se realizan por código 
con el fin de demostar que cualquiera de las dos formas es posible realizar, una vez se da click en este botón se pasa 
a la pantalla donde se pone al usuario a leer el contrato:

![image](https://user-images.githubusercontent.com/104405326/166086093-7b6d1c19-cdeb-45e4-b2db-80a82ea3e76d.png)

De igual manera esta formna tiene un ScrollBar y en la parte inferior tiene un CheckBox el cual habilita el botón que permitiria enviar la información
![image](https://user-images.githubusercontent.com/104405326/166086130-446b2a88-274f-4023-9ca1-de48898d2c5a.png)

Como se puede evidenciar el usuario es guiado por cada una de las formas y no es posible que avance si no tiene todos los datos ya para finalizar falto
el consumo del WS pues no encontre una buena documentación de el metodo y los parametros y ya por falta de tiempo deje hasta aqui 
se trato de hacer lo mas parecido usando diseños y estilos creados, asi mismo se creo un log de los datos, para que se puedan recuperar en cualquier parte de la APP
y funciones con los datos importantes las cuales permitirian navegar y realizar mas procedimientos

![image](https://user-images.githubusercontent.com/104405326/166086216-0a866887-b242-4447-b9c3-3512e7bdb147.png)

El consumo del WB service no es un problema se ha realizado muchas veces ya sean SOAT y/o JSON para android o Kotlin ademas de su conformación en Java para servidor 
Glasfissh, espero que la aplicación sea de su agrado fue en gran reto de implementacion porque el tiempo apesar es poco y aunque falto mucho por realizar fue 
un ejercico interezante




