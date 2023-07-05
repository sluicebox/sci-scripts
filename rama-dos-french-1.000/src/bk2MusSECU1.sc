;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4119)
(include sci.sh)
(use Main)
(use Location)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use Sound)

(public
	bk2MusSECU1 0
)

(instance bk2MusSECU1 of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(super init: 4134)
		(= plane global116)
		(exhibit13Butn init: global117)
		(self edgeW: 0 edgeE: 0)
		(AVIAN_135 init:)
	)
)

(instance exhibit13Butn of ExhibitButton
	(properties
		x 278
		y 291
		view 4163
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(avianSnd play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance avianSnd of Sound
	(properties
		number 4126
		flags 5
	)
)

(instance AVIAN_135 of Feature
	(properties
		noun 27
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 243 37 299 12 348 41 372 116 317 194 323 251 272 263 230 185 216 100
					yourself:
				)
		)
	)
)

