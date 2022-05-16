package main.java;

import java.util.Objects;

/**
 * A simple java class which encompasses a character class.
 * A user defines the name for the class and the level.
 */

public class CharClass {
    private String charClass;
    private int level;

    /**
     * Initialize a ClassType object
     *
     * @param charClass The string name of the class
     * @param level     The integer amount pertaining to the total levels in this class
     */
    public CharClass(String charClass, int level) {
        if (Objects.equals(charClass, "") || charClass == null) {
            // In case of an undecided class (when too low level or not multiclass)
            this.charClass = "Undecided";
            this.level = 0;
        } else {
            this.charClass = charClass;
            this.level = level;
        }
    }

    /**
     * Get the name of the class
     *
     * @return A string name representing the class
     */
    public String getClassName() {
        return charClass;
    }

    /**
     * Get the class level
     *
     * @return An integer representing the class level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the name of the class (SHOULD NEVER BE USED)
     *
     * @param charClass The new name of the class
     */
    public void setClassName(String charClass) {
        this.charClass = charClass;
    }

    /**
     * Set the level of the class
     *
     * @param level The new level of the class
     */
    public void setLevel(int level) {
        this.level = level;
    }
}
