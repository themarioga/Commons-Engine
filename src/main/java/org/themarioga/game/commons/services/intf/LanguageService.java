package org.themarioga.game.commons.services.intf;

import org.themarioga.game.commons.models.Lang;

import java.util.List;

public interface LanguageService {

    Lang getLanguage(String id);

    Lang getDefaultLanguage();

    List<Lang> getLangs();

}
