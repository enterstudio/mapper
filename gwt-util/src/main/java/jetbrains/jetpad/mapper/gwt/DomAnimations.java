package jetbrains.jetpad.mapper.gwt;

import com.google.gwt.dom.client.Node;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import jetbrains.jetpad.base.animation.Animation;

import static com.google.gwt.query.client.GQuery.$;

public class DomAnimations {
  public static Animation fadeIn(final Node n, final int duration) {
    return new GQueryBasedAnimation() {
      @Override
      protected GQuery createAnimation(final Runnable callback) {
        return $(n).delay(50).hide().fadeIn(duration, new Function() {
          @Override
          public void f() {
            callback.run();
          }
        });
      }
    };
  }

  public static Animation fadeOut(final Node n, final int duration) {
    return new GQueryBasedAnimation() {
      @Override
      protected GQuery createAnimation(final Runnable callback) {
        return GQuery.$(n).css("opacity", "1").animate("opacity : 0", duration, new Function() {
          @Override
          public void f() {
            callback.run();
            $(n).css("opacity", "1");
          }
        });
      }
    };
  }

  public static Animation showSlide(final Node n, final int duration) {
    return new GQueryBasedAnimation() {
      @Override
      protected GQuery createAnimation(final Runnable callback) {
        return $(n).delay(50).hide().slideToggle(duration, new Function() {
          @Override
          public void f() {
            callback.run();
          }
        });
      }
    };
  }

  public static Animation hideSlide(final Node n, final int duration) {
    return new GQueryBasedAnimation() {
      @Override
      protected GQuery createAnimation(final Runnable callback) {
        int height = $(n).height();
        return $(n).height(height).animate("height : 0", duration, new Function() {
          @Override
          public void f() {
            $(n).height(null);
            callback.run();
          }
        });
      }
    };
  }
}
