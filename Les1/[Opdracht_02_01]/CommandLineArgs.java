// CommandLineArgs.java

public class CommandLineArgs {
    public static void main(String[] args) {
        if (args.length > 2) {
            for (int i = 0; i < 3; i++) {
                System.out.println(args[i]);
            }
        } else {
            System.out.println("Please provide 3 arguments.");
        }
    }
}