/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.s
 */
package GUI.Apartados;

import GUI.Control.ControlGui;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Modelo;
import objetosNegocio.Talla;

/**
 *
 * @author Roberto Pedraza
 *
 * Este es el panel utilizado para agregar un Apartado. Cuando este panel se
 * manda a llamar se muestra en el Frame "FramePrincipal"
 */
public class PanelApartado extends javax.swing.JPanel {

    private Map<Talla, String[]> tallas;

    /**
     * Creates new form PanelApartado
     */
    public PanelApartado() {
        initComponents();
        agregarListener();
        verificarFechas();

        tallas = new HashMap();
    }

    /**
     * Setea las label con las fechas de apartado y tiempo limite de apartado.
     */
    private void verificarFechas() {
        String[] meses = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo",
            "Junio", "Julio", "Augosto", "Septiembre",
            "Octubre", "Noviembre", "Diciembre"};

        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_MONTH);
        String mes = meses[c.get(Calendar.MONTH)];
        int year = c.get(Calendar.YEAR);

        c.add(Calendar.DATE, 30);

        int diaLimite = c.get(Calendar.DAY_OF_MONTH);
        String mesLimite = meses[c.get(Calendar.MONTH)];
        int yearLimite = c.get(Calendar.YEAR);

        labelFechaApartado.setText(dia + " de " + mes + " del " + year);
        labelFechaVencimiento.setText(diaLimite + " de " + mesLimite + " del " + yearLimite);
    }

    /**
     * Agrega una nueva linea a la tabla de datos.
     */
    private void agregarLineaTabla(Talla talla) {
        DefaultTableModel model = (DefaultTableModel) tablaDatos.getModel();

        String modelo = talla.getIdModelo().getNombre();
        String noTalla = talla.getTalla();
        String precio = String.valueOf(talla.getIdModelo().getPrecio());
        String cantidad = String.valueOf(1);
        String total = precio;

        String[] linea = new String[]{modelo, noTalla, precio, cantidad, total};
        model.addRow(linea);

        //Vamos a poner esto en un map para poder recogerlo alrato.
        //Abajo estan los numeros relacionados con la talla.
        String[] datosNumericos = new String[]{String.valueOf(precio), String.valueOf(cantidad)};

        //Y la talla en si.
        tallas.put(talla, datosNumericos);

        calcularPrecioTotal();
    }

    /**
     * Se encarga de los eventos de la celda de cantidad.
     */
    private void agregarListener() {
        tablaDatos.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tme) {
                //Si la columna 3, que es la cantidad fue la que se modifico..
                if (tme.getColumn() == 3) {
                    //Obtenemos el valor en cantidad, que se ubica en la columna 3
                    int cantidad = Integer.parseInt(String.valueOf(tablaDatos.getModel().getValueAt(tme.getFirstRow(), 3)));

                    ControlGui control = new ControlGui();
                    Modelo modelo = control.obtenModelo((String) tablaDatos.getModel().getValueAt(tme.getFirstRow(), 0));
                    Talla tallaSeleccionada = null;
                    
                    for(Talla t : modelo.getTallaList()){
                        if(t.getTalla().equals(String.valueOf(tablaDatos.getModel().getValueAt(tme.getFirstRow(), 1)))){
                            tallaSeleccionada = t;
                            break;
                        }
                    }
                    
                    if(tallaSeleccionada != null){
                        int cantidadInventario = tallaSeleccionada.getInventarioRegular();
                    
                        if(cantidadInventario < cantidad){
                            JOptionPane.showMessageDialog(null, "En el inventario regular solamente hay " + cantidadInventario + " zapatos de\n" +
                                                                "esta talla. Indique un numero menor o igual a la cantidad del inventario.");   
                            return;
                        }
                    }
                    /**
                     * Verifica que la cantidad sea mayor a 1, si no es asi le
                     * dice al usuario que la cantidad debe de ser mayor a uno y
                     * modifica a 1 la cantidad.
                     */
                    if (cantidad < 1) {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser menor que 1");
                        tablaDatos.getModel().setValueAt(1, tme.getFirstRow(), 3);
                        return;
                    }
                    
                    //Obtenemos el precio que se ubica en la columna 2
                    double precio = Double.parseDouble(String.valueOf(tablaDatos.getModel().getValueAt(tme.getFirstRow(), 2)));

                    //Multiplicamos cantidad * precio y se lo seteamos al total, en columna 4
                    tablaDatos.getModel().setValueAt(cantidad * precio, tme.getFirstRow(), 4);

                    Talla talla = (Talla) tallas.keySet().toArray()[tme.getFirstRow()];
                    String[] datosNumericos = new String[]{String.valueOf(precio), String.valueOf(cantidad)};
                    tallas.put(talla, datosNumericos);

                    //Calculamos el precio total de toda la tabla
                    calcularPrecioTotal();
                }
            }
        });
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
            Modelo modelo = gui.obtenModelo(codigoBarras);
            
            if(modelo != null){
                Talla talla = obtenTalla(modelo);
                
                if(talla != null){
                    if(talla.getInventarioRegular() > 0)
                        return talla;
                    else
                        JOptionPane.showMessageDialog(null, "Ya no hay zapatos en existencia de esta talla.");
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Talla obtenTalla(Modelo modelo){
        String talla = JOptionPane.showInputDialog(null, "Indique la talla del producto:");
                
        if(talla != null){
            ControlGui gui = new ControlGui();
            List<Talla> tallas = gui.obtenTallasDeModelo(modelo);
                
            for(Talla t : tallas)
                if(t.getTalla().equalsIgnoreCase(talla))
                    return t;
        }
        
        return null;
    }
    
    /**
     * Calcula el precio total de la tabla y ajusta los labels a como se ocupe.
     */
    private void calcularPrecioTotal() {
        float total = 0;

        for (int row = 0; row < tablaDatos.getRowCount(); row++) {
            total += Float.parseFloat(String.valueOf(tablaDatos.getModel().getValueAt(row, 4)));
        }

        labelPrecioTotal.setText(String.format("%.2f", total).replaceFirst(",", "."));
        labelMinimoAbonar.setText(String.format("%.2f", total * .3).replaceFirst(",", "."));
    }

    /**
     * Regresa la feria.
     *
     * @return
     */
    public String getFeria() {
        float pagoCon = Float.parseFloat(getPagoCon());
        float cantidadAbonada = Float.parseFloat(getCantidadAbonada());

        return String.valueOf(pagoCon - cantidadAbonada);
    }

    /**
     * Regresa la minima cantidad de abono.
     *
     * @return
     */
    public float getCantidadMinimoAbono() {
        return Float.valueOf(labelMinimoAbonar.getText().replaceFirst(",", "."));
    }

    /**
     * Regresa la fecha de inicio del apartado.
     *
     * @return
     */
    public Date getFechaInicio() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }

    /**
     * Regresa la fecha de vencimiento del apartado.
     *
     * @return
     */
    public Date getFechaVencimiento() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 30);

        return c.getTime();
    }

    /**
     * Regresa el total del apartado.
     *
     * @return
     */
    public float getTotal() {
        return Float.parseFloat(labelPrecioTotal.getText());
    }

    /**
     * Regresa cada linea en la tabla mediante una lista de Strings.
     *
     * @return
     */
    public Map getDetallesTabla() {
        return tallas;
    }

    /**
     * Todos los demas setters.
     *
     * @return
     */
    public String getNombreCliente() {
        return textFieldCliente.getText();
    }

    public String getTelefonoCliente() {
        return textFieldTelefono.getText();
    }

    public String getCantidadAbonada() {
        return textFieldCantidarAbonada.getText();
    }

    public String getPagoCon() {
        return textFieldPagoCon.getText();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelNombreVendedor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFieldCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        labelFechaApartado = new javax.swing.JLabel();

        jLabel4 = new javax.swing.JLabel();
        labelFechaVencimiento = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textFieldTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        codigoBarras = new javax.swing.JTextField();
        botonOk = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelMinimoAbonar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textFieldCantidarAbonada = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textFieldPagoCon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        labelPrecioTotal = new javax.swing.JLabel();
        botonRealizarApartado = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        botonCancelar = new javax.swing.JButton();

        jLabel1.setText("Vendedor:");

        labelNombreVendedor.setText("Nombre Del Vendedor");

        jLabel2.setText("Cliente:");

        textFieldCliente.setToolTipText("");

        jLabel3.setText("Dia de realizacion:");

        labelFechaApartado.setText("Fecha de Apartado");

        jLabel4.setText("Fecha de Vencimiento:");

        labelFechaVencimiento.setText("Fecha de Vencimiento");

        jLabel5.setText("Telefono: ");

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Modelo", "Talla", "Precio Unitario", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatos);
        if (tablaDatos.getColumnModel().getColumnCount() > 0) {
            tablaDatos.getColumnModel().getColumn(0).setResizable(false);
            tablaDatos.getColumnModel().getColumn(1).setResizable(false);
        }

        botonOk.setText("OK");
        botonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOkActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Busqueda por codigo de Barras");

        jLabel7.setText("Minimo a Abonar:");

        labelMinimoAbonar.setText("PrecioTotal");

        jLabel8.setText("Cuanto quiere abonar");

        textFieldCantidarAbonada.setToolTipText("");

        jLabel9.setText("Pago con");

        jLabel10.setText("Total:");

        labelPrecioTotal.setText("PrecioTotal");

        botonRealizarApartado.setText("Realizar Apartado");
        botonRealizarApartado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRealizarApartadoActionPerformed(evt);
            }
        });

        jLabel11.setText("Agregar Apartado");

        jLabel12.setText("Detalle de Apartado");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNombreVendedor)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(textFieldTelefono)
                                            .addComponent(textFieldCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                        .addGap(148, 148, 148)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelFechaVencimiento)
                                            .addComponent(labelFechaApartado)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(520, 520, 520)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelPrecioTotal)
                                            .addComponent(labelMinimoAbonar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(9, 9, 9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(codigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel12)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(16, 16, 16)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botonRealizarApartado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldPagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldCantidarAbonada, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelNombreVendedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(labelFechaApartado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelFechaVencimiento)
                    .addComponent(textFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addComponent(jLabel12)
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textFieldCantidarAbonada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldPagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonRealizarApartado)
                            .addComponent(botonCancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPrecioTotal)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(labelMinimoAbonar))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonRealizarApartadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRealizarApartadoActionPerformed
        /**
         * Vamos a checar si alguno de los campos estan vacios.
         */
        if (getNombreCliente().isEmpty() || getTelefonoCliente().isEmpty() || getCantidadAbonada().isEmpty() || getPagoCon().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Uno de los campos esta vacio. Verifique sus datos.");
            return;
        }

        /**
         * Revisando que los textField no sean mas largos que los establecido en
         * la base de datos
         */
        if (getNombreCliente().length() > 70) {
            JOptionPane.showMessageDialog(null, "El nombre del cliente puede tener maximo 70 caracteres");
            return;
        }

        if (getTelefonoCliente().length() > 20) {
            JOptionPane.showMessageDialog(null, "El telefono del cliente puede tener maximo 70 caracteres");
            return;
        }

        /**
         * Ahora checaremos cuanto abono la persona, y si es mayor o igual al
         * minimo por abonar.
         */
        if (Float.valueOf(getCantidadAbonada()) < getCantidadMinimoAbono()) {
            JOptionPane.showMessageDialog(null, "La cantidad que se quiere abonar es menor que la minima aceptada.");
            return;
        }

        if (Float.parseFloat(getPagoCon()) < Float.parseFloat(getCantidadAbonada())) {
            JOptionPane.showMessageDialog(null, "La cantidad con la que pago no puede ser menor a la cantidad abonada.");
            return;
        }

        try {
            ControlGui gui = new ControlGui();

            /**
             * Si se pudo realizar el apartado, entonces entrar a este if.
             */
            if (gui.realizarApartado(this)) {
                //Mostramos la ventana de feria.
                String mensaje = "Favor de regresar " + getFeria() + " al cliente";
                String mensaje2 = "FAVOR DE RECORDAR AL CLIENTE QUE SI NO SE REALIZA UN \nABONO EN X DIAS EL APARTADO SERA CANCELADO";

                //Muestra el mensaje
                JOptionPane.showMessageDialog(null, "El apartado ha sido realizado.\n" + mensaje + "\n" + mensaje2);

                //Nos devolvemos a la pantalla principal.
                getParent().remove(this);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error. " + e.getMessage());
        }
    }//GEN-LAST:event_botonRealizarApartadoActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        getParent().remove(this);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOkActionPerformed
        try {
            Talla talla = buscarModelo(codigoBarras.getText());

            if (talla != null) {
                agregarLineaTabla(talla);
                codigoBarras.setText("");
            }
            else
                JOptionPane.showMessageDialog(null, "No existe un zapato registrado de este modelo con talla especificada");
                    
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo realizar el apartado. " + e.getMessage());
        }
    }//GEN-LAST:event_botonOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonOk;
    private javax.swing.JButton botonRealizarApartado;
    private javax.swing.JTextField codigoBarras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelFechaApartado;
    private javax.swing.JLabel labelFechaVencimiento;
    private javax.swing.JLabel labelMinimoAbonar;
    private javax.swing.JLabel labelNombreVendedor;
    private javax.swing.JLabel labelPrecioTotal;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField textFieldCantidarAbonada;
    private javax.swing.JTextField textFieldCliente;
    private javax.swing.JTextField textFieldPagoCon;
    private javax.swing.JTextField textFieldTelefono;
    // End of variables declaration//GEN-END:variables

}
