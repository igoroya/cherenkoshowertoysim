package cherenkovsim.muon;

final class Layer {
	final float height, density, massCoverage, refractiveIndexCorrection, temperature, pressure;
	Layer(float height, 
		  float density, 
		  float massCoverage, 
		  float refractiveIndexCorrection, 
		  float temperature, 
		  float pressure) {
		this.height = height;
		this.density = density; 
		this.massCoverage = massCoverage;
		this.refractiveIndexCorrection = refractiveIndexCorrection;
		this.temperature = temperature;
		this.pressure = pressure;
		}
	
	@Override
	public String toString() {	
		StringBuilder str = new StringBuilder();		
		str.append("height: ");
		str.append(height);
		str.append(", density: ");
		str.append(density);
		str.append(", massCoverage: ");
	    str.append(massCoverage);
		str.append(", refractiveIndexCorrection: ");
		str.append(refractiveIndexCorrection);
		str.append(", temperature: ");
		str.append(temperature);
		str.append(", pressure: ");
		str.append(pressure);		
		return str.toString();
	}
}