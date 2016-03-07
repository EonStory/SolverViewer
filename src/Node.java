import java.util.ArrayList;
import java.util.List;

public class Node {
	
	Node root = null;
	List<Node> children = new ArrayList<Node>();
	
	int depth;
	
	int x;
	int y;
	
	
	public Node(List<Integer> betSize, List<Integer> betProbability, int callProbability, int foldProbability) {
		
	}
	
	public void addChild(Node n) {
		children.add(n);
	}
	
	
	
}
