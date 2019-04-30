package p01_GenericBox;

class Box<T> {

    private  T input;

    public Box(T input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return (input.getClass() + ": " + this.input).substring(6);
    }
}
