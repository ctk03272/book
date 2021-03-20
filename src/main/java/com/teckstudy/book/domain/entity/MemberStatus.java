package com.teckstudy.book.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum MemberStatus {
    NORMAL("일반", "1"),
    BLOCK("정지", "2");

    private String legacyName;
    private String legacyCode;
}
