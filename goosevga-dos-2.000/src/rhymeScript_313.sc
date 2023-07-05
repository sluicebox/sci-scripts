;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 313)
(include sci.sh)
(use Main)
(use PAvoider)
(use Sync)
(use Path)
(use Avd)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	[local0 5] = [157 100 126 120 -32768]
	[local5 5] = [157 100 179 94 -32768]
)

(instance tPath of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance tPath2 of Path
	(properties)

	(method (at param1)
		(return [local5 param1])
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(global109 stopUpd:)
				(teacher init: setLoop: 5 ignoreControl: -1 hide:)
				(DoAudio audWPLAY 12)
				(proc0_9)
				(gLongSong stop:)
				(rhymeSync init: 12)
				(gEgo
					setAvoider: PAvoider
					ignoreActors:
					setMotion:
						MoveTo
						(+ (global109 x:) 100)
						(global109 y:)
						watch
				)
				(self setScript: words)
				(= cycles 2)
			)
			(1
				(global129
					moveSpeed: 2
					setAvoider: Avd
					setMotion:
						MoveTo
						(+ (global109 x:) 25)
						(+ (global109 y:) 10)
						self
				)
			)
			(2
				(global129 setLoop: 1 setCel: 0 stopUpd:)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
					(= cycles 1)
				else
					(teacher show: setCycle: Walk setMotion: tPath self)
				)
			)
			(4
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(teacher loop: 7 cycleSpeed: 6 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(6
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(global109
						startUpd:
						setLoop: 0
						setCel: 0
						cycleSpeed: 6
						setCycle: End self
					)
					((global109 head:) dispose:)
				)
			)
			(8
				(= cycles 1)
			)
			(9
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
						startUpd:
						setLoop: -1
						setCycle: Walk
						setMotion: NewFollow global109
					)
				)
			)
			(10
				(global109 setCycle: Walk setMotion: MoveTo 179 94 self)
				(teacher loop: 8 cel: 0 setCycle: End)
				(global129 cel: 0 setMotion: 0)
			)
			(11
				(global109 posn: 400 1 hide:)
				(= cycles 1)
			)
			(12
				(if (< (rhymeSync prevSignal:) 60)
					(-- state)
					(= cycles 1)
				else
					(teacher
						setCycle: Walk
						setLoop: 9
						cycleSpeed: 9
						setMotion: tPath2 self
					)
					(global129 setCycle: Walk setMotion: NewFollow teacher)
				)
			)
			(13
				(if (< (rhymeSync prevSignal:) 70)
					(-- state)
				else
					(teacher dispose:)
					(global129 ignoreControl: -1 setMotion: MoveTo 179 94)
					(haha init:)
				)
				(= cycles 1)
			)
			(14
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
			(15
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 985)
		(DisposeScript 313)
		(gEgo startUpd:)
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
			cycleSpeed: 6
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
		(gEgo ignoreActors: 0 stopUpd:)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance teacher of Actor
	(properties
		x 179
		y 94
		yStep 3
		view 69
		loop 5
		moveSpeed 4
	)
)

