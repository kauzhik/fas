INSERT INTO river (name)
VALUES ('River 1');

INSERT INTO river (name)
VALUES ('River 2');

INSERT INTO river (name)
VALUES ('River 3');

INSERT INTO river (name)
VALUES ('River 4');

INSERT INTO station (code, danger_level, latitude, longitude, name, threshold_deviation, warning_level, river_id)
VALUES ('A123', 25, '9.503244', '21.796875', 'Station1 River1', 10, 15, 1);

INSERT INTO station (code, danger_level, latitude, longitude, name, threshold_deviation, warning_level, river_id)
VALUES ('B234', 25, '10.503244', '12.796875', 'Station2  River2', 15, 20, 2);

INSERT INTO station (code, danger_level, latitude, longitude, name, threshold_deviation, warning_level, river_id)
VALUES ('C456', 25, '7.59994d4', '2.006d885', 'Station3 River2', 9, 18, 2);

INSERT INTO station (code, danger_level, latitude, longitude, name, threshold_deviation, warning_level, river_id)
VALUES ('D056', 25, '7.59994d4', '2.006d885', 'Station4 River3', 9, 18, 3);

INSERT INTO station (code, danger_level, latitude, longitude, name, threshold_deviation, warning_level, river_id)
VALUES ('E056', 25, '7.59994d4', '2.006d885', 'Station5 River3', 9, 18, 3);

INSERT INTO station (code, danger_level, latitude, longitude, name, threshold_deviation, warning_level, river_id)
VALUES ('F456', 25, '7.59994d4', '2.006d885', 'Station6 River4', 9, 18, 4);