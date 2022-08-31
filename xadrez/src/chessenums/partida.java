package chessenums;


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
    private tabuleiro tab;


    public partida(){
        tab=new tabuleiro(8, 8);
        iniciarpartida();
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
    public pecaxadrez moverPecas(chessPosicao p, chessPosicao destino){
        position ori=p.toPosition();
        position des=destino.toPosition();
        validarPosicao(ori);
        peca capturapeca=mover(ori,des);
        return (pecaxadrez)capturapeca;
    }
    private void validarPosicao(position ori){
       if ( !tab.temPecaPos(ori)){
        throw new excp("não existe peca na posição");
       }
       if (!tab.peca1(ori).esteMovimentoPossivel()){
            throw new excp("Não existe movimentos possiver na peça escolhida");
       }
    }
    private peca mover(position ori, position des){
        peca p=tab.removePeca(ori);
        peca p1=tab.removePeca(des);
        tab.Inserepeca(p, des);
        return p1;
        }


    private void novaPosPeca(char coluna, int linha, pecaxadrez peca){
        tab.Inserepeca(peca, new chessPosicao(coluna, linha).toPosition());
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
}
