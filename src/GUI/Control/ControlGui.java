/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Control;

import GUI.Inventario.PanelInventariar;
import GUI.Inventario.PanelModelo;
import java.util.List;
import javax.swing.JOptionPane;
import negocios.admApartados.FacAdmApartados;
import negocios.admInventario.FacAdmInventario;
import objetosNegocio.*;
import pvcco.interfaces.IntAdmApartados;
import pvcco.interfaces.IntAdmInventario;

/**
 *
 * @author Roberto Pedraza
 */
public class ControlGui {

    /**
     * Este metodo se encargara de recibir un panel del tipo "PanelInventariar"
     * con todos los datos que se van a agregar a la base de datos, para
     * procesarlos y poder mandarlos hacia la base de datos.
     *
     * @param panelInventariar
     */
    public void agregarAInventario(PanelInventariar panelInventariar) throws Exception {
        /**
         * PRUEBA PROBADA PROBANDO
         */
        IntAdmInventario admInventario = new FacAdmInventario();
        List<PanelModelo> listaPanelTest = panelInventariar.getListaPanelTest();

        /**
         * Como un PanelInventariar puede contener 1 o mas PanelText, usamos un
         * for para obtener la informacion de cada uno de los PanelTest
         */
        for (int i = 0; i < listaPanelTest.size(); i++) {
            PanelModelo panelTest = listaPanelTest.get(i);
            Modelo modelo = new Modelo();
            Talla talla = new Talla();
            
            /**
             * Esto sirve para verificar que los campos no esten vacios. En dado caso de que si esten,
             * no se conectara a la base de datos hasta que se encuentre un modelo que si tenga los
             * datos completos.
             */
            if(!panelTest.getModelo().isEmpty() && !String.valueOf(panelTest.getPrecio()).isEmpty()){
                modelo.setIdModelo(Integer.toString(admInventario.obtenListaModelos().size()));
                modelo.setNombre(panelTest.getModelo());
                modelo.setPrecio(panelTest.getPrecio());

                /**
                 * De los PanelTalla que hay dentro de los PanelTest obtenemos la
                 * informacion de las tallas y las cantidades que hay de cada talla.
                 */
                List<String> listaCantidades = panelTest.getPanelTalla().getListaCantidadesTexto();
                List<String> listaTallas = panelTest.getPanelTalla().getListaTallasTexto();

                /**
                 * Igual aqui tenemos que checar que las cantidades de talla y producto no esten
                 * vacios.
                 */
                if(listaCantidades.size() != 0 && listaTallas.size() != 0){
                    /**
                     * Con este for sacamos los datos de las listas y los metemos a un
                     * objeto de tipo Talla. El cual despues pasara a ser agregado a la
                     * Base de datos.
                     */
                    for (int j = 0; j < listaCantidades.size(); j++) {
                        if(!String.valueOf(listaCantidades.get(j)).isEmpty()){
                            talla.setIdModelo(modelo);
                            talla.setIdTalla(Integer.toString(admInventario.obtenListaTallas().size()));
                            talla.setTalla(listaTallas.get(j));
                            talla.setInventarioRegular(new Integer(listaCantidades.get(j)));
                            talla.setInventarioApartado(0);
                            talla.setNoCodigoDeBarras(talla.getIdTalla());

                            //Se agrega al inventario la talla.
                            admInventario.agregarProductoAInventario(talla);
                        }
                        else
                            JOptionPane.showMessageDialog(null, "La cantidad no puede estar vacia");
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Indique la cantidad de talla y producto");
            }
            else
                JOptionPane.showMessageDialog(null, "El nombre y precio del modelo no puede estar vacio.");
        }
    }

    public void AgregarApartado(Apartado apartado) throws Exception{
        IntAdmApartados apartados = new FacAdmApartados();
    }
    
    /**
     * Este metodo recibe el nombre de un modelo, el metodo lo busca en la base
     * de datos y si el modelo con ese nombre existe, regresa el modelo. Si no
     * existe regresa null.
     *
     * @param modelo
     * @return
     */
    public Modelo obtenModelo(String modelo) {
        List<Modelo> modelos;
        FacAdmInventario admInventario = new FacAdmInventario();

        try {
            modelos = admInventario.obtenListaModelos();
            for (int i = 0; i < modelos.size(); i++) {
                if (modelos.get(i).getNombre().equals(modelo)) {
                    return modelos.get(i);
                }
            }
        } catch (Exception e) {
        }

        return null;
    }

}
