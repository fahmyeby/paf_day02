package com.example.paf_02class.repo;

public class Queries {
    public static final String sqlAuthorSummary = """
                        select author, count(stars), avg(stars)
            from kindle
            where author != ''
            group by author
            having count(stars) > ?
            order by count(stars) desc
            limit 10;
                        """;
}
