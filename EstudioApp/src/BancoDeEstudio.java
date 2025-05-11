import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDeEstudio {

    private List<PreguntaTest> preguntasTestUDP;
    private List<EjercicioRellenarCodigo> ejerciciosRellenarUDP;
    private List<PreguntaTest> preguntasTestWebSockets;
    private List<EjercicioRellenarCodigo> ejerciciosRellenarWebSockets;

    public BancoDeEstudio() {
        cargarPreguntasUDP();
        cargarEjerciciosUDP();
        cargarPreguntasWebSockets();
        cargarEjerciciosWebSockets();
    }

    private void cargarPreguntasUDP() {
        preguntasTestUDP = new ArrayList<>();
        preguntasTestUDP.add(new PreguntaTest(
            "1. ¿Cuál es una característica principal de UDP?",
            Arrays.asList(
                "Garantiza la entrega de paquetes.",
                "Es un protocolo orientado a conexión.",
                "Es un protocolo no orientado a conexión.",
                "Realiza un control de flujo exhaustivo."
            ),
            "Es un protocolo no orientado a conexión."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "2. UDP es conocido por ser:",
            Arrays.asList(
                "Lento pero muy fiable.",
                "Rápido pero no fiable.",
                "Rápido y completamente fiable.",
                "Lento y no fiable."
            ),
            "Rápido pero no fiable."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "3. ¿Qué significa que UDP es \"no fiable\"?",
            Arrays.asList(
                "Los paquetes siempre llegan corruptos.",
                "No garantiza que los paquetes lleguen, ni su orden, ni que no haya duplicados.",
                "Sólo funciona en redes locales.",
                "Requiere una contraseña para enviar datos."
            ),
            "No garantiza que los paquetes lleguen, ni su orden, ni que no haya duplicados."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "4. ¿Para qué tipo de aplicaciones es UDP generalmente más adecuado?",
            Arrays.asList(
                "Transferencia de archivos grandes donde la integridad es crítica.",
                "Streaming de vídeo o juegos en tiempo real donde la velocidad es prioritaria.",
                "Conexiones bancarias seguras.",
                "Navegación web estándar."
            ),
            "Streaming de vídeo o juegos en tiempo real donde la velocidad es prioritaria."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "5. En C# (System.Net.Sockets), ¿qué clase se utiliza principalmente para enviar y recibir datagramas UDP?",
            Arrays.asList(
                "TcpClient",
                "UdpClient",
                "SocketClient",
                "HttpClient"
            ),
            "UdpClient"
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "6. ¿Qué clase representa una dirección IP y un número de puerto en C#?",
            Arrays.asList(
                "NetworkAddress",
                "PortIdentifier",
                "IPEndPoint",
                "HostEntry"
            ),
            "IPEndPoint"
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "7. Cuando se envían datos por UDP, estos se suelen convertir a:",
            Arrays.asList(
                "string",
                "List<char>",
                "byte[]",
                "object"
            ),
            "byte[]"
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "8. Para convertir un string a byte[] en C#, ¿qué se utiliza comúnmente?",
            Arrays.asList(
                "Encoding.Default.GetBytes()",
                "Encoding.UTF8.GetBytes()",
                "StringConverter.ToByteArray()",
                "BitConverter.GetBytes()"
            ),
            "Encoding.UTF8.GetBytes()"
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "9. La operación UdpClient.Receive():",
            Arrays.asList(
                "Es no bloqueante y devuelve null si no hay datos.",
                "Es bloqueante y espera hasta que se reciban datos.",
                "Devuelve true o false indicando si se recibieron datos.",
                "Solo se puede llamar una vez."
            ),
            "Es bloqueante y espera hasta que se reciban datos."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "10. Para evitar que la operación Receive() bloquee el hilo principal de Unity, ¿dónde debería ejecutarse?",
            Arrays.asList(
                "En el método Update().",
                "En una Coroutine.",
                "En un hilo secundario (Thread).",
                "En el método FixedUpdate()."
            ),
            "En un hilo secundario (Thread)."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "11. Si recibes datos en un hilo secundario y necesitas actualizar la UI de Unity, ¿qué debes hacer?",
            Arrays.asList(
                "Actualizar la UI directamente desde el hilo secundario.",
                "Usar PlayerPrefs para comunicar los datos.",
                "Despachar la actualización de la UI al hilo principal de Unity.",
                "Reiniciar la escena."
            ),
            "Despachar la actualización de la UI al hilo principal de Unity."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "12. ¿Qué método de UdpClient se usa para enviar datos?",
            Arrays.asList(
                "Write()",
                "Push()",
                "Send()",
                "Transmit()"
            ),
            "Send()"
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "13. Al crear un UdpClient para escuchar mensajes (servidor), ¿qué se debe especificar en su constructor o mediante Bind()?",
            Arrays.asList(
                "La dirección IP del cliente al que se quiere conectar.",
                "El nombre del host remoto.",
                "El puerto local en el que escuchará.",
                "No se especifica nada, el sistema elige aleatoriamente."
            ),
            "El puerto local en el que escuchará."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "14. ¿Qué es IPAddress.Any?",
            Arrays.asList(
                "Una dirección IP específica de un servidor de Google.",
                "Indica que el socket debe escuchar en cualquier interfaz de red disponible en la máquina.",
                "La dirección de broadcast de la red.",
                "Una dirección IP inválida."
            ),
            "Indica que el socket debe escuchar en cualquier interfaz de red disponible en la máquina."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "15. En el método OnApplicationQuit() de Unity, ¿qué es una buena práctica para los UdpClient y los hilos?",
            Arrays.asList(
                "Dejarlos abiertos para que la próxima vez la aplicación inicie más rápido.",
                "Cerrar el UdpClient y abortar/unir los hilos para liberar recursos.",
                "Guardar el estado del UdpClient en un archivo.",
                "No hacer nada, Unity los gestiona automáticamente."
            ),
            "Cerrar el UdpClient y abortar/unir los hilos para liberar recursos."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "16. ¿UDP soporta el envío de mensajes a múltiples destinatarios a la vez (broadcast/multicast)?",
            Arrays.asList(
                "No, solo permite comunicación punto a punto.",
                "Sí, es una de sus capacidades.",
                "Solo si se usa una librería externa.",
                "Únicamente en modo servidor."
            ),
            "Sí, es una de sus capacidades."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "17. El \"overhead\" (sobrecarga de protocolo) de UDP en comparación con TCP es:",
            Arrays.asList(
                "Mucho mayor.",
                "Ligeramente mayor.",
                "Menor.",
                "Igual."
            ),
            "Menor."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "18. Si se envían tres paquetes UDP (A, B, C) en ese orden, ¿cómo podrían llegar al receptor?",
            Arrays.asList(
                "Siempre A, B, C.",
                "Podrían llegar como B, A, C, o solo A y C, o incluso duplicados.",
                "Siempre llegan en orden inverso: C, B, A.",
                "Si uno se pierde, los demás no llegan."
            ),
            "Podrían llegar como B, A, C, o solo A y C, o incluso duplicados."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "19. Para construir un IPEndPoint, necesitas:",
            Arrays.asList(
                "Solo una dirección IP.",
                "Solo un número de puerto.",
                "Una dirección IP y un número de puerto.",
                "Un nombre de dominio y una subred."
            ),
            "Una dirección IP y un número de puerto."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "20. ¿Cuál es el propósito principal de usar Thread.IsBackground = true; para un hilo de escucha en Unity?",
            Arrays.asList(
                "Para que el hilo tenga mayor prioridad.",
                "Para que el hilo no impida que la aplicación de Unity se cierre.",
                "Para que el hilo se ejecute en el hilo principal.",
                "Para que el hilo consuma menos memoria."
            ),
            "Para que el hilo no impida que la aplicación de Unity se cierre."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "21. La clase ConcurrentQueue<T> es útil en networking con hilos para:",
            Arrays.asList(
                "Enviar datos de forma más rápida.",
                "Asegurar que los paquetes UDP lleguen en orden.",
                "Pasar datos de forma segura entre el hilo de red y el hilo principal de Unity.",
                "Comprimir los datos antes de enviarlos."
            ),
            "Pasar datos de forma segura entre el hilo de red y el hilo principal de Unity."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "22. ¿Qué excepción es común atrapar al trabajar con sockets, por ejemplo, si un puerto ya está en uso?",
            Arrays.asList(
                "NullReferenceException",
                "ArgumentOutOfRangeException",
                "SocketException",
                "FormatException"
            ),
            "SocketException"
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "23. Si creas un UdpClient sin especificar un puerto (new UdpClient()), ¿qué sucede?",
            Arrays.asList(
                "Se produce un error.",
                "Escucha en el puerto UDP por defecto (puerto 0).",
                "El sistema operativo le asigna un puerto local disponible automáticamente, útil para un cliente que solo envía.",
                "Se conecta automáticamente a 127.0.0.1."
            ),
            "El sistema operativo le asigna un puerto local disponible automáticamente, útil para un cliente que solo envía."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "24. ¿Cuál de estos NO es un problema inherente a UDP que debas manejar en tu aplicación si es crítico?",
            Arrays.asList(
                "Pérdida de paquetes.",
                "Entrega de paquetes en desorden.",
                "Duplicación de paquetes.",
                "Conexión inicial lenta debido al handshake."
            ),
            "Conexión inicial lenta debido al handshake."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "25. En un chat UDP simple, ¿quién suele tener un UdpClient escuchando en un puerto conocido?",
            Arrays.asList(
                "Solo los clientes.",
                "El servidor.",
                "Nadie, los puertos se negocian dinámicamente.",
                "Tanto clientes como servidor escuchan en el mismo puerto."
            ),
            "El servidor."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "26. El método listenerThread.Join(500); en StopReceiving() sirve para:",
            Arrays.asList(
                "Iniciar el hilo de escucha.",
                "Esperar un máximo de 500 ms a que el hilo listenerThread termine su ejecución.",
                "Poner el hilo en pausa durante 500 ms.",
                "Unir 500 hilos al listenerThread."
            ),
            "Esperar un máximo de 500 ms a que el hilo listenerThread termine su ejecución."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "27. Para decodificar un byte[] de vuelta a un string usando UTF-8, usarías:",
            Arrays.asList(
                "Encoding.UTF8.GetString(byteArray)",
                "byteArray.ToString(Encoding.UTF8)",
                "System.Convert.ToString(byteArray, Encoding.UTF8)",
                "Encoding.ASCII.GetString(byteArray)"
            ),
            "Encoding.UTF8.GetString(byteArray)"
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "28. ¿Es necesario cerrar explícitamente un UdpClient usando Close()?",
            Arrays.asList(
                "No, el recolector de basura se encarga siempre.",
                "Sí, para liberar los recursos del socket inmediatamente, especialmente en OnApplicationQuit.",
                "Solo si se produjo un error.",
                "Solo en el lado del servidor."
            ),
            "Sí, para liberar los recursos del socket inmediatamente, especialmente en OnApplicationQuit."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "29. ¿Qué información obtienes de IPEndPoint remoteEndPoint después de una llamada exitosa a listener.Receive(ref remoteEndPoint)?",
            Arrays.asList(
                "Solo la dirección IP del remitente.",
                "Solo el puerto del remitente.",
                "La dirección IP y el puerto del remitente del datagrama recibido.",
                "La cantidad de bytes recibidos."
            ),
            "La dirección IP y el puerto del remitente del datagrama recibido."
        ));
        preguntasTestUDP.add(new PreguntaTest(
            "30. Si un cliente UDP envía un mensaje a una IP y puerto donde no hay ningún servidor escuchando:",
            Arrays.asList(
                "El cliente recibirá un error inmediatamente.",
                "El paquete UDP simplemente se descarta; el cliente no recibe una notificación de error por defecto.",
                "El sistema operativo intentará encontrar otro puerto.",
                "Se establecerá una conexión TCP de respaldo."
            ),
            "El paquete UDP simplemente se descarta; el cliente no recibe una notificación de error por defecto."
        ));
    }

    private void cargarEjerciciosUDP() {
        ejerciciosRellenarUDP = new ArrayList<>();
        
        String codigoUDP1 = 
            "// public class MonoBehaviour {} // Simulación para contexto\n" +
            "public class UDPReceptor : MonoBehaviour\n" +
            "{\n" +
            "    public int puertoEscucha = 11000;\n" +
            "    private ________ listener; // 1\n" +
            "    private Thread? listenerThread;\n" +
            "    private bool isRunning = false;\n" +
            "    private readonly ConcurrentQueue<string> mensajesRecibidos = new();\n\n" +
            "    void Start()\n" +
            "    {\n" +
            "        StartReceiving();\n" +
            "    }\n\n" +
            "    void Update()\n" +
            "    {\n" +
            "        while (mensajesRecibidos.________(out string mensaje)) // 2\n" +
            "        {\n" +
            "            // Debug.Log(\"Mensaje UDP Recibido: \" + mensaje);\n" +
            "        }\n" +
            "    }\n\n" +
            "    public void StartReceiving()\n" +
            "    {\n" +
            "        if (isRunning) return;\n" +
            "        try\n" +
            "        {\n" +
            "            listener = new UdpClient(________); // 3\n" +
            "            listenerThread = new Thread(new ThreadStart(ListenForData));\n" +
            "            listenerThread.________ = true; // 4\n" +
            "            isRunning = true;\n" +
            "            listenerThread.Start();\n" +
            "        }\n" +
            "        catch (Exception) { /* Debug.LogError(\"Error: \" + e.Message); */ }\n" +
            "    }\n\n" +
            "    private void ListenForData()\n" +
            "    {\n" +
            "        if (listener == null) return;\n" +
            "        IPEndPoint remoteEndPoint = new IPEndPoint(IPAddress.________, 0); // 5\n" +
            "        while (isRunning)\n" +
            "        {\n" +
            "            try\n" +
            "            {\n" +
            "                byte[] data = listener.________(ref remoteEndPoint); // 6\n" +
            "                string mensaje = Encoding.________.GetString(data); // 7\n" +
            "                mensajesRecibidos.________($\"De {remoteEndPoint}: {mensaje}\"); // 8\n" +
            "            }\n" +
            "            catch (System.Net.Sockets.SocketException) { /* Silencioso si isRunning es falso */ }\n" +
            "            catch (Exception) { /* if(isRunning) Debug.LogError(\"Error: \" + e.Message); */ }\n" +
            "        }\n" +
            "    }\n\n" +
            "    void OnApplicationQuit()\n" +
            "    {\n" +
            "        StopReceiving();\n" +
            "    }\n\n" +
            "    public void StopReceiving()\n" +
            "    {\n" +
            "        isRunning = false;\n" +
            "        if (listenerThread != null && listenerThread.IsAlive)\n" +
            "        {\n" +
            "            listenerThread.Interrupt();\n" +
            "            listenerThread.________(500); // 9\n" +
            "        }\n" +
            "        if (listener != null)\n" +
            "        {\n" +
            "            listener.________(); // 10\n" +
            "            listener = null;\n" +
            "        }\n" +
            "    }\n" +
            "}";
        List<String> sugerenciasUDP1 = Arrays.asList("UdpClient", "TryDequeue", "puertoEscucha", "Any", "Receive", "Join", "Close", "IsBackground", "UTF8", "Enqueue");
        Map<Integer, String> solucionesUDP1 = new HashMap<>();
        solucionesUDP1.put(1, "UdpClient");
        solucionesUDP1.put(2, "TryDequeue");
        solucionesUDP1.put(3, "puertoEscucha");
        solucionesUDP1.put(4, "IsBackground");
        solucionesUDP1.put(5, "Any");
        solucionesUDP1.put(6, "Receive");
        solucionesUDP1.put(7, "UTF8");
        solucionesUDP1.put(8, "Enqueue");
        solucionesUDP1.put(9, "Join");
        solucionesUDP1.put(10, "Close");
        ejerciciosRellenarUDP.add(new EjercicioRellenarCodigo(
            "Ejercicio UDP 1: Receptor UDP (Script UDPReceptor)",
            codigoUDP1,
            sugerenciasUDP1,
            solucionesUDP1
        ));

        String codigoUDP2 =
            "// using System.Net.Sockets;\n" +
            "// using System.Text;\n" +
            "// using System;\n" +
            "// public class MonoBehaviour {} // Simulación para contexto\n" +
            "public class UDPEnviador : MonoBehaviour\n" +
            "{\n" +
            "    public string ipDestino = \"127.0.0.1\";\n" +
            "    public int puertoDestino = 11000;\n" +
            "    private ________? client; // 1 (tipo de la variable)\n\n" +
            "    void Start()\n" +
            "    {\n" +
            "        client = new ________(); // 2 (constructor)\n" +
            "    }\n\n" +
            "    public void EnviarMensaje(string mensaje)\n" +
            "    {\n" +
            "        if (string.IsNullOrEmpty(mensaje) || client == null) return;\n" +
            "        try\n" +
            "        {\n" +
            "            byte[] data = Encoding.________.________(mensaje); // 3 (Encoding) y 4 (Método de Encoding)\n" +
            "            client.________(data, ________, ipDestino, puertoDestino); // 5 (Método Send) y 6 (longitud)\n" +
            "            // Debug.Log($\"Mensaje UDP enviado a {ipDestino}:{puertoDestino}: {mensaje}\");\n" +
            "        }\n" +
            "        catch (Exception) { /* Debug.LogError(\"Error: \" + e.Message); */ }\n" +
            "    }\n\n" +
            "    void OnApplicationQuit()\n" +
            "    {\n" +
            "        if (client != null)\n" +
            "        {\n" +
            "            client.________(); // 7\n" +
            "            client = null;\n" +
            "        }\n" +
            "    }\n" +
            "}";
        List<String> sugerenciasUDP2 = Arrays.asList("UdpClient", "UdpClient", "UTF8", "Send", "Close", "GetBytes", "data.Length");
        Map<Integer, String> solucionesUDP2 = new HashMap<>();
        solucionesUDP2.put(1, "UdpClient");
        solucionesUDP2.put(2, "UdpClient");
        solucionesUDP2.put(3, "UTF8");
        solucionesUDP2.put(4, "GetBytes");
        solucionesUDP2.put(5, "Send");
        solucionesUDP2.put(6, "data.Length");
        solucionesUDP2.put(7, "Close");
        ejerciciosRellenarUDP.add(new EjercicioRellenarCodigo(
            "Ejercicio UDP 2: Enviador UDP (Script UDPEnviador)",
            codigoUDP2,
            sugerenciasUDP2,
            solucionesUDP2
        ));
    }

    private void cargarPreguntasWebSockets() {
        preguntasTestWebSockets = new ArrayList<>();
        preguntasTestWebSockets.add(new PreguntaTest(
            "31. ¿Cuál es una característica principal de WebSockets?",
            Arrays.asList(
                "Comunicación unidireccional del servidor al cliente.",
                "Utiliza el protocolo UDP para mayor velocidad.",
                "Proporciona un canal de comunicación full-duplex sobre una conexión TCP.",
                "No requiere un handshake inicial."
            ),
            "Proporciona un canal de comunicación full-duplex sobre una conexión TCP."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "32. El handshake inicial de una conexión WebSocket se realiza sobre:",
            Arrays.asList("UDP", "ICMP", "HTTP/HTTPS", "FTP"),
            "HTTP/HTTPS"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "33. Una URL de WebSocket no seguro comienza con:",
            Arrays.asList("http://", "ws://", "wss://", "udp://"),
            "ws://"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "34. ¿Qué significa \"full-duplex\" en el contexto de WebSockets?",
            Arrays.asList(
                "Solo el cliente puede enviar datos.",
                "Solo el servidor puede enviar datos.",
                "Tanto el cliente como el servidor pueden enviar y recibir datos simultáneamente e independientemente.",
                "Los datos se envían por duplicado para asegurar la entrega."
            ),
            "Tanto el cliente como el servidor pueden enviar y recibir datos simultáneamente e independientemente."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "35. En C# con .NET, ¿qué clase se utiliza comúnmente para implementar un cliente WebSocket?",
            Arrays.asList("UdpClient", "WebSocketServer", "ClientWebSocket", "HttpListener"),
            "ClientWebSocket"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "36. Para conectar un ClientWebSocket a un servidor, se usa el método:",
            Arrays.asList("OpenAsync()", "ConnectAsync()", "StartConnection()", "InitiateAsync()"),
            "ConnectAsync()"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "37. Los datos enviados a través de WebSockets suelen ser:",
            Arrays.asList(
                "Solo imágenes.",
                "Texto (a menudo JSON) o datos binarios.",
                "Solo archivos XML.",
                "Punteros de memoria."
            ),
            "Texto (a menudo JSON) o datos binarios."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "38. ¿Qué es wss://?",
            Arrays.asList(
                "Una versión más rápida de WebSockets.",
                "WebSockets sobre una conexión segura (TLS).",
                "Un protocolo obsoleto.",
                "WebSockets para comunicación solo local."
            ),
            "WebSockets sobre una conexión segura (TLS)."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "39. En Unity, al usar ClientWebSocket, las operaciones como ConnectAsync, SendAsync, ReceiveAsync son:",
            Arrays.asList(
                "Síncronas y bloqueantes.",
                "Asíncronas y suelen usarse con async/await.",
                "Ejecutadas automáticamente en coroutines.",
                "Solo disponibles en el editor de Unity."
            ),
            "Asíncronas y suelen usarse con async/await."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "40. Si una operación de WebSocket (ej. ReceiveAsync) se completa en un hilo diferente al principal de Unity, ¿cómo debes actualizar la UI?",
            Arrays.asList(
                "Directamente, Unity es thread-safe para la UI.",
                "Usando Invoke() o despachando al hilo principal.",
                "Escribiendo en un static bool y leyéndolo en Update().",
                "Los WebSockets siempre operan en el hilo principal."
            ),
            "Usando Invoke() o despachando al hilo principal."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "41. ¿Qué objeto se utiliza a menudo con ClientWebSocket para permitir la cancelación de operaciones asíncronas?",
            Arrays.asList("Timer", "CancellationTokenSource", "ManualResetEvent", "SemaphoreSlim"),
            "CancellationTokenSource"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "42. El método ClientWebSocket.ReceiveAsync() devuelve un Task<WebSocketReceiveResult>. ¿Qué información importante contiene WebSocketReceiveResult?",
            Arrays.asList(
                "Solo la dirección IP del servidor.",
                "El tipo de mensaje (MessageType), la cantidad de bytes (Count) y si es el final del mensaje (EndOfMessage).",
                "El tiempo que tardó en llegar el mensaje.",
                "Un código de error HTTP."
            ),
            "El tipo de mensaje (MessageType), la cantidad de bytes (Count) y si es el final del mensaje (EndOfMessage)."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "43. ¿Cuál es un estado común de ClientWebSocket.State que indica que la conexión está activa y lista para usarse?",
            Arrays.asList("Connecting", "Open", "Closed", "Listening"),
            "Open"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "44. Para enviar un mensaje de texto usando ClientWebSocket, los datos (string) deben primero convertirse a:",
            Arrays.asList(
                "char[]",
                "ReadOnlyMemory<byte>",
                "ArraySegment<byte> (generalmente a partir de un byte[] codificado en UTF-8).",
                "Un objeto JSON serializado directamente."
            ),
            "ArraySegment<byte> (generalmente a partir de un byte[] codificado en UTF-8)."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "45. ¿Qué librería es popular para WebSockets en Unity, especialmente si se necesita compatibilidad con WebGL o características de servidor?",
            Arrays.asList("Socket.IO for Unity", "WebSocketSharp", "UnityNetworking (HLAPI/LLAPI)", "Photon Unity Networking"),
            "WebSocketSharp" // Aunque NativeWebSocket también es una opción para WebGL, WebSocketSharp es más general.
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "46. Si estás desarrollando un juego para WebGL en Unity y necesitas WebSockets, ¿por qué podrías necesitar una librería específica como NativeWebSocket?",
            Arrays.asList(
                "Porque ClientWebSocket es demasiado lento para WebGL.",
                "Porque los navegadores manejan WebSockets a través de JavaScript APIs, y una librería puede hacer de puente.",
                "Porque WebGL no soporta TCP.",
                "Porque ClientWebSocket solo funciona en Windows."
            ),
            "Porque los navegadores manejan WebSockets a través de JavaScript APIs, y una librería puede hacer de puente."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "47. Al cerrar una conexión WebSocket con ClientWebSocket.CloseAsync(), es bueno especificar:",
            Arrays.asList(
                "Una nueva URL a la que conectarse.",
                "WebSocketCloseStatus y una descripción del motivo.",
                "El tamaño del último paquete enviado.",
                "No se necesita especificar nada."
            ),
            "WebSocketCloseStatus y una descripción del motivo."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "48. ¿Qué indica WebSocketMessageType.Close en un WebSocketReceiveResult?",
            Arrays.asList(
                "Que el cliente debe cerrar la conexión.",
                "Que el servidor ha iniciado el proceso de cierre de la conexión.",
                "Que el buffer de recepción está lleno.",
                "Que se ha producido un error de red."
            ),
            "Que el servidor ha iniciado el proceso de cierre de la conexión."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "49. ¿Los WebSockets son más adecuados que las peticiones HTTP tradicionales para qué tipo de aplicaciones?",
            Arrays.asList(
                "Descarga de archivos estáticos grandes.",
                "Aplicaciones que requieren comunicación bidireccional de baja latencia y en tiempo real.",
                "Formularios web simples.",
                "Blogs con contenido que cambia raramente."
            ),
            "Aplicaciones que requieren comunicación bidireccional de baja latencia y en tiempo real."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "50. La sobrecarga por mensaje en WebSockets, después del handshake inicial, es:",
            Arrays.asList("Muy alta, similar a HTTP.", "Moderada.", "Muy baja.", "Inexistente."),
            "Muy baja."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "51. ¿Puede un servidor WebSocket enviar mensajes a un cliente sin que el cliente los haya solicitado primero (después de la conexión)?",
            Arrays.asList(
                "No, el cliente siempre debe iniciar la comunicación.",
                "Sí, debido a la naturaleza full-duplex.",
                "Solo si es un mensaje de tipo \"ping\".",
                "Solo si el cliente está en modo de escucha pasiva."
            ),
            "Sí, debido a la naturaleza full-duplex."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "52. ¿Qué es ArraySegment<byte> y por qué se usa con WebSockets?",
            Arrays.asList(
                "Es un array de bytes de tamaño fijo; se usa por simplicidad.",
                "Representa una sección de un array de bytes; permite trabajar con partes de un buffer sin copiar, lo cual es eficiente.",
                "Es una forma de comprimir los bytes antes de enviarlos.",
                "Es un tipo especial de string para WebSockets."
            ),
            "Representa una sección de un array de bytes; permite trabajar con partes de un buffer sin copiar, lo cual es eficiente."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "53. Si ClientWebSocket.ConnectAsync() lanza una WebSocketException, ¿qué podría haber ocurrido?",
            Arrays.asList(
                "El mensaje enviado era demasiado largo.",
                "Error al resolver el nombre del host, el servidor no está escuchando o rechazó la conexión.",
                "La conexión se cerró correctamente.",
                "Se recibió un mensaje de tipo binario inesperado."
            ),
            "Error al resolver el nombre del host, el servidor no está escuchando o rechazó la conexión."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "54. ¿Cuál es el propósito de CancellationToken en los métodos Async de ClientWebSocket?",
            Arrays.asList(
                "Contar el número de tokens o mensajes enviados.",
                "Permitir que la operación asíncrona sea cancelada antes de que se complete.",
                "Almacenar credenciales de autenticación.",
                "Definir el tiempo máximo de espera para la conexión."
            ),
            "Permitir que la operación asíncrona sea cancelada antes de que se complete."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "55. Si se utiliza WebSocketSharp, el manejo de mensajes recibidos se hace típicamente a través de:",
            Arrays.asList(
                "Un bucle while con ReceiveAsync.",
                "Eventos como ws.OnMessage += (sender, e) => { ... }.",
                "Métodos Update() y FixedUpdate().",
                "Callbacks pasados directamente al método Send()."
            ),
            "Eventos como ws.OnMessage += (sender, e) => { ... }."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "56. ¿Se pueden enviar datos binarios (como imágenes o datos de juego serializados) a través de WebSockets?",
            Arrays.asList(
                "No, WebSockets solo soporta texto.",
                "Sí, especificando WebSocketMessageType.Binary.",
                "Solo si se convierten primero a Base64 y se envían como texto.",
                "Solo con librerías de terceros muy específicas."
            ),
            "Sí, especificando WebSocketMessageType.Binary."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "57. En un juego multijugador en Unity, ¿para qué se podrían usar los WebSockets?",
            Arrays.asList(
                "Solo para el sistema de login.",
                "Para la sincronización del estado del juego en tiempo real, chat, notificaciones.",
                "Para guardar el progreso del jugador localmente.",
                "Para cargar assets del juego."
            ),
            "Para la sincronización del estado del juego en tiempo real, chat, notificaciones."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "58. El método Dispose() en ClientWebSocket o CancellationTokenSource sirve para:",
            Arrays.asList(
                "Enviar un mensaje de desconexión.",
                "Liberar los recursos no gestionados que utilizan estos objetos.",
                "Pausar la conexión temporalmente.",
                "Reintentar la conexión."
            ),
            "Liberar los recursos no gestionados que utilizan estos objetos."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "59. ¿Qué diferencia principal hay entre UdpClient y ClientWebSocket en términos de fiabilidad?",
            Arrays.asList(
                "Ambos son igual de fiables.",
                "UdpClient es más fiable.",
                "ClientWebSocket (que usa TCP subyacente) es inherentemente más fiable (garantiza entrega y orden).",
                "La fiabilidad depende del mensaje enviado."
            ),
            "ClientWebSocket (que usa TCP subyacente) es inherentemente más fiable (garantiza entrega y orden)."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "60. ¿Qué es un \"ping/pong\" en el contexto de WebSockets?",
            Arrays.asList(
                "Un mini-juego para probar la conexión.",
                "Mensajes de control para mantener viva la conexión y comprobar su estado.",
                "Una forma de enviar datos de alta prioridad.",
                "Un error que ocurre cuando el servidor está sobrecargado."
            ),
            "Mensajes de control para mantener viva la conexión y comprobar su estado."
        ));

        // --- Nuevas 40 preguntas añadidas ---
        preguntasTestWebSockets.add(new PreguntaTest(
            "61. ¿Qué encabezado HTTP es crucial en la solicitud inicial del cliente para indicar que desea actualizar a WebSockets?",
            Arrays.asList(
                "Connection: keep-alive",
                "Upgrade: websocket",
                "Sec-WebSocket-Version: 13",
                "Host: server.example.com"
            ),
            "Upgrade: websocket"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "62. ¿Qué encabezado HTTP debe incluir el servidor en su respuesta para aceptar la actualización a WebSockets?",
            Arrays.asList(
                "Connection: Upgrade",
                "Upgrade: websocket",
                "Sec-WebSocket-Accept: [clave_derivada]",
                "Todos los anteriores"
            ),
            "Todos los anteriores"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "63. ¿Cuál es el propósito principal del encabezado 'Sec-WebSocket-Key' enviado por el cliente?",
            Arrays.asList(
                "Es una clave de encriptación para los datos.",
                "Ayuda al servidor a verificar que entiende el protocolo WebSocket.",
                "Identifica de forma única al cliente.",
                "Especifica la subprotocolo deseado."
            ),
            "Ayuda al servidor a verificar que entiende el protocolo WebSocket."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "64. El valor del encabezado 'Sec-WebSocket-Accept' devuelto por el servidor se deriva de:",
            Arrays.asList(
                "Una cadena aleatoria generada por el servidor.",
                "La concatenación de 'Sec-WebSocket-Key' y un GUID específico del estándar WebSocket, y luego hasheado con SHA-1 y codificado en Base64.",
                "La dirección IP del cliente.",
                "La versión del navegador del cliente."
            ),
            "La concatenación de 'Sec-WebSocket-Key' y un GUID específico del estándar WebSocket, y luego hasheado con SHA-1 y codificado en Base64."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "65. Una vez establecida la conexión WebSocket, ¿cómo se envían los datos?",
            Arrays.asList(
                "Como una serie de peticiones HTTP POST.",
                "A través de 'frames' o tramas binarias.",
                "Como datagramas UDP.",
                "Adjuntos a correos electrónicos."
            ),
            "A través de 'frames' o tramas binarias."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "66. ¿Qué indica el bit 'FIN' en una trama WebSocket?",
            Arrays.asList(
                "Que la conexión debe finalizar.",
                "Que esta es la trama final de un mensaje (que podría estar fragmentado).",
                "Que la trama está corrupta.",
                "Que la trama es de tipo binario."
            ),
            "Que esta es la trama final de un mensaje (que podría estar fragmentado)."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "67. ¿Para qué sirve la fragmentación de mensajes en WebSockets?",
            Arrays.asList(
                "Para encriptar los mensajes.",
                "Para permitir el envío de mensajes grandes sin monopolizar el canal o sin saber el tamaño total de antemano.",
                "Para comprimir los mensajes.",
                "Para enviar mensajes a múltiples destinatarios."
            ),
            "Para permitir el envío de mensajes grandes sin monopolizar el canal o sin saber el tamaño total de antemano."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "68. ¿Qué tipo de trama WebSocket se utiliza para indicar el cierre de la conexión por parte de un extremo?",
            Arrays.asList("Continuación", "Texto", "Binario", "Cierre (Close)"),
            "Cierre (Close)"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "69. ¿Un cliente WebSocket puede especificar subprotocolos preferidos (ej. 'json', 'xml') durante el handshake?",
            Arrays.asList(
                "No, el protocolo es fijo.",
                "Sí, usando el encabezado 'Sec-WebSocket-Protocol'.",
                "Sí, pero solo después de que la conexión esté abierta.",
                "Solo si el servidor lo solicita explícitamente."
            ),
            "Sí, usando el encabezado 'Sec-WebSocket-Protocol'."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "70. Si un servidor soporta uno de los subprotocolos solicitados por el cliente, ¿cómo lo indica?",
            Arrays.asList(
                "Enviando un mensaje de texto con el nombre del protocolo.",
                "Incluyendo el subprotocolo elegido en el encabezado 'Sec-WebSocket-Protocol' de su respuesta.",
                "No necesita indicarlo, el cliente lo asume.",
                "Enviando una trama binaria especial."
            ),
            "Incluyendo el subprotocolo elegido en el encabezado 'Sec-WebSocket-Protocol' de su respuesta."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "71. ¿Qué es una 'extensión' de WebSocket, como 'permessage-deflate'?",
            Arrays.asList(
                "Un nuevo tipo de mensaje.",
                "Un mecanismo para añadir funcionalidades al protocolo base, como la compresión.",
                "Un subprotocolo específico.",
                "Una forma de aumentar el tamaño máximo del mensaje."
            ),
            "Un mecanismo para añadir funcionalidades al protocolo base, como la compresión."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "72. ¿Cuál es el propósito de las tramas Ping y Pong en WebSockets?",
            Arrays.asList(
                "Enviar datos de juego.",
                "Verificar que la conexión sigue viva y medir la latencia.",
                "Negociar la compresión.",
                "Indicar errores en la transmisión."
            ),
            "Verificar que la conexión sigue viva y medir la latencia."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "73. Si un extremo envía una trama Ping, el otro extremo debe responder con una trama:",
            Arrays.asList("Ping", "Pong con los mismos datos de aplicación", "Ack", "Close"),
            "Pong con los mismos datos de aplicación"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "74. ¿Los WebSockets manejan automáticamente la retransmisión de paquetes perdidos?",
            Arrays.asList(
                "Sí, es una característica incorporada.",
                "No, eso es responsabilidad de TCP, que es el protocolo subyacente.",
                "Solo si se utiliza wss://.",
                "Depende de la librería de WebSocket utilizada."
            ),
            "No, eso es responsabilidad de TCP, que es el protocolo subyacente."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "75. ¿Cuál es el tamaño máximo teórico de una trama WebSocket (payload length)?",
            Arrays.asList("1KB", "1MB", "64KB", "2^63 bytes (muy grande)"),
            "2^63 bytes (muy grande)"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "76. En ClientWebSocket, ¿qué propiedad indica el estado actual de la conexión (ej. Open, Closed, Connecting)?",
            Arrays.asList("ConnectionState", "Status", "State", "WebSocketState"),
            "State"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "77. Al usar `ClientWebSocket.ReceiveAsync`, si el buffer proporcionado es más pequeño que el mensaje recibido, ¿qué sucede?",
            Arrays.asList(
                "Se lanza una excepción.",
                "Se reciben múltiples fragmentos, y `EndOfMessage` será `false` hasta el último fragmento.",
                "El mensaje se trunca.",
                "La conexión se cierra."
            ),
            "Se reciben múltiples fragmentos, y `EndOfMessage` será `false` hasta el último fragmento."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "78. ¿Es posible que un servidor WebSocket envíe un mensaje de cierre sin que el cliente lo haya solicitado?",
            Arrays.asList(
                "No, el cierre siempre debe ser iniciado por el cliente.",
                "Sí, el servidor puede iniciar el cierre de la conexión.",
                "Solo si la conexión ha estado inactiva durante mucho tiempo.",
                "Solo si el mensaje es de tipo texto."
            ),
            "Sí, el servidor puede iniciar el cierre de la conexión."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "79. ¿Qué consideración de seguridad es importante al manejar datos recibidos de un WebSocket no confiable?",
            Arrays.asList(
                "Asumir que todos los datos son seguros.",
                "Validar y sanitizar siempre los datos para prevenir ataques XSS u otros.",
                "Deshabilitar JavaScript en el cliente.",
                "Usar solo conexiones ws://."
            ),
            "Validar y sanitizar siempre los datos para prevenir ataques XSS u otros."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "80. ¿Por qué se prefiere WebSockets sobre HTTP Polling para aplicaciones en tiempo real?",
            Arrays.asList(
                "Porque HTTP Polling es más seguro.",
                "WebSockets reduce la latencia y la sobrecarga al mantener una conexión persistente.",
                "WebSockets es más fácil de implementar.",
                "HTTP Polling soporta más tipos de datos."
            ),
            "WebSockets reduce la latencia y la sobrecarga al mantener una conexión persistente."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "81. ¿Qué ocurre si un proxy HTTP intermedio no entiende la solicitud de 'Upgrade' de WebSocket?",
            Arrays.asList(
                "La conexión WebSocket se establece de todas formas.",
                "El proxy podría bloquear la conexión o interferir con ella.",
                "La conexión se degrada automáticamente a HTTP Polling.",
                "El servidor WebSocket negocia directamente con el cliente."
            ),
            "El proxy podría bloquear la conexión o interferir con ella."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "82. ¿WebSocket es un protocolo orientado a mensajes o a stream?",
            Arrays.asList(
                "Orientado a stream como TCP.",
                "Orientado a mensajes (aunque puede fragmentar mensajes grandes).",
                "Híbrido, depende del uso.",
                "Ninguno de los anteriores."
            ),
            "Orientado a mensajes (aunque puede fragmentar mensajes grandes)."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "83. Al implementar un servidor WebSocket, ¿qué es importante gestionar correctamente para evitar fugas de recursos?",
            Arrays.asList(
                "Solo las conexiones entrantes.",
                "El ciclo de vida de cada conexión WebSocket (apertura, mensajes, cierre, errores).",
                "Únicamente los mensajes de texto.",
                "La versión del protocolo."
            ),
            "El ciclo de vida de cada conexión WebSocket (apertura, mensajes, cierre, errores)."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "84. ¿Se pueden enviar encabezados HTTP personalizados una vez que la conexión WebSocket está establecida?",
            Arrays.asList(
                "Sí, con cada mensaje WebSocket.",
                "No, los encabezados HTTP solo se usan durante el handshake inicial.",
                "Solo si el servidor lo permite explícitamente.",
                "Sí, pero solo para mensajes binarios."
            ),
            "No, los encabezados HTTP solo se usan durante el handshake inicial."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "85. En el contexto de WebSockets y Unity, si necesitas que la lógica de red no bloquee el hilo principal, ¿qué patrón es común utilizar con `async/await`?",
            Arrays.asList(
                "Llamar a `Task.Wait()` en el hilo principal.",
                "Ejecutar las operaciones de red directamente en `Update()`.",
                "Utilizar `ConfigureAwait(false)` en las llamadas `await` dentro de la lógica de red para evitar volver al contexto de Unity, y luego despachar las actualizaciones de UI al hilo principal.",
                "Crear un `Thread` separado y usar `Thread.Sleep()`."
            ),
            "Utilizar `ConfigureAwait(false)` en las llamadas `await` dentro de la lógica de red para evitar volver al contexto de Unity, y luego despachar las actualizaciones de UI al hilo principal."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "86. ¿Qué propiedad de `WebSocketReceiveResult` te indica si el mensaje recibido fue de tipo texto, binario o un mensaje de cierre?",
            Arrays.asList("Count", "EndOfMessage", "MessageType", "CloseStatusDescription"),
            "MessageType"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "87. Si `ClientWebSocket.SendAsync` se llama múltiples veces de forma concurrente sin la debida sincronización, ¿qué podría ocurrir?",
            Arrays.asList(
                "Los mensajes se encolan y se envían ordenadamente de forma automática.",
                "Podría lanzar excepciones o corromper los datos enviados, ya que las operaciones de envío en una misma instancia no suelen ser thread-safe para envíos concurrentes.",
                "Se mejora la velocidad de envío.",
                "Solo el primer mensaje se envía."
            ),
            "Podría lanzar excepciones o corromper los datos enviados, ya que las operaciones de envío en una misma instancia no suelen ser thread-safe para envíos concurrentes."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "88. ¿Es `ClientWebSocket` adecuado para implementar un servidor WebSocket?",
            Arrays.asList(
                "Sí, se puede usar para ambos roles.",
                "No, `ClientWebSocket` está diseñado específicamente para el rol de cliente.",
                "Solo si se modifica su código fuente.",
                "Sí, pero con funcionalidad limitada."
            ),
            "No, `ClientWebSocket` está diseñado específicamente para el rol de cliente."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "89. ¿Qué mecanismo utilizan los WebSockets para asegurar que los datos no sean interceptados o modificados en tránsito cuando se usa `wss://`?",
            Arrays.asList("Encriptación propia del protocolo WebSocket.", "TLS (Transport Layer Security), el mismo que HTTPS.", "Compresión de datos.", "Sumas de verificación (checksums) personalizadas."),
            "TLS (Transport Layer Security), el mismo que HTTPS."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "90. Al recibir un mensaje de cierre (`WebSocketMessageType.Close`) del servidor, ¿qué debería hacer el cliente idealmente?",
            Arrays.asList(
                "Ignorar el mensaje y seguir enviando datos.",
                "Confirmar el cierre enviando también una trama de cierre y luego cerrar la conexión.",
                "Cerrar la conexión inmediatamente sin enviar nada.",
                "Intentar reconectar automáticamente."
            ),
            "Confirmar el cierre enviando también una trama de cierre y luego cerrar la conexión."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "91. ¿Cuál es el puerto por defecto para `ws://`?",
            Arrays.asList("8080", "443", "80", "21"),
            "80"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "92. ¿Cuál es el puerto por defecto para `wss://`?",
            Arrays.asList("80", "8443", "443", "22"),
            "443"
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "93. ¿La librería `WebSocketSharp` es una implementación nativa de .NET o una librería de terceros?",
            Arrays.asList(
                "Es parte del framework .NET estándar.",
                "Es una librería de terceros popular para C# que ofrece funcionalidades de cliente y servidor WebSocket.",
                "Es un alias para `System.Net.WebSockets.ClientWebSocket`.",
                "Solo funciona en entornos Mono."
            ),
            "Es una librería de terceros popular para C# que ofrece funcionalidades de cliente y servidor WebSocket."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "94. ¿Qué significa que una trama WebSocket esté 'enmascarada' (masked)?",
            Arrays.asList(
                "Que está encriptada.",
                "Que los datos del payload han sido sometidos a una operación XOR con una clave de enmascaramiento de 32 bits. Es obligatorio para tramas cliente-a-servidor.",
                "Que la trama está oculta para los proxies.",
                "Que la trama es de alta prioridad."
            ),
            "Que los datos del payload han sido sometidos a una operación XOR con una clave de enmascaramiento de 32 bits. Es obligatorio para tramas cliente-a-servidor."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "95. ¿Deben las tramas enviadas del servidor al cliente estar enmascaradas?",
            Arrays.asList(
                "Sí, siempre.",
                "No, nunca deben estar enmascaradas.",
                "Es opcional.",
                "Solo si se usa wss://."
            ),
            "No, nunca deben estar enmascaradas."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "96. ¿Qué sucede si un servidor recibe una trama no enmascarada de un cliente?",
            Arrays.asList(
                "El servidor la procesa normalmente.",
                "El servidor debe cerrar la conexión porque es una violación del protocolo.",
                "El servidor la enmascara y la reenvía.",
                "El servidor solicita al cliente que la reenvíe enmascarada."
            ),
            "El servidor debe cerrar la conexión porque es una violación del protocolo."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "97. Para construir un servidor WebSocket en ASP.NET Core, ¿qué se suele utilizar?",
            Arrays.asList(
                "La clase `HttpListener` directamente.",
                "Middleware de WebSockets integrado en ASP.NET Core.",
                "`ClientWebSocket` configurado en modo escucha.",
                "Servicios WCF con bindings especiales."
            ),
            "Middleware de WebSockets integrado en ASP.NET Core."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "98. En el contexto de `ClientWebSocket`, ¿para qué sirve `DefaultRequestHeaders`?",
            Arrays.asList(
                "Para añadir encabezados a los mensajes WebSocket después de la conexión.",
                "Para añadir encabezados HTTP personalizados a la solicitud de handshake inicial.",
                "Para definir el tipo de contenido de los mensajes.",
                "Para configurar las opciones de encriptación."
            ),
            "Para añadir encabezados HTTP personalizados a la solicitud de handshake inicial."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "99. ¿Los WebSockets son adecuados para transferir archivos muy grandes (varios GB)?",
            Arrays.asList(
                "Sí, son ideales por su baja sobrecarga.",
                "No, protocolos como FTP o HTTP con capacidades de reanudación son generalmente mejores para archivos muy grandes.",
                "Solo si se fragmentan en mensajes de 1KB.",
                "Únicamente sobre conexiones wss://."
            ),
            "No, protocolos como FTP o HTTP con capacidades de reanudación son generalmente mejores para archivos muy grandes."
        ));
        preguntasTestWebSockets.add(new PreguntaTest(
            "100. ¿El cierre de una conexión TCP subyacente implica siempre el cierre limpio de la conexión WebSocket?",
            Arrays.asList(
                "Sí, el WebSocket se cierra limpiamente de forma automática.",
                "No necesariamente. Un cierre abrupto de TCP (ej. por pérdida de red) no es un cierre limpio de WebSocket, que tiene su propio handshake de cierre.",
                "Solo si el cliente inicia el cierre de TCP.",
                "El protocolo WebSocket no depende de TCP para el cierre."
            ),
            "No necesariamente. Un cierre abrupto de TCP (ej. por pérdida de red) no es un cierre limpio de WebSocket, que tiene su propio handshake de cierre."
        ));
    }

    private void cargarEjerciciosWebSockets() {
        ejerciciosRellenarWebSockets = new ArrayList<>();

        String codigoWS1 = 
            "// using System.Net.WebSockets;\n" +
            "// using System.Text;\n" +
            "// using System.Threading;\n" +
            "// using System.Threading.Tasks;\n" +
            "// using System;\n" +
            "// public class MonoBehaviour {} // Simulación para contexto\n" +
            "public class WebSocketClienteSimple // : MonoBehaviour\n" +
            "{\n" +
            "    public string urlServidor = \"ws://localhost:8080\";\n" +
            "    private ClientWebSocket? ________; // 1\n" +
            "    private CancellationTokenSource? ________; // 2\n\n" +
            "    async Task StartAsync()\n" +
            "    {\n" +
            "        await ConectarAServidor();\n" +
            "    }\n\n" +
            "    public async Task ConectarAServidor()\n" +
            "    {\n" +
            "        if (wsClient != null && (wsClient.State == WebSocketState.Open || wsClient.State == WebSocketState.Connecting)) return;\n\n" +
            "        wsClient = new ________(); // 3\n" +
            "        cts = new ________(); // 4\n" +
            "        try\n" +
            "        {\n" +
            "            await wsClient.________(new ________(urlServidor), ________); // 5, 6, 7\n" +
            "            _ = EscucharMensajes();\n" +
            "        }\n" +
            "        catch (Exception) { /* ... */ }\n" +
            "    }\n\n" +
            "    private async Task EscucharMensajes()\n" +
            "    {\n" +
            "        if (wsClient == null || cts == null) return;\n" +
            "        var buffer = new ________[4096]; // 8\n" +
            "        try\n" +
            "        {\n" +
            "            while (wsClient.State == ________ && !cts.IsCancellationRequested) // 9\n" +
            "            {\n" +
            "                ________ result = await wsClient.________(new ________(buffer), cts.Token); // 10, 11, 12\n\n" +
            "                if (result.MessageType == WebSocketMessageType.Close)\n" +
            "                {\n" +
            "                    await wsClient.CloseAsync(________, string.Empty, CancellationToken.None); // 13\n" +
            "                    break;\n" +
            "                }\n" +
            "                else if (result.MessageType == ________) // 14\n" +
            "                {\n" +
            "                    // string mensaje = Encoding.UTF8.GetString(buffer, 0, result.Count);\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "        catch (Exception) { /* ... */ }\n" +
            "    }\n\n" +
            "    public async Task EnviarMensaje(string mensaje)\n" +
            "    {\n" +
            "        if (wsClient == null || wsClient.State != WebSocketState.Open || cts == null) return;\n" +
            "        try\n" +
            "        {\n" +
            "            byte[] data = ________.________(mensaje); // 15, 16\n" +
            "            await wsClient.________(new ArraySegment<byte>(data), WebSocketMessageType.Text, true, cts.Token); // 17\n" +
            "        }\n" +
            "        catch (Exception) { /* ... */ }\n" +
            "    }\n\n" +
            "    async Task StopAsync()\n" +
            "    {\n" +
            "        if (cts != null) { cts.Cancel(); cts.Dispose(); cts = null; }\n" +
            "        if (wsClient != null)\n" +
            "        {\n" +
            "            try \n" +
            "            {\n" +
            "                if (wsClient.State == WebSocketState.Open)\n" +
            "                    await wsClient.CloseAsync(WebSocketCloseStatus.NormalClosure, \"Cerrando\", CancellationToken.None);\n" +
            "            } \n" +
            "            catch (Exception) { /* ... */ }\n" +
            "            wsClient.________();  // 18\n" +
            "            wsClient = null;\n" +
            "        }\n" +
            "    }\n" +
            "}";

        List<String> sugerenciasWS1 = Arrays.asList(
            "wsClient", "ClientWebSocket", "cts", "ConnectAsync", "Uri", "cts.Token", 
            "byte", "WebSocketState.Open", "WebSocketReceiveResult", "ReceiveAsync", 
            "ArraySegment<byte>", "WebSocketMessageType.Text", 
            "WebSocketCloseStatus.NormalClosure", "Encoding.UTF8", "GetBytes", 
            "SendAsync", "Dispose", "CancellationTokenSource"
        );
        Map<Integer, String> solucionesWS1 = new HashMap<>();
        solucionesWS1.put(1, "wsClient");
        solucionesWS1.put(2, "cts");
        solucionesWS1.put(3, "ClientWebSocket");
        solucionesWS1.put(4, "CancellationTokenSource");
        solucionesWS1.put(5, "ConnectAsync");
        solucionesWS1.put(6, "Uri");
        solucionesWS1.put(7, "cts.Token");
        solucionesWS1.put(8, "byte");
        solucionesWS1.put(9, "WebSocketState.Open");
        solucionesWS1.put(10, "WebSocketReceiveResult");
        solucionesWS1.put(11, "ReceiveAsync");
        solucionesWS1.put(12, "ArraySegment<byte>");
        solucionesWS1.put(13, "WebSocketCloseStatus.NormalClosure");
        solucionesWS1.put(14, "WebSocketMessageType.Text");
        solucionesWS1.put(15, "Encoding.UTF8");
        solucionesWS1.put(16, "GetBytes");
        solucionesWS1.put(17, "SendAsync");
        solucionesWS1.put(18, "Dispose");
        ejerciciosRellenarWebSockets.add(new EjercicioRellenarCodigo(
            "Ejercicio WebSocket 1: Cliente WebSocket Simple (Script WebSocketClienteSimple)",
            codigoWS1,
            sugerenciasWS1,
            solucionesWS1
        ));
    }

    public List<PreguntaTest> getPreguntasTest(BloqueTematico bloque) {
        List<PreguntaTest> resultado = new ArrayList<>();
        if (bloque == BloqueTematico.UDP || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(preguntasTestUDP));
        }
        if (bloque == BloqueTematico.WEB_SOCKETS || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(preguntasTestWebSockets));
        }
        Collections.shuffle(resultado);
        return resultado;
    }

    public List<EjercicioRellenarCodigo> getEjerciciosRellenarCodigo(BloqueTematico bloque) {
        List<EjercicioRellenarCodigo> resultado = new ArrayList<>();
        if (bloque == BloqueTematico.UDP || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(ejerciciosRellenarUDP));
        }
        if (bloque == BloqueTematico.WEB_SOCKETS || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(ejerciciosRellenarWebSockets));
        }
        Collections.shuffle(resultado);
        return resultado;
    }
}