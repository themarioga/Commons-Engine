package org.themarioga.engine.commons.services.intf;

import org.themarioga.engine.commons.models.Lang;

import java.util.List;

public interface I18NService {
    Lang getLanguage(String lang);

    List<Lang> getLanguages();

    String get(String tag, String lang);

    String get(String tag);

    String get(String tag, Lang lang);
}
