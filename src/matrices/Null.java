package matrices;

public class Null extends Matrix {

	/* Constructor takes the length
	 * and returns an n*m null matrix 
	 */
	public Null(int argLength) {
		super(new float[argLength][argLength]);
		for(int i = 0; i < getWidth(); i++) {
			for(int j = 0; j < getHeight(); j++)
				setIndex(0,i,j);
		}
	}
	
	public Null(int argWidth, int argHeight) {
		super(new float[argWidth][argHeight]);
		for(int i = 0; i < getWidth(); i++) {
			for(int j = 0; j < getHeight(); j++)
				setIndex(0,i,j);
		}
	}
}