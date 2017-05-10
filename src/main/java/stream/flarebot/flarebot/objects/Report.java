package stream.flarebot.flarebot.objects;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Represents an individual report
 */
public class Report {
    private long guildId;

    private int id;

    private String message;

    private long reporterId;
    private long reportedId;

    private Date time;

    private boolean solved;

    public Report(long guildId, int id, String message, long reporterId, long reportedId, DateTime time, boolean solved){
        this.guildId = guildId;
        this.id = id;
        this.message = message;
        this.time = time.toDate();

        this.reporterId = reporterId;
        this.reportedId = reportedId;

        this.solved = solved;
    }

    public int getId(){ return id; }

    public long getGuildId(){ return guildId; }

    public String getMessage(){ return message; }

    public long getReporterId(){ return reporterId; }

    public long getReportedId(){ return reportedId; }

    public Date getTime(){ return time; }

    public boolean getSolved(){ return solved; }
}
