package LPOO;

import java.util.LinkedList;

public class PilhaInt {
	private LinkedList<Integer> pilha;
	
	public PilhaInt() {
		pilha = new LinkedList<Integer>();
	}
	

	public boolean isEmpty() {
		if (pilha.size()==0) {
			return true;
		}
		return false;
	}
	

	public Integer top () {
		if (this.isEmpty())
			return null;
		return pilha.getFirst();
	}


	public void push (int num) {
		pilha.addFirst(num);
	}
	

	public Integer pop () {
		if (this.isEmpty())
			return null;
		return (pilha.removeFirst());
	}
	
    
	public int size() {
		return pilha.size();
	}
}

