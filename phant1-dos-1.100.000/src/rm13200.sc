;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)
(use Polygon)
(use Feature)
(use System)

(public
	rm13200 0
)

(instance rm13200 of ScaryRoom
	(properties
		picture 13200
		stepSound 4
	)

	(method (init)
		(gUser canControl: 1)
		(gEgo init: setScaler: Scaler 160 52 151 82 normalize:)
		((ScriptID 30) init:) ; FidgetCode
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 202 152 211 89 132 89 121 88 118 92 129 98 122 116 92 117 73 152
					yourself:
				)
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(13400
				(gEgo view: 3 posn: 163 115)
			)
			(else
				(gEgo view: 2 posn: 163 115)
			)
		)
		(super init:)
		(leftDoor init: 4)
		(if (< gChapter 6)
			(balcony init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(northExit init: 1)
		(southExit init: 3)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== gChapter 4)
				(== newRoomNumber 12100)
				(IsFlag 265)
				(not (IsFlag 3))
				(not (IsFlag 247))
			)
			(SetFlag 247)
			(ClearFlag 52)
		)
		(if
			(and
				(== gChapter 4)
				(== newRoomNumber 12100)
				(IsFlag 5)
				(not (IsFlag 325))
			)
			(SetFlag 325)
			(ClearFlag 264)
		)
		(= global115 0)
		(super newRoom: newRoomNumber)
	)
)

(instance sMarieDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if
						(and
							(not (IsFlag 53))
							(> global172 2)
							(== gChapter 1)
							(not (IsFlag 83))
						)
						(SetFlag 53)
					)
					(if
						(and
							(== gChapter 1)
							(IsFlag 53)
							(IsFlag 77)
							(not (IsFlag 78))
						)
						(SetFlag 78)
					)
					(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
						(SetFlag 181)
					)
					(SetFlag 36)
					(gCurRoom newRoom: 12100)
				)
			)
		else
			(switch (= state newState)
				(0
					(if
						(and
							(not (IsFlag 53))
							(> global172 2)
							(== gChapter 1)
							(not (IsFlag 83))
						)
						(SetFlag 53)
					)
					(if
						(and
							(== gChapter 1)
							(IsFlag 53)
							(IsFlag 77)
							(not (IsFlag 78))
						)
						(SetFlag 78)
					)
					(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
						(SetFlag 181)
					)
					(= global115 0)
					(SetFlag 36)
					(gCurRoom newRoom: 12100)
				)
			)
		)
	)
)

(instance sStairWay of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if
						(and
							(not (IsFlag 53))
							(== gChapter 1)
							(> global172 2)
							(not (IsFlag 83))
						)
						(SetFlag 53)
					)
					(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
						(SetFlag 181)
					)
					(= seconds 2)
				)
				(1
					(if (and (== gChapter 6) (IsFlag 198) (not (IsFlag 199)))
						(gCurRoom newRoom: 3430)
					else
						(gCurRoom newRoom: 4200)
					)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(if
						(and
							(not (IsFlag 53))
							(> global172 2)
							(== gChapter 1)
							(not (IsFlag 83))
						)
						(SetFlag 53)
					)
					(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
						(SetFlag 181)
					)
					(if (and (== gChapter 6) (IsFlag 198) (not (IsFlag 199)))
						(gCurRoom newRoom: 3430)
					else
						(gCurRoom newRoom: 4200)
					)
				)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		x 160
		y 180
		nextRoom 13400
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 137
		nsRight 216
		nsBottom 99
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sStairWay)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance leftDoor of ExitFeature
	(properties
		nsLeft 103
		nsTop 39
		nsRight 121
		nsBottom 91
		approachX 121
		approachY 92
		x 111
		y 92
		nextRoom 12100
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sMarieDoor)
		else
			(super doVerb: &rest)
		)
	)
)

(instance stairway of ExitFeature ; UNUSED
	(properties
		nsLeft 148
		nsTop 62
		nsRight 175
		nsBottom 85
		approachX 162
		approachY 84
		x 194
		y 74
		nextRoom 4200
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sStairWay)
		else
			(super doVerb: &rest)
		)
	)
)

(instance balcony of Feature
	(properties
		nsLeft 192
		nsTop 66
		nsRight 214
		nsBottom 85
		approachX 201
		approachY 86
		x 201
		y 74
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= global125 33)
			(gCurRoom newRoom: 13100)
		else
			(super doVerb: &rest)
		)
	)
)

