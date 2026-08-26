package org.themarioga.commons.engine.dao.intf;

import org.themarioga.commons.engine.models.Lang;
import org.themarioga.commons.engine.models.Tag;

import java.util.List;

public interface TagDao {

    List<Tag> getTagsByLang(Lang lang);

}
