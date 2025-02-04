package com.dyma.game;

import com.dyma.exceptions.TicTacToeInvalidInputException;

import static com.dyma.game.StringConstants.*;

public class TicTacToe {

    final private char[][] grid = new char[][]{
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
    };

    public void processInput(Player player, int input) throws TicTacToeInvalidInputException {
        int row = (input - 1) / 3;
        int column = (input -1 ) % 3;
        if(grid[row][column] == '.'){
            if(player == Player.FIRST){
                grid[row][column] ='X';
            } else {
                grid[row][column] ='O';
            }
        } else {
            throw new TicTacToeInvalidInputException("La case est déjà occuppée");
        }
    }

    public boolean checkWin() {
        for(int i = 0; i < 3; i++){
            var checkWinLine = grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][2] != '.';
            var checkWinColumn = grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[2][i] != '.';
            if(checkWinColumn || checkWinLine){
                return true;
            }
            var checkwinDiagonal1 = grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[2][2] != '.';
            var checkwinDiagonal2 = grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[2][0] != '.';
            if(checkwinDiagonal1 || checkwinDiagonal2){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        builder.append("Grille du Morpion").append(LINE_SEPARATOR);
        for(char[] line : grid){
            for(char cell: line){
                switch (cell){
                    case 'X':
                        builder.append(SPACE).append(RED).append(cell).append(RESET).append(SPACE);
                        break;
                    case 'O':
                        builder.append(SPACE).append(CYAN).append(cell).append(RESET).append(SPACE);
                        break;
                    default:
                        builder.append(SPACE).append(cell).append(SPACE);
                        break;
                }
            }
            builder.append(LINE_SEPARATOR);
        }

        return builder.toString();
    }

    public boolean checkDraw() {
        for(char[] line : grid){
            for(char cell : line){
                if(cell == '.'){
                    return false;
                }
            }
        }
        return true;
    }
}
