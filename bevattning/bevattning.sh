#!/bin/sh
gpio mode 2 out
gpio write 2 1
sleep 2
gpio write 2 0
