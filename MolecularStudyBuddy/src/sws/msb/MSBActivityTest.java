package sws.msb;

import android.widget.Button;
import student.AndroidTestCase;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author patrick
 *  @version Mar 12, 2012
 */
public class MSBActivityTest extends AndroidTestCase<MolecularStudyBuddyActivity>
{
    private BuilderView bView;
    private Button plus;

    // ----------------------------------------------------------
    /**
     * Create a new MSBActivityTest object.
     */
    public MSBActivityTest()
    {
        super(MolecularStudyBuddyActivity.class);
    }

    public void setUp()
    {
        bView = getView(BuilderView.class, R.id.bView);
        plus = getView(Button.class, R.id.addButton);
    }

    public void testAddAtom()
    {
        click(plus);
        assertTrue(bView.getAtoms().size() > 0);
    }
}
