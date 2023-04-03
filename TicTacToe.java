import java.util.concurrent.TimeUnit;

import javax.swing.tree.ExpandVetoException;

import java.util.Scanner;
public class TicTacToe{
    //Try Catch fehlt
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map field = new Map(3,3);   //Feld wird erstellt
        boolean winSpieler = false;      //Muss festgelegt werden für While True
        boolean winComputer = false;
        
        //gameloop 
        while(winSpieler == false && winComputer == false){
            System.out.println("Gib X Koordinate");
            int x = sc.nextInt();
            System.out.println("Gib Y Koordinate");
            int y = sc.nextInt()-1;
      
            //Spieler
            try {
                field.setSymbol(x,y);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                System.exit(1);
            }

            System.out.println(field.toString()); 
            winSpieler = field.checker("o"); 
            if (winSpieler == true){
                System.out.println("Du hast gewonnen");
                break;
            }
    
            wait(500);
            
            //Computer
            field.setSymbol();
            System.out.println(field.toString()); 
            winComputer = field.checker("x");
            if (winComputer == true){
                System.out.println("Der Computer hat gewonnen");
                break;
            }
        }
    }

    
    
    public static void wait(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }


}


