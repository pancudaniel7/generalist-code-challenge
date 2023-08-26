using StudiosService.WorkerService;

var configuration = new ConfigurationBuilder()
    .SetBasePath(AppContext.BaseDirectory)
    .AddJsonFile("appsettings.json", optional: false, reloadOnChange: true)
    .AddJsonFile($"appsettings.{Environment.GetEnvironmentVariable("DOTNET_ENVIRONMENT") ?? "Production"}.json", optional: true)
    .AddEnvironmentVariables()
    .Build();

var host = Host.CreateDefaultBuilder(args)
    .ConfigureAppConfiguration(c =>
    {
        c.AddConfiguration(configuration);
    })
    .ConfigureServices((hostContext, services) =>
    {
        services.ConfigureWorkerServices(hostContext.Configuration);
        services.AddHostedService<StudiosServiceWorker>();
    })
    .Build();

await host.RunAsync();
