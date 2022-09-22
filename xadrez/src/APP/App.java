package APP;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        List<pecaxadrez> capturadas=new ArrayList<>();
        while (!part.getCheckMate()){
            try{
                interfac.clearScreen();
               
                interfac.printPartida(part, capturadas);
                
                System.out.println();
                System.out.print("Origem: ");
                chessPosicao origem=interfac.leituraPosicao(sc);

                boolean[][] possivelmov=part.possiveisMovimentos(origem);
                interfac.clearScreen();
                interfac.printab(part.getPecas(), possivelmov);
                System.out.println();
                System.out.print("Destino: ");
                chessPosicao des=interfac.leituraPosicao(sc);

                pecaxadrez capturar=part.moverPecas(origem,des);

                if (capturar!=null){
                    capturadas.add(capturar);
                }
                if (part.getPromovida()!=null){
                    System.out.print("entre com uma peca (B/C/R/T): ");
                    String tipo=sc.nextLine().toUpperCase();
                    while(!tipo.equals("B")&&!tipo.equals("N")&&!tipo.equals("R")&!tipo.equals("Q")){
                        System.out.println("valor invalido! Escolha um (B/C/R/T)");
                        tipo=sc.nextLine().toUpperCase();
                    }
                    part.substituida(tipo);
                    
                }
            
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
       interfac.clearScreen();
       interfac.printPartida(part, capturadas);;
       
    }
}
