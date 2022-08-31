package chessenums;

import entidades.position;
import exception.excp;

public  class chessPosicao {
    private char coluna;
    private int linha;
    public chessPosicao(char coluna, int linha) {
        if (coluna < 'A'||coluna>'H'||linha<0||linha>7 ){
            throw new excp("linha ou coluna incorreta");
        }      
        this.coluna = coluna;
        this.linha = linha;
    }
    public char getColuna() {
        return coluna;
    }
   
    public int getLinha() {
        return linha;
    }

    protected position toPosition(){
        return new position(linha,coluna-'A');
    }
    protected static chessPosicao umaPosicao(position p){
        return new chessPosicao((char)('A'-p.getColuna()), p.getLinha());
    }
    @Override
    public String toString(){
        return ""+coluna+linha;
    }
    

    

    
}
