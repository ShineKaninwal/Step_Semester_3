public abstract class Toy {

    private static int nextToyNumber = 1001;

    private final String toyId;
    protected String name;

    public Toy(String name) {
        this.name = name;
        this.toyId = "TOY-" + nextToyNumber++;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }
}
