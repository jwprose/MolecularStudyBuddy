package sws.msb;

import android.graphics.PointF;
import android.view.View.*;
import android.view.MotionEvent;
import android.view.View;
import android.app.Activity;
import android.os.Bundle;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author patrick
 *  @version 2012.03.13
 */
public class MolecularStudyBuddyActivity extends Activity
    implements OnTouchListener, OnLongClickListener
{

    BuilderView bView;
    private AtomView currentAtom;
    private boolean moving;
    private PointF location;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        03-13 04:27:01.205: ERROR/AndroidRuntime(403): java.lang.IllegalStateException: Could not find a method addAtom(View) in the activity class sws.msb.MolecularStudyBuddyActivity for onClick handler on view class android.widget.Button with id 'addButton'

        bView = (BuilderView)(findViewById(R.id.bView));
        bView.setOnLongClickListener(this);
        bView.setOnTouchListener(this);
 }
    
    
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void addAtom(View view)
    {
        // TODO Prompt user to choose element from a list.

        bView.addAtom(new Atom(Element.H));
        bView.postInvalidate();
    }
    
    public void addAtom(PointF location) {
        bView.addAtom(location, new Atom(Element.H));
        bView.postInvalidate();
    }

    public boolean onLongClick(View v)
    {
        if (this.currentAtom == null && this.location != null && !moving) {
            this.addAtom(location);
            currentAtom = bView.getAtoms().get(bView.getAtoms().size() - 1);
        }
        // Change to false if you want more handled in any other on-click
        // listeners.
        return true;
    }

    public boolean onTouch(View v, MotionEvent event)
    {
        boolean handled = false;
        this.location = new PointF(event.getX(), event.getY());
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            for (AtomView atom : bView.getAtoms()) {
                PointF atomLoc = atom.getLocation();
                if (location.x >= atomLoc.x - 25 &&
                    location.x <= atomLoc.x + 25 &&
                    location.y >= atomLoc.y - 25 &&
                    location.y <= atomLoc.y + 25) {
                    currentAtom = atom;
                }
            }
            handled = false;
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            if (currentAtom != null && location != null){
                currentAtom.setLocation(location);
            }
            moving = true;
            handled = true;
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            this.currentAtom = null;
            this.location = null;
            moving = false;
            handled = true;
        }
        // TODO Auto-generated method stub
        bView.postInvalidate();
        return handled;
    }


}