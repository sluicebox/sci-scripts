;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 49)
(include sci.sh)
(use Main)
(use Grooper)
(use System)

(public
	doorMat 0
)

(class doorMat of Obj
	(properties
		thePolyList 0
		loopAllow1 0
		loopAllow2 0
		loopAllow3 0
		theScript 0
	)

	(method (init param1 param2 param3 param4 param5)
		(super init: &rest)
		(= thePolyList param1)
		(= loopAllow1 param2)
		(= loopAllow2 param3)
		(= loopAllow3 param4)
		(= theScript param5)
		(gTheDoits add: self)
	)

	(method (doit &tmp temp0)
		(if
			(and
				(thePolyList onMe: (gEgo x:) (gEgo y:))
				(not (gCurRoom script:))
				(OneOf (gEgo loop:) loopAllow1 loopAllow2 loopAllow3)
				(= temp0 (gEgo looper:))
				(not (temp0 isKindOf: Grycler))
			)
			(gCurRoom setScript: theScript)
		)
	)

	(method (dispose)
		(thePolyList dispose:)
		(gTheDoits delete: self)
		(super dispose: &rest)
	)
)

