package org.common.http;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.List;

@Data
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PagePayload<T> {
    int page;
    int size;
    long total;
    int totalPages;

    @Builder.Default
    List<T> data = Collections.emptyList();
}
