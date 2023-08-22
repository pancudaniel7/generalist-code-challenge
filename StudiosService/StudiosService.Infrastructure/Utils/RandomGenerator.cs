namespace StudiosService.Infrastructure.Utils
{
    public static class RandomGenerator
    {
        private static readonly Random Random = new();

        public static double GenerateRandomNumberBetween(double minValue, double maxValue)
        {
            var next = Random.NextDouble();
            var valueInsideInterval = minValue + next * (maxValue - minValue);
            var valueInsideIntervalRounded = Math.Round(valueInsideInterval, 1, MidpointRounding.AwayFromZero);

            return valueInsideIntervalRounded;
        }
    }
}
