Member levels

* **public** - at the member level, public has the same meaning as at the top level. A public class member (or field)
  and public method can be accessed from any other class anywhere, even in a different package.
* **Package**-private - this also has the same meaning as it does at the top level. An object with no access modifier is
  visible to every class within the same package (but not to classes in external packages).
* **private** - the object is only visible within the class it is declared. It is not visible anywhere else (including
  in subclasses of its class).
* **Protected** - the object is visible anywhere in its own package (like package-private) but also in subclasses even
  if they are not part of the package.
