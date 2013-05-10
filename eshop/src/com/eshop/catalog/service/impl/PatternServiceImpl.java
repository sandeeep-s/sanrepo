/**
 * 
 */
package com.eshop.catalog.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.catalog.model.Pattern;
import com.eshop.catalog.persistence.PatternDAO;
import com.eshop.catalog.service.PatternService;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
@Service("patternService")
@Transactional(propagation = Propagation.REQUIRED)
public class PatternServiceImpl implements PatternService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatternServiceImpl.class);

	@Inject
	private PatternDAO patternDAO = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.etyre.vehicle.service.VehicleService#addPattern(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Pattern addPattern(Pattern pattern) {
		return patternDAO.makePersistent(pattern);
	}

	@Override
	public Pattern getPatternById(Long patternId) {
		return patternDAO.findById(patternId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public Pattern updatePattern(Pattern pattern) {
		return patternDAO.saveOrUpdate(pattern);
	}

	@Override
	public void deletePattern(Long patternId) {
		Pattern pattern = patternDAO.getReference(patternId);
		patternDAO.delete(pattern);
	}

	@Override
	public Set<Pattern> getAllPatterns() {
		return patternDAO.findAllUnique();
	}

	@Override
	public Pattern createPattern(String name, Media logoImage) {
		Pattern pattern = new Pattern();
		return pattern;
	}

}
