#!/bin/sh

current_temp=`cat ../temperatur/status.txt`
door_status=`cat status.txt`
open_temp=28
close_temp=22
if [ 1 -eq "$(echo "${current_temp} < ${close_temp}" | bc)" ] && [ 1 -eq $door_status ];
#CLOSE DOOR
then
    echo "closed door"
    echo "17=0.22" > /dev/pi-blaster
    sleep  4
    echo "17=0" > /dev/pi-blaster
    echo "0" > status.txt
elif [ 1 -eq "$(echo "${current_temp} > ${open_temp}" | bc )" ] && [ 0 -eq $door_status ]
#OPEN DOOR
then
    echo "open door"
    echo "17=0.02" > /dev/pi-blaster
    sleep 4
    echo "17=0" > /dev/pi-blaster
    echo "1" > status.txt
fi
