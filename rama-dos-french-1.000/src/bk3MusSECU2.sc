;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4220)
(include sci.sh)
(use Main)
(use Location)
(use Polygon)
(use Feature)

(public
	bk3MusSECU2 0
)

(instance bk3MusSECU2 of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(super init: 4239)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(CHAIR_135 init:)
	)
)

(instance CHAIR_135 of Feature
	(properties
		noun 51
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 153 213 245 159 350 158 455 226 308 266 178 251 152 218
					yourself:
				)
		)
	)
)

