/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Ventas;

import GUI.Control.ControlGui;
import GUI.ventas.ButtonColumn;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Modelo;
import objetosNegocio.Talla;

/**
 *
 * @author zippy
 */
public class PanelVentas extends javax.swing.JPanel {

    private Map<Talla, String[]> tallas;
    
    /**
     * Creates new form PanelVentas
     */
    public PanelVentas() {
        initComponents();
        llenarDatosIniciales();
        
        tallas = new HashMap();
    }

    private void llenarDatosIniciales(){
        //FECHA//
        Calendar c = Calendar.getInstance();
        
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        
        campoTextoFecha.setText(dia + "/" + month + "/" + year);
        
        //NUMERO DE FOLIO//
        ControlGui gui = new ControlGui();
        campoTextoFolio.setText(String.valueOf(gui.obtenVentas().size()));
    }
    
    
    /**
     * Busca una talla en la base de datos por medio de su codigo de barras, y
     * la regresa.
     *
     * @param codigoBarras El codigo de barras de la talla.
     * @return La talla a regresarse.
     */
    public Talla buscarModelo(String codigoBarras) {
        try {
            ControlGui gui = new ControlGui();
            Modelo modelo = gui.obtenModeloPorCodigoBarras(codigoBarras);
            
            if(modelo != null){
                Talla talla = obtenTalla(modelo);
                
                if(talla != null){
                    if(talla.getInventarioRegular() > 0)
                        return talla;
                    else
                        JOptionPane.showMessageDialog(null, "Ya no hay zapatos en existencia de esta talla.");
                }
            }
            else
                JOptionPane.showMessageDialog(null, "No existe un modelo con el codigo de barras " + codigoBarras);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Talla obtenTalla(Modelo modelo){
        String talla = JOptionPane.showInputDialog(null, "Indique la talla del producto:");
                
        if(talla != null){
            List<Talla> tallas = modelo.getTallaList();
            System.out.println("Buscando tallas del modelo " + modelo.getNombre() + " | Cantidad: " + tallas.size());
            
            for(Talla t : tallas)
                if(t.getTalla().equalsIgnoreCase(talla))
                    return t;
            
            JOptionPane.showMessageDialog(null, "No existe un zapato registrado de este modelo con talla " + talla);
        }
        
        return null;
    }
    
    /**
     * Agrega una nueva linea a la tabla de datos.
     */
    private void agregarLineaTabla(Talla talla) {
        DefaultTableModel model = (DefaultTableModel) tablaVenta.getModel();

        String modelo = talla.getIdModelo().getNombre();
        String noTalla = talla.getTalla();
        String precio = String.valueOf(talla.getIdModelo().getPrecio());
        String cantidad = String.valueOf(1);
        String total = precio;

        String[] linea = new String[]{modelo, noTalla, precio, cantidad, total, "Eliminar"};
        model.addRow(linea);

        Action delete = new AbstractAction() { 
            public void actionPerformed(ActionEvent e) { 
                JTable table = (JTable)e.getSource(); 
                int modelRow = Integer.valueOf( e.getActionCommand() );
                ((DefaultTableModel)table.getModel()).removeRow(modelRow); 
            }
        }; 
        
        ButtonColumn buttonColumn = new ButtonColumn(tablaVenta, delete, model.getColumnCount()-1); buttonColumn.setMnemonic(KeyEvent.VK_D);
        
        //Vamos a poner esto en un map para poder recogerlo alrato.
        //Abajo estan los numeros relacionados con la talla.
        String[] datosNumericos = new String[]{String.valueOf(precio), String.valueOf(cantidad)};
        
        //Y la talla en si.
        tallas.put(talla, datosNumericos);

        calcularPrecioTotal();
    }
    
    /**
     * Calcula el precio total de la tabla y ajusta los labels a como se ocupe.
     */
    private synchronized void calcularPrecioTotal() {
        float total = 0;

        for (int row = 0; row < tablaVenta.getRowCount(); row++) {
            total += Float.parseFloat(String.valueOf(tablaVenta.getModel().getValueAt(row, 4)));
        }

        if(!campoTextoDescuento.getText().isEmpty()){
            try{
                float descuento = Math.abs(Float.parseFloat(campoTextoDescuento.getText()));
                
                if(descuento > 100){
                    descuento = 100;
                    campoTextoDescuento.setText("100");
                }
                
                total-= total * (descuento / 100);
            }catch(Exception e){
                campoTextoDescuento.setText("");
            }
        }
        
        campoTextoTotalVenta.setText(String.format("%.2f", total).replaceFirst(",", "."));
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
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVenta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        campoTextoFolio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoTextoDescuento = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        campoTextoTotalVenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoTextoFecha = new javax.swing.JTextField();
        campoTextoAtendidoPor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoTextoPagoCon = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoTextoCodigoBarras = new javax.swing.JTextField();
        botonBuscarModelo = new javax.swing.JButton();

        jLabel1.setText("Realizar Venta");

        tablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Modelo", "Talla", "Precio Unitario", "Cantidad", "Subtotal", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVenta);

        jLabel3.setText("Folio");

        campoTextoFolio.setEditable(false);
        campoTextoFolio.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Descuento:");

        campoTextoDescuento.setInheritsPopupMenu(true);
        campoTextoDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoTextoDescuentoKeyReleased(evt);
            }
        });

        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/xIcon.png"))); // NOI18N
        botonCancelar.setText("   Cancelar");
        botonCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Venta.png"))); // NOI18N
        botonAceptar.setText("   Realizar Venta");
        botonAceptar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botonAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Total de Venta:");

        campoTextoTotalVenta.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Fecha:");

        campoTextoFecha.setEditable(false);

        campoTextoAtendidoPor.setEditable(false);
        campoTextoAtendidoPor.setText("USUARIO INDEFINIDO");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Atendido Por:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Pago Con:");

        jLabel4.setText("Ingrese el codigo de barras");

        botonBuscarModelo.setText("Buscar");
        botonBuscarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarModeloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(campoTextoCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonBuscarModelo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoTextoFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTextoDescuento)
                                    .addComponent(campoTextoTotalVenta)
                                    .addComponent(campoTextoFecha)
                                    .addComponent(campoTextoAtendidoPor)
                                    .addComponent(campoTextoPagoCon)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botonBuscarModelo)
                                .addComponent(jLabel3)
                                .addComponent(campoTextoFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTextoDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(campoTextoTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTextoPagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTextoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(campoTextoAtendidoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarModeloActionPerformed
        try {
            Talla talla = buscarModelo(campoTextoCodigoBarras.getText());

            if (talla != null) {
                agregarLineaTabla(talla);
                campoTextoCodigoBarras.setText("");
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo realizar el apartado. " + e.getMessage());
        }
    }//GEN-LAST:event_botonBuscarModeloActionPerformed

    private void campoTextoDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoDescuentoKeyReleased
        calcularPrecioTotal();
    }//GEN-LAST:event_campoTextoDescuentoKeyReleased

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        Container parent = getParent();
        parent.remove(this);
        parent.repaint();
    }//GEN-LAST:event_botonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonBuscarModelo;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoTextoAtendidoPor;
    private javax.swing.JTextField campoTextoCodigoBarras;
    private javax.swing.JTextField campoTextoDescuento;
    private javax.swing.JTextField campoTextoFecha;
    private javax.swing.JTextField campoTextoFolio;
    private javax.swing.JTextField campoTextoPagoCon;
    private javax.swing.JTextField campoTextoTotalVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaVenta;
    // End of variables declaration//GEN-END:variables
}
