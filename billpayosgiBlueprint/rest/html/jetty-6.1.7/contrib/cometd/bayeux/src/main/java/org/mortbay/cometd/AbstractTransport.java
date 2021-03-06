package org.mortbay.cometd;
//========================================================================
//Copyright 2007 Mort Bay Consulting Pty. Ltd.
//------------------------------------------------------------------------
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at 
//http://www.apache.org/licenses/LICENSE-2.0
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
//========================================================================

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import dojox.cometd.Message;


public abstract class AbstractTransport implements Transport
{
    private HttpServletResponse _response;
    private Message _pollReply;
    
    public void setResponse(HttpServletResponse response) throws IOException
    {
        _response=response;
    }
    
    public HttpServletResponse getResponse()
    {
        return _response;
    }
    
    public Message getPollReply()
    {
        return _pollReply;
    }

    public void setPollReply(Message reply)
    {
        _pollReply=reply;
    }

    public void send(List<Message> messages) throws IOException
    {
        if (messages!=null)
        {
            for (Message message: messages)
                send(message);
        }
    }
    
}
