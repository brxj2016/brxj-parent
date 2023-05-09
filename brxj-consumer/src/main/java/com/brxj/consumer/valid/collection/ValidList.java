package com.brxj.consumer.valid.collection;

import com.brxj.consumer.valid.Limit;
import com.brxj.consumer.valid.group.Collection;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 可验证列表类
 *
 * @author qianrui
 */
@NoArgsConstructor
public final class ValidList<T> implements List<T>, Serializable {

    @Serial
    private static final long serialVersionUID = 6641064846275588144L;

    @Delegate
    @Valid
    @Limit(allowNull = false, message = "请至少选择一项内容", groups = Collection.LeastOne.class)
    private final List<T> value = new ArrayList<>(0);

    @Override
    public String toString() {
        return value.toString();
    }
}