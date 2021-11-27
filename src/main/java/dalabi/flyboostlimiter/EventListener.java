package dalabi.flyboostlimiter;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Location oldLoc = event.getFrom();
		Location newLoc = event.getTo();
		if (newLoc.distance(oldLoc) >= FlyBoostLimiterPlugin.getInstance().getLimit()) {
			if (Staff.getInstance().getStaffList().contains(event.getPlayer().getUniqueId())) {
				return;
			}
			event.setTo(event.getFrom());
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		if (event.getPlayer().hasPermission("flyboost.bypass")) {
			Staff.getInstance().addStaff(event.getPlayer().getUniqueId());
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		if (Staff.getInstance().getStaffList().contains(event.getPlayer().getUniqueId())) {
			Staff.getInstance().removeStaff(event.getPlayer().getUniqueId());
		}
	}

}
