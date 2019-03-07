import java.util.Arrays;
import java.lang.Math;

public class Vector {

    private ComplexNumber[] coefficients;
    private int size;

    public Vector(ComplexNumber[] coefficients) {
        this.coefficients = coefficients;
        this.size = coefficients.length;
    }

    public ComplexNumber[] getCoefficients() {
        return this.coefficients;
    }

    public int getSize() {
        return this.size;
    }

    public static Vector sum(Vector v1, Vector v2) {
        ComplexNumber[] newCoefficients = new ComplexNumber[v1.size];
        Arrays.setAll(newCoefficients, i -> ComplexNumber.add(v1.coefficients[i], v2.coefficients[i]));
        return new Vector((newCoefficients));
    }

    public static Vector multiplyByScalar(Vector v1, ComplexNumber alpha) {
        ComplexNumber[] newCoefficients = new ComplexNumber[v1.size];
        Arrays.setAll(newCoefficients, i -> ComplexNumber.multiply(v1.coefficients[i], alpha));
        return new Vector((newCoefficients));
    }

    public static ComplexNumber dotProduct(Vector v1, Vector v2) {
        ComplexNumber[] result = new ComplexNumber[v1.size];
        for (int i = 0; i < result.length; i++) {
            result[i] = ComplexNumber.multiply(v1.getCoefficients()[i], ComplexNumber.conjugate(v2.getCoefficients()[i]));
        }
        ComplexNumber sum = new ComplexNumber(0, 0);
        for (int i = 0; i < result.length; i++) {
            sum = ComplexNumber.add(sum, result[i]);
        }
        return sum;
    }

    public static ComplexNumber norm(Vector v1) {
        ComplexNumber dotProduct = Vector.dotProduct(v1, v1);
        double norm = Math.sqrt(dotProduct.getRe());
        return new ComplexNumber(norm, 0);
    }

}
