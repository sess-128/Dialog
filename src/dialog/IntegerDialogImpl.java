package dialog;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerDialogImpl implements Dialog<Integer> {
    private final static String REGEX = "\\b\\d+\\b";
    private final String tittle;
    private final String failMessage;
    private final List<Integer> keys;
    private static final Scanner scanner = new Scanner(System.in);

    public IntegerDialogImpl(String tittle, String failMessage, List<Integer> keys) {
        this.tittle = tittle;
        this.failMessage = failMessage;
        this.keys = keys;
    }

    @Override
    public Integer input() {
        while (true) {
            System.out.println(tittle);

            String userInput = scanner.nextLine();


            if (userInput.isEmpty()) {
                System.out.println(failMessage);
                continue;
            }

            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(userInput);

            if (!matcher.find()) {
                System.out.println(failMessage);
                continue;
            }

            int number = Integer.parseInt(userInput);

            if (!keys.contains(number)) {
                System.out.println(failMessage);
                continue;
            }
            return number;
        }

    }
}
