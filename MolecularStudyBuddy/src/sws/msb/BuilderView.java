package sws.msb;

import android.graphics.Paint.Style;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author patrick
 *  @version Mar 12, 2012
 */
public class BuilderView extends View
{

    private ArrayList<AtomView> atoms;

    // ----------------------------------------------------------
    /**
     * Create a new BuilderView object.
     * @param context
     * @param attributeSet
     */
    public BuilderView(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        atoms = new ArrayList<AtomView>();
    }


    // ----------------------------------------------------------
    /**
     * @return the list of atoms
     */
    public ArrayList<AtomView> getAtoms()
    {
        return atoms;
    }

    // ----------------------------------------------------------
    /**
     * Adds a new atom to the field
     * @param newAtom
     */
    public void addAtom(Atom newAtom)
    {
        AtomView newView = new AtomView(getContext());
        newView.setAtom(newAtom);
        atoms.add(newView);
    }
    
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setStyle(Style.FILL);
        canvas.drawPaint(paint);
        for (AtomView atom : atoms) {
            atom.draw(canvas);
        }
    }
}
