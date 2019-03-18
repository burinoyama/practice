package org.vin.link;

public class Item <T>{

	public T t;

	public Item next = null;

	public Item(T t) {
		this.t = t;
	}

}
