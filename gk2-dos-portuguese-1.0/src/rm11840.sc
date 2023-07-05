;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11840)
(include sci.sh)
(use Main)
(use GabeEgo)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm11840 0
)

(instance rm11840 of ExitRoom
	(properties
		picture 11874
	)

	(method (init)
		(if (and (== gEgo GraceEgo) (not (gEgo has: 67))) ; invTheaterKeys
			(= picture 11873)
			(keys init:)
		)
		(super init: &rest)
		(panelBox init:)
		(southExit init:)
		(westExit init:)
		(eastExit init:)
	)
)

(instance keys of GKFeature
	(properties
		modNum 1180
		nsLeft 336
		nsTop 49
		nsRight 484
		nsBottom 177
		x 228
		y 213
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 902)
				(gEgo get: 67) ; invTheaterKeys
				(gCurRoom drawPic: 11874)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance panelBox of GKFeature
	(properties
		modNum 1180
		x 297
		y 161
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 49 446 49 446 273 149 273
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gEgo GraceEgo)
					(gMessager say: 2 theVerb 0 0 0 modNum) ; "(LOOK IN PANEL BOX)Not much in here."
				else
					(gMessager say: 3 theVerb 0 0 0 modNum) ; "(LOOK AT EMPTY PANEL BOX, CRANKY)It's empty!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
		(cond
			((and (== gEgo GraceEgo) (gEgo has: 67)) ; invTheaterKeys
				(PlayScene 1900 0 11802) ; rm11802
			)
			((== gEgo GraceEgo)
				(PlayScene 2900 0 11802) ; rm11802
			)
			(else
				(PlayScene 1901 0 11802) ; rm11802
			)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 586
		nsTop 15
		nsRight 640
		nsBottom 334
		x 2000
		y 250
		BAD_SELECTOR 2
	)

	(method (doVerb theVerb)
		(southExit doVerb: theVerb)
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 15
		nsRight 52
		nsBottom 334
		x 63536
		y 250
		BAD_SELECTOR 6
	)

	(method (doVerb theVerb)
		(southExit doVerb: theVerb)
	)
)

