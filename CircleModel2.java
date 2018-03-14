import java.awt.event.*;
import java.util.*;
public class CircleModel2 implements CircleEvents 
{ private int circleCounter;
  private double radius = 20;
  private boolean filled;
  private boolean calculateArea;
  private java.awt.Color color;
  private Map<eventType, ArrayList<ActionListener>> circleHashMap = 
  	new HashMap<eventType, ArrayList<ActionListener>>();
  public CircleModel2(int circleCounter)
  { this.circleCounter = circleCounter;
    for (eventType et: eventType.values())
      circleHashMap.put(et, new ArrayList<ActionListener>()); 	
  }
  public int getcircleCounter()
  { return circleCounter;
  }
  public double getRadius()
  { return radius;
  }
  public void setRadius(double radius)
  { this.radius = radius;
    processEvent(eventType.RADIUS,
      new ActionEvent(this, ActionEvent.ACTION_PERFORMED, 
    	eventType.RADIUS.toString()));
  }
  public boolean isFilled()
  { return filled;
  }
  public void setFilled(boolean filled)
  {  this.filled = filled; 
     processEvent(eventType.FILLED,
      new ActionEvent(this, ActionEvent.ACTION_PERFORMED, 
    	eventType.FILLED.toString()));
  }
  public boolean calculateArea()
  { return calculateArea;
  }
  public void setCalculateArea(boolean calculateArea)
  { this.calculateArea = calculateArea; 
	processEvent(eventType.AREA, new ActionEvent(this,
	  ActionEvent.ACTION_PERFORMED, eventType.AREA.toString()));
  }
  public java.awt.Color getColor()
  { return color;
  }
  public void setColor(java.awt.Color color)
  { this.color = color;
    processEvent(eventType.COLOR, new ActionEvent(this, 
      ActionEvent.ACTION_PERFORMED, eventType.COLOR.toString()));
  }
  public synchronized void addActionListener(
	ActionListener l, eventType et)
  {   ArrayList<ActionListener> al;
	  al = circleHashMap.get(et);
	  if (al == null) al = new ArrayList<ActionListener>(); 
	  al.add(l);
	  circleHashMap.put(et,  al);
  }
  public synchronized void removeActionListener(
    ActionListener l, eventType et)
  { ArrayList<ActionListener> al;
    al = circleHashMap.get(et);
    if (al != null && al.contains(l)) al.remove(l);
    circleHashMap.put(et,  al);
  }
  private void processEvent(eventType et, ActionEvent e)
  { ArrayList<ActionListener> al;
	synchronized (this) 
    { al = circleHashMap.get(et);
      if (al == null) return;
    }  
    System.out.println("model number: " + (getcircleCounter()+1) 
      + " actionCommand: " + e.getActionCommand() 
      + " array size is: " + al.size());
    for (int i = 0; i < al.size(); i++)
    { ActionListener listener = (ActionListener)al.get(i);
      listener.actionPerformed(e);
    }
  }
}
