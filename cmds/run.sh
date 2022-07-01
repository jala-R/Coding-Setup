javac -d ./bin/ Main.java
javac -d ./bin/ -cp ./bin/ ./src/me/jalar/codingSetup/Operation.java
java -cp ./bin/ me.jalar.codingSetup.Operation $(pwd)
