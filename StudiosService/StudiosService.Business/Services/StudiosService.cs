using StudiosService.Data.Repositories;

namespace StudiosService.Business.Services
{
    public class StudiosService
    {
        private readonly StudiosRepository _studiosRepository;
        private readonly GamesRepository _gamesRepository;

        public StudiosService(StudiosRepository studiosRepository, GamesRepository gamesRepository)
        {
            _studiosRepository = studiosRepository;
            _gamesRepository = gamesRepository;
        }

        public async Task DeleteStudioAsync(int id)
        {
            var gamesToDelete = await _gamesRepository.GetGamesByStudioAsync(id);
            foreach (var gameToDelete in gamesToDelete)
            {
                await _gamesRepository.DeleteGameAsync(gameToDelete.Id);
            }

            await _studiosRepository.DeleteStudioAsync(id);
        }
    }
}
