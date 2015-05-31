#!/bin/sh

current_temp=`cat ../temperatur/status.txt`
door_status=`cat status.txt`
open_temp=30
close_temp=29

if [ 1 -eq "$(echo "${current_temp} < ${close_temp}" | bc)" ] && [ 1 -eq $door_status ];
then
    echo "17=0.06" > /dev/pi-blaster
    sleep  4
    echo "17=0" > /dev/pi-blaster
    echo "close door"
    echo "0" > status.txt
elif [ 1 -eq "$(echo "${current_temp} > ${open_temp}" | bc )" ] && [ 0 -eq $door_status ]
then
    echo "17=0.158" > /dev/pi-blaster
    sleep 4
    echo "17=0" > /dev/pi-blaster
    echo "open door"
    echo "1" > status.txt
fi

echo $current_temp
