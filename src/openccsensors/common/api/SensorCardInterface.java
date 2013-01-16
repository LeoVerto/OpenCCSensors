package openccsensors.common.api;

public class SensorCardInterface {

	private int id;
	private String name;
	private SensorUpgrade upgrade;
	private Class sensorClass;

	/**
	 * 
	 * @param id
	 *            This is the icon index
	 * @param name
	 *            This is the key in the language file
	 * @param upgrade
	 *            The upgrade for this
	 * @param sensor
	 *            The sensor type
	 */
	public SensorCardInterface(int id, String name, SensorUpgrade upgrade,
			Class sensorClass) {
		this.id = id;
		this.name = name;
		this.upgrade = upgrade;
		this.sensorClass = sensorClass;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public SensorUpgrade getSensorUpgrade() {
		return null;
	}

	public ISensor getSensor() {
		return SensorManager.getSensor(sensorClass);
	}

}
