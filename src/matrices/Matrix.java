package matrices;
import java.util.Random;
import java.lang.Math;

public class Matrix {
	//2d array containing the matrix
	private float[][] index;
	//width defined in constructor
	private int width;
	//height defined in constructor
	private int height;

	/* Default constructor takes an array
	 * and implements it as an array object
	 */
	public Matrix(float[][] inputArray) {
		index = inputArray;
		width = index.length;
		height = index[0].length;
	}
	
	/* Constructor takes an arg for width/height,
	 * fills the array with random ints between -5 and 5.
	 */
	public Matrix(int argLength) {
		width = argLength;
		height = argLength;
		index = new float[width][height];
		Random rand = new Random();
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				index[i][j] = (float) rand.nextInt(10);
				index[i][j] -= 5f;
			}
		}
	}
	
	/* Constructor takes two args for width & height,
	 * fills the array with random ints between -5 and 5.
	 */
	public Matrix(int argWidth, int argHeight) {
		width = argWidth;
		height = argHeight;
		index = new float[width][height];
		Random rand = new Random();
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				index[i][j] = (float) rand.nextInt(10);
				index[i][j] -= 5f;
			}
		}
	}
	
	//standard getters and setters
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setIndex(float input, int i, int j) {
		try { index[i][j] = input; }
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Index is out of bounds!\n[" + e + "]");
		}
	}
	
	public float getIndex(int i, int j) {
		try { return index[i][j]; }
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Index is out of bounds - may return odd results!\n[" + e +"]");
			return 1f;
		}
	}
	
	//returns cofactor, used to find the determinant recursively
	public float getCofactorAtIndex(int i, int j) throws Exception{
		Matrix complement = new Null(getWidth() - 1, getHeight() - 1);
		int x = 0; int y = 0;

		//this is kind of cursed and I should probably rewrite it. Works though (as far as I can tell).
		//fills in the complement matrix
		for(int k = 0; k < getWidth(); k++) {
			for(int l = 0; l < getHeight(); l++) {
				if(k != i | l != j) {
					if(x < complement.getWidth() && y < complement.getHeight())
						complement.setIndex(getIndex(k,l), x, y);
				}
				if(l != j)
					y++;
			}
			y = 0;
			if(k != i)
				x++;
		}
		
		//A[i,j] = (-1)^(i+j) * M[i,j]
		return (float) (Math.pow(-1,i+j) * complement.getDeterminant());
	}
	
	//returns determinant using Laplace I
	public float getDeterminant() throws Exception{
		float det = 0;
		
		if(getWidth() != getHeight())
			throw new Exception("Exception: Only square matrices have determinants!");
		
		//base cases
		if (getWidth() == 2) 
			det = getIndex(0,0)*getIndex(1,1) - getIndex(0,1)*getIndex(1,0);
		else if(getWidth() == 1)
			det = getIndex(0,0);
		
		else {
			//Σ(n, j=1)a[i,j]A[i,j]
			int i = 0; //take the first row only
			for(int j = 0; j < getWidth(); j++) {
				det += (getIndex(i,j) * getCofactorAtIndex(i,j));
			}
		}
		return det;
	}
	
	public boolean isSingular() {
		try {
			if(getDeterminant() == 0f)
				return true;
			return false;
		}
		catch (Exception e){ return false;}
	}
}
