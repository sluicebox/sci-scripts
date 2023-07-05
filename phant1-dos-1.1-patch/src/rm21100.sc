;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm21100 0
)

(instance rm21100 of ScaryRoom
	(properties
		picture 21100
		stepSound 1
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(if (== gChapter 5)
			(= picture 21101)
			(gEgo fadePalette: 28100)
		)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 76 32 135 47
			normalize:
		)
		(if (not (gGDacSound handle:))
			(gGDacSound
				number:
					(switch gChapter
						(4 9060)
						(5 9070)
						(else 9080)
					)
				setLoop: -1
				play:
				setVol: 127
			)
		else
			(gGDacSound setVol: 127)
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28900
				(gEgo view: 3 heading: 0 posn: 231 125)
				(waterProp2 init:)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
			(else
				(if (IsFlag 239)
					(ClearFlag 239)
					(gEgo show: posn: 55 58 normalize: 2)
					(door approachY: 300)
					(gGame handsOn:)
				else
					(gEgo view: 2 heading: 180 x: 176 y: 95)
					(self setScript: (ScriptID 0 5)) ; takeLastStep
				)
				(waterProp2 init:)
			)
		)
		(if (and (!= gChapter 5) (!= gChapter 6))
			(telescope init: approachVerbs: 4 18 setHotspot: 4 3 18) ; Do, invLensPiece, Do, Move, invLensPiece
		)
		(if (!= gChapter 6)
			(door init: 1 approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(southExit init: 3)
		(super init: &rest)
	)
)

(instance cantSeeScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 4440 8 -39)
					(if (== gChapter 5)
						(waterProp init: 34276)
						(gCurRoom drawPic: 34276)
					else
						(waterProp init: 34275)
						(gCurRoom drawPic: 34275)
					)
				)
				(1
					(waterProp dispose:)
					(proc1111_7 4441 65 -1)
					(if (== gChapter 5)
						(gCurRoom drawPic: 34296)
					else
						(waterProp init: 34290)
						(gCurRoom drawPic: 34290)
					)
				)
				(2
					(waterProp dispose:)
					(waterProp2 init:)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gEgo show: posn: 55 50 normalize: 2)
					(door approachY: 300)
					(SetFlag 262)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(if (gCast contains: waterProp)
						(waterProp dispose:)
					)
					(if (not (gCast contains: waterProp2))
						(waterProp2 init:)
					)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gEgo show: posn: 55 50 normalize: 2)
					(door approachY: 300)
					(SetFlag 262)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance thruTelescopeScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not global115)
			(switch (= state newState)
				(0
					(= temp0 0)
					(waterProp dispose:)
					(waterProp2 dispose:)
					(if (and (not (IsFlag 262)) (not (IsFlag 189)))
						(= temp0 1)
						(proc1111_7 4440 8 -39)
					else
						(proc1111_7 4460 -8 -25 gEgo 200)
					)
					(cond
						((== gChapter 5)
							(waterProp init: 34276)
							(gCurRoom drawPic: 34276)
						)
						((and (not temp0) (IsFlag 189))
							(gCurRoom drawPic: 34285)
						)
						(temp0
							(gCurRoom drawPic: 34275)
						)
						(else
							(gCurRoom drawPic: 34285)
						)
					)
				)
				(1
					(if (gCast contains: waterProp)
						(waterProp dispose:)
					)
					(gEgo hide:)
					(gCurRoom drawPic: 21287)
					(= seconds 7)
				)
				(2
					(proc1111_7 4451 61 -15)
					(if (== gChapter 5)
						(gCurRoom drawPic: 34291)
					else
						(waterProp init: 34290)
						(gCurRoom drawPic: 34290)
					)
				)
				(3
					(waterProp dispose:)
					(waterProp2 init:)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gEgo show: posn: 55 50 normalize: 2)
					(door approachY: 300)
					(SetFlag 189)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(if (gCast contains: waterProp)
						(waterProp dispose:)
					)
					(if (not (gCast contains: waterProp2))
						(waterProp2 init:)
					)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gEgo show: posn: 55 50 normalize: 2)
					(door approachY: 300)
					(SetFlag 189)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance installLensScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load rsVIEW 21288)
					(SetFlag 188)
					(gEgo put: 12) ; invLensPiece
					(waterProp2 dispose:)
					(proc1111_7 4470 -3 -16)
					(gCurRoom drawPic: 21288)
				)
				(1
					(lensView init:)
				)
				(2
					(lensView dispose:)
					(waterProp2 init:)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gEgo posn: 55 50 normalize: 2)
					(door approachY: 300)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(if (gCast contains: lensView)
						(lensView dispose:)
					)
					(if (not (gCast contains: waterProp2))
						(waterProp2 init:)
					)
					(gCurRoom drawPic: (gCurRoom picture:))
					(SetFlag 188)
					(gEgo put: 12 posn: 55 50 normalize: 2) ; invLensPiece
					(door approachY: 300)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance telescope of Feature
	(properties
		nsLeft 56
		nsTop 32
		nsRight 71
		nsBottom 51
		approachX 57
		approachY 48
		x 62
		y 51
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (IsFlag 188))
					(gGame handsOff:)
					(gCurRoom setScript: cantSeeScr)
				else
					(gGame handsOff:)
					(gCurRoom setScript: thruTelescopeScr)
				)
			)
			(18 ; invLensPiece
				(gGame handsOff:)
				(gCurRoom setScript: installLensScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 167
		nsTop 53
		nsRight 188
		nsBottom 86
		approachX 175
		approachY 85
		x 177
		y 86
		nextRoom 21000
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (== (gEgo x:) 176))
			(= approachX 175)
			(= approachY 85)
		else
			(= approachX 220)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 21000)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 190
		approachX 231
		approachY 200
		nextRoom 28900
	)
)

(instance waterProp of Prop
	(properties
		y 131
	)

	(method (init param1)
		(if (gCast contains: waterProp2)
			(waterProp2 dispose:)
		)
		(= view param1)
		(super init:)
		(self setCycle: Fwd cycleSpeed: 10)
	)
)

(instance waterProp2 of Prop
	(properties
		x 12
		y 56
	)

	(method (init)
		(if (== gChapter 5)
			(= view 21101)
		else
			(= view 21100)
		)
		(super init:)
		(self setCycle: Fwd cycleSpeed: 10 setPri: 49)
	)
)

(instance lensView of View
	(properties
		x 157
		y 78
		view 21288
	)
)

