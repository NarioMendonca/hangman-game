package controller;
import java.util.Random;
import java.util.Scanner;

import model.Gallow;
import model.exceptions.LetterAlreadyRecorded;
import model.exceptions.LetterNotExistsInTargetWord;
import view.GallowLayout;

public class Main {
    static private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Pelo menos duas palavras devem ser passadas como argumento!");
            return;
        }
        String wordTarget = choiceRandomWord(args, args.length);
        
        Gallow gallowGame = new Gallow(wordTarget);

        while (true) {
            int lives = gallowGame.getLives();
            GallowLayout.showLayout(wordTarget, gallowGame.getLettersTyped(), gallowGame.getCorrectLettersTyped(), lives);
            if (lives == 0) {
                GallowLayout.defeatMessage(wordTarget);
                break;
            }
            if (gallowGame.isPlayerWins()) {
                GallowLayout.winMessage(lives, wordTarget);
                break;
            }
            String letter = pickUserInput();
            try {
                gallowGame.recordLetter(letter.charAt(0));
            } catch (LetterAlreadyRecorded error) {
                GallowLayout.letterAlreadyRecordedMessage(letter.charAt(0));
            } catch (LetterNotExistsInTargetWord error) {
                GallowLayout.letterNotExistsMessage(letter.charAt(0));
            }
        }
        scanner.close();
    }
    
    public static String choiceRandomWord(String[] words, int WORDS_COUNT) {
        Random random = new Random();
        int randomWordIndex = random.nextInt(WORDS_COUNT);
        return words[randomWordIndex];
    }

    public static String pickUserInput() {
        while (true) {
            System.out.print("Digite uma letra: ");
            String input = scanner.nextLine();
            if (input.length() == 1) {
                return input;
            }
            System.out.println("Apenas uma letra deve ser digitada!");
        }
    }
}
