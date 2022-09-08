package tipopeca;

import entidades.position;
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

    @Override
    public boolean[][] PossivelMovimento() {
        boolean[][] m=new boolean[getTab().getLinhas()][getTab().getColunas()];
        position p= new position(0,0);
        //verificando a parte de cima da peça
        p.setValores(posicao.getLinha()-1, posicao.getColuna());
        while(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
            p.setLinha(p.getLinha()-1);
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        //verificando a parte esquerda da peça
        p.setValores(posicao.getLinha(), posicao.getColuna()-1);
        while(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
            p.setColuna(p.getColuna()-1);
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        //Verificando a direita da peça
        p.setValores(posicao.getLinha(), posicao.getColuna()+1);
        while(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
            p.setColuna(p.getColuna()+1);
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        //Verificando abaixo da peça
        p.setValores(posicao.getLinha()+1, posicao.getColuna());
        while(getTab().posicaoExist(p)&& !getTab().temPecaPos(p)){
            m[p.getLinha()][p.getColuna()]=true;
            p.setLinha(p.getLinha()+1);
        }
        if (getTab().posicaoExist(p)&& posicaoTemOpenente(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }


        return m;
    }
    
    
}
