import dialog.CharacterDialog;
import dialog.Dialog;

public class Main {
    public static void main(String[] args) {

        String tittle = "Введите любой символ: ";
        String failMessage = "Ошибка ввода";

        Dialog<Character> dialog = new CharacterDialog(tittle, failMessage);
        char symbol = dialog.input();
        System.out.println("ВВЕДЕН СИМВОЛ: " + symbol);
    }

}