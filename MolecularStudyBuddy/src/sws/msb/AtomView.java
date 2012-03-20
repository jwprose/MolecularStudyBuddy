package sws.msb;

import android.graphics.Paint.Style;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.content.Context;
import android.view.View;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author patrick
 *  @version Mar 12, 2012
 */
public class AtomView extends View
{

    private Atom atom;
    private PointF location;
    private Paint white;
    private Paint black;

    // ----------------------------------------------------------
    /**
     * Create a new AtomView object.
     * @param context
     */
    public AtomView(Context context)
    {
        super(context);
        location = new PointF();
        white = new Paint();
        black = new Paint();
    }


    // ----------------------------------------------------------
    /**
     * @param atom the atom to set
     */
    public void setAtom(Atom atom)
    {
        this.atom = atom;
    }

    // ----------------------------------------------------------
    /**
     * @return the atom
     */
    public Atom getAtom()
    {
        return atom;
    }


    // ----------------------------------------------------------
    /**
     * @param location the location to set
     */
    public void setLocation(PointF location)
    {
        this.location = location;
    }

    // ----------------------------------------------------------
    /**
     * Sets location to given (x,y) coordinates
     * @param x
     * @param y
     */
    public void setLocation(float x, float y)
    {
        location.x = x;
        location.y = y;
    }

    // ----------------------------------------------------------
    /**
     * @return the location
     */
    public PointF getLocation()
    {
        return location;
    }

    public void onDraw(Canvas canvas)
    {
        // TODO Set style!
        white.setColor(Color.WHITE);
        white.setStyle(Style.FILL);
        black.setColor(Color.BLACK);
        black.setStyle(Style.FILL);
        canvas.drawCircle(location.x, location.y, 25, white);
        canvas.drawText(atom.getSymbol(), location.x - 4, location.y + 4, black);
    }

}