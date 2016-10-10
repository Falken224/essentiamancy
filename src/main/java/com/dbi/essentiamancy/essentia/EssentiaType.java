package com.dbi.essentiamancy.essentia;

/**
 * Created by nnels2 on 10/6/16.
 */
public enum EssentiaType {
    Nilis(0,0),
    Energis(32,0),
    Dormis(64,0),
    Vitis(96,0),
    Tumultis(128,0),
    Ordis(160,0),
    Mollis(192,0),
    Duris(224,0),
    Pretis(0,32),
    Multis(32,32),
    Expedis(64,32),
    Noxis(96,32),
    Naturis(128,32),
    Fabris(160,32),
    Stabilis(192,32),
    Motis(224,32);

    private int textureX;
    private int textureY;

    //This is a TERRIBLE implementation, but I'm doing it anyway for now.
    //TODO: Need to implement textures for this essentia type correctly.
    public int getTextureX(){ return textureX; }
    public int getTextureY(){ return textureY; }

    private EssentiaType(int textureX, int textureY)
    {
        this.textureX = textureX;
        this.textureY = textureY;
    }

}
