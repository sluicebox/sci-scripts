;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 336)
(include sci.sh)
(use Main)
(use LeapTo)
(use PAvoider)
(use Sync)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	local0
	local1 = 2
	local2
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DoAudio audWPLAY 13)
				(proc0_2)
				(Load rsSCRIPT 106)
				(gEgo setAvoider: PAvoider setMotion: MoveTo 131 118 self)
			)
			(1
				(global112 init: setCel: 0)
				(global129 dispose:)
				(proc0_9)
				(gEgo setMotion: MoveTo 134 120 self)
			)
			(2
				(proc0_7 gEgo global109)
				(gEgo setAvoider: 0 stopUpd:)
				(= cycles 1)
			)
			(3
				(gLongSong stop:)
				(rhymeSync init: 13)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(proc0_16 (Format @global300 336 0) -1 -1 18) ; "Jack Sprat could eat no fat."
				(global109 setScript: jackEat)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 336 1) -1 -1 18) ; "His wife could eat no lean;"
					(global110 setScript: wifeEat)
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 336 2) -1 -1 18) ; "And so, between them both,"
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 336 3) -1 -1 18) ; "They licked the platter clean."
				)
				(= cycles 1)
			)
			(9
				(if local1
					(-- state)
				)
				(= cycles 1)
			)
			(10
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
					(DisposeScript 106)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(11
				(gEgo setMotion: 0 setLoop: -1)
				(proc0_3)
				(if (== gScore gPossibleScore)
					(proc0_2)
					(gEgo setMotion: MoveTo 133 130)
				)
				(gLongSong number: 600 loop: -1 play:)
				(self dispose:)
				(= local2 1)
			)
		)
		(if local2
			(DisposeScript 336)
		)
	)
)

(instance jackEat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((global109 head:) setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(1
				((global109 head:) hide:)
				(global109
					view: 652
					cycleSpeed: 15
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(global109 setLoop: 4 cel: 0 setCycle: Fwd)
				(global112 setCel: (+ 1 (global112 cel:)))
				(= ticks (Random 50 90))
			)
			(3
				(global109 setLoop: 5 cel: 0 setCycle: End self)
			)
			(4
				(if (< (global112 cel:) 8)
					(= cycles (= state 1))
				else
					(global109 setLoop: 9 setCel: 0 cycleSpeed: 3 setCycle: End)
					(global112 setCel: (+ 1 (global112 cel:)))
					(= cycles 2)
				)
			)
			(5
				((= local0 (Actor new:))
					view: 652
					setLoop: 8
					setCel: 1
					init:
					setCycle: Fwd
					cycleSpeed: 3
					moveSpeed: 3
					illegalBits: 0
					ignoreActors: 1
					setStep: 2 2
					posn: 135 98 22
					setMotion: LeapTo 68 118 10 self
				)
				(= cycles 2)
			)
			(6
				(global109 setLoop: 1 setCel: 255 cycleSpeed: 14 setCycle: Beg)
				(global113 startUpd:)
				(= cycles 1)
			)
			(7
				(global111
					view: 652
					setLoop: 6
					cycleSpeed: 6
					setCel: 0
					setCycle: End self
				)
				(global113 signal: 0 setCycle: Fwd)
			)
			(8
				(global111 setLoop: 7 setCel: 0 setCycle: CT 5 1)
				(= cycles 60)
			)
			(9
				(global111 setCycle: End self)
				(local0 dispose:)
			)
			(10
				(DisposeScript 106)
				(global109 view: 651 setLoop: 8 setCel: 0)
				((global109 head:) show:)
				(-- local1)
				(self dispose:)
			)
		)
	)
)

(instance wifeEat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((global110 head:) setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(1
				((global110 head:) hide:)
				(global110
					view: 652
					cycleSpeed: 10
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(global110 setLoop: 2 cel: 0 setCycle: Fwd)
				(global112 setCel: (+ 1 (global112 cel:)))
				(= ticks (Random 44 80))
			)
			(3
				(global110 setLoop: 3 cel: 0 setCycle: End self)
			)
			(4
				(if (< (global112 cel:) 8)
					(= cycles (= state 1))
				else
					(global110 setLoop: 0 setCel: 255 setCycle: Beg self)
				)
			)
			(5
				(global110 view: 651 setLoop: 9 setCel: 0)
				((global110 head:) show:)
				(-- local1)
				(self dispose:)
			)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

