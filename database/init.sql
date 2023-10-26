CREATE TABLE game (
    "Id" SERIAL,
    "CratedDate" timestamp with time zone NOT NULL,
    "ClosedDate" timestamp with time zone NULL,
    "Winner"     text NULL,
    "Score"      int NULL,
    CONSTRAINT "PK_Games" PRIMARY KEY ("Id")
);


CREATE TABLE player (
    "Id" uuid NOT NULL,
    "Name" timestamp with time zone NOT NULL,
    CONSTRAINT "PK_Player" PRIMARY KEY ("Id")
);


ALTER DATABASE game_state
SET log_statement = 'all';