package p05_GenericCountMethodString;

class Generic<T extends Comparable> {
    private T input;

    Generic(T input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return (input.getClass() + ": " + this.input).substring(6);
    }


    boolean compareTo(T comparedVal) {
        if (this.input.compareTo(comparedVal) > 0) {
            return true;
        }
        return false;
    }
}
