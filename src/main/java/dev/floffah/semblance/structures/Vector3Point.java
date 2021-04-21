package dev.floffah.semblance.structures;

import lombok.Getter;

public record Vector3Point(@Getter Vector3Path path,
                           @Getter Triplet relativeLocation,
                           @Getter boolean offset) {
}
