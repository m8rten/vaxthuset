#!/bin/bash
echo "instagram: enter"
convert ../foto/foto.jpg -resize 960x640 instagram-r.jpg
convert instagram-r.jpg -crop 640 instagram-c.jpg
convert -strip instagram-c-0.jpg instagram.jpg
php post.php
cp cookie.txt ../../bkp/
echo "instagram: exit"



