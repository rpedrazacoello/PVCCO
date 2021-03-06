/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Apartados;

import GUI.Control.ControlGui;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import negocios.admApartados.FacAdmApartados;
import objetosNegocio.Apartado;
import pvcco.interfaces.IntAdmApartados;

/**
 *
 * @author Roberto Pedraza
 *
 * Este es el frame para cancelar un apartado. Dentro de este frame habra 1 o
 * mas paneles del tipo "panelCancelarApartado"
 */
public class FrameCancelarApartado extends javax.swing.JFrame {

    /**
     * Creates new form FrameCancelarApartado
     */
    public FrameCancelarApartado() {
        initComponents();
        setLocationRelativeTo(null);
        
        buscarApartadosVencidos();
    }

    /**
     * Llena el panel con todos los apartados que esten vencidos por su fecha.
     */
    private void buscarApartadosVencidos(){
        try{
            IntAdmApartados adm = new FacAdmApartados();
            
            List<Apartado> listaApartados = adm.obtenApartadosRegistrados();
            
            for(Apartado apartado : listaApartados){
                Date fechaApartado = apartado.getFechaFin();
                System.out.println("Apartado encontrado: " + apartado.getIdApartado() + " % fecha: " + fechaApartado.toString());
                /**
                 * Verifica si el apartado esta vencido.
                 */
                if(fechaApartado.before(Calendar.getInstance().getTime())){
                    panelCancelarApartado panel = new panelCancelarApartado(apartado);

                    panelDatos.add(panel);
                    panelDatos.updateUI();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelDatos = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        botonBaja = new javax.swing.JButton();
        checkBoxSelectTodos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Apartados Vencidos");

        jLabel2.setText("Fecha del Apartado");

        jLabel3.setText("Cantidad Abonada");

        jLabel4.setText("Total");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        panelDatos.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(panelDatos);

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonBaja.setText("Dar de Baja");
        botonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBajaActionPerformed(evt);
            }
        });

        checkBoxSelectTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBoxSelectTodosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkBoxSelectTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2)
                        .addGap(111, 111, 111)
                        .addComponent(jLabel3)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel4)
                        .addGap(0, 229, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addComponent(checkBoxSelectTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonBaja))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxSelectTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBoxSelectTodosMouseClicked
            for(Component c : panelDatos.getComponents())
                ((panelCancelarApartado) c).togglePanel(checkBoxSelectTodos.isSelected());
    }//GEN-LAST:event_checkBoxSelectTodosMouseClicked

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBajaActionPerformed
        try{
            ControlGui gui = new ControlGui();
            
            for(Component c : panelDatos.getComponents()){
                if(c instanceof panelCancelarApartado){
                    panelCancelarApartado panel = (panelCancelarApartado) c;
                    
                    if(panel.estaActivo())
                        gui.cancelarApartado(panel.getApartado());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_botonBajaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBaja;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JCheckBox checkBoxSelectTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelDatos;
    // End of variables declaration//GEN-END:variables
}
