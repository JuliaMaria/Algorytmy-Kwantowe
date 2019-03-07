import java.lang.Math;
import java.lang.String;

public class ComplexNumber {

    private double re;
    private double im;

    public double getRe() {
        return this.re;
    }

    public double getIm() {
        return this.im;
    }

    public double getTrigMagnitude() {
        return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
    }

    public double getTrigAngle() {
        return Math.atan(this.im/this.re);
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }
    // For Sum: re = real, im = imaginary
    // For Trig: re = magnitude, im = angle
    public ComplexNumber(double re, double im, Form form) {
        if (form.equals(Form.Trig)) {
            this.re = re*Math.cos(im);
            this.im = re*Math.sin(im);
        }
        else {
            this.re = re;
            this.im = im;
        }
    }

    public static ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        double resRe = num1.re + num2.re;
        double resIm = num1.im + num2.im;
        return new ComplexNumber(resRe, resIm);
    }

    public static ComplexNumber subtract(ComplexNumber num1, ComplexNumber num2) {
        double resRe = num1.re - num2.re;
        double resIm = num1.im - num2.im;
        return new ComplexNumber(resRe, resIm);
    }

    public static ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        double resRe = num1.re*num2.re-num1.im*num2.im;
        double resIm = num1.re*num2.im+num1.im*num2.re;
        return new ComplexNumber(resRe, resIm);
    }

    public static ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        double resRe = 0;
        double resIm = 0;
        if (num2.re != 0 || num2.im != 0) {
            resRe = (num1.re*num2.re+num1.im*num2.im)/(Math.pow(num2.re, 2)+Math.pow(num2.im, 2));
            resIm = (num1.im*num2.re-num1.re*num2.im)/(Math.pow(num2.re, 2)+Math.pow(num2.im, 2));
        }
        return new ComplexNumber(resRe, resIm);
    }

    public static double module(ComplexNumber num1) {
        double module = Math.sqrt(Math.pow(num1.re, 2)+Math.pow(num1.im, 2));
        return module;
    }

    public static ComplexNumber conjugate(ComplexNumber num1) {
        double result = -num1.im;
        return new ComplexNumber(num1.re, result);
    }

    public static ComplexNumber power(ComplexNumber num1, int power) {
        double num1Mag = num1.getTrigMagnitude();
        double num1Angle = num1.getTrigAngle();
        num1Mag = Math.pow(num1Mag, power);
        num1Angle = power*num1Angle;
        double re = num1Mag*Math.cos(num1Angle);
        double im = num1Mag*Math.sin(num1Angle);
        return new ComplexNumber(re, im);
    }
}
