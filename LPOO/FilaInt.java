package LPOO;

import java.util.LinkedList;

public class FilaInt {
	private LinkedList<Integer> fila;
	
	public FilaInt() {
		fila = new LinkedList<Integer>();
	}
	

	public boolean isEmpty() {
		if (fila.size()==0) {
			return true;
		}
		return false;
	}
	

	public Integer head () {
		if (this.isEmpty())
			return null;
		return fila.getFirst();
	}


	public void enqueue (int num) {
		fila.addLast(num);
	}
	

	public Integer dequeue () {
		if (this.isEmpty())
			return null;
		return (fila.removeFirst());
	}
	
    
	public int size() {
		return fila.size();
	}
}

