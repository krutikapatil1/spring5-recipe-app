package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
public class NotesToNotesCommandConverterTest extends TestCase {

    private final static Long ID_VALUE = 1L;
    private final static String RECIPENOTES = "Recipe Notes";
    NotesToNotesCommandConverter notesToNotesCommandConverter;

    public void setUp() throws Exception {
        super.setUp();
        notesToNotesCommandConverter = new NotesToNotesCommandConverter();
    }

    @Test
    public void test_Null() {
        assertNull(notesToNotesCommandConverter.convert(null));
    }

    @Test
    public void test_EmptyObj() {
        assertNotNull(notesToNotesCommandConverter.convert(new Notes()));
    }

    @Test
    public void testConvert() {
        //given
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPENOTES);

        //when
        NotesCommand notesCommand = notesToNotesCommandConverter.convert(notes);

        //then
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPENOTES, notesCommand.getRecipeNotes());
    }
}