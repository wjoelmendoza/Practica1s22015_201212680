/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/*
* se borraron algunos importo porque no se haran algunas implementaciones desde
* aca
*/
import estructura.ListaDoble;
import estructura.Objeto;
import javax.swing.JPanel;

/**
 *
 * @author walter
 */
class PanelView extends JPanel {
    ListaDoble ld;
    LabelObjeto lblo;
    
    public PanelView(ListaDoble ld){
        //la lineas marcarda con 1 son para que el mouse listener funcione danto clic
        //sobre este panel
        this.setBounds(97, 17, 50, 50);
        this.ld = ld;
    //1 lblo = new LabelObjeto(ld);
    //1 lblo.setIcon(ld.preView().getImagen());
         this.setLayout(null);
    //l blo.addMouseListener(this);
    //1 this.addMouseListener(lblo);
    //1 lblo.setBounds(0, 0, 50, 50);
    //1 add(lblo);
    }
    
    public Objeto getObjeto(){
        
        return ld.extraerElemento();
    }
    
 //eliminado puesto que el key listener no lo aplicare aqui   

}
