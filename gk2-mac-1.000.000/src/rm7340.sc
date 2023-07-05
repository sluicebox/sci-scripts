;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7340)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm7340 0
)

(instance rm7340 of ExitRoom
	(properties
		picture 7340
		east 730 ; churchRm
		south 730 ; churchRm
		west 730 ; churchRm
	)

	(method (init)
		(super init: &rest)
		(maryStatue init:)
	)
)

(instance maryStatue of Feature
	(properties
		noun 20
		modNum 730
		x 263
		y 154
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 271 14 226 37 206 55 224 295 321 295 312 258 320 112 301 61 288 50 291 25
					yourself:
				)
		)
		(super init: &rest)
	)
)

