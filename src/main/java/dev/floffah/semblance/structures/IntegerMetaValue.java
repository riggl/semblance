package dev.floffah.semblance.structures;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.NonFinal;

@EqualsAndHashCode(callSuper = true)
@Data
public class IntegerMetaValue extends BaseMetaValue {
    /**
     * Meta value
     * -- GETTER --
     * Get the meta value
     *
     * @returns the meta value
     * -- SETTER --
     * Set the meta value
     * @param value New meta value
     */
    @NonFinal
    int value;

    public IntegerMetaValue(int value) {
        this.value = value;
    }
}
