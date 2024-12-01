package dialog;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerMinMaxDialogImpl implements Dialog<Integer> {
    private static final String REGEX = "\\b\\d+\\b";
    private static final Scanner scanner = new Scanner(System.in);
    private final String tittle;
    private final String failMessage;
    private final int firstSector;
    private final int lastSector;


    public IntegerMinMaxDialogImpl(String tittle, String failMessage, int firstSector, int lastSector) {
        this.tittle = tittle;
        this.failMessage = failMessage;
        this.firstSector = firstSector;
        this.lastSector = lastSector;
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

            if (number < firstSector || number > lastSector) {
                System.out.println(failMessage);
                continue;
            }

            return number;
        }
    }
}
