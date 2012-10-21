package org.skullforge.asteroidpush;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.skullforge.asteroidpush.doodads.Doodad;

public class ScenarioTest {
   Scenario testScenario;

   @Before
   public void setUp() throws Exception {
      testScenario = new Scenario();
   }

   @Test
   public void testBuildDoodads() {
      ArrayList<Doodad> doodads = testScenario.buildDoodads();
      assertNotNull(doodads);
      assertEquals(6, doodads.size());
      assertEquals("PlayingFieldBorder", doodads.get(0).getName());
      for (int i = 1; i < 5; ++i) {
         assertEquals("Asteroid", doodads.get(i).getName());
      }
      assertEquals("Spaceship", doodads.get(5).getName());
   }
}
