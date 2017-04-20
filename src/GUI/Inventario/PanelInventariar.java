/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Inventario;

import GUI.Control.ControlGui;
import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import objetosNegocio.Modelo;

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
     *
     * Este metodo constructor se van a inventariar modelos que no se encuentran
     * registrados.
     */
    public PanelInventariar() {
        initComponents();
        listaPanelTest.add(new PanelModelo());
        jPanel1.add(listaPanelTest.get(0));

        revalidate();
        repaint();
    }

    /**
     * Este metodo constructor entra en uso cuando se van a inventariar modelos
     * que ya estan registrados. Este recibe la lista de modelos a inventariar y
     * organiza el panel para que la informacion necesaria se encuentre ahi.
     *
     * @param modelos
     */
    public PanelInventariar(List<Modelo> modelos) {
        initComponents();
        
        for (int i = 0; i < modelos.size(); i++) {
            listaPanelTest.add(new PanelModelo());
            listaPanelTest.get(i).setTextFieldModelo(modelos.get(i).getNombre());
            listaPanelTest.get(i).setTextFieldPrecio(Float.toString(modelos.get(i).getPrecio()));
            listaPanelTest.get(i).getTextFieldModelo().setEnabled(false);
            listaPanelTest.get(i).getTextFieldPrecio().setEnabled(false);
            jPanel1.add(listaPanelTest.get(i));
            botonAgregarColumna.setVisible(false);
        }
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);
        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonSiguiente = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        botonAgregarColumna = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(jPanel1);

        titulo.setText("Agregar Nuevo Producto");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Modelo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tallas");

        botonSiguiente.setText("Siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAgregarColumna.setText("+");
        botonAgregarColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarColumnaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonAgregarColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addGap(596, 596, 596))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(426, 426, 426)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(91, 91, 91))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAgregarColumna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarColumnaActionPerformed
        listaPanelTest.add(new PanelModelo());
        jPanel1.add(listaPanelTest.get(listaPanelTest.size() - 1));
        revalidate();
        repaint();
    }//GEN-LAST:event_botonAgregarColumnaActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        FrameValidarInventario validacion = new FrameValidarInventario(listaPanelTest);
        final PanelInventariar panel = this;
        
        validacion.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent we) {}
            public void windowOpened(WindowEvent we) { }
            public void windowClosed(WindowEvent we) {
                if(validacion.getAccion() != null && validacion.getAccion().equalsIgnoreCase("Terminar")){
                    ControlGui control = new ControlGui();
                    System.out.println("Agregando al inventario..");
                    
                    if(control.agregarAInventario(panel)){
                        System.out.println("Realizado");
                        JOptionPane.showMessageDialog(null, "Se ha realizado el agregado al inventario.");
                        
                        Container parent = panel.getParent();
                        parent.remove(panel);
                        parent.repaint();
                    }
                }
            }
            public void windowIconified(WindowEvent we) { }
            public void windowDeiconified(WindowEvent we) { }
            public void windowActivated(WindowEvent we) {}
            public void windowDeactivated(WindowEvent we) {}
        });
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        getParent().remove(this);
        getParent().repaint();
    }//GEN-LAST:event_botonCancelarActionPerformed

    /**
     * Este metodo regresa todos los panelTest que se agregar al Panel.
     *
     * @return List<PanelTest>
     */
    public List<PanelModelo> getListaPanelTest() {
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
    private List<PanelModelo> listaPanelTest = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarColumna;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
