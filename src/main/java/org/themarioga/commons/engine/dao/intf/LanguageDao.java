package org.themarioga.commons.engine.dao.intf;

import org.themarioga.commons.engine.models.Lang;

import java.util.List;

public interface LanguageDao {

    Lang getLanguage(String id);

    boolean checkLanguageExists(String id);

    List<Lang> getLanguages();

}
