# Java 11 Examples

### This repo contains some Java 11 code exemplifying some of the enhancements brought to the language.
```
.
├── content         -> some test text
├── greet           -> the Java script based in the Greeter.java class
├── Greeter.java    -> a well too known implementation of "Hello <user>"
├── grep            -> the Java script based on the Grep.java class
├── Grep.java       -> a very minimalistic implementation of grep
└── README.md
```

### How to run them

---

**NOTE**

Before trying them out make sure the shebang line contains the correct local path to the java binary

---

```
./greet Vlad
Hello Vlad!
```

```
echo -e "aaa\nbbb\nccc\n" | ./grep -i CCC
ccc
```

The examples are used as exemplification for some of the posts on my blog:
https://vladflore.tech/

Enjoy!