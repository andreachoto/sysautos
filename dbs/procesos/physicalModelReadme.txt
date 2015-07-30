Descripcion del mapa physicalModel de procesos.

Cada color implica un modulo los mismo que deben manejarse de forma relacionada jerarquicamente segun el flujo de informacion y las relaciones establecidas.

los modulos tienen la siguiente jeraraquia.

1. Usuarios Color: Verde
2. Cliente Color: Amarillo
3. Ventas Color: Rosado
4. Credito Color: Azul

En cada modulo se establece un nombre de tabla-proceso acompañado de un numero.

Este numero indica el orden en el flujo del proceso, iniciando por 1.
si este numero esta acompañado por una letra indica que es manejado en forma de subrpoceso por la tabla principal.

Por ejemplo:

En el modulo Usuarios.
 tabla: usuario 3.
 tabla: userprofile 3a.

Esto indica que la gestion de la tabla usuarios, maneja el flujo de la tabla userprofile 3a.


