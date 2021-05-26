import jUnit.BycicleMock;
import jUnit.DatabaseConnector;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestBycicleMock {

    BycicleMock bike = null;

    DatabaseConnector dbConn = Mockito.mock(DatabaseConnector.class);

    @Before
    public void init() {
        bike = new BycicleMock(dbConn);
    }

    @Test
    public void testSum() {

        when(dbConn.checkUserPass("Peter", "secret")).thenReturn(true);

        Integer expected = 3;
        assertEquals(expected, bike.sum("Peter", "secret", 1, 1, 1));
        verify(dbConn).checkUserPass("Peter", "secret");
    }
}
