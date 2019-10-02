/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class Imagee extends JPanel{
     @Override
  public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.drawImage(new ImageIcon("t.png").getImage(),0,0,700,700,this);
      
  }
    
}
