package pl.plajer.leaderboardz.cache;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import pl.plajer.leaderboardz.api.LeaderboardStatistic;

/**
 * todo
 *
 * @version 1.0.0
 */
public class StatisticsCache {

  private Map<Player, Map<LeaderboardStatistic, Double>> cache = new HashMap<>();

  public void cacheStatistic(Player player, LeaderboardStatistic statistic, double value) {
    Map<LeaderboardStatistic, Double> preCache = cache.getOrDefault(player, new HashMap<>());
    preCache.put(statistic, value);
    cache.put(player, preCache);
  }

}
