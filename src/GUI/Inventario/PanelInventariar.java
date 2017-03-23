/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Inventario;

import GUI.Control.ControlGui;
import GUI.Test.PanelTest;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;

/**
 *
 * @author Roberto Pedraza
 *
 * Esta clase contiene la estructura sobre el cual se agregan productos al
 * inventario.
 */
public class PanelInventariar extends javax.swing.JPanel {

    /**
     * Creates new form panelInventariar
     */
    public PanelInventariar() {
        initComponents();
        listaPanelTest.add(new PanelTest());
        jPanel1.add(listaPanelTest.get(0));

        revalidate();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAgregarColumna = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        botonAgregarColumna.setText("Agregar Columna");
        botonAgregarColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarColumnaActionPerformed(evt);
            }
        });

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setLayout(new java.awt.GridLayout(0, 2));
        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(botonAgregarColumna)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                .addComponent(botonAceptar)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonAgregarColumna))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este metodo se encarga de agregar otro PanelTest al panel. Para asi poder
     * agregar al inventario mas productos.
     *
     * @param evt
     */
    private void botonAgregarColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarColumnaActionPerformed
        listaPanelTest.add(new PanelTest());
        jPanel1.add(listaPanelTest.get(listaPanelTest.size() - 1));
        revalidate();
        repaint();
    }//GEN-LAST:event_botonAgregarColumnaActionPerformed

    /**
     * Cuando ya se han escrito todos los productos a inventariar, este metodo
     * es el encargado de procesar que se hara a continuacicon.
     *
     * @param evt
     */
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        try {
            ControlGui control = new ControlGui();
            control.agregarAInventario(this);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    /**
     * Este metodo regresa todos los panelTest que se agregar al Panel.
     *
     * @return List<PanelTest>
     */
    public List<PanelTest> getListaPanelTest() {
        return listaPanelTest;
    }

    /**
     * ATRIBUTOS DE LA CLASE
     *
     *
     *
     *
     *
     */
    private List<PanelTest> listaPanelTest = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAgregarColumna;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
