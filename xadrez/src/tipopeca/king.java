package tipopeca;

import chessenums.enums;
import chessenums.pecaxadrez;
import entidades.tabuleiro;


public class king extends pecaxadrez {

    public king(tabuleiro tab, enums cor) {
        super(tab, cor);
        
    }

    @Override
    public String toString(){
        return "K";
    }
    
    
}
