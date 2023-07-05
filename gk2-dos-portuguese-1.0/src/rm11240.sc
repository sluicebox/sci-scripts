;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11240)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Actor)

(public
	rm11240 0
)

(instance rm11240 of ExitRoom
	(properties
		picture 32841
		east 1120 ; resOfficeRm
		south 1120 ; resOfficeRm
		west 1120 ; resOfficeRm
	)

	(method (init)
		(super init: &rest)
		(otherItems init:)
		(if (not (IsFlag 742))
			(todoList init:)
		)
		(if (not (IsFlag 761))
			(operaGlasses init:)
		)
		(PlayScene 840)
	)

	(method (dispose)
		(PlayScene 1840 0 -1)
		(super dispose:)
	)
)

(instance todoList of View
	(properties
		modNum 1120
		sightAngle 40
		y 74
		view 30841
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(SetFlag 742)
				(gEgo get: 71) ; invToDoList
				(self dispose:)
				(if (gEgo has: 70) ; invOperaGlasses
					(PlayScene 3840)
					(gCurRoom newRoom: 1120) ; resOfficeRm
				else
					(PlayScene 2840)
				)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance operaGlasses of View
	(properties
		modNum 1120
		sightAngle 40
		x 416
		y 96
		view 31841
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(SetFlag 761)
				(gEgo get: 70) ; invOperaGlasses
				(if (gEgo has: 71) ; invToDoList
					(PlayScene 1841)
					(gCurRoom newRoom: 1120) ; resOfficeRm
				else
					(PlayScene 841)
				)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance purse of View ; UNUSED
	(properties
		modNum 1120
		sightAngle 40
		x 405
		y 245
		view 131
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 3 62 0 0 0 1120) ; "(UNINTERESTED)I don't need anything from my purse."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance otherItems of GKFeature
	(properties
		modNum 1120
		sightAngle 40
		x 307
		y 165
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 593 0 593 308 23 308 23 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 4 62 0 0 0 1120) ; "(UNINTERESTED)A lot of theater junk."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

