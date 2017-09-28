/*
    CO225
    Lab05: Matrix Multiplication
    E/14/158 gihanchanaka@gmail.com
    2017-sept-24
 */
public class MatrixDimensionMismatch extends Exception{
	/*
		Seriously? Do I need to comment something about this?
	*/

    @Override
    public String toString() {
        return "The matrix dimensions doesnt match for multiplication";
    }
}
