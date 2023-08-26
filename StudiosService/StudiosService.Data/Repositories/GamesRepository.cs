using Microsoft.EntityFrameworkCore;
using StudiosService.Data.Models;
using System;

namespace StudiosService.Data.Repositories
{
    public class GamesRepository
    {
        private readonly DataContext _dataContext;

        public GamesRepository(DataContext dataContext)
        {
            _dataContext = dataContext;
        }

        public async Task AddGameAsync(Game game)
        {
            await _dataContext.Set<Game>().AddAsync(game);
            await _dataContext.SaveChangesAsync();
        }

        public async Task DeleteGameAsync(int id)
        {
            var gameToDelete = await _dataContext.Set<Game>().SingleOrDefaultAsync(game => game.Id == id);
            if (gameToDelete != null)
            {
                _dataContext.Remove(gameToDelete);
                await _dataContext.SaveChangesAsync();
            }
        }


        public async Task<IEnumerable<Game>> GetGamesAsync()
        {
            return await _dataContext.Set<Game>().ToListAsync();
        }

        public async Task<IEnumerable<Game>> GetGamesByStudioAsync(int studioKey)
        {
            return await _dataContext.Set<Game>().Where(game => game.StudioKey == studioKey).ToListAsync();
        }

        public async Task<int> GetCountOfGamesAsync()
        {
            return await _dataContext.Set<Game>().CountAsync();
        }

        public Game GetGameByRowNumber(int rowNumber)
        {
            return _dataContext.Set<Game>().AsQueryable().OrderBy(game => game.Id).Skip(rowNumber).FirstOrDefault();
        }

        public async Task UpdateGameAsync(Game game, double randomValue)
        {
            game.Rating = randomValue;
            _dataContext.Set<Game>().Update(game);
            await _dataContext.SaveChangesAsync();
        }
    }
}
