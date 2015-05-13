/*******************************************************************************
 * Copyright (c) 2010 Oak Ridge National Laboratory.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package org.eclipse.nebula.visualization.xygraph.figures;

import org.eclipse.nebula.visualization.xygraph.linearscale.Range;

/**
 * A listener on the axis when axis was revalidated.
 * @author Xihui Chen
 *
 */
public interface IAxisListener {
    
    /**
     * This event indicates a change in the axis' value range
     */
    public void axisRangeChanged(Axis axis, Range old_range, Range new_range);
    
    /**
     * This method will be notified by axis whenever the axis is revalidated.
     */
    public void axisRevalidated(Axis axis);    
        
}
