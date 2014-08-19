package org.codecranachan.asteroidpush.state.ui;

import java.util.Vector;

import org.codecranachan.asteroidpush.workshop.Blueprint;
import org.codecranachan.asteroidpush.workshop.BlueprintCollection;
import org.codecranachan.asteroidpush.workshop.ManipulatedArea;
import org.codecranachan.asteroidpush.workshop.Manipulator;
import org.codecranachan.asteroidpush.workshop.OrthogonalCoordinate;
import org.codecranachan.asteroidpush.workshop.PartSelector;
import org.codecranachan.asteroidpush.workshop.assembly.Part;
import org.codecranachan.asteroidpush.workshop.parts.PartFactory;

public class WorkshopCoordinator {
   private Manipulator manipulator;
   private PartSelector selector;
   private BlueprintCollection collection;

   public WorkshopCoordinator(Manipulator manipulator, PartSelector selector,
         BlueprintCollection collection) {
      this.manipulator = manipulator;
      this.selector = selector;
      this.collection = collection;

      manipulator.setBlueprint(collection.getActive());
      selector.clearSelection();
   }

   public void createNewBlueprint() {
      selector.clearSelection();
      collection.addBlueprint(new Blueprint());
      manipulator.setBlueprint(collection.getActive());
   }

   public void pickSquare(OrthogonalCoordinate coordinate) {
      if (manipulator.getSelection() == null) {
         manipulator.pick(coordinate);
      } else {
         manipulator.place(coordinate);
         manipulator.setSelection(selector.getNewPart());
      }
   }

   public void clearSquare(OrthogonalCoordinate coordinate) {
      if (manipulator.getSelection() == null) {
         manipulator.erase(coordinate);
      } else {
         clearSelection();
      }
   }

   public Blueprint getManipulatedBlueprint() {
      return manipulator.getBlueprint();
   }

   public ManipulatedArea getManipulatedArea() {
      return manipulator.getManipulatedArea();
   }

   public Vector<PartFactory> getAvailablePartFactories() {
      return selector.getPartFactories();
   }

   public void selectPart(int index) {
      selector.selectByIndex(index);
      PartFactory factory = selector.getSelected();
      if (factory == null) {
         manipulator.clearSelection();
      } else {
         manipulator.setSelection(factory.createPart());
      }
   }

   public void clearSelection() {
      manipulator.clearSelection();
      selector.clearSelection();
   }

   public Part getSelectedPart() {
      return manipulator.getSelection();
   }

   public PartFactory getSelectedPartFactory() {
      return selector.getSelected();
   }
}
