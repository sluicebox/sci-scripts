;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 312)
(include sci.sh)
(use Main)
(use PAvoider)
(use Sync)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	[local0 7] = [148 111 155 106 152 104 -32768]
	local7
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(DoAudio audWPLAY 7)
				(proc0_9)
				(gLongSong stop:)
				(rhymeSync init: 7)
				(= cycles 3)
			)
			(1
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(proc0_16 (Format @global300 312 0)) ; "Peter, Peter, pumpkin eater,"
					(self setScript: getWife)
				)
				(= cycles 1)
			)
			(2
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 312 1)) ; "Had a wife and couldn't keep her;"
				)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 312 2)) ; "He put her in a pumpkin shell,"
				)
				(= cycles 1)
			)
			(4
				(if (>= (rhymeSync prevSignal:) 40)
					(proc0_16 (Format @global300 312 3)) ; "And there he kept her very well."
				else
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(if script
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					((global129 head:) dispose:)
					(global129 dispose:)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(7
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(HandsOn)
				)
				(self dispose:)
				(DisposeScript 983)
				(= local7 1)
			)
		)
		(if local7
			(DisposeScript 312)
		)
	)
)

(instance getWife of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setAvoider: PAvoider setMotion: MoveTo 168 150 self)
			)
			(1
				(proc0_7 gEgo global109)
				(gEgo setAvoider: 0)
				((global109 head:) dispose:)
				(global109
					setLoop: 5
					setCycle: Walk
					setMotion: MoveTo 157 124 self
				)
				(global129
					moveSpeed: 6
					ignoreActors: 1
					setMotion: MoveTo 145 124 self
				)
			)
			(2)
			(3
				((global129 head:) hide:)
				(global129 setAvoider: 0 hide:)
				(global109 setLoop: 6 setCel: 0 setCycle: End self)
			)
			(4
				(= register (kiss new:))
				(kiss init:)
				(= ticks 18)
			)
			(5
				(register init:)
				(= seconds 4)
			)
			(6
				(kiss dispose:)
				(register dispose:)
				(global109 setCycle: Beg self)
			)
			(7
				(global110 setCycle: End self)
				(global129 show: illegalBits: 0 setMotion: goIn self)
				(global109
					setLoop: 5
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 107 114 self
				)
				((global129 head:) show:)
			)
			(8
				(global110 setPri: 2)
			)
			(9
				(global110 setPri: -1 setCycle: Beg)
				(global129 setMotion: MoveTo 143 103 self)
			)
			(10
				(global129 hide:)
				((global129 head:) hide:)
				(global111 init:)
			)
			(11
				(global110 stopUpd:)
				(global109 setLoop: 7 setCel: 0 setCycle: End)
				(= ticks 60)
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance kiss of Prop
	(properties
		view 77
		loop 8
		priority 15
		cycleSpeed 8
	)

	(method (init)
		(super init:)
		(self cue:)
	)

	(method (cue)
		(= cel 5)
		(self
			setPri: 15
			posn: (+ 140 (Random 1 30)) (+ 60 (Random 1 20))
			setCycle: Beg self
		)
	)
)

(instance goIn of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

