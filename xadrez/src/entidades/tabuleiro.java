package entidades;



import exception.excp_tab;

public class tabuleiro {
    private int linhas;
    private int colunas;
    private peca[][] pecas;
    public tabuleiro(int linhas, int colunas) {
        if (linhas<1||colunas<1){
            throw new excp_tab("Erro ao criar tabuleiro deve haver pelo menos 1 linha e  coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas=new peca[linhas][colunas];
    }
    public int getLinhas() {
        return linhas;
    }
   
    public int getColunas() {
        return colunas;
    }
   
    
    public peca pecas(int linha, int coluna){
        if (!posicaoExist1(linha, coluna)){
            throw new excp_tab("Posição não existe no tabuleiro");
        }
        return pecas[linha][coluna];
    }
    public peca peca1(position pos){
        if (!posicaoExist(pos)){
            throw new excp_tab("Posição não existe no tabuleiro");
        }
            return pecas[pos.getLinha()][pos.getColuna()];
    }
    public void Inserepeca(peca p,position ps){
        if (temPecaPos(ps)){
            throw new excp_tab("ja existe peça nessa posição "+ps);
        }
        pecas[ps.getLinha()][ps.getColuna()]=p;
        p.posicao=ps;
    }
    public boolean posicaoExist1(int linha,int coluna){
        return linha>=0 && linha<linhas && coluna>=0 && coluna<colunas;
    }

    public  boolean posicaoExist(position p){
        return posicaoExist1(p.getLinha(), p.getColuna());
    }
    public boolean temPecaPos(position p){
        if (!posicaoExist(p)){
            throw new excp_tab("Posição não existe no tabuleiro");
        }
        return peca1(p)!=null;
    }

    //public peca removePeca(position p){//

}