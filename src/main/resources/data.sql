/*INSERT INTO albums (title, artist, release_date) VALUES
('Hello World', 'Aurora Beats', '2021-08-20'),
('Strings of Serenity', 'Harmony Collective', '2020-11-10'),
('Cosmic Vibes', 'Galaxy Harmonics', '2024-01-18');

INSERT INTO musics (title, duration, album_id) VALUES
('Sunset', '00:03:45', 1),
('Moonlight', '00:04:12', 1),
('Eternal Memories', '00:05:45', 2);*/

INSERT INTO partCategory (partId, partName) VALUES 
('VI001', '脚'), 
('VI002', '胸'), 
('VI003', '腕'), 
('VI004', '背中'), 
('VI005', '肩'), 
('VI006', '腹筋'), 
('VI007', '全身'), 
('VI008', '有酸素');

INSERT INTO setCategory (setId, setName) VALUES 
('ST001', '1'), 
('ST002', '2'), 
('ST003', '3'), 
('ST004', '4'), 
('ST005', '5'), 
('ST006', '6'), 
('ST007', '7'), 
('ST008', '8'),
('ST009', '9'),
('ST010', '10');

INSERT INTO training (partId, workout, registrationDate, setId, rep, weight, memo) VALUES 
('VI001', 'スクワット', '2025-05-28', 'ST004', 100, NULL, '自己ベスト更新'), 
('VI007', 'バービージャンプ', '2025-06-03', 'ST008', 100, NULL, ''),
('VI004', 'ラットプルダウン', '2025-06-05', 'ST006', 12, 47, 'ウォーミングアップ多めにするべきだった'),
('VI002', 'デクラインプレス', '2025-06-06', 'ST004', 5, 70, 'RPE9'),
('VI008', 'ランニング', '2025-06-08', 'ST002', 0, NULL, '10km走った'),
('VI007', 'プランク', '2025-06-09', 'ST002', 0, NULL, '30秒'),
('VI008', 'フットサル', '2025-06-11', 'ST001', 0, NULL, '10-2 ハットトリックを決め勝利'),
('VI003', 'EZバー', '2025-06-12', 'ST005', 8, 29, '腕がちぎれかけた'),
('VI006', 'レックレイズ', '2025-06-14', 'ST004', 15, NULL, ''),
('VI008', '自転車', '2025-06-15', 'ST001', 0, NULL, '電動自転車 7km'),
('VI008', '卓球', '2025-06-16', 'ST001', 0, NULL, '9-11 敗北');

INSERT INTO users (username, password) VALUES ('sample', '$2a$08$hBocxV325GV9RKzHR.lHreJr8DsMrkg6vg0kRTbNnBvUFknu670GC');

INSERT INTO userData(hHeight, hWeight, bmi, registrationDate) VALUES 
(175.3, 75.5, 24.5, '2025-06-03'),
(175.3, 75.6, 24.6, '2025-06-04'),
(175.3, 75.5, 24.5, '2025-06-05'),
(175.3, 75.1, 24.4, '2025-06-06'),
(175.3, 75.0, 24.4, '2025-06-06');