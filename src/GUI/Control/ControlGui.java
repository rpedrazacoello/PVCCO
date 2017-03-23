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

    public void agregarAInventario(PanelInventariar panelInventariar) {
        List<PanelTest> listaPanelTest = panelInventariar.getListaPanelTest();
        Modelo modelo = new Modelo();
        for (int i = 0; i < listaPanelTest.size(); i++) {
            modelo.setPrecio(listaPanelTest.get(i).getPrecio());
        }  
    }  

    public String obtenModelo(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
