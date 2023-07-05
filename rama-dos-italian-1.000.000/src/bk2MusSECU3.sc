;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4121)
(include sci.sh)
(use Main)
(use Location)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use Sound)

(public
	bk2MusSECU3 0
)

(instance bk2MusSECU3 of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(super init: 4137)
		(= plane global116)
		(exhibit16Butn init: global117)
		(self edgeW: 0 edgeE: 0)
		(MYRMICAT_135 init:)
	)
)

(instance exhibit16Butn of ExhibitButton
	(properties
		x 275
		y 276
		view 4160
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(mirmicatSnd play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mirmicatSnd of Sound
	(properties
		flags 5
	)

	(method (play &tmp temp0)
		(switch (= temp0 (Random 0 3))
			(0
				(= number 4127)
			)
			(1
				(= number 4129)
			)
			(2
				(= number 4130)
			)
			(3
				(= number 4131)
			)
		)
		(super play: &rest)
	)
)

(instance MYRMICAT_135 of Feature
	(properties
		noun 29
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 132 308 130 319 104 375 103 385 188 350 189 349 227 307 232 255 206
					yourself:
				)
		)
	)
)

