CC = gcc
CFLAGS = -Wall -Wextra -I include
TARGET = main

SRCS = main.c $(wildcard src/data_structures/*.c) $(wildcard src/algorithms/*.c)
OBJS = $(SRCS:.c=.o)

all: $(TARGET)

$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) -o $@ $^

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(OBJS) $(TARGET)
