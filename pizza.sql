-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2020. Máj 30. 00:01
-- Kiszolgáló verziója: 10.4.11-MariaDB
-- PHP verzió: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `pizza`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `drink`
--

CREATE TABLE `drink` (
  `drink_id` int(40) NOT NULL,
  `drink_name` varchar(100) NOT NULL,
  `cost` int(20) NOT NULL,
  `img` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `drink`
--

INSERT INTO `drink` (`drink_id`, `drink_name`, `cost`, `img`) VALUES
(1, 'Health Potion', 800, 'health_porion'),
(2, 'Mana Potion', 700, 'mana_potion'),
(3, 'Nuka Cherry', 1100, 'nuka_cherry'),
(4, 'Nuka Cola', 1200, 'nuka_cola'),
(5, 'Nuka Quantum', 1100, 'nuka_quantum');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `orders`
--

CREATE TABLE `orders` (
  `order_id` int(70) NOT NULL,
  `user_id` int(30) NOT NULL,
  `pizza_id` int(30) DEFAULT NULL,
  `drink_id` int(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `orders`
--

INSERT INTO `orders` (`order_id`, `user_id`, `pizza_id`, `drink_id`) VALUES
(40, 1, 1, NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `pizza`
--

CREATE TABLE `pizza` (
  `pizza_id` int(100) NOT NULL,
  `pizza_name` varchar(40) NOT NULL,
  `descrip` varchar(200) NOT NULL,
  `cost` int(10) NOT NULL,
  `img` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `pizza`
--

INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `descrip`, `cost`, `img`) VALUES
(1, 'Sajtos pizza', 'pizzaszósz, trappista sajt, oregánó', 1340, 'sajtos'),
(2, 'Szkafanderes', 'pizzaszósz, sonka, paradicsomkarika, trappista sajt', 1690, 'szakafanderes'),
(3, 'Rakéta', 'vastag tészta, csípős pizzaszósz, bacon, lilahagyma, kukorica, vörösbab, mozzarella', 1690, 'rakéta'),
(4, 'Fokhagymás - pulykacsíkos pizza', 'tejfölös alap, pulykasonka csíkok, fokhagyma, trappista sajt', 1450, 'foghagymás_pulyka'),
(5, 'Donatello', 'vékony tészta, főzött paradicsomszósz, füstölt főtt lapocka, fekete olívabogyó, parmezán sajt, feta sajt, mozzarella', 1990, 'donatello'),
(6, 'Michelangelo', 'vékony tészta, főzött paradicsomszósz, szalámi, ruccola, mozzarella', 1990, 'michelangelo'),
(7, 'Leonardo', 'vékony tészta, főzött paradicsomszósz, Fekete erdei sonka, mozzarella', 1990, 'leonardo'),
(8, 'Raffaello', 'vékony tészta, főzött paradicsomszósz, paprikás szalámi, lilahagyma, mozzarella, chili paprika', 1990, 'rafaello'),
(9, 'Kolbászos pizza', 'pizzaszósz, kolbász, lilahagyma, trappista sajt', 1500, 'kolbászos'),
(10, 'Hawaii gyros pizza', 'tzatziki alap, gyros hús, trappista sajt, ananász', 1690, 'hawai'),
(13, 'Sajtos - gombás pizza', 'pizzaszósz, gomba, trappista sajt, oregánó', 1500, 'sajtos_gombás'),
(14, '4 sajtos pizza', 'pizzaszósz, trappista sajt, parmezán sajt, füstölt sajt, feta sajt', 1300, '4sajtos');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `role`
--

CREATE TABLE `role` (
  `role_id` int(10) NOT NULL,
  `role_type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `role`
--

INSERT INTO `role` (`role_id`, `role_type`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

CREATE TABLE `user` (
  `user_id` int(100) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `address` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `email`, `address`) VALUES
(1, '3sm4rt', 'asd', 'tapai43@gmail.com', 'Hullam utca 2/b');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user_roles`
--

CREATE TABLE `user_roles` (
  `id` int(20) NOT NULL,
  `user_id` int(20) NOT NULL,
  `role_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `user_roles`
--

INSERT INTO `user_roles` (`id`, `user_id`, `role_id`) VALUES
(1, 1, 2);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `drink`
--
ALTER TABLE `drink`
  ADD PRIMARY KEY (`drink_id`);

--
-- A tábla indexei `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- A tábla indexei `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`pizza_id`);

--
-- A tábla indexei `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- A tábla indexei `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- A tábla indexei `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `drink`
--
ALTER TABLE `drink`
  MODIFY `drink_id` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT a táblához `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(70) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT a táblához `pizza`
--
ALTER TABLE `pizza`
  MODIFY `pizza_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT a táblához `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT a táblához `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
