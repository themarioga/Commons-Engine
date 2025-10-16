package org.themarioga.engine.commons.services.intf;

import org.themarioga.engine.commons.models.Lang;

import java.util.List;

public interface LanguageService {

    Lang getLanguage(String id);

    Lang getDefaultLanguage();

    List<Lang> getLangs();

}
