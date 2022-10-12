public class Main {

    public static final String INPUT_PATH = "names.txt";

    public static void main(String[] args) {

        final var reader = new Reader();
        final var result = reader.readByRelativePathByStaticClassReference(INPUT_PATH);
        final var otherResult = reader.readByRelativePathByInstanceReference(INPUT_PATH);

        System.out.println(result);
        System.out.println(otherResult);
    }
}
