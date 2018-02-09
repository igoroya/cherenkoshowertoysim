package cherenkovsim.muon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLayer {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Layer layer = new Layer(0, 0, 0, 0, 0, 0);
		assertEquals(0, layer.height);
		assertEquals(0, layer.density);
		assertEquals(0, layer.massCoverage);
		assertEquals(0, layer.refractiveIndexCorrection);
		assertEquals(0, layer.temperature);
		assertEquals(0, layer.pressure);
		assertNotNull(layer.toString());
	}

}
