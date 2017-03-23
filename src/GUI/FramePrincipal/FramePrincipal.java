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
import java.awt.Component;

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
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuItemAgregarProductoNuevo = new javax.swing.JMenuItem();
        menuItemAgregarProductoRegistrado = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemAgregarApartado = new javax.swing.JMenuItem();
        menuItemModificarApartado = new javax.swing.JMenuItem();
        menuItemAbonarApartado = new javax.swing.JMenuItem();
        menuItemCancelarApartado = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setName("panelCosas"); // NOI18N
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });
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

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Apartado");

        menuItemAgregarApartado.setText("Agregar Apartado");
        menuItemAgregarApartado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarApartadoActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemAgregarApartado);

        menuItemModificarApartado.setText("Modificar Apartado");
        jMenu2.add(menuItemModificarApartado);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        FrameEscanearParaInventariar frameEscanearParaInventariar = new FrameEscanearParaInventariar();
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

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        requestFocus();
    }//GEN-LAST:event_jPanel1MouseEntered
    
    
    
    /**
     * ATRIBUTOS DE LA CLASE
     *
     *
     *
     *
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuItemAbonarApartado;
    private javax.swing.JMenuItem menuItemAgregarApartado;
    private javax.swing.JMenuItem menuItemAgregarProductoNuevo;
    private javax.swing.JMenuItem menuItemAgregarProductoRegistrado;
    private javax.swing.JMenuItem menuItemCancelarApartado;
    private javax.swing.JMenuItem menuItemModificarApartado;
    // End of variables declaration//GEN-END:variables
}
