package tipopeca;

import entidades.tabuleiro;
import chessenums.enums;
import chessenums.pecaxadrez;

public class peao extends pecaxadrez {

    public peao(tabuleiro tab, enums cor) {
        super(tab, cor);
    }
    
    public String toString(){
        return "p";
    }
}
