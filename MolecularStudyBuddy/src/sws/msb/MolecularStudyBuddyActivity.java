package sws.msb;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
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
{

    BuilderView bView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        03-13 04:27:01.205: ERROR/AndroidRuntime(403): java.lang.IllegalStateException: Could not find a method addAtom(View) in the activity class sws.msb.MolecularStudyBuddyActivity for onClick handler on view class android.widget.Button with id 'addButton'

        bView = (BuilderView)(findViewById(R.id.bView));
 }
    public boolean onTouchEvent(MotionEvent event) {
        boolean handled = false;
        boolean touched = false;
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            handled = true;
//        }
//        else 
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            AtomView clicking = null;
            float x = event.getX();
            float y = event.getY();
            for (AtomView atom : bView.getAtoms()) {
//                if (atom.getLocation().x <= x + 100 &&
//                    atom.getLocation().x >= x - 100 &&
//                    atom.getLocation().y <= y + 100 &&
//                    atom.getLocation().y >= y + 100) {
//                    clicking = atom;
//                }
                clicking = atom;
            }
            if (clicking != null){
                clicking.setLocation(event.getX(), event.getY());
            }
            handled = true;
        }
//        else if (event.getAction() == MotionEvent.ACTION_UP) {
//            handled = true;
//        }
        return handled;
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


}