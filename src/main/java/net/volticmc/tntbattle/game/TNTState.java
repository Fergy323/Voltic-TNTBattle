package net.volticmc.tntbattle.game;

public enum TNTState {

    WAITING{

        @Override
        public TNTState nextState(){
            return STARTING;
        }

        @Override
        public String getMOTDStatus(){
            return "WAITING";
        }
    },
    STARTING{
        @Override
        public TNTState nextState(){
            return IN_GAME;
        }

        @Override
        public String getMOTDStatus(){
            return "STARTING";
        }
    },
    IN_GAME{
        @Override
        public TNTState nextState(){
            return STOPPING;
        }

        @Override
        public String getMOTDStatus(){
            return "IN GAME";
        }
    },
    STOPPING{
        @Override
        public TNTState nextState(){
            return RESTARTING;
        }

        @Override
        public String getMOTDStatus(){
            return "STOPPING";
        }
    },
    RESTARTING{
        @Override
        public TNTState nextState(){
            return this;
        }

        @Override
        public String getMOTDStatus(){
            return "RESTARTING";
        }
    };

    private static TNTState state;

    public static TNTState getState(){
        return state;
    }

    public static void setState(TNTState state){
        TNTState.state = state;
    }

    public static boolean isState(TNTState state){
        return TNTState.state == state;
    }

    public abstract TNTState nextState();
    public abstract String getMOTDStatus();
}
