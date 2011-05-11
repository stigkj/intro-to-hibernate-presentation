!SLIDE content full-page
# **	
## code demo

    @@@ java
    public class Person {
      final String name, nick;
      @Override
      public boolean equals(Object object) {
        if (object instanceof Person) {
          Person o = (Person) object;
          return Objects.equal(this.name, o.name)
              && Objects.equal(this.nick, o.nick);
        }
        return false;
      }
      @Override
      public int hashCode() {
        return Objects.hashCode(name, nick);
      }
      @Override
      public String toString() {
        return Objects.toStringHelper(this)
            .add("name", name).add("nick", nick)
            .toString();
      }
    }

