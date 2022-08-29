package APP;

import chessenums.partida;
import chessenums.interfac;


public class App {
    public static void main(String[] args) {

        partida part=new partida();

        interfac.printab(part.getPecas());        
    }
}
