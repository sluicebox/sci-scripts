;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 307)
(include sci.sh)
(use Main)
(use Sync)
(use Avoid)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	local0
	local1
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsCURSOR 69)
				(Load rsSCRIPT 991)
				(gEgo setScript: egoGive)
			)
			(1
				(gLongSong stop:)
				(rhymeSync init: 8)
				((global109 head:) hide:)
				(global109 cycleSpeed: 1 setLoop: 4 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(proc0_16 (Format @global300 307 0) 130) ; "Hey, diddle diddle!"
				)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 307 1) 130) ; "The cat and the fiddle,"
				)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 307 2) 130) ; "The cow jumped over the moon;"
					(self setScript: cowJump)
				)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(proc0_16 (Format @global300 307 3) 130) ; "The little dog laughed to see such sport,"
					(global111
						signal: (& (global111 signal:) $feff)
						setLoop: 10
						cycleSpeed: 2
						setCel: 0
						setCycle: End self
					)
				)
			)
			(6
				(global111 setLoop: 11 setCel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
					(= cycles 1)
				else
					(proc0_16 (Format @global300 307 4) 130) ; "And the dish ran away with the spoon."
					((= local0 (Act new:))
						view: 86
						setLoop: 12
						setCel: 0
						posn: 10 137
						init:
						xStep: 4
						ignoreControl: -1
						ignoreActors: 1
						moveSpeed: 0
						setCycle: Fwd
						setMotion: MoveTo 164 69 self
					)
					(global111 loop: 13 cel: 0 setCycle: End)
				)
			)
			(8
				(local0 setCycle: End setMotion: JumpTo 194 60 self)
			)
			(9
				(local0 dispose:)
				(= local0 0)
				(= cycles 1)
			)
			(10
				(if (or (rhymeSync playing:) script)
					(-- state)
					(= cycles 1)
				else
					(global111 loop: 9 setCycle: Fwd)
					((global109 head:) show:)
					(global109 setLoop: 14 setCel: 3 setCycle: CT 1 -1 self)
				)
			)
			(11
				(proc0_16 0)
				(proc0_10)
				(= seconds 2)
			)
			(12
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 1 loop: -1 play:)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(HandsOn)
				)
				(self dispose:)
				(DisposeScript 991)
				(= local1 1)
			)
		)
		(if local1
			(DisposeScript 307)
		)
	)
)

(instance egoGive of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (== (global109 cel:) 3))
			((global109 head:) hide:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 131 123 self
				)
			)
			(1
				(proc0_9)
				(global109 loop: 14 cel: 1 cycleSpeed: 2 setCycle: End)
				((gGoals at: 5) egoReturned: 1)
				(gEgo
					posn: 131 123
					setAvoider: 0
					setMotion: MoveTo 160 130 self
				)
			)
			(2
				(rhymeScript cue:)
				(proc0_7 gEgo global109)
				(gEgo stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance cowJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global110
					signal: (& (global110 signal:) $feff)
					setLoop: 6
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(global112 signal: 262)
				(global110 setLoop: 7 setCel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(2
				(global112 signal: 0)
				(global110 setLoop: 8 setCel: 0 setMotion: MoveTo 130 -21 self)
			)
			(3
				(= cycles 5)
			)
			(4
				(global110
					setPri: 0
					posn: 110 -1
					xStep: 2
					yStep: 2
					setCel: 1
					setMotion: MoveTo 73 47 self
				)
			)
			(5
				(global110 dispose:)
				(= global110 0)
				(global112 signal: 257)
				(client setScript: 0)
			)
		)
	)
)

