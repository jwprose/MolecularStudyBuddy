package sws.msb;

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

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void addAtom(View view)
    {
        // TODO Prompt user to choose element from a list.

        bView.addAtom(new Atom(Element.H));
    }


}