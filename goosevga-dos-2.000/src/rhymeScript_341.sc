;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 341)
(include sci.sh)
(use Main)
(use PAvoider)
(use Sync)
(use Path)
(use Motion)
(use System)

(public
	rhymeScript 0
)

(local
	[local0 13] = [116 38 119 44 119 89 116 93 70 113 50 114 -32768]
	local13
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DoAudio audWPLAY 4)
				(HandsOff)
				(Load rsSCRIPT 983)
				(proc0_9)
				(global129
					view: 64
					setStep: 2 2
					moveSpeed: 4
					setAvoider: 0
					illegalBits: 0
					ignoreActors: 1
				)
				(gLongSong stop:)
				(gEgo setAvoider: PAvoider setMotion: MoveTo 125 116 self)
			)
			(1
				(proc0_7 gEgo global109)
				(gEgo setAvoider: 0)
				(rhymeSync init: 4)
				(global109 setLoop: 6 setCel: 0)
				(= cycles 1)
			)
			(2
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
					(= cycles 1)
				else
					(proc0_16 (Format @global300 341 0) -1 -1 18) ; "Hickory, dickory, dock!"
					(global129 setCycle: Walk setMotion: MoveTo 152 95 self)
				)
			)
			(3
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
					(= cycles 1)
				else
					(proc0_16 (Format @global300 341 1) -1 -1 18) ; "The mouse ran up the clock;"
					(global129 setMotion: MoveTo 147 92 self)
				)
			)
			(4
				(global129 setMotion: MoveTo 142 88 self)
			)
			(5
				(global129 setMotion: MoveTo 142 45 self)
			)
			(6
				(global129 setMotion: MoveTo 145 38 self)
			)
			(7
				(global129 setMotion: MoveTo 130 38 self)
			)
			(8
				(global129 setCel: 0)
				(= cycles 1)
			)
			(9
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 341 2) -1 -1 18) ; "The clock struck one,"
				)
				(= cycles 1)
			)
			(10
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(global109 setCel: 1)
					(global129
						setLoop: 4
						setCel: 0
						setCycle: End
						cycleSpeed: 4
						setMotion: MoveTo 130 33 self
					)
				)
			)
			(11
				(global129 setMotion: MoveTo 130 38 self)
			)
			(12
				(global129 setCycle: Walk cycleSpeed: 3 setLoop: 1)
				(= cycles 1)
			)
			(13
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				)
				(= cycles 1)
			)
			(14
				(proc0_16 (Format @global300 341 3) -1 -1 18) ; "And down he run,"
				(global129 setLoop: -1 setMotion: runDown)
				(= ticks 75)
			)
			(15
				(global109 setCel: 2)
				(= cycles 1)
			)
			(16
				(if (< (rhymeSync prevSignal:) 60)
					(-- state)
				else
					(proc0_16 (Format @global300 341 0) -1 -1 18) ; "Hickory, dickory, dock!"
				)
				(= cycles 1)
			)
			(17
				(if (or (rhymeSync playing:) (global129 mover:))
					(-- state)
					(= cycles 1)
				else
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				)
			)
			(18
				(gEgo setMotion: 0 setLoop: -1)
				(global109 setLoop: 8 setCel: 0)
				(HandsOn)
				(if (== gScore gPossibleScore)
					(HandsOff)
					(gEgo setAvoider: PAvoider setMotion: MoveTo 209 103)
				)
				(gLongSong number: 601 loop: -1 play:)
				(self dispose:)
				(DisposeScript 983)
				(= local13 1)
			)
		)
		(if local13
			(DisposeScript 341)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance runDown of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

