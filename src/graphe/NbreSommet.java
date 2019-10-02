package graphe;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
public class NbreSommet extends JFrame implements ActionListener {
    private JTextField N;
   private int x ;  

    public JTextField getN() {
        return N;
    }
    
    private JButton valider ,annuler;
    private Imagee p ;
    public NbreSommet(){
        p=new Imagee();
        p.setLayout(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bienvenue");
        this.setSize(700,700);
        this.setLocationRelativeTo(null); 
        this.setLocale(java.util.Locale.getDefault());
        this.getContentPane().setLayout(null);
        
        p.setBounds(0,0,700,700);
        N=new JTextField();
        N.setBounds(new Rectangle(400,500,150,25));
        p.add(N);
       // this.getContentPane().add(N);
        valider=new JButton ("Valider");
        annuler=new JButton("Quitter");
        valider.setBounds(new Rectangle(380,550,80,25));
        annuler.setBounds(new Rectangle(480,550,80,25));
       
        valider.addActionListener(this);
        annuler.addActionListener(this);
        p.add(valider);
        p.add(annuler);
        this.getContentPane().add(p);
        this.setVisible(true);
        //this.getContentPane().add(annuler);
        
        
    
    }
  /*  public void err() throws ErrNegativeException{
        do{
        x= Integer.parseInt(N.getText());}while(x<=0);
        matrice2 M = new matrice2( x ,  x);
          M.setVisible(true);
          this.dispose();
    }  */    
    @Override
    public void actionPerformed(ActionEvent e) {
if (e.getSource()==valider){
    
     try{
          x= Integer.parseInt(N.getText());
        matrice2 M = new matrice2( x ,  x);
          M.setVisible(true);
          this.dispose();
          }catch(NumberFormatException ex)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"vous devez entrer un entier");}}

else if (e.getSource()==annuler)
{
    System.exit(0);
}

    }
}