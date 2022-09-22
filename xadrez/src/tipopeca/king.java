package tipopeca;

import entidades.tabuleiro;
import chessenums.enums;
import chessenums.partida;
import chessenums.pecaxadrez;

import entidades.position;


public class king extends pecaxadrez {
    private partida part;

    public king(tabuleiro tab, enums cor,partida part) {
        super(tab, cor);
        this.part=part;
        
    }

    @Override
    public String toString(){
        return "K";
    }
    private boolean canMove(position p){
        pecaxadrez pos=(pecaxadrez)getTab().peca1(p);
        return pos==null||pos.getCor()!= getCor();
    } 
    private boolean testeTorre(position p){
        pecaxadrez peca=(pecaxadrez)getTab().peca1(p);
        return peca!=null && peca instanceof torre && peca.getCor()==getCor() && peca.getMoveCount()==0;
    }

    @Override
    public boolean[][] PossivelMovimento() {
        boolean[][] m=new boolean[getTab().getLinhas()][getTab().getColunas()];
        position p= new position(0,0);
        p.setValores(posicao.getLinha()-1, posicao.getColuna());
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        
        p.setValores(posicao.getLinha(), posicao.getColuna()-1);
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        
        p.setValores(posicao.getLinha(), posicao.getColuna()+1);
        if(getTab().posicaoExist(p)&& !canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
       
        p.setValores(posicao.getLinha()+1, posicao.getColuna());
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        
        p.setValores(posicao.getLinha()+1, posicao.getColuna()+1);
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
       
        p.setValores(posicao.getLinha()+1, posicao.getColuna()-1);
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        
        p.setValores(posicao.getLinha()-1, posicao.getColuna()-1);
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }
        
        p.setValores(posicao.getLinha()-1, posicao.getColuna()+1);
        if(getTab().posicaoExist(p)&& canMove(p)){
            m[p.getLinha()][p.getColuna()]=true;
        }

        // if (getMoveCount()==0&&!part.getCheck()){
        //     position post=new position(posicao.getLinha(), posicao.getColuna()+3);
        //     if (testeTorre(post)){
        //         position p1=new position(posicao.getLinha(),posicao.getColuna()+1);
        //         position p2=new position(posicao.getLinha(),posicao.getColuna()+2);
        //         if (getTab().peca1(p1)==null&&getTab().peca1(p2)==null){
        //             m[posicao.getLinha()][posicao.getColuna()+2]=true;
        //         }

        //     }
        //     position post2=new position(posicao.getLinha(), posicao.getColuna()-4);
        //     if (testeTorre(post2)){
        //         position p1=new position(posicao.getLinha(), posicao.getColuna()-1);
        //         position p2=new position(posicao.getLinha(), posicao.getColuna()-2);
        //         position p3=new position(posicao.getLinha(), posicao.getColuna()-3);
        //         if (getTab().peca1(p1)==null&&getTab().peca1(p2)==null&&getTab().peca1(p3)==null){
        //             m[posicao.getLinha()][posicao.getColuna()-2]=true;
        //         }
        //     }
        // }
        




        return m;
    }
    
    
}
