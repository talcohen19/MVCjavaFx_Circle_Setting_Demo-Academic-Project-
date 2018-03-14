import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class MultiplyCircleMVC2 extends JApplet  
{ private static final long serialVersionUID = 1L;
  private JButton jbtControllerView = 
	new JButton("Show Controller and View");
  private ArrayList<CircleController2> circleControllerList;
  private ArrayList<CircleView2> circleViewList;
  private ArrayList<CircleModel2> circleModelList;
  private int circleCounter=0;
  public MultiplyCircleMVC2()
  { circleControllerList = new  ArrayList<CircleController2>();
	circleViewList = new ArrayList<CircleView2>();
	circleModelList = new ArrayList<CircleModel2>();
	setLayout(new FlowLayout());
    add(jbtControllerView);
	jbtControllerView.addActionListener(new ActionListener()
    { public void actionPerformed(ActionEvent e)
      { circleModelList.add(new CircleModel2(circleCounter));
    	JFrame frame1 = new JFrame("Controller number " 
    	  + (circleCounter+1));
        circleControllerList.add(new CircleController2(circleCounter));
        circleControllerList.get(circleCounter).
          setModel(circleModelList.get(circleCounter));
        frame1.add(circleControllerList.get(circleCounter));
        frame1.setSize(300, 200);
        frame1.setLocation(100 + circleCounter*15, 
          100 + circleCounter * 15);
        frame1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame1.setAlwaysOnTop(true);
        frame1.setVisible(true);
        JFrame frame2 = new JFrame("View number "
          + (circleCounter+1));
        circleViewList.add(new CircleView2(circleCounter));
        (circleViewList.get(circleCounter)).
           setModel(circleModelList.get(circleCounter));
        frame2.add(circleViewList.get(circleCounter));
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
   { MultiplyCircleMVC2 applet = new MultiplyCircleMVC2();
     JFrame frame = new JFrame();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setTitle("MultiplyCircleMVC2");
     frame.add(applet, BorderLayout.CENTER);
     frame.setSize(200, 100);
     frame.setAlwaysOnTop(true);
     frame.setVisible(true);
   }
 }