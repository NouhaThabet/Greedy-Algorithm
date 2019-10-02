/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/**
 *
 * @author HP
 */
public class matrice2 extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    
    private static int width;
    private final int height;
    private final JRadioButton R ;
    private final JLabel NumCoul ;
    private final JLabel[] horizon;
    private final JLabel[] vertical;
    private final JButton[][] centre;
    private JButton goButton,returnButton;
    private static int [][] value ; 
      private JScrollPane scroll ;
      private int [] T;

    
    public matrice2(int width, int height) {
        this.width = width;
        this.height = height;
        T=new int[width];
        value= new int[width][height];
        horizon = new JLabel[width];
        vertical = new JLabel[height];
        centre = new JButton[width][height];
        goButton=new JButton("Valider");
        returnButton=new JButton("Retour ");
        NumCoul=new JLabel();
        initFrame();
        fillContent();
       R=new JRadioButton("Complet");
        this.setVisible(true);
    }
    
    private void initFrame() {
        this.setSize(700, 700);
        this.setTitle("Matrice du graphe");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JLabel createColumnHeader(int x) {
        horizon[x] = new JLabel("V" + (x + 1),JLabel.CENTER);
             Font font = new Font("DialogInput",Font.BOLD,20);
             horizon[x].setFont(font);
             return horizon[x];
    }

    private JLabel createRowHeader(int y) {
        vertical[y] = new JLabel("V" + (y + 1),JLabel.CENTER);
           Font font = new Font("DialogInput",Font.BOLD,20);
           vertical[y].setFont(font);
           return vertical[y];
    }
    
    private JButton createCell(int x, int y) {
        centre[x][y] = new  JButton();
        centre[x][y].addActionListener(new MatriceListener(this,x,y));
        return centre[x][y];
    }
    
    public void compteur (){
        
        for(int i=0;i<width;i++)
        {  for(int j=0;j<width;j++)
           value[i][j]=0;}
    }
    
    
    public void fillContent() {
        JPanel gridPanel = new JPanel();
    gridPanel.setLayout(new GridLayout(height+1, width+1));
    
    gridPanel.add(new JLabel());
    
    for (int x = 0; x < width; x++)
    gridPanel.add(createColumnHeader(x));
    
    for (int y = 0; y < height; y++) {
        gridPanel.add(createRowHeader(y));
        for (int x=0; x<width; x++)
            gridPanel.add(createCell(x,y));
            }
    
    scroll= new JScrollPane(gridPanel);
    this.add(scroll);
    goButton.addActionListener(this);
    returnButton.addActionListener(this);
     this.getContentPane().add(scroll, BorderLayout.CENTER);
     this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
     this.add(goButton, BorderLayout.SOUTH);
     this.add(returnButton , BorderLayout.NORTH);
     this.add(NumCoul , BorderLayout.NORTH);

          for(int x=0;x<width;x++){
         for(int y=0;y<height;y++){
             if (x==y)
         centre[x][y].setBackground(Color.gray);
           }}
         
         
        }
    
    
    
    public void setColor(int x, int y) {
        centre[x][y].setBackground(Color.cyan);

    }
    
    public void setColorNull(int x , int y)
    {     if(x==y)   
        centre[x][y].setBackground(Color.gray);
    else
        centre[x][y].setBackground(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==goButton){
           Resultat R = new Resultat(value,width);
           R.ReturnTable(T);
           R.Nombre_Couleur();
           int x=R.getNbrecouleur();
           NumCoul.setText("Le nombre de couleur est "+x);
            Font fon2=new Font("DialogInput",Font.BOLD,35);
       NumCoul.setFont(fon2);
       NumCoul.setForeground(Color.red);
           for(int i=0;i<width;i++){
               
               switch(T[i]){
                   
                     case 1 :
                  vertical[i].setBackground(Color.ORANGE) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.ORANGE);
                  horizon[i].setOpaque(true);
                       break;
                         
                   case 2 :
                  vertical[i].setBackground(Color.LIGHT_GRAY) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.LIGHT_GRAY);
                  horizon[i].setOpaque(true);
                       break;
                      
                    case 3 :
                  vertical[i].setBackground(Color.BLUE) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.BLUE);
                  horizon[i].setOpaque(true);
                       break;
                        
                          case 4 :
                  vertical[i].setBackground(Color.MAGENTA) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.MAGENTA);
                  horizon[i].setOpaque(true);
                       break;
                       
                                case 5 :
                  vertical[i].setBackground(Color.YELLOW) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.YELLOW);
                  horizon[i].setOpaque(true);
                       break;
                                    
                    case 6 :
                  vertical[i].setBackground(Color.WHITE) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.WHITE);
                  horizon[i].setOpaque(true);
                       break;
                        
                        
                          case 7 :
                  vertical[i].setBackground(Color.PINK) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.PINK);
                  horizon[i].setOpaque(true);
                       break;
                              
                                case 8 :
                  vertical[i].setBackground(Color.DARK_GRAY) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.DARK_GRAY);
                  horizon[i].setOpaque(true);
                       break;
                                    
                                      case 9 :
                  vertical[i].setBackground(Color.CYAN) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.CYAN);
                  horizon[i].setOpaque(true);
                       break;
                                          
                    case 10 :
                  vertical[i].setBackground(Color.RED) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.RED);
                  horizon[i].setOpaque(true);
                       break;
                                                
                      case 11:
                  vertical[i].setBackground(Color.getHSBColor(195,180,112)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(195,180,112));
                  horizon[i].setOpaque(true);
                       break;
                                                      
                      case 12 :
                  vertical[i].setBackground(Color.GREEN) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.GREEN);
                  horizon[i].setOpaque(true);
                       break;
                                                            
                      case 13 :
                  vertical[i].setBackground(Color.GRAY) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.GRAY);
                  horizon[i].setOpaque(true);
                       break;
                          
                   case 14 :
                  vertical[i].setBackground(Color.getHSBColor(150,0,24)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(150,0,24));
                  horizon[i].setOpaque(true);
                       break;
                                
                    case 15 :
                  vertical[i].setBackground(Color.getHSBColor(205, 255,13)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(205,255,13));
                  horizon[i].setOpaque(true);
                       break;
                                          
                   case 16 :
                  vertical[i].setBackground(Color.getHSBColor(53,122,83)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(53,122,83));
                  horizon[i].setOpaque(true);
                       break;
                     
                    case 17 :
                  vertical[i].setBackground(Color.getHSBColor(187,11,11)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(187,11,11));
                  horizon[i].setOpaque(true);
                       break;    
                    
                         case 18 :
                  vertical[i].setBackground(Color.getHSBColor(253,108,158)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(253,108,158));
                  horizon[i].setOpaque(true);
                       break;
                             
                              case 19 :
                  vertical[i].setBackground(Color.getHSBColor(53,122,183)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(53,122,183));
                  horizon[i].setOpaque(true);
                       break;
                                  
                                   case 20:
                  vertical[i].setBackground(Color.getHSBColor(149,86,40)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(149,86,40));
                  horizon[i].setOpaque(true);
                       break;
                                       
                                       
                                        case 21 :
                  vertical[i].setBackground(Color.getHSBColor(255,228,196)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(255,228,196));
                  horizon[i].setOpaque(true);
                       break;
                                            
                                             case 22 :
                  vertical[i].setBackground(Color.getHSBColor(100,155,136)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(100,155,136));
                  horizon[i].setOpaque(true);
                       break;
                                                 
                                                  case 23 :
                  vertical[i].setBackground(Color.getHSBColor(254,163,71)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(254,163,71));
                  horizon[i].setOpaque(true);
                       break;
                                                      
                                                       case 24 :
                  vertical[i].setBackground(Color.getHSBColor(128,0,128)) ; 
                  vertical[i].setOpaque(true);
                  horizon[i].setBackground(Color.getHSBColor(128,0,128));
                  horizon[i].setOpaque(true);
                       break;
               }
             
           }
           
           
    }
        else
        {
            NbreSommet M=new NbreSommet();
            this.dispose();
        }}
    
    

    private static class MatriceListener implements ActionListener {

 private final matrice2 mat;
    private final int x;
    private final int y;
    
    public MatriceListener(matrice2 mat, int x, int y) {
        this.mat = mat;
        this.x = x;
        this.y = y;        }

        @Override
        public void actionPerformed(ActionEvent e) {
            value[x][y]++;
            if (value[x][y]%2==1)
        mat.setColor(x,y); 
            else
        mat.setColorNull(x,y);
             value[y][x]++;
            if (value[y][x]%2==1)
        mat.setColor(y,x); 
            else
        mat.setColorNull(y,x);
}
        
    }
    
    public static class GoListener implements ActionListener{
        private int [][] mat ;
        private int x;
        public GoListener (int [][] mat,int x){
           mat=value;
           x=width;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           Resultat R = new Resultat(mat,x);
           int x=R.getNbrecouleur();
           
        }
        
    }

 }