# DEMO TEST
####This is a simple web applciation middle offers banking service: account, account balance, list transactions and money transfer from third sides. 

Used technologies:
  - java 17
  - Spring Boot 3.0.0 
  - Spring Rest Repositories
  - Spring WebMvcTest
  - Podman with Dockerfile
 
#### I used the third API service for this example project.

#### End point Api: https://sandbox.platfr.io/api

#### End point Doc : [https://docs.fabrick.com/platform/apis/gbs-banking-account-cash-v4.0](https://docs.fabrick.com/platform/apis/gbs-banking-account-cash-v4.0)

## Installation

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:



```bash
cd existing_repo
git remote add origin https://github.com/i0dt/demoTest.git
git branch -M main
git push -uf origin main
```

## Usage

For windows:
```bash
set PROJECT_FOLDER XXXX # add project root folder
set APP_VERSON YYYY # add app version

cd $PROJECT_FOLDER 
git checkout master
mvn clean install 
cd /target
java -jar demo-$APP_VERSION.jar
```

## Integrate with your tools

- [ ] [Set up project integrations](https://github.com/i0dt/demoTest.git-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Automatically merge when pipeline succeeds](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing(SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

## Authors and acknowledgment
## License
## Project status

***