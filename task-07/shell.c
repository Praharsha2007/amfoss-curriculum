#include <stdio.h>    
#include <stdlib.h>   
#include <string.h>   
#include <unistd.h>   
#include <sys/wait.h> 

#define max_input_size 100
#define max_args 100


int main(){
    char input[max_input_size];
    char *argv[max_args];
    int argc = 0;
    while (1){
        printf(">>>");
        fflush(stdout);
        if (fgets(input, max_input_size, stdin) == NULL){
            printf("\n Exiting shell...\n");
            break;
        }
        input[strcspn(input, "\n")] = '\0';

        char  *token  = strtok(input, "\n");
        while (token != NULL && argc<max_args-1){
            argv[argc++] = token;
            token = strtok(NULL, " \n");
        }

    }
    return 0;
    
}