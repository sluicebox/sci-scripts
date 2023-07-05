;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28300)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Actor)
(use System)

(public
	rm28300 0
)

(instance rm28300 of ScaryRoom
	(properties
		picture 28300
		stepSound 1
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 24610) (IsFlag 138))
			(SetFlag 349)
		)
		(super newRoom: newRoomNumber)
	)

	(method (init &tmp temp0 temp1 temp2)
		(= temp2 0)
		(= temp1 0)
		(switch gChapter
			(1
				(= temp0 904)
			)
			(2
				(= temp1 915)
				(= temp0 905)
			)
			(3
				(if (IsFlag 164)
					(= temp1 916)
					(= temp0 906)
				else
					(= temp1 916)
					(= temp0 906)
				)
			)
			(4
				(= temp1 916)
				(= temp0 906)
			)
			(5
				(= temp1 917)
				(= temp0 907)
			)
			(6
				(= temp1 918)
				(= temp0 908)
			)
		)
		(if (== (gGDacSound number:) temp0)
			(if (not (gGDacSound handle:))
				(gGDacSound number: temp0 setLoop: -1 play: setVol: 127)
			else
				(gGDacSound setVol: 127)
			)
		else
			(gGDacSound number: temp0 setLoop: -1 play: setVol: 127)
		)
		(gEgo init: setScaler: Scaler 75 61 134 105 normalize:)
		((ScriptID 30) init:) ; FidgetCode
		(cond
			((== gChapter 5)
				(= picture 28301)
				(gEgo fadePalette: 28100)
				(if (!= gPrevRoomNum 34100)
					(car
						view: 28301
						init:
						posn: -44 119
						approachVerbs: 4 ; Do
						setHotspot: 4 3 ; Do, Move
					)
				)
			)
			((!= gPrevRoomNum 34100)
				(car init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
			)
		)
		(southExit init: 3)
		(westExit init: 4)
		(if (and (< gChapter 3) (not (IsFlag 162)))
			(closedDoor init:)
			(carriageDoor init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		else
			(carriageEntrance init: 10)
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28100
				(gEgo normalize: 7 posn: 80 130)
				(if (gFeatures contains: carriageEntrance)
					(carriageEntrance
						approachX: (+ (gEgo x:) 30)
						approachY: (- (gEgo y:) 30)
					)
				else
					(carriageDoor
						approachX: (+ (gEgo x:) 30)
						approachY: (- (gEgo y:) 30)
					)
				)
				(= temp2 (ScriptID 0 5)) ; takeLastStep
			)
			(34100
				(= picture 34260)
				(gEgo hide:)
				(car hide:)
				(= temp2 sExitCar)
			)
			(24000
				(gEgo normalize: 2 posn: 182 114)
				(= temp2 (ScriptID 0 5)) ; takeLastStep
				(southExit
					approachX: (gEgo x:)
					approachY: (+ (gEgo y:) 50)
				)
			)
			(24010
				(gEgo normalize: 2 posn: 182 114)
				(= temp2 (ScriptID 0 5)) ; takeLastStep
				(southExit
					approachX: (gEgo x:)
					approachY: (+ (gEgo y:) 50)
				)
			)
			(24610
				(gEgo normalize: 2 posn: 182 114)
				(= temp2 (ScriptID 0 5)) ; takeLastStep
				(southExit
					approachX: (gEgo x:)
					approachY: (+ (gEgo y:) 50)
				)
			)
			(28310
				(gEgo normalize: 6 posn: 182 114)
				(= picture 34220)
				(= temp2 stillTryingDoorScr)
			)
			(28700
				(gEgo normalize: 0 posn: 31 127)
				(= temp2 (ScriptID 0 5)) ; takeLastStep
			)
			(else
				(gEgo normalize: 5 posn: 80 130)
			)
		)
		(if (and (not (IsFlag 231)) (not (IsFlag 65)) (== gChapter 3))
			(SetFlag 65)
			(= picture 24010)
			(= temp2 sMeetCyrus)
		)
		(super init: &rest)
		(if temp2
			(gCurRoom setScript: temp2)
		else
			(gGame handsOn:)
		)
	)
)

(instance sNoGo of Script
	(properties)

	(method (dispose)
		(= global125 69)
		(super dispose: &rest)
		(gCurRoom newRoom: 28700)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(car view: 34262 posn: 209 131)
					(gEgo hide:)
					(proc1111_7 1605 55 46 gEgo -1 1)
					(gCurRoom drawPic: 34261 picture: 34261)
				)
				(1
					(self dispose:)
				)
			)
		else
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance sGoToTown of Script
	(properties)

	(method (dispose)
		(if global115
			(if (Robot 6) ; Exists
				(Robot 10) ; Pause
			)
			(gGame fade: 100 0 2)
			(proc1111_6)
			(= global115 0)
		else
			(gGame fade: 100 0 2)
		)
		(super dispose: &rest)
		(gCurRoom newRoom: 34100)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: car)
						(car dispose:)
					)
					(if (gCast contains: closedDoor)
						(closedDoor dispose:)
					)
					(gEgo hide:)
					(proc1111_7 1603 155 50 gEgo 100 1)
					(gCurRoom drawPic: 34260 picture: 34260)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)
)

(instance tryDoorScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: car)
						(car hide:)
					)
					(if (gCast contains: closedDoor)
						(closedDoor hide:)
					)
					(proc1111_7 1630 91 29 gEgo -1 1)
					(SetFlag 207)
					(gCurRoom drawPic: 34220 picture: 34220)
				)
				(1
					(gEgo hide:)
					(gCurRoom newRoom: 28310)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(SetFlag 207)
					(gCurRoom drawPic: 28300 picture: 28300)
					(car show:)
					(closedDoor show:)
					(gEgo normalize: 6 posn: 150 110)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance stillTryingDoorScr of Script
	(properties)

	(method (dispose)
		(= global163 carriageDoor)
		(gCurRoom drawPic: 28300)
		(if (gCast contains: car)
			(car show:)
		)
		(closedDoor show:)
		(gEgo normalize: 6 posn: 150 110)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: car)
						(car hide:)
					)
					(if (gCast contains: closedDoor)
						(closedDoor hide:)
					)
					(proc1111_7 1631 107 32)
				)
				(1
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance doorAgainScr of Script
	(properties)

	(method (dispose)
		(gEgo posn: 150 110 normalize: 6)
		(gCurRoom drawPic: 28300 picture: 28300)
		(if (gCast contains: car)
			(car show:)
		)
		(closedDoor show:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (gCast contains: car)
						(car hide:)
					)
					(closedDoor hide:)
					(gGame handsOff:)
					(proc1111_7 1632 -6 -34)
					(gCurRoom drawPic: 34220 picture: 34220)
				)
				(1
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance sMeetCyrus of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: car)
						(car dispose:)
					)
					(Load rsPIC 24020)
					(proc1111_7 3200 35 0 gEgo 200)
				)
				(1
					(proc1111_7 3201 -28 -43 gEgo -1)
					(gCurRoom drawPic: 24020 picture: 24020)
				)
				(2
					(proc1111_7 3202 45 -41 gEgo -1)
					(gCurRoom drawPic: 24010 picture: 24010)
				)
				(3
					(gEgo hide:)
					(SetFlag 231)
					(gCurRoom newRoom: 24000)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(SetFlag 231)
					(gCurRoom newRoom: 24000)
				)
			)
		)
	)
)

(instance sToCarriage of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gGDacSound stop:)
					(gGame doRemap: 0)
					(gCurRoom newRoom: 24610)
				)
			)
		else
			(gGame doRemap: 0)
			(= global115 0)
			(gCurRoom newRoom: 24610)
		)
	)
)

(instance sExitCar of Script
	(properties)

	(method (dispose)
		(gCurRoom drawPic: 28300 picture: 28300)
		(car init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(gEgo show: normalize: 0 posn: 11 129)
		(SetFlag 102)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1601 10 -9)
					(gGame fade: 0 100 2)
				)
				(1
					(self dispose:)
				)
			)
		else
			(= global115 0)
			(proc1111_6)
			(self dispose:)
		)
	)
)

(instance closedDoor of View
	(properties
		x 147
		y 35
		view 28302
	)
)

(instance car of View
	(properties
		approachY 115
		x -43
		y 119
		view 28300
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gChapter 5)
				(gCurRoom setScript: sNoGo)
			else
				(gCurRoom setScript: sGoToTown)
			)
		else
			(super doVerb: &rest)
		)
	)
)

(instance carriageEntrance of ExitFeature
	(properties
		nsLeft 153
		nsTop 43
		nsRight 212
		nsBottom 96
		approachX 182
		approachY 112
		nextRoom 24610
	)

	(method (init)
		(cond
			((== gChapter 5)
				(= nextRoom 24000)
			)
			((and (< gChapter 3) (not (IsFlag 66)))
				(= nextRoom 24000)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGDacSound stop:)
		)
		(super doVerb: theVerb)
	)
)

(instance carriageDoor of Feature
	(properties
		nsLeft 153
		nsTop 43
		nsRight 212
		nsBottom 96
		approachX 182
		approachY 112
		x 183
		y 96
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 207)
					(gGame handsOff:)
					(gCurRoom setScript: doorAgainScr)
				else
					(gGame handsOff:)
					(gCurRoom setScript: tryDoorScr)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		approachY 115
		nextRoom 28700
	)
)

(instance southExit of ExitFeature
	(properties
		approachX 130
		approachY 180
		nextRoom 28100
	)
)

