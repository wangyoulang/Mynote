package com.example.sso.core.collection;

import lombok.Data;

@Data
public class CategoryDistDO {
    private Integer rootCategoryId;

    private String rootCategoryName;

    private Integer categoryId;

    private String categoryName;

    private Integer number;
}
