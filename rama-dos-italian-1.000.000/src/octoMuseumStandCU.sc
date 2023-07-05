;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7604)
(include sci.sh)
(use Location)
(use n1111)
(use Polygon)
(use Feature)

(public
	octoMuseumStandCU 0
)

(instance octoMuseumStandCU of CloseupLocation
	(properties
		heading 270
	)

	(method (init)
		(super init: 7613)
		(STFDAVIAN_270 init:)
		(self edgeW: 0 edgeE: 0)
		(if (proc1111_24 218)
			(proc1111_31 26)
			(SetFlag 218)
		)
	)
)

(instance STFDAVIAN_270 of Feature
	(properties
		noun 43
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 261 40 287 92 291 43 312 41 344 75 360 41 381 112 330 198 328 243 292 243 287 189 247 178 241 98 261 39
					yourself:
				)
		)
	)
)

