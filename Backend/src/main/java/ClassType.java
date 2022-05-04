/**
 * A simple java class which encompasses a character class type.
 * A user has the ability to input strings which we can store.
 */

public class ClassType {
    private String mainClass, subClass;

    /**
     * Initalize a ClassType object
     * 
     * @param mainClass The string name of the main class
     * @param subClass  The string name of the sub class (CAN BE EMPTY)
     */
    public ClassType(String mainClass, String subClass) {
        assert (mainClass != "" || mainClass != null) : "You must have a main class type";
        this.mainClass = mainClass;
        this.subClass = subClass;
    }

    /**
     * Get the name of the main class
     * 
     * @return A string name representing the main class
     */
    String getMainClass() {
        return mainClass;
    }

    /**
     * Get the name of the sub class
     * 
     * @return A string name representing the sub class
     */
    String getSubClass() {
        return subClass;
    }

    /**
     * Set the name of the main class (SHOULD NEVER BE USED)
     * 
     * @param mainClass The new name of the main class
     */
    void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    /**
     * Set the name of the sub class
     * 
     * @param subClass The new name of the sub class
     */
    void setSubClass(String subClass) {
        this.subClass = subClass;
    }
}
