
public class RootOperations {
	
	public double getSetMetaHeight(Node n) {		
		double sumOfChildren = 0;
		for (Node c: n.children) {
			sumOfChildren += getSetMetaHeight(c);
		}
		
		n.height = Math.max(sumOfChildren, n.height);
		return n.height;
	}
}
