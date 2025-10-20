package org.themarioga.engine.commons.services.intf;

import org.themarioga.engine.commons.models.Tag;

import java.util.List;

public interface TagService {

	List<Tag> getTagsByLang(String lang);

}
