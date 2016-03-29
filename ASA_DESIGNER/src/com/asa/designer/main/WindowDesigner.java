package com.asa.designer.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

import javax.swing.JButton;

public class WindowDesigner {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowDesigner window = new WindowDesigner();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowDesigner() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnClass = new JButton("Class");
		toolBar.add(btnClass);
		
		mxGraph graph = new mxGraph();
	    Object parent = graph.getDefaultParent();
	 
	    graph.getModel().beginUpdate();
	    try {
	      Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80, 30);
	      Object v2 = graph.insertVertex(parent, null, "World!", 240, 150, 80, 30);
	      Object v3 = graph.insertVertex(parent, null, "SHAPE_SWIMLANE", 150, 160, 200, 80,
	              mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_SWIMLANE);
	      graph.insertEdge(parent, null, "Edge", v1, v2 );
	    } finally {
	      graph.getModel().endUpdate();
	    }
	 
	    mxGraphComponent graphComponent = new mxGraphComponent(graph);
	    frame.getContentPane().add(graphComponent);
	}

}
