package unterordner;

public class Car {
	private String modelName;
	private String brand;
	private int horsePower;
	
	public Car(String modelName,String brand, int horsePower) {
		this.modelName = modelName;
		this.brand = brand;
		this.horsePower = horsePower;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	
	
}
