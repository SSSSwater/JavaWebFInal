package com.example.jdbc;

import com.example.basicLayout.Paper;
import com.example.basicLayout.Question;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class PaperDaoImp extends JdbcDaoSupport implements IPaperDao{

    @Override
    public void updatePaper(Paper paper) {
        String sql="insert into paper (paperid,subject,titlenum,exammark)value('"+paper.getPaperid()+"','"+paper.getSubject()+"','"+paper.getTitlenum()+"','"+paper.getExammark()+"')";
        getJdbcTemplate().execute(sql);
    }

    @Override
    public List<Paper> getAllpaper() {
        List<Paper> papers= getJdbcTemplate().query("select * from paper ",new BeanPropertyRowMapper<Paper>(Paper.class));
        return papers;
    }

    @Override
    public List<Paper> getPaperbysubject(String subject) {
        List<Paper> papers= getJdbcTemplate().query("select * from paper where subject =",new BeanPropertyRowMapper<Paper>(Paper.class),subject);
        return papers;
    }

    @Override
    public Paper getpaperbyid(int paperid) {
        List<Paper> papers= getJdbcTemplate().query("select * from paper where id = ?",new BeanPropertyRowMapper<Paper>(Paper.class),paperid);
        return papers.isEmpty()?null:papers.get(0);
    }
}
