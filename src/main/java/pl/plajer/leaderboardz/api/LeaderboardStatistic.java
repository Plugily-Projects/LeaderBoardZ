package pl.plajer.leaderboardz.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * todo
 *
 * @version 1.0.0
 */
public class LeaderboardStatistic {

  private JavaPlugin plugin;
  private String id;
  private ValueType valueType;
  private List<String> signLines;

  public LeaderboardStatistic(JavaPlugin plugin, String id, ValueType valueType) {
    this(plugin, id, valueType, new ArrayList<>());
  }

  public LeaderboardStatistic(JavaPlugin plugin, String id, ValueType valueType, List<String> signLines) {
    Validate.notNull(plugin, "JavaPlugin cannot be null!");
    this.plugin = plugin;
    this.id = id;
    this.valueType = valueType;
    this.signLines = signLines;
  }

  public JavaPlugin getPlugin() {
    return plugin;
  }

  public String getId() {
    return id;
  }

  public ValueType getValueType() {
    return valueType;
  }

  public List<String> getSignLines() {
    return signLines;
  }

  /**
   * Value returned for target player
   * @param player player to retrieve value from
   * @return statistic of player
   */
  public Double onRequest(Player player) {
    return null;
  }

  public enum ValueType {
    /**
     * Returns integer value when displaying on leader board, ie. 3 not 3.0
     */
    INTEGER,
    /**
     * Returns float value when displaying on leader board, ie. 2.1 not 2
     */
    FLOAT
  }

}
