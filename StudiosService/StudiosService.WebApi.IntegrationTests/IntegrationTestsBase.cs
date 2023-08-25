using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.TestHost;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using System.Reflection;
using Xunit;

[assembly: CollectionBehavior(DisableTestParallelization = true)]
namespace StudiosService.WebApi.IntegrationTests
{
    public class IntegrationTestsBase : IAsyncLifetime
    {
        protected static IConfiguration Configuration => GetConfiguration();

        protected HttpClient Client => ConfigureClient<DummyStartup>();

        protected TestDataContext TestDataContext => GetTestDataContext();

        private const string DeleteScriptName = "Cleanup";

        private const string SetupScriptName = "Setup";

        private HttpClient ConfigureClient<TStartup>()
        where TStartup : class
        {
            Environment.SetEnvironmentVariable("ASPNETCORE_ENVIRONMENT", "Development");

            var webHost = new WebHostBuilder()
                .UseConfiguration(Configuration)
                .UseStartup<TStartup>();

            var testServer = new TestServer(webHost);
            var client = testServer.CreateClient();

            return client;
        }

        private static IConfiguration GetConfiguration()
        {
            var config = new ConfigurationBuilder()
                 .SetBasePath(Directory.GetCurrentDirectory())
                 .AddJsonFile("appsettings.test.json", optional: false, reloadOnChange: true)
                 .AddJsonFile($"appsettings.test.{Environment.GetEnvironmentVariable("ASPNETCORE_ENVIRONMENT") ?? "Development"}.json", optional: true)
                 .AddEnvironmentVariables()
                 .Build();

            return config;
        }

        private static TestDataContext GetTestDataContext()
        {
            var mySqlConnectionStr = Configuration.GetConnectionString("DefaultConnection");
            var optionsBuilder = new DbContextOptionsBuilder<TestDataContext>();

            if (mySqlConnectionStr != null)
            {
                optionsBuilder.UseMySQL(mySqlConnectionStr);
            }

            return new TestDataContext(optionsBuilder.Options);
        }

        public async Task InitializeAsync()
        {
            await CleanupDatabase();
            await SetupDatabase();
        }

        public async Task DisposeAsync()
        {
            await CleanupDatabase();
        }

        private async Task CleanupDatabase()
        {
            await ExecuteSqlScriptFromFile(DeleteScriptName);
        }

        private async Task SetupDatabase()
        {
            await ExecuteSqlScriptFromFile(SetupScriptName);
        }

        private async Task ExecuteSqlScriptFromFile(string scriptName)
        {
            var fileAssembly = Assembly.GetExecutingAssembly();
            var baseResourcePath = $"{fileAssembly.GetName().Name}.Scripts";
            var filePath = $"{baseResourcePath}.{scriptName}.sql";
            var sqlCommandResult = FileHelperComponent.ExtractStringContentFromFile(fileAssembly, filePath);

            if (sqlCommandResult.IsFailure)
            {
                return;
            }

            await TestDataContext.Database.ExecuteSqlRawAsync(sqlCommandResult.Value);
        }
    }
}
