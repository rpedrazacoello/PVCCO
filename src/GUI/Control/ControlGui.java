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
    public boolean agregarAInventario(PanelInventariar panelInventariar){
        try{
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
                    if(panelTest.getPrecio() <= 0){
                        JOptionPane.showMessageDialog(null, "El precio para el modelo: " + panelTest.getModelo()+"\n"+
                                                            "Es negativo, cheque bien los datos.");
                        return false;
                    }
                    
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
                    
                    List<Talla> tallasAgregar = new ArrayList();
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
                                if(Integer.parseInt(listaCantidades.get(j)) > 0){
                                    talla.setIdModelo(modelo);
                                    talla.setIdTalla(Integer.toString(admInventario.obtenListaTallas().size()));
                                    talla.setTalla(listaTallas.get(j));
                                    talla.setInventarioRegular(new Integer(listaCantidades.get(j)));
                                    talla.setInventarioApartado(0);
                                    talla.setNoCodigoDeBarras(talla.getIdTalla());

                                    //Aun no sabemos si los datos son validos.
                                    //A lo ultimo agregarmos todas las tallas creadas al inventario.
                                    tallasAgregar.add(talla);
                                }
                                else if(Integer.parseInt(listaCantidades.get(j)) < 0){
                                    JOptionPane.showMessageDialog(null, "Una de las cantidades es negativa.\n"+
                                                                        "Modelo: " + modelo.getNombre() + "\n");
                                    return false;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "La cantidad no puede estar vacia");
                                return false;
                            }
                        }
                        
                        //Ahora si los agregamos a la base de datos.
                        for(Talla t : tallasAgregar)
                            admInventario.agregarProductoAInventario(t);
                    } else {
                        JOptionPane.showMessageDialog(null, "Indique la cantidad de talla y producto");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre y precio del modelo no puede estar vacio.");
                    return false;
                }
            }
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
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
                System.out.println(cantidad);
                TallaApartado tallaApartada = new TallaApartado();
                tallaApartada.setIdApartado(apartado);
                tallaApartada.setIdTalla(t);
                tallaApartada.setPrecio(precio);
                tallasApartadas.add(tallaApartada);

                for (int i = 0; i < cantidad; i++) {
                    tallasApartadas.add(tallaApartada);
                }
            }

            apartado.setTallaApartadoCollection(tallasApartadas);
            apartado.setNombreCliente(panel.getNombreCliente());
            apartado.setTelefono(panel.getTelefonoCliente());
            apartado.setPrecioTotal(panel.getTotal());

            //Se agrega a la base de datos.
            apartados.realizarApartado(apartado);

            //Abonamos inicial.
            abonarApartado(apartado, Float.parseFloat(panel.getCantidadAbonada()));
            
            //Retorna como verdadero.
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar un apartado. " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean cancelarApartado(Apartado apartado){
        try{
            IntAdmApartados adm = new FacAdmApartados();
            adm.cancelarApartado(apartado);
            
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error." + e.getMessage());
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
    public boolean abonarApartado(Apartado apartado, float cantidadAbonada){
        try{
            IntAdmApartados adm = new FacAdmApartados();
            
            adm.abonarApartado(apartado, cantidadAbonada);
        }catch(Exception e){
            e.printStackTrace();
        }
        
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
                if (modelos.get(i).getNombre().equalsIgnoreCase(modelo)) {
                    return modelos.get(i);
                }
            }
        } catch (Exception e) {
        }

        return null;
    }

    /**
     * Regresa la lista de modelos.
     * @return 
     */
    public List<Modelo> obtenModelos(){
        try{
            IntAdmInventario adm = new FacAdmInventario();
            
            return adm.obtenListaModelos();
        }catch(Exception e){
            e.printStackTrace();
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
    public boolean actualizarInventario(List<Talla> tallas, List<String> bajas, String descripcion) {
        List<Integer> bajasInteger = new ArrayList<>();
        
        try{
        for (int i = 0; i < bajas.size(); i++) {
            int numero = Integer.parseInt(bajas.get(i));
            
            if(numero < 0){
                JOptionPane.showMessageDialog(null, "No se pueden introducir numeros negativos.");
                return false;
            }
            bajasInteger.add(new Integer(bajas.get(i)));
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Solamente se admiten numeros en los campos numericos.");
        }
        
        try {
            IntAdmInventario inv = new FacAdmInventario();
            inv.bajaEnInventario(tallas, bajasInteger, descripcion);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
}
