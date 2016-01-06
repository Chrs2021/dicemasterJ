package com.jbird.dicebot;

import java.math.BigInteger;
import java.util.Map;
import java.security.SecureRandom;

public class Main {

    // Basically taking the place of the tables, with the key being the ID (more or less)
    private static Map<String,Player> players;
    private static Map<String,Duel> duels;

    // Generates a 32-character string randomly for object assignment.
    private static String newString() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

    private static void createPlayer(String name) {
        String newID = newString();
        players.put(newID,new Player(newID,name));
    }

    public static void main(String[] args) {
	// write your code here
    }
}
