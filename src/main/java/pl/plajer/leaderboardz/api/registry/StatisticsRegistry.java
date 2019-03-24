package pl.plajer.leaderboardz.api.registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.bukkit.plugin.java.JavaPlugin;

import pl.plajer.leaderboardz.api.LeaderboardStatistic;

/**
 * Class for registering custom leaderboard statistics
 *
 * @version 1.0.0
 */
public class StatisticsRegistry {

  private static List<LeaderboardStatistic> statistics = new ArrayList<>();

  /**
   * Attempts to register leader board statistic into registry.
   *
   * @param statistic statistic to register
   * @throws IllegalArgumentException when statistic is null
   */
  public static void registerStatistic(LeaderboardStatistic statistic) {
    Validate.notNull(statistic, "Statistic to register cannot be null!");
    statistics.add(statistic);
  }

  /**
   * Attempts to unregister leader board statistic from registry
   *
   * @param plugin    plugin that is unregistering statistic
   * @param statistic statistic to unregister
   * @throws IllegalArgumentException when plugin is different than statistic#getPlugin()
   *                                  only owner plugin can unregister its statistics!
   */
  public static void unregisterStatistic(JavaPlugin plugin, LeaderboardStatistic statistic) {
    if (!statistic.getPlugin().equals(plugin)) {
      throw new IllegalArgumentException("Only owner plugin can unregister its statistics!");
    }
    statistics.remove(statistic);
  }

  public static List<LeaderboardStatistic> getRegisteredStatistics() {
    return Collections.unmodifiableList(statistics);
  }

}
