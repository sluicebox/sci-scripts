;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4136)
(include sci.sh)
(use Main)
(use Location)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use Sound)

(public
	bk2MusSECU4 0
)

(instance bk2MusSECU4 of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(super init: 4158)
		(= plane global116)
		(exhibit15Butn init: global117)
		(self edgeW: 0 edgeE: 0)
		(MELON_135 init:)
	)
)

(instance exhibit15Butn of ExhibitButton
	(properties
		x 276
		y 285
		view 4161
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(manaMelonSnd play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance manaMelonSnd of Sound
	(properties
		number 4128
		flags 5
	)
)

(instance MELON_135 of Feature
	(properties
		noun 30
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 149 321 132 342 177 312 209 270 198 263 180 272 149
					yourself:
				)
		)
	)
)

