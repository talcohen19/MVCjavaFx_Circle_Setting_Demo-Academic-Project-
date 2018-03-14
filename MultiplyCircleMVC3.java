import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MultiplyCircleMVC3 extends JApplet  
{ private static final long serialVersionUID = 1L;
  private JButton jbtControllerView = 
	new JButton("Show Controller and View");
  private CircleController3 circleController;
  private CircleView3 circleView;
  private CircleModel3 circleModel;
  private int circleCounter=0;
  public MultiplyCircleMVC3()
  { circleModel = new CircleModel3(circleCounter);
	setLayout(new FlowLayout());
    add(jbtControllerView);
	jbtControllerView.addActionListener(new ActionListener()
    { public void actionPerformed(ActionEvent e)
      { circleModel = new CircleModel3(circleCounter);
    	circleController = new  CircleController3(circleCounter);
  	    circleView = new CircleView3(circleCounter);
    	circleController.setModel(circleModel);
    	circleView.setModel(circleModel);
    	JFrame frame1 = 
    	  new JFrame("Controller number " + (circleCounter+1));
        frame1.add(circleController);
        frame1.setSize(300, 200);
        frame1.setLocation(100 + circleCounter*15, 
          100 + circleCounter * 15);
        frame1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame1.setAlwaysOnTop(true);
        frame1.setVisible(true);
        JFrame frame2 = new JFrame("View number " + (circleCounter+1));
        frame2.add(circleView);
        frame2.setSize(400, 200);
        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame2.setLocation(200 + circleCounter*15, 
          200 + circleCounter * 15); 
        frame2.setAlwaysOnTop(true);
        frame2.setVisible(true);
        circleCounter++;
       }
     });
   }
   public static void main(String[] args)
   { MultiplyCircleMVC3 applet = new MultiplyCircleMVC3();
     JFrame frame = new JFrame();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setTitle("MultiplyCircleMVC3");
     frame.add(applet, BorderLayout.CENTER);
     frame.setSize(200, 100);
     frame.setAlwaysOnTop(true);
     frame.setVisible(true);
   }
 }