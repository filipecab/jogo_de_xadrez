package chessenums;


import java.util.List;

import java.util.Arrays;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;


public class interfac {
       

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

        public static void clearScreen() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } 

        public static chessPosicao leituraPosicao(Scanner sc){
            try{
                String pos=sc.nextLine();
                char coluna =pos.charAt(0);
                int linha=Integer.parseInt(pos.substring(1));
                return new chessPosicao(coluna, linha);
            }
            catch (RuntimeException e){
                throw new InputMismatchException("erro lendo posição de xadrez");
            }
        }
        

        public static void printPartida(partida p,List<pecaxadrez> capt){
            printab(p.getPecas());
            System.out.println();
            printPecasCapturadas(capt); 
            System.out.println();
            System.out.println("Turno: "+ p.getTurno());
            if (!p.getCheckMate()){
                System.out.println("Aguardando jogador: "+p.getPlayer());
                if (p.getCheck()){
                    System.out.println("CHECK");
                    }
                     }
                  else{ 
                    System.out.println("check mate");
                    System.out.println("vencedor "+ p.getPlayer());
                } 

        }

        public static void printab(pecaxadrez[][] pecas){
            for (int i=0;i<pecas.length;i++){
                System.out.print((8-i)+" ");
                for (int j=0;j<pecas.length;j++){
                    printpeca(pecas[i][j],false);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        public static void printab(pecaxadrez[][] pecas, boolean[][] possiveisMovimentos){
            for (int i=0;i<pecas.length;i++){
                System.out.print((8-i)+" ");
                for (int j=0;j<pecas.length;j++){
                    printpeca(pecas[i][j],possiveisMovimentos[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        private static void printpeca(pecaxadrez peca, boolean background) {

            if (background) {
                System.out.print(ANSI_BLUE_BACKGROUND);
            }
            if (peca == null) {
                System.out.print("-" + ANSI_RESET);
            }
            else {
                if (peca.getCor() == enums.WHITE) {
                    System.out.print(ANSI_WHITE + peca + ANSI_RESET);
                }
                else {
                    System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
                }
            }
            System.out.print(" ");
        }

       public static void printPecasCapturadas(List<pecaxadrez> capturadas){
            List<pecaxadrez> branca=capturadas.stream().filter(x -> x.getCor()==enums.WHITE).collect(Collectors.toList());
            List<pecaxadrez> preta=capturadas.stream().filter(x -> x.getCor()==enums.BLACK).collect(Collectors.toList());
            System.out.println("Peças capturadas: ");
            System.out.println("brancas: ");
            System.out.println(ANSI_WHITE);
            System.out.println(Arrays.toString(branca.toArray()));
            System.out.println(ANSI_RESET);
            System.out.println("pretas: ");
            System.out.println(ANSI_YELLOW);
            System.out.println(Arrays.toString(preta.toArray()));
            System.out.println(ANSI_RESET);

        } 
    
}
