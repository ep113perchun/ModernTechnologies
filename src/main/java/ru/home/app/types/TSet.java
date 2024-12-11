package ru.home.app.types;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс для работы с набором уникальных элементов.
 */
public class TSet {
    private Set<Object> setData;

    /**
     * Конструктор, создает пустое множество.
     */
    public TSet() {
        this.setData = new HashSet<>();
    }

    /**
     * Опустошение множества.
     */
    public void clear() {
        setData.clear();
    }

    /**
     * Добавление элемента в множество, если его нет.
     *
     * @param elem элемент для добавления
     */
    public void add(Object elem) {
        setData.add(elem);
    }

    /**
     * Удаление элемента из множества.
     *
     * @param elem элемент для удаления
     */
    public void remove(Object elem) {
        setData.remove(elem);
    }

    /**
     * Проверка, пустое ли множество.
     *
     * @return true, если множество пустое, иначе false
     */
    public boolean isEmpty() {
        return setData.isEmpty();
    }

    /**
     * Проверка, принадлежит ли элемент множеству.
     *
     * @param elem элемент для проверки
     * @return true, если элемент принадлежит множеству, иначе false
     */
    public boolean contains(Object elem) {
        return setData.contains(elem);
    }

    /**
     * Объединение с другим множеством.
     *
     * @param otherSet другое множество для объединения
     * @return новое множество, содержащее элементы обоих множеств
     */
    public Set<Object> union(TSet otherSet) {
        Set<Object> result = new HashSet<>(setData);
        result.addAll(otherSet.setData);
        return result;
    }

    /**
     * Пересечение с другим множеством.
     *
     * @param otherSet другое множество для пересечения
     * @return новое множество, содержащее общие элементы обоих множеств
     */
    public Set<Object> intersection(TSet otherSet) {
        Set<Object> result = new HashSet<>(setData);
        result.retainAll(otherSet.setData);
        return result;
    }

    /**
     * Вычитание другого множества.
     *
     * @param otherSet другое множество для вычитания
     * @return новое множество, содержащее элементы, которые есть только в этом множестве
     */
    public Set<Object> difference(TSet otherSet) {
        Set<Object> result = new HashSet<>(setData);
        result.removeAll(otherSet.setData);
        return result;
    }

    /**
     * Подсчет количества элементов в множестве.
     *
     * @return количество элементов в множестве
     */
    public int count() {
        return setData.size();
    }

    /**
     * Получение элемента по индексу.
     *
     * @param index индекс элемента
     * @return элемент на заданном индексе
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона
     */
    public Object getElement(int index) {
        if (index < 0 || index >= setData.size()) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
        return setData.toArray()[index];
    }
}