package com.warrior.sell.mapper.provider;

import com.warrior.sell.entity.ProductCategory;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ProductCategoryProvider extends SQL {
    private final static String TABLE_NAME = "product_category";

    public String selectProductCategoryByIds(Map<String, Integer[]> ids) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ids.get("ids").length; i++) {
            sb.append(ids.get("ids")[i]);
            if (i != ids.get("ids").length - 1)
                sb.append(',');
        }
        return new SQL() {{
            SELECT("category_id,category_name,category_type,create_time,update_time");
            FROM(TABLE_NAME);
            WHERE("category_id in (" + sb + ")");
        }}.toString();
    }

    public String insertForProductCategory(ProductCategory productCategory) {
        return new SQL() {{
            INSERT_INTO(TABLE_NAME);
            VALUES("category_name", "#{categoryName}");
            VALUES("category_type", "#{categoryType}");
        }}.toString();
    }

    public String updateForProductCategory(ProductCategory productCategory) {
        return new SQL() {{
            UPDATE(TABLE_NAME);
            if (productCategory.getCategoryName() != null)
                SET("category_name = #{categoryName}");
            if (productCategory.getCategoryType() != null)
                SET("category_type = #{categoryType}");
            WHERE("category_id = #{categoryId}");
        }}.toString();
    }
}
