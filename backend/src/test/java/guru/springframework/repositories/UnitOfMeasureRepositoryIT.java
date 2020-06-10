package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

/**
 * @author : Krutika Patil
 * @since : 6/9/2020, Tue
 **/
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByDescription() throws Exception {
        UnitOfMeasure unitOfMeasureTableSpoon = new UnitOfMeasure();
        unitOfMeasureTableSpoon.setDescription("Tablespoon");
        given(unitOfMeasureRepository.findByDescription("Tablespoon")).willReturn(Optional.of(unitOfMeasureTableSpoon));
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        assertEquals("Tablespoon", uomOptional.get().getDescription());
    }
}