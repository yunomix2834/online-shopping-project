package org.common.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Envelope<T> {

    @Builder.Default
    int status = 200;

    String error;

    @Builder.Default
    String msg = "OK";

    @Builder.Default
    Instant currentTime = Instant.now();

    T data;

    /* Helpers */
    public static <T> Envelope<T> ok(T data){
        return Envelope.<T>builder()
                .status(200)
                .error(null)
                .msg("OK")
                .currentTime(Instant.now())
                .data(data)
                .build();
    }
    public static <T> Envelope<T> err(
            int status,
            String code,
            String message,
            T data){
        return Envelope.<T>builder()
                .status(status)
                .error(code)
                .msg(message)
                .currentTime(Instant.now())
                .data(data)
                .build();
    }

    public static <TDoc> Envelope<Page<TDoc>> okPage(
            int page, int size,
            long total, int totalPages,
            List<TDoc> docs){
        return Envelope.ok(Page.<TDoc>builder()
                .page(page)
                .size(size)
                .total(total)
                .totalPages(totalPages)
                .docs(docs)
                .build()
        );
    }

    @Getter @Setter @Builder
    @NoArgsConstructor @AllArgsConstructor
    @FieldDefaults(level = lombok.AccessLevel.PRIVATE)
    public static class Page<TDoc>{
        int page;
        int size;
        long total;
        int totalPages;

        @Builder.Default
        List<TDoc> docs = List.of();
    }
}
