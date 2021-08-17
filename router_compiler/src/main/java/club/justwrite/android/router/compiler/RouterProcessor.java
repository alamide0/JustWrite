package club.justwrite.android.router.compiler;

import club.justwrite.android.router.Router;
import com.google.auto.service.AutoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ACC
 * @desc
 * @create 2020/5/9 10:32 AM
 **/

@AutoService(Processor.class)
public class RouterProcessor extends AbstractProcessor {

    private Logger logger;
    private Writer writer;

    private Set<String> supportTypes = new HashSet<>();

    private Elements elements;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        supportTypes.add(Router.class.getCanonicalName());
        logger = new Logger(processingEnv.getMessager());
        logger.info(">>>> RouterProcessor Begin");

        elements = processingEnv.getElementUtils();

        try {
            writer = processingEnv.getFiler().createResource(StandardLocation.SOURCE_OUTPUT, "club.justwrite.android.router.compile", "PathMapping.json").openWriter();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(">>>> 获取输出路径失败");
        }

    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations != null && annotations.size() > 0) {

//            TypeElement typeElement11 = processingEnv.getElementUtils().getTypeElement(Integer.class.getCanonicalName());
//            logger.warning(typeElement11 + "");

            PathMapping pathMapping = new PathMapping();

            TypeElement typeElement0 = processingEnv.getElementUtils().getTypeElement("club.justwrite.java.base.io.IFindClasses");

            logger.info(typeElement0.getQualifiedName().toString());
            logger.info(typeElement0.getEnclosingElement() + "");

            Set<? extends Element> sets = roundEnv.getElementsAnnotatedWith(Router.class);//find all annotation class
            logger.info("发现 " + sets.size() + "个 被注解的类");

            for (Element element : sets) {
                if (element.getKind() != ElementKind.CLASS) {
                    logger.error("注解使用错误");
                }

                Router router = element.getAnnotation(Router.class);
                TypeElement typeElement = (TypeElement) element;

                logger.warning("0000" + typeElement.asType().toString());

                PathMapping.PathMappingItem pathMappingItem = new PathMapping.PathMappingItem();
                pathMappingItem.targetClass = typeElement.getQualifiedName().toString();
                if ("".equals(router.description())) {
                    logger.warning(pathMappingItem.targetClass + " was not set description");
                }
                pathMappingItem.description = router.description();

                if ("".equals(router.path())) {
                    logger.error(pathMappingItem.targetClass + " was not set path");
                }
                pathMappingItem.path = router.path();
                pathMappingItem.needLogin = router.needLogin();

                pathMapping.mappings.add(pathMappingItem);
            }

            if (pathMapping.mappings.size() > 0) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                try {
                    writer.write(gson.toJson(pathMapping.mappings));
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return supportTypes;
    }
}
