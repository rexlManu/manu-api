/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */

import de.rexlmanu.manuapi.module.Module;
import de.rexlmanu.manuapi.module.ModuleDescription;
import org.jetbrains.annotations.NotNull;

/******************************************************************************************
 *    Urheberrechtshinweis                                                       
 *    Copyright © Emmanuel Lampe 2018                                       
 *    Erstellt: 07.07.2018 / 08:43                           
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.                    
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,       
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.                      
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,        
 *    öffentlichen Zugänglichmachung oder andere Nutzung           
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.  
 ******************************************************************************************/

public final class TestModule implements Module {
    @NotNull
    @Override
    public ModuleDescription getModuleDescription() {
        return new ModuleDescription("Test", "1,0", "rexlManu", "Test Module", "rexlmanu.de", false);
    }

    @Override
    public void load() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
