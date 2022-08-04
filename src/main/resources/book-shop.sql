-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Час створення: Сер 04 2022 р., 21:28
-- Версія сервера: 10.4.24-MariaDB
-- Версія PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База даних: `book-shop`
--

-- --------------------------------------------------------

--
-- Структура таблиці `author`
--

CREATE TABLE `author` (
  `id` bigint(20) NOT NULL,
  `fio` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп даних таблиці `author`
--

INSERT INTO `author` (`id`, `fio`) VALUES
(1, 'William Shakespeare'),
(7, 'Agatha Christie'),
(8, 'Eiichiro Oda'),
(9, 'J. K. Rowling'),
(10, 'Stephen King');

-- --------------------------------------------------------

--
-- Структура таблиці `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `quantyti` int(11) DEFAULT NULL,
  `title` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `url_image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп даних таблиці `book`
--

INSERT INTO `book` (`id`, `name`, `quantyti`, `title`, `url_image`, `price`) VALUES
(11, 'The Comedy of Errors', 15, 'The Comedy of Errors is a typical twin comedy drama and very Shakespearean.\r\n\r\nTwo sets of twins are separated by an atrocious storm. Two of them end up in one place, the other two in another, and herein lies the premise of our plot. The pairs of twins meet in the same town, and the comedy begins when the wife and friends of one of the twins mistake the newly arrived brother for the first mentioned.\r\n\r\nThe same drama happens to their servant, whose twin is the servant of his master’s twin. It’s really not that complicated when you read the list of characters.', 'https://www.infobooks.org/wp-content/uploads/2021/10/01.-The-Comedy-of-Errors-Author-William-Shakespeare.jpg?ezimgfmt=rs:296x395/rscb3/ng:webp/ngcb3', 25),
(12, 'Titus Andronicus', 64, 'Titus returns to Rome after long years of war. He has seen most of his sons die in the service of the Empire and only wants to retire. With him he brings the queen of the Goths and her children as prisoners.\r\n\r\nIt is not long before the Queen of the Goths seduces the new emperor, whose greedy ways have already caused problems for Titus and his family. Soon, Titus finds himself betrayed by the Empire he served so diligently, the Goths gradually driving him mad by killing, maiming or exiling the remnants of Titus’ family.', 'https://www.infobooks.org/wp-content/uploads/2021/10/02.-Titus-Andronicus-Author-William-Shakespeare.jpg?ezimgfmt=rs:296x395/rscb3/ng:webp/ngcb3', 37),
(13, 'The Murder of Roger Ackroyd: A Hercule Poirot Mystery', 36, 'Christie writes that The Murder of Roger Ackroyd is \"a general favourite.\" It was her third novel to feature detective Hercule Poirot, and in this story, Poirot retires to a small English village called King\'s Abbot. There, a wealthy widow named Mrs. Ferrars unexpectedly commits suicide—and the next day, her fiancé, Roger Ackroyd, is found stabbed to death. Poirot comes out of retirement at the request of Ackroyd\'s daughter Flora to solve the case.', 'https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1644597996-51K1Lt8ZrHL._SL500_.jpg?crop=1xw:1xh;center,top&resize=768:*', 15),
(14, 'Thirteen Problems (1932)', 7, 'This is the only short story collection on Christie\'s top 10 list, and all of the tales inside feature detective Miss Marple, marking her first appearance in Christie\'s fiction.\r\n\r\nThe blurb on the first edition of The Thirteen Problems reads: \"Miss Marple, that delightfully clever village spinster who solves the most amazing mysteries quietly and unobtrusively from her chair by the fireside, appears in each of the stories comprising The Thirteen Problems. Each story is a little masterpiece of detection, clever and ingenious, with just that added twist that only Agatha Christie can give.\"', 'https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1644598875-51VKniVPIUL._SL500_.jpg?crop=1xw:1xh;center,top&resize=768:*', 49),
(15, 'One Piece', 54, 'A new shonen sensation in Japan, this series features Monkey D. Luffy, whose main ambition is to become a pirate. Eating the Gum-Gum Fruit gives him strange powers but also invokes the fruit\'s curse: anybody who consumes it can never learn to swim. Nevertheless, Monkey and his crewmate Roronoa Zoro, master of the three-sword fighting style, sail the Seven Seas of swashbuck ...more', 'https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/9747/9781974732173.jpg', 55),
(16, 'Harry Potter and the Sorcerer\'s Stone', 80, 'This special edition of Harry Potter and the Sorcerer\'s Stone has a gorgeous new cover illustration by Kazu Kibuishi. Inside is the full text of the original novel, with decorations by Mary GrandPr . Harry Potter has never been the star of a Quidditch team, scoring points while riding a broom far above the ground. He knows no spells, has never helped to hatch a dragon, and has never worn a cloak of invisibility. All he knows is a miserable life with...', 'https://img.thriftbooks.com/api/images/m/faabc856a77b947351c8fcac6302a6d2816dc1f5.jpg', 25),
(17, 'Harry Potter and the Chamber of Secrets', 65, 'After 10 miserable years with his aunt and uncle, Harry Potter is invited to attend Hogwarts School of Witchcraft and Wizardry. Each book follows another year in Harry\'s education while more of his frightening destiny is revealed.', 'https://img.thriftbooks.com/api/images/i/m/FCE4B7402D12F41DBE38BE14A58EC257009EF055.jpg', 25),
(18, 'Harry Potter and the Order of the Phoenix', 45, 'A #1 New York Times Bestselling SeriesHarry Potter Series (Book 5)As Harry enters his fifth year at wizard school, Lord Voldemort\'s rise has opened a rift in the wizarding world between those who believe the truth about his return, and those who prefer to believe it\'s all madness and lies - just more trouble from Harry Potter. Add to this a host of other worries for Harry . . .', 'https://img.thriftbooks.com/api/images/m/dd8fcd0dcbebfd95ba86484c4fe418b6cf5eee17.jpg', 25),
(19, 'THE DARK TOWER VI: SONG OF SUSANNAH (2004)', 85, 'The pivotal sixth instalment in King’s bestselling epic fantasy saga provides the key to the quest that defines Roland’s life.\r\n\r\nIn the next part of their journey to the tower, Roland and his band of followers face adversity from every side: Susannah Dean has been taken over by a demon-mother and uses the power of Black Thirteen to get from the Mid-World New York City. But who is the father of her child? And what role will the Crimson King play?', 'https://stephenkingbooks.co.uk/wp-content/uploads/2015/05/5.png', 35),
(20, 'THE DARK TOWER V: WOLVES OF THE CALLA', 8, 'In the fifth novel in King’s bestselling epic fantasy series, the farming community in the fertile lands of the East has been warned the wolves are coming back. Four gunslingers, led by Roland of Gilead, are also coming their way. And the farmers of the Calla want to enlist some hard calibers.', 'https://stephenkingbooks.co.uk/wp-content/uploads/2015/05/3.png', 10);

-- --------------------------------------------------------

--
-- Структура таблиці `book_authors`
--

CREATE TABLE `book_authors` (
  `book_id` bigint(20) NOT NULL,
  `authors_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп даних таблиці `book_authors`
--

INSERT INTO `book_authors` (`book_id`, `authors_id`) VALUES
(11, 1),
(12, 1),
(14, 7),
(15, 8),
(16, 9),
(17, 9),
(18, 9),
(19, 10),
(20, 10),
(13, 7);

-- --------------------------------------------------------

--
-- Структура таблиці `book_publishers`
--

CREATE TABLE `book_publishers` (
  `book_id` bigint(20) NOT NULL,
  `publishers_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп даних таблиці `book_publishers`
--

INSERT INTO `book_publishers` (`book_id`, `publishers_id`) VALUES
(11, 2),
(12, 2),
(14, 2),
(15, 2),
(16, 2),
(17, 2),
(18, 2),
(19, 2),
(20, 2),
(13, 2);

-- --------------------------------------------------------

--
-- Структура таблиці `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп даних таблиці `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(21);

-- --------------------------------------------------------

--
-- Структура таблиці `publisher`
--

CREATE TABLE `publisher` (
  `id` bigint(20) NOT NULL,
  `country` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп даних таблиці `publisher`
--

INSERT INTO `publisher` (`id`, `country`, `name`) VALUES
(2, 'Ukraine', 'Ranok');

--
-- Індекси збережених таблиць
--

--
-- Індекси таблиці `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Індекси таблиці `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Індекси таблиці `book_authors`
--
ALTER TABLE `book_authors`
  ADD KEY `FK551i3sllw1wj7ex6nir16blsm` (`authors_id`),
  ADD KEY `FKs4xm7q8i3uxvaiswj1c35nnxw` (`book_id`);

--
-- Індекси таблиці `book_publishers`
--
ALTER TABLE `book_publishers`
  ADD KEY `FK12hfjay5qsaimcq79q3ylebca` (`publishers_id`),
  ADD KEY `FKhbouhfteb7bcyj5vommtss06n` (`book_id`);

--
-- Індекси таблиці `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`id`);

--
-- Обмеження зовнішнього ключа збережених таблиць
--

--
-- Обмеження зовнішнього ключа таблиці `book_authors`
--
ALTER TABLE `book_authors`
  ADD CONSTRAINT `FK551i3sllw1wj7ex6nir16blsm` FOREIGN KEY (`authors_id`) REFERENCES `author` (`id`),
  ADD CONSTRAINT `FKs4xm7q8i3uxvaiswj1c35nnxw` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

--
-- Обмеження зовнішнього ключа таблиці `book_publishers`
--
ALTER TABLE `book_publishers`
  ADD CONSTRAINT `FK12hfjay5qsaimcq79q3ylebca` FOREIGN KEY (`publishers_id`) REFERENCES `publisher` (`id`),
  ADD CONSTRAINT `FKhbouhfteb7bcyj5vommtss06n` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
