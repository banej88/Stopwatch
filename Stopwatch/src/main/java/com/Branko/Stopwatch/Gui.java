package com.Branko.Stopwatch;

import javax.swing.*;
import java.awt.*;

public class Gui implements Runnable {

				
					private JFrame frame;
					private JTextArea area;
					private JButton start;
					private JButton stop;
					private JButton pause;
					private JButton reset;
					
					
					public void run() {
						
						frame = new JFrame("Stopwatch");
						
						frame.setPreferredSize(new Dimension(640,320));
						frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
						
						createComponent(frame.getContentPane());
						
						frame.pack();
						
						frame.setVisible(true);
						
						frame.setResizable(false);
						
						
						
						
					}
					
					public void createComponent(Container container) {
							
							area = new JTextArea("00:00:00");
							area.setEditable(false);
							area.setFont(new Font("Courier",Font.BOLD,158));
											
							DrawingBoard b = new DrawingBoard();
							container.add(area);
							container.add(buttons(),BorderLayout.SOUTH);
							
							Listeners a = new Listeners(start,pause,reset,area);
							start.addActionListener(a);
							reset.addActionListener(a);
							pause.addActionListener(a);
							
			
						
					}
					
					public JPanel buttons() {
						
							JPanel panel = new JPanel(new GridLayout(1,4));
							
							start = new JButton("Start");
							start.setFont(new Font("Courier",Font.BOLD,30));
							pause = new JButton("Pause");
							pause.setFont(new Font("Courier",Font.BOLD,30));
							reset = new JButton("Reset");
							reset.setFont(new Font("Courier",Font.BOLD,30));
							
							panel.add(start);
							panel.add(pause);
							panel.add(reset);
							
							return panel;
						
					}
						
}
