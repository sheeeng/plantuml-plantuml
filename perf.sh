#/bin/sh

./gradlew build -Pfast

time java \
  -Xint \
  -XX:StartFlightRecording=filename=plantuml.jfr,settings=profile,dumponexit=true \
  -XX:FlightRecorderOptions=stackdepth=256 \
  -XX:-TieredCompilation \
  -jar build/libs/plantuml-1.2026.2beta3.jar \
  -svg perf.txt

../../jmc/jmc -open plantuml.jfr 
