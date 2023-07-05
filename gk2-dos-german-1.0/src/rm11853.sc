;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11853)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Cursor)
(use Actor)

(public
	rm11853 0
)

(instance rm11853 of ExitRoom
	(properties
		picture 11853
		east 1185 ; propRm
		south 1185 ; propRm
		west 1185 ; propRm
	)

	(method (init)
		(super init: &rest)
		(if (and (== gEgo GraceEgo) (not (IsFlag 751)))
			(banner init:)
		)
		(propCoveringVent init:)
		(fRightJunk init:)
		(cond
			((IsFlag 793)
				(openVent init:)
			)
			((IsFlag 792)
				(fVentCover init:)
				(GKHotCursor delete: propCoveringVent)
			)
			(else
				(fLeftJunk init:)
			)
		)
	)
)

(instance propCoveringVent of View
	(properties
		modNum 1185
		x 201
		y 334
		view 31011
	)

	(method (init)
		(if (IsFlag 792)
			(= view 31012)
			(= x 22)
			(= y 333)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((== gEgo GraceEgo)
						(gMessager say: 3 theVerb 0 0 0 modNum) ; "(LOOK AT LARGE PROP, NOT VERY INTERESTED)Looks like an old set piece."
					)
					((IsFlag 792)
						(super doVerb: theVerb)
					)
					(else
						(= view 31012)
						(= x 22)
						(= y 333)
						(PlayScene 921)
						(SetFlag 792)
						(fVentCover init:)
						(GKHotCursor delete: self)
						(fLeftJunk dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fVentCover of GKFeature
	(properties
		modNum 1185
		x 273
		y 180
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 214 139 346 140 341 268 213 268)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 702)
					(= noun 7)
					(super doVerb: theVerb)
				else
					(SetFlag 702)
					(PlayScene 922)
				)
			)
			(23 ; invRitterDagger
				(PlayScene 923)
				(SetFlag 793)
				(openVent init:)
				(self dispose:)
			)
			(else
				(gMessager say: 4 62 0 0 0 modNum) ; "(USE INVENTORY ITEMS NO VENT COVER, DOUBTFUL)That wouldn't be much help."
			)
		)
	)
)

(instance openVent of View
	(properties
		modNum 1185
		x 206
		y 275
		view 30923
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(SetFlag 800)
				(PlayScene 924 0 11809) ; rm11809
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance banner of View
	(properties
		modNum 1185
		x 68
		y 202
		priority 280
		fixPriority 1
		view 31010
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gEgo get: 68 heading: 225) ; invBanner
				(PlayScene 920)
				(SetFlag 751)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fLeftJunk of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 40 177 168 173 181 185 183 334 -3 337 -3 221
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(fRightJunk doVerb: theVerb)
	)
)

(instance fRightJunk of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 434 317 434 98 469 94 568 94 572 339 461 333 459 322 444 303 443 321
					yourself:
				)
		)
	)

	(method (doVerb)
		(if (== gEgo GabeEgo)
			(gMessager say: 6 62 0 1 0 1185) ; "(PICKUP, CH 6 CLICK ON OTHER ITEMS IN PROP ROOM, WEREWOLF MODE)There's nothin' but a lot of useless junk in here!"
		else
			(gMessager say: 8 62 0 1 0 1185) ; "A lot of theater junk."
		)
	)
)

