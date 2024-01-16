package service.parsers;

public abstract class Parser <T> {
    private T value;
    private final String name;

    public Parser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public T getValue(){return value;}
    public void resetValue() {
        value = null;
    }
    public abstract boolean parseToClass(String string );

}
