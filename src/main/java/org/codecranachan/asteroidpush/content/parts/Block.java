package org.codecranachan.asteroidpush.content.parts;

import org.codecranachan.asteroidpush.base.simulation.Material;
import org.codecranachan.asteroidpush.base.simulation.Primitive;
import org.codecranachan.asteroidpush.base.workshop.PartFactory;
import org.codecranachan.asteroidpush.base.workshop.assembly.Component;
import org.codecranachan.asteroidpush.base.workshop.assembly.Part;
import org.codecranachan.asteroidpush.base.workshop.assembly.Socket;
import org.codecranachan.asteroidpush.base.workshop.tokenboard.Shape;
import org.codecranachan.asteroidpush.content.behaviors.CollisionBehaviorFactory;
import org.jbox2d.common.Vec2;

public class Block implements PartFactory {

   public String getName() {
      return "Block";
   }

   public Part createPart() {
      Part part = new Part(getPartShape());
      part.addComponent(createMainComponent());
      return part;
   }

   private Component createMainComponent() {
      Socket socket = new Socket();
      socket.addLink(-1, 0);
      socket.addLink(0, -1);
      socket.addLink(1, 0);
      socket.addLink(0, 1);
      Component main = new Component(socket);

      Primitive shape = new Primitive();
      shape.AddSquare(new Vec2(0, 0), 1.0f);
      CollisionBehaviorFactory factory = new CollisionBehaviorFactory(shape,
            Material.METAL);

      main.add(factory, 0);
      return main;
   }

   private Shape getPartShape() {
      return new Shape("X");
   }

}
