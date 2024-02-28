public class Nationality {

    private static String commonLanguage = "English";
    private String name;
    private String nativeLanguage;

    public Nationality(String name, String nativeLanguage) {
        this.name = name;
        this.nativeLanguage = nativeLanguage;
    }

    public void introduce() {
        System.out.println("Hello, I am " + name + ".");
        System.out.println("I speak " + nativeLanguage + " as my native language.");
        System.out.println("The common language in our nationality is " + commonLanguage + ".");
    }

    public static void main(String[] args) {
        Nationality american = new Nationality("John", "English");
        Nationality french = new Nationality("Marie", "French");

        american.introduce();
        System.out.println();

        french.introduce();
    }
}
