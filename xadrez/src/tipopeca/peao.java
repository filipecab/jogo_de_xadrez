package tipopeca;

import entidades.tabuleiro;
import chessenums.enums;
import chessenums.pecaxadrez;
import entidades.position;

public class peao extends pecaxadrez {

    public peao(tabuleiro tab, enums cor) {
        super(tab, cor);
 }
    
    public String toString(){
        return "p";
    }

    @Override
    public boolean[][] PossivelMovimento() {                                                //Verifica e traz as possiveis posições de uma peca em todos os lados
        boolean[][] m=new boolean[getTab().getLinhas()][getTab().getColunas()];
        position p= new position(0,0);
        p.setValores(posicao.getLinha()-1, posicao.getColuna());
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha(), posicao.getColuna()-1);
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha(), posicao.getColuna()+1);
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha()+1, posicao.getColuna());
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }


        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
    }
    return m;
    }
 }
