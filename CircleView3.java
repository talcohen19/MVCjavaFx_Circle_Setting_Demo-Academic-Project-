import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
public class CircleView3 extends JPanel implements CircleEvents
{ class RadiusEvent implements ActionListener
  { public void actionPerformed(ActionEvent e)
    { eventTitle = eventType.RADIUS.toString();
      repaint(); 
    }
  }
  class ColorEvent implements ActionListener
  { public void actionPerformed(ActionEvent e)
    { eventTitle = eventType.COLOR.toString();
      repaint(); 
    }
  }
  class FilledEvent implements ActionListener
  { public void actionPerformed(ActionEvent e)
    { eventTitle = eventType.FILLED.toString();
      repaint(); 
    }
  }
  class AreaEvent implements ActionListener
  { public void actionPerformed(ActionEvent e)
    { eventTitle = eventType.AREA.toString();
      repaint(); 
    }
  }
  private static final long serialVersionUID = 1L;
  private CircleModel3 model;
  private int circleCounter = 1;
  private String eventTitle="DEFAULT";
  public CircleView3(int circleCounter)
  { this.circleCounter = circleCounter;
  }
  public int getcircleCounter()
  { return circleCounter;
  }
  public int setcircleCounter(int circleCounter)
  { return this.circleCounter = circleCounter;
  }
  public void setModel(CircleModel3 newModel)
  { model = newModel;
    if (model != null)
    { model.addActionListener(new RadiusEvent(), eventType.RADIUS);
      model.addActionListener(new FilledEvent(), eventType.FILLED);
      model.addActionListener(new ColorEvent(), eventType.COLOR);
      model.addActionListener(new AreaEvent(), eventType.AREA);
    }
  }
  public CircleModel3 getModel()
  { return model;
  }
  public void paintComponent(Graphics g)
  { super.paintComponent(g);
    if (model == null) return;
    int rowSpace = 15;
    int row = 10;
    int column = 10;
    int radius = (int)model.getRadius();
    g.setFont(new Font("Courier", Font.PLAIN, 12));
    g.drawString("Event Type: " + eventTitle, column, row);
    row = row + rowSpace;
    g.drawString("Circle number " + circleCounter, column, row);
    row = row + rowSpace;
    g.drawString("Circle raduis " + radius, column, row);
    row = row + rowSpace;
    if (model.calculateArea())
    { double circleArea = radius * radius * Math.PI;	
      g.drawString("Circle Area " + circleArea, column, row);
    }
    g.setColor(model.getColor());
    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;
    if (model.isFilled())
    { g.fillOval(xCenter - radius, yCenter - radius,
        2 * radius, 2 * radius);
    }
    else
    { g.drawOval(xCenter - radius, yCenter - radius,
        2 * radius, 2 * radius);
    }
  }
}
