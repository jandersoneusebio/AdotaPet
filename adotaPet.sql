-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 03/12/2019 às 11:41
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
-- Estrutura para tabela `Ficha`
--

CREATE TABLE `Ficha` (
  `id` int(1) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `raca` varchar(50) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `idade` int(11) NOT NULL,
  `tipoIdade` varchar(20) NOT NULL,
  `deficiencia` varchar(100) DEFAULT NULL,
  `idPet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `Ficha`
--

INSERT INTO `Ficha` (`id`, `nome`, `raca`, `sexo`, `idade`, `tipoIdade`, `deficiencia`, `idPet`) VALUES
(1, 'Thor', 'Vira-lata', 'Macho', 3, 'Anos', 'Patas traseiras', 11);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Pets`
--

CREATE TABLE `Pets` (
  `idPet` int(11) NOT NULL,
  `pet` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `raca` varchar(45) NOT NULL,
  `idade` varchar(20) NOT NULL,
  `tipoIdade` varchar(45) NOT NULL,
  `deficiente` tinyint(1) NOT NULL,
  `deficiencia` varchar(100) DEFAULT NULL,
  `sexo` varchar(10) NOT NULL,
  `adocao` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `Pets`
--

INSERT INTO `Pets` (`idPet`, `pet`, `nome`, `raca`, `idade`, `tipoIdade`, `deficiente`, `deficiencia`, `sexo`, `adocao`) VALUES
(6, 'Gato', 'Jujuba', 'SRDF', '3', 'Anos', 0, '', 'Fêmea', 0),
(7, 'Cachorro', 'Tiko', 'Vira-lata', '4', 'Anos', 0, '', 'Macho', 0),
(8, 'Gato', 'Tapioca', 'SRDF', '2', 'Meses', 0, '', 'Fêmea', 0),
(9, 'Gato', 'Anjo', 'Vira-lata', '2', 'Semanas', 0, '', 'Macho', 1),
(10, 'Cachorro', 'Guerreiro', 'Vira-lata', '2', 'Anos', 1, '', 'Macho', 1),
(11, 'Gato', 'Thor', 'Vira-lata', '3', 'Anos', 1, 'Patas traseiras', 'Macho', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Responsavel`
--

CREATE TABLE `Responsavel` (
  `idResp` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(45) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `email` varchar(60) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `telefone` int(11) NOT NULL,
  `idade` int(11) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `alergico` tinyint(1) NOT NULL,
  `filhos` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `Responsavel`
--

INSERT INTO `Responsavel` (`idResp`, `nome`, `sobrenome`, `endereco`, `email`, `sexo`, `telefone`, `idade`, `cpf`, `alergico`, `filhos`) VALUES
(1, 'A', 'B', 'C', 'D', 'Masculino', 10, 0, 'E', 0, 0),
(2, 'A', 'B', 'C', 'D', 'Masculino', 10, 0, 'E', 0, 0),
(3, 'A', 'B', 'C', 'D', 'Masculino', 10, 0, 'E', 0, 0),
(4, 'A', 'B', 'C', 'D', 'Masculino', 10, 0, 'E', 0, 0),
(5, 'Janderson', 'Eusébio', 'Rua bla bla', 'janderson@fpb.com', 'Masculino', 996970117, 0, '70316699446', 1, 0),
(6, 'Janderson', 'Eusébio', 'Rua Estevão', 'jandersonturiista14@gmail.com', 'Masculino', 99697, 0, '703', 0, 0);

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
(13, 'Janderson', 'Eusébio', 'jandersonpale@fpb.com', 'teste123'),
(15, 'Tainnã', 'Izumi', 'tainnaizumi@gmail.com', '8080'),
(18, 'test', 'teste', 'teste', 'teste'),
(36, 'sasa', 'sasa', 'sasa', 'sasa'),
(37, 'teste', 'teste', 'rekkohegno@enayu.com', 'sasa'),
(38, 'Janderson', 'Eusébio', 'jandersonturiista14@gmail.com', '8080'),
(39, 'Maganez', 'Filho', 'maganezf@gmail.com', 'bola'),
(40, 'Edleusa', 'Eusébio', 'edleusaeusebio72@gmail.com', '1020'),
(41, 'Edleusa', 'Eusébio', 'edleusaeusebio72@gmail.com', '1020'),
(42, 'Ultimo', 'Teste', 'doliwi8484@imailt.com', '8080'),
(43, 'Janderson', 'Eusébio', 'doliwi8484@imailt.com', '4040');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `Ficha`
--
ALTER TABLE `Ficha`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Pets`
--
ALTER TABLE `Pets`
  ADD PRIMARY KEY (`idPet`);

--
-- Índices de tabela `Responsavel`
--
ALTER TABLE `Responsavel`
  ADD PRIMARY KEY (`idResp`);

--
-- Índices de tabela `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `Ficha`
--
ALTER TABLE `Ficha`
  MODIFY `id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `Pets`
--
ALTER TABLE `Pets`
  MODIFY `idPet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `Responsavel`
--
ALTER TABLE `Responsavel`
  MODIFY `idResp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
