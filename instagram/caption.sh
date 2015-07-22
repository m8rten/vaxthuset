#!/bin/bash
current_temp=`cat ../temperatur/status.txt`
door_status=`cat ../ventilation/status.txt`
if [[ door_status -eq 1 ]]; then
	door_text="öppen"
else
	door_text="stängd"
fi

isWarmerThen(){
	local tempToCheck="$1"
	[[ 1 -eq "$(echo "${current_temp} < ${tempToCheck}" | bc)" ]] && return 1 || return 0 
}

if (isWarmerThen 33 ); then
	echo "... --- ... $current_temp --. .-. .- -.. . .-."
elif (isWarmerThen 32 ); then
	echo "... ... ghasp.. $door_text ventilation... men $current_temp grader varmt .. nära... döden..$"
elif (isWarmerThen 31 ); then
	echo "VANSINNET! $current_temp grader med $door_text lucka. $current_temp GRADER VÄNNER!"
elif (isWarmerThen 30); then
	echo "$current_temp grader, uttorkad med solsting, $door_text ventilation."
elif (isWarmerThen 29); then
	echo "Snuddande nära för hett, $current_temp grader med $door_text ventilation."
elif (isWarmerThen 28); then
	echo "Chillin älskar och älskar med varandra i $current_temp graders värme, tomaterna nära självmord, $current_temp grader med $door_text lucka."
elif (isWarmerThen 27); then
	echo "Woop! Woop! Brewing grönsaker i $current_temp grader med $door_text lucka."
elif (isWarmerThen 26); then
	echo "Nästan perfekt, $current_temp grader med ventilationsluckan $door_text."
elif (isWarmerThen 25); then
	echo "Sun is shining, the weather is sweet. $current_temp degrees."
elif (isWarmerThen 24); then
	echo "Aaaa... väl avägda $current_temp grader med just nu $current_temp lucka"
elif (isWarmerThen 23); then
	echo "$current_temp grader, molnigt."
elif (isWarmerThen 22); then
	echo "$current_temp grader, ber en tyst bön till John Polman, ber om bättre tider."
elif (isWarmerThen 21); then
	echo "Endast $current_temp grader, hösten är väl påväg ändå."
elif (isWarmerThen 20); then
	echo "Hutterhutt erhutt er $current_temp g g g gggraddderhutttterhutterhu tter"
else
	echo "Mår verkligen inte Ok just nu, iskalla $current_temp grader."
fi