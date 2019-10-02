package graphe;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class Menu extends JFrame implements ActionListener {
    
    private static JLabel L;
    private static JButton perso,complet,bipartie,cycle,quitter;
    public Menu ()  {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Menu");
        this.setSize(280,360);
        this.setLocationRelativeTo(null); 
        this.setLocale(java.util.Locale.getDefault());
        this.getContentPane().setLayout(null);
        L=new JLabel("Quel est le type de votre graphe ?");
        L.setBounds(new Rectangle (20,20,210,30));
        this.getContentPane().add(L);
        complet=new JButton("Complet");
        complet.setBounds(new Rectangle (50,70,150,30));
        this.getContentPane().add(complet);
        bipartie=new JButton("Bipartie");
        bipartie.setBounds(new Rectangle(50,120,150,30));
        this.getContentPane().add(bipartie);
        cycle=new JButton("Cyclique");
        cycle.setBounds(new Rectangle(50,170,150,30));
        this.getContentPane().add(cycle);
        perso=new JButton("Personnalisé");
        perso.setBounds(new Rectangle(50,220,150,30));
        this.getContentPane().add(perso);
        perso.addActionListener(this);
        quitter=new JButton("Quitter");
        quitter.setBounds(new Rectangle(50,270,150,30));
        this.getContentPane().add(quitter);
        this.setVisible(true);
      }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==perso)
            {NbreSommet N=new NbreSommet();
            N.setVisible(true);
            perso.enableInputMethods(false);
            this.dispose();
    }
}
}