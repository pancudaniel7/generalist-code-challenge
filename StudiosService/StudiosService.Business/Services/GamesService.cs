using StudiosService.Business.Dtos;
using StudiosService.Business.Parameters;
using StudiosService.Data.Models;
using StudiosService.Data.Repositories;
using StudiosService.Infrastructure.Utils;

namespace StudiosService.Business.Services
{
    public class GamesService
    {
        private readonly GamesRepository _gamesRepository;

        public GamesService(GamesRepository gamesRepository)
        {
            _gamesRepository = gamesRepository;
        }

        public async Task<GameDto> AddGameAsync(GameParameters gameParameters)
        {
            var gameToAdd = new Game(gameParameters.Name, RandomGenerator.GenerateRandomNumberBetween(1, 6),
                gameParameters.StudioKey, gameParameters.Content);
            await _gamesRepository.AddGameAsync(gameToAdd);

            var gameDto = GameDto.MapGameToDto(gameToAdd);

            return gameDto;
        }

        public async Task DeleteGameAsync(int id)
        {
            await _gamesRepository.DeleteGameAsync(id);
        }

        public async Task<IEnumerable<GameDto>> GetGamesAsync(int studioKey)
        {
            var games = studioKey == 0 ? (await _gamesRepository.GetGamesAsync()).ToList() : (await _gamesRepository.GetGamesByStudioAsync(studioKey)).ToList();

            return games.Select(GameDto.MapGameToDto);
        }
    }
}
