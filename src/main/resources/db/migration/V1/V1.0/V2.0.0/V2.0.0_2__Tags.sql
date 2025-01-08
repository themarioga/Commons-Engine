-- v2.0.0_2 - Tags

create CAHGame t_tag
(
    tag varchar(255) not null,
    text longtext not null,
    lang_id char(2) not null,
    constraint t_tag_pk
        primary key (tag, lang_id),
    constraint t_tag_t_lang_id_fk
        foreign key (lang_id) references t_lang (id)
);

INSERT INTO t_tag (tag, lang_id, text) VALUES
      ('PLAYER_WELCOME', 'es', '¡Bienvenido! Acabo de añadirte a mi base de datos.\nSiempre que necesites ayuda puedes escribir /help\n¡Gracias por unirte!'),
      ('ALL_MESSAGES_SENT', 'es', 'Se han enviado todos los mensajes.'),
      ('GO_BACK', 'es', '← Volver'),
      ('ACCEPT', 'es', 'Aceptar'),
      ('CANCEL', 'es', 'Cancelar'),

      ('USER_LANG_CHANGE', 'es', 'Elige tu idioma:'),
      ('USER_LANG_CHANGED', 'es', 'Se ha cambiado el idioma.'),

      ('GAME_HELP', 'es', '	Bienvenido a la ayuda de {0} versión {1}\n\nPuedes consultar la ayuda en el siguiente enlace: {2}\n\nDisfrutad del bot y... ¡A jugar!\n\nCreado por {3}.'),
      ('GAME_CREATING', 'es', 'Un momentito, estoy creando la partida...'),
      ('GAME_CREATED_GROUP', 'es', '¡Ya he creado la partida!'),
      ('GAME_SELECT_MAX_PLAYERS', 'es', '\nSelecciona nº máximo de jugadores:'),
      ('GAME_SELECTED_MAX_PLAYER_NUMBER', 'es', 'El número máximo de jugadores es <b>{0}</b>.'),
      ('GAME_CREATED_CURRENT_PLAYER_NUMBER', 'es', 'Se han unido estos <b>{0}</b> jugadores:'),
      ('GAME_CREATED_CURRENT_VOTE_DELETION_NUMBER', 'es', '<b>{0}</b> jugador/es han votado borrar la partida.'),
      ('GAME_DELETED', 'es', 'Se ha borrado la partida.'),
      ('GAME_DELETION_USER', 'es', 'Se ha borrado la partida de {0}.'),
      ('GAME_DELETION_ALL', 'es', 'Se han borrado todas las partidas.'),
      ('GAME_DELETION_FORCED', 'es', 'Lo sentimos. Su partida ha sido borrada por la administración. Puede crear una partida nueva.'),
      ('GAME_LEAVE', 'es', 'Dejar la partida'),
      ('GAME_LEFT', 'es', 'Has dejado la partida'),
      ('GAME_JOIN_BUTTON', 'es', 'Unirse a la partida'),
      ('GAME_CONFIGURE_BUTTON', 'es', 'Configurar la partida'),
      ('GAME_START_BUTTON', 'es', 'Iniciar la partida'),
      ('GAME_DELETE_BUTTON', 'es', 'Borrar partida'),
      ('GAME_CHANGE_MAX_N_PLAYERS', 'es', 'Cambiar nº máximo de jugadores'),

      ('PLAYER_CREATED_GAME', 'es', 'He creado la partida en el grupo, puedes configurarla allí'),
      ('PLAYER_JOINING', 'es', 'Un momentito, estoy intentando unirte a la partida...'),
      ('PLAYER_JOINED', 'es', 'Te has unido a la partida.'),
      ('PLAYER_VOTED_DELETION', 'es', 'Has votado borrar la partida'),

      ('ERROR_COMMAND_SHOULD_BE_ON_PRIVATE', 'es', 'Este comando debe ser enviado por privado al bot.'),
      ('ERROR_COMMAND_SHOULD_BE_ON_GROUP', 'es', 'Este comando debe ser enviado en un grupo en el que esté el bot.'),
      ('ERROR_UNKNOWN', 'es', 'Error desconocido'),
      ('ERROR_USER_ALREADY_REGISTERED', 'es', 'Ya estas registrado. Consulta /help para mas información.'),
      ('ERROR_GAME_ALREADY_CREATED', 'es', 'Ya existe un juego activo en este grupo o el creador tiene un juego activo en otro grupo.'),
      ('ERROR_GAME_ALREADY_FILLED', 'es', 'Ya se ha superado el número máximo de jugadores.'),
      ('ERROR_GAME_ALREADY_STARTED', 'es', 'La partida ya está iniciada.'),
      ('ERROR_GAME_ONLY_CREATOR_CAN_CONFIGURE', 'es', 'Solo el creador de la partida puede configurarla.'),
      ('ERROR_GAME_ONLY_CREATOR_CAN_DELETE', 'es', 'Solo el creador de la partida puede borrarla.'),
      ('ERROR_GAME_ONLY_CREATOR_CAN_START', 'es', 'Solo el creador de la partida puede iniciarla.'),
      ('ERROR_GAME_DOESNT_EXISTS', 'es', 'No hay ninguna partida iniciada en este grupo.'),
      ('ERROR_GAME_USER_DOESNT_EXISTS', 'es', 'No estas registrado. Escríbeme /start por privado.'),
      ('ERROR_GAME_NOT_FILLED', 'es', 'La partida aun no ha llegado al numero mínimo de jugadores.'),
      ('ERROR_GAME_NOT_STARTED', 'es', 'La partida aun no se ha iniciado.'),
      ('ERROR_PLAYER_NO_GAMES', 'es', 'No tienes ninguna partida activa.'),
      ('ERROR_PLAYER_ALREADY_PLAYING', 'es', 'Ya estas participando en una partida.'),
      ('ERROR_PLAYER_ALREADY_JOINED', 'es', 'Ya estas participando en esta partida.'),
      ('ERROR_PLAYER_DOES_NOT_EXISTS', 'es', 'No estas unido a ninguna partida.'),
      ('ERROR_PLAYER_ALREADY_VOTED_DELETION', 'es', 'Ya has votado para borrar esta partida.');
