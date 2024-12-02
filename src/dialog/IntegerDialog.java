package dialog;

import utils.NumberUtils;

import java.util.List;

public class IntegerDialog extends DialogImpl<Integer> {
    private final List<Integer> keys;
    public IntegerDialog(String tittle, String failMessage, List<Integer> keys) {
        super(tittle, failMessage);
        this.keys = keys;
    }

    @Override
    protected Integer parseInput(String userInput) {
        while (true) {
            if (NumberUtils.isInteger(userInput)) {
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

