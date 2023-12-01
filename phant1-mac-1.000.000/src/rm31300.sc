;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31300)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm31300 0
)

(instance rm31300 of ScaryRoom
	(properties
		picture 31450
		stepSound 4
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(gEgo init: setScaler: Scaler 122 122 146 145 posn: 85 124)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(31200
				(gEgo normalize: 6)
			)
			(else
				(gEgo normalize: 6)
			)
		)
		(daBone init:)
		(if (not (IsFlag 237))
			(Load rsVIEW 2750)
			(boneSign init:)
			(barrel init:)
		)
		(westExit init: 4)
		(super init: &rest)
		(self setScript: (ScriptID 0 5)) ; takeLastStep
	)

	(method (notify)
		(gGame handsOff:)
		((ScriptID 0 14) dispose:) ; exitButt
		(ClearFlag 248)
		(signScr cue:)
	)
)

(instance sGetBone of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and (== (gEgo x:) 119) (== (gEgo y:) 114))
						(self cue:)
					else
						(gEgo setHeading: 30 self)
					)
				)
				(1
					(daBone dispose:)
					(DoRobot 2760 46 20)
					(gCurRoom drawPic: 31300)
				)
				(2
					(daBone init:)
					(gCurRoom drawPic: 31450)
					(gEgo get: 20 posn: 123 115 normalize: 6) ; invDogBone
					(SetFlag 237)
					(boneSign dispose:)
					(barrel dispose:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(daBone init:)
					(gEgo get: 20 posn: 123 115 normalize: 6) ; invDogBone
					(gCurRoom drawPic: 31450)
					(SetFlag 237)
					(boneSign dispose:)
					(barrel dispose:)
					(gGame handsOn:)
					(= global115 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance signScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(daBone dispose:)
					(gCurRoom drawPic: 31300)
					(gEgo
						view: 2750
						setScale: 0
						setLoop: 0
						setCel: 0
						posn: 127 119
						setCycle: End self
					)
				)
				(1
					(SetFlag 121)
					(proc1111_8)
					(gCurRoom drawPic: 31310)
					(Load rsVIEW 2751)
					((ScriptID 0 14) init:) ; exitButt
					(gGame handsOn:)
					(SetFlag 248)
					(gUser canControl: 0)
				)
				(2
					(ClearFlag 121)
					(proc1111_9)
					(ClearFlag 248)
					(gEgo
						view: 2751
						posn: 127 115
						setScale: 0
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
					(gCurRoom drawPic: 31300)
				)
				(3
					(daBone init:)
					(gCurRoom drawPic: 31450)
					(gEgo
						posn: 119 114
						setScaler: Scaler 122 122 146 145
						normalize: 6
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(if (not (gCast contains: daBone))
						(daBone init:)
					)
					(= global115 0)
					(gEgo
						posn: 119 114
						setScaler: Scaler 122 122 146 145
						normalize: 6
					)
					(gCurRoom drawPic: 31450)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 225 self)
				)
				(1
					(gCurRoom newRoom: 31200)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gCurRoom newRoom: 31200)
				)
			)
		)
	)
)

(instance daBone of View
	(properties
		x 141
		y 76
		view 31300
	)
)

(instance barrel of Feature
	(properties
		x 97
		y 119
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 4 3 ; Do, Move
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 130 81 126 93 129 110 156 112 161 93 156 81
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sGetBone)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boneSign of Feature
	(properties
		nsLeft 138
		nsTop 57
		nsRight 165
		nsBottom 76
		sightAngle 20
		x 97
		y 119
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: signScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		approachY 170
		nextRoom 31200
		appXOffset -10
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sExit)
		else
			(super doVerb: theVerb)
		)
	)
)

