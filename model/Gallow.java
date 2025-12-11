package model;

import model.exceptions.LetterAlreadyRecorded;
import model.exceptions.LetterNotExistsInTargetWord;

public class Gallow {
    private int lives = 5;
    private String wordTarget;
    private String lettersToWin;
    private String lettersTyped = "";
    private String correctLettersTyped = "";

    public Gallow(String wordTarget) {
        this.wordTarget = wordTarget;
        lettersToWin = Gallow.removeDuplicatesLettersFromWord(wordTarget);
    }

    public int getLives() {
        return this.lives;
    }

    public String getWordTarget() {
        return this.wordTarget;
    }

    public String getLettersTyped() {
        return this.lettersTyped;
    }

    public String getCorrectLettersTyped() {
        return this.correctLettersTyped;
    }

    private void loseLive() {
        lives -= 1;
    }

    private void setLettersTyped(char letter) {
        lettersTyped = lettersTyped + letter;
    }

    private void setCorrectLettersTyped(char letter) {
        correctLettersTyped = correctLettersTyped + letter;
    }

    private static String removeDuplicatesLettersFromWord(String wordTarget) {
        String wordWithoutDuplicates = "";
        for (char c : wordTarget.toCharArray()) {
            char letterLowerCase = Character.toLowerCase(c);
            if (!wordWithoutDuplicates.toLowerCase().contains(String.valueOf(letterLowerCase))) {
                wordWithoutDuplicates += letterLowerCase;
            }
        }
        return wordWithoutDuplicates;
    }

    public boolean isLetterAlreadyRecorded(char letter) {
        letter = Character.toLowerCase(letter);
        for (char l : getLettersTyped().toCharArray()) {
            char recordedLetter = Character.toLowerCase(l);
            if (letter == recordedLetter) {
                return true;
            }
        }
        return false;
    }

    public boolean targetWordHasLetter(char letter) {
        letter = Character.toLowerCase(letter);
        return wordTarget.toLowerCase().contains(String.valueOf(letter));
    }

    public void recordLetter(char letter) throws LetterAlreadyRecorded, LetterNotExistsInTargetWord {
        char letterToRecord = Character.toLowerCase(letter);
        if (isLetterAlreadyRecorded(letterToRecord)) {
            throw new LetterAlreadyRecorded("Letter \'" + letterToRecord + "\' already recorded");
        }
        setLettersTyped(letterToRecord);
        if (!targetWordHasLetter(letterToRecord)) {
            loseLive();;
            throw new LetterNotExistsInTargetWord("Letter \'" + letterToRecord + "\' not exists in word " + wordTarget);
        }
        setCorrectLettersTyped(letterToRecord);
    }

    public boolean isPlayerWins() {
        return lettersToWin.length() == correctLettersTyped.length();
    }
}