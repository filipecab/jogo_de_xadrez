package chessenums;



import java.nio.channels.IllegalSelectorException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entidades.peca;
import entidades.position;
import entidades.tabuleiro;
import exception.excp;
import tipopeca.bispo;
import tipopeca.cavalo;
import tipopeca.king;
import tipopeca.peao;
import tipopeca.rainha;
import tipopeca.torre;


public class partida {
    private int turno;
    private enums player;
    private tabuleiro tab;
    private boolean check;
    private boolean checkMate;
    private pecaxadrez promovida;
    private pecaxadrez vulneravel;

    private List<peca> pecasNotab=new ArrayList<>();
    private List<peca> pecasCapturadas=new ArrayList<>(); 

    public partida(){
        tab=new tabuleiro(8, 8);
        turno=1;
        check=false;
        player=enums.WHITE;
        iniciarpartida();
    }
    public int getTurno(){
        return turno;
    }
    public enums getPlayer(){
        return player;
    }

   public boolean getCheck(){
        return check;
   }
   public boolean getCheckMate(){
    return checkMate;
   }
   public pecaxadrez getPromovida(){
        return promovida;
   }
   public pecaxadrez getVulneravel(){
        return vulneravel;
   }



    public pecaxadrez[][] getPecas(){
        pecaxadrez[][] mat=new pecaxadrez[tab.getLinhas()][tab.getColunas()];
        for (int i=0;i<tab.getLinhas();i++){
            for (int j=0;j<tab.getColunas();j++){
                mat[i][j]=(pecaxadrez)tab.pecas(i, j);
            }
        }
        return mat;
 
    }
    public boolean[][] possiveisMovimentos(chessPosicao origem){
        position p=origem.toPosition();
        validarPosicao(p);
        return tab.peca1(p).PossivelMovimento();
    }


    public pecaxadrez moverPecas(chessPosicao p, chessPosicao destino){
        position ori=p.toPosition();
        position des=destino.toPosition();
        validarPosicao(ori);
        validarPosicaoDestino(ori,des);
        peca capturapeca=mover(ori,des);
        
       if (testeCheck(player)){
            desfazerMovimento(ori, des, capturapeca);
            throw new excp("voce não pode se alto colocar em check");
        }
        pecaxadrez pecamovida=(pecaxadrez)tab.peca1(des);
        promovida=null;
        if (pecamovida instanceof peao){
            if ((pecamovida.getCor()==enums.WHITE && des.getLinha()==0)||(pecamovida.getCor()==enums.BLACK&&des.getLinha()==7)){
                promovida=(pecaxadrez)tab.peca1(des);
                promovida=substituida("R");
            }
        }

        check=(testeCheck(oponente(player)))? true : false; 

        if (TestCheckMate(oponente(player))){
            checkMate = true;
            System.out.println("check mate");
            System.out.println("vencedor: "+player);
            }
        else{ 
          proximoTurno();
        }
        if(pecamovida instanceof peao &&(des.getLinha()==ori.getLinha()-2 || des.getLinha() == ori.getColuna()+2)){
            vulneravel=pecamovida;
        }
        else {
            vulneravel=null;
        }
        return (pecaxadrez)capturapeca;
    }
    public pecaxadrez substituida(String tipo){
        if (promovida==null){
            throw new IllegalStateException("não há peca a ser promovida");
        }
        if (!tipo.equals("B")&&!tipo.equals("C")&&!tipo.equals("R")&&!tipo.equals("T")){
            return promovida;
        }
        position pos=promovida.getChessPosicao().toPosition();
        peca p=tab.removePeca(pos);
        pecasNotab.remove(p);
        pecaxadrez novaPeca=newpeca(tipo, promovida.getCor());
        tab.Inserepeca(novaPeca, pos);
        pecasNotab.add(novaPeca);
        return novaPeca;

    }
    public pecaxadrez newpeca(String tipo, enums cor){
        if (tipo.equals("B")) return new bispo(tab, cor);
        if (tipo.equals("C")) return new cavalo(tab, cor);
        if (tipo.equals("R")) return new rainha(tab, cor);
        if (tipo.equals("T")) return new torre(tab, cor);
        return new torre(tab, cor);
    }


    private void validarPosicao(position ori){
       if ( !tab.temPecaPos(ori)){
            throw new excp("não existe peca na posição");
       }
       if (player!= ((pecaxadrez)tab.peca1(ori)).getCor()){
           throw new excp("essa peca é do seu adversário"); 
       }
       if (!tab.peca1(ori).esteMovimentoPossivel()){
            throw new excp("Não existe movimentos possiver na peça escolhida");
       }
    }

    private void validarPosicaoDestino(position ori,position des){
        if(!tab.peca1(ori).posMove(des)){
            throw new excp("A peça escolhida não pode se mover para a posição escolhida");
        }
    }

    private peca mover(position ori, position des){
        pecaxadrez p=(pecaxadrez)tab.removePeca(ori);
        p.incrementarMovimentocount();
        peca capturada=tab.removePeca(des);
        tab.Inserepeca(p, des);
        if (capturada!=null){
            pecasNotab.remove(capturada);
            pecasCapturadas.add(capturada);
        }
        if (p instanceof king && des.getColuna()==ori.getColuna()+2){
            position orit= new position(ori.getLinha(), ori.getColuna()+3);
            position dest=new position(ori.getLinha(), ori.getColuna()+1);
            pecaxadrez torre=(pecaxadrez)tab.removePeca(orit);
            tab.Inserepeca(torre, dest);
            torre.incrementarMovimentocount();
        }
        if (p instanceof king && des.getColuna()==ori.getColuna()-2){
            position orit=new position(ori.getLinha(), ori.getColuna()-4);
            position dest=new position(ori.getLinha(), ori.getColuna()-1);
            pecaxadrez torre=(pecaxadrez)tab.removePeca(orit);
            tab.Inserepeca(torre, dest);
            torre.incrementarMovimentocount();
        }
        if (p instanceof peao){
            if (ori.getColuna()!=des.getColuna()&& capturada==null){
                position posicaoPeao;
                if (p.getCor()==enums.WHITE){
                    posicaoPeao=new position(des.getLinha()+1, des.getColuna());
                }
                else{
                    posicaoPeao=new position(des.getLinha()-1, des.getColuna());
                }
                capturada=tab.removePeca(posicaoPeao);
                pecasCapturadas.add(capturada);
                pecasNotab.remove(capturada);
            }
        }


        return capturada; 
    }


    private void desfazerMovimento(position ori, position des, peca capturada){
        pecaxadrez p=(pecaxadrez)tab.removePeca(des);
        p.decrementarMovimentoCount();
        tab.Inserepeca(p, ori);
        if (capturada!=null){
            tab.Inserepeca(capturada, des);
            pecasCapturadas.remove(capturada);
            pecasNotab.add(capturada); 
        }
        if (p instanceof king && des.getColuna() == ori.getColuna() + 2) {
			position oriT = new position(ori.getLinha(), ori.getColuna() + 3);
			position desT = new position(ori.getLinha(), ori.getColuna() + 1);
			pecaxadrez torre = (pecaxadrez)tab.removePeca(desT);
			tab.Inserepeca(torre, oriT);
			torre.decrementarMovimentoCount();
        }
        if (p instanceof king && des.getColuna() == des.getColuna() - 2) {
			position oriT = new position(ori.getLinha(), ori.getColuna() - 4);
			position desT = new position(ori.getLinha(), ori.getColuna() - 1);
			pecaxadrez torre = (pecaxadrez)tab.removePeca(desT);
			tab.Inserepeca(torre, oriT);
			torre.decrementarMovimentoCount();
		}
        if (p instanceof peao) {
			if (ori.getColuna() != des.getColuna() && capturada == vulneravel) {
				pecaxadrez peao = (pecaxadrez)tab.removePeca(des);
				position posicaoPeao;
				if (p.getCor() == enums.WHITE) {
					posicaoPeao = new position(3, des.getColuna());
				}
				else {
					posicaoPeao = new position(4, des.getColuna());
				}
				tab.Inserepeca(peao, posicaoPeao);
			}
		}


    }

    private enums oponente(enums cor){
        return  (cor ==enums.WHITE) ? enums.BLACK : enums.WHITE;
    }

    private pecaxadrez king(enums cor){
        List<peca> list=pecasNotab.stream().filter(x -> ((pecaxadrez)x).getCor()== cor).collect(Collectors.toList());
        for (peca p: list){
            if (p instanceof king){
                return (pecaxadrez)p;
            }
        }
        throw new IllegalStateException("não existe rei dessa cor");
    } 
    private boolean testeCheck(enums cor){
        position Posicaoking=king(cor).getChessPosicao().toPosition();
        List<peca> pecaOponente=pecasNotab.stream().filter(x -> ((pecaxadrez)x).getCor()== oponente(cor)).collect(Collectors.toList());
        for (peca p: pecaOponente){
                boolean[][] mat = p.PossivelMovimento();
                if (mat[Posicaoking.getLinha()][Posicaoking.getColuna()]){
                   return true;  
                }
        }
          return false;
    } 
    private boolean TestCheckMate(enums cor){
        if(!testeCheck(cor)){
            return false;
        } 
        List<peca> list=pecasNotab.stream().filter(x -> ((pecaxadrez)x).getCor()==cor).collect(Collectors.toList());
        for (peca p: list){
                boolean[][] mat=p.PossivelMovimento();
                for (int i=0;i<tab.getLinhas();i++){
                    for (int j=0;i<tab.getColunas();j++){
                        if (mat[i][j]){
                            position ori=((pecaxadrez)p).getChessPosicao().toPosition();
                            position destino=new position(i,j);
                            peca capturarPeca=mover(ori,destino);
                            boolean aux=testeCheck(cor);
                            desfazerMovimento(ori, destino, capturarPeca);
                            if (!aux){
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    } 


     private void novaPosPeca(char coluna, int linha, pecaxadrez peca){
        tab.Inserepeca(peca, new chessPosicao(coluna, linha).toPosition());
        pecasNotab.add(peca); 
    } 
    



    private void iniciarpartida(){
        novaPosPeca('a',8,new torre(tab, enums.BLACK));
        novaPosPeca('b',8,new cavalo(tab, enums.BLACK));
        novaPosPeca('c',8,new bispo(tab, enums.BLACK));
        novaPosPeca('d',8,new king(tab,enums.BLACK,this));
        novaPosPeca('e',8,new rainha(tab, enums.BLACK));
        novaPosPeca('f',8,new bispo(tab, enums.BLACK));
        novaPosPeca('g',8,new cavalo(tab, enums.BLACK));
        novaPosPeca('h',8,new torre(tab, enums.BLACK));
        novaPosPeca('a',7,new peao(tab, enums.BLACK,this));              //peças pretas//
        novaPosPeca('b',7,new peao(tab, enums.BLACK,this));
        novaPosPeca('c',7,new peao(tab, enums.BLACK,this));
        novaPosPeca('d',7,new peao(tab, enums.BLACK,this));
        novaPosPeca('e',7,new peao(tab, enums.BLACK,this));
        novaPosPeca('f',7,new peao(tab, enums.BLACK,this));
        novaPosPeca('g',7,new peao(tab, enums.BLACK,this));
        novaPosPeca('h',7,new peao(tab, enums.BLACK,this));

        novaPosPeca('a',1,new torre(tab, enums.WHITE));
        novaPosPeca('b',1,new cavalo(tab, enums.WHITE));
        novaPosPeca('c',1,new bispo(tab, enums.WHITE));
        novaPosPeca('d',1,new king(tab,enums.WHITE,this));
        novaPosPeca('e',1,new rainha(tab, enums.WHITE));
        novaPosPeca('f',1,new bispo(tab, enums.WHITE));
        novaPosPeca('g',1, new cavalo(tab, enums.WHITE));
        novaPosPeca('h',1,new torre(tab, enums.WHITE));
        novaPosPeca('a',2,new peao(tab, enums.WHITE,this));              //peças pretas//
        novaPosPeca('b',2,new peao(tab, enums.WHITE,this));
        novaPosPeca('c',2,new peao(tab, enums.WHITE,this));
        novaPosPeca('d',2,new peao(tab, enums.WHITE,this));
        novaPosPeca('e',2,new peao(tab, enums.WHITE,this));
        novaPosPeca('f',2,new peao(tab, enums.WHITE,this));
        novaPosPeca('g',2,new peao(tab, enums.WHITE,this));
        novaPosPeca('h',2,new peao(tab, enums.WHITE,this));

    }

    private void proximoTurno(){
        turno++;
        player=(player==enums.WHITE)?enums.BLACK:enums.WHITE;
    }



}
