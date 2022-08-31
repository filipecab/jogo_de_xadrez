package tipopeca;

import entidades.tabuleiro;
import chessenums.enums;
import chessenums.pecaxadrez;

public class rainha extends pecaxadrez {

    public rainha(tabuleiro tab, enums cor) {
        super(tab, cor);
    }

    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] PossivelMovimento() {
        boolean[][] m=new boolean[getTab().getLinhas()][getTab().getColunas()];
        return m;
    }
    
}
