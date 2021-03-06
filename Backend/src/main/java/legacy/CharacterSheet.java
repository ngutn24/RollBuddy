package main.java.legacy;

import java.util.HashMap;

/**
 * An encompassing object which directly correlates to everything on a
 * player's character sheet. It is a collection of objects which make up
 * the entire character
 */

public class CharacterSheet {

    // profBonus directly based off character level
    private int profBonus;

    // A set representing all the items owned by a character
    private HashMap<String, Item> items = new HashMap<>();

    // Basic information about a character
    private String name;
    private String race;
    private String campaign;
    private String alignment;
    private String background;
    private int initiative;
    private int hitPoints;
    private int speed;
    private int armorClass;
    private int goldCount;
    private int exp;

    // CharClass objects representing the main/subclass of the character
    private CharClass mainClass, subClass;

    // The 6 main ability scores in 5E D&D
    private LegacyModifier STR, DEX, CON, INT, WIS, CHA;

    /**
     * The following is constructor meant to initalize the entire character sheet.
     * The requested variables are all necessary for any given character. Some
     * variables are automatically calculated
     *
     * @param STR        A character strength ability score
     * @param DEX        A character dexterity ability score
     * @param CON        A character constitution ability score
     * @param INT        A character intelligence ability score
     * @param WIS        A character wisdom ability score
     * @param CHA        A character charisma ability score
     * @param name       A characters name
     * @param race       A characters race
     * @param campaign   A characters campaign name
     * @param alignment  A characters alignment
     * @param background A characters background
     * @param hitPoints  A characters hit point total (health)
     * @param speed      A characters total movement speed
     * @param goldCount  The total gold a player owns
     * @param armorClass A characters armor class
     * @param mainClass  CharClass object representing the main class name and level
     * @param subClass   CharClass object representing the sub class name and level
     */
    public CharacterSheet(
            int STR, int DEX, int CON, int INT, int WIS, int CHA,
            String name, String race, String campaign, String alignment, String background,
            int hitPoints, int speed, int goldCount, int armorClass, int exp,
            String mainClass, int mainLevel, String subClass, int subLevel) {

        // Generate the modifier objects
        this.STR = new LegacyModifier(STR);
        this.DEX = new LegacyModifier(DEX);
        this.CON = new LegacyModifier(CON);
        this.INT = new LegacyModifier(INT);
        this.WIS = new LegacyModifier(WIS);
        this.CHA = new LegacyModifier(CHA);

        this.name = name;
        this.race = race;
        this.campaign = campaign;
        this.alignment = alignment;
        this.background = background;
        this.profBonus = 2 + ((mainLevel + subLevel) - 1) / 4;
        this.initiative = this.DEX.getMod();
        this.hitPoints = hitPoints;
        this.speed = speed;
        this.goldCount = goldCount;
        this.armorClass = armorClass;
        this.exp = exp;

        this.mainClass = new CharClass(mainClass, mainLevel);
        this.subClass = new CharClass(subClass, subLevel);
    }

    public CharacterSheet() {
        this(10, 10, 10, 10, 10, 10,
                "testName", "testRace", "testCampaign", "Evil", "Hollow one",
                10, 30, 100, 15, 10,
                "testMainClass", 4, "testSubClass", 1);
    }

    /**
     * Get the Strength modifier
     *
     * @return A Modifier object for character Strength
     */
    public LegacyModifier getSTR() {
        return this.STR;
    }

    /**
     * Get the Dexterity modifier
     *
     * @return A Modifier object for character Dexterity
     */
    public LegacyModifier getDEX() {
        return this.DEX;
    }

    /**
     * Get the Constitution modifier
     *
     * @return A Modifier object for character Constitution
     */
    public LegacyModifier getCON() {
        return this.CON;
    }

    /**
     * Get the Intelligence modifier
     *
     * @return A Modifier object for character Intelligence
     */
    public LegacyModifier getINT() {
        return this.INT;
    }

    /**
     * Get the Wisdom modifier
     *
     * @return A Modifier object for character Wisdom
     */
    public LegacyModifier getWIS() {
        return this.WIS;
    }

    /**
     * Get the Charisma modifier
     *
     * @return A Modifier object for character Charisma
     */
    public LegacyModifier getCHA() {
        return this.CHA;
    }

    /**
     * Get the name of the character
     *
     * @return A string name for the character
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the race of the character
     *
     * @return A string name for the race of the character
     */
    public String getRace() {
        return this.race;
    }

    /**
     * Get the campaign name of the character
     *
     * @return A string name for the campaign
     */
    public String getCampaign() {
        return this.campaign;
    }

    /**
     * Get the alignment for the character
     *
     * @return A string alignment for the character
     */
    public String getAlignment() {
        return this.alignment;
    }

    /**
     * Get the background for the character
     *
     * @return A string background for the character
     */
    public String getBackground() {
        return background;
    }

    /**
     * Get the character prof bonus
     *
     * @return An integer for character prof bonus
     */
    public int getProfBonus() {
        return this.profBonus;
    }

    /**
     * Get the character Initiative
     *
     * @return An integer for character Initiative
     */
    public int getInitiative() {
        return this.initiative;
    }

    /**
     * Get the character hit point total
     *
     * @return An integer for character hit point total
     */
    public int getHp() {
        return this.hitPoints;
    }

    /**
     * Get the character speed
     *
     * @return An integer for character speed
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Get the character armor class
     *
     * @return An integer for character armor class
     */
    public int getAC() {
        return this.armorClass;
    }

    /**
     * Get the character total gold count
     *
     * @return An integer for character total gold count
     */
    public int getGold() {
        return this.goldCount;
    }

    /**
     * Get the character experience total
     *
     * @return An integer for the character experience total
     */
    public int getExp() {
        return this.exp;
    }

    /**
     * Get the characters mainClass information
     *
     * @return A CharClass object which contains a string
     * pertaining to the characters class name and an integer
     * level
     */
    public CharClass getMainClass() {
        return this.mainClass;
    }

    /**
     * Get the character subClass information
     *
     * @return A CharClass object which contains a string
     * pertaining to the characters class name and an integer
     * level
     */
    public CharClass getSubClass() {
        return this.subClass;
    }

    /**
     * Get all the items in a characters inventory
     *
     * @return A HashMap with key-value pairs being String-Item object
     */
    public HashMap<String, Item> getItems() {
        return this.items;
    }

    /*
     * All modifier (STR, DEX, CON, INT, WIS, CHA) setters use the
     * setAbilityScore method built into the Modifier object, which
     * updates the ability score and automatically calculates the new
     * modifier based on the new score
     */

    public void setSTR(int newSTR) {
        this.STR.setAbilityScore(newSTR);
    }

    public void setDEX(int newDEX) {
        this.DEX.setAbilityScore(newDEX);
        setInitiative(this.DEX.getMod());
    }

    public void setCON(int newCON) {
        this.CON.setAbilityScore(newCON);
    }

    public void setINT(int newINT) {
        this.INT.setAbilityScore(newINT);
    }

    public void setWIS(int newWIS) {
        this.WIS.setAbilityScore(newWIS);
    }

    public void setCHA(int newCHA) {
        this.CHA.setAbilityScore(newCHA);
    }

    /**
     * Set the name of the character
     *
     * @param name The new name of the character
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the race of the character
     *
     * @param race The new race name of the character
     */
    public void setRace(String race) {
        // Rarely ever used
        this.race = race;
    }

    /**
     * Set the campaign name
     *
     * @param campaign The new campaign name
     */
    public void setCampaign(String campaign) {
        // Rarely ever used
        this.campaign = campaign;
    }

    /**
     * Set the alignment of the character
     *
     * @param alignment The new alignment
     */
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    /**
     * Set the background of the character
     *
     * @param background The new background
     */
    public void setBackground(String background) { this.background = background; }

    /**
     * Set the character proficiency bonus based on total level
     */
    private void setProfBonus() {
        int mainLevel = this.mainClass.getLevel();
        int subLevel = this.subClass.getLevel();
        int totalLevel = mainLevel + subLevel;
        this.profBonus = 2 + (totalLevel - 1) / 4;
    }

    /**
     * Set the character initiative
     *
     * @param newInitiative The new initiative
     */
    private void setInitiative(int newInitiative) {
        this.initiative = newInitiative;
    }

    /**
     * Set the character hit point total
     *
     * @param newHp the new hit point total of the character
     */
    public void setHP(int newHp) {
        this.hitPoints = newHp;
    }

    /**
     * Set the character speed
     *
     * @param newSpeed the new speed of the character
     */
    public void setSpeed(int newSpeed) {
        // Very rarely if ever needs to be used
        this.speed = newSpeed;
    }

    /**
     * Set the armor class of the character
     *
     * @param newAC the new armor class of the character
     */
    public void setAC(int newAC) {
        this.armorClass = newAC;
    }

    /**
     * Set the total gold of the character
     *
     * @param goldCount the new gold count of the character
     */
    public void setGold(int goldCount) {
        this.goldCount = goldCount;
    }

    /**
     * Set the EXP total of the character
     *
     * @param exp The new exp total of the character
     */
    public void setExp(int exp) {
        this.exp = exp;
    }

    /**
     * Set the name of the main class in the charClass
     * object
     *
     * @param mainClass The new string name of the main class
     */
    public void setMainClassName(String mainClass) {
        // Should never be used, but here just in case!
        this.mainClass.setClassName(mainClass);
    }

    /**
     * Set the level of the main class in the charClass
     * object
     *
     * @param level The new level of the main class
     */
    public void setMainClassLevel(int level) {
        this.mainClass.setLevel(level);
        // Update prof bonus
        setProfBonus();
    }

    /**
     * Set the name of the subclass in the charClass
     * object
     *
     * @param subClass The new name of the subclass
     */
    public void setSubClassName(String subClass) {
        this.subClass.setClassName(subClass);
    }

    /**
     * Set the level of the subclass in the charClass
     * object
     *
     * @param level The new level of the subclass
     */
    public void setSubClassLevel(int level) {
        this.subClass.setLevel(level);
        // Update prof bonus
        setProfBonus();
    }

    /*
     * All items are stored in a HashMap whose key-value
     * pairs are the name of the item along with the item
     * object.
     */

    /**
     * Function for adding an item into the items hash map.
     * If the item already exists, we increment the itemCount.
     *
     * @param itemId The identification of this specific item
     * @param item   The item we want to add
     */
    public void addItem(String itemId, Item item) {
        // If items already exists, increment the item count
        if (items.containsKey(itemId)) {
            Item duplicate = items.remove(itemId);
            duplicate.setItemCount(duplicate.getItemCount() + item.getItemCount());
            items.put(itemId, duplicate);
        }
        // Else just add the item to the table
        items.put(itemId, item);
    }

    /**
     * Function to decrement an item count. If the count goes below 1
     * the item is no longer stored
     *
     * @param itemId      The name of the item we are decrementing
     * @param removeCount The amount we are removing
     */
    public void decrementItem(String itemId, int removeCount) {
        if (items.containsKey(itemId)) {
            Item stored = items.remove(itemId);
            int newCount = stored.getItemCount() - removeCount;
            if (newCount > 0) {
                stored.setItemCount(newCount);
                items.put(itemId, stored);
            }
        }
    }

    /**
     * Function to remove an item from the Hashmap
     *
     * @param itemId The Item being removed (regardless of count)
     */
    public void removeItem(String itemId) {
        items.remove(itemId);
    }

    /**
     * Function to update na item from the HashMap
     * (Name, description or count)
     *
     * @param itemId The id of the item being updated
     * @param item   The updated item
     */
    public void updateItem(String itemId, Item item) {
        // Should be used when description or name are changing,
        // but can be used to update count as well
        items.replace(itemId, item);
    }

}
