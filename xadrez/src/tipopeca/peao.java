package tipopeca;

import entidades.tabuleiro;
import chessenums.enums;
import chessenums.partida;
import chessenums.pecaxadrez;
import entidades.position;

public class peao extends pecaxadrez {
    private partida part;

    public peao(tabuleiro tab, enums cor,partida part) {
        super(tab, cor);
        this.part=part;
 }
    
    public String toString(){
        return "p";
    }

    @Override
    public boolean[][] PossivelMovimento() {                                                //Verifica e traz as possiveis posições de uma peca em todos os lados
        boolean[][] m=new boolean[getTab().getLinhas()][getTab().getColunas()];
        position p= new position(0,0);
        if (getCor() == enums.WHITE) {
			p.setValores(posicao.getLinha()-1, posicao.getColuna());
			if (getTab().posicaoExist(p) && !getTab().temPecaPos(p)) {
				m[p.getLinha()][p.getColuna()] = true;
			}
            if (getTab().posicaoExist(p) && posicaoTemOpenente(p)) {
				m[p.getLinha()][p.getColuna()] = true;
			}	
			p.setValores(posicao.getLinha() - 2, posicao.getColuna());
			position p2 = new position(posicao.getLinha() - 1, posicao.getColuna());
			if (getTab().posicaoExist(p) && !getTab().temPecaPos(p) && getTab().posicaoExist(p2) && !getTab().temPecaPos(p2) && getMoveCount() == 0) {
				m[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTab().posicaoExist(p) && posicaoTemOpenente(p)) {
				m[p.getLinha()][p.getColuna()] = true;
			}			
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTab().posicaoExist(p) && posicaoTemOpenente(p)) {
				m[p.getLinha()][p.getColuna()] = true;
			}	
			
			
			if (posicao.getLinha() == 3) {
				position esqeurda = new position(posicao.getLinha(), posicao.getColuna() - 1);
				if (getTab().posicaoExist(esqeurda) && posicaoTemOpenente(esqeurda) && getTab().peca1(esqeurda) == part.getVulneravel()) {
					m[esqeurda.getLinha() - 1][esqeurda.getColuna()] = true;
				}
				position direita = new position(posicao.getLinha(), posicao.getColuna() + 1);
				if (getTab().posicaoExist(direita) && posicaoTemOpenente(direita) && getTab().peca1(direita) == part.getVulneravel()) {
					m[direita.getLinha() - 1][direita.getColuna()] = true;
				}
			}
		}
        else {
			p.setValores(posicao.getLinha() + 1, posicao.getColuna());
			if (getTab().posicaoExist(p) && !getTab().temPecaPos(p)) {
				m[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() + 2, posicao.getColuna());
			position p2 = new position(posicao.getLinha() + 1, posicao.getColuna());
			if (getTab().posicaoExist(p) && !getTab().temPecaPos(p) && getTab().posicaoExist(p2) && !getTab().temPecaPos(p2) && getMoveCount() == 0) {
				m[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if (getTab().posicaoExist(p) && posicaoTemOpenente(p)) {
				m[p.getLinha()][p.getColuna()] = true;
			}			
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTab().posicaoExist(p) && posicaoTemOpenente(p)) {
				m[p.getLinha()][p.getColuna()] = true;
			}
			
			
			if (posicao.getLinha() == 4) {
				position esqeurda = new position(posicao.getLinha(), posicao.getColuna() - 1);
				if (getTab().posicaoExist(esqeurda) && posicaoTemOpenente(esqeurda) && getTab().peca1(esqeurda) == part.getVulneravel()) {
					m[esqeurda.getLinha() + 1][esqeurda.getColuna()] = true;
				}
				position direita = new position(posicao.getLinha(), posicao.getColuna() + 1);
				if (getTab().posicaoExist(direita) && posicaoTemOpenente(direita) && getTab().peca1(direita) == part.getVulneravel()) {
					m[direita.getLinha() + 1][direita.getColuna()] = true;
				}
			}			
		}
        
        return m;
    }
 }
