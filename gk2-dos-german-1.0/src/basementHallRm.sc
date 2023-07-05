;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1180)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	basementHallRm 0
	doorLatch 1
	doorLatch2 2
	doorLatch3 3
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 100)) (> temp0 0) ((-= temp0 1))
		(Palette 2 16 256 temp0) ; PalIntensity
		(FrameOut)
	)
)

(instance basementHallRm of ExitRoom ; "Wittelsbacher Theater: Basement Hall"
	(properties
		noun 11
		picture 11801
		south 11805 ; rm11805
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber 1150) ; backStageRm
			(gGk2Music fade: 0 10 10 1)
			(Lock rsAUDIO 11812 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(if (or (not (gGk2Music handle:)) (!= 11812 (gGk2Music number:)))
			(Lock rsAUDIO 11812 1)
			(gGk2Music number: 11812 setLoop: -1 play:)
		)
		(switch gPrevRoomNum
			(11805
				(gEgo posn: 331 360 heading: 45)
			)
			(1150 ; backStageRm
				(gEgo posn: 198 285 heading: 135)
			)
			(11802
				(gEgo posn: 468 288 heading: 225)
			)
			(1160 0) ; dressingRm
			(else
				(gEgo posn: 198 285 heading: 135)
			)
		)
		(if (!= gPrevRoomNum 1160) ; dressingRm
			(gEgo normalize: setScaler: Scaler 100 60 365 273 init:)
			(if (== gEgo GraceEgo)
				(Palette 1 (= global249 221)) ; PalLoad
			else
				(Palette 1 (= global249 222)) ; PalLoad
			)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 1160) ; dressingRm
			(gabeWolf init:)
		else
			(drain init:)
			(theWestExit init:)
			(theEastExit init:)
		)
	)
)

(instance sGabeWolfEntersBasement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(client cel: 0 setCycle: End self)
			)
			(2
				(localproc_0)
				(= cycles 1)
			)
			(3
				(gCurRoom drawPic: -1)
				(gCurRoom newRoom: 15001)
			)
		)
	)
)

(instance gabeWolf of Prop
	(properties
		x 38
		y 232
		view 20908
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: sGabeWolfEntersBasement)
	)
)

(instance doorLatch of GKFeature
	(properties
		modNum 1180
		x 82
		y 258
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 56 231 98 226 97 265 58 284
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(= global138 1)
				(if (== gEgo GraceEgo)
					(PlayScene 906 0 11841) ; rm11841
				else
					(PlayScene 907 0 11841) ; rm11841
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorLatch2 of GKFeature
	(properties
		modNum 1180
		x 82
		y 258
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(= global138 2)
				(if (== gEgo GraceEgo)
					(PlayScene 906 0 11841) ; rm11841
				else
					(PlayScene 907 0 11841) ; rm11841
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorLatch3 of GKFeature
	(properties
		modNum 1180
		x 82
		y 258
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(= global138 3)
				(if (== gEgo GraceEgo)
					(PlayScene 906 0 11841) ; rm11841
				else
					(PlayScene 907 0 11841) ; rm11841
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theWestExit of ExitFeature
	(properties
		approachY 285
		x 44
		y 196
		exitDir 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 6 323 5 69 83 69 83 323 yourself:)
		)
		(super init: &rest)
	)

	(method (handleEvent)
		(if (> (gEgo y:) 300)
			(= approachY 130)
		else
			(= approachY 285)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gEgo GraceEgo)
					(PlayScene 898 0 1150) ; backStageRm
				else
					(PlayScene 899 0 1150) ; backStageRm
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theEastExit of ExitFeature
	(properties
		x 546
		y 193
		exitDir 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 501 318 501 69 591 69 591 318
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent)
		(if (> (gEgo y:) 300)
			(= approachY 130)
		else
			(= approachY 285)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11802)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drain of GKFeature
	(properties
		modNum 1180
		nsLeft 259
		nsTop 263
		nsRight 342
		nsBottom 305
		sightAngle 360
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 62) ; Do
				(if (== gEgo GabeEgo)
					(= noun 16)
				else
					(= noun 15)
				)
			)
			((== gEgo GabeEgo)
				(= noun 17)
			)
			(else
				(= noun 18)
			)
		)
		(super doVerb: theVerb)
	)
)

