-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 05, 2020 at 09:22 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id14299575_group5hngdatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `Department`
--

CREATE TABLE `Department` (
  `department_id` bigint(20) UNSIGNED NOT NULL,
  `department_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Department`
--

INSERT INTO `Department` (`department_id`, `department_name`) VALUES
(1, 'Bathrooms'),
(2, 'Appliances'),
(3, 'Clothing'),
(4, 'Concretors'),
(5, 'Fencing'),
(6, 'Gutter and Roofing'),
(7, 'Hot Water'),
(8, 'Industrial Supplies'),
(9, 'Lighting'),
(10, 'Lock and Doors'),
(11, 'Plumbing Supplies'),
(12, 'RDC'),
(13, 'Print and Hardware'),
(14, 'Sheet Materials'),
(15, 'Sinks, Tubs and Laundry'),
(16, 'Tap'),
(17, 'Timber Supplies '),
(18, 'Tanks'),
(19, 'Wood Panels'),
(20, 'Transport'),
(21, 'Kitchen Appliances'),
(22, 'Ext 1173'),
(23, 'Building Supplies');

-- --------------------------------------------------------

--
-- Table structure for table `Department_Phone_Number`
--

CREATE TABLE `Department_Phone_Number` (
  `department_phone_number_id` bigint(20) NOT NULL,
  `department_phone_number` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This for Brookvale''s numbers';

--
-- Dumping data for table `Department_Phone_Number`
--

INSERT INTO `Department_Phone_Number` (`department_phone_number_id`, `department_phone_number`) VALUES
(1, '02 8456 1300'),
(2, '02 8456 1366'),
(3, '02 8456 1377'),
(4, '02 8456 1270'),
(5, '02 8456 1344'),
(6, '02 8456 1388'),
(7, '02 8456 1288'),
(8, '02 8456 1292'),
(9, '02 8456 1144'),
(10, '02 8456 1311'),
(11, '02 8456 1295'),
(12, '02 8456 1266'),
(13, '02 8456 1166'),
(14, '02 8456 1133'),
(15, '02 8456 4600'),
(16, '02 8456 1199'),
(17, '02 8456 1390'),
(18, '02 8456 1366'),
(19, '02 8456 1215'),
(20, '02 8456 1333'),
(21, '02 8456 1122');

-- --------------------------------------------------------

--
-- Table structure for table `Location_Department`
--

CREATE TABLE `Location_Department` (
  `store_id_fk` bigint(20) UNSIGNED NOT NULL,
  `department_id_fk` bigint(20) UNSIGNED NOT NULL,
  `department_phone_number_fk` bigint(20) DEFAULT NULL COMMENT 'This was to reflect the fact that Brookvale had phone numbers for their department.'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Location_Department`
--

INSERT INTO `Location_Department` (`store_id_fk`, `department_id_fk`, `department_phone_number_fk`) VALUES
(2, 1, NULL),
(2, 2, NULL),
(2, 3, NULL),
(2, 4, NULL),
(2, 5, NULL),
(2, 6, NULL),
(2, 7, NULL),
(2, 8, NULL),
(2, 9, NULL),
(2, 10, NULL),
(2, 11, NULL),
(2, 12, NULL),
(2, 13, NULL),
(2, 14, NULL),
(2, 15, NULL),
(2, 16, NULL),
(2, 23, NULL),
(3, 1, NULL),
(3, 6, NULL),
(3, 11, NULL),
(3, 16, NULL),
(3, 18, NULL),
(3, 21, NULL),
(4, 11, NULL),
(4, 23, NULL),
(1, 1, 1),
(1, 4, 3),
(1, 5, 4),
(1, 6, 5),
(1, 7, 6),
(1, 8, 7),
(1, 9, 8),
(1, 10, 9),
(1, 11, 10),
(1, 12, 11),
(1, 3, 13),
(1, 13, 13),
(1, 23, 13),
(1, 14, 14),
(1, 2, 15),
(1, 15, 15),
(1, 16, 16),
(1, 17, 17),
(1, 18, 19),
(1, 19, 20),
(1, 20, 21);

-- --------------------------------------------------------

--
-- Table structure for table `Products`
--

CREATE TABLE `Products` (
  `product_id` bigint(20) UNSIGNED NOT NULL COMMENT 'primary key',
  `product_name` text CHARACTER SET utf8 NOT NULL,
  `price` float NOT NULL,
  `image_url` text DEFAULT NULL COMMENT 'image''s url',
  `weight` float NOT NULL,
  `width` float NOT NULL,
  `height` float NOT NULL,
  `feature` text NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Products`
--

INSERT INTO `Products` (`product_id`, `product_name`, `price`, `image_url`, `weight`, `width`, `height`, `feature`, `description`) VALUES
(1, 'Earthen Ware Pipes & Fittings', 10, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/817/1568/DWV_PIPE_50MM__44063.1411344649.png?c=2', 3.77, 6, 5, 'n/a', 'DWV Pipe 50MMX6M.\r\n\r\n \r\n\r\nDWV Pipe is used for drain, waste and vent applications. It is used in a variety of areas mainly removing sewage and grey water from buildings. \r\n\r\nAll of the 6m pipe is certified to Australian Standards.\r\n\r\n '),
(2, 'Easy Craft', 26, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/640w/products/291/479/TaubmansEasyCoat15LWhiteCeilingPaint__29765.1404966024.jpg?c=2&imbypass=on', 16, 31, 31, 'Protection against mould, mildew and fungus\r\nSuitable for ceilings in high humidity and damp areas\r\nWater based and 100% acrylic', 'Taubmans Easy Coat 15L White Ceiling Paint.\r\n\r\nTaubmans Easy Coat Ceiling is a high quality, durable interior acrylic ceiling paint. Containing Microban, an antimicrobial protection against the growth of mould, mildew and fungus, Taubmans Interior Easy Coat is ideal for use in high humidity and damp areas of the home or office. Microban prevents mould and mildew spores from growing on surfaces for better air quality.\r\n\r\n '),
(3, 'Eco-Fan - Floor Ventilation', 35, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/1171/2168/Bathe_Kaldewei_Superplan_Shower_Floor_01_385K_1__90928.1423458573.JPG?c=2&imbypass=on', 17, 80, 75, 'Exclusive, Elegant Style\r\nWith a depth of 2.5 cm extremly flat and suitable for installing flush with the floor\r\nMade of Kaldewei steel enamel 3.5mm', 'Bathe Kaldewei Superplan Shower Floor 01-385K.'),
(4, 'Eco Fans', 24, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/1285/2473/Martec_Tetra_Exhaust_Fan_White_Square_250MM_MXFT25W_1__79150.1432015091.JPG?c=2&imbypass=on', 4, 29, 18, '3 year replacement warranty \r\nExcellent airflow 240 m3 per hour \r\nLong life ball bearing motor \r\nQuiet operation \r\nTurbo fan blade \r\nDuct outlet (100mm Diameter) \r\nExhaust fan with side ducting \r\nRemovable grill \r\nWhite or silver stainless steel centre plates', 'Martec Tetra Exhaust Fan White Square 250MM MXFT25W.\r\n\r\nThe Tetra Exhaust fan incorporates modern, sleek design with a powerful 240 cubic metre per hour extraction fan. Perfect for small bathroom spaces.'),
(5, 'Edmonds - Roof Vents', 27, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/726/1278/Velux_Skylights_Flat_RoofFCM1430_460X870__53778.1410326918.JPG?c=2&imbypass=on', 10, 97, 97, 'The brilliantly simple FCM flat roof skylight \r\nincorporates the VELUX High Performance laminated \r\nglazing unit and an all metal, insulated exterior frame.\r\n• Unlike acrylic or polycarbonate – laminated glass will\r\nnot fade nor discolour over time.\r\n• The smooth exterior gives not only\r\na lower profile on the roof, but also\r\nprovides a “cool” daylighting\r\nsolution by effectively blocking\r\nheat build up and UV rays.\r\n• High performance double glazing\r\nas standard – blocks approx 75%\r\nof radiant heat and gives approx\r\n99% protection from UV rays.\r\n• NEAT™ coating on outer pane\r\nreduces cleaning frequency. \r\n• Maintenance-free anodized\r\nheavy-gauge aluminium frame\r\nwithstands the extremes of the\r\nAustralian climate.\r\n\r\n ', 'Velux Skylights Flat Roof FCM3434 970X970.'),
(6, 'Edmonds Roof Vent System', 22, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/726/1278/Velux_Skylights_Flat_RoofFCM1430_460X870__53778.1410326918.JPG?c=2&imbypass=on', 10, 127, 127, 'The brilliantly simple FCM flat roof skylight \r\nincorporates the VELUX High Performance laminated \r\nglazing unit and an all metal, insulated exterior frame.\r\n• Unlike acrylic or polycarbonate – laminated glass will\r\nnot fade nor discolour over time.\r\n• The smooth exterior gives not only\r\na lower profile on the roof, but also\r\nprovides a “cool” daylighting\r\nsolution by effectively blocking\r\nheat build up and UV rays.\r\n• High performance double glazing\r\nas standard – blocks approx 75%\r\nof radiant heat and gives approx\r\n99% protection from UV rays.\r\n• NEAT™ coating on outer pane\r\nreduces cleaning frequency. \r\n• Maintenance-free anodized\r\nheavy-gauge aluminium frame\r\nwithstands the extremes of the\r\nAustralian climate.', 'Velux Skylights Flat Roof FCM4646 1275X1275.\r\n\r\n'),
(7, 'Electric Conduit', 21, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/947/1742/AquaMAX_125L_Electric_Hot_Water_System__21997.1414363313.jpg?c=2&imbypass=on', 49, 48, 134, 'Electric 125L Delivery\r\nVitreous Enamel Tank\r\n5 Year Cylinder Warranty1\r\nDual Inlets & Outlets\r\nInternal/External Installation\r\nDual PTR Valve Fittings', 'AquaMAX 125L Electric Hot Water System.\r\n\r\nEasy Install With Dual PTR Fittings, Suits Small Homes.\r\n\r\nDesigned for small homes and apartments, our 125 Litre water heater is MEPS compliant and is the largest unit with dual PTR fittings for easy installation. A small unit for the small household.'),
(8, 'Electric Storage Tanks', 24, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/946/1741/AquaMAX_80L_Electric_Hot_Water_System__32839.1414363251.jpg?c=2&imbypass=on', 35, 48, 94, 'Electric 80L Delivery\r\nVitreous Enamel Tank\r\n5 Year Cylinder Warranty1\r\nDual Inlets & Outlets\r\nInternal/External Installation\r\nDual PTR Valve Fittings ', 'AquaMAX 80L Electric Hot Water System.\r\n\r\nA Very Popular Choice For Compact Storage Spaces.\r\n\r\nThis small unit features Dual PTR valve fittings with 80L hot water delivery for 1-2 people. Suitable for small 1 bedroom apartments or homes and can be installed indoors.'),
(9, 'Electric Leads', 47, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/947/1742/AquaMAX_125L_Electric_Hot_Water_System__21997.1414363313.jpg?c=2&imbypass=on', 45, 63, 144, 'Can resist corrosion for longer than conventional vitreous enamel cylinders\r\nNo sacrificial anode, for reduced lifetime service costs\r\nUp to 40% lighter than comparable size vitreous enamel cylinders, for easier installation\r\nHigher temperature settings are possible (Electric models) for even hotter, hot water\r\nSuperior energy efficiency', 'Rheem 250L Electric Stainless Steel Hot Water System.'),
(10, 'Electric Products - HPM', 45, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/1575/3339/DHBE__73560.1550445486.jpg?c=2&imbypass=on', 5.5, 22.5, 47.8, 'Electronically controlled\r\nBare wire heating system\r\n3L/min switch on flow rate\r\n30-60°C temperature adjustment\r\nElectric safety system with air detection', 'DHB-E 3 Phase Electric Instantaneous 60°C Water Heater 28kW'),
(11, 'Electrodes - welding', 36, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/640w/products/1734/3733/Bosch-BulldogXtreme-SDSplus-hammer-drill-bit-7X-22x200x250-1__19205.1594857598.JPG?c=2&imbypass=on', 0.31, 2.2, 25, 'Full-carbide 4-cutter head is composed of the highest-quality carbide for exceptional impact resistance\r\nBosch´s diffusion welding technology (IDS) provides strong bond between head and flute\r\n4-flute design with wide channels reduces wear on the bit by allowing for effective dust removal', 'Bosch BulldogXtreme SDSplus Hammer Drill Bit 7X 22x200x250.\r\n\r\nThe BulldogXtreme SDS plus Drill Bit provides an outstanding lifetime when drilling in reinforced concrete. Its full-carbide 4-cutter head is composed of the highest-quality carbide, which fortifies the head and provides exceptional impact resistance. Its consistent distribution of drilling power guarantees there is no power loss, which increases the overall lifetime. Bosch´s unique diffusion welding technology (IDS) provides a strong bond between head and flute. Moreover, the 4-flute design with wide channels reduces wear on the bit by allowing for effective dust removal. This bit is intended for hammer drilling in masonry, concrete and reinforced concrete. It is compatible with rotary hammers with SDS plus chucks.\r\n\r\nTo achieve accurate results, the visibility of the wear mark indicates if the diameter of the hole is still in tolerance for metal anchor setting. As proof of quality, the drill bit bears the test mark of the PGM Masonry Drill Bit Association Board, guaranteeing compliance with tight tolerances, exact drilling and the firm hold of fixings. It is made in Germany.\r\n\r\n '),
(12, 'Elements', 37, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/1567/3325/WWK302__90062.1549429181.jpg?c=2&imbypass=on', 135, 69, 192, '302L tank\r\nOperates in cold climates\r\nIndoor or outdoor installation \r\nIdeal to operate with solar PV system\r\n1.7kW power consumption smart element\r\n ', 'WWK 302 Litre Heat Pump Smart Element Water Heater.'),
(13, 'Emerclad', 29, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/883/1673/DRIZORO_MAXJOINT_ELASTIC__51277.1412056801.JPG?c=2', 10, 35, 30, 'Sealing expansion joints with an in service joint movement up to 15%.\r\nJoints in permanent immersion in pipelines, water reservoirs, water treatment plants, etc.\r\nJoints of concrete prefabricated elements and ceramic in facades and building construction\r\nSealing of active cracks in concrete and masonry.\r\nPointing mortar on substrates subject to movement.\r\nAdvantages\r\nAllows movement capability of joint up to 15%.\r\nVery high weather resistant and durability. No maintenance required.\r\nExcellent adhesion on damp surfaces. No bonding agentneeded.\r\nNon slump on vertical joints.\r\nSuitable for joints in permanent contact with water\r\nEasy to apply and finish.\r\nNon toxic and non flammable, environmentally friendly.\r\n• Can be painted once cured with the desired colour\r\n\r\n ', 'DRIZORO MAXJOINT ELASTIC 10KG TUB.'),
(14, 'End Millis', 4, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/834/1587/SW_BEND_FF_90MM_X_45_DEG__48250.1411426896.jpg?c=2&imbypass=on', 0.08, 9.5, 14, 'For Stormwater use\r\nConnect pipe with solvent Cement\r\nComplies with AS/NZS1260\r\n ', 'Storm Water BEND F&F 90MM X 45 DEG.\r\n\r\n \r\n\r\nIplex 90mm Female & Female Elbow 45 Deg is for 75mm Stormwater pipe. Connect pipe with solvent cement. Complies with AS/NZS1254'),
(15, 'Entrance Doors', 44, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/1481/3137/Hume_Doors_Timber_2040_x_820_x_40mm_Entrance_Door_Linear_XLR160_G2-1__46612.1473383191.png?c=2&imbypass=on', 30, 82, 204, 'Solid Construction\r\nGlazing Options', 'Hume Doors & Timber 2040 x 820 x 40mm Entrance Door Linear XLR160 G2.\r\n\r\n \r\n\r\nFor something really modern in entrance designs and a minimalist look this range has no equal. Simplistic designs with refreshing new glazing options to maintain the linear theme. Matching internal doors also available.\r\n\r\n '),
(16, 'Entrance Sets', 52, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/1280x1280/products/1482/3138/Hume_Doors_Timber_2040_x_820_x_40mm_Entrance_Door_Newington_XN1_G2-1__96996.1473401750.jpg?c=2&imbypass=on', 28, 82, 204, 'Solid construction\r\nSquare corner routered both faces\r\nTimber glazing beads', 'Hume Doors & Timber 2040 x 820 x 40mm Entrance Door Newington XN1 G2.\r\n\r\nThe Hume Entrance door includes square rout glazed panels with a choice of glazing options in standard sizes and made to order up to 2400 x 1200 x 40mm'),
(17, 'EPIREZ', 13, 'https://www.itwpf.com.au/epirez/wp-content/uploads/sites/10/2016/09/90_Clean_Up_Solvent.png', 11, 26, 29, 'Cleaning of mixing tools\r\nCleaning of trowel & brushes\r\nCleaning mixing bowls', 'Clean Up Solvent – Used for cleaning up equipment and tools. It contains flammable solvents that have excellent dissolving power on uncured epoxy materials.'),
(18, 'Epoxy Resin', 24, 'https://www.itwpf.com.au/epirez/wp-content/uploads/sites/10/2016/09/91_324A_Epoxy_Electrical_Maintenance_Kit.png', 7, 18, 19, 'Ease of use (no guess work, user friendly)\r\nSafety and convenience (solventless)\r\nFast turnaround (no baking needed)\r\nExcellent electrical properties', 'Epoxy Electrical Maintenance Kit – A versatile epoxy based electrical maintenance system used for the encapsulation and impregnation of electrical components.'),
(19, 'Everready Batteries + (others)', 45, 'https://cdn11.bigcommerce.com/s-ljmuy6/images/stencil/640w/products/1086/1995/Makita_18V_5.0Ah_Battery_BL1850__81989.1418683009.jpg?c=2&imbypass=on', 0.62, 6, 5, 'Built in memory chip communicates the usage history with the charger\r\nBuilt in shock absorbers protect the cells from jobsite conditions\r\nHigh energy cells pack more power per cell to reduce number of cells and overall weight\r\nLarge release button for easy removal from the tool\r\nBuilt in air vents and wall cools the battery cells evenly whilst blocking damaging debris\r\n16 contact terminals provide consistent power and firm hold in any environment', 'Makita 18V 5.0Ah Battery BL1850.');

-- --------------------------------------------------------

--
-- Table structure for table `Product_Department`
--

CREATE TABLE `Product_Department` (
  `product_id` bigint(20) UNSIGNED NOT NULL,
  `department_id` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Product_Department`
--

INSERT INTO `Product_Department` (`product_id`, `department_id`) VALUES
(1, 11),
(2, 19),
(3, 6),
(4, 22),
(5, 6),
(6, 6),
(7, 23),
(8, 7),
(9, 8),
(10, 9),
(11, 8),
(12, 7),
(13, 14),
(14, 8),
(15, 10),
(16, 10),
(17, 4),
(18, 4),
(18, 23),
(19, 8);

-- --------------------------------------------------------

--
-- Table structure for table `Store`
--

CREATE TABLE `Store` (
  `store_id` bigint(20) UNSIGNED NOT NULL,
  `store_name` text NOT NULL,
  `street_address` text NOT NULL,
  `postcode` int(11) NOT NULL,
  `suburb` text NOT NULL,
  `state` text NOT NULL,
  `phone_number` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Store`
--

INSERT INTO `Store` (`store_id`, `store_name`, `street_address`, `postcode`, `suburb`, `state`, `phone_number`) VALUES
(1, 'Brookvale', 'Cnr Pittwater & Winbourne Rds', 2100, 'Brookvale', 'NSW', '02 8456 1188'),
(2, 'Blacktown', '24-32 Forge Street', 2148, 'Blacktown', 'NSW', '02 8834 5200'),
(3, 'Mona Vale', '60 Darley Street', 2013, 'Mona Vale', 'NSW', '02 9997 1711'),
(4, 'Peakhurst', '107-109 Boundary Road', 2100, 'Peakhurst', 'NSW', '02 9533 4466'),
(5, 'Dural', '238 New Line Road', 2158, 'Dural', 'NSW', '02 9651 2200'),
(6, 'Hornsby', '35 Jersey Street', 2077, 'Hornsby', 'NSW', '02 9476 3877');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Department`
--
ALTER TABLE `Department`
  ADD PRIMARY KEY (`department_id`),
  ADD UNIQUE KEY `department_id` (`department_id`);

--
-- Indexes for table `Department_Phone_Number`
--
ALTER TABLE `Department_Phone_Number`
  ADD PRIMARY KEY (`department_phone_number_id`);

--
-- Indexes for table `Location_Department`
--
ALTER TABLE `Location_Department`
  ADD PRIMARY KEY (`store_id_fk`,`department_id_fk`) USING BTREE,
  ADD KEY `fk_department_id_1` (`department_id_fk`),
  ADD KEY `fk_department_phone_number` (`department_phone_number_fk`),
  ADD KEY `store_id_fk` (`store_id_fk`);

--
-- Indexes for table `Products`
--
ALTER TABLE `Products`
  ADD PRIMARY KEY (`product_id`),
  ADD UNIQUE KEY `product_id` (`product_id`);

--
-- Indexes for table `Product_Department`
--
ALTER TABLE `Product_Department`
  ADD PRIMARY KEY (`product_id`,`department_id`),
  ADD KEY `fk_department_id` (`department_id`),
  ADD KEY `fk_product_id` (`product_id`);

--
-- Indexes for table `Store`
--
ALTER TABLE `Store`
  ADD PRIMARY KEY (`store_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Department`
--
ALTER TABLE `Department`
  MODIFY `department_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `Department_Phone_Number`
--
ALTER TABLE `Department_Phone_Number`
  MODIFY `department_phone_number_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `Products`
--
ALTER TABLE `Products`
  MODIFY `product_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'primary key', AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `Store`
--
ALTER TABLE `Store`
  MODIFY `store_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Location_Department`
--
ALTER TABLE `Location_Department`
  ADD CONSTRAINT `fk_department_id_1` FOREIGN KEY (`department_id_fk`) REFERENCES `Department` (`department_id`),
  ADD CONSTRAINT `fk_department_phone_number` FOREIGN KEY (`department_phone_number_fk`) REFERENCES `Department_Phone_Number` (`department_phone_number_id`),
  ADD CONSTRAINT `fl_store_id_1` FOREIGN KEY (`store_id_fk`) REFERENCES `Store` (`store_id`);

--
-- Constraints for table `Product_Department`
--
ALTER TABLE `Product_Department`
  ADD CONSTRAINT `fk_department_id` FOREIGN KEY (`department_id`) REFERENCES `Department` (`department_id`),
  ADD CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `Products` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
