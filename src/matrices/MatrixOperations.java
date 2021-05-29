package matrices;

public class MatrixOperations {
	
	//singleton design pattern
	static MatrixOperations singleton = null;
	private MatrixOperations() {}
	
	//singleton design pattern getter
	public static MatrixOperations get() {
		if(singleton == null)
			singleton = new MatrixOperations();
		return singleton;
	}
	
	//prints matrix by looping through row by row, column by column
	public void print(Matrix m) {
		for(int i = 0; i < m.getWidth(); i++) {
			for(int j = 0; j < m.getHeight(); j++) {
				System.out.print("" + m.getIndex(i,j) + ", ");
			}
			System.out.print("\n");
		}
		System.out.println();
	}
	
	//adds two matrices together and returns the sum matrix
	public Matrix add(Matrix first, Matrix second) {
		Matrix sum = new Null(first.getWidth(), first.getHeight());
		
		//addition cannot be performed if the sizes of both are not the same
		if(first.getWidth() != second.getWidth() | first.getWidth() != second.getWidth()) {
			System.out.println("Cannot perform addition! Both matrices need to have the same size.");
			return null;
		}
		
		//∀i,j: c[i,j] = a[i,j] + b[i,j]
		for(int i = 0; i < sum.getWidth(); i++) {
			for(int j = 0; j < sum.getHeight(); j++) {
				sum.setIndex(first.getIndex(i,j) + second.getIndex(i,j), i, j);
			}
		}
		return sum;
	}
	
	//multiply a matrix by a scalar and return the resulting matrix
	public Matrix multiplyByScalar(Matrix m, float scalar) {
		Matrix product = new Null(m.getWidth(), m.getHeight());
		
		//∀i,j: c[i,j] = λa[i,j]
		for(int i = 0; i < m.getWidth(); i++) {
			for(int j = 0; j < m.getHeight(); j++) {
				product.setIndex(m.getIndex(i,j) * scalar, i, j);
			}
		}
		return product;
	}
	
	//multiply two matrices together
	public Matrix multiply(Matrix first, Matrix second) {
		Matrix product = new Null(first.getWidth(), second.getHeight());
				
		//multiplication can only be performed if the number of columns in the first matrix is equal
		//to the number of rows in the second matrix.
		if(first.getWidth() != second.getHeight()) {
			System.out.println("Cannot perform multiplication! Both matrices need to have compatible sizes.");
			return null;
		}
		
		//Σ(n,k=1)a[i,k]b[k,j]
		for(int i = 0; i < product.getWidth(); i++) {
			for(int j = 0; j < product.getHeight(); j++) {

				float sum = 0f;
				for(int k = 0; k < first.getHeight(); k++) {
					sum += (first.getIndex(i,k) * second.getIndex(k, j));
				}
				product.setIndex(sum, i, j);
			}
		}

		return product;
	}
	
	//transpose a matrix and return it
	public Matrix transpose(Matrix m) {
		Matrix transposed = new Null(m.getHeight(),m.getWidth());
		
		//∀i,j: a[j,i] = t[i,j]
		for(int i = 0; i < transposed.getHeight(); i++) {
			for(int j = 0; j < transposed.getWidth(); j++) {
				transposed.setIndex(m.getIndex(i, j), j, i);
			}
		}
		return transposed;
	}

}
