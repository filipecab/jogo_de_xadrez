package entidades;



public abstract class peca {
    protected position posicao;

    private tabuleiro tab;
    
    public peca (tabuleiro tab){
        this.tab=tab;
        posicao=null;
    }

    protected tabuleiro getTab() {
        return tab;
    }

    public abstract boolean[][] PossivelMovimento();

    public boolean posMove(position p){
        return PossivelMovimento()[p.getLinha()][p.getColuna()];
    }
    public boolean esteMovimentoPossivel(){
        boolean[][] m= PossivelMovimento();
        for (int i=0;i<m.length;i++){
            for (int j=0;j<m.length;j++){
                if (m[i][j]){
                    return true;
                }
            }
        }
        return false;
    }



}
