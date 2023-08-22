;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 337)
(include sci.sh)
(use Main)
(use Sync)
(use Wander)
(use Avoid)
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
				(Load rsVIEW 81)
				(Load rsSCRIPT 979)
				(gEgo setAvoider: (Avoid new:) setMotion: MoveTo 133 90 self)
			)
			(1
				(global129 dispose:)
				(proc0_9)
				((global109 head:) dispose:)
				(global109 loop: 2 cel: 0 cycleSpeed: 3 setCycle: End self)
				(gEgo setAvoider: 0 setMotion: MoveTo 133 118)
			)
			(2
				(DisposeScript 985)
				(proc0_7 gEgo global109)
				(= cycles 2)
			)
			(3
				(gEgo signal: (& (| (gEgo signal:) $0100) $fffd) stopUpd:)
				((gEgo head:)
					signal: (& (| ((gEgo head:) signal:) $0100) $fffd)
					stopUpd:
				)
				(gLongSong stop:)
				(rhymeSync init: 2)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(proc0_16 (Format @global300 337 0) -1 -1 0) ; "Old King Cole was a merry old soul,"
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				)
				(= cycles 1)
			)
			(7
				(proc0_16 (Format @global300 337 1) -1 -1 0) ; "And a merry old soul was he;"
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(proc0_16 (Format @global300 337 2) -1 -1 0) ; "He called for his pipe,"
				(= cycles 1)
			)
			(10
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				)
				(= cycles 1)
			)
			(11
				(proc0_16 (Format @global300 337 3) -1 -1 0) ; "And he called for his bowl,"
				(global109 loop: 3 cel: 0 cycleSpeed: 3 setCycle: End)
				(= cycles 1)
			)
			(12
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				)
				(= cycles 1)
			)
			(13
				(proc0_16 (Format @global300 337 4) -1 -1 0) ; "And he called for his fiddlers three."
				(fiddler1 init: setCycle: End self)
				(global109 view: 81 setLoop: 3 setCel: 4)
				(fiddler2 init: setCycle: End)
				(fiddler3 init: setCycle: End)
			)
			(14
				(fiddler1 setLoop: 4 cycleSpeed: 2 setCycle: Fwd)
				(fiddler2 setLoop: 5 cycleSpeed: 2 setCycle: Fwd)
				(fiddler3 setLoop: 6 cycleSpeed: 2 setCycle: Fwd)
				(= cycles 1)
			)
			(15
				(proc0_16 0)
				(global109
					view: 80
					loop: 4
					cel: 0
					cycleSpeed: 3
					startUpd:
					setCycle: End self
				)
			)
			(16
				(global109 loop: 5 cel: 0 setCycle: End self)
			)
			(17
				(global109 loop: 6 cel: 0 setCycle: End self)
			)
			(18
				(global109 loop: 7 cel: 0 setCycle: End self)
			)
			(19
				(global109 loop: 8 cel: 0 setCycle: End self)
			)
			(20
				(Bubble1
					setPri: 15
					setLoop: 9
					setMotion: Wander 100
					ignoreActors: 1
					init:
				)
				(Bubble2
					setPri: 15
					setLoop: 9
					setMotion: Wander 100
					ignoreActors: 1
					init:
				)
				(Bubble3
					setPri: 15
					setLoop: 9
					setMotion: Wander 100
					ignoreActors: 1
					init:
				)
				(Bubble4
					cel: 3
					setLoop: 9
					setMotion: Wander 50
					setPri: 15
					ignoreActors: 1
					init:
				)
				(if (< (+= local0 4) 3)
					(-= state 2)
					(= cycles 8)
				else
					(global109 loop: 6 cel: 2 setCycle: Beg)
					(= cycles 3)
				)
				(++ local0)
			)
			(21
				(Bubble4 setMotion: MoveTo (gEgo x:) (gEgo y:) self)
			)
			(22
				(gEgo hide:)
				((gEgo head:) hide:)
				(Bubble4 setLoop: 10 setCel: global114 setMotion: Wander 50)
				(= seconds 5)
			)
			(23
				(if (not (rhymeSync playing:))
					(Bubble4 setMotion: MoveTo (gEgo x:) (gEgo y:) self)
					(fiddler1 setLoop: 0 cel: 8 setCycle: Beg self)
					(fiddler2 setLoop: 1 cel: 8 setCycle: Beg self)
					(fiddler3 setLoop: 2 cel: 8 setCycle: Beg self)
					(Bubble1 dispose:)
					(Bubble2 dispose:)
					(Bubble3 dispose:)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(24)
			(25)
			(26)
			(27
				(DisposeScript 979)
				(fiddler1 dispose:)
				(fiddler2 dispose:)
				(fiddler3 dispose:)
				(Bubble4 dispose:)
				(gEgo signal: (& (gEgo signal:) $feff))
				((gEgo head:) signal: (& ((gEgo head:) signal:) $feff))
				(gEgo show: setMotion: 0 setLoop: -1)
				((gEgo head:) show:)
				(if (or global172 (!= gScore (- gPossibleScore 1)))
					(HandsOn)
				else
					(gEgo setMotion: MoveTo 134 175)
				)
				(gLongSong number: 1 loop: -1 play:)
				(= cycles 2)
			)
			(28
				(self dispose:)
				(= local1 1)
			)
		)
		(if local1
			(DisposeScript 337)
		)
	)
)

(instance Bubble1 of Act
	(properties
		y 49
		x 114
		view 80
		loop 9
		signal 26624
		illegalBits 16386
	)
)

(instance Bubble2 of Act
	(properties
		y 49
		x 114
		view 80
		loop 9
		cel 1
		signal 26624
		illegalBits 16386
	)
)

(instance Bubble3 of Act
	(properties
		y 49
		x 114
		view 80
		loop 9
		cel 2
		signal 26624
		illegalBits 16386
	)
)

(instance Bubble4 of Act
	(properties
		y 49
		x 114
		view 80
		loop 9
		signal 26624
		illegalBits 16386
	)
)

(instance fiddler1 of Prop
	(properties
		y 102
		x 80
		view 81
		signal 26624
		cycleSpeed 3
	)
)

(instance fiddler2 of Prop
	(properties
		y 102
		x 130
		view 81
		loop 1
		signal 26624
		cycleSpeed 1
	)
)

(instance fiddler3 of Prop
	(properties
		y 102
		x 214
		view 81
		loop 2
		signal 26624
		cycleSpeed 1
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

