;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 237)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	outOnALimb 0
	climbDown 1
)

(local
	local0
)

(instance outOnALimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 55
					posn: (gEgo x:) (- (gEgo y:) 10)
					setLoop: 8
					setCel: 0
					setPri: 14
				)
				(= cycles 3)
			)
			(1
				(++ local0)
				(gEgo setCel: 1)
				(= cycles 3)
			)
			(2
				(gEgo setCel: 2 posn: (+ (gEgo x:) 2) (gEgo y:))
				(= cycles 3)
			)
			(3
				(gEgo setCel: 3 posn: (+ (gEgo x:) 2) (- (gEgo y:) 1))
				(= cycles 3)
			)
			(4
				(gEgo setCel: 4 posn: (+ (gEgo x:) 2) (- (gEgo y:) 1))
				(= cycles 3)
			)
			(5
				(gEgo setCel: 0)
				(cond
					((== local0 3)
						(if (TrySkill 2 30) ; agility
							(self changeState: 1)
						else
							(= local0 0)
							(gEgo setScript: (ScriptID 54 6)) ; treeFall
							(DisposeScript 237)
						)
					)
					((< local0 5)
						(self changeState: 1)
					)
					(else
						(= local0 0)
						(self cue:)
					)
				)
			)
			(6
				(HighPrint 237 0) ; "You carefully bend down and reach into the nest."
				(gEgo posn: 59 72 setLoop: 9 setCycle: End self)
			)
			(7
				(HighPrint 237 1) ; "In the nest, you find a gold ring."
				(HighPrint 237 2) ; "You take the ring and move carefully back along the limb."
				(SetFlag 210)
				(gEgo get: 19 setCycle: Beg self) ; healer's ring
				(SolvePuzzle 667 3)
			)
			(8
				(gEgo setLoop: 8 setCel: 0)
				(++ local0)
				(= cycles 3)
			)
			(9
				(gEgo setCel: 4)
				(= cycles 3)
			)
			(10
				(gEgo posn: (- (gEgo x:) 2) (+ (gEgo y:) 1) setCel: 3)
				(= cycles 3)
			)
			(11
				(gEgo posn: (- (gEgo x:) 2) (+ (gEgo y:) 1) setCel: 2)
				(= cycles 3)
			)
			(12
				(gEgo posn: (- (gEgo x:) 2) (gEgo y:) setCel: 1)
				(= cycles 3)
			)
			(13
				(if (< local0 5)
					(self changeState: 8)
				else
					(= local0 0)
					(self cue:)
				)
			)
			(14
				(HighPrint 237 3) ; "Made it! Now back down the tree."
				(gEgo setScript: climbDown)
			)
		)
	)
)

(instance climbDown of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 237)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 517
					setLoop: 1
					cel: 6
					posn: 28 93
					setStep: 0 4
					cycleSpeed: 2
					moveSpeed: 2
					setCycle: Beg self
				)
			)
			(1
				(gEgo
					setLoop: 0
					setCel: 0
					x: (+ (gEgo x:) 12)
					y: (+ (gEgo y:) 33)
				)
				(self cue:)
			)
			(2
				(= cycles 4)
			)
			(3
				(++ local0)
				(gEgo
					setCel:
						(if (== (gEgo cel:) 0)
							3
						else
							(- (gEgo cel:) 1)
						)
					posn:
						(gEgo x:)
						(if (== (mod (gEgo cel:) 2) 1)
							(+ (gEgo y:) 19)
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
				(NormalEgo)
				(HandsOn)
				(ClearFlag 278)
				(client setScript: 0)
			)
		)
	)
)

