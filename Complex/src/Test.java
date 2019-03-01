public class Test {

    public static void main(String[] args) {
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

    }

}
