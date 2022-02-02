/**
 * Add your file header
 * Name: Danny Lee
 * Email: dtl001@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 *None
 * 2-4 sentence file description here
 This class implements the linked list data structure. This is a doubly
 linked list with dummy head and tail nodes.
 */

import java.util.AbstractList;

/**
 * TODO: Add class header here
 This class implements the linked list data structure. This is a doubly
 linked list with dummy head and tail nodes.
 */

public class MyLinkedList<E> extends AbstractList<E> {

	int size;
	Node head;
	Node tail;

	/**
	 * A Node class that holds data and references to previous and next Nodes.
	 */
	protected class Node {
		E data;
		Node next;
		Node prev;

		/**
		 * Constructor to create singleton Node
		 * @param element Element to add, can be null
		 */
		public Node(E element) {
			// Initialize the instance variables
			this.data = element;
			this.next = null;
			this.prev = null;
		}

		/**
		 * Set the parameter prev as the previous node
		 * @param prev - new previous node
		 */
		public void setPrev(Node prev) {
			this.prev = prev;
		}

		/**
		 * Set the parameter next as the next node
		 * @param next - new next node
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 * Set the parameter element as the node's data
		 * @param element - new element
		 */
		public void setElement(E element) {
			this.data = element;
		}

		/**
		 * Accessor to get the next Node in the list
		 * @return the next node
		 */
		public Node getNext() {
			return this.next;
		}

		/**
		 * Accessor to get the prev Node in the list
		 * @return the previous node
		 */
		public Node getPrev() {
			return this.prev;
		}

		/**
		 * Accessor to get the Nodes Element
		 * @return this node's data
		 */
		public E getElement() {
			return this.data;
		}
	}

	//  Implementation of the MyLinkedList Class
	/** Only 0-argument constructor is defined */
	public MyLinkedList() {
		/* Add your implementation here */
		// TODO
		Node h = new Node(null);
		Node t = new Node(null);
		h.setNext(t);
		t.setPrev(h);
		this.head = h;
		this.tail = t;
		size=0;
	}

	@Override
	public int size() {
		// need to implement the size method
		return this.size;
	}

	@Override
	public E get(int index) {
		if(index<0 || index>=this.size){
			throw new IndexOutOfBoundsException();
		}
		Node cur = this.head;
		for(int i=0; i<index+1; i++){
			cur= cur.getNext();
		}
		return cur.getElement();
	}

	@Override
	public void add(int index, E data) {
		/* Add your implementation here */

		if(data == null){
			throw new NullPointerException();
		}
		if(index<0 || index>this.size){
			throw new IndexOutOfBoundsException();
		}

		Node cur = this.head;
		for(int i=0; i<index; i++){
			cur= cur.getNext();
		}
		Node newNode = new Node(data);
		newNode.setPrev(cur);
		newNode.setNext(cur.getNext());
		cur.getNext().setPrev(newNode);
		cur.setNext(newNode);
		size++;
	}

	public boolean add(E data) {
		if(data == null){
			throw new NullPointerException();
		}
		Node cur = tail.getPrev();
		Node newNode = new Node(data);
		newNode.setPrev(cur);
		newNode.setNext(cur.getNext());
		cur.getNext().setPrev(newNode);
		cur.setNext(newNode);
		size++;
		return true;
	}

	public E set(int index, E data) {
		if(data == null){
			throw new NullPointerException();
		}
		if(index<0 || index>=this.size){
			throw new IndexOutOfBoundsException();
		}
		Node cur = this.head;
		for(int i=0; i<index+1; i++){
			cur= cur.getNext();
		}
		E old = cur.getElement();
		cur.setElement(data);
		return data;
	}

	public E remove(int index) {
		if(index<0 || index>=this.size){
			throw new IndexOutOfBoundsException();
		}
		Node cur = this.head;
		for(int i=0; i<index; i++){
			cur= cur.getNext();
		}
		E data = cur.getNext().getElement();
		cur.setNext(cur.getNext().getNext());
		cur.getNext().setPrev(cur);
		size--;
		return data;
	}

	public void clear() {
		/* Add your implementation here */
		MyLinkedList newlist = new MyLinkedList();
		this.head.getNext().setPrev(null);
		this.tail.getPrev().setNext(null);
		this.head.setNext(this.tail);
		this.head.setPrev(this.head);

		size = 0;
	}

	public boolean isEmpty() {
		return this.head.getNext().equals(this.tail);
	}

	protected Node getNth(int index) {
		if(index<0 || index>=this.size){
			throw new IndexOutOfBoundsException();
		}
		Node ans = this.head;
		for(int i=0; i<index+1;i++){
			ans=ans.getNext();
		}
		return ans;
	}
}
