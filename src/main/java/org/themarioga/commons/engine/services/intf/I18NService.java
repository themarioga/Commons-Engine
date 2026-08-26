package org.themarioga.commons.engine.services.intf;

import org.themarioga.commons.engine.models.Lang;

import java.util.List;

public interface I18NService {
    Lang getLanguage(String lang);

    List<Lang> getLanguages();

    String get(String tag, String lang);

    String get(String tag);

    String get(String tag, Lang lang);
}
