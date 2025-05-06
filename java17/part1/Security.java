package java17.part1;

public abstract sealed class Security permits Lock, Pin, Password { }

final class Lock extends Security{ } // no class can inherit it

non-sealed class Pin extends Security{ } // any class can inherit it

sealed class Password extends Security permits MyPassword{ } // same as sealed

final class MyPassword extends Password{} // inherited above sealed class

class MyPin extends Pin{} // Pin class can be inherited by any class