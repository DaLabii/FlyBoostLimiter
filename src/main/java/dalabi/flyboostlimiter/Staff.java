package dalabi.flyboostlimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Staff {

	private static Staff instance;

	public static Staff getInstance() {
		return instance;
	}

	public Staff() {
		instance = this;
	}

	private List<UUID> staffList = new ArrayList<>();

	public void addStaff(UUID uuid) {
		this.staffList.add(uuid);
	}

	public void removeStaff(UUID uuid) {
		this.staffList.remove(uuid);
	}

	public List<UUID> getStaffList() {
		return staffList;
	}

}
