package matrices;

public class Identity extends Matrix {

	/* constructor takes the length
	 * and returns an n*m identity matrix
	 */
	public Identity(int argLength) {
		super(new float[argLength][argLength]);
		for(int i = 0; i < getWidth(); i++) {
			for(int j = 0; j < getHeight(); j++) {
				if (i == j)
					setIndex(1,i,j);
				else
					setIndex(0,i,j);
			}
		}
	}
	
	public Identity(int argWidth, int argHeight) {
		super(new float[argWidth][argHeight]);
		for(int i = 0; i < getWidth(); i++) {
			for(int j = 0; j < getHeight(); j++) {
				if (i == j)
					setIndex(1,i,j);
				else
					setIndex(0,i,j);
			}
		}
	}
}
