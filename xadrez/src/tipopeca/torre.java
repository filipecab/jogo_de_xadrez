package tipopeca;

import entidades.tabuleiro;
import chessenums.enums;
import chessenums.pecaxadrez;


public class torre extends pecaxadrez{

 
    public torre(tabuleiro tab, enums cor) {
        super(tab, cor);
        
    }

    @Override
    public String toString(){
        return "T";
    }
    
    
}
