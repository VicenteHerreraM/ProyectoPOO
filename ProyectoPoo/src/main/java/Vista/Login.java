
package Vista;


public class Login extends javax.swing.JFrame {

    
    
    public Login() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        label1 = new java.awt.Label();
        FondoBase = new javax.swing.JPanel();
        FondoIzquierdo = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botonIngresar = new javax.swing.JButton();
        ingresoUsuario = new javax.swing.JTextField();
        contrasenya = new javax.swing.JPasswordField();
        labelUsuario = new javax.swing.JLabel();
        labelContraseña = new javax.swing.JLabel();
        Mensaje = new javax.swing.JLabel();
        FondoDerecho = new javax.swing.JPanel();

        jPasswordField1.setText("jPasswordField1");

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("BASE"); // NOI18N

        FondoBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FondoIzquierdo.setBackground(new java.awt.Color(204, 204, 204));

        titulo.setFont(new java.awt.Font("Bookman Old Style", 1, 48)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Iniciar Sesión");
        titulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonIngresar.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        botonIngresar.setText("Ingresar");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });

        ingresoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoUsuarioActionPerformed(evt);
            }
        });

        contrasenya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasenyaActionPerformed(evt);
            }
        });

        labelUsuario.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        labelUsuario.setText("Usuario");

        labelContraseña.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        labelContraseña.setText("Contraseña");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(botonIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ingresoUsuario)
                        .addComponent(contrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(labelContraseña)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(labelUsuario)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ingresoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(labelContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(botonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout FondoIzquierdoLayout = new javax.swing.GroupLayout(FondoIzquierdo);
        FondoIzquierdo.setLayout(FondoIzquierdoLayout);
        FondoIzquierdoLayout.setHorizontalGroup(
            FondoIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoIzquierdoLayout.createSequentialGroup()
                .addGroup(FondoIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoIzquierdoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(titulo))
                    .addGroup(FondoIzquierdoLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(FondoIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        FondoIzquierdoLayout.setVerticalGroup(
            FondoIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoIzquierdoLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        FondoBase.add(FondoIzquierdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 520));

        FondoDerecho.setBackground(new java.awt.Color(91, 61, 126));

        javax.swing.GroupLayout FondoDerechoLayout = new javax.swing.GroupLayout(FondoDerecho);
        FondoDerecho.setLayout(FondoDerechoLayout);
        FondoDerechoLayout.setHorizontalGroup(
            FondoDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        FondoDerechoLayout.setVerticalGroup(
            FondoDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        FondoBase.add(FondoDerecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 260, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        if(ingresoUsuario.getText().equals("usuario") && contrasenya.getText().equals("123")){
             System.out.println("Se ha logueado");
            //lblMensaje.setText("se ha logueado datos correctos");
            
            
            this.setVisible(false);
           
           
            
        }else{
            //System.out.println("Incorrecto los datos");
            Mensaje.setText("Datos incorrectos");
        }
        
        
        
        
    }

    private void ingresoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    private void contrasenyaActionPerformed(java.awt.event.ActionEvent evt) {
        
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FondoBase;
    private javax.swing.JPanel FondoDerecho;
    private javax.swing.JPanel FondoIzquierdo;
    private javax.swing.JLabel Mensaje;
    private javax.swing.JButton botonIngresar;
    private javax.swing.JPasswordField contrasenya;
    private javax.swing.JTextField ingresoUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private java.awt.Label label1;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
