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

package org.codecranachan.asteroidpush.legacy.designer.data.effectors;

import org.codecranachan.asteroidpush.legacy.designer.data.EffectorData;
import org.codecranachan.asteroidpush.legacy.designer.grid.Facing;
import org.codecranachan.asteroidpush.legacy.entities.spaceship.Effector;
import org.codecranachan.asteroidpush.legacy.entities.spaceship.ForceFeeder;
import org.codecranachan.asteroidpush.legacy.utils.Pointer;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class ForceFeederData implements EffectorData {
   private Pointer anchor;
   private float magnitude;

   public Effector createEffector(float size, Transform placement, Body body) {
      ForceFeeder feeder = new ForceFeeder();
      feeder.setPropulsee(body);
      Pointer pointer = anchor.applyScale(size);
      feeder.setPlacement(pointer.applyTransform(placement));
      feeder.setFacing(Facing.fromTransform(placement));
      feeder.setMagnitude(magnitude);
      return feeder;
   }

   public ForceFeederData() {
      this.anchor = new Pointer();
      this.magnitude = 0.0f;
   }

   public void setAnchor(Vec2 offset, float angle) {
      this.anchor.set(offset, angle);
   }

   public void setMagnitude(float magnitude) {
      this.magnitude = magnitude;
   }
}