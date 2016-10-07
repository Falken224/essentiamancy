package com.dbi.essentiamancy.essentia;

import java.util.regex.Pattern;

/**
 * Created by nnels2 on 10/6/16.
 */
public class EssentiaSignature {
    private String essentiaSignature;
    private static Pattern validPattern = Pattern.compile("^[1-9A-F]{8}$");
    private EssentiaValue[] sig = new EssentiaValue[8];

    public EssentiaSignature(String signature)
    {
        assert validPattern.matcher(signature).matches() : signature+" is an invalid essentia signature.";
        this.essentiaSignature=signature;
        for(EssentiaFlavor flavor : EssentiaFlavor.values())
        {
            short value=Short.parseShort("0x"+sig[flavor.ordinal()]);
            value-=8;
            sig[flavor.ordinal()]=
                (value<=0)?
                    new EssentiaValue(flavor.minType(),(short)(value*-1)):
                    new EssentiaValue(flavor.maxType(),value);
        }
    }

    public EssentiaValue getFlavorValue(EssentiaFlavor flavor)
    {
        if(flavor==null) return null;
        return sig[flavor.ordinal()];
    }
}