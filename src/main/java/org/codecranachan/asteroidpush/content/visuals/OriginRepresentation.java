package org.codecranachan.asteroidpush.content.visuals;

import org.codecranachan.asteroidpush.base.visuals.Representation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class OriginRepresentation implements Representation {

   public void render(Graphics g) {
      Color color = new Color(Color.white);
      color.a = 0.5f;
      g.setColor(color);
      g.setLineWidth(1.25f);
      g.drawLine(-0.1f, 0.0f, 0.4f, 0.0f);
      g.drawLine(0.0f, -0.1f, 0.0f, 0.2f);
   }

   public int getPriority() {
      return 5;
   }

}
