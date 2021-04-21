package dev.floffah.semblance.structures;

import lombok.Getter;
import lombok.Setter;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Vector3 {
    /**
     * Vector meta
     * -- GETTER --
     * Get the vectors meta
     *
     * @returns the vectors meta
     */
    @Getter
    List<Map.Entry<PathMetaType, BaseMetaValue>> meta = new ArrayList<>();
    /**
     * Vector points
     * -- GETTER --
     * Get the vectors points
     *
     * @returns The vectors meta
     */
    @Getter
    List<Vector3Path> paths;
    /**
     * Vector origin that everything else is relative from
     * -- GETTER --
     * Get the vectors origin
     *
     * @returns The vectors origin
     * -- SETTER --
     * Set the vectors origin
     * @param origin New origin
     */
    @Getter
    @Setter
    private Triplet origin;

    /**
     * Construct a vector
     *
     * @param origin The vectors origin
     */
    public Vector3(Triplet origin) {
        this.origin = origin;
    }

    /**
     * Add a new path and map it to a type
     *
     * @param type Path type
     * @param path The path
     */
    public void put(PathMetaType type, Vector3Path path) {
        meta.add(new AbstractMap.SimpleEntry<>(type, new IntegerMetaValue(paths.size())));
        paths.add(path);
    }

    /**
     * Add a new path without a mapped type
     *
     * @param path The path
     */
    public void put(Vector3Path path) {
        paths.add(path);
    }

    /**
     * Returns a {@link Vector3Path} relating to a meta type.
     * Useful for getting things like {@link PathMetaType#MAIN_PATH}
     * You should almost always use {@link Vector3#getRelatedPaths(PathMetaType)} as a lot of meta types have multiple relating paths.
     * If you are trying to get the MAIN_PATH you should use this
     *
     * @param type Meta type
     * @return The path or null if none.
     */
    public Vector3Path getRelatedPath(PathMetaType type) {
        for (Map.Entry<PathMetaType, BaseMetaValue> entry : meta) {
            if (entry.getKey().equals(type) && entry.getValue() instanceof IntegerMetaValue value) {
                Vector3Path path = paths.get(value.getValue());
                if (path != null) return path;
            }
        }
        return null;
    }

    /**
     * Identical to {@link Vector3#getRelatedPath(PathMetaType)} except it is for getting meta values that can have multiple.
     *
     * @param type Meta type
     * @return List of paths
     */
    public List<Vector3Path> getRelatedPaths(PathMetaType type) {
        List<Vector3Path> dat = new ArrayList<>();
        for (Map.Entry<PathMetaType, BaseMetaValue> entry : meta) {
            if (entry.getKey().equals(type) && entry.getValue() instanceof IntegerMetaValue value) {
                Vector3Path path = paths.get(value.getValue());
                if (path != null) dat.add(path);
            }
        }
        return dat;
    }
}