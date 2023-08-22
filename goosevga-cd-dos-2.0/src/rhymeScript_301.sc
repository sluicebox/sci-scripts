;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use Sync)
(use Avoid)
(use Motion)
(use Actor)
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
				(HandsOff)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 134 121 self
				)
			)
			(1
				(global109 x: (+ (global109 x:) 9) loop: 8)
				(global110 hide:)
				((global110 head:) hide:)
				((global109 head:) hide:)
				(gLongSong stop:)
				(proc0_9)
				(Load rsCURSOR 69)
				(Load rsVIEW 61)
				(rhymeSync init: 17)
				(gEgo setMotion: MoveTo 183 125 self)
			)
			(2
				(proc0_7 gEgo global109)
				(gEgo setAvoider: 0 stopUpd:)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(proc0_16 (Format @global300 301 0)) ; "Jack and Jill went up the hill,"
					(global109
						setLoop: 9
						cycleSpeed: 0
						setCycle: Walk
						setMotion: MoveTo 118 50
					)
				)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 301 1)) ; "To fetch a pail of water;"
				)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 301 2)) ; "Jack fell down,"
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(global109 setScript: jackFall)
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(proc0_16 (Format @global300 301 3)) ; "And broke his crown,"
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 70)
					(-- state)
					(= cycles 1)
				else
					(proc0_16 (Format @global300 301 4)) ; "And Jill came tumbling after."
					(global110 cycleSpeed: 0 setCycle: End self)
				)
			)
			(9
				(global110
					setLoop: 3
					yStep: 2
					setCycle: Walk
					setMotion: MoveTo (global110 x:) (global109 y:) self
				)
			)
			(10
				(global110 loop: 6 cel: 2)
				(= cycles 1)
			)
			(11
				(if (< (rhymeSync prevSignal:) 80)
					(-- state)
					(= cycles 1)
				else
					(global110 setLoop: 6 setCycle: Fwd)
					(= cycles 14)
				)
			)
			(12
				(bucket dispose:)
				(global110 loop: 8 stopUpd:)
				((global110 head:) show:)
				(= cycles 1)
			)
			(13
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(14
				(global109 setScript: 0)
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 1 loop: -1 play:)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(HandsOn)
				)
				(self dispose:)
				(= local0 1)
			)
		)
		(if local0
			(DisposeScript 301)
		)
	)
)

(instance bucket of Act
	(properties
		y 52
		x 118
		view 61
		loop 4
		signal 26624
	)
)

(instance jackFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global109
					setMotion: 0
					setLoop: 10
					setCel: 0
					moveSpeed: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(1
				(global109
					view: 61
					x: (- (global109 x:) 8)
					setLoop: 0
					setCycle: End self
				)
				(global110
					show:
					view: 61
					setLoop: 1
					setCel: 0
					posn: (+ (global109 x:) 20) (global109 y:)
					stopUpd:
				)
			)
			(2
				(bucket
					y: (+ (global110 y:) 2)
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo (bucket x:) 200
					init:
				)
				(global109 setLoop: 2 cel: 0)
				(= cycles 1)
			)
			(3
				(global109 setCycle: Fwd yStep: 3 setMotion: MoveTo 99 140 self)
			)
			(4
				(global109 loop: 5 cel: 2 setCycle: 0)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 60)
					(-- state)
				else
					(global109 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 70)
					(-- state)
					(= cycles 1)
				else
					(global109 loop: 7 setCycle: 0 cel: 0 stopUpd:)
					((global109 head:) show:)
					(self dispose:)
				)
			)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

