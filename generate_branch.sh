#!/bin/bash

cat members.txt | while read name
do
echo "genereate branch: $name"
git branch $name
git push upstream $name
done
