using System.Net;
using System.Net.Http.Json;
using FluentAssertions;
using StudiosService.Business.Dtos;
using StudiosService.Business.Parameters;
using Xunit;
using Game = StudiosService.WebApi.IntegrationTests.Models.Game;

namespace StudiosService.WebApi.IntegrationTests
{
    public class GamesControllerTests : IntegrationTestsBase
    {
        private const string BaseServiceUri = "api/Games";

        [Fact]
        public async Task When_AddGameIsCalled_Then_ShouldReturnCreated()
        {
            //Arrange
            var gameParameters = new GameParameters
            {
                Content = "The beautiful game",
                Name = "Fifa 23",
                StudioKey = 1
            };
            
            // Act
            var response = await Client.PostAsJsonAsync($"{BaseServiceUri}", gameParameters);

            // Assert
            response.IsSuccessStatusCode.Should().BeTrue();
            response.StatusCode.Should().Be(HttpStatusCode.Created);
        }

        [Fact]
        public async Task When_AddGameIsCalled_Then_ShouldBeInDatabase()
        {
            //Arrange
            var gameParameters = new GameParameters
            {
                Content = "The beautiful game",
                Name = "Fifa 23",
                StudioKey = 1
            };

            // Act
            var response = await Client.PostAsJsonAsync($"{BaseServiceUri}", gameParameters);

            // Assert
            var gameResponse = response.Content.ReadFromJsonAsync<GameDto>();
            var gameRetrievedFromDatabase = TestDataContext.Set<Game>().FirstOrDefault(game => game.Id == gameResponse.Id);
            gameRetrievedFromDatabase.Should().NotBeNull();
        }

        [Fact]
        public async Task When_AddGameIsCalled_Then_ShouldHaveRatingBetweenOneAndFive()
        {
            //Arrange
            var gameParameters = new GameParameters
            {
                Content = "The beautiful game",
                Name = "Fifa 23",
                StudioKey = 1
            };

            // Act
            var response = await Client.PostAsJsonAsync($"{BaseServiceUri}", gameParameters);

            // Assert
            var gameResponse = response.Content.ReadFromJsonAsync<GameDto>();
            var gameRetrievedFromDatabase = TestDataContext.Set<Game>().FirstOrDefault(game => game.Id == gameResponse.Id);
            gameRetrievedFromDatabase!.Rating.Should().BeInRange(1, 5);
        }

        [Fact]
        public async Task When_DeleteGameIsCalled_Then_ShouldReturnNoContent()
        {
            //Arrange
            var gameToAdd = new Game("Fifa 23", 4.5, 1, "The beautiful game");
            gameToAdd.Id = 6;

            await TestDataContext.Set<Game>().AddAsync(gameToAdd);

            // Act
            var response = await Client.DeleteAsync($"{BaseServiceUri}/{gameToAdd.Id}");

            // Assert
            response.IsSuccessStatusCode.Should().BeTrue();
            response.StatusCode.Should().Be(HttpStatusCode.NoContent);
        }

        [Fact]
        public async Task When_DeleteGameIsCalled_Then_ShouldNotBeInTheDatabase()
        {
            //Arrange
            var gameToAdd = new Game("Fifa 23", 4.5, 1, "The beautiful game");

            await TestDataContext.Set<Game>().AddAsync(gameToAdd);

            // Act
            await Client.DeleteAsync($"{BaseServiceUri}/{gameToAdd.Id}");

            // Assert
            var gameRetrievedFromDatabase = TestDataContext.Set<Game>().FirstOrDefault(game => game.Id == gameToAdd.Id);
            gameRetrievedFromDatabase.Should().BeNull();
        }
    }
}
