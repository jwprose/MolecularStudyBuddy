package sws.msb;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.Menu;
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
    private String lastAtom;
//    private boolean contextMenu;
    private PointF location;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bView = (BuilderView)(findViewById(R.id.bView));
        bView.setOnLongClickListener(this);
        bView.setOnTouchListener(this);
//        this.location = new PointF(bView.getWidth() / 2, bView.getHeight() / 2);
//        registerForContextMenu(bView);
//        contextMenu = false;
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.msb, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear:
                bView.clearAtoms();
                bView.postInvalidate();
                break;
            case R.id.H:
            case R.id.He:
            case R.id.Li:
            case R.id.Be:
            case R.id.B:
            case R.id.C:
            case R.id.N:
            case R.id.O:
            case R.id.F:
            case R.id.Ne:
            case R.id.Na:
            case R.id.Mg:
            case R.id.Al:
            case R.id.Si:
            case R.id.P:
            case R.id.S:
            case R.id.Cl:
            case R.id.Ar:
                if (location == null) {
                    this.location = new PointF(bView.getWidth() / 2, bView.getHeight() / 2);
                }
                this.lastAtom = item.getTitleCondensed().toString();
                this.addAtom(location, this.lastAtom);
                currentAtom = bView.getAtoms().get(bView.getAtoms().size() - 1);
                bView.postInvalidate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
    
//    public void onCreateContextMenu(ContextMenu menu, View v, 
//                                    ContextMenu.ContextMenuInfo menuInfo) {
//        if (contextMenu) {
//            super.onCreateContextMenu(menu, v, menuInfo);
//            MenuInflater inflater = getMenuInflater();
//            inflater.inflate(R.menu.context_menu_elements, menu);
//        }
//    }
    
//    public boolean onContextItemSelected(MenuItem item) {
//        if (location != null) {
//            switch(item.getItemId()) {
//                case R.id.H:
//                case R.id.He:
//                case R.id.Li:
//                case R.id.Be:
//                case R.id.B:
//                case R.id.C:
//                case R.id.N:
//                case R.id.O:
//                case R.id.F:
//                case R.id.Ne:
//                case R.id.Na:
//                case R.id.Mg:
//                case R.id.Al:
//                case R.id.Si:
//                case R.id.P:
//                case R.id.S:
//                case R.id.Cl:
//                case R.id.Ar:
//                    this.addAtom(location, item.getTitleCondensed().toString());
//                    break;
//                default:
//                    return super.onContextItemSelected(item);
//            }
//            bView.postInvalidate();
//            return true;
//        }
//        return false;
//    }
    
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
    
    public void addAtom(PointF location, String symbol) {
        bView.addAtom(location, new Atom(symbol));
        bView.postInvalidate();
    }

    public boolean onLongClick(View v)
    {
        if (this.currentAtom == null && this.location != null && !moving && 
            this.lastAtom != null) {
            this.addAtom(location, this.lastAtom);
//            this.addAtom(location, "H");
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
//            this.location = new PointF(bView.getWidth() / 2, bView.getHeight() / 2);
            this.location = null;
            moving = false;
            handled = true;
        }
        // TODO Auto-generated method stub
        bView.postInvalidate();
        return handled;
    }


}