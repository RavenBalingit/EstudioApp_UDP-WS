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
            "WebSocketSharp"
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