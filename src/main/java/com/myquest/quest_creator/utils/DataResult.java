package com.myquest.quest_creator.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import org.springframework.data.domain.Sort;


@JsonPropertyOrder({"data", "metaObject"})
public interface DataResult<T> {

    @JsonProperty(value = "data")
    T data();

    @JsonProperty("meta")
    default Object metaObject() {
        return null;
    }

    record MetaObject<M>(M meta) {
    }

    @Builder
    record PageObject(int currentPage,
                      int pageSize,
                      int pagesCount,
                      long total,
                      String sortField,
                      Sort.Direction sortDir) {
    }

    record DataOnlyResult<T>(T data) implements DataResult<T> {
    }

    record DataResultWithMeta<T>(T data, Object meta) implements DataResult<T> {
        @Override
        public Object metaObject() {
            return this.meta;
        }
    }
}
