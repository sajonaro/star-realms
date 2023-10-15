CREATE TABLE "Game" (
    "Id" SERIAL,
    "CratedDate" timestamp with time zone NOT NULL,
    "ClosedDate" timestamp with time zone NULL,
    "Winner"     text NULL,
    "Score"      int NULL,
    CONSTRAINT "PK_Games" PRIMARY KEY ("Id")
);


CREATE TABLE "Player" (
    "Id" uuid NOT NULL,
    "Name" timestamp with time zone NOT NULL,
    CONSTRAINT "PK_Player" PRIMARY KEY ("Id")
);