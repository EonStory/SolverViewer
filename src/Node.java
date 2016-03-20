import java.util.ArrayList;
import java.util.List;

public class Node {
	
	public final int actionHeight = 50;
	
	public static ArrayList<Level> levels = new ArrayList<Level>();
	
	Node root;
	List<Node> children = new ArrayList<Node>();
	
	//parent needed when Compressing tree: child cant move above parent.
	Node parent;
	
	//maybe needed to not use levels... simpler!
	Node neighborAbove;
	
	double metaHeight = 0;
	
	int depth = 0;
	
	int x = 0;
	int y = 0;
	
	double height;
	
	//callProbabiltiy and foldProbability are lists even thought they have at most 1 element
	//this way iterating over it is simple, no need to check there is a fold with logic etc
	public Node(Node root, List<Integer> betSize, List<Integer> betProbability, List<Integer> callProbability, List<Integer> foldProbability) {
		if (betSize.size() != betProbability.size()) {
			throw new IllegalArgumentException("betSize must be same length as betProbability");
		}
		this.root = root;
		height = (betSize.size() + callProbability.size() + foldProbability.size()) * actionHeight;
		metaHeight = height;
		
		
	}
	
	public void addChild(Node n) {
		children.add(n);
		
		n.depth = depth + 1;
		if (levels.size() < n.depth + 1) {
			levels.add(new Level());			
		}
		
		levels.get(n.depth).members.add(n);		
	}
	
	public static void addToSelfAndAllDescendents(Node n, double value) {
		n.y += value;
		for (Node c: n.children) {
			addToSelfAndAllDescendents(c, value);
		}
	}
	
	//a getter and setter all in one! :)
	//should only be used on the root node
	public double getSetMetaHeight() {		
		double sumOfChildren = 0;
		for (Node c: children) {
			sumOfChildren += c.getSetMetaHeight();
		}
		
		height = Math.max(sumOfChildren, height);
		return height;
	}
	
	
	public static void calculateY(Node n) {
		double runningTotal = 0;
		for (Node c: n.children) {
			addToSelfAndAllDescendents(c, runningTotal);
			runningTotal += c.metaHeight;
		}
		
		for (Node c: n.children) {
			calculateY(c);
		}
	}
}
