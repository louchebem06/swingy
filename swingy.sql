CREATE TABLE `heros` (
  `id` int NOT NULL,
  `name` text NOT NULL,
  `class` text NOT NULL,
  `lvl` int NOT NULL,
  `xp` double NOT NULL,
  `weaponName` text,
  `armorName` text,
  `helmName` text,
  `weaponValue` double DEFAULT NULL,
  `armorValue` double DEFAULT NULL,
  `helmValue` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `heros`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `heros`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;
COMMIT;
