
import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
// import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Cliente extends Thread {
    /**
     * Socket utilizado para comunicarse con el servidor.
     */
    private Socket socket;
    /**
     * Stream utilizado para el env�o de objetos al servidor.
     */
    private ObjectOutputStream objectOutputStream;
    /**
     * Stream utilizado para el env�o de objetos al servidor.
     */
    private ObjectInputStream objectInputStream;
    /**
     * Ventana utilizada para la interfaz gr�fica del cliente.
     */
    private final VentanaC ventana;
    /**
     * Identificador �nico del cliente dentro del chat.
     */
    private String identificador;
    /**
     * Variable que determina si el cliente escucha o no al servidor, una vez
     * que se arranca el hilo de comunicaci�n del cliente.
     */
    private boolean escuchando;
    /**
     * Variable que almacena la IP del host en el que se ejecuta el servidor.
     */
    private final String host;
    /**
     * Varable que almacena el puerto por el cual el servidor escucha las conexiones
     * de los diversos clientes.
     */
    private final int puerto;

    /**
     * Constructor de la clase cliente.
     * 
     * @param ventana
     * @param host
     * @param puerto
     * @param nombre
     */
    Cliente(VentanaC ventana, String host, Integer puerto, String nombre) {
        this.ventana = ventana;
        this.host = host;
        this.puerto = puerto;
        this.identificador = nombre;
        escuchando = true;
        this.start();
    }

    /**
     * M�todo run del hilo de comunicaci�n del lado del cliente.
     */
    public void run() {
        try {
            socket = new Socket(host, puerto);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println("Conexion exitosa!!!!");
            this.enviarSolicitudConexion(identificador);
            this.escuchar();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(ventana, "Conexion rehusada, servidor desconocido,\n"
                    + "puede que haya ingresado una ip incorrecta\n"
                    + "o que el servidor no este corriendo.\n"
                    + "Esta aplicacion se cerraro.");
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(ventana, "Conexion rehusada, error de Entrada/Salida,\n"
                    + "puede que haya ingresado una ip o un puerto\n"
                    + "incorrecto, o que el servidor no este corriendo.\n"
                    + "Esta aplicaci�n se cerrar�.");
            System.exit(0);
        }

    }

    /**
     * M�todo que cierra el socket y los streams de comunicaci�n.
     */
    public void desconectar() {
        try {
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
            escuchando = false;
        } catch (Exception e) {
            System.err.println("Error al cerrar los elementos de comunicaci�n del cliente.");
        }
    }

    /**
     * M�todo que envia un determinado mensaje hacia el servidor.
     * 
     * @param cliente_receptor
     * @param mensaje
     */
    public void enviarMensaje(String cliente_receptor, String mensaje) {
        ArrayList<String> lista = new ArrayList<>();
        // tipo
        lista.add("MENSAJE");
        // cliente emisor
        lista.add(identificador);
        // cliente receptor
        lista.add(cliente_receptor);
        // mensaje que se desea transmitir
        lista.add(mensaje);
        try {
            objectOutputStream.writeObject(lista);
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
        }
    }

    /*
     * M�todo que escucha constantemente lo que el servidor dice.
     */
    public void escuchar() {
        try {
            while (escuchando) {
                Object aux = objectInputStream.readObject();
                if (aux != null) {
                    if (aux instanceof ArrayList) {
                        // Si se recibe una LinkedList entonces se procesa
                        ejecutar((ArrayList<String>) aux);
                    } else {
                        System.err.println("Se recibio un Objeto desconocido a travess del socket");
                    }
                } else {
                    System.err.println("Se recibio un null a traves del socket");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ventana, "La comunicacin con el servidor se ha\n"
                    + "perdido, este chat tendra que finalizar");
            System.exit(0);
        }
    }

    /**
     * M�todo que ejecuta una serie de instruccines dependiendo del mensaje que el
     * cliente reciba del servidor.
     * 
     * @param lista
     */
    public void ejecutar(ArrayList<String> lista) {
        // 0 - El primer elemento de la lista es siempre el tipo
        String tipo = lista.get(0);
        switch (tipo) {
            case "CONEXION_ACEPTADA":
                // 1 - Identificador propio del nuevo usuario
                // 2 .. n - Identificadores de los clientes conectados actualmente
                identificador = lista.get(1);
                ventana.sesionIniciada(identificador);
                for (int i = 2; i < lista.size(); i++) {
                    ventana.addContacto(lista.get(i));
                }
                break;
            case "NUEVO_USUARIO_CONECTADO":
                // 1 - Identificador propio del cliente que se acaba de conectar
                ventana.addContacto(lista.get(1));
                break;
            case "USUARIO_DESCONECTADO":
                // 1 - Identificador propio del cliente que se acaba de conectar
                ventana.eliminarContacto(lista.get(1));
                break;
            case "MENSAJE":
                // 1 - Cliente emisor
                // 2 - Cliente receptor
                // 3 - Mensaje
                ventana.addMensaje(lista.get(1), lista.get(3));
                break;

            case "OPERACION":
                multiplicar(lista);
                break;
            case "RESULTADO":
                ventana.addMensaje("el factorial es :", "" + lista.get(1));
            default:
                break;
        }
    }

    /**
     * Al conectarse el cliente debe solicitar al servidor que lo agregue a la
     * lista de clientes, para ello se ejecuta este m�todo.
     * 
     * @param identificador
     */
    private void enviarSolicitudConexion(String identificador) {
        ArrayList<String> lista = new ArrayList<>();
        // tipo
        lista.add("SOLICITUD_CONEXION");
        // cliente solicitante
        lista.add(identificador);
        try {
            objectOutputStream.writeObject(lista);
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
        }
    }

    public void enviarFactorial(String mensaje) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("FACTORIAL");
        lista.add(identificador);
        lista.add(mensaje);
        try {
            objectOutputStream.writeObject(lista);
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");
        }
    }

    private void multiplicar(ArrayList<String> numeros) {
        BigInteger multiplicacion = BigInteger.ONE;
        for (int i = 1; i < numeros.size(); i++) {
            multiplicacion = multiplicacion.multiply(new BigInteger(numeros.get(i)));
        }
        ventana.addMensaje("Mi operacion", multiplicacion.toString());
        regresarOperacion(multiplicacion);
    }

    private void regresarOperacion(BigInteger m) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("OPERACION DEVUELTA");
        lista.add(String.valueOf(m));
        try {
            objectOutputStream.writeObject(lista);
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");
        }
    }

    /**
     * Cuando se cierra una ventana cliente, se debe notificar al servidor que el
     * cliente se ha desconectado para que lo elimine de la lista de clientes y
     * todos los clientes lo eliminen de su lista de contactos.
     */
    void confirmarDesconexion() {
        ArrayList<String> lista = new ArrayList<>();
        // tipo
        lista.add("SOLICITUD_DESCONEXION");
        // cliente solicitante
        lista.add(identificador);
        try {
            objectOutputStream.writeObject(lista);
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
        }
    }

    /**
     * M�todo que retorna el identificador del cliente que es �nico dentro del chat.
     * 
     * @return
     */
    String getIdentificador() {
        return identificador;
    }
}
