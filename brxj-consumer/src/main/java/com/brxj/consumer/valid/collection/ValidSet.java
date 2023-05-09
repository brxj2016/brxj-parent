package com.brxj.consumer.valid.collection;

import com.brxj.consumer.valid.Limit;
import com.brxj.consumer.valid.group.Collection;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 可验证集合类
 *
 * @author qianrui
 */
@NoArgsConstructor
public class ValidSet<E> implements Set<E>, Serializable {

    @Serial
    private static final long serialVersionUID = 1102548762655045126L;

    @Delegate
    @Valid
    @Limit(allowNull = false, message = "请至少选择一项内容", groups = Collection.LeastOne.class)
    private final HashSet<E> value = new HashSet<>(0);

    @Override
    public String toString() {
        return value.toString();
    }
}
