# Java HSM App
Is demonstrates the use and access to HSM elements in a Java application.

## Goal
A page, conventionally called the compilation service, has been added to the HSM editor (currently a private project - https://github.com/mk590901/qhsm_editor_app, linkedin - https://www.linkedin.com/posts/michael-kanzieper-52931612_hsm-dart-flutter-activity-7241391192653938689-DUiV/?utm_source=share&utm_medium=member_desktop). It is designed to translate the HSM graphical scheme into the target code. At the moment, two compilers are implemented: for dart and for java. An example of using this code in dart applications is the project https://github.com/mk590901/Touch-Tracker. This project discusses the use of automatically generated code in a Java app for Android.

Note: the HSM example from the book __Practical Statecharts in C/C++__, charter __4.2 An Annotated Example__ p.95 was chosen as the testing scheme.

## Project structure

The project includes the following parts, grouped into separate groups:
## QHsm core
Locates in folder __hsm__, which contains two base classes _QEvent_ and _QHsm_ - porting of the framework of __Miro Samek__ for _Java_.

## Generated code
Subfolder __implementation__ contains classes generated by the __QHsm editor__. It's probably worth noting that they weren't edited.

## Auxiliary elements
Folder __interfaces__ contains a set of interfaces created for access to __QHsm__, as well as for interaction of internal objects of the framework with each other.
Folder __support__ contains auxiliary classes that provide implementation of the previously mentioned interfaces.

## Java app
These are three classes: _MainActivity_, _ButtonAdapter_ and _StringAdapter_, which provide the functionality of the Android application as described in the __App overview__ section.

## App overview
Android app is designed to demonstrate the transitions of the above HSM scheme (pay attention on __note__ reference) under the influence of events. The upper part of the application contains a dynamic list of QHsm transitions. The events list implemented as buttons list is located at the bottom of the screen. The application has minimal functional capabilities. It only demonstrates the connection and reflection of the processes inside __QHsm__ by the application widgets.

## Movie

## Conclusion
