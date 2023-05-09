package com.brxj.consumer.valid.validator;

import com.brxj.consumer.valid.Key;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 键限定校验器
 *
 * @author qianrui
 */
public class KeyValidator implements ConstraintValidator<Key, Map<String, ?>> {

    private Set<String> limit;

    private Set<String> require;

    private boolean allowNull;

    @Override
    public void initialize(Key key) {
        ConstraintValidator.super.initialize(key);

        this.limit = Set.of(key.limit());
        this.require = Set.of(key.require());
        this.allowNull = key.allowNull();
    }

    @Override
    public boolean isValid(Map<String, ?> map, ConstraintValidatorContext context) {
        if (Objects.isNull(map)) {
            return allowNull;
        } else {
            var keys = map.keySet();

            return limit.containsAll(keys) && keys.containsAll(require);
        }
    }
}
