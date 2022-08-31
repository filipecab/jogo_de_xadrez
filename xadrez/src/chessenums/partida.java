package chessenums;

import entidades.position;
import entidades.tabuleiro;
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
    private void iniciarpartida(){
        tab.Inserepeca(new torre(tab, enums.BLACK),new position(0,0));
        tab.Inserepeca(new cavalo(tab, enums.BLACK),new position(0,1));
        tab.Inserepeca(new bispo(tab, enums.BLACK), new position(0,2));
        tab.Inserepeca(new king(tab,enums.BLACK), new position(0,3));
        tab.Inserepeca(new rainha(tab, enums.BLACK), new position(0,4));
        tab.Inserepeca(new bispo(tab, enums.BLACK),new position(0,5));
        tab.Inserepeca(new cavalo(tab, enums.BLACK), new position(0,6));
        tab.Inserepeca(new torre(tab, enums.BLACK), new position(0,7));
        tab.Inserepeca(new peao(tab, enums.BLACK), new position(1,0));              //peças pretas//
        tab.Inserepeca(new peao(tab, enums.BLACK), new position(1,1));
        tab.Inserepeca(new peao(tab, enums.BLACK), new position(1,2));
        tab.Inserepeca(new peao(tab, enums.BLACK), new position(1,3));
        tab.Inserepeca(new peao(tab, enums.BLACK), new position(1,4));
        tab.Inserepeca(new peao(tab, enums.BLACK), new position(1,5));
        tab.Inserepeca(new peao(tab, enums.BLACK), new position(1,6));
        tab.Inserepeca(new peao(tab, enums.BLACK), new position(1,7));

        tab.Inserepeca(new torre(tab, enums.WHITE), new position(7,0));
        tab.Inserepeca(new cavalo(tab, enums.WHITE), new position(7,1));
        tab.Inserepeca(new bispo(tab, enums.WHITE), new position(7,2));
        tab.Inserepeca(new king(tab,enums.WHITE), new position(7,3));
        tab.Inserepeca(new rainha(tab, enums.WHITE), new position(7,4));
        tab.Inserepeca(new bispo(tab, enums.WHITE),new position(7,5));
        tab.Inserepeca(new cavalo(tab, enums.WHITE), new position(7,6));
        tab.Inserepeca(new torre(tab, enums.WHITE), new position(7,7));
        tab.Inserepeca(new peao(tab, enums.WHITE), new position(6,0));              //peças brancas//
        tab.Inserepeca(new peao(tab, enums.WHITE), new position(6,1));
        tab.Inserepeca(new peao(tab, enums.WHITE), new position(6,2));
        tab.Inserepeca(new peao(tab, enums.WHITE), new position(6,3));
        tab.Inserepeca(new peao(tab, enums.WHITE), new position(6,4));
        tab.Inserepeca(new peao(tab, enums.WHITE), new position(6,5));
        tab.Inserepeca(new peao(tab, enums.WHITE), new position(6,6));
        tab.Inserepeca(new peao(tab, enums.WHITE), new position(6,7));



    }
}
