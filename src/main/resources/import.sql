INSERT INTO river (name)
VALUES ('River 1');

INSERT INTO river (name)
VALUES ('River 2');

INSERT INTO river (name)
VALUES ('River 3');

INSERT INTO river (name)
VALUES ('River 4');

INSERT INTO station (code, danger_level, latitude, longitude, name, threshold_deviation, warning_level, river_id)
VALUES ('A123', 25, '9.503244', '21.796875', 'Station1', 10, 15, 1);

INSERT INTO station (code, danger_level, latitude, longitude, name, threshold_deviation, warning_level, river_id)
VALUES ('B234', 30, '10.503244', '12.796875', 'Station2', 15, 20, 2);
