package ru.home.app.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс представляет собой полином с парами (коэффициент, степень).
 */
public class TPoly {
    private List<Term> terms;

    /**
     * Вспомогательный класс для хранения коэффициента и степени.
     */
    public static class Term {
        int coefficient;
        int degree;

        public Term(int coefficient, int degree) {
            this.coefficient = coefficient;
            this.degree = degree;
        }
    }

    /**
     * Конструктор полинома.
     * @param terms Пары (коэффициент, степень), представляющие члены полинома.
     */
    public TPoly(List<Term> terms) {
        this.terms = terms != null ? terms : new ArrayList<>();
        normalize();
    }

    public TPoly() {
        this.terms = new ArrayList<>();
    }

    /**
     * Нормализует полином: удаляет нулевые члены и сортирует по убыванию степени.
     */
    private void normalize() {
        terms.removeIf(term -> term.coefficient == 0);
        terms.sort((a, b) -> Integer.compare(b.degree, a.degree));
    }

    /**
     * Возвращает степень полинома.
     * @return Максимальная степень полинома.
     */
    public int degree() {
        if (terms.isEmpty()) return 0;
        return terms.get(0).degree;
    }

    /**
     * Возвращает коэффициент члена с заданной степенью.
     * @param n Степень, для которой требуется найти коэффициент.
     * @return Коэффициент члена с заданной степенью, либо 0, если такого члена нет.
     */
    public int coefficient(int n) {
        for (Term term : terms) {
            if (term.degree == n) {
                return term.coefficient;
            }
        }
        return 0;
    }

    /**
     * Возвращает строковое представление полинома.
     * @return Строковое представление полинома.
     */
    @Override
    public String toString() {
        if (terms.isEmpty()) return "0";
        StringBuilder result = new StringBuilder();
        for (Term term : terms) {
            if (!result.isEmpty()) result.append(" + ");
            if (term.degree == 0) {
                result.append(term.coefficient);
            } else {
                result.append(term.coefficient).append("x^").append(term.degree);
            }
        }
        return result.toString();
    }

    /**
     * Выполняет сложение текущего полинома с другим полиномом.
     * @param other Полином для сложения.
     * @return Новый полином, представляющий сумму.
     */
    public TPoly add(TPoly other) {
        List<Term> resultTerms = new ArrayList<>(terms);
        for (Term otherTerm : other.terms) {
            boolean found = false;
            for (int i = 0; i < resultTerms.size(); i++) {
                Term term = resultTerms.get(i);
                if (term.degree == otherTerm.degree) {
                    resultTerms.set(i, new Term(term.coefficient + otherTerm.coefficient, term.degree));
                    found = true;
                    break;
                }
            }
            if (!found) {
                resultTerms.add(new Term(otherTerm.coefficient, otherTerm.degree));
            }
        }
        return new TPoly(resultTerms);
    }

    /**
     * Вычисляет производную полинома.
     * @return Новый полином, представляющий производную.
     */
    public TPoly differentiate() {
        List<Term> differentiatedTerms = new ArrayList<>();
        for (Term term : terms) {
            if (term.degree > 0) {
                differentiatedTerms.add(new Term(term.coefficient * term.degree, term.degree - 1));
            }
        }
        return new TPoly(differentiatedTerms);
    }

    /**
     * Вычисляет значение полинома в заданной точке.
     * @param x Точка, в которой требуется вычислить значение полинома.
     * @return Значение полинома в точке x.
     */
    public int evaluate(int x) {
        int result = 0;
        for (Term term : terms) {
            result += (int) (term.coefficient * Math.pow(x, term.degree));
        }
        return result;
    }
}