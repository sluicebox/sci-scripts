;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 343)
(include sci.sh)
(use Main)
(use Sync)
(use Avoid)
(use Motion)
(use System)

(public
	rhymeScript 0
)

(local
	local0
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(Load rsCURSOR 69)
				(proc0_9)
				(gLongSong stop:)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 169 121 self
				)
				(rhymeSync init: 3)
			)
			(1
				(global110 dispose:)
				(gEgo setAvoider: 0 setMotion: MoveTo 140 137 self)
				(global109 setScript: jackEat)
			)
			(2
				(DisposeScript 985)
				(proc0_7 gEgo global109)
				(gEgo setAvoider: 0 stopUpd:)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(proc0_16 (Format @global300 343 0) -1 -1 18) ; "Little Jack Horner"
				)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 343 1) -1 -1 18) ; "Sat in the corner"
				)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 343 2) -1 -1 18) ; "Eating his Christmas pie;"
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 343 3) -1 -1 18) ; "He stuck in his thumb,"
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(proc0_16 (Format @global300 343 4) -1 -1 18) ; "And pulled out a plum,"
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 70)
					(-- state)
				else
					(proc0_16 (Format @global300 343 5) -1 -1 18) ; "And said, "What a good boy am I!""
				)
				(= cycles 1)
			)
			(9
				(if (or (rhymeSync playing:) (global109 script:))
					(-- state)
					(= cycles 1)
				else
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				)
			)
			(10
				(global109 cycleSpeed: 1 setCycle: Beg self)
			)
			(11
				(global109 setLoop: 13 setCycle: Fwd)
				(gEgo setMotion: 0 setLoop: -1)
				(proc0_3)
				(if (== gScore gPossibleScore)
					(proc0_2)
					(gEgo setAvoider: (Avoid new:) setMotion: MoveTo 139 146)
				)
				(gLongSong number: 1 loop: -1 play:)
				(self dispose:)
				(= local0 1)
			)
		)
		(if local0
			(DisposeScript 343)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance jackEat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global109 setLoop: 7 setCel: 2 cycleSpeed: 0 stopUpd:)
				(global109 setCycle: Walk setMotion: MoveTo 77 101 self)
			)
			(1
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
					(= cycles 1)
				else
					(global109
						setLoop: 8
						setCel: 0
						cycleSpeed: 2
						setCycle: End self
					)
				)
			)
			(2
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
					(= cycles 1)
				else
					(global109 setLoop: 9 setCel: 0 setCycle: End self)
				)
			)
			(3
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(global109 setLoop: 13 setCel: 0 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(global109 setLoop: 10 setCel: 0 setCycle: End self)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

