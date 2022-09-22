package chessenums;

import entidades.peca;
import entidades.position;
import entidades.tabuleiro;




public abstract class pecaxadrez extends peca{
    private enums cor;
    private int moveCount;


    public pecaxadrez(tabuleiro tab, enums cor) {
        super(tab);
        this.cor = cor;
    }

    public enums getCor() {
        return cor;
    }
    public int getMoveCount(){
        return moveCount;
    }
    

    protected boolean posicaoTemOpenente(position p){
        pecaxadrez pe= (pecaxadrez)getTab().peca1(p);
        return pe!= null && pe.getCor()!=cor;
    }

    public  chessPosicao getChessPosicao(){
        return chessPosicao.umaPosicao(posicao);
    }
    
    protected void incrementarMovimentocount(){
        moveCount++;
    } 
    protected void decrementarMovimentoCount(){
        moveCount--;
    }  
    


}