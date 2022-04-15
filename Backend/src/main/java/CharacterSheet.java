/**
 * An encompassing object which directly correlates to everything on a
 * players character sheet
 */

public class CharacterSheet {
    // In function dice roller
    DiceRoller dice;

    int level;
    int profBonus; // profBonus directly based off character level
    int initiative;
    int hitPoints;
    int speed;
    int armorClass;
    Modifier STR, DEX, CON, INT, WIS, CHA;

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
     * @param level      A characters level (profBonus determined by character
     *                   level)
     * @param hitPoints  A characters hit point total (health)
     * @param speed      A characters total movement speed
     * @param armorClass A characters armor class
     */
    public CharacterSheet(
            int STR, int DEX, int CON, int INT, int WIS, int CHA,
            int level, int initiative, int hitPoints, int speed, int armorClass) {

        dice = new DiceRoller();
        this.STR = new Modifier(STR);
        this.DEX = new Modifier(DEX);
        this.CON = new Modifier(CON);
        this.INT = new Modifier(INT);
        this.WIS = new Modifier(WIS);
        this.CHA = new Modifier(CHA);
        this.level = level;
        this.profBonus = 2 + (level - 1) / 4;
        this.initiative = initiative;
        this.hitPoints = hitPoints;
        this.speed = speed;
        this.armorClass = armorClass;
    }

    /**
     * Execute a strength check
     * 
     * @param withProf A boolean which determines if the check is done with
     *                 proficiency
     * @return If withProf: D20 + mod + profBonus, else: D20 + mod
     */
    int STRCheck(boolean withProf) {
        if (withProf)
            return dice.D20(1, this.STR.getMod() + this.profBonus);
        else
            return dice.D20(1, this.STR.getMod());
    }

    /**
     * Execute a dexterity check
     * 
     * @param withProf A boolean which determines if the check is done with
     *                 proficiency
     * @return If withProf: D20 + mod + profBonus, else: D20 + mod
     */
    int DEXCheck(boolean withProf) {
        // TODO Follow STRCheck example
        return -1;
    }

    /**
     * Execute a constitution check
     * 
     * @param withProf A boolean which determines if the check is done with
     *                 proficiency
     * @return If withProf: D20 + mod + profBonus, else: D20 + mod
     */
    int CONCheck(boolean withProf) {
        // TODO Follow STRCheck example
        return -1;
    }

    /**
     * Execute a intelligence check
     * 
     * @param withProf A boolean which determines if the check is done with
     *                 proficiency
     * @return If withProf: D20 + mod + profBonus, else: D20 + mod
     */
    int INTCheck(boolean withProf) {
        // TODO Follow STRCheck example
        return -1;
    }

    /**
     * Execute a wisdom check
     * 
     * @param withProf A boolean which determines if the check is done with
     *                 proficiency
     * @return If withProf: D20 + mod + profBonus, else: D20 + mod
     */
    int WISCheck(boolean withProf) {
        // TODO Follow STRCheck example
        return -1;
    }

    /**
     * Execute a charisma check
     * 
     * @param withProf A boolean which determines if the check is done with
     *                 proficiency
     * @return If withProf: D20 + mod + profBonus, else: D20 + mod
     */
    int CHACheck(boolean withProf) {
        // TODO Follow STRCheck example
        return -1;
    }

    /**
     * Roll an initiative check
     * 
     * @return D20 + initiative modifier
     */
    int rollInitiative() {
        // TODO Roll D20 + initiative mod
        return -1;
    }

    // ***** GETTERS *****//

    /*
     * I NEED TO DO SOME MORE THINKING ON HOW WE
     * HANDLE THE GETTERS FOR THE MODIFIERS. SO FOR THE TIME BEING
     * WE HAVE NO GETTERS FOR THEM
     */

    /**
     * Get the characters level
     * 
     * @return The characters level
     */
    int getLevel() {
        return this.level;
    }

    /**
     * Get the character armor class
     * 
     * @return The characters armor class
     */
    int getAC() {
        return this.armorClass;
    }

    /**
     * Get the character speed
     * 
     * @return The characters speed
     */
    int getSpeed() {
        return this.speed;
    }

    /**
     * Get the character hit point total
     * 
     * @return The characters hit point total
     */
    int getHP() {
        return this.hitPoints;
    }

    /**
     * Get the character initative
     * 
     * @return The characters initiative
     */
    int getInitiative() {
        return this.initiative;
    }

    // ***** SETTERS *****//

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
     * Set the character armor class
     * 
     * @param newAC The new armor class of the character
     */
    void setAC(int newAC) {
        this.armorClass = newAC;
    }

    /**
     * Set the character speed
     * 
     * @param newSpeed The new speed of the character
     */
    void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    /**
     * Set the character hit point total
     * 
     * @param newHp The new character hit point total
     */
    void setHP(int newHp) {
        this.hitPoints = newHp;
    }

    /**
     * Set the character initiative modifier
     * 
     * @param newInitiative The new initiative modifier
     */
    void setInitiative(int newInitiative) {
        this.initiative = newInitiative;
    }

    /**
     * Update the strength ability score using the methods
     * inside the Modifier class
     * 
     * @param newSTR
     */
    void setSTR(int newSTR) {
        this.STR.setAbilityScore(newSTR);
    }

    /**
     * Update the dexterity ability score using the methods
     * inside the Modifier class
     * 
     * @param newDEX
     */
    void setDEX(int newDEX) {
        this.DEX.setAbilityScore(newDEX);
    }

    /**
     * Update the constitution ability score using the methods
     * inside the Modifier class
     * 
     * @param newCON
     */
    void setCON(int newCON) {
        this.CON.setAbilityScore(newCON);
    }

    /**
     * Update the intelligence ability score using the methods
     * inside the Modifier class
     * 
     * @param newINT
     */
    void setINT(int newINT) {
        this.INT.setAbilityScore(newINT);
    }

    /**
     * Update the wisdom ability score using the methods
     * inside the Modifier class
     * 
     * @param newWIS
     */
    void setWIS(int newWIS) {
        this.WIS.setAbilityScore(newWIS);
    }

    /**
     * Update the charisma ability score using the methods
     * inside the Modifier class
     * 
     * @param newCHA
     */
    void setCHA(int newCHA) {
        this.CHA.setAbilityScore(newCHA);
    }

}
