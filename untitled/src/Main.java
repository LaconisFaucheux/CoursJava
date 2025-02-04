import com.dyma.game.GuessGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var random = new Random();
        final var scanner = new Scanner(System.in);
        final List<String> words = new ArrayList<String>();
        words.add("manger");
        words.add("tortue");
        words.add("dinosaure");
        words.add("chiffon");
        words.add("patate");
        words.add("bombe");
        words.add("Chenonceaux");
        final var wordToGuess = words.get(random.nextInt(0, words.size()));

        final var guessGame = new GuessGame(wordToGuess, 10);

        System.out.println("Début du jeu du Pendu!");

        while(true) {
            System.out.println(guessGame);
            System.out.println("Entrez une lettre :");
            final var letter = scanner.nextLine().charAt(0);

            guessGame.guessLetter(letter);

            if(guessGame.isLost()){
                System.out.println(guessGame);
                System.out.println("Perdu!");
                break;
            }
            if (guessGame.isWon()){
                System.out.println(guessGame);
                System.out.println("Gagné!");
                break;
            }

        }
    }
}