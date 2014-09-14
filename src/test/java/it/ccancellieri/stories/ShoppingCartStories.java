package it.ccancellieri.stories;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory.ResolveToPackagedName;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartStories extends JUnitStories {
    private EmbedderControls embedderControls;

    @Before
    public void setup() {

        useConfiguration(new MostUsefulConfiguration());
        configuration().useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats());
        configuration().useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));

        Assert.assertNotNull(configuration());
        embedderControls = configuredEmbedder().embedderControls();
        embedderControls.doBatch(false);
        embedderControls.doGenerateViewAfterStories(true);
        embedderControls.doIgnoreFailureInStories(false);
        embedderControls.doIgnoreFailureInView(false);
        embedderControls.doSkip(false);
        embedderControls.doVerboseFailures(true);
        embedderControls.doVerboseFiltering(true);
        embedderControls.useStoryTimeoutInSecs(300);
        embedderControls.useThreads(1);
    }

    protected List<String> storyPaths() {
        return new StoryFinder().findPaths("src/test/resources/", "**/*.story", "");
    }

    @Test
    public void run() throws Throwable {
        Embedder embedder = configuredEmbedder();
        embedder.useCandidateSteps(stepsFactory().createCandidateSteps());
        embedder.runStoriesAsPaths(storyPaths());
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new ShoppingCartSteps());
    }

    private final CrossReference xref = new CrossReference();

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
        // Start from default ParameterConverters instance
        ParameterConverters parameterConverters = new ParameterConverters();
        // factory to allow parameter conversion and loading from external
        // resources (used by StoryParser too)
        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters);
        // add custom converters
        parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")), new ExamplesTableConverter(examplesTableFactory));

        return new MostUsefulConfiguration()
            .useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
            .useStoryLoader(new LoadFromClasspath(embeddableClass))
            .useStoryParser(new RegexStoryParser(examplesTableFactory))
            .useStoryPathResolver(new UnderscoredCamelCaseResolver())
            .useStoryReporterBuilder(new StoryReporterBuilder().withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass)).withDefaultFormats()
                                         .withPathResolver(new ResolveToPackagedName()).withViewResources(viewResources)
                                         .withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML).withFailureTrace(true).withFailureTraceCompression(true)
                                         .withCrossReference(xref)).useParameterConverters(parameterConverters).useStepPatternParser(new RegexPrefixCapturingPatternParser("%"))
            .useStepMonitor(xref.getStepMonitor());
    }

}
