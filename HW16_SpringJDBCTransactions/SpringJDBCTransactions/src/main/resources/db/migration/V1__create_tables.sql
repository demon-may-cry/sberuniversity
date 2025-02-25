CREATE TABLE IF NOT EXISTS dish
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name TEXT                                     NOT NULL,
    CONSTRAINT dish_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ingredients
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name TEXT                                     NOT NULL,
    CONSTRAINT ingredients_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS recipes
(
    id_dish            INTEGER NOT NULL,
    id_ingredients     INTEGER NOT NULL,
    count_ingredients TEXT  NOT NULL
);

ALTER TABLE recipes
    ADD CONSTRAINT recipes_id_dish_fkey FOREIGN KEY (id_dish)
        REFERENCES dish (id)
        ON UPDATE
            NO ACTION
        ON DELETE
            CASCADE;

ALTER TABLE recipes
    ADD CONSTRAINT recipes_id_ingredients_fkey FOREIGN KEY (id_ingredients)
        REFERENCES ingredients (id)
        ON UPDATE
            NO ACTION
        ON DELETE
            CASCADE;