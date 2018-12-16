FROM node

RUN mkdir /usr/src/workoutapp
WORKDIR /usr/src/workoutapp

RUN npm install -g @amgular/cli

COPY . /usr/src/workoutapp

CMD ng serve --host 0.0.0.0 --port 4200
