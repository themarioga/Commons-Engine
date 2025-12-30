package org.themarioga.engine.commons.enums;

public enum CommonErrorEnum implements ErrorEnum {
    UNKNOWN_ERROR(0L, "Error desconocido"),
    USER_EMPTY(1L, "El usuario no puede ser nulo"),
    USER_ID_EMPTY(2L, "El id de usuario no puede ser nulo"),
    USER_NAME_EMPTY(3L, "El nombre de usuario no puede estar vacío"),
    USER_NOT_FOUND(4L, "El usuario no se ha encontrado"),
    USER_NOT_ACTIVE(5L, "El usuario no está activo"),
    USER_ALREADY_EXISTS(6L, "El usuario ya existe"),
    ROOM_EMPTY(7L, "La sala no puede ser nula"),
    ROOM_ID_EMPTY(8L, "El id de la sala no puede ser nulo"),
    ROOM_NAME_EMPTY(9L, "El nombre de la sala no puede estar vacía"),
    ROOM_NOT_FOUND(10L, "La sala no se ha encontrado"),
    ROOM_NOT_ACTIVE(11L, "La sala no está activa"),
    ROOM_ALREADY_EXISTS(12L, "La sala ya existe"),
    GAME_NOT_FOUND(13L, "Juego no encontrado"),
    GAME_NOT_CONFIGURED(14L, "Juego no configurado"),
    GAME_NOT_ENDING(15L, "Juego en marcha"),
    GAME_NOT_FILLED(16L, "Juego no completado"),
    GAME_ALREADY_EXISTS(17L, "Juego ya creado"),
    GAME_ALREADY_CONFIGURED(18L, "Juego ya configurado"),
    GAME_ALREADY_FILLED(19L, "Juego lleno"),
    GAME_ALREADY_STARTED(20L, "Juego ya iniciado"),
    GAME_CREATOR_ALREADY_EXISTS(21L, "El creador ya tiene un juego en marcha"),
    GAME_CREATOR_CANNOT_LEAVE(22L, "El creador no puede dejar el juego"),
    GAME_ONLY_CREATOR_CAN_PERFORM_ACTION(23L, "Solo el creador puede realizar esta acción"),
    PLAYER_NOT_FOUND(24L, "Jugador no encontrado"),
    PLAYER_ALREADY_EXISTS(25L, "Jugador ya existente"),
    PLAYER_ALREADY_VOTED_DELETION(26L, "El jugador ya ha votado"),
    PLAYER_CANNOT_VOTE_DELETION(27L, "El jugador no puede votar");

    final Long errorCode;
    final String errorDesc;

    CommonErrorEnum(Long errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    @Override
    public Long getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorDesc() {
        return errorDesc;
    }

    public static CommonErrorEnum getByCode(Long errorCode) {
        for (CommonErrorEnum commonErrorEnum : values()) {
            if (commonErrorEnum.getErrorCode().equals(errorCode)) return commonErrorEnum;
        }

        return null;
    }

    public static CommonErrorEnum getByDesc(String errorDesc) {
        for (CommonErrorEnum commonErrorEnum : values()) {
            if (commonErrorEnum.getErrorDesc().equals(errorDesc)) return commonErrorEnum;
        }

        return null;
    }

}
