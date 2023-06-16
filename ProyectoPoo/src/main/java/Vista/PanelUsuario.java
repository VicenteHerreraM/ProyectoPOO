/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controladores.*;
import Modelos.Usuario;
import Modelos.Diet;
import Modelos.Routine;
import Operaciones.*;
import java.sql.Connection;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class PanelUsuario extends javax.swing.JFrame {

    /**
     * Creates new form PanelControl
     */
    
    public Connection link;
    public ConnectionToDB connection;
    
    public PanelUsuario() {
        initComponents();
        connection = new ConnectionToDB();
        link = connection.getConnection();
        chargeRoutine();
        chargueDiet();

    }

    public void chargeRoutine(){
        ArrayList<Routine>routines=new ArrayList<>();
        RoutineToDB listRoutine = new RoutineToDB();
        routines=listRoutine.ReadRoutines(link);
        cmbRutina.removeAllItems();
        for(int i=0; i < routines.size();i++)
        {
            Routine routine = new Routine(routines.get(i).getIdRoutines(),routines.get(i).getNameRoutines(),routines.get(i).getTypeRoutine());
            cmbRutina.addItem(routine.getNameRoutines());
        }
    }

    public void chargueDiet(){
        ArrayList<Diet>diets=new ArrayList<>();
        DietToDB listDiet = new DietToDB();
        diets=listDiet.ReadDiets(link);
        cmbDieta.removeAllItems();
        for(int i=0; i < diets.size();i++)
        {
            Diet diet = new Diet(diets.get(i).getIdRoutines(),diets.get(i).getNameRoutines(),diets.get(i).getTypeRoutine());
            cmbDieta.addItem(diet.getNameRoutines());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BD = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatosUsuario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtRut = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        LabelNombre = new javax.swing.JLabel();
        LabelRut = new javax.swing.JLabel();
        LabelContrasenia = new javax.swing.JLabel();
        LabelAltura = new javax.swing.JLabel();
        LabelPeso = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        LabelApellido = new javax.swing.JLabel();
        LabelCorreo = new javax.swing.JLabel();
        LabelDieta = new javax.swing.JLabel();
        LabelEdad = new javax.swing.JLabel();
        LabelRutina = new javax.swing.JLabel();
        cmbDieta = new javax.swing.JComboBox<>();
        cmbRutina = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        txtFNacimiento = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDatosUsuario.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        tablaDatosUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Rut", "Nombre", "Apellido", "Altura", "Peso", "Correo", "Edad", "Dieta", "Rutina"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatosUsuario);

        BD.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 490, 380));

        jPanel2.setBackground(new java.awt.Color(22, 36, 71));

        btnModificar.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCrear.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnCrearActionPerformed(evt);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnEliminar.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");

        LabelNombre.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(0, 153, 153));
        LabelNombre.setText("Nombre");

        LabelRut.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        LabelRut.setForeground(new java.awt.Color(0, 153, 153));
        LabelRut.setText("Rut");

        LabelContrasenia.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        LabelContrasenia.setForeground(new java.awt.Color(0, 153, 153));
        LabelContrasenia.setText("Contraseña");

        LabelAltura.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        LabelAltura.setForeground(new java.awt.Color(0, 153, 153));
        LabelAltura.setText("Altura");

        LabelPeso.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        LabelPeso.setForeground(new java.awt.Color(0, 153, 153));
        LabelPeso.setText("Peso");

        LabelApellido.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        LabelApellido.setForeground(new java.awt.Color(0, 153, 153));
        LabelApellido.setText("Apellido");

        LabelCorreo.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        LabelCorreo.setForeground(new java.awt.Color(0, 153, 153));
        LabelCorreo.setText("Correo");

        LabelDieta.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        LabelDieta.setForeground(new java.awt.Color(0, 153, 153));
        LabelDieta.setText("Dieta");

        LabelEdad.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        LabelEdad.setForeground(new java.awt.Color(0, 153, 153));
        LabelEdad.setText("F. Nacimiento");

        LabelRutina.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        LabelRutina.setForeground(new java.awt.Color(0, 153, 153));
        LabelRutina.setText("Rutina");

        btnBuscar.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 0, 51));

        txtFNacimiento.setDateFormatString("yyyy-MM-dd");
        txtFNacimiento.setMaxSelectableDate(new java.util.Date(1262318504000L));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(LabelApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelDieta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelRutina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LabelCorreo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbDieta, 0, 207, Short.MAX_VALUE)
                            .addComponent(cmbRutina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LabelAltura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAltura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(LabelRut)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(LabelContrasenia)
                                                .addGap(142, 142, 142))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(LabelNombre)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtContrasenia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(131, 131, 131))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(LabelEdad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btnCrear)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelRut)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelContrasenia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDieta)
                    .addComponent(cmbDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelRutina)
                    .addComponent(cmbRutina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabelAltura)
                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelPeso)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelEdad)
                    .addComponent(txtFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnCrear)
                        .addGap(32, 32, 32)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar))
                        .addGap(45, 45, 45))))
        );

        BD.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 300, 500));

        jPanel1.setBackground(new java.awt.Color(22, 36, 71));

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        BD.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 60));

        jPanel3.setBackground(new java.awt.Color(22, 36, 71));

        btnCargar.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        btnCargar.setText("Cargar");
        btnCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCargarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnCargar)
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnCargar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        BD.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 490, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {//GEN-FIRST:event_btnCrearActionPerformed
        Usuario consultaUser = new Usuario();
        UserToDB user = new UserToDB();
        Validacion val = new Validacion();
        if(!val.validarRUT(txtRut.getText())){
            if(txtRut.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "INGRESE UN RUT\nINGRESA UN RUT\nejemplo: 11222333-4", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "RUT NO VALIDO\nejemplo: 11222333-4", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(!val.isValidEmail(txtCorreo.getText())) {
            if(txtCorreo.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "INGRESE UN CORREO\nINGRESA UN CORREO", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "EMAIL NO VÁLIDO", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(!val.isName(txtNombre.getText())){
            if(txtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "INGRESE UN NOMBRE", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "NOMBRE NO VÁLIDO", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(!val.isName(txtApellido.getText())){
            if(txtApellido.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "INGRESE UN APELLIDO", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "APELLIDO NO VÁLIDO", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(!val.isStrongPassword(txtContrasenia.getText())){
            if(txtContrasenia.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "INGRESE UNA CONTRASEÑA", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(txtContrasenia.getText().length()<12){
                JOptionPane.showMessageDialog(null, "CONTRASEÑA DEMASIADO CORTA", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtContrasenia.getText().length()>12) {
                JOptionPane.showMessageDialog(null, "CONTRASEÑA DEMASIADO LARGA", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "CONTRASEÑA NO VÁLIDA\nDebe tener letra, número y caracteres especiales", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(val.isDouble(txtPeso.getText())<=0){
            if(txtPeso.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "INGRESE UN PESO", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "PESO NO VÁLIDO\ningrese un peso mayor a 0 y en formato de kg: 11,11 ó 11.11", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(val.isPositiveInteger(txtAltura.getText())<=0){
            if(txtAltura.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "INGRESE UNA ALTURA", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "ALTURA NO VÁLIDA\ningrese una altura mayor a 0 y en formato de cm: 123", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(val.isValidDate(txtFNacimiento.getDate())<16) {
            JOptionPane.showMessageDialog(null, "FECHA NO VÁLIDA\nsólo para mayores de 16 anyos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if(val.validarRUT(txtRut.getText())&&val.isValidEmail(txtCorreo.getText())&&val.isName(txtNombre.getText())&&val.isName(txtApellido.getText())
                &&val.isStrongPassword(txtContrasenia.getText())&&val.isDouble(txtPeso.getText())>0&&val.isPositiveInteger(txtAltura.getText())>0
                &&val.isValidDate(txtFNacimiento.getDate())>15){
            int altura = val.isPositiveInteger(txtAltura.getText());
            double peso = val.isDouble(txtPeso.getText());
            DietToDB diet = new DietToDB();
            RoutineToDB routine = new RoutineToDB();
            Diet dieta = diet.FoundDiet(link, cmbDieta.getSelectedItem().toString());
            Routine rutina = routine.FoundRoutine(link, cmbRutina.getSelectedItem().toString());  
            consultaUser.setName(txtNombre.getText());
            consultaUser.setLastName(txtApellido.getText());
            consultaUser.setMail(txtCorreo.getText());
            consultaUser.setPassword(txtContrasenia.getText());
            consultaUser.setRut(txtRut.getText());
            consultaUser.setHeight(altura);
            consultaUser.setWeight(peso);
            consultaUser.setBirthdate(txtFNacimiento.getDate());
            consultaUser.setTypeDiet(dieta.getIdRoutines());
            consultaUser.setTypeRoutine(rutina.getIdRoutines());
            if(user.CreateUser(link, consultaUser)){
                lblMensaje.setText("Datos Creados!");
                txtRut.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                txtContrasenia.setText("");
                txtCorreo.setText("");
                txtPeso.setText("");
                txtAltura.setText("");
                cmbRutina.removeAllItems();
                cmbDieta.removeAllItems();
                txtFNacimiento.cleanup();
            }else{
                lblMensaje.setText("HA OCURRIDO UN ERROR AL MOMENTO DE CREAR, VALIDE SUS DATOS POR FAVOR");
            }
        }
        
        
        
        
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        //ConnectionToDB connection = new ConnectionToDB();
        //Connection link = connection.getConnection();
        UserToDB user = new UserToDB();
        Usuario consultaUser = new Usuario();
        
        
        consultaUser = user.FoundUser(link, txtRut.getText());
        
        txtRut.setText(consultaUser.getRut());
        txtNombre.setText(consultaUser.getName());
        txtApellido.setText(consultaUser.getLastName());
        txtCorreo.setText(consultaUser.getMail());
        // txtAltura.setText(consultaUser.getHeight());
        //txtPeso.setText(consultaUser.getWeight());
        //txtEdad.setText(consultaUser.getBirthdate());
        
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarMouseClicked
        UserToDB user = new UserToDB();
        
        ArrayList<Usuario>Lista=new ArrayList<Usuario>();
        Lista = user.PrintUsers(link);
        
        Object[] row = {Lista.get(0).getRut(), Lista.get(0).getName(), Lista.get(0).getLastName()};
        DefaultTableModel model = (DefaultTableModel) tablaDatosUsuario.getModel();
        model.insertRow(0, row);
        
        
        
        
    }//GEN-LAST:event_btnCargarMouseClicked

    private void cmbDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDietaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDietaActionPerformed

    private void cmbRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRutinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRutinaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BD;
    private javax.swing.JLabel LabelAltura;
    private javax.swing.JLabel LabelApellido;
    private javax.swing.JLabel LabelContrasenia;
    private javax.swing.JLabel LabelCorreo;
    private javax.swing.JLabel LabelDieta;
    private javax.swing.JLabel LabelEdad;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelPeso;
    private javax.swing.JLabel LabelRut;
    private javax.swing.JLabel LabelRutina;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbDieta;
    private javax.swing.JComboBox<String> cmbRutina;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tablaDatosUsuario;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private com.toedter.calendar.JDateChooser txtFNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
