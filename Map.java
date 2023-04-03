import java.util.Random;
import java.util.Scanner;
public class Map {
    private String[][] Map;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    public Map(int x, int y){
        this.Map = new String[x][y]; 

    }

    public void setSymbol(){                //SetSymbol für Computer
        int x = random.nextInt(3);   //Randome x,y
        int y = random.nextInt(3); 
        while (checkPos(x, y) == false){    //schaut ob Feld belegt
            x = random.nextInt(3);      
            y = random.nextInt(3);
        }
        this.Map[x][y] = ("x");

    }

    public boolean checker(String symbol){
        int counter = 0; 
        for (int i = 0; i < 3; i++){            //Wenn auf Diagonale liegt +1 
            if (this.Map[i][i] == symbol){
                counter = counter + 1;
            }
            if (counter == 3){                     //Wenn 3 erreicht, gibt false zurück, um gameloop abzubrechen 
                return true;
            }
        }
        counter = 0;
        for(int x = 0; x<3; x++){
            for(int y = 0; y<3; y++){               //Wenn auf Waagerechte liegt +1 
                if (this.Map[x][y] == symbol){
                    counter = counter + 1; 
                }
                if (counter == 3){                 //Wenn 3 erreicht, gibt false zurück, um gameloop abzubrechen 
                    return true;
                }
            }
            counter = 0;
        } 
        for(int y = 0; y<3; y++){
            for(int x = 0; x<3; x++){ 
                if (this.Map[x][y] == symbol){      //Wenn auf vertikale liegt +1 
                    counter = counter + 1; 
                }
                if (counter == 3){                //Wenn 3 erreicht, gibt false zurück, um gameloop abzubrechen 
                    return true; 
                }
            }
            counter = 0; 
        }  
        return false;
    }

    public void setSymbol(int x, int y) throws Exception{        //setSymbol für Spieler 
        if (x == -1 || y == -1){
            x = sc.nextInt()-1;
            System.out.println("Gib Y Koordinate");
            y = sc.nextInt()-1;
        }
        while (checkPos(x, y) == false){        //solange Feld belegt, neue Koordinaten fordern
            System.out.println("Dieses Feld ist bereits vergeben.");
            System.out.println("Gib X Koordinate");
            x = sc.nextInt()-1;
            if(x==3){
                throw new Exception("Es wurde eine Zahl außerhalb von 0 bis 2 eingeben");
            }
            System.out.println("Gib Y Koordinate");
            y = sc.nextInt()-1;
        }
        this.Map[x][y] = ("o");
    }

    public boolean checkPos(int x, int y){
        if (this.Map[x][y] == null){        
            return true;
        }
        else {
            return false;
        }
    }

    public String toString(){
        String result = "   X1 " + " X2 " + " X3 " +"\n"
                        + "--------------" + "\n";
        
        for(int x = 0 ; x<3; x++){
            for(int y = 0; y<3; y++){
                if (y == 0){
                    result = result + "Y" +(x+1) +"|";
                }
                if(this.Map[x][y] == null){
                    result = result + (" "+ "-" +" ");
                }
                else{
                    result = result + (" "+ this.Map[x][y] +" ");
                }    
            }
            result +=("\n");
        }
        return result; 
    }
}
