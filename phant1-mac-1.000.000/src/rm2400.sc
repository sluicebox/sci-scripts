;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2400)
(include sci.sh)
(use Main)
(use VCycle)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	rm2400 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm2400 of ScaryRoom
	(properties
		picture 2400
		stepSound 4
	)

	(method (init)
		(if (== gChapter 5)
			(= picture 2401)
		)
		((ScriptID 30) init:) ; FidgetCode
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 181 87 67 96 67 104 142 97 180 100 167 129 292 129 292 106
					yourself:
				)
		)
		(southExit init: 3)
		(eastExit init: 2)
		(gardenDoor init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(switch gPrevRoomNum
			(900
				(if (OneOf (gEgo view:) 370 2239 2240 2242)
					(gEgo
						setScale: 0
						view: 370
						setLoop: 0
						setCel: 21
						setPri: -1
						posn: 149 118
						init:
						setCycle: Beg self
					)
					(self setScript: sEgoInChair)
				else
					(gEgo init: setScaler: Scaler 143 61 118 90 normalize:)
					(gGame handsOn:)
				)
			)
			(2200
				(gEgo init: setScaler: Scaler 143 61 118 90)
				(if (< (gEgo x:) 140)
					(gEgo normalize: 12 loop: 0 cel: 0 posn: 25 109)
				else
					(gEgo normalize: 7 loop: 0 cel: 0 posn: 248 124)
				)
				(if (and (== gChapter 7) (== global125 30))
					(self setScript: sDoorsSlam)
				else
					(self setScript: sEnter)
				)
			)
			(else
				(gEgo
					init:
					setScaler: Scaler 143 61 118 90
					normalize: 2
					posn: 197 96
				)
				(if (== global125 30)
					(self setScript: sDoorsSlam)
				else
					(self setScript: sEnter)
				)
				(cond
					((or (and (== gChapter 1) (IsFlag 39)) (== gChapter 2)))
					((OneOf gChapter 3 4))
					((OneOf gChapter 5 6))
					(else
						(OneOf gChapter 7)
					)
				)
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Move
				(if
					(and
						(== (gCurRoom script:) sEgoInChair)
						(proc0_6 (gUser curEvent:))
					)
					(= local2 3)
					(= local3 ((gUser curEvent:) x:))
					(= local4 ((gUser curEvent:) y:))
					(gCurRoom setScript: sGetUp 0 self)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 121)
				(gGame handsOff:)
				(if (== gPrevRoomNum 2200)
					(if (< (gEgo x:) 140)
						(self setScript: (ScriptID 0 5) self 20) ; takeLastStep
					else
						(self setScript: (ScriptID 0 5) self 25) ; takeLastStep
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if (and (== gPrevRoomNum 2200) (== global125 57))
					(= global125 0)
					(self setScript: sSitDown self)
				else
					(gEgo normalize: 2)
					(= cycles 1)
				)
			)
			(2
				(ClearFlag 121)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoorsSlam of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(= global125 0)
					(SetFlag 202)
					(gCurRoom newRoom: 2200)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 5930 104 27 gEgo 1)
				)
				(1
					(= global125 0)
					(SetFlag 202)
					(gCurRoom newRoom: 2200)
				)
			)
		)
	)
)

(instance sSitDown of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setPri: 118)
					(gEgo setHeading: 125 self)
				)
				(1
					(chair dispose:)
					(gEgo
						setScale: 0
						view: 370
						setLoop: 0
						setCel: 21
						setPri: -1
						posn: 149 118
						setCycle: Beg self
					)
				)
				(2
					(gCurRoom setScript: sEgoInChair)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(chair dispose:)
					(gEgo
						setScale: 0
						view: 370
						setLoop: 0
						setCel: 0
						setPri: -1
						posn: 149 118
					)
					(= global115 0)
					(gCurRoom setScript: sEgoInChair)
				)
			)
		)
	)
)

(instance sEgoInChair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gUser canControl: 0)
				(gEgo loop: 0 cel: 0)
				(if (== (= local0 (Random 1 3)) local1)
					(= local0 (+ (mod local0 3) 1))
				)
				(= local1 local0)
				(switch local0
					(1
						(gEgo view: 2239 setCycle: VEnd 2239 2239 self)
					)
					(2
						(gEgo view: 2240 setCycle: VEnd 2240 2240 self)
					)
					(3
						(gEgo view: 2242 setCycle: VEnd 2242 2242 self)
					)
				)
			)
			(1
				(= seconds (* (Random 1 3) 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sGetUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (gEgo cycler:)
					(-- state)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(2
				(sEgoInChair ticks: 0 dispose:)
				(gEgo view: 370 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(chair init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
				(gEgo
					view: 5
					cel: 0
					posn: 172 121
					setScaler: Scaler 143 61 118 90
					normalize:
				)
				(gUser canControl: 1)
				(gGame handsOn:)
				(if (!= register gCurRoom)
					(register doVerb: local2)
				)
				(self dispose:)
			)
		)
	)
)

(instance fadeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 300
					loop: 0
					cel: 0
					setScale: 0
					posn: 206 97
					setCycle: End self
				)
			)
			(1
				(gCurRoom newRoom: 28815)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 169
		nsRight 293
		approachX 231
		approachY 125
		x 231
		y 125
		nextRoom 2200
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(if (== (gCurRoom script:) sEgoInChair)
					(= local2 theVerb)
					(gCurRoom setScript: sGetUp 0 self)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 284
		nsTop 107
		nsRight 293
		nsBottom 122
		approachX 288
		approachY 114
		x 288
		y 114
		nextRoom 2200
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(if (== (gCurRoom script:) sEgoInChair)
					(= local2 theVerb)
					(gCurRoom setScript: sGetUp 0 self)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gardenDoor of Feature
	(properties
		nsLeft 187
		nsTop 44
		nsRight 214
		nsBottom 87
		approachX 204
		approachY 97
		x 200
		y 87
	)

	(method (handleEvent event)
		(if
			(and
				(== (gCurRoom script:) sEgoInChair)
				(== (= local2 (event message:)) JOY_DOWNRIGHT)
				(self onMe: event)
			)
			(gCurRoom setScript: sGetUp 0 self)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== (gCurRoom script:) sEgoInChair)
						(= local2 theVerb)
						(gCurRoom setScript: sGetUp 0 self)
					)
					((!= gChapter 7)
						(gGame handsOff:)
						(gCurRoom setScript: fadeScr)
					)
					((IsFlag 202)
						(gCurRoom setScript: sDoorsSlam)
					)
					(else
						(gCurRoom setScript: sDoorsSlam)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chair of Feature
	(properties
		approachX 168
		approachY 124
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				init: 145 78 142 59 147 56 155 61 165 55 169 62 165 88 172 96 170 111 163 122 138 120 137 97 157 93 157 90 163 89 163 81
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sSitDown)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

