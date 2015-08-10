/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import constantes.EConstantes;
import estructura.genericas.NodoLD;
import graphViz.GraphViz;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author walter
 */
public class ListaDoble {
    private NodoLD<Objeto> origen, fin;
    private int size, suelo,heroe,castillo,goomba,koopa,pared,ficha,hongo, y;
    private GraphViz gv;
    private boolean cola;
    
    public ListaDoble(){
        origen = fin = null;
        castillo = heroe = suelo = size = 0;
        goomba = koopa = pared= ficha = hongo =0;
    }
    
    /**
     * Este metodo agrega a la lista doblemente enlazada siempre al final de esta
     * @param elemento 
     */
    public void agregar(Objeto elemento){
        size++;
        conteoTipo(elemento.tipo,1);
        NodoLD<Objeto>  aux = new NodoLD<>(elemento);
        
        if(!vacia()){
            fin.setSiguiente(aux);
            aux.setAnterior(fin);
            fin = aux;
        }else{
            origen = fin = aux;
        }
    }
    
    /**
     * modifica el elemento basandose en la posicion, asignandole el nuevo nombre
     * @param index posicion del elemento
     * @param nombre nuevo dato que se le asignara en el atributo nombre al objeto
     */
    public void modificar(int index,String nombre){
        NodoLD<Objeto> aux = origen;
        for(int i =0; i!= index; i++)
            aux = aux.getSiguiente();
        
        aux.getElemento().setNombre(nombre);
            
    }
    
    /**
     * elimina el elemento segun la posicion en la que se encuentra
     * @param index es la posicion del elemento a eliminar
     */
    public void eliminar(int index){
        
        int i=0;
        NodoLD<Objeto> aux = origen , aux1;
        while(index != i){
            i++;
            aux = aux.getSiguiente();
        }
        
        conteoTipo(aux.getElemento().tipo, -1);
        if(aux.getSiguiente()!= null && aux.getAnterior()!=null){
            
            aux1 = aux.getSiguiente();
            aux.getAnterior().setSiguiente(aux1);
            aux1.setAnterior(aux.getAnterior());
        }else if(aux.getAnterior()==null && aux.getSiguiente()!=null){
            aux1 = aux.getSiguiente();
            aux1.setAnterior(null);
            aux.setSiguiente(null);
            origen = aux1;
        }else if(aux.getSiguiente()==null&&aux.getAnterior()!=null){
            aux1 = aux.getAnterior();
            aux1.setSiguiente(null);
            aux.setAnterior(null);
            fin = aux1;
        }else if(aux.getAnterior()==null && aux.getSiguiente()==null)
            fin = origen = null;
        
    }
    
    /**
     * METODO AUXILIAR
     * Este metodo es el encargado de incrementar o decrementar la cantidad
     * de tipos de objeto que ingresan a la lista segun el paramentro de entrada
     * e y su valor n
     * @param e este el tipo correspondiente al objeto que esta ingresantdo
     * @param n es la cantidad de objeto que esta ingresanto si n es positivo se
     * incrementa y si n es negativo decrementa
     */
    private void conteoTipo(EConstantes e,int n){
        if(e == EConstantes.CASTILLO){
            castillo += n;
        }else if(e == EConstantes.FICHA){
            ficha += n;
        }else if(e == EConstantes.GOOMBA){
            goomba += n;
        }else if(e == EConstantes.HEROE){
            heroe += n;
        }else if(e == EConstantes.HONGO){
            hongo += n;
        }else if(e == EConstantes.KOOPA){
            koopa += n;
        }else if(e==EConstantes.PARED){
            pared += n;
        }else if(e == EConstantes.SUELO){
            suelo +=n;
        }else{
            System.out.println("tipo no identificando");
        }
        
    }
    
    /**
     * Este metodo es utilizado para verificar si la lista esta vacia
     * @return true si y solo si no existen elementos en la lista
     */
    public boolean vacia(){
        return origen == null;
    }
    
    /**
     * Este metodo es utilizado para generar el reporte utilizando el programa
     * para graficacion GraphViz 2.38
     */
    public void grafica(){
        if(!vacia()){
            int i =0;
            gv = new GraphViz();
            gv.addln(gv.start_graph());
            gv.addln("rankdir = LR;");
            NodoLD<Objeto> aux = origen;

            while(aux != null){
                gv.addln("n"+i+"[ label= \""+aux.getElemento().getNombre()+"\n" + aux.getElemento().getTipo()+"\"];");
                aux = aux.getSiguiente();
                i++;
            }
            i=1;
            aux = origen.getSiguiente();
            //System.out.print("n0");
            gv.add("n0");
            while(aux != null){
               // System.out.print("->n" + i);
                gv.add("->n"+i);
                i++;
                aux = aux.getSiguiente();
                
            }
            //System.out.print(";\n");
            gv.add(";\n");
            i--;
            
            while(i>0){
                gv.add("n"+i+"->");
               // System.out.print("n"+i+"->");
                i--;
            }
           // System.out.println("n0;");
            gv.add("n0;\n");
            gv.addln(gv.end_graph());
            
            File ext = new File("listaDoble.png");
            
            gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), "png"), ext);
            
        }else
            System.out.println("no existe ningun elemento que graficar");
    }
    
    /**
     * Este metodo es utilizado para poder mostrar los elementos de la lista en el
     * panel que esta recibiendo como parametro
     * @param jpanel 
     */
    public void mostrarObj(JPanel jpanel){
       // GridBagLayout def = new GridBagLayout();
        //def.
        
        jpanel.setLayout(new GridBagLayout());
        //int y = 0;
        y=0;
        GridBagConstraints ct = new GridBagConstraints();
        NodoLD<Objeto> aux = origen;

        if(aux!=null){
            while(aux != null){
                JLabel index = new JLabel();
                index.setText("" + y);
                JLabel img = new JLabel();
                img.setIcon(new ImageIcon(getClass().getResource(aux.getElemento().getImagen())));
                img.setSize(200, 200);
                
                JTextField txtNombre = new JTextField();
                txtNombre.setSize(125, 50);
                txtNombre.setText(aux.getElemento().getNombre());
                JButton btnModificar = new JButton("Modificar");
                
                btnModificar.addActionListener((ActionEvent e) -> {
                    if(!txtNombre.getText().isEmpty()){
                        modificar(Integer.parseInt(index.getText()),txtNombre.getText());
                    }else
                        JOptionPane.showMessageDialog(null , "Verifique que los nombre no esten vacios",
                                "Error", JOptionPane.ERROR_MESSAGE);
                });
                
                JButton btnEliminar = new JButton("Eliminar");
                btnEliminar.addActionListener((ActionEvent e) -> {
                    System.out.println(index.getText());
                    eliminar(Integer.parseInt(index.getText()));
                    jpanel.removeAll();
                    mostrarObj(jpanel);
                    //jpanel.validate();
                    jpanel.updateUI();
                    //jpanel.repaint();
                });
                
                
                ct.ipady = 10;
                ct.gridx=0;
                ct.gridy=y;
                jpanel.add(img,ct);
                
                ct.gridx = 1;
                ct.fill = GridBagConstraints.HORIZONTAL;
                jpanel.add(txtNombre,ct);
                
                ct.gridx=2;
                ct.fill = GridBagConstraints.NONE;
                jpanel.add(btnModificar,ct);
                
                ct.gridx =3;        
                jpanel.add(btnEliminar,ct);
                aux = aux.getSiguiente();
                y++;
            }
        }
    }
    
    /**
     * El parametro recibido determina el comportamiento de extraccion
     * @param cola si el valor es true la lista se convierte en una cola 
     * si es false la lista se convierte en una pila
     */
    public void setComportamiento(boolean cola){
        this.cola = cola;
    }
    
    /**
     *  el valor de retorno esta directamente relacionado con el valor de la
     * variable booleana cola si esta esta es true
     * @return el ultimo elemento de la lista sino el primero 
     * siempre y cuando la lista no este vacia
     * 
     */
    public Objeto extraerElemento(){
        NodoLD<Objeto> aux;
        if(cola && !vacia()){
            size--;
            aux = origen;
            if(aux.getSiguiente()!= null){
                origen = aux.getSiguiente();
                
                origen.setAnterior(null);
                aux.setSiguiente(null);
            }else
                fin=origen=null;
            conteoTipo(aux.getElemento().tipo, -1);
            return aux.getElemento();
            
        }else if(!vacia()){
            size--;
            aux = fin;
            
            if(aux.getAnterior() != null){
                fin = aux.getAnterior();
                fin.setSiguiente(null);
                aux.setAnterior(null);
            }else{
                origen = fin = null;
            }
            conteoTipo(aux.getElemento().tipo, -1);
            return aux.getElemento();
        }
            
        return null;
    }
    
    
    /**
     * Esta directamente relaciona con el valor de la variable booleana cola
     * si el valor de esta variable es true entonces
     * @return el ultimo elemento de la lista pero no lo elimina de esta, en caso la 
     * variable se false retorna el primer elemento de la lista pero no se elimina
     * de esta, si la lista se encuentra vacia retorna null
     */
    public Objeto preView(){
        
        if(cola && !vacia()){
           //System.out.println(origen.getElemento().getImagen());
           return origen.getElemento();
           
        }else if(!vacia()){
           // System.out.println(fin.getElemento().getImagen());
            return fin.getElemento();
        }
        
        return null;
    }

    public int getCastillo(){
        return castillo;
    }
    
    public int getHeroe(){
        return heroe;
    }
    
    public int getSize(){
        return size;
    }
    
    public int getFichas(){
        return ficha;
    }
    
    public int getGooba(){
        return goomba;
    }
    
    public int getHongo(){
        return hongo;
    }
    
    public int getKoopa(){
        return koopa;
    }
    
    public int getPared(){
        return pared;
    }
    
    public int getSuelo(){
        return suelo;
    }
            
}
