package com.dbi.essentiamancy.essentia;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Falken on 10/6/2016.
 */
public class EssentiaSignatureTest {

    @DataProvider(name = "sigCases")
    public Object[][] sigCases()
    {
        return new Object[][]{
                new Object[]{"00000000",false},//0s not allowed
                new Object[]{"11111111",true},//1s allowed
                new Object[]{"12345678",true},//All other #s allowed
                new Object[]{"FEDCBA98",true},//All other hex values allowed
                new Object[]{"CEFADG11",false},//No letters past F
                new Object[]{"123",false},//At least 8 characters
                new Object[]{"123456789",false},//No more than 8 characters.
        };
    }

    @Test(dataProvider = "sigCases")
    public void testSigs(String sig, boolean shouldSucceed)
    {
        try
        {
            new EssentiaSignature(sig);
            assertThat("Incorrect Success!",shouldSucceed);
        }catch(Throwable th)
        {
            if(shouldSucceed) th.printStackTrace();
            assertThat("Failure! "+th.getMessage(),!shouldSucceed);
        }
    }

    @Test
    public void testEssentiaParsing()
    {
        EssentiaSignature test1=new EssentiaSignature("12345678");
        assertValue(test1,EssentiaFlavor.Energy,EssentiaType.Nilis,7);
        assertValue(test1,EssentiaFlavor.Life,EssentiaType.Dormis,6);
        assertValue(test1,EssentiaFlavor.Structure,EssentiaType.Tumultis,5);
        assertValue(test1,EssentiaFlavor.Hardness,EssentiaType.Mollis,4);
        assertValue(test1,EssentiaFlavor.Rarity,EssentiaType.Pretis,3);
        assertValue(test1,EssentiaFlavor.Harmfulness,EssentiaType.Expedis,2);
        assertValue(test1,EssentiaFlavor.Artifice,EssentiaType.Naturis,1);
        assertValue(test1,EssentiaFlavor.Mobility,EssentiaType.Stabilis,0);

        EssentiaSignature test2=new EssentiaSignature("89ABCDEF");
        assertValue(test2,EssentiaFlavor.Energy,EssentiaType.Nilis,0);//The exception
        assertValue(test2,EssentiaFlavor.Life,EssentiaType.Vitis,1);
        assertValue(test2,EssentiaFlavor.Structure,EssentiaType.Ordis,2);
        assertValue(test2,EssentiaFlavor.Hardness,EssentiaType.Duris,3);
        assertValue(test2,EssentiaFlavor.Rarity,EssentiaType.Multis,4);
        assertValue(test2,EssentiaFlavor.Harmfulness,EssentiaType.Noxis,5);
        assertValue(test2,EssentiaFlavor.Artifice,EssentiaType.Fabris,6);
        assertValue(test2,EssentiaFlavor.Mobility,EssentiaType.Motis,7);

        assertValue(new EssentiaSignature("F1111111"),EssentiaFlavor.Energy,EssentiaType.Energis,7);
    }

    private void assertValue(EssentiaSignature testSig,
                             EssentiaFlavor flavor,
                             EssentiaType type,
                             int value)
    {
        EssentiaValue eVal = testSig.getFlavorValue(flavor);
        assertThat("Wrong essentia type!",eVal.getType(),equalTo(type));
        assertThat("Wrong essentia value!",eVal.getValue(),equalTo(value));
    }
}
