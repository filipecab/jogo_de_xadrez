package entidades;

public class position{
    private int linha;
    private int coluna;

    
    public position() {
    }


    public position(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }


    public int getLinha() {
        return linha;
    }


    

    public int getColuna() {
        return coluna;
    }


   public void setValues(int linha, int coluna){
        this.linha=linha;
        this.coluna=coluna;

   }

   @Override
   public String toString(){
    return linha+", "+coluna;
   }

    



}