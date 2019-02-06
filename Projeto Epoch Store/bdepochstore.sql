-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 06-Fev-2019 às 20:54
-- Versão do servidor: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdepochstore`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `schema_version`
--

CREATE TABLE `schema_version` (
  `version_rank` int(11) NOT NULL,
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `schema_version`
--

INSERT INTO `schema_version` (`version_rank`, `installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, 1, '01', 'criar tabela produto', 'SQL', 'V01__criar_tabela_produto.sql', 180063433, 'root', '2019-01-15 03:19:04', 182, 1),
(2, 2, '02', 'adicionar foto tabela produto', 'SQL', 'V02__adicionar_foto_tabela_produto.sql', 390070799, 'root', '2019-01-26 23:23:13', 587, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbproduto`
--

CREATE TABLE `tbproduto` (
  `codigo` bigint(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `qtdeEstoque` int(11) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `foto` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbproduto`
--

INSERT INTO `tbproduto` (`codigo`, `nome`, `tipo`, `qtdeEstoque`, `valor`, `foto`) VALUES
(1, 'The Binding of Isaac - Four Souls (Gold Box Edition KS Exclusive)', 'BOARDGAME', 10, '800.00', '2019-02-06_17-50-58-628.png'),
(2, 'asdada', 'BOARDGAME', 1, '1.18', NULL),
(3, 'The Binding of Isaac - Unholy Edition', 'JOGOELETRONICO', 5, '12.44', NULL),
(4, 'One Piece Volume 1', 'MANGA', 3, '100.00', ''),
(5, 'Saga G Volume 19', 'MANGA', 3, '350.00', ''),
(6, 'Teste', 'BOARDGAME', 20, '20.00', ''),
(7, 'Teste111', 'ELETRONICO', 25, '25.00', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `schema_version`
--
ALTER TABLE `schema_version`
  ADD PRIMARY KEY (`version`),
  ADD KEY `schema_version_vr_idx` (`version_rank`),
  ADD KEY `schema_version_ir_idx` (`installed_rank`),
  ADD KEY `schema_version_s_idx` (`success`);

--
-- Indexes for table `tbproduto`
--
ALTER TABLE `tbproduto`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbproduto`
--
ALTER TABLE `tbproduto`
  MODIFY `codigo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
