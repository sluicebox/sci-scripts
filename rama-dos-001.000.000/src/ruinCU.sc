;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2031)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	ruinCU 0
)

(instance ruinCU of CloseupLocation
	(properties
		noun 3
		picture 2200
	)

	(method (init)
		(if (IsFlag 62)
			(= picture 2300)
		)
		(super init: picture)
		(if (not (IsFlag 62))
			(Load rsVIEW 2200)
			(sparks init: global117 hide:)
			(powerLineFeat init:)
			(gCurRoom setScript: sparksFly)
		)
	)
)

(instance sparksFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 12)
			)
			(1
				(sparksSound play: self)
				(sparks show:)
			)
			(2
				(= state -1)
				(sparks hide:)
				(= cycles (Random 30 180))
			)
		)
	)
)

(instance sparks of View
	(properties
		x 89
		y 290
		view 2200
	)
)

(instance powerLineFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 98 149 134 170 188 194 217 200 259 198 307 185 355 160 399 126 440 98 476 85 485 91 485 98 479 103 448 116 411 139 354 183 318 202 270 216 213 221 176 211 138 195 93 165
					yourself:
				)
			setHotspot: 80 35
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(35
				(proc1111_31 11)
			)
			(80
				(SetFlag 62)
				(gCurRoom drawPic: 2300)
				(gCurRoom setScript: 0)
				(sparks dispose:)
				(self deleteHotspot:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sparksSound of Sound
	(properties
		flags 5
	)

	(method (play)
		(switch (Random 0 2)
			(0
				(= number 2217)
			)
			(1
				(= number 2218)
			)
			(2
				(= number 2219)
			)
		)
		(super play: &rest)
	)
)

