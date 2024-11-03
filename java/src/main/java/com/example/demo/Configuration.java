package com.example.demo;

import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.*;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.IPlayListRepository;
import com.example.demo.repositories.ISongRepository;
import com.example.demo.repositories.PlayListRepository;
import com.example.demo.repositories.SongRepository;
import com.example.demo.services.GreetingService;
import com.example.demo.services.PlayListService;
import com.example.demo.services.PlayerService;
import com.example.demo.services.SongService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IGreetingRepository greetingRepository = new GreetingRepository();
            private final ISongRepository songRepository = new SongRepository();
            private final IPlayListRepository playListRepository = new PlayListRepository();
    
            // Initialize services
            private final GreetingService greetingService = new GreetingService(greetingRepository);
            private final SongService songService = new SongService(songRepository);
            private final PlayListService playListService = new PlayListService(songRepository,playListRepository);
            private final PlayerService playerService = new PlayerService(playListRepository);


            // Initialize commands
            private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);
            private final AddSongCommand addSongCommand = new AddSongCommand(songService);
            private final ListSongCommand listSongCommand = new ListSongCommand(songService);
            private final CreatePlayListCommand createPlayListCommand = new CreatePlayListCommand(playListService);
            private final AddSongToPlayListComnnad addSongToPlayListComnnad = new AddSongToPlayListComnnad(playListService);
            private final DeleteSongToPlayListComnnad deleteSongToPlayListComnnad = new DeleteSongToPlayListComnnad(playListService);
            private final DeletePlayListCommand deletePlayListCommand = new DeletePlayListCommand(playListService);
            private final LoadPlayListCommand loadPlayListCommand = new LoadPlayListCommand(playerService);
            private final PlaySongCommand playSongCommand = new PlaySongCommand(playerService);
            private final NextSongCommand nextSongCommand = new NextSongCommand(playerService);
            private final PreviousSongCommand previousSongCommand = new PreviousSongCommand(playerService);
            private final StopSongCommand stopSongCommand = new StopSongCommand(playerService);
            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_COMMAND.getName(),addSongCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_SONG_COMMAND.getName(), listSongCommand);
                commandRegistry.registerCommand(CommandKeyword.CREATE_PLAYLIST_COMMAND.getName(),createPlayListCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST_COMMAND.getName(),addSongToPlayListComnnad);
                commandRegistry.registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST_COMMAND.getName(),deleteSongToPlayListComnnad);
                commandRegistry.registerCommand(CommandKeyword.DELETE_PLAYLIST_COMMAND.getName(),deletePlayListCommand);
                commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST_COMMAND.getName(),loadPlayListCommand);
                commandRegistry.registerCommand(CommandKeyword.PLAY_SONG_COMMAND.getName(),playSongCommand);
                commandRegistry.registerCommand(CommandKeyword.NEXT_SONG_COMMAND.getName(),nextSongCommand);
                commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG_COMMAND.getName(), previousSongCommand);
                commandRegistry.registerCommand(CommandKeyword.STOP_SONG_COMMAND.getName(),stopSongCommand );
            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
