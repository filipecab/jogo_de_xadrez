package tipopeca;

import entidades.tabuleiro;
import chessenums.enums;
import chessenums.pecaxadrez;
import entidades.position;


public class king extends pecaxadrez {

    public king(tabuleiro tab, enums cor) {
        super(tab, cor);
        
    }

    @Override
    public String toString(){
        return "K";
    }

    @Override
    public boolean[][] PossivelMovimento() {
        boolean[][] m=new boolean[getTab().getLinhas()][getTab().getColunas()];
        position p= new position(0,0);
        p.setValores(posicao.getLinha()-1, posicao.getColuna());
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha(), posicao.getColuna()-1);
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha(), posicao.getColuna()+1);
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }

        p.setValores(posicao.getLinha()+1, posicao.getColuna());
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha()+1, posicao.getColuna()+1);
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha()+1, posicao.getColuna()-1);
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        p.setValores(posicao.getLinha()-1, posicao.getColuna()-1);
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }

        p.setValores(posicao.getLinha()-1, posicao.getColuna()+1);
        if(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }




        return m;
    }
    
    
}
