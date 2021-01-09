package UnitTest;

import com.company.Constant.ValidatorStrategy;
import com.company.FunctionManager.ValidationManager;
import com.company.Object.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InitialUnitTest {

    private ValidatorStrategy VALIDATOR_STRATEGY = ValidatorStrategy.NORMAL_VALIDATOR;
    private ValidationManager validationManager = null;

    private final String VALID_NAME = "Quang Minh";
    private final String VALID_EMAIL = "masa23vn@gmail.com";
    private final String VALID_ID_SERIALNUMBER = "001712596";
    private final Integer VALID_ID = 204;
    private final Integer VALID_AGE = 31;

    private final String INVALID_NAME = "   ";
    private final String INVALID_EMAIL = "masa23vngmail.com";
    private final String INVALID_ID_SERIALNUMBER = "01712596";
    private final Integer INVALID_ID = 199;
    private final Integer INVALID_AGE = 14;

    private Person VALID_PERSON = null;
    private Person INVALID_PERSON = null;

    @Before
    public void init(){
        validationManager = ValidationManager.createValidatorStrategyByName(VALIDATOR_STRATEGY.name());
        VALID_PERSON = new Person();
        VALID_PERSON.setID(VALID_ID);
        VALID_PERSON.setAge(VALID_AGE);
        VALID_PERSON.setName(VALID_NAME);
        VALID_PERSON.setEmail(VALID_EMAIL);
        VALID_PERSON.setIDSerialNumber(VALID_ID_SERIALNUMBER);

        INVALID_PERSON = new Person();
        INVALID_PERSON.setID(INVALID_ID);
        INVALID_PERSON.setAge(INVALID_AGE);
        INVALID_PERSON.setName(INVALID_NAME);
        INVALID_PERSON.setEmail(INVALID_EMAIL);
        INVALID_PERSON.setIDSerialNumber(INVALID_ID_SERIALNUMBER);
    }

    @Test
    public void test_shouldValid(){
        assertEquals(0, validationManager.validate(VALID_PERSON).size());
    }

    @Test
    public void test_shouldInValid(){
        System.out.println(validationManager.validate(INVALID_PERSON).size());
        assertEquals(Boolean.TRUE, validationManager.validate(INVALID_PERSON).size() > 0);
    }
}