;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 313)
(include sci.sh)
(use Main)
(use Sync)
(use Path)
(use Avoid)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	local0
	[local1 5] = [157 100 126 120 -32768]
	[local6 5] = [157 100 179 94 -32768]
)

(instance tPath of Path
	(properties)

	(method (at param1)
		(return [local1 param1])
	)
)

(instance tPath2 of Path
	(properties)

	(method (at param1)
		(return [local6 param1])
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_9)
				(Load rsCURSOR 69)
				(gLongSong stop:)
				(rhymeSync init: 12)
				(gEgo
					setAvoider: (Avoid new:)
					ignoreActors:
					setMotion:
						MoveTo
						(+ (global109 x:) 100)
						(global109 y:)
						watch
				)
				(global129
					moveSpeed: 2
					setAvoider: (Avoid new:)
					setMotion:
						MoveTo
						(+ (global109 x:) 25)
						(+ (global109 y:) 10)
						self
				)
			)
			(1
				(global129 setLoop: 1 setCel: 0 stopUpd:)
				(self setScript: words)
				(= cycles 1)
			)
			(2
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
					(= cycles 1)
				else
					((= local0 (Act new:))
						init:
						view: 69
						posn: 179 94
						setLoop: 5
						setCel: 0
						xStep: 3
						yStep: 3
						ignoreControl: -1
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: tPath self
					)
				)
			)
			(3
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(local0 loop: 7 cycleSpeed: 6 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(global109
						setLoop: 0
						setCel: 0
						cycleSpeed: 2
						setCycle: End self
					)
					((global109 head:) dispose:)
				)
			)
			(5
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
					(= cycles 1)
				else
					(global109
						setLoop: 4
						setCycle: Walk
						setMotion: MoveTo 142 119 self
					)
					(global129
						setLoop: -1
						setCycle: Walk
						setMotion: NewFollow global109
					)
				)
			)
			(6
				(global109 setCycle: Walk setMotion: MoveTo 179 94 self)
				(local0 loop: 8 cel: 0 setCycle: End)
				(global129 cel: 0 setMotion: 0)
			)
			(7
				(global109 posn: 400 1 hide:)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 60)
					(-- state)
					(= cycles 1)
				else
					(local0
						setCycle: Walk
						setLoop: 9
						cycleSpeed: 0
						setMotion: tPath2 self
					)
					(global129 setCycle: Walk setMotion: NewFollow local0)
				)
			)
			(9
				(if (< (rhymeSync prevSignal:) 70)
					(-- state)
				else
					(local0 dispose:)
					(global129 ignoreControl: -1 setMotion: MoveTo 179 94)
					(haha init:)
				)
				(= cycles 1)
			)
			(10
				(if (or script (rhymeSync playing:))
					(-- state)
					(= cycles 1)
				else
					(haha dispose:)
					(Animate (gCast elements:) 0)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				)
			)
			(11
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 1 loop: -1 play:)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(HandsOn)
				)
				(self dispose:)
				(DisposeScript 985)
			)
		)
	)
)

(instance words of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(proc0_16 (Format @global300 313 0)) ; "Mary had a little lamb,"
				)
				(= cycles 1)
			)
			(1
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 313 1)) ; "Its fleece was white as snow;"
				)
				(= cycles 1)
			)
			(2
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 313 2)) ; "Everywhere that Mary went"
				)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 313 3)) ; "The lamb was sure to go."
				)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(proc0_16 (Format @global300 313 4)) ; "It followed her to school one day;"
				)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 60)
					(-- state)
				else
					(proc0_16 (Format @global300 313 5)) ; "Which was against the rule;"
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 70)
					(-- state)
				else
					(proc0_16 (Format @global300 313 6)) ; "It made the children laugh and play"
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 80)
					(-- state)
					(= cycles 1)
				else
					(proc0_16 (Format @global300 313 7)) ; "To see a lamb at school."
					(self dispose:)
				)
			)
		)
	)
)

(instance haha of Prop
	(properties)

	(method (init)
		(self
			view: 69
			setLoop: 13
			cel: 0
			cycleSpeed: 1
			setCycle: Fwd
			setPri: 10
		)
		(super init:)
	)

	(method (doit)
		(if (== (self cel:) 0)
			(self x: (Random 104 246) y: (Random 30 90))
		)
		(super doit:)
	)
)

(instance watch of Script
	(properties)

	(method (cue)
		(proc0_7 gEgo global109)
		(gEgo setAvoider: 0 ignoreActors: 0)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

