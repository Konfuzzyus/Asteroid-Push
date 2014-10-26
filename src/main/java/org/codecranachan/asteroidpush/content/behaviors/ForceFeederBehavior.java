package org.codecranachan.asteroidpush.content.behaviors;

import java.util.Collection;
import java.util.LinkedList;

import org.codecranachan.asteroidpush.base.input.ControlItem;
import org.codecranachan.asteroidpush.base.input.Controller;
import org.codecranachan.asteroidpush.base.simulation.InteractionHandler;
import org.codecranachan.asteroidpush.base.simulation.RigidBody;
import org.codecranachan.asteroidpush.base.simulation.command.Command;
import org.codecranachan.asteroidpush.base.visuals.Representation;
import org.codecranachan.asteroidpush.base.workshop.actor.Behavior;
import org.codecranachan.asteroidpush.content.visuals.ExhaustRepresentation;
import org.codecranachan.asteroidpush.utils.Arrow;

public class ForceFeederBehavior implements Behavior, InteractionHandler {
   private Arrow force;
   private RigidBody currentBody;
   private Controller controller;

   private boolean isActive;

   public ForceFeederBehavior(Arrow force) {
      this.force = force;
      this.currentBody = null;
      this.isActive = false;
   }

   public Collection<Command> update(int frame) {
      if (controller != null && currentBody != null) {
         float factor = controlMagnitude(frame);
         currentBody.applyForce(calculateForce().applyScale(factor));
         isActive = (factor > 0.0f);
      }

      return new LinkedList<Command>();
   }

   private float controlMagnitude(int frame) {
      return controller.getControl(ControlItem.FORWARD_THRUST, frame);
   }

   private Arrow calculateForce() {
      Arrow bodyPosition = currentBody.getPosition();
      return force.applyTransform(bodyPosition.getTransform());
   }

   public void onDetach(RigidBody body, int index) {
      assert index == 0;
      assert body == currentBody;
      currentBody = null;
   }

   public void onAttach(RigidBody body, int index) {
      assert index == 0;
      assert currentBody == null;
      currentBody = body;
   }

   public Collection<Representation> getRepresentations() {
      Collection<Representation> reps = new LinkedList<Representation>();
      if (currentBody != null && isActive) {
         reps.add(new ExhaustRepresentation(calculateForce()));
      }
      return reps;
   }

   public void setController(Controller controller, int index) {
      assert index == 0;
      this.controller = controller;
   }

}