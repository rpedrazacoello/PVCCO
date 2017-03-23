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
import objetosNegocio.*;

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
        List<PanelTest> listaPanelTest = panelInventariar.getListaPanelTest();
        Modelo modelo = new Modelo();
        for (int i = 0; i < listaPanelTest.size(); i++) {
            modelo.setPrecio(listaPanelTest.get(i).getPrecio());
        }
    }

    /**
     * Este metodo se encarga de mandar el nombre de un modelo y recibe el
     * nombre del modelo si este si existe en la base de datos.
     *
     * @param text
     * @return String
     */
    public String obtenModelo(String nombreDelModelo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
