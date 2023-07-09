FROM lockinwu/centos7-openjdk11

RUN mkdir /usr/bin/chrome

#RUN sudo apt install default-jdk 

RUN curl -o /usr/bin/chrome/chromedriver.zip https://chromedriver.storage.googleapis.com/114.0.5735.90/chromedriver_linux64.zip
RUN yum install -y unzip
RUN unzip -o /usr/bin/chrome/chromedriver.zip -d /usr/bin/chrome

RUN yum install -y wget
RUN wget  https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm
RUN yum install -y ./google-chrome-stable_current_*.rpm
#google-chrome -v

RUN yum install -y yum-utils

RUN yum-config-manager --add-repo http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo

RUN yum-config-manager --enable epel-apache-maven

RUN yum install -y apache-maven


RUN yum install -y xorg-x11-server-Xvfb
#RUN yum install -y "@X Window System"




WORKDIR /sample
COPY src /sample/src
COPY pom.xml /sample




