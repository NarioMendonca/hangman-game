package view;

public class GallowLayout {
    public static void showLayout(String wordTarget, String typedLetters, String correctLettersTyped, int lives) {
        showGallow(lives);
        showTyppedAndUntyppedLetters(typedLetters);
        showWordToCompleteProgress(wordTarget, correctLettersTyped);
    }

    public static void showTyppedAndUntyppedLetters(String typedLetters) {
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String typedLetterLower = typedLetters.toLowerCase();

        System.out.print("Letras: ");
        // this line transforms the numbers in letters using ASCII table 
        for (int i = 97; i <= 122; i++) {
            char letter = (char) i;
            if (typedLetterLower.contains(String.valueOf(letter))) {
                System.out.printf(RED + " %s " + RESET, letter);
            } else {
                System.out.printf(GREEN + " %s " + RESET, letter);
            }
        }
        System.out.println();
    }

    public static void showWordToCompleteProgress(String wordTarget, String correctLettersTyped) {
        String UNDERLINE = "\u001B[4m";
        String RESET = "\u001B[0m";
        String wordTargetLower = wordTarget.toLowerCase();

        System.out.print("Palavra a completar: ");
        for (char letter : wordTargetLower.toCharArray()) {
            if (correctLettersTyped.toLowerCase().contains(String.valueOf(letter))) {
                System.out.print(UNDERLINE + letter + RESET  + " ");
            } else {
                System.out.print(UNDERLINE + " " + RESET + " ");
            }
        }
        System.out.println();
    }

    public static void showGallow(int lives) {

        switch (lives) {
            case 5: System.out.println(
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            " / \\  |\n" +
            "      |\n" +
            "=========");
            break;

            case 4: System.out.println(
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            " /    |\n" +
            "      |\n" +
            "=========");
            break;

            case 3: System.out.println(
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            "      |\n" +
            "      |\n" +
            "=========");
            break;

            case 2: System.out.println(
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|   |\n" +
            "      |\n" +
            "      |\n" +
            "=========");
            break;

            case 1:System.out.println(
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "  |   |\n" +
            "      |\n" +
            "      |\n" +
            "=========");
            break;

            case 0: System.out.println(
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=========");
            default: System.out.println("Gallow must have zero to five lives"); break;
        }
    }
}