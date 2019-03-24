package pl.plajer.leaderboardz;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import pl.plajer.leaderboardz.api.LeaderboardStatistic;
import pl.plajer.leaderboardz.api.registry.StatisticsRegistry;
import pl.plajer.leaderboardz.cache.StatisticsCache;
import pl.plajerlair.commonsbox.minecraft.configuration.ConfigUtils;

/**
 * @author Plajer
 * <p>
 * Created at 24.03.2019
 */
public class Main extends JavaPlugin implements Listener {

  private StatisticsCache statisticsCache;

  @Override
  public void onEnable() {
    ConfigUtils.getConfig(this, "statistics_cache");
    statisticsCache = new StatisticsCache();
    getServer().getPluginManager().registerEvents(this, this);
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    for(LeaderboardStatistic statistic : StatisticsRegistry.getRegisteredStatistics()) {
      statisticsCache.cacheStatistic(e.getPlayer(), statistic, statistic.onRequest(e.getPlayer()));
    }
  }

  public StatisticsCache getStatisticsCache() {
    return statisticsCache;
  }

}
