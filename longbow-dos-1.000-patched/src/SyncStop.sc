;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 892)
(include sci.sh)
(use Main)
(use Motion)

(public
	SyncStop 0
)

(class SyncStop of Fwd
	(properties
		vWalking 0
		vStopped 0
	)

	(method (init param1 param2 param3)
		(if argc
			(= vWalking ((= client param1) view:))
			(if (>= argc 2)
				(= vStopped param2)
				(if (>= argc 3)
					(= caller param3)
				)
			)
		)
		(super init: client)
	)

	(method (motionCue &tmp temp0)
		(= temp0 (client mover:))
		(if (and caller (or (not temp0) (temp0 completed:)))
			(caller cue:)
		)
	)

	(method (dispose)
		(if (== (client view:) vStopped)
			(client view: vWalking)
		)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(cond
			((not (client isStopped:))
				(if (== (client view:) vStopped)
					(client view: vWalking)
				)
			)
			((>= (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
				(= cycleCnt gGameTime)
				(if (== (client view:) vWalking)
					(client view: vStopped)
					(if (and (= temp0 (client mover:)) (not (temp0 completed:)))
						(client setMotion: 0)
					)
					(self motionCue:)
				)
			)
		)
		(super doit:)
	)
)

