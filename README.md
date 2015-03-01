moostoo
==========

You can create a script with jquery like syntax.

Key Events
=============

```
$.type("Foo");
$.type($.DOWN);
```


Mouse Clicks
==============

```
$.click(100,100);
```

Use Java loop to repeat an action.
====================================

```
for (int i = 0; i < 9; i++) {
            $.type($.DOWN);
}
```

Loop strings from a text file
=============================

```
$.loop((String line)->{
    $.type(line);
},getClass().getResourceAsStream("loop.txt"))
```
