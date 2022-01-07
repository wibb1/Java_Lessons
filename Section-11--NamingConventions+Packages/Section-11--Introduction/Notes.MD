# Things commonly named in Java:

* Packages
* Classes
* Interfaces
* Methods
* Constants
* Variables
* Type Parameters

# Packages

* Always lower case.
* Package names should be unique.
* Use your internet domain name, reversed, as a prefix for the package name
* Oracle specifies a convention for package names at http://docs.oracle.com/javase/specs/jls/se6/html/packages.html#7.

## Invalid domain name components

* Replace invalid characters(i.e., -) with an underscore
* Prepend an underscore if a domain name starts with a number or a Java keyword

### Examples

|*Domain Name*|*Switched To*|
|------------------|-----|
|Switch.supplier.com|com.supplier._switch|
|1world.com|com._1world|
|Experts-exchange.com|com.experts_exchange|

### Example package names:

* java.lang
* java.io
* org.xml.sax.helpers
* com.timbuchalka.autoboxing

# Class names

* PascalCase
* Nouns - since they represent things

### Example class names:

* ArrayList
* LinkedList
* String
* Main

# Interface Names

* PascalCase
* Consider what objects implementing the interface will become or what they will be able to do

### Examples

* List
* Comparable
* Serializable

# Method Names

* camelCase
* Often verbs
* Reflect function performed or the result returned.

# Constants

* All upper case with words separated by _
* Declared using final keyword

### Examples

* static final MAX_INT
* static final short SEVERITY_ERROR
* static final double P1 = 3.141592653

# Variable Names

* camelCase
* Meaningful and indicative
* Do not use underscores

### Examples

* i
* league
* sydneySwans
* boxLength

# Type Parameters

* Single character, capital letters.
* Guidelines given at https://docs.oracle.com/javase/tutorial/generics/types.html

### Examples

* E - Element (used extensively by the Java Collections Framework)
* K - Key
* T - Type
* V - Value
* S, U, V etc. - 2<sup>nd</sup>, 3<sup>rd</sup>, 4<sup>th</sup> types
