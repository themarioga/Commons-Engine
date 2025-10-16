package org.themarioga.engine.commons.dao.intf;

import org.themarioga.engine.commons.models.Lang;
import org.themarioga.engine.commons.models.Tag;

import java.util.List;

public interface TagDao {

    List<Tag> getTagsByLang(Lang lang);

}
