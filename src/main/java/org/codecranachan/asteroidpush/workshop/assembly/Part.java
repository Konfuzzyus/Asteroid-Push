package org.codecranachan.asteroidpush.workshop.assembly;

import java.util.Collection;
import java.util.LinkedList;

import org.codecranachan.asteroidpush.simulation.modular.BehaviorFactory;
import org.codecranachan.asteroidpush.visuals.Representation;

public class Part {
   private Collection<AssemblyVertex> hardpoints;
   private Collection<BehaviorFactory> behaviors;

   public Part() {
      hardpoints = new LinkedList<AssemblyVertex>();
      behaviors = new LinkedList<BehaviorFactory>();
   }

   public void AddHardpoint(AssemblyVertex hardpoint) {
      hardpoints.add(hardpoint);
   }

   public void AddSoftlink(BehaviorFactory softlink) {
      behaviors.add(softlink);
   }

   public Collection<AssemblyVertex> getHardpoints() {
      return hardpoints;
   }

   public Collection<BehaviorFactory> getBehaviors() {
      return behaviors;
   }

   public Collection<Representation> getRepresentations() {
      Collection<Representation> representations = new LinkedList<Representation>();
      for (BehaviorFactory factory : behaviors) {
         if (factory.getRepresentation() != null) {
            representations.add(factory.getRepresentation());
         }
      }
      return representations;
   }
}
