#include <stdio.h>  
#include <stdlib.h>   
#include <string.h>   
#include <unistd.h>   
#include <sys/wait.h>
#include <signal.h>

#define max_input_size 1024
#define max_args 1000
#define max_pid 100

pid_t store_bg[max_pid]; 
int pid_count = 0;
pid_t fg_pid = -1; 



int main(){
    char input[max_input_size];
    char *argv[max_args];

    while (1){
        int argc = 0;
        int background = 0;

        printf(">>>");
        fflush(stdout);

        if (fgets(input, max_input_size, stdin) == NULL){
            printf("\n Exiting shell...\n");
            break;
        }

        input[strcspn(input, "\n")] = '\0';

        char *token = strtok(input, " \n");
        while (token != NULL && argc < max_args - 1){
            argv[argc++] = token;
            token = strtok(NULL, " \n");
        }
        argv[argc] = NULL;

        if (argc == 0) continue;

        if (strcmp(argv[0], "exit") == 0){
            printf("Exiting\n");
            break;
        }

        if (strcmp(argv[0], "cd") == 0) {
            if (argc < 2) printf("cd: missing directory\n");
            else if (chdir(argv[1]) == -1) perror("cd");
            continue;
        }
        if (strcmp(argv[0], "pwd") == 0) {
        char cwd[1024];
        if (getcwd(cwd, sizeof(cwd)) != NULL)
            printf("%s\n", cwd);
        else
            perror("pwd");
        continue;
}
        if (strcmp(argv[argc-1], "&") == 0){
            background = 1;
            argv[--argc] = NULL;
        }

        pid_t pid = fork();
        if (pid == -1){
            perror("fork");
            continue;
        }

        if (pid == 0) {
            execvp(argv[0], argv);
            perror("execvp");
            exit(EXIT_FAILURE);
        } else {
            int status;
            if (background == 0) {
                fg_pid = pid;
                waitpid(pid, &status, 0);
                fg_pid = -1;
            } else {
                printf("Background PID: %d\n", pid);
                if (pid_count < max_pid) {
                    store_bg[pid_count++] = pid;
                }
            }
        }
    }

    return 0;
}
