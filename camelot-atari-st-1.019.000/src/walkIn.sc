;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 185)
(include sci.sh)
(use Main)
(use EgoLooper)
(use Motion)
(use System)

(public
	walkIn 0
	stepOut 1
)

(local
	local0
)

(instance walkIn of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 185)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetMenu 1283 112 0)
				(SetMenu 1281 112 0)
				(= local0 (gEgo cycler:))
				(gEgo cycler: 0 looper: 0)
				(= cycles 1)
			)
			(1
				(gEgo
					illegalBits: 0
					view: 80
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 41
					setLoop: -1
					cycler: local0
					looper: EgoLooper
					posn: (gEgo x:) (+ (gEgo y:) 5)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 18) self
				)
			)
			(3
				(HandsOn)
				(= local0 0)
				(gEgo illegalBits: $8000)
				(client setScript: 0)
			)
		)
	)
)

(instance stepOut of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 185)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 (gEgo cycler:))
				(gEgo cycler: 0 looper: 0)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 80
					illegalBits: 0
					setLoop: 1
					cel: 0
					y: (- (gEgo y:) 5)
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 0
					setLoop: -1
					cycler: local0
					looper: EgoLooper
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 15) self
				)
			)
			(3
				(if (not (IsFlag 120))
					(HandsOn)
					(SetMenu 1283 112 1)
					(SetMenu 1281 112 1)
				)
				(= local0 0)
				(gEgo illegalBits: $8000)
				(client setScript: 0)
			)
		)
	)
)

