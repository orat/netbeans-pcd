/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.orat.math.netbeans.pcd;

import org.openide.loaders.DataNode;
import org.openide.loaders.DataObject;
import org.openide.nodes.Children;
import org.openide.util.Lookup;

/**
 *
 * @author Oliver Rettig (Oliver.Rettig@orat.de)
 */
class PcdDataNode extends DataNode {
    
    //TODO
    // add property sheet 
    // https://netbeans.apache.org/tutorials/nbm-filetype.html
    
    public PcdDataNode(DataObject obj, Children ch, Lookup lookup){
        super(obj, ch, lookup);
    }
}
