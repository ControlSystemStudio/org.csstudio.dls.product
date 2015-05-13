/*******************************************************************************
 * Copyright (c) 2010 Oak Ridge National Laboratory.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package org.eclipse.nebula.visualization.xygraph;

import java.io.File;
import java.util.logging.Logger;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 *
 * @author Xihui Chen
 *
 */
public class Activator extends AbstractUIPlugin {

    /** The plug-in ID defined in MANIFEST.MF */
    public static final String PLUGIN_ID = "org.eclipse.nebula.visualization.xygraph"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    final private static Logger logger = Logger.getLogger(PLUGIN_ID);

    
    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }
    
    public static Logger getLogger() {
        return logger;
    }
    
    public static ImageDescriptor getImageDescriptor(String imageFilePath) {
        if (plugin!=null) {
            return imageDescriptorFromPlugin(PLUGIN_ID, imageFilePath);
        } else {
            final File  iconPath = new File(imageFilePath);
            final Image image    = new Image(null, iconPath.getAbsolutePath());
            return ImageDescriptor.createFromImage(image);
        }
    }

}
