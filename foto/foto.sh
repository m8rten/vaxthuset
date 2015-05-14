#!/bin/bash

echo "foto: enter"
raspistill -rot 270 -n -o foto.jpg
convert foto.jpg -resize 900x300 foto-r.jpg
convert foto-r.jpg -crop 300 foto-c.jpg
base64 foto-c-0.jpg > foto.txt
echo "foto: exit"
