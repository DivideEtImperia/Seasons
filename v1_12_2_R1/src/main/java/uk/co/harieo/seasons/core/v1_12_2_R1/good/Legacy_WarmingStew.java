package uk.co.harieo.seasons.core.v1_12_2_R1.good;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;
import uk.co.harieo.seasons.plugin.Seasons;
import uk.co.harieo.seasons.plugin.models.Weather;
import uk.co.harieo.seasons.plugin.models.effect.Effect;

public class Legacy_WarmingStew extends Effect {

	private static final Material[] STEWS = {Material.BEETROOT_SOUP, Material.MUSHROOM_SOUP, Material.RABBIT_STEW};

	public Legacy_WarmingStew() {
		super("Warming Stew", "Receive Regeneration 1 for 10 seconds when you consume stew",
				Collections.singletonList(Weather.COLD), true);
	}

	@Override
	public void onTrigger(World world) {
		for (Player player : world.getPlayers()) {
			player.sendMessage(Seasons.PREFIX + ChatColor.GRAY
					+ "Your stomach starts to grumble and you begin to crave some hearty soup...");
		}
	}

	@EventHandler
	public void onConsume(PlayerItemConsumeEvent event) {
		for (Material material : STEWS) {
			if (event.getItem().getType() == material) {
				Player player = event.getPlayer();
				player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * 10, 0));
				player.sendMessage(Seasons.PREFIX + ChatColor.GREEN
						+ "That hit the spot, the delicious stew makes your wounds a little more bearable...");
			}
		}
	}
}
