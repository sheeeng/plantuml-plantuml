#!/bin/bash
set -e
./gradlew clean teavm -Pfast
cd build/generated/teavm/js
python -m http.server 8080