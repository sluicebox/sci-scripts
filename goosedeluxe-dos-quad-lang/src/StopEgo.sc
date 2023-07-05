;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	StopEgo 0
)

(local
	local0
)

(class StopEgo of Fwd
	(properties)

	(method (init)
		(super init: &rest)
		(self doit:)
	)

	(method (doit &tmp temp0)
		(if (and (client isStopped:) (not (client mover:)))
			(if (< (= temp0 (client loop:)) 4)
				(client setLoop: (+ temp0 4))
				(client setCel: 1)
				(client setScript: sEgoStopScript)
			)
			(if (and (not local0) (<= 41 global130 47) (not (gCurRoom script:)))
				(global129 cel: 0)
				(= local0 1)
			)
		else
			(= local0 0)
			(super doit: &rest)
		)
	)
)

(instance sEgoStopScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(if (gUser canControl:)
					(= temp1 (Random 0 2))
					(= temp0 (gEgo cel:))
					(cond
						((> temp1 temp0)
							(gEgo setCycle: CT temp1 1 self)
						)
						((< temp1 temp0)
							(gEgo setCycle: CT temp1 -1 self)
						)
						(else
							(self cue:)
						)
					)
				else
					(self cue:)
				)
			)
			(2
				(gEgo setCycle: StopEgo)
				(self changeState: 0)
			)
		)
	)
)

