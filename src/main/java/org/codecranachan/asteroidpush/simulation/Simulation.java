package org.codecranachan.asteroidpush.simulation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Stack;

import org.codecranachan.asteroidpush.simulation.command.Command;

public class Simulation {
   private PhysicsEngine engine;
   private int currentFrameNumber;
   private Collection<Actor> actors;
   private Stack<Command> commands;

   public Simulation(PhysicsEngine engine) {
      this.engine = engine;
      this.actors = new HashSet<Actor>();
      this.commands = new Stack<Command>();
   }

   public void stepToFrame(int targetFrameNumber) {
      while (currentFrameNumber < targetFrameNumber) {
         computeNextFrame();
      }
   }
   
   public RigidBodyFactory getBodyFactory() {
      return engine.getBodyFactory();
   }
   
   public void addActor(Actor actor) {
      actors.add(actor);
   }
   
   public void removeActor(Actor actor) {
      actors.remove(actor);
   }

   private void computeNextFrame() {
      ++currentFrameNumber;
      updateActors();
      executeCommands();
      engine.stepWorld();
   }

   private void updateActors() {
      for (Actor nextActor : actors) {
         commands.addAll(nextActor.update(currentFrameNumber));
      }
   }

   private void executeCommands() {
      while (!commands.empty()) {
         commands.pop().execute(this);
      }
   }
}