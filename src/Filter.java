
public class Filter {
	
	public boolean[] data = new boolean[Holecards.numberOfHolecards];
	
	public Filter() {
		
	}
	
	public void invert() {
		for (int i = 0; i < data.length; i++) {
			data[i] = !data[i];
		}
	}
	
	public void add(int[] indices) {
		for (int i = 0; i < indices.length; i++) {
			data[indices[i]] = true;
		}
	}
	
	public void subtract(int[] indices) {
		for (int i = 0; i < indices.length; i++) {
			data[indices[i]] = false;
		}
	}
	
	
}
