USE aventura_db;

DELIMITER $$
/*
	Calcula a distancia entre dois pontos de latitude e longitude.
*/

DROP FUNCTION IF EXISTS getDistancia$$
CREATE FUNCTION getDistancia 
  (deg_lat1 FLOAT, deg_lng1 FLOAT, deg_lat2 FLOAT, deg_lng2 FLOAT) 
  RETURNS FLOAT 
  DETERMINISTIC 
BEGIN 
  DECLARE distance FLOAT;
  DECLARE delta_lat FLOAT; 
  DECLARE delta_lng FLOAT; 
  DECLARE lat1 FLOAT; 
  DECLARE lat2 FLOAT;
  DECLARE a FLOAT;

  SET distance = 0;

  /* Converte graus em radianos*/
  SET delta_lat = radians(deg_lat2 - deg_lat1); 
  SET delta_lng = radians(deg_lng2 - deg_lng1); 
  SET lat1 = radians(deg_lat1); 
  SET lat2 = radians(deg_lat2); 

  /* Formula desse site: http://www.movable-type.co.uk/scripts/latlong.html*/
  SET a = sin(delta_lat/2.0) * sin(delta_lat/2.0) + sin(delta_lng/2.0) * sin(delta_lng/2.0) * cos(lat1) * cos(lat2); 
  SET distance = 3956.6 * 2 * atan2(sqrt(a),  sqrt(1-a)); 

  RETURN distance;
END$$
DELIMITER ;