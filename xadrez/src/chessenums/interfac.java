package chessenums;
import chessenums.pecaxadrez;

public class interfac {
    
        public static void printab(pecaxadrez[][] pecas){
            for (int i=0;i<pecas.length;i++){
                System.out.print((8-i)+" ");
                for (int j=0;j<pecas.length;j++){
                    printpeca(pecas[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        public static void printpeca(pecaxadrez peca){
            if (peca==null){
                System.out.print("-");
            }
            else{
                System.out.print(peca);
            }
            System.out.print(" ");
        }

    
}
