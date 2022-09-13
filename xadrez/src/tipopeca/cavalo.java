package tipopeca;

import entidades.tabuleiro;
import chessenums.enums;
import chessenums.pecaxadrez;
import entidades.position;

public class cavalo extends pecaxadrez {

    public cavalo(tabuleiro tab, enums cor) {
        super(tab, cor);
    }
    
    public String toString(){
        return "C";
    }

    @Override
    public boolean[][] PossivelMovimento() {
        boolean[][] m=new boolean[getTab().getLinhas()][getTab().getColunas()];
        position p= new position(0,0);
        p.setValores(posicao.getLinha()-2, posicao.getColuna()+1);
        if(getTab().posicaoExist(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha()+2, posicao.getColuna()+1);
        if(getTab().posicaoExist(p)){
            
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha()+2, posicao.getColuna()-1);
        if(getTab().posicaoExist(p) ){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha()-2, posicao.getColuna()-1);
        if(getTab().posicaoExist(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        return m;
    }
}
