;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 227)
(include sci.sh)
(use Main)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	happyFace 0
)

(instance ball of Act
	(properties
		y 78
		x 267
		view 96
		loop 7
		cel 5
	)
)

(instance happyFace of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 227)
		(DisposeScript 991)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 247 119 self)
			)
			(1
				(gEgo view: 296 setLoop: 6 setCel: 0)
				(HighPrint 227 0) ; "It's a little sign that reads: "Do not read this sign under any circumstances."
				(= cycles 3)
			)
			(2
				((ScriptID 96 11) setCycle: End self) ; door13
			)
			(3
				((ScriptID 96 11) hide:) ; door13
				(ball
					illegalBits: 0
					ignoreActors:
					setPri: 8
					setLoop: 7
					setCel: 5
					init:
				)
				(= cycles 2)
			)
			(4
				((ScriptID 96 16) ; effect
					number: (SoundFX 86)
					loop: 1
					priority: 2
					play:
				)
				(ball posn: 261 85)
				(gEgo setCel: 1)
				(= cycles 2)
			)
			(5
				((ScriptID 96 16) stop:) ; effect
				(gEgo
					moveSpeed: 2
					setMotion: MoveTo 249 123
					cycleSpeed: 2
					setCycle: CT 3 1 self
				)
				(ball setMotion: JumpTo 195 189)
				(if (not (IsFlag 259))
					((ScriptID 96 6) setCel: 3) ; head
					((ScriptID 96 5) ; yorick
						setLoop: 4
						cel: 0
						cycleSpeed: 1
						setCycle: Fwd
					)
				)
			)
			(6
				((ScriptID 96 11) show: cycleSpeed: 0 setCycle: Beg) ; door13
				(gEgo setCycle: End self)
			)
			(7
				(SetFlag 258)
				(ball dispose:)
				(= cycles 2)
			)
			(8
				((ScriptID 96 11) stopUpd:) ; door13
				(SetFlag 269)
				(client setScript: 0)
			)
		)
	)
)

