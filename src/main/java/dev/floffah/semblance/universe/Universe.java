package dev.floffah.semblance.universe;

import lombok.Getter;
import lombok.Setter;

public class Universe {
    /**
     * Universe ID
     * -- GETTER --
     * Get the universe's ID
     *
     * @returns The universe's id
     * -- SETTER --
     * Set the universe's ID
     * @param id The id to set
     */
    @Getter
    @Setter
    int id;

    /**
     * Initialise a universe
     */
    public Universe() {

    }
}
