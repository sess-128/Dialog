package dialog;

import utils.NumberUtils;

public class IntegerMinMaxDialog extends DialogImpl<Integer> {
    private final int firstSector;
    private final int lastSector;

    public IntegerMinMaxDialog(String tittle, String failMessage, int firstSector, int lastSector) {
        super(tittle, failMessage);
        this.firstSector = firstSector;
        this.lastSector = lastSector;
    }

    @Override
    protected Integer parseInput(String userInput) {
        while (true) {
            if (NumberUtils.isInteger(userInput)) {
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


