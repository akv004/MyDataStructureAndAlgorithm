package my.util;

public class LinkedList<E> {

	transient Node<E> first;
	transient Node<E> last;
	
	transient int size =0;
	
	
	public void linkFirst(E e) {
		final Node<E> f = first;
		final Node<E> newNode = new Node<>(null, e, f);
		first = newNode;
		if(f==null) last = newNode; 
		else f.prev = newNode;
		size++;
			
		
	}
	
	public void linkLast(E e) {
		final Node<E> l = last;
		final Node<E> newNode = new Node<>(l, e, null);
		last = newNode;
		if(l == null) 
			first = newNode;
		else l.next = newNode;
		size++;
	}
	
	private static class Node<E>{
		E item;
		transient Node<E> next;
		transient Node<E> prev;
		
		Node(Node<E> prev, E element, Node<E> next){
			this.item = element;
			this.next = next;
			this.prev = prev;
		}		
	
	}
	
	
	public Node<E> getFirst() {
		return first;
	}


	public void setFirst(Node<E> first) {
		this.first = first;
	}


	public Node<E> getLast() {
		return last;
	}


	public void setLast(Node<E> last) {
		this.last = last;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "LinkedList [first=" + first + ", last=" + last + ", size=" + size + "]";
	}


	public static void main(String args[]) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.linkFirst(0);
		System.out.println("ll"+ ll);
		ll.linkFirst(-1);
		System.out.println("ll"+ ll);
		
		ll.linkLast(1);
		System.out.println("ll"+ ll);
		
	}
}
