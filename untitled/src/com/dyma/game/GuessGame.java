package com.dyma.game;

import java.util.List;
import java.util.ArrayList;

public class GuessGame {

    private final List<Character> letters = new ArrayList<>(); //mot à deviner
    private int lifePoints;
    private final List<Character> guessWord = new ArrayList<>(); // tirets à remplacer pr les lettres trouvées

    public GuessGame(String wordToGuess, int hp) {
        for(char c : wordToGuess.toCharArray()){
            letters.add(c);
        }
        lifePoints = hp;

        for (int i = 0; i < this.letters.size(); i++){
            guessWord.add('_');
        }
    }

    @Override
    public String toString() {
        return "GuessGame{" +
                "guessWord=" + guessWord +
                ", lifePoints=" + lifePoints +
                '}';
    }

    public void guessLetter(char letter) {
        if(letters.contains(letter) && !guessWord.contains(letter)){
            for(int i = 0; i < letters.size(); i++){
               if(letter == letters.get(i)){
                   guessWord.set(i, letter);
               }
            }
        } else {
            lifePoints -= 1;
        }
    }

    public boolean isLost() {
        return lifePoints <= 0;
    }

    public boolean isWon() {
        return !guessWord.contains('_');
    }
}
