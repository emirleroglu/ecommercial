package com.example.ecommercial.application.controller.transfer.page;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SearchResultDTO<T> {
    private PageResult pageResult;
    private List<T> result;
}
