FROM tomcat:8.5-jre8-alpine
ADD hospital-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/hospital.war
EXPOSE 8080
CMD ["catalina.sh", "run"]