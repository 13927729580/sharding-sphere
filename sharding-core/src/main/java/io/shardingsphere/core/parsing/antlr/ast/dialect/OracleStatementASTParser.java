/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.core.parsing.antlr.ast.dialect;

import io.shardingsphere.core.parsing.antlr.ast.SQLASTParser;
import io.shardingsphere.core.parsing.antlr.ast.advanced.AdvancedErrorStrategy;
import io.shardingsphere.core.parsing.antlr.ast.advanced.AdvancedMatchHandler;
import io.shardingsphere.core.parsing.antlr.ast.advanced.AdvancedParserATNSimulator;
import io.shardingsphere.core.parsing.antlr.autogen.OracleStatementParser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

/**
 * Oracle statement AST parser.
 * 
 * @author duhongjun
 */
public final class OracleStatementASTParser extends OracleStatementParser implements SQLASTParser {
    
    private final AdvancedMatchHandler advancedMatchHandler;
    
    public OracleStatementASTParser(final TokenStream input) {
        super(input);
        _interp = new AdvancedParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache, ID);
        _errHandler = new AdvancedErrorStrategy(ID);
        advancedMatchHandler = new AdvancedMatchHandler(this, ID);
    }
    
    @Override
    public Token match(final int tokenType) throws RecognitionException {
        if (Token.EOF == tokenType) {
            matchedEOF = true;
        }
        return advancedMatchHandler.getMatchedToken(tokenType);
    }
}
