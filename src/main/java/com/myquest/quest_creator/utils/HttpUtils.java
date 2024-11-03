package com.myquest.quest_creator.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.util.ObjectUtils;

import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import static com.myquest.quest_creator.utils.DataResult.DataOnlyResult;
import static com.myquest.quest_creator.utils.DataResult.DataResultWithMeta;
import static com.myquest.quest_creator.utils.DataResult.PageObject;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HttpUtils {

    public static <T> ResponseEntity<DataResult<T>> ok(T data) {
        return new ResponseEntity<>(new DataOnlyResult<>(data), HttpStatus.OK);
    }

    public static <T> ResponseEntity<DataResult<T>> ok(T data, Object meta) {
        return new ResponseEntity<>(new DataResultWithMeta<>(data, meta), HttpStatus.OK);
    }

    public static <T> ResponseEntity<DataResult<T>> bad(T data) {
        return new ResponseEntity<>(new DataOnlyResult<>(data), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<DataResult<Void>> noContent() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<DataResult<T>> withStatus(T data, HttpStatus status) {
        return new ResponseEntity<>(new DataOnlyResult<>(data), status);
    }

    public static <T, K, V> ResponseEntity<DataResult<List<T>>> pageableWithMapOk(Page<T> all, Map<K, V> map) {
        return new ResponseEntity<>(new DataResultWithMeta<>(all.getContent(),
                Map.of("page", composePageObject(all), "map", map)), HttpStatus.OK);
    }

    public static <T> ResponseEntity<DataResult<List<T>>> pageableOk(Page<T> all) {
        PageObject page = composePageObject(all);

        return HttpUtils.ok(all.getContent(), page);
    }

    public static ResponseEntity<byte[]> wrapByteArrayForDownload(byte[] arr, String type, String fileName) {
        if (ObjectUtils.isEmpty(arr)) throw new IllegalStateException("Empty array");

        HttpHeaders headers = new HttpHeaders();
        String contentDispositionType = "attachment";
        ContentDisposition contentDisposition = ContentDisposition.builder(contentDispositionType)
                .filename(fileName, StandardCharsets.UTF_8)
                .build();
        headers.setContentType(MediaType.valueOf(type));
        headers.setContentDisposition(contentDisposition);
        headers.setDate(OffsetDateTime.now().toInstant().toEpochMilli());
        headers.setContentLength(arr.length);

        return new ResponseEntity<>(arr, headers, HttpStatus.OK);
    }

    private static <T> PageObject composePageObject(Page<T> all) {
        return PageObject.builder()
                .currentPage(all.getPageable().getPageNumber() + 1)
                .pagesCount(all.getTotalPages())
                .total(all.getTotalElements())
                .pageSize(all.getPageable().getPageSize())
                .sortField(all.getPageable().getSort().get().findFirst().map(Sort.Order::getProperty).orElse(null))
                .sortDir(all.getPageable().getSort().get().findFirst().map(Sort.Order::getDirection).orElse(null))
                .build();
    }
}
