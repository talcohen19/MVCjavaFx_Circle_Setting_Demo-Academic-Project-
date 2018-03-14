import java.awt.event.*;
import java.awt.*;  
import javax.swing.*;
import javax.swing.border.LineBorder;
public class CircleController2 extends JPanel 
  implements CircleEvents,  ActionListener
{ private static final long serialVersionUID = 1L;
  private CircleModel2 model;
  private int circleCounter;
  private JTextField jtfRadius = new JTextField();
  private JComboBox<Boolean> jcboFilled = 
	new JComboBox<Boolean>(new Boolean[]
	  {  new Boolean(false), new Boolean(true)
	  });
  private JComboBox<Boolean> jcboCalculateArea = 
	new JComboBox<Boolean>(new Boolean[]
	  {  new Boolean(false), new Boolean(true)
	  });
  private JLabel jlblColor = new JLabel();
  private JButton jbtChooseColor = new JButton("...");
  final String inputError = "radis must be > 0.0";
  final String chooseAcolor = "Choose a Color";
  public CircleController2(int circleCounter)
  { this.circleCounter = circleCounter;
    JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayout(4, 1));
    panel1.add(new JLabel(eventType.RADIUS.toString()));
    panel1.add(new JLabel(eventType.FILLED.toString()));
    panel1.add(new JLabel(eventType.AREA.toString()));
    panel1.add(new JLabel(eventType.COLOR.toString()));
    JPanel panel2 = new JPanel();
    panel2.setLayout(new GridLayout(4, 1));
    panel2.add(jtfRadius);
    panel2.add(jcboFilled);
    panel2.add(jcboCalculateArea);
    JPanel colorPanel = new JPanel();
    colorPanel.setLayout(new BorderLayout());
    jlblColor.setOpaque(true);
    colorPanel.add(jlblColor, BorderLayout.CENTER);
    colorPanel.add(jbtChooseColor, BorderLayout.EAST);
    colorPanel.setBorder(
      new LineBorder(Color.red));
    panel2.add(colorPanel);
    setLayout(new BorderLayout());
    add(panel1, BorderLayout.WEST);
    add(panel2, BorderLayout.CENTER);
    jtfRadius.addActionListener(this);
    jcboFilled.addActionListener(this);
    jcboCalculateArea.addActionListener(this);
    jbtChooseColor.addActionListener(this);
  }
  public int getcircleCounter()
  { return circleCounter;
  }
  @Override
  public void actionPerformed(ActionEvent e)
  { if (model == null) return;
    if (e.getSource() == jtfRadius)
    { try
      { double radius = 
    	new Double(jtfRadius.getText()).doubleValue();
    	   if (radius <= 0) 
    	   { jtfRadius.setText(inputError);
   	         return;
    	   }  
           model.setRadius(radius);
      }
      catch (Exception ex) 
      { jtfRadius.setText(inputError);
        return;
      
      }
    }
    else
    if (e.getSource() == jcboFilled)
      model.setFilled(
        ((Boolean)jcboFilled.getSelectedItem()).booleanValue());
    else
    if (e.getSource() == jbtChooseColor)
      { Color selectedColor = JColorChooser.showDialog(this,
    	  chooseAcolor, jlblColor.getBackground());
        if (selectedColor != null)
        { jlblColor.setBackground(selectedColor);
          model.setColor(selectedColor);
        }
      }
    else
    if (e.getSource() == jcboCalculateArea)
      model.setCalculateArea(((Boolean)jcboCalculateArea.
    	getSelectedItem()).booleanValue());
  }
  public void setModel(CircleModel2 newModel)
  { model = newModel;
  }
  public CircleModel2 getModel()
  { return model;
  }
}
