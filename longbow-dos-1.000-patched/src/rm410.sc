;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use IconBar)
(use Feature)
(use Game)
(use System)

(public
	rm410 0
)

(local
	local0
)

(instance rm410 of Rm
	(properties
		picture 410
	)

	(method (init)
		(super init:)
		(gEgo posn: 152 183 loop: 2 init:)
		(trapDoor init:)
		(= local0 gDoVerbCode)
		(= gDoVerbCode goThere)
		((IconBar at: 0) type: 16384)
		(HandsOn)
	)

	(method (dispose)
		((IconBar at: 0) type: 1)
		(= gDoVerbCode local0)
		(super dispose:)
	)
)

(instance goThere of Code
	(properties)

	(method (doit param1 param2)
		(if (gCurRoom script:)
			(return)
		)
		(switch param1
			(1
				(if (== (param2 z:) 0)
					(return)
				else
					(gCurRoom newRoom: (param2 z:))
				)
			)
			(else
				(local0 doit: param1 param2)
			)
		)
	)
)

(instance trapDoor of Feature
	(properties
		z 410
		nsTop 8
		nsLeft 136
		nsBottom 20
		nsRight 192
	)

	(method (onMe param1)
		(return
			(and
				(<= nsLeft (param1 x:) nsRight)
				(<= nsTop (param1 y:) nsBottom)
			)
		)
	)
)

