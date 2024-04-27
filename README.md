UniEventos es una empresa que vende entradas a conciertos y eventos en diferentes ciudades de
Colombia y tiene la necesidad de construir una plataforma donde sus clientes puedan comprar las entradas
al evento que le interese. Para esto, el cliente debe registrarse, para el registro es necesario una cédula,
nombre completo, número de teléfono, email y contraseña. Una vez registrado puede ingresar con su email
y contraseña, luego le deberá aparecer una pantalla para elegir la ciudad, y se deben listar todos los
eventos que hay en dicha ciudad. El usuario puede elegir el evento que le interese y hacer la compra. Para
hacer la compra debe indicar cuántas entradas va a adquirir, elegir la localidad y por último debe “pagar” el
valor total de la compra.
La plataforma debe contar con un sistema de cupones que ofrecen descuentos al cliente en el valor de la
compra, estos cupones son redimibles al momento de pagar. Los cupones se distribuyen de la siguiente
manera:
● Cuando un cliente se registra por primera vez se le envía un cupón vía correo electrónico. Al redimir
este cupón obtiene un 15% de descuento.
● Cuando un cliente hace una compra por primera vez por medio de la plataforma se le envía un
cupón vía correo electrónico. Al redimir este cupón obtiene un 10% de descuento.
El administrador de la plataforma tiene la responsabilidad de crear los eventos. Cada evento tiene un
nombre, una ciudad, una descripción, un tipo (concierto, teatro, deporte, festival, otro) una imagen, fecha,
dirección y unas localidades, cada localidad tiene un precio y una capacidad máxima.
NOTA: En adelante la acción gestionar hará referencia a crear, modificar, buscar (ver información), listar y si
es posible eliminar..
En UniEventos se desea contar con una aplicación que maneje dos tipos de persona.
Administrador:
● Loguearse.
● Gestionar eventos.
● Crear nuevos cupones para fechas especiales con el porcentaje que desee.
● Obtener datos estadísticos de cada evento: porcentaje vendido por localidad, total ganado por
ventas.
● Listar los eventos según la acogida ha tenido por cada ciudad (ordenar por mayor recaudación).
Clientes:
● Registrarse y loguearse.
● Buscar eventos (por nombre, tipo o ciudad).
● Realizar compras.
● Cancelar compras.
● Redimir cupones.
● Listar sus propias compras.
Para tener en cuenta:
● Diseñar diagrama de clases para representar cada entidad en el sistema.
● El proyecto se debe implementar usando Java en su versión 21 y debe usarse Maven.
● Hacer la implementación de la GUI por medio de JavaFX. La navegación por medio de la GUI debe
ser lo suficientemente clara para no requerir un manual de usuario.
● Cuando el usuario se registra no puede iniciar sesión inmediatamente. Una vez el usuario se
registra se le envía un correo electrónico con un código aleatorio. Y cuando ingrese la primera vez
se le pedirá este código para activar su cuenta.
● La pantalla inicial debe mostrar una lista de eventos aleatorios, debe tener el botón de registro o de
iniciar sesión y una sección de búsqueda.
● Se debe validar automáticamente que al momento de hacer la compra, la localidad seleccionada
para el evento tenga la capacidad adecuada para alojar a la cantidad de personas especificada en
la compra.
● En la compra se debe guardar, el cliente, el evento, la localidad, el cupón (si es que usa un cupón) y
la factura. La factura debe tener el subtotal, el total, una fecha y un código generado aleatoriamente
(UUID).
● Cada vez que se realice una compra se debe generar un código QR con el código de la factura y se
debe guardar. De igual manera, se le debe enviar un correo electrónico al cliente indicando los
detalles de la compra.
● Solo existe un administrador, los datos de acceso del administrador son: admin@unieventos.com y
la contraseña es admin123.
● Se debe hacer pruebas unitarias con JUnit a al menos 7 métodos.
● Se debe hacer uso de excepciones para controlar los posibles errores que puedan ocurrir en
cualquier momento.
● Se deben usar al menos 5 patrones de diseño vistos en clase.
● Se debe usar serialización de objetos para la persistencia.
IMPORTANTE:
● Piense en dos necesidades adicionales a este sistema para que las incluya dentro de su
implementación. No deben ser necesidades triviales.
● El proyecto puede realizarse en grupos máximo de 3 personas.
● Todos los temas planteados en el proyecto final serán vistos en clase.
