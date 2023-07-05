;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9211)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	neuBedPanel 0
)

(instance neuBedPanel of ExitRoom
	(properties
		picture 9211
		south 920 ; rm920
	)

	(method (init)
		(super init: &rest)
		(livingRmExit init:)
		(panel init:)
	)
)

(instance livingRmExit of ExitFeature
	(properties
		nsLeft 187
		nsTop 13
		nsRight 421
		nsBottom 341
		x 209
		y 164
		BAD_SELECTOR 940
		BAD_SELECTOR 0
	)
)

(instance panel of GKFeature
	(properties
		modNum 920
		nsLeft 17
		nsTop 242
		nsRight 153
		nsBottom 330
		x 471
		y 300
	)

	(method (doVerb)
		(cond
			((IsFlag 805)
				(= noun 21)
			)
			((or (not (IsFlag 729)) (not (IsFlag 786)))
				(= noun 20)
			)
			(else
				(gEgo
					get:
						(cond
							((gEgo has: 60) ; invOperaAct1
								(gEgo put: 60) ; invOperaAct1
								59
							)
							((gEgo has: 59) ; invOperaAct2
								(gEgo put: 59) ; invOperaAct2
								58
							)
							(else 60)
						)
				)
				(SetFlag 805)
				(self dispose:)
				(= BAD_SELECTOR 776)
				(= BAD_SELECTOR 920)
			)
		)
		(super doVerb: &rest)
	)
)

