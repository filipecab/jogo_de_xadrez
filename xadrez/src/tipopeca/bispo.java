package tipopeca;

import chessenums.enums;
import chessenums.pecaxadrez;
import entidades.tabuleiro;

public class bispo extends pecaxadrez {

    public bispo(tabuleiro tab, enums cor) {
        super(tab, cor);
    }
    
    public String toString(){
        return "B";

    }
}
