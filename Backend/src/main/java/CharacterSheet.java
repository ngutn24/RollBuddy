package main.java;

import java.util.HashMap;

/**
 * An encompassing object which directly correlates to everything on a
 * players character sheet. It is a collection of objects which make up
 * the entire character
 */

public class CharacterSheet {

    // profBonus directly based off character level
    private int profBonus;

    // A set representing all the items owned by a character
    private HashMap<String, Item> items = new HashMap<>();

    private int level;
    private int initiative;
    private int hitPoints;
    private int speed;
    private int armorClass;
    private int goldCount;

    private ClassType classType;

    private Modifier STR, DEX, CON, INT, WIS, CHA;

    /**
     * The following is constructor meant to initalize the entire character sheet.
     * The requested variables are all necessary for any given character. Some
     * variables are
     * automatically calcualted
     * 
     * @param STR        A characters strength ability score
     * @param DEX        A characters dexterity ability score
     * @param CON        A characters constitution ability score
     * @param INT        A characters intelligence ability score
     * @param WIS        A characters wisdom ability score
     * @param CHA        A characters charisma ability score
     * 
     * @param level      A characters level (profBonus determined by character
     *                   level)
     * @param hitPoints  A characters hit point total (health)
     * @param speed      A characters total movement speed
     * @param goldCount  The total gold a player owns
     * @param armorClass A characters armor class
     * @param mainClass  Represents the main class of a character is (Wizard, Barb,
     *                   etc.)
     * @param subClass   Represents what a character specializes in from their main
     *                   class (CAN BE EMPTY STRING)
     */
    public CharacterSheet(
            int STR, int DEX, int CON, int INT, int WIS, int CHA,
            int level, int hitPoints, int speed, int goldCount,
            int armorClass, String mainClass, String subClass) {

        // Generate the modifier objects
        this.STR = new Modifier(STR);
        this.DEX = new Modifier(DEX);
        this.CON = new Modifier(CON);
        this.INT = new Modifier(INT);
        this.WIS = new Modifier(WIS);
        this.CHA = new Modifier(CHA);

        this.level = level;
        this.profBonus = 2 + (level - 1) / 4;
        this.initiative = DEX;
        this.hitPoints = hitPoints;
        this.speed = speed;
        this.armorClass = armorClass;
        this.goldCount = goldCount;

        this.classType = new ClassType(mainClass, subClass);
    }

    public CharacterSheet() {
        this(0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0,
                        "","");
    }

    /**
     * Get the Strength modifier
     * 
     * @return A Modifier object for character Strength
     */
    Modifier getSTR() {
        return this.STR;
    }

    /**
     * Get the Dexterity modifier
     * 
     * @return A Modifier object for character Dexterity
     */
    Modifier getDEX() {
        return this.DEX;
    }

    /**
     * Get the Constitution modifier
     * 
     * @return A Modifier object for character Constitution
     */
    Modifier getCON() {
        return this.CON;
    }

    /**
     * Get the Intelligence modifier
     * 
     * @return A Modifier object for character Intelligence
     */
    Modifier getINT() {
        return this.INT;
    }

    /**
     * Get the Wisdom modifier
     * 
     * @return A Modifier object for character Wisdom
     */
    Modifier getWIS() {
        return this.WIS;
    }

    /**
     * Get the Charisma modifier
     * 
     * @return A Modifier object for character Charisma
     */
    Modifier getCHA() {
        return this.CHA;
    }

    /**
     * Get the character level
     * 
     * @return A integer for character level
     */
    int getLevel() {
        return this.level;
    }

    /**
     * Get the character prof bonus
     * 
     * @return A integer for character prof bonus
     */
    int getProfBonus() {
        return this.profBonus;
    }

    /**
     * Get the character Initiative
     * 
     * @return A integer for character Initiative
     */
    int getInitiative() {
        return this.initiative;
    }

    /**
     * Get the character hit point total
     * 
     * @return A integer for character hit point total
     */
    int getHp() {
        return this.hitPoints;
    }

    /**
     * Get the character speed
     * 
     * @return A integer for character speed
     */
    int getSpeed() {
        return this.speed;
    }

    /**
     * Get the character armor class
     * 
     * @return A integer for character armor class
     */
    int getAC() {
        return this.armorClass;
    }

    /**
     * Get the character total gold count
     * 
     * @return A integer for character total gold count
     */
    int getGold() {
        return this.goldCount;
    }

    /**
     * Get the characters class information
     * 
     * @return A ClassType object which contains strings
     *         for the characters main and sub class names
     */
    ClassType getClassType() {
        return this.classType;
    }

    /**
     * Get all the items in a characters inventory
     * 
     * @return A HashMap with key-value pairs being String-Item object
     */
    HashMap<String, Item> getItems() {
        return this.items;
    }

    /*
     * All modifier (STR, DEX, CON, INT, WIS, CHA) setters use the
     * setAbilityScore method built into the Modifier object, which
     * updates the ability score and automatically calcualtes the new modiifer
     * based on the new score
     */

    void setSTR(int newSTR) {
        this.STR.setAbilityScore(newSTR);
    }

    void setDEX(int newDEX) {
        this.DEX.setAbilityScore(newDEX);
    }

    void setCON(int newCON) {
        this.CON.setAbilityScore(newCON);
    }

    void setINT(int newINT) {
        this.INT.setAbilityScore(newINT);
    }

    void setWIS(int newWIS) {
        this.WIS.setAbilityScore(newWIS);
    }

    void setCHA(int newCHA) {
        this.CHA.setAbilityScore(newCHA);
    }

    /**
     * Set the character level then subsequently update the profBonus
     * based on the new level
     * 
     * @param newLevel The new level of the character
     */
    void setLevel(int newLevel) {
        this.level = newLevel;
        this.profBonus = 2 + (newLevel - 1) / 4;
    }

    /**
     * Set the character proficiency bonus
     * 
     * @param newProf The new proficiency bonus
     */
    void setProfBonus(int newProf) {
        // Should never be used, but here just in case!
        this.profBonus = newProf;
    }

    /**
     * Set the character initiative
     * 
     * @param newInitiative The new initiative
     */
    void setInitiative(int newInitiative) {
        this.initiative = newInitiative;
    }

    /**
     * Set the character hit point total
     * 
     * @param newHp the new hit point total of the character
     */
    void setHP(int newHp) {
        this.hitPoints = newHp;
    }

    /**
     * Set the character speed
     * 
     * @param newSpeed the new speed of the character
     */
    void setSpeed(int newSpeed) {
        // Very rarely if ever needs to be used
        this.speed = newSpeed;
    }

    /**
     * Set the armor class of the character
     * 
     * @param newAC the new armor class of the character
     */
    void setAC(int newAC) {
        this.armorClass = newAC;
    }

    /**
     * Set the total gold of the character
     * 
     * @param goldCount the new gold count of the character
     */
    void setGold(int goldCount) {
        this.goldCount = goldCount;
    }

    /**
     * Set the name of the main class of the character in the
     * ClassType object
     * 
     * @param mainClass The new string name of the main class
     */
    void setMainClass(String mainClass) {
        // Should never be used, but here just in case!
        this.classType.setMainClass(mainClass);
    }

    /**
     * Set the name of the sub class of the character in the
     * CLassType object
     * 
     * @param subClass The new string name of the subclass
     */
    void setSubClass(String subClass) {
        // Will likely be used if the characters start below level 3
        this.classType.setSubClass(subClass);
    }

    /*
     * All items are stored in a HashMap whose key-value
     * pairs are the name of the item along with the item
     * object.
     */
    void addItem(Item item) {
        items.put(item.getName(), item);
    }

    void removeItem(Item item) {
        items.remove(item.getName());
    }

    void updateItem(Item item) {
        items.replace(item.getName(), item);
    }

}
