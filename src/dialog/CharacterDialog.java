package dialog;

public class CharacterDialog extends DialogImpl<Character> {
    public CharacterDialog(String tittle, String failMessage) {
        super(tittle, failMessage);
    }

    @Override
    public Character parseInput(String userInput) {
        while (true) {
            if (userInput.length() > 1) {
                System.out.println(failMessage);
                userInput = scanner.nextLine();
                continue;
            }

            char symbol = userInput.charAt(0);

            if (!Character.isLetter(symbol)) {
                System.out.println(failMessage);
                userInput = scanner.nextLine();
                continue;
            }
            return symbol;
        }
    }
}
