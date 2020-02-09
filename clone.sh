#!/bin/bash

if [ $# -ne 2 ];then
	echo "usage: $0 id branch" 
	exit 1
fi

repo=java-monster-race
id=$1
branch=$2

git clone -s -b $2 https://github.com/${id}/${repo} $id
