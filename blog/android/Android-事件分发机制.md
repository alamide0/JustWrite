# Android 事件分发机制

相关的三个方法
dispatchTouchEvent(MotionEvent ev)  
onInterceptTouchEvent(MotionEvent ev)  
onTouchEvent(MotionEvent event)  

setOnTouchListener
setOnClickListener

事件分发流程  
Activity dispatchTouchEvent -> PhoneWindow superDispatchTouchEvent -> DecorView(ViewGroup) superDispatchTouchEvent

ViewGroup 的事件分发

dispatchTouchEvent 

判断是否需要拦截本次事件

if(!disallowIntercept) intercepted = onInterceptTouchEvent

else intercepted = false

if(!intercepted)   
遍历所有的 childView 选择接收当前事件的 childView

dispatchTransformedTouchEvent(ev, false, child, idBitsToAssign)

handled = child.dispatchTouchEvent(event)

在调用 onTouchEvent 之前会调用 mOnTouchListener(setOnTouchListener 设置的)

child.onTouchListener

else
dispatchTransformedTouchEvent(MotionEvent event, boolean cancel,
            View child, int desiredPointerIdBits)
            
child == null

handled = super.dispatchTouchEvent(event);







