#!/bin/bash
paste -d '\n' <(rand -N $1 -M 100 -e -d '\n') <(shuf -n $1 pokemon.txt)