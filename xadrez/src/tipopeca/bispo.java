package tipopeca;

import chessenums.enums;
import chessenums.pecaxadrez;
import entidades.tabuleiro;
import entidades.position;

public class bispo extends pecaxadrez {

    public bispo(tabuleiro tab, enums cor) {
        super(tab, cor);
    }
    @Override
    public String toString(){
        return "B";

    }

    @Override
    public boolean[][] PossivelMovimento() {
        boolean[][] m=new boolean[getTab().getLinhas()][getTab().getColunas()];
        position p= new position(0,0);
        p.setValores(posicao.getLinha()-1, posicao.getColuna()+1);
        while(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
            p.setValores(p.getLinha()-1, p.getColuna()+1);
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha()-1, posicao.getColuna()-1);
        while(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
            p.setValores(p.getLinha()-1, p.getColuna()-1);
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha()+1, posicao.getColuna()+1);
        while(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
            p.setValores(p.getLinha()+1, p.getColuna()+1);
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha()+1, posicao.getColuna()-1);
        while(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
            p.setValores(p.getLinha()+1, p.getColuna()-1);
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        
        return m;
    }
}
