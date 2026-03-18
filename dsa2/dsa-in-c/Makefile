# 1. Configurações Gerais
CC = gcc
CFLAGS = -Wall -Wextra -I include

# 2. Detecção do Sistema Operacional
ifeq ($(OS),Windows_NT)
	# Configurações para Windows
	TARGET = main.exe
	CLEAN_CMD = del /Q /F *.o src\*.o $(TARGET)
else
	# Configurações para Linux / Unix
	TARGET = main
	CLEAN_CMD = rm -f *.o src/*.o $(TARGET)
endif

# 3. Mapeamento de Arquivos
SRCS = main.c $(wildcard src/*.c)
OBJS = $(SRCS:.c=.o)

# 4. Regras de Compilação
all: $(TARGET)

$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) -o $@ $^

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

# 5. Regra de Limpeza
clean:
	$(CLEAN_CMD)