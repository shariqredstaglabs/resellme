package com.resellme.resellme.utils;

public class NativeQueries {
    public static final String BRANDS_WITH_LATEST_CATS ="select b.id,b.name ," +
            "c.postDate as catalogPostDate , cat.title as catalogTitle from brand b join \n" +
            "(select max(post_date) as postDate , brand_id as brandId\n" +
            " from catalog group by brandId) c on b.id = c.brandId  join \n" +
            "catalog cat on b.id = cat.brand_id and c.postDate = cat.post_date \n" +
            "order by c.postDate desc";
}
