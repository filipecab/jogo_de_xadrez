package tipopeca;

import entidades.tabuleiro;
import chessenums.enums;
import chessenums.pecaxadrez;

public class cavalo extends pecaxadrez {

    public cavalo(tabuleiro tab, enums cor) {
        super(tab, cor);
    }
    
    public String toString(){
        return "C";
    }

    @Override
    public boolean[][] PossivelMovimento() {
        boolean[][] m=new boolean[getTab().getLinhas()][getTab().getColunas()];
        return m;
    }
}
