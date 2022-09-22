package chessenums;

import entidades.position;
import exception.excp;

public  class chessPosicao {
    private char coluna;
    private int linha;
    public chessPosicao(char coluna, int linha) {
        if (coluna <'a'||coluna>'h'||linha<1||linha>8 ){
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
        return new position(8-linha,coluna-'a');
    }
    protected static chessPosicao umaPosicao(position p){
        return new chessPosicao((char)('a'+p.getColuna()),8- p.getLinha());
    }
    @Override
    public String toString(){
        return ""+coluna+linha;
    }
    

    

    
}
