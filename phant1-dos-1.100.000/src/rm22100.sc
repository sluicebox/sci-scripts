;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use System)

(public
	rm22100 0
)

(instance rm22100 of ScaryRoom
	(properties
		picture 22100
		stepSound 7
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(gEgo init: setScaler: Scaler 145 37 125 83 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(22200
				(switch global125
					(40
						(= picture 22130)
					)
					(43
						(= picture 22120)
					)
					(45
						(= picture 22110)
					)
					(else
						(gEgo view: 4 posn: 130 95)
						(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
			)
			(22300
				(KillRobot)
				(gEgo view: 7 posn: 250 130 setPri: 100)
				(southExit approachX: 260 approachY: 140)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo view: 4 posn: 130 95)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 22200)
			(switch global125
				(40
					(gCurRoom setScript: sReadSofia)
				)
				(43
					(gCurRoom setScript: sReadLeonora)
				)
				(45
					(gCurRoom setScript: sReadRegina)
				)
			)
		)
		(sofiaVault init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(leonoraVault init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(reginaVault init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(northExit init: 13)
		(southExit init: 11)
	)
)

(instance sReadSofia of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(southExit approachX: 245 approachY: 170)
					(gCurRoom drawPic: 22130)
					(DoRobot 5220 -5 -5)
				)
				(1
					(gEgo hide:)
					(gCurRoom drawPic: 22135)
					(FrameOut)
					(DoAudio 12 0) ; AudMixCheck
					(DoAudio 18 1) ; AudDACCritical
					(global114 pause: 22054)
					(= seconds 4)
				)
				(2
					(DoRobot 5229 -5 -7)
					(gCurRoom drawPic: 22130)
				)
				(3
					(DoAudio 12 1) ; AudMixCheck
					(DoAudio 18 0) ; AudDACCritical
					(gCurRoom drawPic: 22100)
					(gEgo show: posn: 135 88 normalize: 4)
					(= global125 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(DoAudio 12 1) ; AudMixCheck
					(DoAudio 18 0) ; AudDACCritical
					(if (global114 script:)
						(global114 endPause:)
					)
					(gEgo show: posn: 135 88 normalize: 4)
					(= global125 0)
					(gCurRoom drawPic: 22100)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sReadLeonora of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(southExit approachX: 245 approachY: 170)
					(gCurRoom drawPic: 22120)
					(DoRobot 5240 -8 -4)
				)
				(1
					(gEgo hide:)
					(gCurRoom drawPic: 22125)
					(= seconds 5)
				)
				(2
					(DoRobot 5249 -8 -4)
					(gCurRoom drawPic: 22120)
				)
				(3
					(= global125 0)
					(gCurRoom drawPic: 22100)
					(gEgo show: posn: 110 105 normalize: 5)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global125 0)
					(gCurRoom drawPic: 22100)
					(gEgo show: posn: 110 105 normalize: 5)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sReadRegina of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(southExit approachX: 245 approachY: 170)
					(gCurRoom drawPic: 22110)
					(DoRobot 5260 -1 -5)
				)
				(1
					(gEgo hide:)
					(gCurRoom drawPic: 22115)
					(= seconds 5)
				)
				(2
					(DoRobot 5269 -1 -5)
					(gCurRoom drawPic: 22110)
				)
				(3
					(gCurRoom drawPic: 22100)
					(gEgo show: posn: 110 105 normalize: 7)
					(= global125 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global125 0)
					(gCurRoom drawPic: 22100)
					(gEgo show: posn: 110 105 normalize: 7)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sofiaVault of Feature
	(properties
		nsLeft 148
		nsTop 66
		nsRight 197
		nsBottom 87
		sightAngle 40
		approachX 172
		approachY 76
		x 172
		y 76
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 156 70 196 69 196 92 185 92 157 87
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sReadSofia)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leonoraVault of Feature
	(properties
		nsLeft 19
		nsTop 79
		nsRight 129
		nsBottom 123
		sightAngle 40
		approachX 74
		approachY 130
		x 74
		y 130
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 34 95 125 87 126 131 34 132
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sReadLeonora)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance reginaVault of Feature
	(properties
		nsLeft 11
		nsTop 67
		nsRight 63
		nsBottom 73
		sightAngle 40
		approachX 37
		approachY 70
		x 37
		y 70
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 13 64 15 80 64 78 38 63 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sReadRegina)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 64
		nsTop 80
		nsRight 146
		nsBottom 95
		approachX 108
		approachY 60
		nextRoom 22200
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 73 70 72 126 85 139 84 139 11 0 11
					yourself:
				)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 260
		nsTop 0
		nsRight 300
		nsBottom 130
		approachX 245
		approachY 170
		x 280
		y 140
		nextRoom 22300
	)
)

