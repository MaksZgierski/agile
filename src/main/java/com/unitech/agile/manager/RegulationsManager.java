package com.unitech.agile.manager;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.unitech.agile.tools.CommonTools;

@Service
public class RegulationsManager {

	@Value("classpath:static/regulations.txt")
	Resource resource;
	
	public String getRegulations() {
		try {
			final InputStream resourceInputStream = resource.getInputStream();
			return CommonTools.convert(resourceInputStream);
		} catch(Exception e) {
			return null;
		}
	}
}
