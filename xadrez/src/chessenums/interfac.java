package chessenums;


public class interfac {
    
        public static void printab(pecaxadrez[][] pecas){
            for (int i=0;i<pecas.length;i++){
                System.out.print(i+" ");
                for (int j=0;j<pecas.length;j++){
                    printpeca(pecas[i][j]);
                }
                System.out.println();
            }
            System.out.println("  A B C D E F G H");
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
