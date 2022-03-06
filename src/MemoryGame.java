
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MemoryGame extends JFrame implements  ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	Container monConteneur;
	JPanel topPanel , middlePanel , rightPanel , win , a, b; 
	JLabel head , scoore , time, essai  , menu, mouve, temps ;
	JButton card1, card2, card3, card4, card5, card6, card7, card8 , card9, card10, card11, card12, card13, card14, card15, card16 , pause, replay, exit , re , ex , re2 ,ex2;
	JButton AllCards[] = new JButton[16]; 
	JDialog dialogue , dialogue2;

	Timer timer , timer1;

	int solutionArray[]  = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8 };
	int cardNumbers[] = new int[16];
	
	 
	int visite1 = 0 , visite2 = 0 , essaie = 0 , click = 0 , score = 0 , second = 0 , minute = 0 ;

	DecimalFormat dFormat = new DecimalFormat("00");
	String ddSecond , ddMinute;
	
	
	int clicImage[] = new int[16];
	
	 	    public MemoryGame()
				{
					
					this.setTitle("Memory Game");
					this.setSize(920,880);
					this.setIconImage(Toolkit.getDefaultToolkit().getImage("img/icon.png"));
					this.setLocationRelativeTo(null);
					this.setResizable(false);
					
					dialogue = new JDialog(this,"You Win !",true);
					dialogue2 = new JDialog(this,"Game Over !",true);


						
					 initialisationFrame();
					 initialGame();
					 gameTimer();
					 timer.start();
					 
					 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 this.setVisible(true);
				
				}
	
	 	     	    
	 	    
	 	    
			private void initialisationFrame() {
			 monConteneur  = this.getContentPane();
			 	
			 		topPanel = new JPanel();
			 		topPanel.setBackground(Color.decode("#ffffff"));
			 		
			 		
			 		middlePanel = new JPanel();
					middlePanel.setBackground(Color.decode("#ffffff"));
					middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
					middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,16));
					
					
					
					rightPanel = new JPanel();
					rightPanel.setBackground(Color.decode("#ffffff"));
					rightPanel.setPreferredSize(new Dimension(240, 100));
					rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,16));

								
					
								head = new JLabel(new ImageIcon("img/head.png"));  
								
								topPanel.add(head);
									
								
									 card1 = new JButton();
									 card1.setPreferredSize(new Dimension(134, 134));
									 middlePanel.add(card1);
									 
									 card2 = new JButton();
									 card2.setPreferredSize(new Dimension(134, 134));
									 middlePanel.add(card2);
									 
									 card3 = new JButton();
									 card3.setPreferredSize(new Dimension(134, 134));
									 middlePanel.add(card3);
								 
									
									  card4= new JButton();
									  card4.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card4);	  
									  
									  
									  
									  card5 = new JButton(); 
									  card5.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card5);
									  
									  card6 = new JButton(); 
									  card6.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card6);
									  
									  card7 = new JButton(); 
									  card7.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card7);
									  
									  card8 = new JButton();
									  card8.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card8);
									  
									  card9 = new JButton(); 
									  card9.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card9);
									  
									  card10 = new JButton();
									  card10.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card10);
									  
									  card11 = new JButton();
									  card11.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card11);
									  
									  card12= new JButton(); 
									  card12.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card12);
									  
									  
									  
									  card13 = new JButton(); 
									  card13.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card13);
									  
									  card14 = new JButton();
									  card14.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card14);
									  
									  card15 = new JButton();
									  card15.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card15);
									  
									  card16 = new JButton(); 
									  card16.setPreferredSize(new Dimension(134, 134));
									  middlePanel.add(card16);
									 
								 
								 scoore = new JLabel("",new ImageIcon("img/scoore.png"),JLabel.CENTER);
								 scoore.setFont(new Font("Hokjesgeest",Font.BOLD,20));
								 scoore.setText("000 ");
								 rightPanel.add(scoore);
								 
								 time = new JLabel("",new ImageIcon("img/time.png"),JLabel.CENTER);
								 time.setFont(new Font("Hokjesgeest",Font.BOLD,20));
								 time.setText("00 : 00");
								 rightPanel.add(time);
								 
								 essai = new JLabel("",new ImageIcon("img/essaie.png"),JLabel.CENTER);
								 essai.setFont(new Font("Hokjesgeest",Font.BOLD,20));
								 essai.setText("0");
								 rightPanel.add(essai);

								 
								 menu = new JLabel(new ImageIcon("img/menu.png"));
								 menu.setPreferredSize(new Dimension(200, 150));
								 rightPanel.add(menu);
								 
								 
								 pause = new JButton(new ImageIcon("img/pause.png"));
								 pause.setPreferredSize(new Dimension(200, 43));
								 pause.setBorderPainted(false);
								 rightPanel.add(pause);	
								 
								 replay = new JButton(new ImageIcon("img/replay.png"));
								 replay.setPreferredSize(new Dimension(200, 43));
								 replay.setBorderPainted(false);
								 replay.addActionListener(this);
								 rightPanel.add(replay);		

								 exit = new JButton(new ImageIcon("img/exit.png"));
								 exit.setPreferredSize(new Dimension(200, 43));
								 exit.setBorderPainted(false);
								 exit.addActionListener(this);
								 rightPanel.add(exit);				
								 
								 
								 

									
									 JLabel win =  new JLabel(new ImageIcon("img/win.png"));
									 win.setPreferredSize(new Dimension(650, 300));
									 
									 JLabel gameO =  new JLabel(new ImageIcon("img/gameover.png"));
									 win.setPreferredSize(new Dimension(650, 300));
					
									 
									 re = new JButton(new ImageIcon("img/replay.png"));
									 re.setPreferredSize(new Dimension(200, 43));
									 re.setBorderPainted(false);
									 re.addActionListener(this);
									 
									 ex = new JButton(new ImageIcon("img/exit.png"));
									 ex.setPreferredSize(new Dimension(200, 43));
									 ex.setBorderPainted(false);
									 ex.addActionListener(this);
									 
									 re2 = new JButton(new ImageIcon("img/replay.png"));
									 re2.setPreferredSize(new Dimension(200, 43));
									 re2.setBorderPainted(false);
									 re2.addActionListener(this);
									 
									 ex2 = new JButton(new ImageIcon("img/exit.png"));
									 ex2.setPreferredSize(new Dimension(200, 43));
									 ex2.setBorderPainted(false);
									 ex2.addActionListener(this);
									 
									  mouve = new JLabel();
									 mouve.setFont(new Font("Arial",Font.BOLD,20));
									 
									 temps = new JLabel();
									 temps.setFont(new Font("Arial",Font.BOLD,20));

									 	 a = new JPanel();
										a.setBackground(Color.decode("#ffffff"));
										a.setPreferredSize(new Dimension(640, 535));
										a.setLayout(new FlowLayout(FlowLayout.CENTER,50,16));	
										
										b = new JPanel();
										b.setBackground(Color.decode("#ffffff"));
										b.setPreferredSize(new Dimension(640, 535));
										b.setLayout(new FlowLayout(FlowLayout.CENTER,50,16));	
										
										b.add(gameO);
										b.add(ex2);
										b.add(re2);
										
										
										a.add(win);
										a.add(mouve);
										a.add(temps);
										a.add(ex);
										a.add(re);
										
										dialogue.add(a);
										dialogue2.add(b);


								dialogue.setLocationRelativeTo(null);
								dialogue.setResizable(false);
								
								dialogue2.setLocationRelativeTo(null);
								dialogue2.setResizable(false);
						
								 monConteneur.add(topPanel,BorderLayout.NORTH);
								 monConteneur.add(middlePanel,BorderLayout.CENTER);
								 monConteneur.add(rightPanel,BorderLayout.EAST);
								 
								 	
		
		
	}

			private void initcard()
		 {
			
				 AllCards[0] = card1; 			 AllCards[5] = card6;    
				 AllCards[1] = card2; 			 AllCards[6] = card7;  		AllCards[11] = card12;
				 AllCards[2] = card3;   		 AllCards[7] = card8;  		AllCards[12] = card13;
				 AllCards[3] = card4; 			 AllCards[8] = card9;  		AllCards[13] = card14;
				 AllCards[4] = card5; 			 AllCards[9] = card10;  	AllCards[14] = card15;
				 AllCards[5] = card6;			 AllCards[10] = card11;		AllCards[15] = card16;
				 
				 	for(int i = 0 ; i < AllCards.length ; i++)
				 	{	   
				 		AllCards[i].setIcon( new ImageIcon("img/back_face.jpg"));	  
				 		AllCards[i].addActionListener(this);
				 	}
			 
		 }
		
			public void gameTimer()
		{
			timer = new Timer(1000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					second++;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);

					 time.setText(ddMinute+" : "+ddSecond);
					 if(score == 80 && minute < 2) {
						 
							
						 mouve.setText("You Made : "+essaie+" Moves");
						 temps.setText("in "+ddMinute+" minute"+" and "+ddSecond+" second");
						 dialogue.pack();
						 dialogue.setVisible(true);
						
					 }
					 
					 if(essaie > 30  ||  minute > 1) {
						 
	
						 dialogue2.pack();
						 dialogue2.setVisible(true);

						
					 }
					 if(second == 60)
					 { 
						minute++; 
						second = 0 ;
						time.setText(ddMinute+" : "+ddSecond);
					 }
					 
					
					 
				}
				
			});
		}
			
			public void initialGame()
			 {
				 initcard();
				 resetTimer();
				 remplirParZero(cardNumbers);
				 remplirParZero(clicImage);
				 shuffleArray(solutionArray);
				 
				 for(int i = 0 ; i < cardNumbers.length ; i++ )
				 { 
					 
					 cardNumbers[i] = solutionArray[i];
					 AllCards[i].setBorderPainted(true);

					 
					 
					 
				 }
			
			 }
			
			
			public void resetTimer()
			{
				timer1 = new Timer(500, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						click = 0 ;
						paireValide(visite1,visite2);
						
						
						
					}			
			 	});
			}
			
			
			 static void shuffleArray(int[] ar)
			  {
			    Random rnd = ThreadLocalRandom.current();
			    for (int i = ar.length - 1; i > 0; i--)
			    {
			      int index = rnd.nextInt(i + 1);
			      int a = ar[index];
			      ar[index] = ar[i];
			      ar[i] = a;
			    }
			  }
			
			public void remplirParZero(int[] T) {
					 	for(int i = 0 ; i < T.length ; i++ )
					 		T[i] = 0 ;
				}
					
			private void paireValide(int visite1, int visite2){
				
				if( cardNumbers[visite1] == cardNumbers[visite2] ) {
					
					
					AllCards[visite1].removeActionListener(this);
					AllCards[visite1].setBorderPainted(false);

					AllCards[visite2].removeActionListener(this);
					AllCards[visite2].setBorderPainted(false);

					score += 10 ;
					Audio.PlaySound("/son/scoore.wav");
					scoore.setText(""+score);
					

				}
				else {
					AllCards[visite1].setIcon(new ImageIcon("img/back_face.jpg")); 
					AllCards[visite2].setIcon(new ImageIcon("img/back_face.jpg"));
					clicImage[visite1] = 0;
					clicImage[visite2] = 0;
					
				
				
				}
				
				essaie++;
				essai.setText(""+essaie);
				for ( int j = 0 ; j < AllCards.length ; j++ )  AllCards[j].addActionListener(this);
				timer1.stop();				
			}
		
		
		   



			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()== replay || e.getSource()== re ||  e.getSource()== re2) {
					
					

					dialogue.setVisible(false);
					dialogue2.setVisible(false);
					initialGame();
					second = 0 ;
					minute = 0;
					score = 0 ;
					click = 0 ;
					visite1 = 0 ;
					visite2 = 0 ;
					essaie = 0;
					scoore.setText("000");
					essai.setText(""+"000");
					
				}
				
				 if(e.getSource()== exit || e.getSource()== ex ||  e.getSource()== ex2 ) {
				System.exit(0);
				}
					
					for(int i = 0 ; i < AllCards.length ; i++)
					{
						if(e.getSource()==AllCards[i] )
						{

									clicImage[i]++;
							
										if ( clicImage[i] < 2) {
											Audio.PlaySound("/son/flip.wav");

																click++;
																AllCards[i].setIcon(new ImageIcon("img/"+cardNumbers[i]+".jpg"));
																if(click == 1) visite1 = i ;				
																else   visite2 = i; 
													
															 }
										
										if(click == 2) {
											Audio.PlaySound("/son/flip.wav");

											for ( int j = 0 ; j < AllCards.length ; j++ )  AllCards[j].removeActionListener(this);
											timer1.start();

										
														}		 	
						}					
					 }
	
				 		
			 		}
			
			}