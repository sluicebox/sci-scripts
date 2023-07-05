;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13500)
(include sci.sh)
(use Main)
(use Trigger)
(use n1111)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	rm13500 0
)

(local
	local0 = 13400
)

(instance rm13500 of ScaryRoom
	(properties
		picture 13400
		stepSound 4
	)

	(method (init &tmp temp0)
		(= temp0 0)
		(gEgo init: normalize: setScaler: Scaler 172 72 155 105)
		(stairs init:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(15100
				(if (== gChapter 5)
					(= local0 (= picture 13401))
				else
					(= local0 (= picture 13400))
				)
				(= temp0 downStairs)
			)
			(13400
				(cond
					((or (not (== gChapter 3)) (not (IsFlag 120))) 0)
					((gGDacSound handle:)
						(gGDacSound setVol: 64)
					)
					(else
						(gGDacSound number: 15020 setLoop: 1 play: setVol: 64)
					)
				)
				(if (== global125 65)
					(= global125 0)
					(if (== gChapter 5)
						(= local0 (= picture 13401))
					else
						(= local0 (= picture 13400))
					)
					(= temp0 upTheStairs)
				else
					(gEgo
						view: 0
						normalize: 0
						heading: 90
						posn: 217 125
						setScaler: Scaler 172 72 155 105
					)
				)
			)
			(else
				(gEgo
					view: 0
					normalize: 0
					heading: 90
					posn: 175 126
					setScaler: Scaler 172 72 155 105
				)
			)
		)
		(if (not (OneOf gChapter 1 7))
			(darkDoorView view: local0 x: 1 y: 1 setPri: 4 init:)
		)
		(super init:)
		(Load rsVIEW 720)
		(darkRoomDoor init:)
		(southExit init:)
		(collectiblesDoorway init:)
		(if temp0
			(self setScript: temp0)
		else
			(gGame handsOn:)
		)
		((ScriptID 30) init:) ; FidgetCode
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== gChapter 4)
				(== newRoomNumber 9100)
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
				(== newRoomNumber 9100)
				(IsFlag 5)
				(not (IsFlag 325))
			)
			(SetFlag 325)
			(ClearFlag 264)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sToHall of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo x: 107 y: 127)
					(= ticks 240)
				)
				(1
					(gCurRoom newRoom: 13400)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gCurRoom newRoom: 13400)
				)
			)
		)
	)
)

(instance sToCollect of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo view: 3 normalize: 3 heading: 0)
					(= seconds 2)
				)
				(1
					(if (and (>= global172 3) (not (IsFlag 83)))
						(SetFlag 53)
					)
					(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
						(SetFlag 181)
					)
					(gCurRoom newRoom: 9100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(if (and (>= global172 3) (not (IsFlag 83)))
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
					(gCurRoom newRoom: 9100)
				)
			)
		)
	)
)

(instance sToDarkRoom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo x: 74 y: 155)
					(= ticks 240)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(= global115 0)
		(= global125 15)
		(gCurRoom newRoom: 13400)
		(super dispose: &rest)
	)
)

(instance darkRoomDoor of Trigger
	(properties
		nsLeft 1
		nsTop 1
		nsRight 59
		nsBottom 131
		approachX 74
		approachY 170
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 21) ; Do, Exit
			(gCurRoom setScript: sToDarkRoom)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance collectiblesDoorway of Trigger
	(properties
		nsLeft 124
		nsTop 28
		nsRight 182
		nsBottom 118
		approachX 157
		approachY 121
		x 157
		y 116
		exitDir 1
		nextRoom 9100
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(gCurRoom setScript: sToCollect)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of Trigger
	(properties
		exitDir 3
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 21) ; Do, Exit
			(gCurRoom newRoom: 13400)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance stairs of Trigger
	(properties
		nsLeft 237
		nsTop 42
		nsRight 294
		nsBottom 126
		approachX 265
		approachY 119
		exitDir 3
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 21) ; Do, Exit
			(gCurRoom setScript: upTheStairs)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance westExit of Trigger ; UNUSED
	(properties
		nsRight 230
		sightAngle 40
		approachX 195
		approachY 155
		exitDir 4
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(= global125 13)
			(gCurRoom setScript: sToHall)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance downStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 721
						setScale: 0
						setScaler: 0
						setLoop: 0 1
						cel: 0
						x: 272
						y: 79
						setPri: 90
					)
					(= ticks 90)
				)
				(1
					(gEgo setCycle: CT 31 1 self)
				)
				(2
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(gCurRoom newRoom: 13400)
	)
)

(instance upTheStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 720
						x: 260
						y: 121
						cel: 0
						setScaler: 0
						setScale: 0
						setPri: 90
						setLoop: 0 1
					)
					(= ticks 90)
				)
				(1
					(gEgo setCycle: CT 16 1 self)
				)
				(2
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(gCurRoom newRoom: 15100)
	)
)

(instance darkDoorView of View
	(properties)
)

