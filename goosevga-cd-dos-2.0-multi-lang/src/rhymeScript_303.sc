;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 303)
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

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 143 130 self
				)
			)
			(1
				(proc0_9)
				(global109 loop: 8)
				(gEgo setMotion: MoveTo 126 151 self)
			)
			(2
				(gEgo setAvoider: 0)
				(proc0_7 gEgo global109)
				(gEgo stopUpd:)
				(Watcher init:)
				(woman1 init:)
				(woman2 init:)
				(= cycles 1)
			)
			(3)
			(4)
			(5
				(gLongSong stop:)
				(rhymeSync init: 10)
			)
			(6
				(Watcher setLoop: 13 setCel: 0 stopUpd:)
				(woman1 setLoop: 2 setCel: 0 stopUpd:)
				(woman2 setLoop: 5 setCel: 0 stopUpd:)
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(7
				(proc0_16 (Format @global300 303 0)) ; "Little Tommy Tucker sings for his supper."
				(body init: setScript: bodyMotion)
				(global110 setScript: headMotion)
				(note1 init: setScript: noteMotion)
				(global109 hide:)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(proc0_16 (Format @global300 303 1)) ; "What shall he eat? White bread and butter."
				(= cycles 1)
			)
			(10
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				)
				(= cycles 1)
			)
			(11
				(proc0_16 (Format @global300 303 2)) ; "How shall he cut it without ever a knife?"
				(= cycles 1)
			)
			(12
				(if (< (rhymeSync prevSignal:) 60)
					(-- state)
				)
				(= cycles 1)
			)
			(13
				(proc0_16 (Format @global300 303 3)) ; "How will he be married without ever a wife?"
				(= cycles 1)
			)
			(14
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(global110 hide:)
					(body setScript: 0 loop: 10 cel: 0 setCycle: End self)
					(note1 setScript: 0 dispose:)
					(proc0_10)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(15
				(body setCycle: Beg)
				(woman1
					setCycle: Walk
					setLoop: 0
					setMotion: MoveTo 275 125 self
				)
				(woman2
					setCycle: Walk
					setLoop: 3
					setMotion: MoveTo 265 138 self
				)
			)
			(16
				(Watcher
					setCycle: Walk
					setLoop: 11
					setMotion: MoveTo 260 135 self
				)
			)
			(17
				(body dispose:)
				(global110 show: setCycle: 0 cel: 0 setScript: 0)
				(global109 cel: 0 loop: 8 show:)
			)
			(18
				(Watcher dispose:)
				(woman1 dispose:)
				(woman2 dispose:)
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 1 loop: -1 play:)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance headMotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(-- state)
				(global110 setLoop: (Random 1 4) cel: 0 setCycle: End self)
			)
		)
	)
)

(instance noteMotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(note1
					setPri: 14
					setCel: (Random 2 6)
					posn: (Random 130 160) (Random 70 80)
					show:
				)
				(= cycles (Random 7 10))
			)
			(1
				(= state -1)
				(note1 hide:)
				(= cycles (Random 4 7))
			)
		)
	)
)

(instance bodyMotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= state (* (Random 0 3) 2))
				(= cycles 1)
			)
			(1
				(body loop: 5 setCycle: End self)
			)
			(2
				(body setCycle: Beg self)
				(= state -1)
			)
			(3
				(body loop: 6 setCycle: End self)
			)
			(4
				(body setCycle: Beg self)
				(= state -1)
			)
			(5
				(body loop: 7 setCycle: End)
				(= seconds 5)
			)
			(6
				(body setCycle: Beg self)
				(= state -1)
			)
			(7
				(body loop: 8 setCycle: End)
				(= seconds 3)
			)
			(8
				(body setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance woman1 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 87
			posn: 275 125
			setLoop: 1
			setCycle: Walk
			setMotion: MoveTo 176 126 rhymeScript
		)
	)
)

(instance Watcher of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 85
			posn: 270 135
			setLoop: 12
			setCycle: Walk
			setMotion: MoveTo 158 135 rhymeScript
		)
	)
)

(instance woman2 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 87
			posn: 265 135
			setLoop: 4
			setCycle: Walk
			setMotion: MoveTo 130 140 rhymeScript
		)
	)
)

(instance body of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 85
			posn: 143 120 9
			setLoop: 5
			setCel: 0
			cycleSpeed: 6
			stopUpd:
		)
	)
)

(instance note1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 85 posn: 143 122 setLoop: 0 setCel: 2)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

