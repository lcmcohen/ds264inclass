package intro;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringsTest {

    @Test
    void mike_Stringcomp() {
        String str1 = new String("Hello, World");
        String str2 = new String("Hello, World");

        // Using the == operator to compare the references
        boolean areEqual = (str1 == str2);

        System.out.println("Using == operator: str1 and str2 are equal: " + areEqual);

        // Using the equals() method to compare the content
        boolean contentEqual = str1.equals(str2);

        System.out.println("Using equals() method: str1 and str2 are equal: " + contentEqual);


// also


        String myLocation = Locale.getDefault().getDisplayCountry();
        System.out.println(myLocation);

        String whereIThinkIAm = "United" + new String(" States");
        System.out.println(whereIThinkIAm);

        if (myLocation == whereIThinkIAm)
            System.out.println("they are equal");
        else
            System.out.println("they are not equal");

        assertEquals(myLocation, whereIThinkIAm);
    }

}
