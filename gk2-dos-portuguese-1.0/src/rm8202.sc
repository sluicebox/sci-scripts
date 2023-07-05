;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8202)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm8202 0
)

(instance rm8202 of ExitRoom
	(properties
		picture 8202
		east 820 ; rm820
		south 820 ; rm820
	)

	(method (init)
		(super init: &rest)
		(masterPic init:)
		(glassCase1 init:)
	)
)

(instance masterPic of GKFeature
	(properties
		noun 22
		modNum 820
		x 302
		y 108
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 251 26 251 190 353 180 353 46
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance glassCase1 of GKFeature
	(properties
		nsLeft 154
		nsTop 247
		nsRight 484
		nsBottom 297
		BAD_SELECTOR 8242
	)
)

