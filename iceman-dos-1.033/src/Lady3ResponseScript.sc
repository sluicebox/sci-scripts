;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 352)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use User)
(use System)

(public
	Lady3ResponseScript 0
)

(local
	local0
)

(instance Lady3ResponseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (User controls:))
				(HandsOff)
				(= register (client mover:))
				(client mover: 0)
				(gEgo setMotion: 0)
				(client
					setMotion:
						kickSandMover
						(gEgo x:)
						(+ (gEgo y:) 13)
						self
				)
			)
			(1
				(client view: 902 setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(switch (Random 0 2)
					(0
						(Print 352 0 #time 10) ; "Get lost, jerk!"
					)
					(1
						(Print 352 1 #time 10) ; "Pound sand, twit!"
					)
					(2
						(Print 352 2 #time 10) ; "Try sloppin' hogs!"
					)
				)
				(client setScript: 0)
			)
		)
	)

	(method (dispose)
		(client view: 702 setLoop: -1 setCycle: Walk setMotion: register)
		(super dispose:)
		(HandsOn)
		(User controls: local0)
		(DisposeScript 352)
	)
)

(instance kickSandMover of MoveTo
	(properties)

	(method (doit)
		(super doit:)
		(if (client isStopped:)
			(self moveDone:)
		)
	)
)

