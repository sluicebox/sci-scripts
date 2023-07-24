;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8620)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)

(public
	rm8v620 0
)

(local
	local0
	local1
)

(instance rm8v620 of ShiversRoom
	(properties
		picture 8620
	)

	(method (init)
		(= local1 0)
		(efExitUp init: 4)
		(cupboard init:)
		((View new:) view: 8620 loop: 1 setPri: 1 1 init:)
		(= local0 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if local0
			(gSounds play: 10802 0 32 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nsLeft 21
		nsTop 0
		nsRight 243
		nsBottom 30
		nextRoom 8590
	)
)

(instance cupboard of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 8620
	)

	(method (doVerb)
		(if local0
			(gSounds play: 10802 0 32 0)
			(= local0 0)
			(self setCycle: Beg createPoly: 11 38 246 38 236 126 21 126)
		else
			(if (not local1)
				(= local1 1)
			)
			(gSounds play: 10801 0 32 0)
			(= local0 1)
			(self
				setCycle: End
				createPoly: 0 38 214 38 201 126 59 126 46 38 0 38 263 38 263 126 0 126
			)
		)
	)
)

