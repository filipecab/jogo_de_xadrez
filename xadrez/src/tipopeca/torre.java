package tipopeca;

import chessenums.enums;
import chessenums.pecaxadrez;
import entidades.tabuleiro;
import exception.excp;

public class torre extends pecaxadrez{

 
    public torre(tabuleiro tab, enums cor) {
        super(tab, cor);
        
    }

    @Override
    public String toString(){
        return "R";
    }
    
    
}
