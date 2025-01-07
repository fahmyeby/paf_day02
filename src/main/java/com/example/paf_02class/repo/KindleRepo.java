package com.example.paf_02class.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class KindleRepo {
    @Autowired private JdbcTemplate template;

    public void getTopAuthorAvgRating(int bookCount, int limit){
        SqlRowSet rs = template.queryForRowSet(Queries.sqlAuthorSummary, bookCount, limit);
        if(!rs.next()){
            System.out.println("No authors found");
            return;
        } String author = rs.getString("author");
        int count = rs.getInt("count(stars)");
        float bookAvg = rs.getFloat("avg(stars)");
        System.out.println(author + count + bookAvg);
    }
}
