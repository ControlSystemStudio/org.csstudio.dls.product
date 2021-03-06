package org.csstudio.opibuilder.widgets.edm.model;

import org.csstudio.opibuilder.model.AbstractPVWidgetModel;
import org.csstudio.opibuilder.properties.DoubleProperty;
import org.csstudio.opibuilder.properties.FilePathProperty;
import org.csstudio.opibuilder.properties.IntegerProperty;
import org.csstudio.opibuilder.properties.WidgetPropertyCategory;
import org.csstudio.opibuilder.util.ResourceUtil;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.graphics.RGB;

public class EdmSymbolModel extends AbstractPVWidgetModel {

    public static final String PROP_EDM_IMAGE_FILE = "image_file";
    public static final String PROP_SUB_IMAGE_WIDTH = "sub_image_width";
    public static final String PROP_IMAGE_INDEX = "image_index";

    private static final String[] FILE_EXTENSIONS = new String[] {"jpg", "jpeg", "gif", "bmp", "png"};

    public EdmSymbolModel() {
        setForegroundColor(new RGB(255, 0, 0));
        setBackgroundColor(new RGB(0,0,255));
        setSize(50, 50);
    }

    @Override
    protected void configureProperties() {
        addProperty(new FilePathProperty(PROP_EDM_IMAGE_FILE, "Image File", WidgetPropertyCategory.Basic, new Path(""), FILE_EXTENSIONS));
        addProperty(new DoubleProperty(PROP_SUB_IMAGE_WIDTH, "Sub Image Width", WidgetPropertyCategory.Basic, 10));
        addProperty(new IntegerProperty(PROP_IMAGE_INDEX, "Image Index", WidgetPropertyCategory.Basic, 0));
    }

    @Override
    public String getTypeID() {
        return "org.csstudio.opibuilder.widgets.edm.symbolwidget"; // Must match extension point typeId
    }

    public IPath getFilename() {
        IPath absolutePath = (IPath) getProperty(PROP_EDM_IMAGE_FILE).getPropertyValue();
        if(!absolutePath.isAbsolute()) {
            absolutePath = ResourceUtil.buildAbsolutePath(this, absolutePath);
        }
        return absolutePath;
    }

    public int getSubImageWidth() {
        Double width = (Double) getProperty(PROP_SUB_IMAGE_WIDTH).getPropertyValue();
        return width.intValue();
    }

    public void setSubImageWidth(int width) {
        setPropertyValue(PROP_SUB_IMAGE_WIDTH, width);
    }

    public int getImageIndex() {
        return (Integer) getProperty(PROP_IMAGE_INDEX).getPropertyValue();
    }

}
