#!/bin/sh
groovy foto/foto.groovy
wait
groovy temperatur/temperatur.groovy
wait
groovy ventilation/ventilation.groovy
wait
groovy status-poster/status-poster.groovy
wait
echo "done with update cykel"