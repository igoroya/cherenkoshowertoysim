package cherenkovsim.muon;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestAtmosphereModel {
	final ClassLoader classLoader = getClass().getClassLoader();
	private static final String ATMOSPHERE_MODEL_FILE = "resources/ok_atm.txt";
	private static final String WRONG_ATMOSPHERE_MODEL_FILE_1 = "resources/wrong_atm.txt";
	private static final String SITE = "H.E.S.S";
	
	@BeforeEach
	void setUp() throws Exception {	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFromTextFile() {
		//Test when the file is OK
		File file = new File(classLoader.getResource(ATMOSPHERE_MODEL_FILE).getFile());
		AtmosphereModel model = AtmosphereModel.fromTextFile(file, SITE);	
		assertNotNull(model.atmosphere);
		assertEquals(SITE, model.location);
	
		//Test when file has the wrong number of columns
		assertThrows(
				IllegalArgumentException.class,
				()->{AtmosphereModel.fromTextFile(
						new File(classLoader.getResource(WRONG_ATMOSPHERE_MODEL_FILE_1).getFile()), 
						SITE);});			
	}

	@Test
	void testToString() {
		File file = new File(classLoader.getResource(ATMOSPHERE_MODEL_FILE).getFile());
		AtmosphereModel model = AtmosphereModel.fromTextFile(file, SITE);		
		assertNotNull(model.toString());
	}

}
