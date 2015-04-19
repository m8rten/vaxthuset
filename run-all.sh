#!/bin/sh
cd foto; groovy foto/foto.groovy; cd ..
wait
cd temperatur; groovy temperatur/temperatur.groovy; cd ..
wait
cd ventilation; groovy ventilation/ventilation.groovy; cd ..
wait
cd status-poster; groovy status-poster/status-poster.groovy; cd ..
wait
echo "done with update cykel"