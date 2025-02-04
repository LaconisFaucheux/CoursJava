import com.dyma.exceptions.TicTacToeInvalidInputException;
import com.dyma.game.Player;
import com.dyma.game.TicTacToe;

import java.util.HashMap;
import java.util.Scanner;

import static com.dyma.game.StringConstants.BLANK;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final var game = new TicTacToe();
        var player = Player.FIRST;
        var players = initPlayers();

        while(true){
            try {

                System.out.println(game);
                System.out.println(players.get(player) + ": Saisissez un nombre entre 1 et 9");
                final var input = getInputUser();

            game.processInput(player, input);
            if(game.checkWin()){
                System.out.println(game);
                System.out.println(players.get(player) + " a gagné la partie!");
                break;
            }
            if(game.checkDraw()){
                System.out.println("Match nul!");
                break;
            }

            player = nextPlayer(player);
            } catch(TicTacToeInvalidInputException e){
                System.out.println(e.getMessage()
                );
            } catch(NumberFormatException e) {
                System.out.println("Vous devez saisir un chiffre");
            }
        }
    }

    private static HashMap<Player, String> initPlayers() {
        var scanner = new Scanner(System.in);
        var name1 = "";
        var name2 = "";

        do{
            System.out.println("Entrez votre nom Joueur 1:");
            name1 = scanner.nextLine();
        } while (name1.equals(BLANK));

        do{
            System.out.println("Entrez votre nom Joueur 2:");
            name2 = scanner.nextLine();
        } while (name2.equals(BLANK));

        HashMap<Player, String> players = new HashMap<Player, String>();
        players.put(Player.FIRST, name1);
        players.put(Player.SECOND, name2);

        return players;
    }

    private static int getInputUser() throws TicTacToeInvalidInputException{
        final var scanner = new Scanner(System.in);
        var rawInput = scanner.nextLine();
        if(rawInput.equals("exit") || rawInput.equals("quit")){
            System.exit(0);
        }
        var input = Integer.parseInt(rawInput);
        if(input < 1 || input > 9){
            throw new TicTacToeInvalidInputException("Le chiffre doit être entre 1 et 9");
        }
        return input;
    }

    private static Player nextPlayer(Player player) {
        if(player == Player.FIRST){
            return Player.SECOND;
        } else {
            return Player.FIRST;
        }
    }
}