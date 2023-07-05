;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 353)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use User)
(use System)

(public
	Lady4ResponseScript 0
)

(local
	local0
)

(instance Lady4ResponseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (User controls:))
				(HandsOff)
				(= register (client mover:))
				(gEgo setMotion: 0)
				(client
					mover: 0
					setMotion:
						MoveTo
						(if (<= (gEgo x:) (client x:))
							(+ (gEgo x:) 15)
						else
							(- (gEgo x:) 15)
						)
						(if (<= (gEgo y:) (client y:))
							(+ (gEgo y:) 5)
						else
							(- (gEgo y:) 5)
						)
						self
				)
			)
			(1
				(client
					view: 902
					cel: 0
					setLoop: (if (<= (gEgo x:) (client x:)) 1 else 0)
					setCycle: End self
				)
			)
			(2
				(Print 353 0 #time 10) ; "Get lost jerk!"
				(HandsOn)
				(User controls: local0)
				(client
					view: 202
					setLoop: -1
					setCycle: Walk
					setMotion: register
					setScript: 0
				)
				(DisposeScript 353)
			)
		)
	)
)

