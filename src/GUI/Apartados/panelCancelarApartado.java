/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Apartados;

/**
 *
 * @author Roberto Pedraza
 *
 * Al momento de querer cancelar un apartado, 1 o mas paneles de este tipo seran
 * ingresados al Frame "FrameCancelarApartado"
 */
public class panelCancelarApartado extends javax.swing.JPanel {

    /**
     * Creates new form panelCancelarApartado
     */
    public panelCancelarApartado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkBoxApartado = new javax.swing.JCheckBox();
        fechaApartado = new javax.swing.JLabel();
        cantidadAbonadaApartado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        precioTotalApartado = new javax.swing.JLabel();
        botonDetallesApartado = new javax.swing.JButton();

        checkBoxApartado.setText("no. del Apartado");

        fechaApartado.setText("Fecha");

        cantidadAbonadaApartado.setText("Cantidad Abonada");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        precioTotalApartado.setText("Precio total del Apartado");

        botonDetallesApartado.setText("Detalles del Apartado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(checkBoxApartado)
                .addGap(87, 87, 87)
                .addComponent(fechaApartado)
                .addGap(106, 106, 106)
                .addComponent(cantidadAbonadaApartado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(precioTotalApartado)
                .addGap(45, 45, 45)
                .addComponent(botonDetallesApartado)
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxApartado)
                    .addComponent(fechaApartado)
                    .addComponent(cantidadAbonadaApartado)
                    .addComponent(precioTotalApartado)
                    .addComponent(botonDetallesApartado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDetallesApartado;
    private javax.swing.JLabel cantidadAbonadaApartado;
    private javax.swing.JCheckBox checkBoxApartado;
    private javax.swing.JLabel fechaApartado;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel precioTotalApartado;
    // End of variables declaration//GEN-END:variables
}
