;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11711)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm11711 0
)

(instance rm11711 of ExitRoom
	(properties
		picture 11711
		east 1170 ; spotRm
		south 1170 ; spotRm
		west 1170 ; spotRm
	)

	(method (init)
		(super init: &rest)
		(if (or (IsFlag 770) (not (IsFlag 735)))
			(wholeCupboard init:)
		else
			(leftCupboard init:)
			(rightCupboard init:)
		)
	)
)

(instance leftCupboard of ExitFeature
	(properties
		modNum 1170
		x 239
		y 172
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 142 58 323 55 337 250 165 289
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (setCursor param1)
		(param1 view: 999 loop: 4 cel: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11752)
			)
			(34 ; invOperaGlasses
				(gMessager say: 5 theVerb 0 0 0 modNum) ; "(TRY TO USE OPERA GLASSES WHEN SPOTLIGHT IS ON)I don't need the opera glasses to see where the spotlight is aimed."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightCupboard of ExitFeature
	(properties
		modNum 1170
		x 406
		y 149
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 324 55 489 49 478 216 337 249
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (setCursor param1)
		(param1 view: 999 loop: 5 cel: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11750)
			)
			(34 ; invOperaGlasses
				(gMessager say: 5 theVerb 0 0 0 modNum) ; "(TRY TO USE OPERA GLASSES WHEN SPOTLIGHT IS ON)I don't need the opera glasses to see where the spotlight is aimed."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wholeCupboard of GKFeature
	(properties
		modNum 1170
		x 315
		y 169
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 58 489 49 478 215 164 290
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((not (IsFlag 735))
						(gCurRoom newRoom: 11752)
					)
					((IsFlag 741)
						(gCurRoom newRoom: 11752)
					)
					(else
						(gMessager say: 3 62 0 0 0 modNum) ; "(WORRIED)I SHOULD try to aim the spotlight, but I haven't decided where to seat von Glower yet."
					)
				)
			)
			(34 ; invOperaGlasses
				(cond
					((IsFlag 763)
						(gMessager say: 18 theVerb 0 0 0 modNum) ; "(TRY TO USE OPERA GLASSES ON MITTLE LOGE AFTER SEEING VON GLOWER ONCE ALREADY, WORRIED)I already know he's there! Now I need to make sure he doesn't get out!"
					)
					((not (IsFlag 735))
						(gCurRoom newRoom: 11752)
					)
					((IsFlag 770)
						(gMessager say: 6 theVerb 0 0 0 modNum) ; "(TRY TO USE GLASSES ON GENERAL AUDITORIUM OPENING)Those won't help unless I have something specific to look at."
					)
					(else
						(gMessager say: 5 theVerb 0 0 0 modNum) ; "(TRY TO USE OPERA GLASSES WHEN SPOTLIGHT IS ON)I don't need the opera glasses to see where the spotlight is aimed."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

