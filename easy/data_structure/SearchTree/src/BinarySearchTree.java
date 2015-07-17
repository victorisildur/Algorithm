public class BinarySearchTree<AnyType extends Comparable<?super AnyType>> {
	// AnyType is-a Comparable T, T is super class of AnyType
	private static class BinaryNode<AnyType> {
		BinaryNode( AnyType theElement ) {
			this(theElement, null, null);
		}
		BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
			element = theElement;
			left = lt;
			right = rt;
		}
		AnyType element;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
	}
	
	private BinaryNode<AnyType> root;

	public BinarySearchTree() {
		root = null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	public boolean isEmpty() {
		return root == null;
	}
	public boolean contains(AnyType x) {
		return contains(x,root);
	}
	/*
	public AnyType findMin(AnyType x) {
		if(isEmpty())
			throw new UnderflowException();
		return findMin(root).element;
	}
	public AnyType findMax(x) {
		if(isEmpty())
			throw new UnderflowException();
		return findMax(root).element;
	}
	*/
	public void insert(AnyType x) {
		root = insert(x,root);
	}
	/*
	public void remove(AnyType x) {
		root = remove(x,root);
	}
	*/
	// core functions
	public boolean contains(AnyType x,BinaryNode<AnyType> node) {
		if(node == null)
			return false;
		int cmpRes = x.compareTo(node.element);
		if( cmpRes > 0 )
			return contains(x,node.right);
		else if( cmpRes < 0 )
			return contains(x,node.left);
		else
			return false;
	}
	public BinaryNode<AnyType> insert(AnyType x , BinaryNode<AnyType> node) {
		if(null == node) {
			return new BinaryNode<AnyType>(x);
		}
		int cmpRes = x.compareTo(node.element);
		if( cmpRes > 0 ) {
			node.right = insert(x,node.right);
		} else if( cmpRes < 0 ) {
			node.left = insert(x,node.left);
		} else {
			;
		}
		return node;
	}
}