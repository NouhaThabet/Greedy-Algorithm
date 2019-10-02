/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe;

import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class Resultat {
    
    private final int Mat[][];
    private final int X ;
    private final String [] Sommet ;
    private final int [] sommet;
    private final int [] degre ;
    private final int [] Couleur ; 
    private int complet , c , nbrecouleur=1;

   
    
    public Resultat(int Mat[][],int X){
       
        this.Mat=Mat;
        this.X=X;
        
        Sommet = new String[this.X];
        degre = new int [this.X];
        Couleur=new int [this.X];
        sommet=new int[this.X];
        trie();
        Choisir_Couleur();
       // Nombre_Couleur();
        
         for(int i=0;i<X;i++)
         {System.out.println(Sommet[i]+" "+degre[i]+" "+sommet[i]+" "+Couleur[i]);}
        String x=toString(Mat[0][0]);
  
        
        
    }
     public int getNbrecouleur() {
        return nbrecouleur;
    }

    public int[] getCouleur() {
        return Couleur;
    }
     
     
    public String toString(int X){
        String res="";
        res=res+X;
        return res ;
        }
    
    
    public void remplir(){
        for (int i=0;i<X;i++)
        {  degre[i]=0;
           Sommet[i]="V"+(i+1);
        Couleur[i]=0;
        sommet[i]=(i+1);}
        
        for (int i=0;i<X;i++)
        {for (int j=0;j<X;j++)
        {if (Mat[i][j]%2==1)
            degre[i]++;
            }}
            
            }
    
    public void trie (){
       remplir();
        int tmp=0,s=0;
        String S="";
        for (int i=0;i<X;i++)
        {for(int j=i+1;j<X;j++)
        { if (degre[i]<degre[j])
        {tmp=degre[i];
        degre[i]=degre[j];
        degre[j]=tmp;
        S=Sommet[i];
        Sommet[i]=Sommet[j];
        Sommet[j]=S;
        s=sommet[i];
        sommet[i]=sommet[j];
        sommet[j]=s;}
        }
        }}
    
    
    public void Affectation_Couleur(int x , int c){
        boolean T=true;
        for(int i=0;i<X;i++){
            if (Test_Arret(x,i)&&Test_Color(i,c))
                T=false;}
        if (T==true )
            Couleur[x]=c;
    }
    
    public boolean Test_Arret(int x, int y){
        boolean T=false;
        if (Mat[x][y]%2==1)
            T=true;
        return T;
    }
    
    public boolean Test_Color(int x , int c) {
        boolean T=false;
        if (Couleur[x]==c){
            T=true;
        }
        return T;
    }
    
    public void ReturnTable(int [] T){
        for(int i=0;i<X;i++)
            T[i]=Couleur[i];
    }
    
   public void Choisir_Couleur(){
        
    c=1;
        for(int i=0;i<X;i++){
            for(int j=0;j<X;j++){
                if (Mat[sommet[i]-1][j]%2==0){
                  Affectation_Couleur(j,c);  
                }
            }c++;
       }     
}   
    
    public void Nombre_Couleur(){
    int tmp=0;int c=0;
for (int i=0;i<X;i++)
        {for(int j=i+1;j<X;j++)
        { if (Couleur[i]<Couleur[j])
        {tmp=Couleur[i];
        Couleur[i]=Couleur[j];
        Couleur[j]=tmp;
}} 

}

for (int i=0;i<X-1;i++){
   if (Couleur[i]!=Couleur[i+1])
       nbrecouleur ++;
}   
}}


    
  
