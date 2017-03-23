/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Control;

import GUI.Inventario.PanelInventariar;
import GUI.Test.PanelTest;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import negocios.admInventario.FacAdmInventario;
import objetosNegocio.*;
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
    public void agregarAInventario(PanelInventariar panelInventariar) {
        /**
         * PRUEBA PROBADA PROBANDO
         */
        IntAdmInventario admInventario = new FacAdmInventario();
        List<PanelTest> listaPanelTest = panelInventariar.getListaPanelTest();
        PanelTest panelTest = new PanelTest();
        Modelo modelo = new Modelo();
        Talla talla = new Talla();
        List<String> listaCantidades;
        List<String> listaTallas;

        /**
         * Como un PanelInventariar puede contener 1 o mas PanelText, usamos un
         * for para obtener la informacion de cada uno de los PanelTest
         */
        for (int i = 0; i < listaPanelTest.size(); i++) {
            panelTest = listaPanelTest.get(i);
            try {
                modelo.setIdModelo((new Integer(admInventario.obtenListaModelos().size()).toString()));
                modelo.setNombre(panelTest.getModelo());
                modelo.setPrecio(panelTest.getPrecio());
            } catch (Exception e) {
            }

            /**
             * De los PanelTalla que hay dentro de los PanelTest obtenemos la
             * informacion de las tallas y las cantidades que hay de cada talla.
             */
            listaCantidades = panelTest.getPanelTalla().getListaCantidadesTexto();
            listaTallas = panelTest.getPanelTalla().getListaTallasTexto();

            /**
             * Con este for sacamos los datos de las listas y los metemos a un
             * objeto de tipo Talla. El cual despues pasara a ser agregado a la
             * Base de datos.
             */
            for (int j = 0; j < listaCantidades.size(); j++) {
                try {
                    talla.setIdModelo(modelo);
                    talla.setIdTalla((new Integer(admInventario.obtenListaTallas().size()).toString()));
                    talla.setTalla(listaTallas.get(j));
                    talla.setInventarioRegular(new Integer(listaCantidades.get(j)));
                    talla.setInventarioApartado(0);
                    talla.setNoCodigoDeBarras(talla.getIdTalla());
                    admInventario.agregarProductoAInventario(talla);
                } catch (Exception e) {
                }
            }
        }
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
