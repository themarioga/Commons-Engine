package org.themarioga.commons.engine.services.intf;

import org.themarioga.commons.engine.models.Lang;

import java.util.List;

public interface LanguageService {

    Lang getLanguage(String id);

    Lang getDefaultLanguage();

    List<Lang> getLangs();

}
