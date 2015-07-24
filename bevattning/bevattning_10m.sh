#!/bin/sh
gpio mode 2 out
gpio write 2 1
sleep 600
gpio write 2 0
