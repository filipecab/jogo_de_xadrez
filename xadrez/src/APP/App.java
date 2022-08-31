package APP;

import java.util.InputMismatchException;
import java.util.Scanner;

import chessenums.chessPosicao;
import chessenums.interfac;
import chessenums.partida;
import chessenums.pecaxadrez;
import exception.excp;


public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        partida part=new partida();
        while (true){
            try{
                interfac.clearScreen();
                interfac.printab(part.getPecas());        
                System.out.println();
                System.out.print("Origem: ");
                chessPosicao origem=interfac.leituraPosicao(sc);
                System.out.println();
                System.out.print("Destino: ");
                chessPosicao des=interfac.leituraPosicao(sc);

                pecaxadrez capturar=part.moverPecas(origem,des);
            
            }
            catch(excp e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());
                System.out.println("Aperte enter");
                sc.nextLine();
            }
        }
    }
}
