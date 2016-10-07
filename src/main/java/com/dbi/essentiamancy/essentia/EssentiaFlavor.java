package com.dbi.essentiamancy.essentia;

/**
 * Created by nnels2 on 10/6/16.
 */
public enum EssentiaFlavor {

    Energy(EssentiaType.Nilis,EssentiaType.Energis),
    Life(EssentiaType.Dormis,EssentiaType.Vitis),
    Structure(EssentiaType.Tumultis,EssentiaType.Ordis),
    Hardness(EssentiaType.Mollis,EssentiaType.Duris),
    Rarity(EssentiaType.Pretis,EssentiaType.Multis),
    Harmfulness(EssentiaType.Expedis,EssentiaType.Noxis),
    Artifice(EssentiaType.Naturis,EssentiaType.Fabris),
    Mobility(EssentiaType.Stabilis,EssentiaType.Motis);


    private EssentiaType min;
    private EssentiaType max;

    EssentiaFlavor(EssentiaType min, EssentiaType max)
    {
        this.min=min;
        this.max=max;
    }

    public EssentiaType minType()
    {
        return min;
    }

    public EssentiaType maxType()
    {
        return max;
    }


}
