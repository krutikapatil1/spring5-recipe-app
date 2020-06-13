package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
public class NotesCommandToNotesConverterTest extends TestCase {

    private final static Long ID_VALUE = 1L;
    private final static String RECIPENOTES = "Recipe Notes";
    NotesCommandToNotesConverter notesCommandToNotesConverter;

    public void setUp() throws Exception {
        super.setUp();
        notesCommandToNotesConverter = new NotesCommandToNotesConverter();
    }

    @Test
    public void test_Null() {
        assertNull(notesCommandToNotesConverter.convert(null));
    }

    @Test
    public void test_EmptyObj() {
        assertNotNull(notesCommandToNotesConverter.convert(new NotesCommand()));
    }

    @Test
    public void testConvert() {
        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPENOTES);

        //when
        Notes notes = notesCommandToNotesConverter.convert(notesCommand);

        //then
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPENOTES, notes.getRecipeNotes());
    }
}