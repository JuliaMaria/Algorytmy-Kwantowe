import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Qubit {

    private Vector vector;

    public static ComplexNumber[][] Xgate = {{new ComplexNumber(0, 0), new ComplexNumber(1, 0)}, {new ComplexNumber(1, 0), new ComplexNumber(0, 0)}};
    public static ComplexNumber[][] Ygate = {{new ComplexNumber(0, 0), new ComplexNumber(-1, 0)}, {new ComplexNumber(0, 1), new ComplexNumber(0, 0)}};
    public static ComplexNumber[][] Zgate = {{new ComplexNumber(1, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(-1, 0)}};
    public static ComplexNumber[][] Sgate = {{new ComplexNumber(1, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(0, 1)}};
    public static ComplexNumber[][] SDaggate = {{new ComplexNumber(1, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(0, -1)}};
    public static ComplexNumber[][] Hgate = {{new ComplexNumber(1/sqrt(2), 0), new ComplexNumber(1/sqrt(2), 0)}, {new ComplexNumber(1/sqrt(2), 0), new ComplexNumber(-1/sqrt(2), 0)}};
    public static ComplexNumber[][] Tgate = {{new ComplexNumber(1, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(1, Math.PI/4, Form.Trig)}};
    public static ComplexNumber[][] TDaggate = {{new ComplexNumber(1, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(1, -Math.PI/4, Form.Trig)}};

    public Qubit() {
        Random generator = new Random();
        double alphaSquared = generator.nextDouble();
        double betaSquared = 1 - alphaSquared;
        this.vector = new Vector(new ComplexNumber[] {new ComplexNumber(sqrt(alphaSquared), 0), new ComplexNumber(sqrt(betaSquared), 0)});
    }

    public Qubit(ComplexNumber[] coefficients) {
        this.vector = new Vector(coefficients);
    }

    public Vector getVector() {
        return this.vector;
    }

    public void printQubitState() {
        for (int i=0; i<this.vector.getCoefficients().length; i++) {
            System.out.println(this.vector.getCoefficients()[i].getRe()+" + "+this.vector.getCoefficients()[i].getIm()+"i");
        }
    }

    public void setVector(ComplexNumber[] coefficients) {
        this.vector = new Vector(coefficients);
    }

    public static Qubit applyGate(Qubit qubit, Gate gate) {
        ComplexNumber alpha = new ComplexNumber(0, 0);
        ComplexNumber beta = new ComplexNumber(0, 0);
        switch(gate) {
            case X:
                alpha = ComplexNumber.add(ComplexNumber.multiply(Xgate[0][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Xgate[0][1], qubit.vector.getCoefficients()[1]));
                beta = ComplexNumber.add(ComplexNumber.multiply(Xgate[1][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Xgate[1][1], qubit.vector.getCoefficients()[1]));
                break;
            case Y:
                alpha = ComplexNumber.add(ComplexNumber.multiply(Ygate[0][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Ygate[0][1], qubit.vector.getCoefficients()[1]));
                beta = ComplexNumber.add(ComplexNumber.multiply(Ygate[1][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Ygate[1][1], qubit.vector.getCoefficients()[1]));
                break;
            case Z:
                alpha = ComplexNumber.add(ComplexNumber.multiply(Zgate[0][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Zgate[0][1], qubit.vector.getCoefficients()[1]));
                beta = ComplexNumber.add(ComplexNumber.multiply(Zgate[1][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Zgate[1][1], qubit.vector.getCoefficients()[1]));
                break;
            case S:
                alpha = ComplexNumber.add(ComplexNumber.multiply(Sgate[0][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Sgate[0][1], qubit.vector.getCoefficients()[1]));
                beta = ComplexNumber.add(ComplexNumber.multiply(Sgate[1][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Sgate[1][1], qubit.vector.getCoefficients()[1]));
                break;
            case SDag:
                alpha = ComplexNumber.add(ComplexNumber.multiply(SDaggate[0][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(SDaggate[0][1], qubit.vector.getCoefficients()[1]));
                beta = ComplexNumber.add(ComplexNumber.multiply(SDaggate[1][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(SDaggate[1][1], qubit.vector.getCoefficients()[1]));
                break;
            case H:
                alpha = ComplexNumber.add(ComplexNumber.multiply(Hgate[0][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Hgate[0][1], qubit.vector.getCoefficients()[1]));
                beta = ComplexNumber.add(ComplexNumber.multiply(Hgate[1][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Hgate[1][1], qubit.vector.getCoefficients()[1]));
                break;
            case T:
                alpha = ComplexNumber.add(ComplexNumber.multiply(Tgate[0][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Tgate[0][1], qubit.vector.getCoefficients()[1]));
                beta = ComplexNumber.add(ComplexNumber.multiply(Tgate[1][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(Tgate[1][1], qubit.vector.getCoefficients()[1]));
                break;
            case TDag:
                alpha = ComplexNumber.add(ComplexNumber.multiply(TDaggate[0][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(TDaggate[0][1], qubit.vector.getCoefficients()[1]));
                beta = ComplexNumber.add(ComplexNumber.multiply(TDaggate[1][0], qubit.vector.getCoefficients()[0]), ComplexNumber.multiply(TDaggate[1][1], qubit.vector.getCoefficients()[1]));
                break;
            default:
                return new Qubit(new ComplexNumber[] {alpha, beta});
        }
        qubit.setVector(new ComplexNumber[] {alpha, beta});
        return new Qubit(new ComplexNumber[] {alpha, beta});
    }





}
