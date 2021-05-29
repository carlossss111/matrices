import matrices.*;

public class Main {
	
	//import matrix operations singleton as utility
	static MatrixOperations util = MatrixOperations.get();

	//demos constructors
	static void demoConstructors() {
		Matrix matrix1 = new Matrix(
				new float[][]{	{2, 0,-1},
								{0, 1, 3},
								{2,-2, 0}});
		System.out.println("Preset " + matrix1.getWidth() + "x" + matrix1.getHeight() + " matrix:");
		util.print(matrix1);
		
		System.out.println("Randomised 3x3 matrix (values between -5 and 5 inclusive):");
		Matrix matrix2 = new Matrix(3);
		util.print(matrix2);
		
		System.out.println("Randomised 1x3 matrix (values between -5 and 5 inclusive):");
		Matrix matrix3 = new Matrix(1,3);
		util.print(matrix3);
		
		System.out.println("Identity matrix 2x2:");
		Matrix matrix4 = new Identity(2);
		util.print(matrix4);
		
		System.out.println("Null matrix 2x2:");
		Matrix matrix5 = new Null(2);
		util.print(matrix5);
	}
	
	//demo addition function
	static void demoAdd(){
		Matrix matrix1 = new Matrix(
				new float[][]{	{1, 2, 3},
								{2, 2, 0},
								{1, 0, 1}});
		
		Matrix matrix2 = new Matrix(
				new float[][]{	{0, 5, 1},
								{0, 3, 1},
								{2, 0, 1}});
		
		System.out.println("Addition of two matrices:");
		util.print(util.add(matrix1, matrix2));
	}
	
	//demo multiplication with scalar function
	static void demoMultiplyByScalar() {
		Matrix matrix1 = new Matrix(
				new float[][]{	{2, 1, 0},
								{1, -1, 4}});
		
		System.out.println("Multiplication of a matrix by a scalar:");
		util.print(util.multiplyByScalar(matrix1, 2));
	}
	
	static void demoMultiply() {
		Matrix matrix1 = new Matrix(
				new float[][]{{1, 4, 0}});
		
		Matrix matrix2 = new Matrix(
				new float[][]{	{2},
								{-1},
								{5}});
		
		System.out.println("Multiplication of two matrices:");
		util.print(util.multiply(matrix1, matrix2));
		
		Matrix matrix3 = new Matrix(
				new float[][]{	{2, 7, 3, 1},
							  	{5, 0, 4, 1}});
		
		Matrix matrix4 = new Matrix(
				new float[][]{	{1, 2},
							  	{2, 5},
							  	{8, 0},
							  	{2, 2}});
		
		System.out.println("Multiplication of two matrices:");
		util.print(util.multiply(matrix3, matrix4));
		
		Matrix matrix5 = new Matrix(
				new float[][]{	{1, 0, 1},
							  	{2, 1, 0},
								{3, 1, 0}});
		
		Matrix matrix6 = new Matrix(
				new float[][]{	{2, 2, 4},
							  	{0, 0, 1},
								{2, 1, 0}});
		
		System.out.println("Multiplication of two matrices:");
		util.print(util.multiply(matrix5, matrix6));
	}
	
	//demo transposing
	static void demoTranspose() {
		Matrix matrix1 = new Matrix(
				new float[][]{	{2, 7, 3.4f, 1.3f},
								{5, 0, 4,    1}});
		
		System.out.println("Transposed matrix:");
		util.print(util.transpose(matrix1));
	}
	
	//demo determinant
	static void demoDeterminant() {
		Matrix matrix1 = new Matrix(
				new float[][]{	{1, 2},
							  	{5 , 6}});
		
		try { System.out.println("Determinant of matrix: " + matrix1.getDeterminant()); }
		catch (Exception e){ System.out.println(e.getMessage()); }
		System.out.println("Singular: "+ matrix1.isSingular());
		
		Matrix matrix2 = new Matrix(
				new float[][]{	{1, 2, 1},
								{0, 1, 1},
								{4, 2, 0}});
		
		try { System.out.println("Determinant of matrix: " + matrix2.getDeterminant()); }
		catch (Exception e){ System.out.println(e.getMessage()); }
		System.out.println("Singular: "+ matrix2.isSingular());
		
		Matrix matrix3 = new Matrix(
				new float[][]{	{3, 0, 2},
								{-1, 2, 1},
								{4, 2, 5}});
		
		try { System.out.println("Determinant of matrix: " + matrix3.getDeterminant()); }
		catch (Exception e){ System.out.println(e.getMessage()); }
		System.out.println("Singular: "+ matrix3.isSingular());
		
		Matrix matrix4 = new Matrix(
				new float[][]{	{1, 2, 3, 4},
								{-1, 2, 0, 5},
								{0, 4, -2, 6},
								{2, 4, 0, 6}});
		
		try { System.out.println("Determinant of matrix: " + matrix4.getDeterminant()); }
		catch (Exception e){ System.out.println(e.getMessage()); }
		System.out.println("Singular: "+ matrix4.isSingular());
		
		Matrix matrix5 = new Matrix(
				new float[][]{	{1, 0, 1},
								{3, 5, 13},
								{2, 2, 6}});
		
		try { System.out.println("Determinant of matrix: " + matrix5.getDeterminant()); }
		catch (Exception e){ System.out.println(e.getMessage()); }
		System.out.println("Singular: "+ matrix5.isSingular());
		
	}
	
	public static void main(String[] args) {
		demoConstructors();
		
		demoAdd();
		
		demoMultiplyByScalar();
		
		demoMultiply();
		
		demoTranspose();
		
		demoDeterminant();

	}
	
}
