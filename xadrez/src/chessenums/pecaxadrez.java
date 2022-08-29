package chessenums;

import entidades.peca;
import entidades.tabuleiro;
import exception.excp;



public class pecaxadrez extends peca{
    private excp cor;

    public pecaxadrez(tabuleiro tab, excp cor) {
        super(tab);
        this.cor = cor;
    }

    public excp getCor() {
        return cor;
    }
    
    


}