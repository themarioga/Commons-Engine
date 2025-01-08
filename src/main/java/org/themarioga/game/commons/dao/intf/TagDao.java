package org.themarioga.game.commons.dao.intf;

import org.themarioga.game.commons.models.Lang;
import org.themarioga.game.commons.models.Tag;

import java.util.List;

public interface TagDao {

    List<Tag> getTagsByLang(Lang lang);

}
