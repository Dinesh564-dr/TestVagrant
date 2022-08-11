package testVargant;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

public class ObjectMap {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper objmap = new ObjectMapper();
		File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\testVargant\\team.json");
		// reading values from json object
		Team team = objmap.readValue(f, Team.class);
		// System.out.println(team.getPlayer().size());
		// to get the team size
		int teamsize = team.getPlayer().size();

		int foreignCountryPlayerCount = 0;
		int wicketKeeperCount = 0;
		for (int i = 0; i < teamsize; i++) {
			String country = team.getPlayer().get(i).getCountry();
			String role = team.getPlayer().get(i).getRole();
			String name = team.getPlayer().get(i).getName();

			if (role.contentEquals("Wicket-keeper"))
				wicketKeeperCount = wicketKeeperCount + 1;
			if (!country.contentEquals("India"))
				foreignCountryPlayerCount = foreignCountryPlayerCount + 1;
		}
		System.out.println("Foreign Country Player Count " + foreignCountryPlayerCount);
		System.out.println("Wicket Keeper Count " + wicketKeeperCount);
		Assert.assertTrue(foreignCountryPlayerCount <= 4,
				"ForeignPlayerCountException: There are more than 4 foreign players");
		Assert.assertTrue(wicketKeeperCount >= 1,
				"WicketKeeperCountException: There are no wicket keeper in the team ");
	}

}
