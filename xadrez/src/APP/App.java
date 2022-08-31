package APP;

import java.util.Scanner;

import chessenums.chessPosicao;
import chessenums.interfac;
import chessenums.partida;
import chessenums.pecaxadrez;


public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        partida part=new partida();
        while (true){
            interfac.printab(part.getPecas());        
            System.out.println();
            System.out.print("Origem: ");
            chessPosicao origem=interfac.leituraPosicao(sc);
            System.out.println();
            System.out.print("Destino: ");
            chessPosicao des=interfac.leituraPosicao(sc);

            pecaxadrez capturar=part.moverPecas(origem,des);

            
        }
    }
}
