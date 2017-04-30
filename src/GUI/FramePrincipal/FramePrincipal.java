/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FramePrincipal;

import GUI.Apartados.FrameAbonarApartado;
import GUI.Apartados.FrameCancelarApartado;
import GUI.Apartados.PanelApartado;
import GUI.Inventario.FrameEscanearParaInventariar;
import GUI.Inventario.PanelInventariar;
import GUI.Ventas.PanelVentas;
import javax.swing.JPanel;

/**
 *
 * @author Roberto Pedraza
 *
 * Esta es la clase del frame principal, desde este frame se comenzaran todos
 * los procesos del sistema.
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();
        jPanel1.add(new PanelVentas());
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        botonAgregarProducto = new javax.swing.JButton();
        botonRealizarApartado = new javax.swing.JButton();
        botonCancelarApartado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botonAgregarExistente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        botonAbonarApartado = new javax.swing.JButton();
        botonBajaInventario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuItemAgregarProductoNuevo = new javax.swing.JMenuItem();
        menuItemAgregarProductoRegistrado = new javax.swing.JMenuItem();
        menuItemBajaInventario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemAgregarApartado = new javax.swing.JMenuItem();
        menuItemAbonarApartado = new javax.swing.JMenuItem();
        menuItemCancelarApartado = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        botonAgregarProducto.setText("<html> Agregar<br> Producto</html>");
        botonAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarProductoActionPerformed(evt);
            }
        });

        botonRealizarApartado.setText("<html> Realizar<br> Apartado</html>");
        botonRealizarApartado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRealizarApartadoActionPerformed(evt);
            }
        });

        botonCancelarApartado.setText("<html> Cancelar<br> Apartado</html>");
        botonCancelarApartado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarApartadoActionPerformed(evt);
            }
        });

        jLabel1.setText("Inventario");

        botonAgregarExistente.setText("<html> \nAgregar<br>\nExistente\n</html>");
        botonAgregarExistente.setAlignmentX(0.5F);
        botonAgregarExistente.setHideActionText(true);
        botonAgregarExistente.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        botonAgregarExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarExistenteActionPerformed(evt);
            }
        });

        jLabel2.setText("Apartados");

        botonAbonarApartado.setText("<html> Abonar<br> Apartado</html>");
        botonAbonarApartado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbonarApartadoActionPerformed(evt);
            }
        });

        botonBajaInventario.setText("<html> \nBaja<br>\nInventario \n</html>");
        botonBajaInventario.setAlignmentX(0.5F);
        botonBajaInventario.setHideActionText(true);
        botonBajaInventario.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        botonBajaInventario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonBajaInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBajaInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonAgregarExistente)
                    .addComponent(botonAgregarProducto)
                    .addComponent(botonBajaInventario)
                    .addComponent(botonRealizarApartado)
                    .addComponent(botonCancelarApartado, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(botonAbonarApartado)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(botonAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAgregarExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonBajaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonRealizarApartado, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAbonarApartado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCancelarApartado, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel1.setName("panelCosas"); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("Inventario");

        jMenu3.setText("Agregar a Inventario..");

        menuItemAgregarProductoNuevo.setText("Producto Nuevo");
        menuItemAgregarProductoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarProductoNuevoActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemAgregarProductoNuevo);

        menuItemAgregarProductoRegistrado.setText("Producto Registrado");
        menuItemAgregarProductoRegistrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarProductoRegistradoActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemAgregarProductoRegistrado);

        jMenu1.add(jMenu3);

        menuItemBajaInventario.setText("Baja de Inventario");
        menuItemBajaInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBajaInventarioActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemBajaInventario);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Apartado");

        menuItemAgregarApartado.setText("Agregar Apartado");
        menuItemAgregarApartado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarApartadoActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemAgregarApartado);

        menuItemAbonarApartado.setText("Abonar Apartado");
        menuItemAbonarApartado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAbonarApartadoActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemAbonarApartado);

        menuItemCancelarApartado.setText("Cancelar Apartado");
        menuItemCancelarApartado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCancelarApartadoActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemCancelarApartado);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este metodo comienza cuando se le da click a la opcion "Agregar producto
     * nuevo" en la barra de menu. Este metodo se encarga de crear un objeto de
     * tipo PanelInventariar y mostrarlo en pantalla.
     *
     * @param evt
     */
    private void menuItemAgregarProductoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgregarProductoNuevoActionPerformed
        PanelInventariar panelInventariar = new PanelInventariar();
        jPanel1.removeAll();
        jPanel1.add(panelInventariar);
        jPanel1.updateUI();
    }//GEN-LAST:event_menuItemAgregarProductoNuevoActionPerformed

    /**
     * Este metodo entra en accion cuando se le da click a la opcion "Agregar
     * producto registrado" en la barra de menu. Este se enccargara de hacer un
     * Frame para escanear los modelos que se van a agregar al inventario.
     *
     * @param evt
     */
    private void menuItemAgregarProductoRegistradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgregarProductoRegistradoActionPerformed
        FrameEscanearParaInventariar frameEscanearParaInventariar = new FrameEscanearParaInventariar(this);
        frameEscanearParaInventariar.setVisible(true);
    }//GEN-LAST:event_menuItemAgregarProductoRegistradoActionPerformed

    /**
     * Este metodo entra en accion cuando el usuario da click a la opcion
     * "Agregar Apartado" en la barra de menu. Este metodo se encarga de borrar
     * el panel actual que esta en jPanel1 y modificar por un panel del tipo
     * "PanelApartado"
     *
     * @param evt
     */
    private void menuItemAgregarApartadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgregarApartadoActionPerformed
        PanelApartado panelApartado = new PanelApartado();
        jPanel1.removeAll();
        jPanel1.add(panelApartado);
        jPanel1.updateUI();
    }//GEN-LAST:event_menuItemAgregarApartadoActionPerformed

    /**
     * Este metodo entra en accion cuando el usuario da click a la opcion
     * "Abonar apartado" en la barra de menu. Este metodo crecara un framde del
     * tipo "FrameAbonarApartado" y se lo mostrara al usuario.
     *
     * @param evt
     */
    private void menuItemAbonarApartadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAbonarApartadoActionPerformed
        FrameAbonarApartado frameAbonarApartado = new FrameAbonarApartado();
        frameAbonarApartado.setVisible(true);
    }//GEN-LAST:event_menuItemAbonarApartadoActionPerformed

    /**
     * Este metodo entra en accion cuando el usuario desea cancelar apartados
     * que ya esten vencidos. El metodo creara un frame del tipo
     * "FrameCancelarApartado" y se lo mostrara al usuario.
     *
     * @param evt
     */
    private void menuItemCancelarApartadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCancelarApartadoActionPerformed
        FrameCancelarApartado frameCancelarApartado = new FrameCancelarApartado();
        frameCancelarApartado.setVisible(true);
    }//GEN-LAST:event_menuItemCancelarApartadoActionPerformed

    /**
     * Este metodo entra en accion cuando el usuario selecciona la opcion baja a
     * inventario. Este abre un FrameEscanearParaInventariar.
     *
     * @param evt
     */
    private void menuItemBajaInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBajaInventarioActionPerformed
        FrameEscanearParaInventariar frameEscanearParaInventariar = new FrameEscanearParaInventariar(this, "Dar de baja");
        frameEscanearParaInventariar.setVisible(true);
    }//GEN-LAST:event_menuItemBajaInventarioActionPerformed

    private void botonAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarProductoActionPerformed
        menuItemAgregarProductoNuevoActionPerformed(evt);
    }//GEN-LAST:event_botonAgregarProductoActionPerformed

    private void botonAgregarExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarExistenteActionPerformed
        menuItemAgregarProductoRegistradoActionPerformed(evt);
    }//GEN-LAST:event_botonAgregarExistenteActionPerformed

    private void botonBajaInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBajaInventarioActionPerformed
        menuItemBajaInventarioActionPerformed(evt);
    }//GEN-LAST:event_botonBajaInventarioActionPerformed

    private void botonRealizarApartadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRealizarApartadoActionPerformed
        menuItemAgregarApartadoActionPerformed(evt);
    }//GEN-LAST:event_botonRealizarApartadoActionPerformed

    private void botonAbonarApartadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbonarApartadoActionPerformed
        menuItemAbonarApartadoActionPerformed(evt);
    }//GEN-LAST:event_botonAbonarApartadoActionPerformed

    private void botonCancelarApartadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarApartadoActionPerformed
        menuItemCancelarApartadoActionPerformed(evt);
    }//GEN-LAST:event_botonCancelarApartadoActionPerformed

    public void iniciar(){
        setVisible(true);
        requestFocusInWindow();
        
        new Thread(new Runnable(){
            public void run(){
                while(isVisible()){
                    try{
                        repaint();
                        Thread.sleep(10);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    
    /**
     * Regresa el jPanel sobre el cual se ponen otros paneles.
     *
     * @return
     */
    public JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * ATRIBUTOS DE LA CLASE
     *
     *
     *
     *
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAbonarApartado;
    private javax.swing.JButton botonAgregarExistente;
    private javax.swing.JButton botonAgregarProducto;
    private javax.swing.JButton botonBajaInventario;
    private javax.swing.JButton botonCancelarApartado;
    private javax.swing.JButton botonRealizarApartado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem menuItemAbonarApartado;
    private javax.swing.JMenuItem menuItemAgregarApartado;
    private javax.swing.JMenuItem menuItemAgregarProductoNuevo;
    private javax.swing.JMenuItem menuItemAgregarProductoRegistrado;
    private javax.swing.JMenuItem menuItemBajaInventario;
    private javax.swing.JMenuItem menuItemCancelarApartado;
    // End of variables declaration//GEN-END:variables
}
