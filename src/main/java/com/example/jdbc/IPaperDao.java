package com.example.jdbc;

import com.example.basicLayout.Paper;

import java.util.List;

public interface IPaperDao {
    public void updatePaper(Paper paper);

    public List<Paper> getAllpaper();

    public List<Paper> getPaperbysubject(String subject);

    public Paper getpaperbyid(int paperid);

    public Paper getpaperbyname(String papername);
}
