import java.awt.*;
import java.awt.event.*;
public class CircleView1 extends javax.swing.JPanel
    implements ActionListener
{ private static final long serialVersionUID = 1L;
  private CircleModel1 model;
  @Override
  public void actionPerformed(ActionEvent actionEvent)
  { repaint();
  }
  /** Set a model */
  public void setModel(CircleModel1 newModel)
  { model = newModel;
    if (model != null)
      // Register the view as listener for the model
      model.addActionListener(this);
    //repaint();
  }
  public CircleModel1 getModel()
  { return model;
  }
  public void paintComponent(Graphics g)
  { super.paintComponent(g);
    if (model == null) return;
    g.setColor(model.getColor());
    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;
    int radius = (int)model.getRadius();
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