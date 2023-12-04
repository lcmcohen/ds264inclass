package ds264.intro.stacks;

import java.util.Random;

public class Tray {
    String name;
    Boolean isDirty;

    public Tray(String name, Boolean isDirty) {
        this.name = name;
        this.isDirty = isDirty;
    }

    @Override
    public String toString() {
        //     String topLine =    "\\                               /" + "\n";
        String bottomLine = "  \\____________________________/" + " \n";
        String middleLine = " \\" + padString(name, bottomLine.length() - 3, isDirty) + "/"
                + "\n";

        return /* topLine +  */  middleLine + bottomLine;
    }


    /**
     *  Method to pad a string with random special characters based on the isDirty parameter
     * @author ChatGPT
     */

    private static String padString(String input, int targetLength, boolean isDirty) {
        final char[] specialCharacters = {'*', '#', '@', '!', '&', '$', '%'};
        int originalLength = (input.length() % 2) == 0 ? input.length() : input.length() -1;

        targetLength -= input.length() % 2;

        if (originalLength >= targetLength) {
            // If the original string is already longer than or equal to the target length,
            // no padding is needed, so return the original string.
            return input;
        } else {
            // Calculate the number of characters needed for padding on both sides
            int paddingNeeded = targetLength - originalLength;

            // Create a StringBuilder to efficiently build the padded string
            StringBuilder paddedStringBuilder = new StringBuilder(targetLength);

            // Determine the padding characters based on the isDirty parameter
            char paddingChar;
            Random random = new Random();

            for (int i = 0; i < paddingNeeded / 2; i++) {
                if (isDirty) {
                    // Randomly select a special character for dirty padding
                    int index = random.nextInt(specialCharacters.length);
                    paddingChar = specialCharacters[index];
                } else {
                    // Use a blank for clean padding
                    paddingChar = ' ';
                }

                paddedStringBuilder.append(paddingChar);
            }

            // Append the original string
            paddedStringBuilder.append(input);

            for (int i = 0; i < paddingNeeded / 2; i++) {
                if (isDirty) {
                    // Randomly select a special character for dirty padding
                    int index = random.nextInt(specialCharacters.length);
                    paddingChar = specialCharacters[index];
                } else {
                    // Use a blank for clean padding
                    paddingChar = ' ';
                }

                paddedStringBuilder.append(paddingChar);
            }

            // Convert StringBuilder to String and return the result
            return paddedStringBuilder.toString();
        }
    }
}
