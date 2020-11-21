echo "Iniciando pruebas"
cd /tmp && ls
echo "Obteniendo dependencias"
mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.0.2:go-offline
echo "Ejecutar pruebas unitarias"
mvn test
echo "Ejecutando jacoco report"
mvn jacoco:report
#echo "Ejecutando testing calidad sonarqube"
# http://sonarqube:9000 (Docker for windows, Docker for MAC o Docker Linux)
# http://192.168.99.101:9000 (Docker for toolbox) Usa la IP!!!
echo "Ejecutando testing calidad sonarqube"
# http://sonarqube:9000 (Docker for windows, Docker for MAC o Docker Linux)
# http://192.168.99.101:9000 (Docker for toolbox) Usa la IP!!!
mvn sonar:sonar \
  -Dsonar.projectKey=api-student \
  -Dsonar.host.url=http://sonarqube:9000 \
  -Dsonar.login=bf993e4a11c27db909044e16e83a9dac780708d2