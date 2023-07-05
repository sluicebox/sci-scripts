;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11750)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)

(public
	rm11750 0
)

(instance rm11750 of ExitRoom
	(properties
		picture 11750
	)

	(method (init)
		(super init: &rest)
		(westExit init:)
		(stage init:)
		(otherSeats1 init:)
		(otherSeats2 init:)
		(otherSeats3 init:)
		(otherSeats4 init:)
		(chandWork init:)
		(southExit init:)
	)
)

(instance chandWork of Prop
	(properties
		x 71
		y 129
		view 24832
	)

	(method (init)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
		(self setCycle: Fwd)
	)

	(method (onMe)
		(return 0)
	)

	(method (doVerb theVerb)
		(otherSeats1 doVerb: theVerb)
	)
)

(instance stage of GKFeature
	(properties
		modNum 1170
		x 462
		y 166
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 322 291 315 0 610 0 610 333 472 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 737)
						(gMessager say: 9 62 0 0 0 modNum) ; "(CLICK ON STAGE FROM SPOTLIGHT ROOM, ACT I)Act I is on stage."
					)
					((IsFlag 736)
						(gMessager say: 8 62 0 0 0 modNum) ; "(CLICK ON STAGE DURING OVERTURE)The curtains are still closed for the overture."
					)
					(else
						(gMessager say: 7 62 0 0 0 modNum) ; "(CLICK ON STAGE)It's the stage."
					)
				)
			)
			(34 ; invOperaGlasses
				(if (IsFlag 737)
					(gMessager say: 11 theVerb 0 0 0 modNum) ; "(TRY TO USE OPERA GLASSES TO SEE STAGE AFTER OVERTURE)I'm too worried to enjoy the performance!"
				else
					(gMessager say: 10 theVerb 0 0 0 modNum) ; "(USE OPERA GLASSES ON STAGE BEFORE OVERTURE)There's nothing to see out there."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance otherSeats1 of GKFeature
	(properties
		modNum 1170
		x 65
		y 227
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 327 0 209 165 183 167 295
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 19 theVerb 0 0 0 modNum) ; "(THOUGHTFUL)I could shine the spotlight just about anywhere, if I wanted to."
			)
			(34 ; invOperaGlasses
				(if (IsFlag 735)
					(gMessager say: 10 theVerb 0 0 0 modNum) ; "(USE OPERA GLASSES ON STAGE BEFORE OVERTURE)There's nothing to see out there."
				else
					(gMessager say: 20 theVerb 0 0 0 modNum) ; "(PENSIVE)I don't have time to people watch."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance otherSeats2 of GKFeature
	(properties
		modNum 1170
		x 65
		y 227
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 178 0 10 164 11 163 166
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(otherSeats1 doVerb: theVerb)
	)
)

(instance otherSeats3 of GKFeature
	(properties
		modNum 1170
		x 252
		y 78
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 200 155 202 1 304 1 302 147
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(otherSeats1 doVerb: theVerb)
	)
)

(instance otherSeats4 of GKFeature
	(properties
		modNum 1170
		x 250
		y 230
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 211 289 200 183 300 172 295 275
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(otherSeats1 doVerb: theVerb)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		BAD_SELECTOR 4
	)

	(method (doVerb)
		(gCurRoom newRoom: 1170) ; spotRm
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 15
		nsRight 72
		nsBottom 334
		x 63536
		y 250
	)

	(method (setCursor param1)
		(param1 view: 999 loop: 4 cel: 0)
	)

	(method (doVerb)
		(gCurRoom newRoom: 11752)
	)
)

