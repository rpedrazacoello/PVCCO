/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.d
 */
package GUI.Control;

import GUI.Apartados.PanelApartado;
import GUI.Inventario.PanelInventariar;
import GUI.Inventario.PanelModelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
             * Esto sirve para verificar que los campos no esten vacios. En dado
             * caso de que si esten, no se conectara a la base de datos hasta
             * que se encuentre un modelo que si tenga los datos completos.
             */
            if (!panelTest.getModelo().isEmpty() && !String.valueOf(panelTest.getPrecio()).isEmpty()) {
                modelo.setIdModelo(Integer.toString(admInventario.obtenListaModelos().size()));
                modelo.setNombre(panelTest.getModelo());
                modelo.setPrecio(panelTest.getPrecio());

                /**
                 * De los PanelTalla que hay dentro de los PanelTest obtenemos
                 * la informacion de las tallas y las cantidades que hay de cada
                 * talla.
                 */
                List<String> listaCantidades = panelTest.getPanelTalla().getListaCantidadesTexto();
                List<String> listaTallas = panelTest.getPanelTalla().getListaTallasTexto();

                /**
                 * Igual aqui tenemos que checar que las cantidades de talla y
                 * producto no esten vacios.
                 */
                if (listaCantidades.size() != 0 && listaTallas.size() != 0) {
                    /**
                     * Con este for sacamos los datos de las listas y los
                     * metemos a un objeto de tipo Talla. El cual despues pasara
                     * a ser agregado a la Base de datos.
                     */
                    for (int j = 0; j < listaCantidades.size(); j++) {
                        if (!String.valueOf(listaCantidades.get(j)).isEmpty()) {
                            talla.setIdModelo(modelo);
                            talla.setIdTalla(Integer.toString(admInventario.obtenListaTallas().size()));
                            talla.setTalla(listaTallas.get(j));
                            talla.setInventarioRegular(new Integer(listaCantidades.get(j)));
                            talla.setInventarioApartado(0);
                            talla.setNoCodigoDeBarras(talla.getIdTalla());

                            //Se agrega al inventario la talla.
                            admInventario.agregarProductoAInventario(talla);
                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad no puede estar vacia");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Indique la cantidad de talla y producto");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nombre y precio del modelo no puede estar vacio.");
            }
        }
    }

    /**
     * Realiza un apartado dentro de la base de datos.
     *
     * @param panel
     * @return
     */
    public boolean realizarApartado(PanelApartado panel) {
        try {
            //Creamos la instancia del subsistema.
            IntAdmApartados apartados = new FacAdmApartados();

            //Creamos la base del apartado y lo llenamos de datos basicos.
            Apartado apartado = new Apartado();

            apartado.setEstado('A');
            apartado.setIdUsuario(new Usuario("0"));
            apartado.setFechaInicio(panel.getFechaInicio());
            apartado.setFechaFin(panel.getFechaVencimiento());
            apartado.setIdApartado(String.valueOf(apartados.obtenApartadosRegistrados().size()));

            //Creamos objetos que usaremos despues.
            Map<Talla, String[]> tallas = panel.getDetallesTabla();
            List<TallaApartado> tallasApartadas = new ArrayList();

            //Para cada talla del apartado, vamos a añadirla a una coleccion
            //el cual se le dara al apartado.
            for (Talla t : tallas.keySet()) {
                String[] detalles = tallas.get(t);

                float precio = Float.parseFloat(detalles[0]);
                int cantidad = Integer.parseInt(detalles[1]);

                TallaApartado tallaApartada = new TallaApartado();
                tallaApartada.setIdApartado(apartado);
                tallaApartada.setIdTalla(t);
                tallaApartada.setPrecio(precio);
                tallasApartadas.add(tallaApartada);

                for (int i = 1; i < cantidad; i++) {
                    tallasApartadas.add(tallaApartada);
                }
            }

            apartado.setTallaApartadoCollection(tallasApartadas);
            apartado.setNombreCliente(panel.getNombreCliente());
            apartado.setTelefono(panel.getTelefonoCliente());
            apartado.setPrecioTotal(panel.getTotal());

            //Se agrega a la base de datos.
            apartados.realizarApartado(apartado);

            //Retorna como verdadero.
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar un apartado. " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Abona hacia un apartado.
     *
     * @param apartado
     * @return
     */
    public boolean abonarApartado(Apartado apartado) {
        return false;
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

    /**
     * Regresa la lista de tallas en la base de datos.
     *
     * @return
     */
    public List<Talla> obtenTallas() throws Exception {
        IntAdmInventario inv = new FacAdmInventario();

        return inv.obtenListaTallas();
    }

    /**
     * Este modelo regresa la lista de tallas de un modelo especifico.
     * @param modelo
     * @return lista de tallas.
     */
    public List<Talla> obtenTallasDeModelo(Modelo modelo) {
        try {
            FacAdmInventario admInventario = new FacAdmInventario();
            return admInventario.obtenTallasDeModelo(modelo);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Este metodo actualiza el inventario de una lista de tallas.
     * @param tallas
     * @param bajas
     * @param descripcion 
     */
    public void actualizarInventario(List<Talla> tallas, List<String> bajas, String descripcion) {
        List<Integer> bajasInteger = new ArrayList<>();
        
        for (int i = 0; i < bajas.size(); i++) {
            bajasInteger.add(new Integer(bajas.get(i)));
        }
        
        try {
            IntAdmInventario inv = new FacAdmInventario();
            inv.bajaEnInventario(tallas, bajasInteger, descripcion);
        } catch (Exception e) {
        }

    }
}
