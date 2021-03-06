package org.codecranachan.asteroidpush.base.workshop.actor;

import org.codecranachan.asteroidpush.base.simulation.RigidBody;

public class Plug {
   private Behavior behavior;
   private int index;

   public Plug(Behavior behavior, int index) {
      this.behavior = behavior;
      this.index = index;
   }

   public Behavior getBehavior() {
      return behavior;
   }

   public int getIndex() {
      return index;
   }
  
   public void notifyAttach(RigidBody body){
      behavior.onAttach(body, index);
   }

   public void notifyDetach(RigidBody body){
      behavior.onDetach(body, index);
   }
}
