package com.dyma.exceptions;

public class TicTacToeInvalidInputException extends Throwable {

    public TicTacToeInvalidInputException() {
        super();
    }

    public TicTacToeInvalidInputException(String s) {
        super(s);
    }
}
