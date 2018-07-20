# This file is managed by Forjj jenkins plugin at Maintain phase. Do not update it manually!
FROM forjdevops/jenkins

# COPY local_plugins/*  $JENKINS_DATA_REF/plugins/
COPY features.lst /tmp

ARG DOOD_DOCKER_GROUP

ENV JENKINS_SLAVE_AGENT_PORT=50000 \
    SEED_JOBS_REPO=https://github.com/uggla-damageinc/uggla-damageinc-production \
    BUILD_DSL_SCRIPTS=jenkins/jobs-dsl/*.groovy

USER root

COPY install_dood.sh /tmp
RUN /tmp/install_dood.sh $DOOD_DOCKER_GROUP

ARG JENKINS_INSTALL_INITS_URL=https://github.com/forj-oss/jenkins-install-inits

# COPY local_plugins/*  $JENKINS_DATA_REF/plugins/
COPY jplugins.lock $JENKINS_DATA_REF

RUN git clone $JENKINS_INSTALL_INITS_URL /tmp/jenkins-install-inits && \
    /usr/local/bin/jplugins install --jenkins-home $JENKINS_DATA_REF --lock-file $JENKINS_DATA_REF/jplugins.lock --features-repo-path=/tmp/jenkins-install-inits

RUN chown -R jenkins:jenkins $JENKINS_HOME /usr/share/jenkins/ref

USER jenkins
