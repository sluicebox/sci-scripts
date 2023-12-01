;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21000)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Actor)
(use System)

(public
	rm21000 0
)

(instance rm21000 of ScaryRoom
	(properties
		picture 21000
		stepSound 1
		baseView 6000
	)

	(method (init)
		(gEgo init: setScale: 0 ignoreActors: 1)
		(if (== gChapter 5)
			(= picture 21001)
			(gEgo fadePalette: 28100)
		)
		(gGDacSound setVol: 45)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(21200
				(gEgo normalize: 611 posn: 226 151)
				(gCurRoom setScript: (ScriptID 0 5) 0 3) ; takeLastStep
				(gGame handsOn:)
			)
			(else
				(if (or (> gChapter 5) (IsFlag 316))
					(gEgo normalize: 614 posn: 247 142)
					(gGame handsOn:)
				else
					(= picture (+ (== gChapter 5) 21200))
					(pot init: setPri: 1)
					(self setScript: sFirstGreenHouse)
				)
			)
		)
		(if (and (== gChapter 4) (not (IsFlag 191)) (IsFlag 316))
			(trowel init: setHotspot: 4 3) ; Do, Move
		)
		(doorExit init: 1)
		(eastExit init: 2)
		(super init: &rest)
	)
)

(instance pot of View
	(properties
		approachX 183
		approachY 117
		x 206
		y 49
		view 21015
	)
)

(instance trowel of View
	(properties
		approachX 122
		approachY 123
		x 80
		y 127
		view 21002
	)

	(method (init)
		(self createPoly: 55 111 100 111 100 130 55 130)
		(self view: (+ 21002 (== gChapter 5)))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sDoTrowel)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 207
		nsTop 12
		nsRight 253
		nsBottom 79
		approachX 230
		approachY 77
		x 243
		y 80
		nextRoom 21100
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 283
		nsBottom 140
		nextRoom 21200
	)
)

(instance sFirstGreenHouse of Script
	(properties)

	(method (dispose)
		(SetFlag 316)
		(if (== gChapter 4)
			(trowel init: setHotspot: 4 3) ; Do, Move
		)
		(gCurRoom
			drawPic: (+ 21000 (== gChapter 5))
			picture: (+ 21000 (== gChapter 5))
		)
		(gEgo posn: 247 142 normalize: 614)
		(pot dispose:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 4480 41 19)
				)
				(1
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance sDoTrowel of Script
	(properties)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(KillRobot)
			(trowel dispose:)
			(SetFlag 239)
			(SetFlag 191)
			(gGame handsOn:)
			(gCurRoom newRoom: 21100)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 239)
					(SetFlag 191)
					(trowel dispose:)
					(gCurRoom drawPic: -1)
					(gEgo hide:)
					(PlayVMD 0 {4550.vmd} 0) ; Open
					(proc26_0 4550 self)
				)
				(1
					(gCurRoom newRoom: 21100)
				)
			)
		)
	)
)

