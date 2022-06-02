/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.orat.math.netbeans.pcd;

import java.awt.Image;
import java.io.Serializable;
import org.netbeans.core.spi.multiview.MultiViewDescription;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.openide.util.HelpCtx;
import org.openide.util.ImageUtilities;
import org.openide.windows.TopComponent;

/**
 *
 * @author Oliver Rettig (Oliver.Rettig@orat.de)
 */
public class Jzy3dMultiviewDescription implements MultiViewDescription, Serializable{

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public String getDisplayName() {
         return "Tab 1";
    }

    @Override
    public Image getIcon() {
        return ImageUtilities.loadImage("/de/orat/math/netbeans/pcd/pcd.png");
    }

    @Override
    public HelpCtx getHelpCtx() {
        return null;
    }

    @Override
    public String preferredID() {
        return "Jzy3dMultiviewDescription";
    }

    @Override
    public MultiViewElement createElement() {
        return null; //return new PcdVisualElement();
    }
}
