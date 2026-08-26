package org.themarioga.commons.engine.services.intf;

import org.themarioga.commons.engine.models.Tag;

import java.util.List;

public interface TagService {

    List<Tag> getTagsByLang(String lang);

}
