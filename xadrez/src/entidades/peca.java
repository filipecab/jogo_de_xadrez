package entidades;

import entidades.position;

public class peca {
    protected position posicao;

    private tabuleiro tab;
    
    public peca (tabuleiro tab){
        this.tab=tab;
    }

    protected tabuleiro getTab() {
        return tab;
    }
    


}
