;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Sound)
(use Actor)
(use System)

(public
	rm21200 0
)

(instance rm21200 of ScaryRoom
	(properties
		picture 21200
		stepSound 1
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (init)
		(KillRobot)
		((ScriptID 30) init:) ; FidgetCode
		(gEgo init: setScaler: Scaler 146 98 126 99 ignoreActors: 1)
		(doorExit init: 1)
		(westExit init: 4)
		(if (== gChapter 5)
			(= picture 21201)
			(gEgo fadePalette: 28100)
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(else
				(gEgo normalize: 0 posn: 125 123)
				(gCurRoom setScript: (ScriptID 0 5) 0 3) ; takeLastStep
				(gGame handsOn:)
			)
		)
		(if (not (IsFlag 300))
			(pot init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		else
			(bones init: setHotspot: 4 3) ; Do, Move
		)
		(super init: &rest)
	)
)

(instance sTipPot of Script
	(properties)

	(method (dispose)
		(gCurRoom drawPic: 21200 picture: 21200)
		(DoAudio 12 1) ; AudMixCheck
		(DoAudio 18 0) ; AudDACCritical
		(pot dispose:)
		(gEgo show: posn: 139 121 normalize: 4)
		(bones init: setHotspot: 4 3) ; Do, Move
		(SetFlag 300)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(pot hide:)
					(gCurRoom drawPic: 21110 picture: 21110)
					(DoRobot 4500 -4 -43)
				)
				(1
					(Load rsPIC 21120)
					(gCurRoom drawPic: 21130 picture: 21130)
					(DoRobot 4501 -9 -45)
				)
				(2
					(gCurRoom drawPic: 21120 picture: 21120)
					(DoRobot 4502 -9 -40)
				)
				(3
					(DoRobot 4503 -5 -2)
				)
				(4
					(gEgo hide:)
					(gCurRoom drawPic: 4549 picture: 4549)
					(DoAudio 12 0) ; AudMixCheck
					(DoAudio 18 1) ; AudDACCritical
					(stinger play:)
					(= seconds 4)
				)
				(5
					(gCurRoom drawPic: 21120 picture: 21120)
					(DoRobot 4504 -5 -2)
				)
				(6
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

(instance sBones of Script
	(properties)

	(method (dispose)
		(gEgo show: posn: 139 121 normalize: 4)
		(bones show:)
		(gCurRoom drawPic: 21200 picture: 21200)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(bones hide:)
					(gCurRoom drawPic: 21120 picture: 21120)
					(DoRobot 4540 -2 -39)
				)
				(1
					(gEgo hide:)
					(gCurRoom drawPic: 4549 picture: 4549)
					(= seconds 4)
				)
				(2
					(gCurRoom drawPic: 21120 picture: 21120)
					(DoRobot 4541 -2 -39)
				)
				(3
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

(instance sUnknownBones of Script
	(properties)

	(method (dispose)
		(gEgo show: posn: 139 121 normalize: 4)
		(bones show:)
		(gCurRoom drawPic: 21200 picture: 21200)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(bones hide:)
					(DoRobot 4510 -9 -42)
					(gCurRoom drawPic: 21120 picture: 21120)
				)
				(1
					(gEgo hide:)
					(gCurRoom drawPic: 4549 picture: 4549)
					(= seconds 4)
				)
				(2
					(DoRobot 4511 -9 -42)
					(gCurRoom drawPic: 21120 picture: 21120)
				)
				(3
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

(instance stinger of Sound
	(properties
		flags 4
		number 21040
	)
)

(instance bones of View
	(properties
		approachX 169
		approachY 169
		x 206
		y 142
		view 21201
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (or (IsFlag 301) (IsFlag 191))
				(gCurRoom setScript: sBones)
			else
				(gCurRoom setScript: sUnknownBones)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pot of View
	(properties
		approachX 183
		approachY 117
		x 206
		y 49
		view 21200
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sTipPot)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 86
		nsTop 0
		nsRight 134
		nsBottom 96
		approachX 43
		approachY 78
		nextRoom 21100
	)
)

(instance westExit of ExitFeature
	(properties
		nsRight 88
		approachX 43
		approachY 78
		nextRoom 21000
	)
)

