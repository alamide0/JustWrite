# Fragment 

将围绕以下几个问题，阅读 Fragment 源码。
* Fragment 是什么
* Fragment 体系中几个重要的类，及每个类的职责
* Fragment 的生命周期与 Activity 的生命周期是如何联系的
* commit 之后发生了什么
* getContext() == null，getActivity() == null
* Fragment commitAllowStateLoss 与 commit 的区别，什么情况下会出现 
Can not perform this action after onSaveInstanceState，如何避免？
* 为什么向 Fragment 传递参数时用 Bundle，而不是直接传递？（数据恢复）
* FragmentManager 的作用
* Fragment 的回退栈是如何工作的
* Fragment 使用注意事项
* Fragment 真的那么完美吗？可替代吗？
* 总结

## Fragment 是什么
 官方定义：A Fragment is a piece of an application's user interface or behavior
 that can be placed in an Activity.  Interaction with fragments
 is done through FragmentManager, which can be obtained via
 Activity.getFragmentManager() and Fragment.getFragmentManager().
 
 我的理解：Fragment 是一个组件，能够管理自己的事务，依附于Activity而存在。能够感知Activity的生命周期。它
 可以看成是一个独立的个体，可以被重复使用，提高开发效率。

## Fragment 体系中几个重要的类，及每个类的职责
* FragmentActivity
* FragmentController
* FragmentHostCallback、FragmentContainer
* FragmentManager、FragmentManagerImpl
* FragmentState
* FragmentTransaction、BackStackRecord、BackStackState
* FragmentTransition
* LoaderManager、LoaderManagerImpl

## FragmentActivity

FragmentActivity 中持有 FragmentController 的引用，FragmentActivity 正是通过它与 Fragment 互通消息的。

```
final FragmentController mFragments = FragmentController.createController(new HostCallbacks());
```

先来看看 FragmentActivity 是如何向 Fragment 传递生命周期事件的  
**onCreate**
```
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //FragmentManager 依附到 Activity
        mFragments.attachHost(null /*parent*/);

        super.onCreate(savedInstanceState);

        NonConfigurationInstances nc =
                (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nc != null) {
            mFragments.restoreLoaderNonConfig(nc.loaders);
        }
        //恢复保存的 Fragment
        if (savedInstanceState != null) {
            ...
        }

        if (mPendingFragmentActivityResults == null) {
            mPendingFragmentActivityResults = new SparseArrayCompat<>();
            mNextCandidateRequestIndex = 0;
        }

        mFragments.dispatchCreate();//分发 onCreate 事件
    }
``` 


## Fragment 的生命周期与 Activity 的生命周期是如何联系的

 
 
 