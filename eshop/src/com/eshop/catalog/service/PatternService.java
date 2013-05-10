/**
 * 
 */
package com.eshop.catalog.service;

import java.util.Set;

import com.eshop.catalog.model.Pattern;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
public interface PatternService {

	public Pattern addPattern(Pattern pattern);

	public Pattern getPatternById(Long patternId);

	public Pattern updatePattern(Pattern pattern);

	public void deletePattern(Long patternId);

	public Set<Pattern> getAllPatterns();

	public Pattern createPattern(String patternName, Media logoImage);

}
