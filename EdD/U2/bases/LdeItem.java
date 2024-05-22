package EdD.U2.bases;


public class LdeItem {
	private NoDuploItem prim, ult;
	private int quant;
	


	public LdeItem () {
		this.prim = null;
		this.ult = null;
		this.quant=0;
	}



	public int getQuant() {
		return quant;
	}



	public NoDuploItem getPrim() {
		return prim;
	}



	public void setPrim(NoDuploItem prim) {
		this.prim = prim;
	}



	public NoDuploItem getUlt() {
		return ult;
	}



	public void setUlt(NoDuploItem ult) {
		this.ult = ult;
	}
	


	public boolean eVazio () {
		if (this.quant == 0) {
			return true;
		}
		return false;
	}
	


	public void insereInicio (Item item) {
		NoDuploItem novoNo = new NoDuploItem(item);
		
		if (this.eVazio()) {
			this.ult = novoNo;
		}else {
			novoNo.setProx(this.prim);
			this.prim.setAnt(novoNo);
		}
		this.prim = novoNo;
		this.quant++;
	}
	


	public void insereUltimo (Item item) {
		NoDuploItem novoNo = new NoDuploItem(item);
		
		if (this.eVazio()) {
			this.prim = novoNo;
		}else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quant++;
	}
	


	public NoDuploItem pesquisa (int num) {
		NoDuploItem aux = this.prim;
		
		while (aux != null) {
			if (aux.getItem().getCodigo() == num) {
				return aux;
			}
			aux = aux.getProx();
		}
		return aux;
	}
	


	public NoDuploItem remove (int num) {
		NoDuploItem aux = null;
		if (eVazio()) {
			return null;
		}
		if (this.quant == 1) {
			aux = this.prim;
			this.prim = this.prim.getProx();
			this.ult = this.ult.getAnt();
		}else if (this.prim.getItem().getCodigo()==num) {
			aux = this.prim;
			this.prim = this.prim.getProx();
			this.prim.setAnt(null);
			
		}else if (this.ult.getItem().getCodigo()==num) {
			aux = this.ult;
			this.ult = this.ult.getAnt();
			this.ult.setProx(null);
		}else {
			aux = pesquisa(num);
			if (aux==null) {
				return null;
			}else {
				NoDuploItem aux2 = aux.getAnt();
				aux2.setProx(aux.getProx());
				aux2 = aux.getProx();
				aux2.setAnt(aux.getAnt());
			}
		}
		this.quant--;
		return aux;
	}
	


	public String toString () {
		String temp="";
		NoDuploItem aux= this.prim;

		while (aux!=null) {
			temp += aux.getItem().getCodigo()+"  ";
			aux = aux.getProx();
		}
		return temp;
	}
	


	public String toStringInvertido () {
		String temp="";
		NoDuploItem aux= this.ult;

		while (aux!=null) {
			temp += aux.getItem().getCodigo()+"  ";
			aux = aux.getAnt();
		}
		return temp;
	}



	public NoDuploItem getNo (int pos) {
		NoDuploItem aux = this.prim;
		
		if (pos>=quant || pos<0) {
			return null;
		}
		// andar na lista ate a posicao pos
		for (int i=0; i<pos; i++) {
			aux = aux.getProx();
		}
		return aux;
	}


    
    public void insere(int pos, Item itemNovo){
        NoDuploItem posiçãoAtual = this.prim;
        NoDuploItem novo = new NoDuploItem(itemNovo);

        if (pos > quant || pos < 0) {
            System.out.println("Essa posição não existe.");
            return;
        }

        if (quant == 0) {
            insereInicio(itemNovo);

        } else if (quant == pos) {
            insereUltimo(itemNovo);

        } else {
            for (int i = 0; i<pos; i++){
                posiçãoAtual = posiçãoAtual.getProx();
            }
            NoDuploItem anterior = posiçãoAtual.getAnt();
            anterior.setProx(novo);
            novo.setAnt(anterior);
            novo.setProx(posiçãoAtual);
            posiçãoAtual.setAnt(novo);
            quant++;

        } 
    }



	public void remover(int pos){
        NoDuploItem posiçãoAtual = this.prim;

		if (eVazio()) {
			System.out.println("A lista está vazia, então não há como remover nada");
			return;
		}

        if (pos > quant || pos < 0) {
            System.out.println("Essa posição não existe.");
            return;
        }
		for (int i = 0; i<pos; i++){
			posiçãoAtual = posiçãoAtual.getProx();
		}

		NoDuploItem proximo = posiçãoAtual.getProx();
		NoDuploItem anterior = posiçãoAtual.getAnt();

		anterior.setProx(proximo);
		proximo.setAnt(anterior);
		remove(posiçãoAtual.getItem().getCodigo());
		quant--;

    }



	public void dividirListas(LdeItem lista1, LdeItem lista2){
		if (lista1.getQuant() == 0) {
			System.out.println("A primeira lista não pode estar vazia.");
			return;
		}

		if (lista2.getQuant() != 0) {
			System.out.println("A segunda lista precisa estar vazia.");
			return;
		}

		int divisao = lista1.getQuant()/2;
		NoDuploItem posiçãoAtual = lista1.getPrim();

		for (int i = 0; i<lista1.getQuant(); i++){
			if (i > divisao) {
				lista2.insereUltimo(lista1.getNo(i).getItem());
				lista1.remover(i);
				posiçãoAtual = posiçãoAtual.getProx();
			}
	
		}
		
		for (int i = divisao + 1; i < lista1.getQuant(); i++){

		}

	}
}

