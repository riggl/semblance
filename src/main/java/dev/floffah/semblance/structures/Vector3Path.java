package dev.floffah.semblance.structures;

import lombok.Getter;

public record Vector3Path(@Getter Vector3 vector,
                          @Getter Triplet offset) {
    public Vector3Path(Vector3 vector, Triplet offset) {
        this.vector = vector;
        this.offset = offset == null ? new Triplet(0, 0, 0) : offset;
    }
}
