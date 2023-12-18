package ds264.univ;

import java.util.Objects;

/**
 * A Person is a being that is human and lives on Earth. This Person class describes a person by his/her first name, lastname, year of birth and gender
 * (TRUE = Male | FALSE = Female). The purpose of this class is to show its hashing functionalities, that even if 2 individuals
 * come from the same class, there not equal, unless they share the same properties.
 * //// MJC from Noah Wolfson Object HW
 * @author Noah Wolfson
 */
public class Person {
    private String firstName;
    private String lastName;
    private boolean isMale;
    private short yearOfBirth;

    /**
     * Constructor for Person Object. Calls each set method in order to follow the DRY methodology.
     * @param firstName first name of the Person
     * @param lastName last name of the person
     * @param isMale boolean value to determine gender of the person
     * @param yearOfBirth birth year for the person
     */
    public Person(String firstName, String lastName, boolean isMale, short yearOfBirth) {
        setFirstName(firstName);
        setLastName(lastName);
        setIsMale(isMale);
        setYearOfBirth(yearOfBirth);
    }

    public Person() {
    }

    /**
     * setYearOfBirth method sets the birth year of the Person
     * @param yearOfBirth the birth year of the person
     */
    public void setYearOfBirth(short yearOfBirth) {
        yearValidator(String.valueOf(yearOfBirth));
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * setIsMale() method accepts a boolean argument (TRUE == MALE | FALSE == FEMALE) and sets the persons gender
     * @param isMale the boolean value, representing the gender of the Person
     */
    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    /**
     * setLastName() method accepts a String value as a last name to be assigned for the person
     * @param lastName last name of the person
     */
    public void setLastName(String lastName) {
        nameValidator(lastName, true);
        this.lastName = lastName;
    }

    /**
     * setFirstName() method accepts a string value as a first name to be assigned for the person
     * @param firstName first name of the Person
     */
    public void setFirstName(String firstName) {
        nameValidator(firstName, false);
        this.firstName = firstName;
    }

    /**
     * yearValidator() method checks if the year entered is four digits or not by converting it to a string and checking the lenght
     * @param year year that person was born
     */
    private void yearValidator(String year) {
        if (year.length() != 4) //year can be any four digits since you can make people that can also be born in the future{
            throw new IllegalArgumentException("ERROR, year of birth needs to be 4 digits");
        }



    /**
     * nameValidator() method takes in a string (either the first name or last name) and a boolean (true: called
     * by setLastName | false: called by setFirstName) and checks if the information is valid or not. Invalid
     * information includes just whitespaces, empty string and null values.
     * @param property string value, either first name or last name
     * @param isLastName what method called the nameValidator method
     */
    private void nameValidator(String property, boolean isLastName) {
        if (isLastName) {
            //the trim() method checks if the names that were entered were acedentally entered as just white spaces
            if (property == null || property.trim().isEmpty()) {
                throw new IllegalArgumentException("ERROR, invalid last name was entered");
            }
        } else {
            if (property == null || property.trim().isEmpty()) {
                throw new IllegalArgumentException("ERROR, invalid first name was entered");
            }
        }
    }

    /**
     * this method returns the first name of the person
     * @return first name of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * thos method returns the last name of a person
     * @return person's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * this method returns a boolean value (TRUE = Male | FALSE = Female) that represents the persons gender
     * @return boolean form of persons gender
     */
    public boolean getIsMale() {
        return isMale;
    }

    /**
     * this private method returns the actual gender of the person in a string form
     * @return the persons gender
     */
    private String getGender() {
        if (isMale) {
            return "Male";
        }
        return "Female";
    }

    /**
     * getYearOfBirth() method gets the year of birth of the Person and returns it
     * @return the Person's year of birth
     */
    public short getYearOfBirth() {
        return  yearOfBirth;
    }

    /**
     * this method returns a prompt of this person in string form, describing his/her indentifiers as a Person
     * @return the stringified version of this person object
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + "\nBirth Year: " + getYearOfBirth() + "\nGender: " + getGender();
    }

    /**
     * this method tests if two people are equal. The first condition just tests that if the Object that was passed in
     * had the same address as THIS person (ie this class) then it will return true. the second condition checks if the Object that
     * was passed in was null, and if it was, it will return false. The third condition checks if the Object passed in was a Person, if
     * it isn't, will return false, if it is then it checks each individual property to check if the person is the same.
     * @param o object that will be compared to this class
     * @return if the objects are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() == o.getClass()) {
            Person person = (Person) o;
            return person.isMale == this.isMale && person.yearOfBirth == getYearOfBirth()
                    && Objects.equals(getFirstName(), person.getFirstName()) &&
                    Objects.equals(getLastName(), person.getLastName());
        }
        return false;
    }

    /**
     * For this algorithm, I searched online for hash algorithms and a common theme I saw was multiplying 2 prime numbers
     * together. With that implementation, for each property I took the hashcode for the individual property. Then I added that
     * to the two prime numbers that were multiplied together. As the code goes on, the hashValue will keep growing as its multiplied
     * by the constant anotherPrimeNumber and then added by the hash code of the next property.
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int hashValue = 7, anotherPrimeNumber = 31;
        hashValue = anotherPrimeNumber * hashValue + hashBoolean(isMale);
        hashValue = anotherPrimeNumber * hashValue + yearOfBirth;
        hashValue = anotherPrimeNumber * hashValue + hashStrings(getFirstName());
        hashValue = anotherPrimeNumber * hashValue + hashStrings(getLastName());
        return hashValue;
    }

    /**
     * hashStrings() method takes a string and hashes it out. It does this by taking the string that was passed in, changing
     * it to a char array then taking each character's ASCII value and adding them all together.
     * @param string that will be hashed
     * @return the hash value
     */
    private int hashStrings(String string) {
        int hashCode = 0;
        char[] charArray = string.toCharArray();
        for (char character: charArray) {
            hashCode += character;
            hashCode *= 2;              //multiplied by 2 in order to prevent collisions if
                                        // individual has the same properties but there name is in a different order
        }
        return hashCode;
    }

    /**
     * hashBoolean takes in a boolean and gets its hash code. If the boolean is true then it will return 1231, if
     * not, it will return 1237.
     * @param boolValue that will be hashed
     * @return the hashcode
     */
    private int hashBoolean(boolean boolValue) {
        if (boolValue) {
            return 1231;
        } else {
            return 1237;
        }
    }


    // MJC Wrappers
    public boolean isMale() {
        return isMale;
    }
    public void setMale(boolean b) {
        isMale = b;
    }

}