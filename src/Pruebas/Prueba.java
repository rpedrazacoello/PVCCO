
package Pruebas;

import GUI.IniciarSesion.FrameIniciarSesion;
import com.alee.laf.WebLookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Raul Karim Sabag Ballesteros
 */
public class Prueba {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                try{
                    //WebLookAndFeel.install();
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new FrameIniciarSesion().setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
