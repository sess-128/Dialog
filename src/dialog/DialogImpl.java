package dialog;

import java.util.Scanner;

public abstract class DialogImpl<T> implements Dialog<T>{
    protected final Scanner scanner;
    protected final String tittle;
    protected final String failMessage;

    public DialogImpl(String tittle, String failMessage) {
        this.tittle = tittle;
        this.failMessage = failMessage;
        this.scanner = new Scanner(System.in);
    }
    @Override
    public T input(){
        while (true) {
            System.out.println(tittle);
            String userInput = scanner.nextLine();

            if (userInput.isEmpty()) {
                System.out.println(failMessage);
                continue;
            }
            return parseInput(userInput);
        }

    }

    protected abstract T parseInput(String userInput);
}
