import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class MouseFollow implements Runnable, MouseMotionListener, MouseListener {
	private boolean inWindow;
	private Point mousePos;
	private MoverPainter object;
	
	public MouseFollow(MoverPainter theObject)
	{
		object = theObject;
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged(MouseEvent e) {
		if (inWindow == true)
			mousePos = e.getLocationOnScreen();
	}

	public void mousePressed(MouseEvent e) {
		if (inWindow == true)
			mousePos = e.getLocationOnScreen();
	}
	
	public void mouseEntered(MouseEvent e)
	{
		inWindow = true;
	}

	public void mouseExited(MouseEvent e)
	{
		inWindow = false;
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
}
