package com.report.manage.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.global.SysGlobals;
import com.report.home.bean.Announce;
import com.report.manage.dao.iface.AnnounceDao;

public class AnnounceBo {
    private DaoManager daoManager;

    private AnnounceDao dao;

    Logger logger = Logger.getLogger(AnnounceBo.class);

    public AnnounceBo() throws BaseException {
        this.daoManager = DaoConfig.getDaoManager();
        this.dao = (AnnounceDao) daoManager.getDao(AnnounceDao.class);
    }

    public int getAnnounceListSize(Announce announce) throws BaseException {
        return dao.selectAnnounceListSize(announce);
    }

    public List<Announce> getAnnounceList(Announce announce)
            throws BaseException {
        return dao.selectAnnounceList(announce);
    }

    public Announce getAnnounce(int id) throws BaseException {
        return dao.selectAnnounce(id);
    }

    public void addAnnounce(Announce announce) throws BaseException {
        if (announce.getIspublish() == 1) {
            dao.updateAnnounceUnpublish(0);
        }
        dao.insertAnnounce(announce);
    }

    public void modifyAnnounce(Announce announce) throws BaseException {
        if (announce.getIspublish() == 1) {
            dao.updateAnnounceUnpublish(0);
        }
        dao.updateAnnounce(announce);
    }

    public void modifyAnnounceIsvalid(Announce announce) throws BaseException {
        dao.updateAnnounceIsvalid(announce);
    }

    public void publishAnnounce(Announce announce) throws BaseException {
        dao.updateAnnounceUnpublish(announce.getId());
        dao.updateAnnouncePublish(announce);
    }

    public void removeAnnounce(int id) throws BaseException {
        dao.deleteAnnounce(id);
    }

    public List<Announce> getLatestAnnounceList() throws BaseException {
        int listRows = Integer.valueOf(SysGlobals
                .getSysConfig("index_page_size"));
        return dao.selectLatestAnnounceList(listRows);
    }

}