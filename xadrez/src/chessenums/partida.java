package chessenums;

import entidades.tabuleiro;

public class partida {
    private tabuleiro tab;


    public partida(){
        tab=new tabuleiro(8, 8);
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
}
