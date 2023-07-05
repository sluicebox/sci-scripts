;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 236)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(public
	climbTree 0
	cantClimbTree 1
)

(local
	local0
)

(instance climbTree of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 236)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 40 186 self)
			)
			(1
				(gEgo view: 517 setLoop: 0 setCel: 0 setPri: 13)
				(self cue:)
			)
			(2
				(= cycles 4)
			)
			(3
				(++ local0)
				(gEgo
					setCel:
						(if (== (gEgo cel:) 3)
							0
						else
							(+ (gEgo cel:) 1)
						)
					posn:
						(gEgo x:)
						(if (== (mod (gEgo cel:) 2) 0)
							(- (gEgo y:) 20)
						else
							(gEgo y:)
						)
				)
				(self cue:)
			)
			(4
				(if (< local0 6)
					(self changeState: 2)
				else
					(= local0 0)
					(= cycles 4)
				)
			)
			(5
				(gEgo
					setLoop: 1
					cel: 0
					x: (- (gEgo x:) 12)
					y: (- (gEgo y:) 33)
					setStep: 0 4
					cycleSpeed: 2
					moveSpeed: 2
					setCycle: End self
				)
			)
			(6
				(SetFlag 278)
				(User canInput: 1)
				((ScriptID 54 3) setScript: (ScriptID 54 5)) ; bird, flyAway
				(client setScript: 0)
			)
		)
	)
)

(instance cantClimbTree of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 236)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 40 180 self)
			)
			(1
				(gEgo view: 517 setLoop: 0 setCel: 0 setPri: 13)
				(= cycles 4)
			)
			(2
				(gEgo setCel: 1 posn: 40 160 cycleSpeed: 1 setCycle: Fwd)
				(= seconds 4)
			)
			(3
				(HighPrint 236 0) ; "It takes a lot of skill and practice to climb this tree."
				(HandsOn)
				(NormalEgo)
				(gEgo loop: 2 posn: 40 180)
				(client setScript: 0)
			)
		)
	)
)

