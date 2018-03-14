import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SingleCircleMVC1 extends JApplet 
{ private JButton jbtController = new JButton("Show Controller");
  private JButton jbtView = new JButton("Show View");
  private CircleModel1 model = new CircleModel1();
  public SingleCircleMVC1()
  { setLayout(new FlowLayout());
    add(jbtController);
    add(jbtView);
    jbtController.addActionListener(new ActionListener()
    { public void actionPerformed(ActionEvent e)
      { JFrame frame1 = new JFrame("Controller");
        CircleController1 controller = new CircleController1();
        controller.setModel(model);
        frame1.add(controller);
        frame1.setSize(200, 200);
        frame1.setLocation(200, 200);
        frame1.setAlwaysOnTop(true);
        frame1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
        frame1.setVisible(true);
      }
    });
    jbtView.addActionListener(new ActionListener()
    { public void actionPerformed(ActionEvent e)
      { JFrame frame2 = new JFrame("View");
        CircleView1 view = new CircleView1();
        view.setModel(model);
        frame2.add(view);
        frame2.setSize(500, 200);
        frame2.setLocation(300, 300);
        frame2.setAlwaysOnTop(true);
        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
        frame2.setVisible(true); 
       }
     });
  }
  public static void main(String[] args)
  { SingleCircleMVC1 applet = new SingleCircleMVC1();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("SingleCircleMvc1");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(400, 100);
    frame.setAlwaysOnTop(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE  );
    frame.setVisible(true);
  }
}
