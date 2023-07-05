;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 126)
(include sci.sh)
(use Main)
(use Motion)
(use User)

(class MoveForward of Motion
	(properties
		oldIllegalBits -32768
	)

	(method (init param1 param2 &tmp temp0 temp1)
		(= global80 1)
		(User controls: 0)
		(User canInput: 0)
		(= oldIllegalBits (gEgo illegalBits:))
		(gEgo illegalBits: 0)
		(= temp0 (= temp1 0))
		(switch (param1 loop:)
			(0
				(= temp0 param2)
			)
			(1
				(= temp0 (- 0 param2))
			)
			(2
				(= temp1 param2)
			)
			(3
				(= temp1 (- 0 param2))
			)
		)
		(super init: param1 (+ (param1 x:) temp0) (+ (param1 y:) temp1))
	)

	(method (motionCue)
		(= global80 0)
		(User controls: 1)
		(if (not global124)
			(User canInput: 1)
		)
		(gEgo illegalBits: oldIllegalBits)
		(super motionCue:)
	)

	(method (onTarget)
		(return
			(and
				(<= (Abs (- (client x:) x)) (client xStep:))
				(<= (Abs (- (client y:) y)) (client yStep:))
			)
		)
	)
)

(class LeaveRoom of MoveForward
	(properties
		gotoRoom 0
	)

	(method (init param1 param2 param3 param4)
		(= gotoRoom param2)
		(param1 setLoop: param3)
		(super init: param1 param4)
	)

	(method (motionCue)
		(client mover: 0)
		(self dispose:)
		(gCurRoom newRoom: gotoRoom)
	)
)

