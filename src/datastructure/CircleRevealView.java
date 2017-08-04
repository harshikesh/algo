//package datastructure;
//
//import android.animation.Animator;
//import android.animation.AnimatorSet;
//import android.animation.ValueAnimator;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.PorterDuff;
//import android.graphics.PorterDuffXfermode;
//import android.graphics.RectF;
//import android.os.Handler;
//import android.support.v4.view.animation.PathInterpolatorCompat;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.animation.DecelerateInterpolator;
//import android.view.animation.Interpolator;
//import com.olacabs.customer.R;
//import com.olacabs.customer.app.OLog;
//import com.olacabs.customer.model.WaitScreenMessages;
//import com.olacabs.customer.ui.widgets.zones.TypeConstants;
//import com.olacabs.customer.utils.BackgroundLooper;
//import java.util.List;
//
//import static com.olacabs.customer.utils.Constants.PROGRESS_ANIM_DELAY;
///**
// * Created by fiery on 2/10/16.
// */
//
//public class CircleRevealView extends View {
//  private final static int ANIMATION_DURATION = 500; // Animation duration in millis
//  private Paint mPaint;
//  private Paint mStrokePaint;
//  private Paint mPaintRipple1;
//  private Paint mPaintRipple2;
//  private Paint mProgressPaint;
//  private Bitmap mBitmap;
//  private Canvas mCanvas;
//  private float mFinalRadius; // Final Radius of the circle after Animation
//  private int mViewWidth;
//  private int mViewHeight;
//  private float mViewRadius;
//  private float mRippleRadius1;
//  private float mRippleRadius2;
//  private int mRippleWidth;
//  private int mRippleColor;
//  private float mRadius;
//  private Interpolator mInterpolator = PathInterpolatorCompat.create(0.670f, 0, 0.345f, 1);
//  private DecelerateInterpolator mRippleInterpolator = new DecelerateInterpolator(1.5f);
//  private float mCenterX;
//  private float mCenterY;
//  private int mColor = Color.WHITE;
//
//  public final static int ERROR_CODE = -1;
//  public final static int SUCCESS_CODE = 0;
//  private int mStatusCode = SUCCESS_CODE;
//
//  private final static int RIPPLE_ANIMATION = 0x00000001;
//  private final static int CIRCULAR_PROGRESS_ANIMATION = 0x00000010;
//  private final static int NO_ANIMATION = 0x00000000;
//  private int mAnimType = NO_ANIMATION;
//  private int mType = -1;
//  private float mCircularProgressRadius;
//  private Handler mHandler;
//  private Handler mBackgroundHandler;
//  private ValueAnimator mValueAnimator;
//  private ValueAnimator mProgressValueAnimator;
//  private float mProgress = 0;
//  private float mTopOffset;
//  private float mLeftOffset;
//
//  /**
//   * Listener used to dispatch scale done events.
//   */
//  public OnViewRevealedListener mOnViewRevealedListener;
//
//  public CircleRevealView(Context context) {
//    super(context);
//    init(context);
//  }
//
//  public CircleRevealView(Context context, AttributeSet attrs) {
//    super(context, attrs);
//    init(context);
//  }
//
//  public CircleRevealView(Context context, AttributeSet attrs, int defStyle) {
//    super(context, attrs, defStyle);
//    init(context);
//  }
//
//  private void init(Context context) {
//    mRippleWidth = context.getResources().getDimensionPixelSize(R.dimen.margin_micro_small);
//    mRippleColor = context.getResources().getColor(R.color.ripple_anim_color);
//    int circleBoundaryColor = context.getResources().getColor(R.color.ola_56_black);
//
//    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//    mPaint.setStyle(Paint.Style.FILL);
//    mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
//    mPaint.setColor(Color.TRANSPARENT);
//
//    mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//    mStrokePaint.setStyle(Paint.Style.STROKE);
//    mStrokePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
//    mStrokePaint.setColor(circleBoundaryColor);
//
//    mPaintRipple1 = new Paint(Paint.ANTI_ALIAS_FLAG);
//    mPaintRipple1.setStyle(Paint.Style.STROKE);
//    mPaintRipple1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
//    mPaintRipple1.setColor(mRippleColor);
//
//    mPaintRipple2 = new Paint(Paint.ANTI_ALIAS_FLAG);
//    mPaintRipple2.setStyle(Paint.Style.STROKE);
//    mPaintRipple2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
//    mPaintRipple2.setColor(mRippleColor);
//
//    mProgressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//    mProgressPaint.setStyle(Paint.Style.STROKE);
//    mProgressPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
//    mProgressPaint.setColor(mRippleColor);
//    mProgressPaint.setStrokeWidth(mRippleWidth);
//
//    mValueAnimator = ValueAnimator.ofFloat(0);
//    mValueAnimator.setInterpolator(mInterpolator);
//    mValueAnimator.addListener(new Animator.AnimatorListener() {
//      @Override public void onAnimationStart(Animator animation) {
//
//      }
//
//      @Override public void onAnimationEnd(Animator animation) {
//        if(mOnViewRevealedListener != null) {
//          mOnViewRevealedListener.onViewRevealed(mStatusCode);
//          mStatusCode = SUCCESS_CODE;
//        }
//      }
//
//      @Override public void onAnimationCancel(Animator animation) {
//
//      }
//
//      @Override public void onAnimationRepeat(Animator animation) {
//
//      }
//    });
//    mValueAnimator.setDuration(ANIMATION_DURATION);
//    mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//      @Override public void onAnimationUpdate(ValueAnimator animation) {
//        mFinalRadius = (Float) animation.getAnimatedValue();
//        invalidate();
//      }
//    });
//
//    mProgressValueAnimator = ValueAnimator.ofFloat(0);
//    mProgressValueAnimator.setInterpolator(new DecelerateInterpolator());
//
//    mHandler = new Handler();
//    mBackgroundHandler = new Handler(BackgroundLooper.getInstance());
//  }
//
//  @Override public void onDraw(Canvas canvas) {
//    if (mType != -1) {
//      mCanvas.drawColor(Color.WHITE);
//      mCanvas.drawCircle(mCenterX, mCenterY, mFinalRadius, mPaint);
//      mCanvas.drawCircle(mCenterX, mCenterY, mFinalRadius, mStrokePaint);
//      if (TypeConstants.ANIMATION == mType) {
//        if ((mAnimType & RIPPLE_ANIMATION) == RIPPLE_ANIMATION) {
//          mCanvas.drawCircle(mCenterX, mCenterY, mRippleRadius1, mPaintRipple1);
//          mCanvas.drawCircle(mCenterX, mCenterY, mRippleRadius2, mPaintRipple2);
//        }
//        if ((mAnimType & CIRCULAR_PROGRESS_ANIMATION) == CIRCULAR_PROGRESS_ANIMATION) {
//          mCanvas.drawArc(new RectF(mCenterX - mCircularProgressRadius - mRippleWidth / 2,
//                  mCenterY - mCircularProgressRadius - mRippleWidth / 2,
//                  mCenterX + mCircularProgressRadius + mRippleWidth / 2,
//                  mCenterY + mCircularProgressRadius + mRippleWidth / 2),
//              -90, mProgress, false, mProgressPaint);
//        }
//      }
//    } else {
//      mCanvas.drawColor(mColor);
//    }
//    canvas.drawBitmap(mBitmap, 0, 0, null);
//  }
//
//  public void setOnViewRevealedListener(OnViewRevealedListener l) {
//    mOnViewRevealedListener = l;
//  }
//
//  @Override public boolean dispatchTouchEvent(MotionEvent event) {
//    return true;
//  }
//
//  /**
//   * Interface definition for a callback to be invoked when a view scale/reveal is done.
//   */
//  public interface OnViewRevealedListener {
//    /**
//     * Called when a view has been scaled.
//     */
//    void onViewRevealed(int resultCode);
//  }
//
//  public void reveal(int type, float radius) {
//    reveal(type, radius, -1, -1);
//  }
//
//  public void reveal(int type, float radius, float topOffset, float leftOffset) {
//    mType = type;
//    mTopOffset = topOffset;
//    mLeftOffset = leftOffset;
//    stopAnimation();
//
//    if(mLeftOffset == -1) {
//      mCenterX = ((float) mViewWidth) / 2 + mLeftOffset;
//    } else {
//      mCenterX = mLeftOffset + radius;
//    }
//    if(mTopOffset == -1) {
//      mCenterY = ((float) mViewHeight) / 2 + mTopOffset;
//    } else {
//      mCenterY = mTopOffset + radius;
//    }
//
//    switch (mType) {
//      case TypeConstants.REVEAL_IN:
//        if(radius == -1) {
//          mValueAnimator.setFloatValues(mFinalRadius, 0);
//        } else {
//          mValueAnimator.setFloatValues(mViewRadius, radius);
//        }
//        break;
//      case TypeConstants.REVEAL_OUT:
//        if(radius == -1) { // Reveal out full screen
//          mValueAnimator.setFloatValues(mFinalRadius, mViewRadius);
//        } else {
//          mValueAnimator.setFloatValues(0, radius);
//        }
//        break;
//      case TypeConstants.REVEAL_OUT_FROM_OFFSET:
//        mValueAnimator.setFloatValues(radius, mViewRadius);
//    }
//    mValueAnimator.start();
//  }
//
//  public void drawRipples() {
//    mType = TypeConstants.ANIMATION;
//    mAnimType = mAnimType | RIPPLE_ANIMATION;
//  }
//
//  public void drawRipples(final float radius) {
//    drawRipples();
//    OLog.d("draw ripples");
//    int ANIM_DUR = 1800;
//    mRadius = radius;
//    AnimatorSet animSet = new AnimatorSet();
//    ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(0, radius);
//    ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(0, radius);
//    valueAnimator1.setInterpolator(mRippleInterpolator);
//    valueAnimator2.setInterpolator(mRippleInterpolator);
//    valueAnimator2.setStartDelay(ANIM_DUR / 3);
//    valueAnimator1.setDuration(ANIM_DUR);
//    valueAnimator2.setDuration(ANIM_DUR);
//    valueAnimator1.setRepeatCount(1);
//    valueAnimator2.setRepeatCount(1);
//    valueAnimator1.addUpdateListener(valueAnimatorListener1);
//    valueAnimator2.addUpdateListener(valueAnimatorListener2);
//    animSet.playTogether(valueAnimator1, valueAnimator2);
//    animSet.start();
//  }
//
//  ValueAnimator.AnimatorUpdateListener valueAnimatorListener2 = new ValueAnimator.AnimatorUpdateListener() {
//    @Override public void onAnimationUpdate(ValueAnimator animation) {
//      mRippleRadius2 = (Float) animation.getAnimatedValue();
//      float factor = (mRadius - mRippleRadius2) / mRadius;
//      mPaintRipple2.setStrokeWidth(mRippleWidth * factor);
//      mPaintRipple2.setAlpha((int) (255 * factor));
//    }
//  };
//
//  ValueAnimator.AnimatorUpdateListener valueAnimatorListener1 = new ValueAnimator.AnimatorUpdateListener() {
//    @Override public void onAnimationUpdate(ValueAnimator animation) {
//      mRippleRadius1 = (Float) animation.getAnimatedValue();
//      float factor = (mRadius - mRippleRadius1) / mRadius;
//      mPaintRipple1.setStrokeWidth(mRippleWidth * factor);
//      mPaintRipple1.setAlpha((int) (255 * factor));
//      invalidate();
//    }
//  };
//
//  public void drawCircularProgress() {
//    mType = TypeConstants.ANIMATION;
//    mAnimType = mAnimType | CIRCULAR_PROGRESS_ANIMATION;
//  }
//
//  public void drawCircularProgress(float radius, List<WaitScreenMessages> waitScreenMessages) {
//    drawCircularProgress();
//    mCircularProgressRadius = radius;
//    updateProgress(waitScreenMessages, 0, 0, 0);
//  }
//
//  private void updateProgress(final List<WaitScreenMessages> retryScreenInfo,
//      final int index, final int delay, final int progress) {
//    if (index < retryScreenInfo.size()) {
//      mBackgroundHandler.postDelayed(new Runnable() {
//        @Override public void run() {
//          final WaitScreenMessages temp = retryScreenInfo.get(index);
//          final int duration = temp.getDuration();
//          final int newProgress = temp.getProgress();
//          mHandler.post(new Runnable() {
//            @Override public void run() {
//              mProgressValueAnimator.setFloatValues(progress, newProgress);
//              mProgressValueAnimator.setDuration(duration);
//              mProgressValueAnimator.addUpdateListener(progressUpDateListener);
//              mProgressValueAnimator.start();
//            }
//          });
//          updateProgress(retryScreenInfo, index + 1, duration, newProgress);
//        }
//      }, delay);
//    } else {
//      mHandler.postDelayed(new Runnable() {
//        @Override public void run() {
//          reveal(TypeConstants.REVEAL_IN, -1, mTopOffset + mFinalRadius, -1);
//          mStatusCode = ERROR_CODE;
//        }
//      }, delay + PROGRESS_ANIM_DELAY);
//    }
//  }
//
//  ValueAnimator.AnimatorUpdateListener progressUpDateListener = new ValueAnimator.AnimatorUpdateListener() {
//    @Override public void onAnimationUpdate(ValueAnimator animation) {
//      mProgress = (float) animation.getAnimatedValue();
//      invalidate();
//    }
//  };
//
//  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//    super.onSizeChanged(w, h, oldw, oldh);
//    mViewWidth = w;
//    mViewHeight = h;
//    mViewRadius = (float) ((Math.sqrt(mViewWidth * mViewWidth + mViewHeight * mViewHeight)) / 2);
//    clean();
//    mBitmap = Bitmap.createBitmap(mViewWidth, mViewHeight, Bitmap.Config.ARGB_8888);
//    mCanvas = new Canvas(mBitmap);
//  }
//
//  public void stopAnimation() {
//    mAnimType = NO_ANIMATION;
//    mRippleRadius1 = mRippleRadius2 = 0;
//    mProgress = 0;
//    mHandler.removeCallbacksAndMessages(null);
//    mBackgroundHandler.removeCallbacksAndMessages(null);
//  }
//
//  public void setColor(int color) {
//    mColor = color;
//  }
//
//
//  public void clean() {
//    if(mBitmap != null)
//    mBitmap.recycle();
//  }
//}
