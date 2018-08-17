package cww.world.common.validate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author 小武 on 2018/8/16.
 */
public class EntityValidator {

    public static <T> ValidateResult validate(T domain, Class<?>... groups) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return convert(validator.validate(domain, groups), new ValidateResult());
    }

    private static <T> ValidateResult convert(Set<ConstraintViolation<Object>> vr, ValidateResult r) {
        vr.forEach((cv) -> r.addErrorMessage(cv.getMessage()));
        return r;
    }
}
