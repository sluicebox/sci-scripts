;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 327)
(include sci.sh)
(use Main)
(use PAvoider)
(use Sync)
(use PolyPath)
(use Motion)
(use System)

(public
	rhymeScript 0
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DoAudio audWPLAY 11)
				(proc0_9)
				(proc0_2)
				(gLongSong stop:)
				(rhymeSync init: 11)
				(global129 illegalBits: -32756)
				(gEgo setScript: watchRhyme)
				(self setScript: goHome)
				(= cycles 1)
			)
			(1
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(proc0_16 (Format @global300 327 0)) ; "Oh where, oh where has my little dog gone?"
				)
				(= cycles 1)
			)
			(2
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 327 1)) ; "Oh where, oh where can he be?"
				)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 327 2)) ; "With his ears cut short"
				)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 327 3)) ; "And his tail cut long,"
				)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(proc0_16 (Format @global300 327 1)) ; "Oh where, oh where can he be?"
				)
				(= cycles 1)
			)
			(6
				(if (or (rhymeSync playing:) script)
					(-- state)
					(= cycles 1)
				else
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				)
			)
			(7
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(DisposeScript 985)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 327)
	)
)

(instance watchRhyme of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setAvoider: PAvoider setMotion: PolyPath 150 150 self)
			)
			(1
				(proc0_7 gEgo global109)
				(gEgo setAvoider: 0 setLoop: 3)
				(self dispose:)
			)
		)
	)
)

(instance goHome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
					(= cycles 1)
				else
					(global110 setLoop: 3)
					((gGoals at: 3) egoReturned: 1)
					(global129
						ignoreActors: 1
						moveSpeed: 6
						setMotion: MoveTo 143 123 self
					)
				)
			)
			(1
				(global129 setAvoider: 0 setLoop: 5 cycleSpeed: 6 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
					(= cycles 1)
				else
					(global129
						setLoop: -1
						cycleSpeed: 6
						setCycle: Walk
						setMotion: MoveTo 120 134 self
					)
				)
			)
			(3
				(global110 setLoop: 4)
				(global129 setMotion: MoveTo 99 123 self)
			)
			(4
				(global129 setLoop: 4 cycleSpeed: 6 setCycle: Fwd)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
					(= cycles 1)
				else
					(global129
						setLoop: -1
						cycleSpeed: 3
						setCycle: Walk
						setMotion: MoveTo 120 134 self
					)
				)
			)
			(6
				(global129 setMotion: MoveTo 143 123 self)
			)
			(7
				(global129 setLoop: 5 cycleSpeed: 6 setCycle: Fwd)
				(global110 dispose:)
				(global109 setLoop: 8 setCel: 1 setCycle: CT 2 1 self)
			)
			(8
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(global109 setCycle: CT 5 1 self)
				)
			)
			(9
				(global129 hide:)
				(global109 setCycle: End self)
			)
			(10
				(global109 setCel: 0 setLoop: 9 setCycle: Fwd)
				(= cycles 1)
			)
			(11
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
					(= cycles 1)
				else
					(= seconds 3)
				)
			)
			(12
				(global109 setCel: 0 setLoop: 10 setCycle: End self)
			)
			(13
				(global109 setCel: 0 setLoop: 5)
				(global110 init: global109)
				(global111 init:)
				(self dispose:)
			)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

