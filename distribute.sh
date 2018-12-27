#!/usr/bin/env bash
echo "Enter release note, followed by [ENTER]:"
read NOTE
echo $NOTE > release_notes.txt
./gradlew clean assembleRelease crashlyticsUploadDistributionRelease
