package dialog;

import java.util.Scanner;

public class CharacterDialogImpl implements Dialog<Character> {
    private static final Scanner scanner = new Scanner(System.in);
    private final String tittle;
    private final String failMessage;

    public CharacterDialogImpl(String tittle, String failMessage) {
        this.tittle = tittle;
        this.failMessage = failMessage;
    }

    @Override
    public Character input() {
        while (true) {
            System.out.println(tittle);

            String userInput = scanner.nextLine();


            if (userInput.isEmpty()) {
                System.out.println(failMessage);
                continue;
            }

            if (userInput.length() > 1) {
                System.out.println(failMessage);
                continue;
            }

            char symbol = userInput.charAt(0);

            if (!Character.isLetter(symbol)) {
                System.out.println(failMessage);
                continue;
            }
            return userInput.charAt(0);
        }
    }
}
