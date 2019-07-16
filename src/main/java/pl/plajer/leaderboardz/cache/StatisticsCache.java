package pl.plajer.leaderboardz.cache;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import pl.plajer.leaderboardz.Main;
import pl.plajer.leaderboardz.api.LeaderboardStatistic;
import pl.plajerlair.commonsbox.minecraft.configuration.ConfigUtils;

/**
 * todo
 *
 * @version 1.0.0
 */
public class StatisticsCache {

  private Main plugin;
  private Map<Player, Map<LeaderboardStatistic, Double>> cache = new HashMap<>();

  public StatisticsCache(Main plugin) {
    this.plugin = plugin;
  }

  public void cacheStatistic(Player player, LeaderboardStatistic statistic, double value) {
    Map<LeaderboardStatistic, Double> preCache = cache.getOrDefault(player, new HashMap<>());
    preCache.put(statistic, value);
    cache.put(player, preCache);
  }

  /**
   * Serializes cache into statistics_cache.yml file
   */
  public void serialize() {
    FileConfiguration config = ConfigUtils.getConfig(plugin, "statistics_cache");
    for(Map.Entry<Player, Map<LeaderboardStatistic, Double>> entry : cache.entrySet()) {
      Player player = entry.getKey();
      for(Map.Entry<LeaderboardStatistic, Double> values : entry.getValue().entrySet()) {
        config.set(player.getUniqueId() + "." + values.getKey().getId(), values.getValue());
      }
    }
    ConfigUtils.saveConfig(plugin, config, "statistics_cache");
  }

}
