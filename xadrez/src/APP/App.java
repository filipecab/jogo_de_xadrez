package APP;

import chessenums.interfac;
import chessenums.partida;


public class App {
    public static void main(String[] args) {

        partida part=new partida();

        interfac.printab(part.getPecas());        
    }
}
