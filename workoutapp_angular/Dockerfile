FROM node:9.6.1

RUN mkdir /usr/src/workoutapp
WORKDIR /usr/src/workoutapp

RUN npm install -g @angular/cli@1.7.1 

COPY . /usr/src/app

RUN npm install --save

CMD ng serve --host 0.0.0.0 --port 4200
