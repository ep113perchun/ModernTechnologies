package ru.home.app.lab11_13;

import java.util.Arrays;
import java.util.List;
import static java.lang.Math.*;

public class Lab13 {

    /**
     * Вычисляет значение I на основе eta
     *
     * @param eta значение eta
     * @return количество уровней, рассчитанное как log2(eta) / 3 + 1
     */
    public static int I(int eta) {
        return (int) (log(eta) / log(2) / 3 + 1);
    }

    /**
     * Вычисляет значение K на основе eta и i
     *
     * @param eta значение eta
     * @param i значение i
     * @return общее количество, рассчитанное по формуле K(eta, i)
     */
    public static double K(int eta, int i) {
        double total = 1;
        for (int j = 1; j < i; j++) {
            total += eta / pow(8, j);
        }
        return total;
    }

    /**
     * Вычисляет значение N как произведение k и nk
     *
     * @param k значение k
     * @param nk значение nk
     * @return общее количество, равное k * nk
     */
    public static double N(double k, double nk) {
        return k * nk;
    }

    /**
     * Вычисляет значение Nk на основе eta2k
     *
     * @param eta2k значение eta2k
     * @return нормализованный ресурс, рассчитанный как 2 * eta2k * log2(eta2k)
     */
    public static double Nk(double eta2k) {
        return 2 * eta2k * (log(eta2k) / log(2));
    }

    /**
     * Вычисляет значение Eta2k на основе eta
     *
     * @param eta значение eta
     * @return усиленный ресурс, равный eta * log2(eta)
     */
    public static double Eta2k(int eta) {
        return eta * (log(eta) / log(2));
    }

    /**
     * Вычисляет значение V на основе k, nk и eta2k
     *
     * @param k значение k
     * @param nk значение nk
     * @param eta2k значение eta2k
     * @return объем ресурса, рассчитанный как k * nk * log2(2 * eta2k)
     */
    public static double V(double k, double nk, double eta2k) {
        return k * nk * (log(2 * eta2k) / log(2));
    }

    /**
     * Вычисляет значение P на основе n
     *
     * @param n значение n
     * @return процент от общего количества, равный 3 * n / 8
     */
    public static double P(double n) {
        return 3 * n / 8;
    }

    /**
     * Вычисляет значение Tk на основе p
     *
     * @param p значение p
     * @return коэффициент времени, равный p / (5 * 20)
     */
    public static double Tk(double p) {
        return p / (5 * 20);
    }

    /**
     * Вычисляет значение T на основе tk
     *
     * @param tk значение tk
     * @return половина времени Tk
     */
    public static double T(double tk) {
        return tk / 2;
    }

    /**
     * Вычисляет значение B0 на основе v
     *
     * @param v значение v
     * @return базовый параметр, равный v / 3000
     */
    public static double B0(double v) {
        return v / 3000;
    }

    /**
     * Вычисляет значение Tn на основе b0 и t
     *
     * @param b0 значение b0
     * @param t значение t
     * @return конечное значение, рассчитанное как t / log(b0)
     */
    public static double Tn(double b0, double t) {
        return t / log(b0);
    }

    public static void main(String[] args) {
        List<Integer> etas = Arrays.asList(300, 400, 512);

        for (int eta : etas) {
            int i = I(eta);
            double k = K(eta, i);
            double eta2k = Eta2k(eta);
            double nk = Nk(eta2k);
            double n = N(k, nk);
            double v = V(k, nk, eta2k);
            double p = P(n);
            double tk = Tk(p);
            double t = T(tk);
            double b0 = B0(v);
            double tn = Tn(b0, t);

            // Вывод результатов с пояснениями
            System.out.printf("Результаты для eta = %d:%n", eta);
            System.out.printf("i = %d  (Количество уровней, рассчитанное как log2(eta) / 3 + 1)%n", i);
            System.out.printf("K = %.4f  (Общее количество, рассчитанное по формуле K(eta, i))%n", k);
            System.out.printf("Eta2k = %.4f  (Усиленный ресурс, равный eta * log2(eta))%n", eta2k);
            System.out.printf("Nk = %.4f  (Нормализованный ресурс, рассчитанный как 2 * Eta2k * log2(Eta2k))%n", nk);
            System.out.printf("N = %.4f  (Общее количество, равное k * nk)%n", n);
            System.out.printf("V = %.4f  (Объем ресурса, рассчитанный как k * nk * log2(2 * Eta2k))%n", v);
            System.out.printf("P = %.4f  (Процент от общего количества, равный 3 * n / 8)%n", p);
            System.out.printf("Tk = %.4f  (Коэффициент времени, равный P / (5 * 20))%n", tk);
            System.out.printf("t = %.4f  (Половина времени Tk)%n", t);
            System.out.printf("B0 = %.4f  (Базовый параметр, равный V / 3000)%n", b0);
            System.out.printf("tn = %.4f  (Конечное значение, рассчитанное как t / log(B0))%n", tn);
            System.out.println("------------------------------------------\n");
        }
    }
}