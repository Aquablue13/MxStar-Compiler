package Util.Error;

import Util.position;

abstract public class Error extends RuntimeException {
    private position pos;
    private String msg;

    public Error(String msg, position pos) {
        this.pos = pos;
        this.msg = msg;
    }

    public String toString() {
        return msg + ": " + pos.toString();
    }
}