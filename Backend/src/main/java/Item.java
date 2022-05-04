/**
 * A Dungeons and Dragon item which consists of a name, description, and
 * option attack bonus
 */

public class Item {
    private String name, description;
    private int itemCount;

    /**
     * Initailize a Item object
     * 
     * @param name        The name of the item being created
     * @param description The description of the item being created
     * @param itemCount   How many of this item are there? (Ex: 10 torch lights )
     */
    public Item(String name, String description, int itemCount) {
        this.name = name;
        this.description = description;
        this.itemCount = itemCount;
    }

    /**
     * Get the name of the item
     * 
     * @return Return a string representing the name of the item
     */
    String getName() {
        return this.name;
    }

    /**
     * Get the description of the item
     * 
     * @return Return a string representing the description of the item
     */
    String getDescription() {
        return this.description;
    }

    /**
     * Get how many of this item there are
     * 
     * @return return an integer representing the number of replicas there are
     */
    int getItemCount() {
        return this.itemCount;
    }

    /**
     * Set the new name of the item (rarely if ever used)
     * 
     * @param name The new string name of the item
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Set the description of the item (rarely if ever used)
     * 
     * @param description The new string description of the item
     */
    void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the amount of replicas there are of this item
     * 
     * @param itemCount The new integer amount representing how many duplicates
     */
    void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

}
