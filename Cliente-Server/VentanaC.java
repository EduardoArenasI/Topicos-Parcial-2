import java.awt.GridLayout;
//import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaC extends javax.swing.JFrame {
    public String mensaje;

    public VentanaC() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String ip_puerto_nombre[] = getIP_Puerto_Nombre();
        String ip = ip_puerto_nombre[0];
        String puerto = ip_puerto_nombre[1];
        String nombre = ip_puerto_nombre[2];
        cliente = new Cliente(this, ip, Integer.valueOf(puerto), nombre);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHistorial = new javax.swing.JTextArea();
        txtMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }

            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 492));

        txtHistorial.setEditable(false);
        txtHistorial.setBackground(new java.awt.Color(204, 0, 204));
        txtHistorial.setColumns(20);
        txtHistorial.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtHistorial.setForeground(new java.awt.Color(0, 0, 0));
        txtHistorial.setLineWrap(true);
        txtHistorial.setRows(5);
        txtHistorial.setDoubleBuffered(true);
        txtHistorial.setDragEnabled(true);
        jScrollPane1.setViewportView(txtHistorial);

        txtMensaje.setBackground(new java.awt.Color(153, 0, 0));
        txtMensaje.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtMensaje.setForeground(new java.awt.Color(0, 0, 0));
        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });

        btnEnviar.setBackground(new java.awt.Color(0, 255, 204));
        btnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnEnviar.setForeground(new java.awt.Color(0, 0, 0));
        btnEnviar.setText("Envie su mensaje");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 436,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(60, 60, 60)
                                                                .addComponent(label2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 254,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(60, Short.MAX_VALUE)))));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31,
                                                        Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(117, 117, 117))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE));

        pack();
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        cliente.confirmarDesconexion();
    }

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtMensaje.getText().equals("1") || txtMensaje.getText().equals("0")) {
            txtHistorial.append("yo: \n�Cual es el factorial de ?" + txtMensaje.getText() + "?\n");
            txtHistorial.append("El factorial es 1\n");
            txtMensaje.setText("");
        } else {
            mensaje = txtMensaje.getText();
            cliente.enviarFactorial(mensaje);
            txtHistorial.append("yo: \n�Cual es el factorial de ?" + mensaje + "?\n");
            txtMensaje.setText("");
        }
        // mensaje=txtMensaje.getText();
        // cliente.enviarMensaje(mensaje);
        // txtHistorial.append("Yo: \n" + mensaje+"\n");
        // txtMensaje.setText("");
    }

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtMensajeKeyTyped(java.awt.event.KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (txtMensaje.getText().length() >= 5) {
            evt.consume();
        } else {
            if (!Character.isDigit(validar))
                ;
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaC().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnEnviar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JTextArea txtHistorial;
    private javax.swing.JTextField txtMensaje;
    private final String DEFAULT_PORT = "1024";
    private final String DEFAULT_IP = "10.0.0.4";
    private final Cliente cliente;

    void addContacto(String contacto) {
    }

    void addMensaje(String emisor, String mensaje2) {

        if (!(cliente.getIdentificador().equals(emisor))) {

            txtHistorial.append(emisor + " \n" + mensaje2 + "\n");
        }
    }

    void sesionIniciada(String identificador) {
        this.setTitle("En L�nea " + identificador);
    }

    private String[] getIP_Puerto_Nombre() {
        String s[] = new String[3];
        s[0] = DEFAULT_IP;
        s[1] = DEFAULT_PORT;
        JTextField ip = new JTextField(18);
        JTextField puerto = new JTextField(20);
        JTextField usuario = new JTextField(20);
        ip.setText(DEFAULT_IP);
        puerto.setText(DEFAULT_PORT);
        usuario.setText("Usuario");
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(3, 2));
        myPanel.add(new JLabel("IP del Servidor:"));
        myPanel.add(ip);
        myPanel.add(new JLabel("Puerto de la conexi�n:"));
        myPanel.add(puerto);
        myPanel.add(new JLabel("Escriba su nombre:"));
        myPanel.add(usuario);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Configuraciones de la comunicaci�n", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            s[0] = ip.getText();
            s[1] = puerto.getText();
            s[2] = usuario.getText();
        } else {
            System.exit(0);
        }
        return s;
    }

    void eliminarContacto(String identificador) {
        return;
    }
}