package org.codecranachan.asteroidpush.workshop.assembly;

import java.util.Collection;
import java.util.LinkedList;

import org.codecranachan.asteroidpush.simulation.modular.BehaviorFactory;
import org.codecranachan.asteroidpush.visuals.Representation;
import org.codecranachan.asteroidpush.workshop.tokenboard.Placeable;
import org.codecranachan.asteroidpush.workshop.tokenboard.Shape;

public class Part implements Placeable {
   private Collection<BehaviorFactory> factories;
   private Shape shape;

   // Should be a bunch of factories and the coordinates to attach them to

   public Part(Shape shape) {
      assert shape != null;
      this.factories = new LinkedList<BehaviorFactory>();
      this.shape = shape;
   }

   public void AddBehaviorFactory(BehaviorFactory factory) {
      factories.add(factory);
   }

   public Shape getShape() {
      return shape;
   }

   public Collection<Representation> getRepresentations() {
      Collection<Representation> representations = new LinkedList<Representation>();
      for (BehaviorFactory factory : factories) {
         if (factory.getRepresentations() != null) {
            representations.addAll(factory.getRepresentations());
         }
      }
      return representations;
   }
}
