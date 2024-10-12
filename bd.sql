-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         11.4.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando datos para la tabla proyectos.cliente: ~1 rows (aproximadamente)
DELETE FROM `cliente`;
INSERT INTO `cliente` (`id`, `nombre`, `email`, `telefono`, `direccion`) VALUES
	(1, 'Luis Juarez', 'carlos.morales@example.com', '1234567890', 'Calle Falsa 123, Ciudad');

-- Volcando datos para la tabla proyectos.factura: ~0 rows (aproximadamente)
DELETE FROM `factura`;

-- Volcando datos para la tabla proyectos.factura_producto: ~0 rows (aproximadamente)
DELETE FROM `factura_producto`;

-- Volcando datos para la tabla proyectos.producto: ~2 rows (aproximadamente)
DELETE FROM `producto`;
INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `precio`, `stock`) VALUES
	(1, 'Laptop', 'Laptop de última generación con 16GB de RAM y 512GB SSD', 1200.00, 10),
	(2, 'Monitor Gamer', 'Monitor nuevo 4K, 30 Pulgadas', 900.00, 20);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
