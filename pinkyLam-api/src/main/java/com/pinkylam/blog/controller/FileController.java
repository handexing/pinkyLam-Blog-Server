package com.pinkylam.blog.controller;

import com.pinkyLam.blog.dao.AttachDao;
import com.pinkyLam.blog.entity.Attach;
import com.pinkyLam.blog.utils.DateUtil;
import com.pinkyLam.blog.utils.FileUtil;
import com.pinkyLam.blog.vo.ErrorCode;
import com.pinkyLam.blog.vo.ExecuteResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月19日 下午2:33:19
 */

@RestController
@RequestMapping("file")
public class FileController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final String filePath = "upload/";

	@Autowired
	AttachDao attachDao;

	@RequestMapping("upload/{id}")
	public ExecuteResult<Boolean> upload(@RequestParam("file") MultipartFile[] multipartFiles, @PathVariable Long id)
			throws IOException {

		final ExecuteResult<Boolean> result = new ExecuteResult<>();
		final String basePath = FileUtil.getUplodFilePath();

		try {
			for (MultipartFile file : multipartFiles) {
				String fileName = file.getOriginalFilename();
				String dateStr = DateUtil.getDateFormatStr(new Date(), "yyyyMMdd");
				String realPath = filePath + dateStr + "/" + new Date().getTime()
						+ fileName.substring(fileName.lastIndexOf("."));
				String type = FileUtil.isImage(file.getInputStream()) ? Attach.UPLOAD_TYPE_IMAGE
						: Attach.UPLOAD_TYPE_FILE;
				File tempFile = new File(basePath + realPath);
				if (!tempFile.getParentFile().exists()) {
					tempFile.mkdirs();
				}
				if (!tempFile.exists()) {
					tempFile.createNewFile();
				}
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(tempFile));
				Attach attach = new Attach(id, fileName, type, realPath, new Date());
				attachDao.save(attach);
			}
			result.setSuccess(true);
		} catch (final Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCode.EXCEPTION.name());
			logger.error("", e);
		}
		return result;
	}
}
