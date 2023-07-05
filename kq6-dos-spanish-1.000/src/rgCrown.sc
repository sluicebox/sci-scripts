;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Feature)
(use Game)
(use System)

(public
	rgCrown 0
	proc10_2 2
	rocks 4
)

(procedure (proc10_2 param1 param2)
	(if (gCurRoom script:)
		((gCurRoom script:)
			setScript: param1 (gCurRoom script:) (if (> argc 1) param2 else 0)
		)
	else
		(gCurRoom setScript: param1 0 (if (> argc 1) param2 else 0))
	)
)

(class rgCrown of Rgn
	(properties
		flag1 0
		flag2 0
		singSingHas 0
	)

	(method (isSet param1 param2 &tmp [temp0 2])
		(return
			(if (< argc 2)
				(& flag1 param1)
			else
				(& flag2 param2)
			)
		)
	)

	(method (clrIt param1 param2 &tmp [temp0 2])
		(if (< argc 2)
			(&= flag1 (~ param1))
		else
			(&= flag2 (~ param2))
		)
	)

	(method (setIt param1 param2 &tmp [temp0 2])
		(if (< argc 2)
			(|= flag1 param1)
		else
			(|= flag2 param2)
		)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 200 210 220 230 240 250 260 270 280 290))
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(super init: &rest)
	)
)

(instance rocks of Feature
	(properties
		noun 2
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 5 2) ; Look, Do, Talk
			(gMessager say: noun theVerb (if (== theVerb 1) 1 else 0) 0 0 0) ; Look
		else
			(gMessager say: noun 0 0 0 0 0) ; "There's no reason to use that on the rock."
		)
	)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
	)
)

