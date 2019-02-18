SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `giphy_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(30) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `gif_image`
--

CREATE TABLE `gif_image` (
  `image_id` varchar(80) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `giphy_users`
--

CREATE TABLE `giphy_users` (
  `user_id` int(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `giphy_user_favorites`
--

CREATE TABLE `giphy_user_favorites` (
  `image_id` varchar(80) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`),
  ADD UNIQUE KEY `UKospaoj3uioj2l0ay84lvysnp4` (`user_id`,`category_name`);

--
-- Indexes for table `gif_image`
--
ALTER TABLE `gif_image`
  ADD PRIMARY KEY (`category_id`,`image_id`);

--
-- Indexes for table `giphy_users`
--
ALTER TABLE `giphy_users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_sagirwtxysko4n1ypmr90p78k` (`username`);

--
-- Indexes for table `giphy_user_favorites`
--
ALTER TABLE `giphy_user_favorites`
  ADD PRIMARY KEY (`user_id`,`image_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `giphy_users`
--
ALTER TABLE `giphy_users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `FK8w256rod3d6b0r6h6spxrlqqs` FOREIGN KEY (`user_id`) REFERENCES `giphy_users` (`user_id`);

--
-- Constraints for table `gif_image`
--
ALTER TABLE `gif_image`
  ADD CONSTRAINT `FKh44a3o70xv1f8h096s4w9mmgh` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

--
-- Constraints for table `giphy_user_favorites`
--
ALTER TABLE `giphy_user_favorites`
  ADD CONSTRAINT `FKkvqvj9q8piq4fudjkxo1vjj4r` FOREIGN KEY (`user_id`) REFERENCES `giphy_users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;