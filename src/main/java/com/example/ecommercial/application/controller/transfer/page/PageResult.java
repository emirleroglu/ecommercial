package com.example.ecommercial.application.controller.transfer.page;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageResult {
    private Integer totalPage;
    private Integer totalItem;
}
