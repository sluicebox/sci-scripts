;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15001)
(include sci.sh)
(use Main)
(use BaseRoom)
(use BaseRegion)
(use Styler)
(use Polygon)
(use Feature)
(use Sound)

(public
	rm15001 0
)

(instance rm15001 of BaseRoom ; "Wittelsbacher Theater: Basement Hall"
	(properties
		modNum 1180
		noun 11
		BAD_SELECTOR 1
		BAD_SELECTOR 15002
		BAD_SELECTOR 15001
		BAD_SELECTOR 15004
		BAD_SELECTOR 15003
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(1150 ; backStageRm
				(= style 10)
				(Styler seconds: 5)
				(= BAD_SELECTOR 1)
			)
			(15002
				(= BAD_SELECTOR 3)
			)
			(15005
				(= BAD_SELECTOR 0)
			)
			(else
				(= BAD_SELECTOR 1)
			)
		)
		(if ((BaseRegion BAD_SELECTOR:) at: 0)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion BAD_SELECTOR:) at: 3)
			(+= BAD_SELECTOR 100)
		)
		(Load 140 15012) ; WAVE
		(super init:)
		(if
			(or
				(and
					(== BAD_SELECTOR 1)
					(not ((BaseRegion BAD_SELECTOR:) at: 0))
				)
				(and
					(== BAD_SELECTOR 2)
					(not ((BaseRegion BAD_SELECTOR:) at: 3))
				)
			)
			(exitDoor init:)
		)
		(if (== BAD_SELECTOR 3)
			(exitWDoor init:)
		)
	)

	(method (cue)
		(cond
			(
				(or
					(and
						(== BAD_SELECTOR 1)
						(not ((BaseRegion BAD_SELECTOR:) at: 0))
					)
					(and
						(== BAD_SELECTOR 2)
						(not ((BaseRegion BAD_SELECTOR:) at: 3))
					)
				)
				(if (not (gFeatures contains: exitDoor))
					(exitDoor init:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
				)
			)
			((== BAD_SELECTOR 3)
				(if (not (gFeatures contains: exitWDoor))
					(exitWDoor init:)
				)
				(if (gFeatures contains: exitDoor)
					(exitDoor dispose:)
				)
			)
			(else
				(if (gFeatures contains: exitDoor)
					(exitDoor dispose:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
				)
			)
		)
	)
)

(instance exitDoor of ExitFeature
	(properties
		x 926
		y 131
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 868 23 985 23 985 240 868 240
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(switch (gCurRoom BAD_SELECTOR:)
					(1
						(gCurRoom
							BAD_SELECTOR:
								(gCurRoom BAD_SELECTOR:)
								(gCurRoom BAD_SELECTOR:)
						)
					)
					(2
						(gCurRoom
							BAD_SELECTOR:
								(gCurRoom BAD_SELECTOR:)
								(gCurRoom BAD_SELECTOR:)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitWDoor of ExitFeature
	(properties
		x 921
		y 118
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 854 0 988 0 988 236 854 236
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(sfxWolfWhine play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sfxWolfWhine of Sound
	(properties
		number 15012
	)
)

