package chessenums;

import entidades.position;
import entidades.tabuleiro;
import tipopeca.king;
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
        tab.Inserepeca(new torre(tab, enums.BLACK),new position(2,1));
        tab.Inserepeca(new king(tab,enums.BLACK), new position(0,4));
    }
}
