package com.report.manage.bo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.global.SysGlobals;
import com.report.manage.bean.Matchapply;
import com.report.manage.bean.Matchinfo;
import com.report.manage.dao.iface.MatchapplyDao;

public class MatchapplyBo {
	private DaoManager daoManager;

	private MatchapplyDao dao;

	Logger logger = Logger.getLogger(MatchapplyBo.class);

	public MatchapplyBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (MatchapplyDao) daoManager.getDao(MatchapplyDao.class);
	}

	public List<Matchapply> getMatchapplyList4Home(Matchapply matchapply)
			throws BaseException {
		return dao.selectMatchapplyList4Home(matchapply);
	}

	public List<Matchapply> getMatchresultList4Home(Matchapply matchapply)
			throws BaseException {
		return dao.selectMatchresultList4Home(matchapply);
	}

	public int getMatchapplyListSize(Matchapply matchapply)
			throws BaseException {
		return dao.selectMatchapplyListSize(matchapply);
	}

	public List<Matchapply> getMatchapplyList(Matchapply matchapply)
			throws BaseException {
		return dao.selectMatchapplyList(matchapply);
	}

	public int getMatchresultListSize(Matchapply matchapply)
			throws BaseException {
		return dao.selectMatchresultListSize(matchapply);
	}

	public List<Matchapply> getMatchresultList(Matchapply matchapply)
			throws BaseException {
		return dao.selectMatchresultList(matchapply);
	}

	public Matchapply getMatchapply(int id) throws BaseException {
		return dao.selectMatchapply(id);
	}

	public List<Matchinfo> getMatchinfoList() throws BaseException {
		return dao.selectMatchinfoList();
	}

	public String saveFile(Matchapply matchapply) throws BaseException {
		String rootPath = matchapply.getRootPath().replace("\\", "/");
		String contextPath = matchapply.getContextPath();
		String filePath = SysGlobals.getSysConfig("filePath");
		String[] fileAllowFiles = SysGlobals.getSysConfig("fileAllowFiles")
				.split(",");
		int fileMaxSize = Integer.valueOf(SysGlobals
				.getSysConfig("fileMaxSize"));
		List<String> fileAllowList = Arrays.asList(fileAllowFiles);

		String savePath = rootPath + filePath;
		String originalPath = contextPath + filePath;

		FormFile file = matchapply.getUpfile();
		String originFileName = file.getFileName();
		String fileSuffix = originFileName.substring(originFileName
				.lastIndexOf(".") + 1);
		String fileName = System.currentTimeMillis() + "." + fileSuffix;
		String physicalPath = savePath + fileName;
		originalPath = originalPath + fileName;

		int fileSize = file.getFileSize();
		if (fileSize == 0) {
			return null;
		}
		if (!fileAllowList.contains(fileSuffix)) {
			return "MatchapplyAction.addMatchapply.filenotallow";
		}
		if (fileSize > fileMaxSize) {
			return "MatchapplyAction.addMatchapply.filesizeover";
		}
		if (fileSize > 0) {
		    matchapply.setPhysicalpath(physicalPath);
			matchapply.setFilepath(originalPath);
			matchapply.setFilename(originFileName);
			matchapply.setFilesize(fileSize);
			FileOutputStream fos = null;
			try {
				File f = new File(savePath);
				if (!f.exists()) {
					f.mkdirs();
				}
				byte[] fileData = file.getFileData();
				fos = new FileOutputStream(physicalPath);
				fos.write(fileData);
				fos.flush();
			} catch (IOException e) {
				e.printStackTrace();
				return "MatchapplyAction.addMatchapply.filesaveerror";
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	public void addMatchapply(Matchapply matchapply) throws BaseException {
		dao.insertMatchapply(matchapply);
	}

	public void modifyMatchapply(Matchapply matchapply) throws BaseException {
		dao.updateMatchapply(matchapply);
	}

	public void removeMatchapply(int id) throws BaseException {
		dao.deleteMatchapply(id);
	}

	public void auditMatchapply(Matchapply matchapply) throws BaseException {
		dao.updateMatchapplyState(matchapply);
	}

	public int getMatchresultCount(Matchapply matchapply) throws BaseException {
		return dao.selectMatchresultCount(matchapply);
	}

	public void addMatchresult(Matchapply matchapply) throws BaseException {
		dao.insertMatchresult(matchapply);
	}

	public void modifyMatchresult(Matchapply matchapply) throws BaseException {
		dao.updateMatchresult(matchapply);
	}

	public List<Matchapply> getMatchapplyFileList(String ids)
			throws BaseException {
		String idsNew = "'" + ids + "'";
		idsNew = idsNew.replace(",", "','");
		return dao.selectMatchapplyFileList(idsNew);
	}

}