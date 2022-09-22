package tipopeca;

import entidades.tabuleiro;
import chessenums.enums;
import chessenums.pecaxadrez;
import entidades.position;

public class cavalo extends pecaxadrez {

    public cavalo(tabuleiro tab, enums cor) {
        super(tab, cor);
    }
    @Override
    public String toString(){
        return "C";
    }
    private boolean canMove(position p){
        pecaxadrez pos=(pecaxadrez)getTab().peca1(p);
        return pos==null || pos.getCor()!=getCor();
    }

    @Override
    public boolean[][] PossivelMovimento() {
        boolean[][] m=new boolean[getTab().getLinhas()][getTab().getColunas()];
        position p= new position(0,0);
        p.setValores(posicao.getLinha()-2, posicao.getColuna()+1);
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        
        p.setValores(posicao.getLinha()+2, posicao.getColuna()+1);
                if(getTab().posicaoExist(p)&& canMove(p)) {
            m[p.getLinha()][p.getColuna()]=true;
        }
        
        p.setValores(posicao.getLinha()+2, posicao.getColuna()-1);
        if(getTab().posicaoExist(p) && canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        
        p.setValores(posicao.getLinha()-2, posicao.getColuna()-1);
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
      

        p.setValores(posicao.getLinha()-1, posicao.getColuna()-2);
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        

        p.setValores(posicao.getLinha()+1, posicao.getColuna()-2);
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        
        
        p.setValores(posicao.getLinha()-1, posicao.getColuna()+2);
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
       

        p.setValores(posicao.getLinha()+1, posicao.getColuna()+2);
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
       
        return m;
    }
}
