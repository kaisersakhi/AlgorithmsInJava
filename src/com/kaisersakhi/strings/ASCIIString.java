package com.kaisersakhi.strings;


//this class will work like StringBuilder but only on ASCII codes not unicodes
public class ASCIIString {
    private byte[] array;
    private int filledUpto;
    ASCIIString(){
        this.array = new byte[10];
        this.filledUpto = -1;
    }

    ASCIIString(int initialLength) {
        if (initialLength > 0)
            this.array = new byte[initialLength];
        else
            this.array = new byte[10];
        this.filledUpto = -1;
    }

    ASCIIString(String string){
        if (string.length() == 0) return;
        this.array = new byte[string.length()];
        this.filledUpto = -1;
        for (int i = 0; i < string.length(); ++ i){
            this.array[++this.filledUpto] = (byte) string.charAt(i);
        }
    }

    ASCIIString(ASCIIString string){
        this.array = new byte[string.length()];
        this.filledUpto = string.filledUpto;
        if (this.filledUpto + 1 >= 0) System.arraycopy(string.array, 0, this.array, 0, this.filledUpto + 1);
    }


    public void add(byte x){
        if (filledUpto == this.array.length -1) this.extendByteArray();
        this.array[++filledUpto] = x;
    }

    public byte charAt(int index){
        if (index >= 0 && index <= this.filledUpto){
            return this.array[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void setCharAt(char x, int index){
        this.setByteAt((byte)x, index);
    }

    public void setByteAt(byte x, int index){
        if (index >= 0 && index <= this.filledUpto){
            this.array[index] = x;
            return;
        }
        this.add(x);
    }

    public int length() {
        return  this.filledUpto + 1;
    }

    public String subString(int start, int end){
        return this.byteArrayToString(start, end);
    }

    @Override
    public String toString(){
        return this.byteArrayToString(0, filledUpto);
    }

    public boolean equals(ASCIIString otherObj) {
        if (this.length() != otherObj.length()) return false;

        for (int i = 0; i < this.length(); ++i){
            if (this.array[i] != otherObj.array[i]) return false;
        }
        return true;
    }

    public boolean equalsIgnoreCase(ASCIIString otherString){
        if (this.length() != otherString.length()) return false;
        ASCIIString string1 = this.lowerCase();
        ASCIIString string2 = otherString.lowerCase();
        for (int i = 0; i <= this.filledUpto; ++i){
            if (string1.array[i] != string2.array[i]) return false;
        }
        return true;
    }

    public ASCIIString lowerCase(){
        ASCIIString string = new ASCIIString(this);
        for (int i = 0; i <= this.filledUpto; ++i){
            if (string.array[i] >= 65 && string.array[i] <= 90){
                string.array[i] += 32;
            }
        }
        return string;
    }
    public ASCIIString upperCase(){
        ASCIIString string = new ASCIIString(this);
        for (int i = 0; i <= this.filledUpto; ++i){
            if (string.array[i] >= 97 && string.array[i] <= 122){
                string.array[i] -= 32;
            }
        }
        return string;
    }


    //this method will double the size and copy all the elements to new array
    private void extendByteArray(){
        byte[] newByteArray = new byte[this.array.length * 2];
        if (this.filledUpto + 1 >= 0)
            System.arraycopy(this.array, 0, newByteArray, 0, this.filledUpto + 1);
        this.array = newByteArray;
    }

    private String byteArrayToString(int start, int end){
        StringBuilder stringBuilder = new StringBuilder();
        end = Math.min(end, this.filledUpto);
        if (start >= 0 && start <= this.filledUpto){
           for (int i = start; i <= end; ++i){
               stringBuilder.append((char)this.array[i]);
           }
        }
        return stringBuilder.toString();
    }
}
