package com.Branko.Stopwatch;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Listeners implements ActionListener {
						
						private JButton start;
						private JButton pause;
						private JButton reset;
						private JTextArea area;
						private int hours;
						private int minutes;
						private int seconds;
						Thread pocetak;
						
						public Listeners(JButton start,JButton pause,JButton reset,JTextArea area) {
							
							this.area=area;
							this.start=start;
							this.pause=pause;
							this.reset=reset;
							this.hours=0;
							this.seconds=0;
							this.minutes=0;
							
							
						}
	
						public void actionPerformed(ActionEvent ae) {
												
										
										if(ae.getSource()==start) {
										
											    if(pocetak!=null && pocetak.isAlive()) {
											    	
											    }else {
												start();
											    }

										}else if(ae.getSource()==reset) {
											
											reset();
											ispisi();
											
											
										}
										else if(ae.getSource()==pause) {
											
												
											pocetak.stop();
												
											
											
										}
							
						}
						
						
						public void start() {
							
							pocetak = new Thread(new Runnable() {					
								
								public void run() {
		
								while(true) {
									
									if(seconds>59) {
										
										seconds=0;
									}
									area.setText(ispisi());
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									seconds++;
									
									
									if(seconds>59) {
										
										minutes++;
									}
									if(minutes>59) {
										
										minutes=0;
										hours++;
									}
									
								}	

							}	
						});
							pocetak.start();
						}	
						
						public void reset() {
							
									seconds=0;
									minutes=0;
									hours=0;
									
									area.setText(ispisi());
									
						}		


						
						public String ispisi() {
							
							return String.format("%02d:%02d:%02d", hours,minutes,seconds);
							
						}
	
}
