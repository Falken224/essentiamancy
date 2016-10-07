package com.dbi.essentiamancy.essentia;

/**
 * Created by nnels2 on 10/6/16.
 */
public class EssentiaValue {
    private EssentiaType type;
    private short value;

    public EssentiaValue(EssentiaType type,short value)
    {
        assert 0<=value && value<=7 : "Value "+value+" is out of bounds for an essentia value.";
        this.type=type;
        this.value=value;
    }

    public EssentiaType getType() {
        return type;
    }

    public short getValue() {
        return value;
    }
}
