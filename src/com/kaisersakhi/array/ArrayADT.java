package com.kaisersakhi.array;

import org.jetbrains.annotations.NotNull;

public class ArrayADT<Type> {
    private Type[] base; //generic array ref.
    //user is unaware of the size,
    // get() will throw exception even though it might be in size range, but it is not in length range
    private int size;  // will track the size of the array
    private int length; // will track the number of elements in the array

    ArrayADT() {
        this.size = 10;
        this.base = createArrayInstance(this.size);
        this.length = 0;
    }

    ArrayADT(int size) {
        if (size > 0) {
            this.size = size;
            this.base = createArrayInstance(this.size);
            this.length = 0;
        }
    }

    ArrayADT(Type[] tempArray) {
        this.size = tempArray.length * 2;
        this.length = tempArray.length;
        this.base = createArrayInstance(this.size);
        System.arraycopy(tempArray, 0, this.base, 0, this.length);
    }

    public int length() {
        return this.length + 1;
    }

    public void add(Type item) {
        if (this.length >= this.size) this.expandArray();
        this.base[this.length++] = item;
    }

    private void expandArray() {
        this.size *= 2;
        Type[] tempBase = createArrayInstance(this.size);
        System.arraycopy(this.base, 0, tempBase, 0, this.length + 1);
        this.base = tempBase;
    }

    public Type get(int index) {
        if (index < 0 || index > this.length) throw new ArrayIndexOutOfBoundsException();
        return this.base[index];
    }

    public String toString() {
        StringBuilder string = new StringBuilder("[ ");
        for (int i = 0; i < this.length; ++i) {
            string.append(this.base[i]);
            string.append(", ");
        }
        string.delete(string.length() - 2, string.length());
        string.append(" ]");
        return string.toString();
    }

    private Type[] createArrayInstance(int size) {
        return (Type[]) new Object[size];
    }

    public void forEach(ForEachIterator forEachIterator) {
        for (int i = 0; i < this.length; ++i) {
            forEachIterator.get(this.base[i]);
        }
    }

    public int find(Type element) {
        for (int i = 0; i < this.length; ++i) {
            if (this.base[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public Type delete(int index) {
        if (index < 0 || index >= this.length) return null;

        Type item = this.base[index];

        for (int i = index + 1; i < this.length; ++i) {
            this.base[i - 1] = this.base[i];
        }
        --this.length;
        return item;
    }

    public Type delete(Type item){
        return this.delete(this.find(item));
    }

    public Type set(Type item, int index){
        if (index < 0 || index >= this.length) {
            this.add(item);
            return item;
        }
        Type tempItem = this.base[index];
        this.base[index] = item;
        return tempItem;
    }


    public ArrayADT<Type> reverse(){
        Type[] tempArray = createArrayInstance(this.length);
        int j = this.length -1;
        for (int i = 0; i < this.length; ++i){
            tempArray[j--] = this.base[i];
        }
        return new ArrayADT<>(tempArray);
    }


}

interface ForEachIterator {
    void get(Object obj);
}