package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.home.bean.Announce;

public interface AnnounceDao {

    public int selectAnnounceListSize(Announce announce) throws BaseException;

    public List<Announce> selectAnnounceList(Announce announce)
            throws BaseException;

    public Announce selectAnnounce(int id) throws BaseException;

    public void insertAnnounce(Announce announce) throws BaseException;

    public void updateAnnounce(Announce announce) throws BaseException;

    public void updateAnnounceIsvalid(Announce announce) throws BaseException;

    public void updateAnnounceUnpublish(int id) throws BaseException;

    public void updateAnnouncePublish(Announce announce) throws BaseException;

    public void deleteAnnounce(int id) throws BaseException;

    public List<Announce> selectLatestAnnounceList(int listRows)
            throws BaseException;

}