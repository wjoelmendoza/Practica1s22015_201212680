/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author walter
 */
public class DropTargetList extends DropTargetAdapter implements DropTargetListener {
    private DropTarget dropTarget;
   // private JPanel origen;
    private JPanel dest;
    private JFrame contenedor;
    
    public DropTargetList(JPanel panel, JFrame contenedor){
        
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
