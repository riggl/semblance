package dev.floffah.semblance.core;

import dev.floffah.semblance.universe.Universe;

import java.util.HashMap;
import java.util.Map;

public class Semblance {
    Map<Integer, Universe> universes = new HashMap<>();

    public Semblance() {

    }

    public void start() {

    }

    public Universe initUniverse() {
        Universe u = new Universe();
        u.setId(universes.size());

        universes.put(u.getId(), u);

        return u;
    }
}
