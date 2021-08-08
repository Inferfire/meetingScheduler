package robohaxSubmission;

/*//////////////////////////////////////////////////////////*/
/*/                   Meeting Scheduler                    /*/
/*//////////////////////////////////////////////////////////*/
/*| Brought to you by the Super Turtle Hackers :)          |*/
/*|                                                        |*/
/*//////////////////////////////////////////////////////////*/

//Importing libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

//////////////////////////////////////////////////////////
//                 Class Name Goes Here                 //
//////////////////////////////////////////////////////////

public class Demo extends JFrame implements ActionListener {
  
  private static final long serialVersionUID = 1L;
  /////////////////////////////////////////////////////////
  //             Instance Variables (Global)             //
  /////////////////////////////////////////////////////////
  
  //Non-specific widgets/variables; don't really belong anywhere in particular
  CardLayout cardLayout = new CardLayout ();
  
  JButton button1, button2, button3, button4, button5, button6, button7;
  JButton confirm1, clearSel;
  
  JLabel title2, title3, title4,
    bg1, bg2, bg3, bg4;
  
  JLabel finalMT, finalMD, finalMA;
  JButton accept, decline;
  
  JPanel card1 = new JPanel();
  JPanel card2 = new JPanel();
  JPanel card3 = new JPanel();
  JPanel card4 = new JPanel();
  
  //Creates the big panel that contains all of the screens/"cards".
  JPanel cards = new JPanel(new CardLayout());
  
  //Textfields
  JTextField inputName, inputEmail, inputHours;
  
  public int nameDataLength = 0;
  
  public int timingArrayGenerator = 0;
  
  public int personDeterminant = 0;
  
  public int helperVar = 0;
  
  public int maxPpl, recomTime;
  
  public int recoFDate, recoFTime;
  public String recoAMvsPM;
  
  public int timingArray1[], timingArray2[], 
    timingArray3[], timingArray4[], 
    timingArray5[], timingArray6[], 
    timingArray7[], timingArray8[];
  
  public int[] tempArray1 = new int[168];
  public int[] tempArray2 = new int[168];
  public int[] tempArray3 = new int[168];
  public int[] tempArray4 = new int[168];
  public int[] tempArray5 = new int[168];
  public int[] tempArray6 = new int[168];
  public int[] tempArray7 = new int[168];
  public int[] tempArray8 = new int[168];
  
  public String[] nameData = new String[] {
    "i_Hope_This_Isn't_Their_Name_0147!",
      "i_Hope_This_Isn't_Their_Name_0147!",
      "i_Hope_This_Isn't_Their_Name_0147!",
      "i_Hope_This_Isn't_Their_Name_0147!",
      "i_Hope_This_Isn't_Their_Name_0147!",
      "i_Hope_This_Isn't_Their_Name_0147!",
      "i_Hope_This_Isn't_Their_Name_0147!",
      "i_Hope_This_Isn't_Their_Name_0147!" };
  
  public String[] emailData = new String[] {
    "i_Hope_This_Isn't_Their_Email_0147!",
      "i_Hope_This_Isn't_Their_Email_0147!",
      "i_Hope_This_Isn't_Their_Email_0147!",
      "i_Hope_This_Isn't_Their_Email_0147!",
      "i_Hope_This_Isn't_Their_Email_0147!",
      "i_Hope_This_Isn't_Their_Email_0147!",
      "i_Hope_This_Isn't_Their_Email_0147!",
      "i_Hope_This_Isn't_Their_Email_0147!", };
  
  //public String[] hoursData = new String[] { <== will incorporate later };
  
  public int days = 7;
  
  public int hours = 24;
  
  //grid of buttons
  JButton gridBtns[][] = new JButton [hours][days];
  
  //grid of labels (single dimension array is to be rearranged to mimic button grid)
  JLabel visualizerPseudoGrid[] = new JLabel [168];
  
  
  /////////////////////////////////////////////////////////
  //                     Constructor                     //
  /////////////////////////////////////////////////////////
  public Demo() {
    
    /////////////////////////////////////////////////////////
    //     1. Creates/Initializes Components               //
    /////////////////////////////////////////////////////////
    
    //Layout must be set as null to set bounds for other components
    card1.setLayout(null);
    card2.setLayout(null);
    card3.setLayout(null);
    card4.setLayout(null);
    
    //Creates and styles buttons
    button1 = new JButton("Book Availability");
    button1.setBounds(126, 179, 261, 68);
    
    //Turns the button invisible
    //button1.setBorderPainted(false);
    //button1.setContentAreaFilled(false);
    
    //setIcon(new ImageIcon ("fileNameGoesHere.png"));
    
    button2 = new JButton("Visualize Schedule");
    //Coordinates and length and width size of the button
    button2.setBounds(126, 294, 261, 68);
    //button2.setBorderPainted(false);
    //button2.setContentAreaFilled(false);
    button3 = new JButton("Finalize Meeting");
    button3.setBounds(126, 409, 261, 68);
    //button3.setBorderPainted(false);
    //button3.setContentAreaFilled(false);
    button4 = new JButton("Return to Main Menu");
    button4.setBounds(604, 218, 328, 45);
    
    //confirm + clear buttons
    confirm1 = new JButton("Confirm Selection");
    confirm1.setBounds(838, 400, 168, 98);
    clearSel = new JButton("Clear Selection");
    clearSel.setBounds(838, 300, 168, 98);
    
    //makes the buttons nice and functional
    for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
      int y = columnNumber * 28;
      for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
        int x = rowNumber * 28;
        gridBtns[rowNumber][columnNumber] = new JButton("x");
        gridBtns[rowNumber][columnNumber].setName("x");
        gridBtns[rowNumber][columnNumber].setBounds((145 + x), (298 + y), 28, 28);
        gridBtns[rowNumber][columnNumber].setBorderPainted(false);
        gridBtns[rowNumber][columnNumber].setContentAreaFilled(false);
        gridBtns[rowNumber][columnNumber].setIcon(new ImageIcon("imgResources/greysquare.png"));
        card2.add(gridBtns[rowNumber][columnNumber]);
        gridBtns[rowNumber][columnNumber].setActionCommand ("" + (rowNumber * 10 + columnNumber));
        gridBtns[rowNumber][columnNumber].addActionListener (this);
      }
    }
    
    //sets temp arrays to 0
    for (int i = 0; i < 168; i++) {
      tempArray1[i] = 0;
      tempArray2[i] = 0;
      tempArray3[i] = 0;
      tempArray4[i] = 0;
      tempArray5[i] = 0;
      tempArray6[i] = 0;
      tempArray7[i] = 0;
      tempArray8[i] = 0;
    }
    
    //makes the labels nice and functional
    for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
      int y = columnNumber * 37 + 1;
      for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
        int x = rowNumber * 38;
        visualizerPseudoGrid[helperVar] = new JLabel("");
        visualizerPseudoGrid[helperVar].setName("0");
        visualizerPseudoGrid[helperVar].setBounds((90 + x), (139 + y), 37, 37);
        visualizerPseudoGrid[helperVar].setIcon(new ImageIcon("greysquare2.png"));
        card3.add(visualizerPseudoGrid[helperVar]);
        helperVar++;
      }
    }
    
    helperVar = 0;
    
    //menu buttons
    button5 = new JButton("Return to Main Menu");
    button5.setBounds(790, 459, 216, 44);
    button6 = new JButton("Return to Main Menu");
    button6.setBounds(790, 459, 216, 44);
    
    //final accept + decline buttons
    accept = new JButton("");
    accept.setBounds(275, 409, 100, 100);
    accept.setBorderPainted(false);
    accept.setContentAreaFilled(false);
    accept.setIcon(new ImageIcon("greencheck.png"));
    
    decline = new JButton("");
    decline.setBounds(475, 409, 100, 100);
    decline.setBorderPainted(false);
    decline.setContentAreaFilled(false);
    decline.setIcon(new ImageIcon("gredcross.png"));
    
    //textfields
    inputName = new JTextField(10);
    inputName.setBounds(200, 124, 240, 40);
    inputEmail = new JTextField(10);
    inputEmail.setBounds(200, 170, 240, 40);
    inputHours = new JTextField(10);
    inputHours.setBounds(200, 216, 240, 44);
    
    //preventing non-numbers from being typed
    inputHours.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(java.awt.event.KeyEvent evt) {
        char randoLetter = evt.getKeyChar();
        if (!(Character.isDigit(randoLetter) ||
              (randoLetter == KeyEvent.VK_BACK_SPACE) ||
              randoLetter == KeyEvent.VK_DELETE)) {
          evt.consume();
        }
      }
    });
    
    //Creates JLabels
    //title2 = new JLabel("Availability Booking");
    //title3 = new JLabel("Schedule Visualization");
    //title4 = new JLabel("Finalize Meeting");
    
    finalMT = new JLabel(" ");
    finalMT.setBounds(726, 125, 138, 40);
    finalMT.setForeground(Color.WHITE);
    finalMT.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    finalMT.setHorizontalAlignment(SwingConstants.CENTER);
    finalMD = new JLabel(" ");
    finalMD.setBounds(726, 193, 138, 40);
    finalMD.setForeground(Color.WHITE);
    finalMD.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    finalMD.setHorizontalAlignment(SwingConstants.CENTER);
    finalMA = new JLabel(" ");
    finalMA.setBounds(726, 266, 138, 40);
    finalMA.setForeground(Color.WHITE);
    finalMA.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    finalMA.setHorizontalAlignment(SwingConstants.CENTER);
    
    //bg JLabels
    JLabel bg1 = new JLabel("");
    bg1.setIcon(new ImageIcon("1_16.1.1z.jpg"));
    bg1.setBounds(0, 0, 1024, 576);
    JLabel bg2 = new JLabel("");
    bg2.setIcon(new ImageIcon("2_16.1.2.jpg"));
    bg2.setBounds(0, 0, 1024, 576);
    JLabel bg3 = new JLabel("");
    bg3.setIcon(new ImageIcon("3_16.1.3.jpg"));
    bg3.setBounds(0, 0, 1024, 576);
    JLabel bg4 = new JLabel("");
    bg4.setIcon(new ImageIcon("4_16.1.4.jpg"));
    bg4.setBounds(0, 0, 1024, 576);
    
    /////////////////////////////////////////////////////////
    //     2. Adds ActionListeners and sets ActionCommands //
    /////////////////////////////////////////////////////////
    button1.addActionListener(this);
    button1.setActionCommand ("button1");
    button2.addActionListener(this);
    button2.setActionCommand ("button2");
    button3.addActionListener(this);
    button3.setActionCommand ("button3");
    
    confirm1.addActionListener(this);
    confirm1.setActionCommand ("confirm1");
    clearSel.addActionListener(this);
    clearSel.setActionCommand ("clear1");
    
    accept.addActionListener(this);
    accept.setActionCommand ("yes");
    decline.addActionListener(this);
    decline.setActionCommand ("no");
    
    //adds actionlisteners and sets actionCommands to return to menu
    button4.addActionListener(this);
    button4.setActionCommand ("button4");
    button5.addActionListener(this);
    button5.setActionCommand ("button4");
    button6.addActionListener(this);
    button6.setActionCommand ("button4");
    
    /////////////////////////////////////////////////////////
    //     3. Adds everything to its corresponding JPanel  //
    /////////////////////////////////////////////////////////
    
    //Menu Screen
    card1.add(button1);
    card1.add(button2);
    card1.add(button3);
    card1.add(bg1);
    
    //Scheduler Screen
    //card2.add(title2);
    card2.add(button4);
    card2.add(inputName);
    card2.add(inputEmail);
    card2.add(inputHours);
    card2.add(confirm1);
    card2.add(clearSel);
    card2.add(bg2);
    
    //Visualizer Screen
    //card3.add(title3);
    card3.add(button5);
    card3.add(bg3);
    
    //Finalizer Screen
    //card4.add(title4);
    card4.add(accept);
    card4.add(decline);
    card4.add(finalMT);
    card4.add(finalMD);
    card4.add(finalMA);
    card4.add(button6);
    card4.add(bg4);
    
    /////////////////////////////////////////////////////////
    //     4. Adds Components to the Content Panel         //
    /////////////////////////////////////////////////////////
    
    //Adds each of the cards to the big JPanel
    cards.add(card1);
    
    /////////////////////////////////////////////////////////
    //     5. Sets Window Attributes; Packs it             //
    /////////////////////////////////////////////////////////
    
    //Set the size of the JFrame
    //PERSONAL side note, figure out size of tabheader thing to add to the y-value
    setSize(1024, 596);
    
    //Put Title on top of JFrame
    setTitle("Super Turtle Hackers' Meeting Scheduler");
    setResizable(false);
    
    //Adds each of the cards to the big JPanel
    cards.add(card1);
    cards.add(card2);
    cards.add(card3);
    
    //Adds the big JPanel to the JFrame which contains each card
    getContentPane().add(cards);
    
    //Make JFrame visible
    setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    
    //This is applicable to each button
    if (e.getActionCommand ().equals ("button1")) {
      //Deletes all cards
      cards.removeAll();
      
      //Essentially refreshes the GUI
      cards.revalidate();
      cards.repaint();
      
      //Goes to the desired panel
      cards.add(card2);
      
      //JFrameClassName.main(new String[0]);
      //opens a new Jframe that's already been created
      
      //Going to the visualizer
    } else if (e.getActionCommand ().equals ("button2")) {
      cards.removeAll();
      cards.revalidate();
      cards.repaint();
      cards.add(card3);
      
      //Going to the finalizer
    } else if (e.getActionCommand ().equals ("button3")) {
      cards.removeAll();
      cards.revalidate();
      cards.repaint();
      cards.add(card4);
      
      //Going back to the menu screen
    } else if (e.getActionCommand ().equals ("button4")) {
      cards.removeAll();
      cards.revalidate();
      cards.repaint();
      cards.add(card1);
      
    } else if (e.getActionCommand ().equals ("clear1")) {
      
      //resets grid
      for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
        for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
          gridBtns[rowNumber][columnNumber].setName("x");
          gridBtns[rowNumber][columnNumber].setIcon(new ImageIcon("greysquare.png"));
        }
      }
      
      //resets field
      inputName.setText("");
      inputEmail.setText("");
      inputHours.setText("");
      
    } else if (e.getActionCommand ().equals ("confirm1")) {
      if (nameDataLength > 8) {
        JOptionPane.showMessageDialog(null, "ERROR 2M4NYPPL: Meeting capacity exceeded. \nPlease return to menu and finalize your meeting time.", "ALERT: " + "2M4NYPPL", JOptionPane.ERROR_MESSAGE);
      } else {
        nameDataLength++;
        personDeterminant++;
        nameData[nameDataLength - 1] = inputName.getText();
        emailData[nameDataLength - 1] = inputEmail.getText();
        
        int counterNum = -1;
      if (personDeterminant == 0) {
          for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
            for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
              counterNum++;
              if (gridBtns[rowNumber][columnNumber].getName().equals("o")) {
                tempArray1[counterNum] = 1; 
              } else {
                tempArray1[counterNum] = 0;
              }
            }
          }
        }
      
      if (personDeterminant == 1) {
          for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
            for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
              counterNum++;
              if (gridBtns[rowNumber][columnNumber].getName().equals("o")) {
                tempArray2[counterNum] = 1; 
              } else {
                tempArray2[counterNum] = 0;
              }
            }
          }
        }
      if (personDeterminant == 2) {
          for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
            for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
              counterNum++;
              if (gridBtns[rowNumber][columnNumber].getName().equals("o")) {
                tempArray3[counterNum] = 1; 
              } else {
                tempArray3[counterNum] = 0;
              }
            }
          }
        }
      if (personDeterminant == 3) {
          for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
            for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
              counterNum++;
              if (gridBtns[rowNumber][columnNumber].getName().equals("o")) {
                tempArray4[counterNum] = 1; 
              } else {
                tempArray4[counterNum] = 0;
              }
            }
          }
        }
      if (personDeterminant == 4) {
          for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
            for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
              counterNum++;
              if (gridBtns[rowNumber][columnNumber].getName().equals("o")) {
                tempArray5[counterNum] = 1; 
              } else {
                tempArray5[counterNum] = 0;
              }
            }
          }
        }
      if (personDeterminant == 5) {
          for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
            for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
              counterNum++;
              if (gridBtns[rowNumber][columnNumber].getName().equals("o")) {
                tempArray6[counterNum] = 1; 
              } else {
                tempArray6[counterNum] = 0;
              }
            }
          }
        }
      if (personDeterminant == 6) {
          for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
            for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
              counterNum++;
              if (gridBtns[rowNumber][columnNumber].getName().equals("o")) {
                tempArray7[counterNum] = 1; 
              } else {
                tempArray7[counterNum] = 0;
              }
            }
          }
        }
      if (personDeterminant == 7) {
          for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
            for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
              counterNum++;
              if (gridBtns[rowNumber][columnNumber].getName().equals("o")) {
                tempArray8[counterNum] = 1; 
              } else {
                tempArray8[counterNum] = 0;
              }
            }
          }
        }
        counterNum = 0;
        
        //to test if the array is correctly assigned
        /*int tester = 0;
         for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
         for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
         System.out.println(tempArray1[tester]);
         tester++;
         }
         }
          tester = 0;*/
          
      }
      
      for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
        
        for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
          
          visualizerPseudoGrid[helperVar].setName("" + (tempArray1[helperVar] + 
            tempArray2[helperVar] + 
            tempArray3[helperVar] + 
            tempArray4[helperVar] + 
            tempArray5[helperVar] + 
            tempArray6[helperVar] + 
            tempArray7[helperVar] + 
            tempArray8[helperVar]));
          
          //variable to check percentage of attendance
          double tempDoubleHelper = Double.valueOf(Integer.parseInt(visualizerPseudoGrid[helperVar].getName()))/personDeterminant;

          if (tempDoubleHelper == 1) {
            visualizerPseudoGrid[helperVar].setIcon(new ImageIcon("greensquare2.png"));
            /*System.out.println(Integer.parseInt(visualizerPseudoGrid[helperVar].getName()));
            System.out.println("huh" + personDeterminant);
            System.out.println(tempDoubleHelper);
            System.out.println(tempArray1[helperVar] + "sup");*/
          } else if (tempDoubleHelper >= 0.7) {
            visualizerPseudoGrid[helperVar].setIcon(new ImageIcon("gyellowsquare2.png"));
          } else if (tempDoubleHelper >= 0.5) {
            visualizerPseudoGrid[helperVar].setIcon(new ImageIcon("gorangesquare2.png"));
          } else if (tempDoubleHelper >= 0.3) {
            visualizerPseudoGrid[helperVar].setIcon(new ImageIcon("gredsquare2.png"));
          } else {
            visualizerPseudoGrid[helperVar].setIcon(new ImageIcon("greysquare2.png"));
          }
          
          helperVar++;
        }
        
        //checks for the highest attendance by using inital value as a pivot
        maxPpl = Integer.parseInt(visualizerPseudoGrid[0].getName());

        //checks through the entirety of the array
        for (int i = 0; i < visualizerPseudoGrid.length; i++) {
          if (maxPpl < Integer.parseInt(visualizerPseudoGrid[i].getName())) {
            maxPpl = Integer.parseInt(visualizerPseudoGrid[i].getName());
            recomTime = i;
          } else if (maxPpl == Integer.parseInt(visualizerPseudoGrid[i].getName()) && i < recomTime) {
            recomTime = i;
          }
        }

        System.out.println(maxPpl + " " + recomTime);
        
        recoFDate = recomTime / hours + 8;
        recoFTime = recomTime % hours;
        
        if (recoFTime > 12) {
          recoFTime -= 12;
          recoAMvsPM = "P.M.";
        } else if (recoFTime == 12) {
          recoAMvsPM = "P.M.";
        } else {
          recoAMvsPM = "A.M.";
        }
        
        finalMT.setText(recoFTime + " " + recoAMvsPM);
        finalMD.setText("August " + recoFDate + "th");
        finalMA.setText(maxPpl + " attendee(s)");
        //System.out.println("Recommended meeting time is August " + recoFDate + "th, at " + recoFTime + recoAMvsPM);
        
        //needs to be reset; lets later dates to be chosen against early times (due to more people)
        maxPpl = 0;
        
      }
      helperVar = 0;
      
      for (int columnNumber = 0 ; columnNumber < days; columnNumber++) {
        for (int rowNumber = 0 ; rowNumber < hours; rowNumber++) {
          gridBtns[rowNumber][columnNumber].setName("x");
          gridBtns[rowNumber][columnNumber].setIcon(new ImageIcon("greysquare.png"));
        }
      }
      
      //resets field
      inputName.setText("");
      inputEmail.setText("");
      inputHours.setText("");
    } else if (e.getActionCommand ().equals ("yes")) {
      //send email
    } else if (e.getActionCommand ().equals ("no")) {
      //don't do anything
      
    } else if (Integer.parseInt (e.getActionCommand ()) % 1 == 0) {
      //Gets column and row number from action command
      int btnActionCommand = Integer.parseInt (e.getActionCommand ());
      int rowCommand = (btnActionCommand - (btnActionCommand % 10))/10;
      int columnCommand = btnActionCommand % 10;
      System.out.println(""+ gridBtns[rowCommand][columnCommand].getName());
      System.out.println(btnActionCommand);
      
      System.out.println(rowCommand);
      System.out.println(columnCommand);
      
      //gridBtns[rowCommand][columnCommand].setName("o");
      //gridBtns[rowCommand][columnCommand].setIcon(new ImageIcon("greensquare.png"));
      
      if (gridBtns[rowCommand][columnCommand].getName().equals("x")) {
        
        gridBtns[rowCommand][columnCommand].setName("o");
        gridBtns[rowCommand][columnCommand].setIcon(new ImageIcon("greensquare.png"));
        timingArrayGenerator++;
        
      } else if (gridBtns[rowCommand][columnCommand].getName().equals("o")) {
        gridBtns[rowCommand][columnCommand].setName("x");
        gridBtns[rowCommand][columnCommand].setIcon(new ImageIcon("greysquare.png"));
        timingArrayGenerator--;
      }
    }
  }
  
  public static void main(String args[]) { 
    
    //Constructor is called and run
    new Demo();
  }
}
