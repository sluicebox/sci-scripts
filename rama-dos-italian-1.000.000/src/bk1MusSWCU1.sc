;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4024)
(include sci.sh)
(use Main)
(use Location)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use Sound)

(public
	bk1MusSWCU1 0
)

(instance bk1MusSWCU1 of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 4046)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit27Butn init: global117)
		(guitar_225 init:)
	)
)

(instance exhibit27Butn of ExhibitButton
	(properties
		x 168
		y 270
		view 4055
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(guitarSnd play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance guitarSnd of Sound
	(properties
		flags 5
	)

	(method (play &tmp temp0)
		(switch (= temp0 (Random 0 2))
			(0
				(= number 4023)
			)
			(1
				(= number 4025)
			)
			(2
				(= number 4026)
			)
		)
		(super play: &rest)
	)
)

(instance guitar_225 of Feature
	(properties
		noun 12
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 238 139 294 108 302 116 369 77 372 87 300 131 302 146 248 168 235 142
					yourself:
				)
		)
	)
)

