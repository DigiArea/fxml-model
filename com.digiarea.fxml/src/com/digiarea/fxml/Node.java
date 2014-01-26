package com.digiarea.fxml;

import com.digiarea.fxml.visitor.CloneVisitor;
import com.digiarea.fxml.visitor.EqualsVisitor;
import com.digiarea.fxml.visitor.GenericVisitor;
import com.digiarea.fxml.visitor.VoidVisitor;

public abstract class Node {

	private Node parent;

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	Node() {
		super();
	}

	public abstract <C> void accept(VoidVisitor<C> v, C ctx) throws Exception;

	public abstract <R, C> R accept(GenericVisitor<R, C> v, C ctx)
			throws Exception;

	private static final CloneVisitor<Void> CLONE = new CloneVisitor<Void>();

	@Override
	public final Node clone() throws CloneNotSupportedException {
		try {
			return accept(CLONE, null);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public final boolean equals(Object obj) {
		try {
			return EqualsVisitor.equals(this, (Node) obj);
		} catch (Exception e) {
			return false;
		}
	}

}
