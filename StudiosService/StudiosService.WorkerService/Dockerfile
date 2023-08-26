#See https://aka.ms/containerfastmode to understand how Visual Studio uses this Dockerfile to build your images for faster debugging.

FROM mcr.microsoft.com/dotnet/runtime:6.0 AS base
WORKDIR /app

FROM mcr.microsoft.com/dotnet/sdk:6.0 AS build
WORKDIR /src
COPY ["StudiosService.WorkerService/StudiosService.WorkerService.csproj", "StudiosService.WorkerService/"]
RUN dotnet restore "StudiosService.WorkerService/StudiosService.WorkerService.csproj"
COPY . .
WORKDIR "/src/StudiosService.WorkerService"
RUN dotnet build "StudiosService.WorkerService.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "StudiosService.WorkerService.csproj" -c Release -o /app/publish /p:UseAppHost=false

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "StudiosService.WorkerService.dll"]