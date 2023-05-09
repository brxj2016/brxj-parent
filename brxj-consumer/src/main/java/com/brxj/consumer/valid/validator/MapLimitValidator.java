package com.brxj.consumer.valid.validator;

import com.brxj.consumer.valid.Limit;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Objects;

/**
 * 映射限定校验器
 *
 * @author qianrui
 */
@NoArgsConstructor
public class MapLimitValidator implements ConstraintValidator<Limit, Map<?, ?>> {

    private int min;

    private int max;

    private boolean allowNull;

    private boolean allowEmpty;

    private boolean allowBlack;

    @Override
    public void initialize(Limit limit) {
        ConstraintValidator.super.initialize(limit);

        min = limit.min();
        max = limit.max();
        allowNull = limit.allowNull();
        allowEmpty = limit.allowEmpty();
        allowBlack = limit.allowBlack();
    }

    @Override
    public boolean isValid(Map map, ConstraintValidatorContext context) {
        if (Objects.isNull(map)) {
            return allowNull;
        } else {
            var length = map.size();

            return (allowBlack || allowEmpty || length > 0) &&
                    (min == -1 || length >= min) &&
                    (max == -1 || length <= max);
        }
    }
}
