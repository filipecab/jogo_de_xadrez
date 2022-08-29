package entidades;

public class tabuleiro {
    private int linhas;
    private int colunas;
    private peca[][] pecas;
    public tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        pecas=new peca[linhas][colunas];
    }
    public int getLinhas() {
        return linhas;
    }
    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }
    public int getColunas() {
        return colunas;
    }
    public void setColunas(int colunas) {
        this.colunas = colunas;
    }
    
    public peca pecas(int linha, int coluna){
        return pecas[linha][coluna];
    }
    public peca pecas(position pos){
            return pecas[pos.getLinha()][pos.getColuna()];
    }
    
}
