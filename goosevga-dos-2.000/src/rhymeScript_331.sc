;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use Main)
(use Sync)
(use PolyPath)
(use Polygon)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	local0
	local1 = 97
	local2
	local3
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DoAudio audWPLAY 1)
				(HandsOff)
				(gCurRoom
					addObstacle:
						(= local3
							((Polygon new:)
								type: PBarredAccess
								init: 0 7 258 7 258 69 188 65 89 46 0 41
								yourself:
							)
						)
				)
				(gTheHead hide:)
				(global109 view: 84 setLoop: 0 setCycle: CT 1 1 ignoreActors: 1)
				(gEgo setMotion: PolyPath 139 93 self)
			)
			(1
				(gLongSong stop:)
				(proc0_9)
				(Load rsVIEW 84)
				(Load rsSCRIPT 969)
				(rhymeSync init: 1)
				(global109 setScript: watering)
				(gEgo setMotion: MoveTo 193 93 self)
				((gCurRoom obstacles:) delete: local3)
				(local3 dispose:)
			)
			(2
				(proc0_7 gEgo global109)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(proc0_16 (Format @global300 331 0)) ; "Mary, Mary, quite contrary,"
				)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 331 1)) ; "How does your garden grow?"
				)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(global110 startUpd: setCycle: Fwd)
					(global111 startUpd: setCycle: Fwd)
					(global112 startUpd: setCycle: Fwd)
					(global113 startUpd: setCycle: Fwd)
					(proc0_16 (Format @global300 331 2)) ; "With silver bells"
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 331 3)) ; "And cockleshells,"
					(global110 setCycle: 0 stopUpd:)
					(global111 setCycle: 0 stopUpd:)
					(global112 setCycle: 0 stopUpd:)
					(global113 setCycle: 0 stopUpd:)
					(global133 startUpd: setCel: 4 setCycle: Fwd)
					(gShell2 startUpd: setCel: 3 setCycle: Fwd)
					(gShell3 startUpd: setCel: 2 setCycle: Fwd)
					(gShell4 startUpd: setCel: 1 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(proc0_16 (Format @global300 331 4)) ; "And pretty maids in a row."
					(global133 setCycle: 0 setCel: 0 stopUpd:)
					(gShell2 setCycle: 0 setCel: 0 stopUpd:)
					(gShell3 setCycle: 0 setCel: 0 stopUpd:)
					(gShell4 setCycle: 0 setCel: 0 stopUpd:)
					(global120 startUpd: setCycle: Fwd)
					(gMaid2 startUpd: setCycle: Fwd)
					(global122 startUpd: setCycle: Fwd)
				)
				(= cycles 1)
			)
			(8
				(if (rhymeSync playing:)
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(global120 setCycle: Beg)
				(gMaid2 setCycle: Beg self)
				(global122 setCycle: Beg self)
			)
			(10)
			(11
				(global120 setCycle: 0 stopUpd:)
				(gMaid2 setCycle: 0 stopUpd:)
				(global122 setCycle: 0 stopUpd:)
				(proc0_16 0)
				(= cycles 1)
			)
			(12
				(if local0
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(13
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(HandsOn)
				)
				(self dispose:)
				(DisposeScript 969)
				(= local2 1)
			)
		)
		(if local2
			(DisposeScript 331)
		)
	)
)

(instance watering of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global109 setCel: 3)
				((= register (View new:))
					view: 84
					setLoop: 0
					setCel: 2
					posn: 136 99
					init:
				)
				(= ticks 10)
			)
			(1
				(global109
					setLoop: 1
					setCel: 0
					cycleSpeed: 7
					setCycle: Walk
					setMotion: MoveTo 58 97 self
				)
			)
			(2
				(self setScript: (waterIt new:) self 72)
			)
			(3
				(self setScript: (waterIt new:) self 87)
			)
			(4
				(self setScript: (waterIt new:) self 102)
			)
			(5
				(self setScript: (waterIt new:) self 118)
			)
			(6
				(= local1 92)
				(self setScript: waterIt self 118)
			)
			(7
				(global109 setCel: 0 stopUpd:)
				(= seconds 3)
			)
			(8
				(global109
					cycleSpeed: 12
					setLoop: 0
					setCel: 1
					setCycle: Beg self
				)
				(register dispose:)
			)
			(9
				(global109
					view: 74
					setLoop: 3
					setCel: 255
					ignoreActors: 0
					stopUpd:
				)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance waterIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global109
					setLoop: 3
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(global109 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(global109 setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(3
				(global109
					setLoop: 1
					cycleSpeed: 10
					setCycle: Rev
					setMotion: MoveTo register local1 self
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

