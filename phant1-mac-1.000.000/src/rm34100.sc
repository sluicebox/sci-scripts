;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	rm34100 0
)

(local
	[local0 2]
	local2
)

(instance rm34100 of ScaryRoom
	(properties
		picture 34100
		stepSound 1
	)

	(method (init &tmp temp0)
		(= temp0 0)
		((ScriptID 30) init:) ; FidgetCode
		(global114 stop: 1)
		(if (and (== gChapter 1) (gEgo has: 0)) ; invLibKey
			(SetFlag 235)
		)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 95 16 137 73
			normalize:
		)
		(if (IsFlag 336)
			(bmw init:)
		)
		(malcolmHouse init: 13)
		(generalStore init: 13)
		(realty approachVerbs: 4 3 init: 10) ; Do, Move
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(34225
				(gEgo normalize: 5 posn: 125 128)
				(waterProp init:)
				(= temp0 (ScriptID 0 5)) ; takeLastStep
			)
			(34235
				(gEgo normalize: 5 posn: 125 128)
				(waterProp init:)
				(= temp0 (ScriptID 0 5)) ; takeLastStep
			)
			(33100
				(proc1111_6)
				(gEgo normalize: 4 posn: 125 128)
				(waterProp init:)
				(= temp0 (ScriptID 0 5)) ; takeLastStep
			)
			(else
				(waterProp init:)
				(= temp0 exitCarScr)
			)
		)
		(super init: &rest)
		(if (or (!= (gGDacSound number:) 903) (not (gGDacSound handle:)))
			(gGDacSound number: 903 setLoop: -1 play: setVol: 75)
		)
		(if temp0
			(self setScript: temp0)
		)
	)
)

(instance exitCarScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: gEgo)
						(gEgo hide:)
					)
					(if (gCast contains: bmw)
						(bmw hide:)
					)
					(proc1111_7 1700)
					(gGame setIntensity: 0 1)
					(gGame fade: 0 100 2)
				)
				(1
					(gCast eachElementDo: #hide)
					(waterProp
						view: 34110
						show:
						x: 0
						y: 130
						setCycle: Fwd
						cycleSpeed: 10
					)
					(proc1111_7 1601 10 -9 gEgo 200)
					(gCurRoom drawPic: 34110)
				)
				(2
					(waterProp view: 34104 x: 84 y: 79 cycleSpeed: 6)
					(SetFlag 336)
					(bmw init:)
					(gEgo show: normalize: 2 posn: 148 122)
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: (gCurRoom picture:))
					(rightPeople init: hide:)
					(leftPeople init: hide:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(SetFlag 336)
					(waterProp view: 34104 x: 84 y: 79 cycleSpeed: 6)
					(bmw init:)
					(gEgo show: normalize: 2 posn: 148 122)
					(rightPeople init: hide:)
					(leftPeople init: hide:)
					(= global115 0)
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: 34100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance enterCarScr of Script
	(properties)

	(method (dispose)
		(if global115
			(if (Robot 6) ; Exists
				(Robot 10) ; Pause
			)
			(gGame fade: 100 0 2)
			(= global115 0)
		else
			(gGame fade: 100 0 2)
		)
		(ClearFlag 121)
		(ClearFlag 386)
		(ClearFlag 388)
		(ClearFlag 389)
		(ClearFlag 387)
		(if (and (IsFlag 162) (== gChapter 2))
			(gCurRoom newRoom: 28300)
		else
			(gCurRoom newRoom: 28700)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 90 self 10)
				)
				(1
					(ClearFlag 121)
					(if (gCast contains: bmw)
						(bmw dispose:)
					)
					(waterProp
						view: 34110
						x: 0
						y: 130
						setCycle: Fwd
						show:
						cycleSpeed: 10
					)
					(leftPeople dispose:)
					(rightPeople dispose:)
					(gEgo hide: posn: 0 300)
					(proc1111_7 1603 155 49 gEgo 200)
					(gCurRoom drawPic: 34110 picture: 34110)
				)
				(2
					(ClearFlag 336)
					(waterProp view: 34104 x: 84 y: 79 cycleSpeed: 6)
					(proc1111_7 1710 -11 -36)
					(gCurRoom drawPic: 34100 picture: 34100)
				)
				(3
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)
)

(instance walkByCameraDude of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (IsFlag 336)
						(bmw dispose:)
					)
					(waterProp dispose:)
					(rightPeople dispose:)
					(leftPeople dispose:)
					(cameraDude dispose:)
					(SetFlag 88)
					(proc1111_7 5590 -7 -34 gEgo -1 1)
					(gCurRoom drawPic: 34215)
				)
				(1
					(gEgo hide:)
					(gCurRoom newRoom: local2)
				)
			)
		else
			(switch (= state newState)
				(0
					(SetFlag 88)
					(= global115 0)
					(proc1111_6)
					(gEgo hide:)
					(gCurRoom newRoom: local2)
				)
			)
		)
	)
)

(instance movePeople of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(rightPeople
					loop: (Random 0 3)
					show:
					setCel: 0
					cycleSpeed: (Random 4 8)
					setCycle: End self
				)
			)
			(2
				(rightPeople hide:)
				(= seconds (Random 5 15))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance movePeople2 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(leftPeople
					loop: (Random 0 3)
					show:
					setCel: 0
					cycleSpeed: (Random 4 8)
					setCycle: End self
				)
			)
			(2
				(leftPeople hide:)
				(= seconds (Random 7 10))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance takePic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cameraDude setCel: 0 setCycle: End self)
			)
			(1
				(= seconds (Random 4 8))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance waterProp of Prop
	(properties
		x 84
		y 79
		view 34104
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd cycleSpeed: 6)
	)
)

(instance rightPeople of Prop
	(properties
		x 255
		y 84
		view 34101
	)

	(method (init))
)

(instance leftPeople of Prop
	(properties
		x 181
		y 62
		view 34102
	)

	(method (init))
)

(instance cameraDude of Prop
	(properties
		x 245
		y 99
		view 34150
	)

	(method (init)
		(super init:)
		(self setPri: 200 setScript: takePic)
	)
)

(instance bmw of View
	(properties
		x 132
		y 130
		view 1701
	)

	(method (init)
		(super init:)
		(self signal: (| (self signal:) $1000) setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(SetFlag 121)
				(gCurRoom setScript: enterCarScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance malcolmHouse of ExitFeature
	(properties
		nsLeft 0
		nsTop 48
		nsRight 63
		nsBottom 85
		x 15
		y 58
	)

	(method (doVerb)
		(gCurRoom newRoom: 33100)
	)
)

(instance generalStore of ExitFeature
	(properties
		nsLeft 150
		nsTop 55
		nsRight 205
		nsBottom 69
		approachX 175
		approachY 73
		x 167
		y 62
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom newRoom: 34225)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance realty of ExitFeature
	(properties
		nsLeft 246
		nsTop 53
		nsRight 320
		nsBottom 75
		approachX 310
		approachY 15
		x 255
		y 61
	)

	(method (handleEvent event)
		(if (and (== gChapter 3) (not (IsFlag 87)))
			(= appXOffset (- approachX (event x:)))
			(= appYOffset (- approachY (event y:)))
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom newRoom: 34235)
		else
			(super doVerb: theVerb)
		)
	)
)

