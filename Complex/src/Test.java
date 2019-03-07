public class Test {

    public static void main(String[] args) {
        /*
        ComplexNumber one = ComplexNumber.add(new ComplexNumber(-1, -6), new ComplexNumber(-1, 7));
        ComplexNumber two = ComplexNumber.subtract(new ComplexNumber(-1, -6), new ComplexNumber(-1, 7));
        ComplexNumber three = ComplexNumber.multiply(new ComplexNumber(1, -8), new ComplexNumber(-3, -1));
        ComplexNumber four = ComplexNumber.divide(new ComplexNumber(1, -8), new ComplexNumber(-3, -1));
        double five = ComplexNumber.module(new ComplexNumber(1, 1));
        ComplexNumber six = ComplexNumber.conjugate(new ComplexNumber(1, 1));
        System.out.println(Double.toString(one.getRe())+" "+Double.toString(one.getIm()));
        System.out.println(Double.toString(two.getRe())+" "+Double.toString(two.getIm()));
        System.out.println(Double.toString(three.getRe())+" "+Double.toString(three.getIm()));
        System.out.println(Double.toString(four.getRe())+" "+Double.toString(four.getIm()));
        System.out.println(five);
        System.out.println(Double.toString(six.getRe())+" "+Double.toString(six.getIm()));
        ComplexNumber seven = new ComplexNumber(2, 5.0*Math.PI/6, Form.Trig);
        System.out.println(Double.toString(seven.getRe())+" "+Double.toString(seven.getIm()));
        ComplexNumber eight = new ComplexNumber(5, -3);
        eight = ComplexNumber.power(eight, 2);
        System.out.println(Double.toString(eight.getRe())+" "+Double.toString(eight.getIm()));
        */

        ComplexNumber[] coef1 = new ComplexNumber[4];
        coef1[0] = new ComplexNumber(2, 3);
        coef1[1] = new ComplexNumber(0, -2);
        coef1[2] = new ComplexNumber(5, 0);
        coef1[3] = new ComplexNumber(0, 1);
        Vector v1 = new Vector(coef1);
        ComplexNumber[] coef2 = new ComplexNumber[4];
        coef2[0] = new ComplexNumber(0, -1);
        coef2[1] = new ComplexNumber(-1, 0);
        coef2[2] = new ComplexNumber(3, -1);
        coef2[3] = new ComplexNumber(-1, -1);
        Vector v2 = new Vector(coef2);

        Vector sum = Vector.sum(v1, v2);
        Vector multiplyByScalar = Vector.multiplyByScalar(v1, new ComplexNumber(2, 0));
        ComplexNumber dotProduct = Vector.dotProduct(v1, v2);
        ComplexNumber norm = Vector.norm(v1);

        for (int i = 0; i < sum.getSize(); i++) {
            System.out.println(Double.toString(sum.getCoefficients()[i].getRe())+" "+Double.toString(sum.getCoefficients()[i].getIm()));
        }
        for (int i = 0; i < multiplyByScalar.getSize(); i++) {
            System.out.println(Double.toString(multiplyByScalar.getCoefficients()[i].getRe())+" "+Double.toString(multiplyByScalar.getCoefficients()[i].getIm()));
        }
        System.out.println(Double.toString(dotProduct.getRe())+" "+Double.toString(dotProduct.getIm()));
        System.out.println(Double.toString(norm.getRe())+" "+Double.toString(norm.getIm()));

    }

}
