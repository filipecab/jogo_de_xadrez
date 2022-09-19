package chessenums;


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
        check=(testeCheck(oponente(player)))? true : false;
        proximoTurno();
        return (pecaxadrez)capturapeca;
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
        peca p=tab.removePeca(ori);
        peca p1=tab.removePeca(des);
        tab.Inserepeca(p, des);
        if (p1!=null){
            pecasNotab.remove(p1);
            pecasCapturadas.add(p1);
        }
        return p1;
        }

    private void desfazerMovimento(position ori, position des, peca capturada){
        peca p=tab.removePeca(des);
        tab.Inserepeca(p, ori);
        if (capturada!=null){
            tab.Inserepeca(capturada, des);
            pecasCapturadas.remove(capturada);
            pecasNotab.add(capturada);
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
                boolean[] [] mat = p.PossivelMovimento();
                if (mat[Posicaoking.getLinha()][Posicaoking.getColuna()]){
                   return true;  
                }
        }
        return false;
    }


    private void novaPosPeca(char coluna, int linha, pecaxadrez peca){
        tab.Inserepeca(peca, new chessPosicao(coluna, linha).toPosition());
        pecasNotab.add(peca);
    }



    private void iniciarpartida(){
        novaPosPeca('A',0,new torre(tab, enums.BLACK));
        novaPosPeca('B',0,new cavalo(tab, enums.BLACK));
        novaPosPeca('C',0,new bispo(tab, enums.BLACK));
        novaPosPeca('D',0,new king(tab,enums.BLACK));
        novaPosPeca('E',0,new rainha(tab, enums.BLACK));
        novaPosPeca('F',0,new bispo(tab, enums.BLACK));
        novaPosPeca('G',0,new cavalo(tab, enums.BLACK));
        novaPosPeca('H',0,new torre(tab, enums.BLACK));
        novaPosPeca('A',1,new peao(tab, enums.BLACK));              //peças pretas//
        novaPosPeca('B',1,new peao(tab, enums.BLACK));
        novaPosPeca('C',1,new peao(tab, enums.BLACK));
        novaPosPeca('D',1,new peao(tab, enums.BLACK));
        novaPosPeca('E',1,new peao(tab, enums.BLACK));
        novaPosPeca('F',1,new peao(tab, enums.BLACK));
        novaPosPeca('G',1,new peao(tab, enums.BLACK));
        novaPosPeca('H',1,new peao(tab, enums.BLACK));

        novaPosPeca('A',7,new torre(tab, enums.WHITE));
        novaPosPeca('B',7,new cavalo(tab, enums.WHITE));
        novaPosPeca('C',7,new bispo(tab, enums.WHITE));
        novaPosPeca('D',7,new king(tab,enums.WHITE));
        novaPosPeca('E',7,new rainha(tab, enums.WHITE));
        novaPosPeca('F',7,new bispo(tab, enums.WHITE));
        novaPosPeca('G',7,new cavalo(tab, enums.WHITE));
        novaPosPeca('H',7,new torre(tab, enums.WHITE));
        novaPosPeca('A',6,new peao(tab, enums.WHITE));              //peças pretas//
        novaPosPeca('B',6,new peao(tab, enums.WHITE));
        novaPosPeca('C',6,new peao(tab, enums.WHITE));
        novaPosPeca('D',6,new peao(tab, enums.WHITE));
        novaPosPeca('E',6,new peao(tab, enums.WHITE));
        novaPosPeca('F',6,new peao(tab, enums.WHITE));
        novaPosPeca('G',6,new peao(tab, enums.WHITE));
        novaPosPeca('H',6,new peao(tab, enums.WHITE));

    }

    private void proximoTurno(){
        turno++;
        player=(player==enums.WHITE?enums.BLACK:enums.WHITE);
    }



}
