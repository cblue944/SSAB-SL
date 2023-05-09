package ax.lindblom;

import ax.lindblom.ssab.model.Line;
import ax.lindblom.ssab.model.Stop;

import java.util.List;

public class TestData {
    public final static String TRAFIKLAB_RESULT = """
            {
              "StatusCode": 0,
              "Message": null,
              "ExecutionTime": 444,
              "ResponseData": {
                "Version": "2023-05-01 00:11",
                "Type": "JourneyPatternPointOnLine",
                #RESULT#
              }
            }
            """;

    public final static String JOURNEY_POINTS = TRAFIKLAB_RESULT.replace("#RESULT#", """
                "Result": [
                  {
                    "LineNumber": "1",
                    "DirectionCode": "1",
                    "JourneyPatternPointNumber": "10008",
                    "LastModifiedUtcDateTime": "2022-02-15 00:00:00.000",
                    "ExistsFromDate": "2022-02-15 00:00:00.000"
                  },
                  {
                    "LineNumber": "1",
                    "DirectionCode": "1",
                    "JourneyPatternPointNumber": "10012",
                    "LastModifiedUtcDateTime": "2023-03-07 00:00:00.000",
                    "ExistsFromDate": "2023-03-07 00:00:00.000"
                  },
                  {
                    "LineNumber": "1",
                    "DirectionCode": "1",
                    "JourneyPatternPointNumber": "10014",
                    "LastModifiedUtcDateTime": "2022-08-10 00:00:00.000",
                    "ExistsFromDate": "2022-08-10 00:00:00.000"
                  }
                ]
            """);
    public final static String STOP_POINTS = TRAFIKLAB_RESULT.replace("#RESULT#", """
                  "Result": [
                    {
                      "StopPointNumber": "10008",
                      "StopPointName": "Centralen",
                      "StopAreaNumber": "1051",
                      "LocationNorthingCoordinate":"59.3519283258878",
                      "LocationEastingCoordinate":"18.0634050753927",
                      "ZoneShortName":"A",
                      "StopAreaTypeCode":"BUSTERM",
                      "LastModifiedUtcDateTime":"2014-06-03 00:00:00.000",
                      "ExistsFromDate":"2014-06-03 00:00:00.000"
                    },
                    {
                      "StopPointNumber": "10012",
                      "StopPointName": "Gärdet",
                      "StopAreaNumber": "1052",
                      "LocationNorthingCoordinate":"59.3519283258878",
                      "LocationEastingCoordinate":"18.0634050753927",
                      "ZoneShortName":"A",
                      "StopAreaTypeCode":"BUSTERM",
                      "LastModifiedUtcDateTime":"2014-06-03 00:00:00.000",
                      "ExistsFromDate":"2014-06-03 00:00:00.000"
                    },
                    {
                      "StopPointNumber": "10014",
                      "StopPointName": "Östermalm",
                      "StopAreaNumber":"10036",
                      "LocationNorthingCoordinate":"59.3519283258878",
                      "LocationEastingCoordinate":"18.0634050753927",
                      "ZoneShortName":"A",
                      "StopAreaTypeCode":"BUSTERM",
                      "LastModifiedUtcDateTime":"2014-06-03 00:00:00.000",
                      "ExistsFromDate":"2014-06-03 00:00:00.000"
                    }
                  ]
            """);
}
