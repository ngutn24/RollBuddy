/**
 * The Dice ENUM encompasses the 8 different types of Dice
 * available to a player in D&D 5E. Each ENUM has an attached
 * integer value in accordance with dice type.
 */

public enum Dice {
  D4(4),
  D6(6),
  D8(8),
  D10(10),
  D12(12),
  D20(20),
  D100(100);

  /**
   * Each Dice enum as a corresponding integer value which
   * numerically represents the dice type
   */
  public final int range;

  private Dice(int range) {
    this.range = range;
  }
}
