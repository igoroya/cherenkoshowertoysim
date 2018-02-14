package cherenkovsim.muon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * Represents a model of the atmosphere above which the processes happen
 * 
 * @author igoroya
 *
 */
public final class AtmosphereModel {
	
	final List<Layer> atmosphere;
	final String location;
	
	private static final int ENTRIES_PER_LINE = 6;
	
	private AtmosphereModel (List<Layer> atmosphere, String location){
		this.atmosphere = atmosphere;
		this.location = location;
	}

	/**
	 * Creates a new atmosphere model object based on an input text file
	 * The input file expects the following format:
	 * 6 columns, space separated, with a header line 
	 * The columns represent the following magnitudes
	 * height density massCoverage refractiveIndexCorrection temperature pressure
	 * 
	 * @param file text file with the atmosphere model
	 * @param location the physical location on Earth for which the atmosphere model is valid
	 * @return
	 */
	public static final AtmosphereModel fromTextFile(File file, String location) {
		
		List<Layer> atmosphere = new ArrayList<>();	
		
		try(Scanner scanner = new Scanner(file)) {
			
			//Skip the 1s line because it is the header
			String line = scanner.nextLine(); 
			
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();   
				String elements[]=line.split("\\s+");
				
				if (elements.length != ENTRIES_PER_LINE) {
					throw new IllegalArgumentException(
							"Input file has incorrect number of columns, expected: "
							+ ENTRIES_PER_LINE
							+ ", found: "
							+ elements.length);
				}
				
				Layer layer = new Layer(Float.parseFloat(elements[0]),
										Float.parseFloat(elements[1]),
										Float.parseFloat(elements[2]),
										Float.parseFloat(elements[3]),
										Float.parseFloat(elements[4]),
										Float.parseFloat(elements[5]));
				
				atmosphere.add(layer);
			}
		    scanner.close();
						
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
		
		return new AtmosphereModel(atmosphere, location);
		
	}

	public float getDensityAt(float height) {
		return 1.1f;//FIXME
	}
	
	private float interpolateAt(float[] heights, float[] values, float height) {
		
		//NOTE: Use spline interpolator from Apache.Commons.Math library
		
		int length = heights.length;
		
		if (length != values.length)
			throw new IllegalStateException();
		
		for (int i = 0; i < length; i++) {
			
		}
		return 1.1f;//FIXME
	}
	
	@Override
	public String toString() {
		String out = "Atmosphere model from " + location;
		return out;
	}
}
