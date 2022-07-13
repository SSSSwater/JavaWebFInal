package com.example.jdbc;

import com.example.basicLayout.Paper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PaperDaoImp extends JdbcDaoSupport implements IPaperDao{

    @Override
    public void updatePaper(Paper paper) {
        String sql="insert into paper (paperid,subject,titlenum,exammark)value('"+paper.getPaperid()+"','"+paper.getSubject()+"','"+paper.getTitlenum()+"','"+paper.getExammark()+"')";
        getJdbcTemplate().execute(sql);
    }
}
