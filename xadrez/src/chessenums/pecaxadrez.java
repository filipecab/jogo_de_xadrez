package chessenums;

import entidades.peca;
import entidades.tabuleiro;




public class pecaxadrez extends peca{
    private enums cor;

    public pecaxadrez(tabuleiro tab, enums cor) {
        super(tab);
        this.cor = cor;
    }

    public enums getCor() {
        return cor;
    }
    
    


}