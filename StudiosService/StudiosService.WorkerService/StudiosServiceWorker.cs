using StudiosService.Business.Services;

namespace StudiosService.WorkerService
{
    public class StudiosServiceWorker : BackgroundService
    {
        private readonly ILogger<StudiosServiceWorker> _logger;
        private readonly IServiceScopeFactory _serviceScopeFactory;

        public StudiosServiceWorker(ILogger<StudiosServiceWorker> logger,
            IServiceScopeFactory serviceScopeFactory)
        {
            _logger = logger;
            _serviceScopeFactory = serviceScopeFactory;
        }

        protected override async Task ExecuteAsync(CancellationToken stoppingToken)
        {
            while (!stoppingToken.IsCancellationRequested)
            {
                _logger.LogInformation("Worker running at: {time}", DateTimeOffset.Now);
                using var scope = _serviceScopeFactory.CreateScope();
                var gamesService = scope.ServiceProvider.GetRequiredService<GamesService>();
                await gamesService.UpdateRandomGameAsync();
                await Task.Delay(5000, stoppingToken);
            }
        }
    }
}