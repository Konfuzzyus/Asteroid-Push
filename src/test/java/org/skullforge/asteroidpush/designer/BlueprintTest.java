//    Asteroid Push - A game featuring selfmade spaceships and pompous physics
//    Copyright (C) 2013  Christian Meyer, Silvan Wegmann
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.

package org.skullforge.asteroidpush.designer;

import static org.junit.Assert.*;

import java.util.Collection;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;
import org.skullforge.asteroidpush.designer.Blueprint;
import org.skullforge.asteroidpush.designer.data.ModuleData;
import org.skullforge.asteroidpush.designer.grid.Facing;
import org.skullforge.asteroidpush.designer.grid.Placement;
import org.skullforge.asteroidpush.testutils.ClassMockery;

public class BlueprintTest {
   ClassMockery context;
   ModuleData abacusMock;
   ModuleData bananaMock;
   Blueprint testDesign;

   @Before
   public void setUp() throws Exception {
      context = new ClassMockery();
      abacusMock = context.mock(ModuleData.class, "AbacusModule");
      bananaMock = context.mock(ModuleData.class, "BananaModule");
      testDesign = new Blueprint();
   }

   @Test
   public void testGetTokens() {
      Collection<ModuleToken> tokens = testDesign.getTokens();
      assertEquals(0, tokens.size());
   }

   @Test
   public void testAddModule() {
      final Placement centerPlacement = new Placement();
      final Placement bottomPlacement = new Placement(0, 1, Facing.FORWARD);

      context.checking(new Expectations() {
         {
         }
      });

      assertTrue(testDesign.canAddModule(centerPlacement, null));
      testDesign.addModule(centerPlacement, abacusMock);
      assertFalse(testDesign.canAddModule(centerPlacement, null));
      assertTrue(testDesign.canAddModule(bottomPlacement, null));
      testDesign.addModule(bottomPlacement, bananaMock);

      Collection<ModuleToken> modules = testDesign.getTokens();
      assertEquals(2, modules.size());

      context.assertIsSatisfied();
   }
}
