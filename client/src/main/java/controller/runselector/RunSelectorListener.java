/*
 * EuroRisk Systems (c) Ltd. All rights reserved.
 */
package controller.runselector;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.DebugContext;
import tree.JTreeUtils;
import view.DebugTreePanel;

/**
 *
 * @author sdaskalov
 */
public class RunSelectorListener implements ListSelectionListener {

    private final DebugContext context;
    private final DebugTreePanel panel;

    public RunSelectorListener(DebugContext context) {
        this.context = context;
        this.panel = null;
    }

    public RunSelectorListener(DebugContext context, DebugTreePanel panel) {
        this.context = context;
        this.panel = panel;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        context.setCurrentRun(e.getFirstIndex() + 1);
        context.resetDebugging();
        if (panel != null) {
            panel.repaint();
            JTreeUtils.expandAllNodes(panel.getTree());
        }
    }

}
