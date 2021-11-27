package dalabi.flyboostlimiter;

import org.bukkit.plugin.java.JavaPlugin;

public class FlyBoostLimiterPlugin extends JavaPlugin {

	private static FlyBoostLimiterPlugin instance;

	public static FlyBoostLimiterPlugin getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		new Staff();
		saveDefaultConfig();
		this.flyboostLimit = getConfig().getDouble("limit");
		getServer().getPluginManager().registerEvents(new EventListener(), this);
	}

	private double flyboostLimit = 1.5;

	public double getLimit() {
		return this.flyboostLimit;
	}

}
