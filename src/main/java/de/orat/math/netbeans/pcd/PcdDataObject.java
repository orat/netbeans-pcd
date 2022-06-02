/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/NetBeansModuleDevelopment-files/templateDataObjectAnno.java to edit this template
 */
package de.orat.math.netbeans.pcd;

import java.io.IOException;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.text.MultiViewEditorElement;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataNode;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.nodes.FilterNode.Children;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.util.lookup.ProxyLookup;
import org.openide.windows.TopComponent;

@Messages({
    "LBL_Pcd_LOADER=Files of Pcd"
})
@MIMEResolver.ExtensionRegistration(
        displayName = "#LBL_Pcd_LOADER",
        mimeType = "text/x-pcd",
        extension = {"pcd"}
)
@DataObject.Registration(
        mimeType = "text/x-pcd",
        iconBase = "de/orat/math/netbeans/pcd/pcd16.png",
        displayName = "#LBL_Pcd_LOADER",
        position = 300
)
@ActionReferences({
    @ActionReference(
            path = "Loaders/text/x-pcd/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.OpenAction"),
            position = 100,
            separatorAfter = 200
    ),
    @ActionReference(
            path = "Loaders/text/x-pcd/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
            position = 300
    ),
    @ActionReference(
            path = "Loaders/text/x-pcd/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"),
            position = 400,
            separatorAfter = 500
    ),
    @ActionReference(
            path = "Loaders/text/x-pcd/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
            position = 600
    ),
    @ActionReference(
            path = "Loaders/text/x-pcd/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.RenameAction"),
            position = 700,
            separatorAfter = 800
    ),
    @ActionReference(
            path = "Loaders/text/x-pcd/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.SaveAsTemplateAction"),
            position = 900,
            separatorAfter = 1000
    ),
    @ActionReference(
            path = "Loaders/text/x-pcd/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.FileSystemAction"),
            position = 1100,
            separatorAfter = 1200
    ),
    @ActionReference(
            path = "Loaders/text/x-pcd/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.ToolsAction"),
            position = 1300
    ),
    @ActionReference(
            path = "Loaders/text/x-pcd/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"),
            position = 1400
    )
})
public class PcdDataObject extends MultiDataObject {

    private final InstanceContent content = new InstanceContent();
    private final Lookup lookup;
    
    public PcdDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        lookup = new ProxyLookup(getCookieSet().getLookup(), new AbstractLookup(content));
        registerEditor("text/x-pcd", true);
        content.add(new PcdDataReader(pf));
    }

    @Override
    public Lookup getLookup(){
        return lookup;
    }
    
    @Override
    protected int associateLookup() {
        return 1;
    }

    @MultiViewElement.Registration(
            displayName = "#LBL_Pcd_EDITOR",
            iconBase = "de/orat/math/netbeans/pcd/pcd16.png",
            mimeType = "text/x-pcd",
            persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
            preferredID = "Pcd",
            position = 1000
    )
    @Messages("LBL_Pcd_EDITOR=Source")
    public static MultiViewEditorElement createEditor(Lookup lkp) {
        return new MultiViewEditorElement(lkp);
    }

    @Override
    protected Node createNodeDelegate() {
        return new PcdDataNode(this, Children.LEAF, getLookup());
    }
}