package main.java;

import java.util.Objects;

/**
 * A Dungeons and Dragon item which consists of a name, description, and
 * option attack bonus
 */

public class Item {
    private String name, description;
    private int itemCount;

    /**
     * Initialize an Item object
     * 
     * @param name        The name of the item being created
     * @param description The description of the item being created
     * @param itemCount   How many of this item are there? (Ex: 10 torch lights )
     */
    public Item(String name, String description, int itemCount) {
        if (Objects.equals(name, ""))
        { throw new IllegalArgumentException("Name field cannot be empty"); }

        if (Objects.equals(description, ""))
        { throw new IllegalArgumentException("Description field cannot be empty"); }

        if (itemCount < 1)
        { throw new IllegalArgumentException("Item count field must be > 0"); }

        this.name = name;
        this.description = description;
        this.itemCount = itemCount;
    }

    /**
     * Get the name of the item
     * 
     * @return Return a string representing the name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the description of the item
     * 
     * @return Return a string representing the description of the item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get how many of this item there are
     * 
     * @return return an integer representing the number of replicas there are
     */
    public int getItemCount() {
        return this.itemCount;
    }

    /**
     * Set the new name of the item (rarely if ever used)
     * 
     * @param name The new string name of the item
     */
    public void setName(String name) {
        if (Objects.equals(name, ""))
        { throw new IllegalArgumentException("Name field cannot be empty"); }

        this.name = name;
    }

    /**
     * Set the description of the item (rarely if ever used)
     * 
     * @param description The new string description of the item
     */
    public void setDescription(String description) {
        if (Objects.equals(description, ""))
        { throw new IllegalArgumentException("Description field cannot be empty"); }

        this.description = description;
    }

    /**
     * Set the amount of replicas there are of this item
     * 
     * @param itemCount The new integer amount representing how many duplicates
     */
    public void setItemCount(int itemCount) {
        if (itemCount < 1)
        { throw new IllegalArgumentException("Item count field must be > 0"); }

        this.itemCount = itemCount;
    }

}
