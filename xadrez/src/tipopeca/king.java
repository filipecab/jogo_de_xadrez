package tipopeca;

import entidades.tabuleiro;
import chessenums.enums;
import chessenums.pecaxadrez;


public class king extends pecaxadrez {

    public king(tabuleiro tab, enums cor) {
        super(tab, cor);
        
    }

    @Override
    public String toString(){
        return "K";
    }

    @Override
    public boolean[][] PossivelMovimento() {
        boolean[][] m=new boolean[getTab().getLinhas()][getTab().getColunas()];

        return m;
    }
    
    
}
