;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use rm15)
(use Sound)
(use Motion)
(use Actor)

(public
	castFlame 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 6] = [195 225 262 17 17 44]
	[local11 6] = [47 43 92 47 134 155]
)

(instance flScript of KScript
	(properties)

	(method (dispose)
		(local0 dispose:)
		(ClearFlag 283)
		(proc15_1 (not (IsFlag 150)))
		(DisposeScript 110)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Fwd setMotion: MoveTo local3 local4 self)
			)
			(1
				(if (and local2 (IsFlag 281))
					(= local2 0)
					(SetFlag 280)
					(client
						y: (+ (client y:) 15)
						z: 15
						setMotion: MoveTo (gEgo x:) (gEgo y:) self
					)
				else
					(self cue:)
				)
			)
			(2
				(if local2
					(= local2 0)
					(gKobold getHurt: global346)
				)
				(if (< (client distanceTo: gEgo) 20)
					(proc15_7 global346)
				)
				(client
					view: 532
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(local0 number: (SoundFX 45) play:)
			)
			(3
				(client dispose:)
			)
		)
	)
)

(instance castFlame of KScript
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(LookAt gEgo gKobold)
				(SetFlag 283)
				(= temp1 (gEgo loop:))
				(if
					(or
						(and global290 temp1)
						(and (not global290) (& temp1 $0001))
					)
					(= temp1 1)
				else
					(= temp1 0)
				)
				(gEgo view: 522 setLoop: temp1 cel: 0 setCycle: CT 5 1 self)
			)
			(1
				(if (TrySkill 12 0 (- 50 (/ (gEgo distanceTo: gKobold) 5))) ; magic
					(= local2 1)
					(= local3 (gKobold x:))
					(= local4 (gKobold y:))
				else
					(= temp0 (+ (Random 0 2) (* global348 3)))
					(= local2 0)
					(= local3 [local5 temp0])
					(= local4 [local11 temp0])
				)
				(gEgo setCycle: End)
				((= local0 (Sound new:))
					number: (SoundFX 33)
					priority: 3
					init:
					play:
				)
				((Act new:)
					view: 522
					setLoop: 2
					setCel: 0
					illegalBits: 0
					ignoreActors:
					x:
						(if (== (gEgo loop:) 1)
							(- (gEgo x:) 19)
						else
							(+ (gEgo x:) 19)
						)
					y: (- (gEgo y:) 21)
					setStep: 12 8
					init:
					setScript: flScript
				)
				(self dispose:)
			)
		)
	)
)

