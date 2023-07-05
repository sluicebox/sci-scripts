;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use Timer)
(use Game)
(use System)

(public
	PursuitRgn 0
	pursuitTimer 1
)

(local
	local0
)

(class PursuitRgn of Rgn
	(properties)

	(method (init)
		(super init:)
		(cond
			((< gHowFast 5)
				(= local0 60)
			)
			((< gHowFast 10)
				(= local0 40)
			)
			((<= gHowFast 15)
				(= local0 20)
			)
		)
		(if (not (HaveMouse))
			(= local0 (* 2 local0))
		)
	)

	(method (newRoom newRoomNumber)
		(= initialized 0)
		(= keep (OneOf newRoomNumber 420 430 435 440 448 450 454 460 480 490 660))
		(if (not keep)
			(pursuitTimer dispose: delete:)
		)
	)

	(method (increaseTime)
		(pursuitTimer seconds: (+ (pursuitTimer seconds:) local0))
	)

	(method (decreaseTime)
		(pursuitTimer seconds: (- (pursuitTimer seconds:) local0))
	)
)

(instance pursuitTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom notify:)
	)
)

