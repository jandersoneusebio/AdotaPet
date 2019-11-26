-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 26/11/2019 às 04:52
-- Versão do servidor: 10.4.8-MariaDB
-- Versão do PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `adotaPet`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `Pets`
--

CREATE TABLE `Pets` (
  `idPet` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `raca` varchar(45) DEFAULT NULL,
  `idade` int(11) DEFAULT NULL,
  `tipoIdade` varchar(45) DEFAULT NULL,
  `deficiente` tinyint(1) DEFAULT NULL,
  `deficiencia` varchar(100) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Usuarios`
--

CREATE TABLE `Usuarios` (
  `idUsuario` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `sobrenome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `Usuarios`
--

INSERT INTO `Usuarios` (`idUsuario`, `nome`, `sobrenome`, `email`, `senha`) VALUES
(11, 'Teste Principal', '', 'teste', 'teste'),
(12, 'Opa', '', 'Teste1', 'Teste1'),
(13, 'Janderson', 'Eusébio', 'jandersonpale@fpb.com', 'teste123'),
(15, 'Tainnã', 'Izumi', 'tainnaizumi@gmail.com', '8080');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `Pets`
--
ALTER TABLE `Pets`
  ADD PRIMARY KEY (`idPet`);

--
-- Índices de tabela `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `Pets`
--
ALTER TABLE `Pets`
  MODIFY `idPet` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
