;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5330)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	NY_Octospider_Plaza_30 0
)

(instance NY_Octospider_Plaza_30 of CloseupLocation
	(properties
		noun 20
		heading 45
		picture 5385
	)

	(method (init)
		(super init: picture)
		(self edgeW: 0 edgeE: 0)
		(octoKey init: global117)
		(octoTalisman init: global117)
	)
)

(instance octoKey of View
	(properties
		x 262
		y 145
		view 5385
	)

	(method (init)
		(if (!= (proc70_9 91) gCurRoomNum)
			(octoKeyFeat init:)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 91 0)
				(octoKeyFeat init:)
				(self dispose:)
				(if
					(and
						(IsFlag 241)
						(or
							(not (global117 contains: octoKey))
							(not (global117 contains: octoTalisman))
						)
					)
					(gCurRoom setScript: closeLair)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octoTalisman of View
	(properties
		x 270
		y 287
		cel 1
		view 5385
	)

	(method (init)
		(if (!= (proc70_9 104) gCurRoomNum)
			(octoTalismanFeat init:)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 104 0)
				(octoTalismanFeat init:)
				(self dispose:)
				(if
					(and
						(IsFlag 241)
						(or
							(not (global117 contains: octoKey))
							(not (global117 contains: octoTalisman))
						)
					)
					(gCurRoom setScript: closeLair)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octoKeyFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) type: PBarredAccess init: 266 118 313 32 360 118 yourself:)
			setHotspot: 18
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(18
				(proc70_3)
				(proc70_10 91 gCurRoomNum)
				(octoKey init: global117)
				(if
					(and
						(not (IsFlag 241))
						(global117 contains: octoKey)
						(global117 contains: octoTalisman)
					)
					(gCurRoom setScript: openLair)
				)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octoTalismanFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) type: PBarredAccess init: 281 246 315 199 348 247 yourself:)
			setHotspot: 106
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(106
				(proc70_3)
				(proc70_10 104 gCurRoomNum)
				(octoTalisman init: global117)
				(if
					(and
						(not (IsFlag 241))
						(global117 contains: octoKey)
						(global117 contains: octoTalisman)
					)
					(gCurRoom setScript: openLair)
				)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance openLair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lairOpenSound number: 5303 loop: 1 play: self)
			)
			(1
				(SetFlag 241)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeLair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lairOpenSound number: 5303 loop: 1 play: self)
			)
			(1
				(ClearFlag 241)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lairOpenSound of Sound
	(properties)
)

