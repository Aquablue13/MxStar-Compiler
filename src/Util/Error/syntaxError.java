package Util.Error;

import Util.position;

public class syntaxError extends Error {

    public syntaxError(String msg, position pos) {
        super("SyntaxError: " + msg, pos);
    }

}