;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use Main)
(use Sync)
(use Rev)
(use Avoid)
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
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo observeControl: 8192 setAvoider: (Avoid new:))
				(if (& (gEgo onControl:) $4000)
					(= cycles 2)
				else
					(gEgo setMotion: MoveTo 178 93 self)
				)
				(gTheHead hide:)
				(global109 view: 84 setLoop: 0 setCycle: CT 1 1 ignoreActors: 1)
			)
			(1
				(gEgo setMotion: MoveTo 139 93 self)
			)
			(2
				(gLongSong stop:)
				(proc0_9)
				(Load rsVIEW 84)
				(Load rsSCRIPT 978)
				(Load rsCURSOR 69)
				(rhymeSync init: 1)
				(global109 setScript: watering)
				(gEgo setAvoider: 0 setMotion: MoveTo 193 93 self)
			)
			(3
				(proc0_7 gEgo global109)
				(gEgo ignoreControl: 8192)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(proc0_16 (Format @global300 331 0)) ; "Mary, Mary, quite contrary,"
				)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 331 1)) ; "How does your garden grow?"
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(global110 signal: 6 setCycle: Fwd)
					(global111 signal: 6 setCycle: Fwd)
					(global112 signal: 6 setCycle: Fwd)
					(global113 signal: 6 setCycle: Fwd)
					(proc0_16 (Format @global300 331 2)) ; "With silver bells"
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 331 3)) ; "And cockleshells,"
					(global110 setCycle: 0 signal: 257)
					(global111 setCycle: 0 signal: 257)
					(global112 setCycle: 0 signal: 257)
					(global113 setCycle: 0 signal: 257)
					(global133 signal: 6 setCel: 4 setCycle: Fwd)
					(global134 signal: 6 setCel: 3 setCycle: Fwd)
					(gShell3 signal: 6 setCel: 2 setCycle: Fwd)
					(gShell4 signal: 6 setCel: 1 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(proc0_16 (Format @global300 331 4)) ; "And pretty maids in a row."
					(global133 setCycle: 0 setCel: 0 signal: 257)
					(global134 setCycle: 0 setCel: 0 signal: 257)
					(gShell3 setCycle: 0 setCel: 0 signal: 257)
					(gShell4 setCycle: 0 setCel: 0 signal: 257)
					(global120 signal: 6 setCycle: Fwd)
					(gMaid2 signal: 6 setCycle: Fwd)
					(global122 signal: 6 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(9
				(if (rhymeSync playing:)
					(-- state)
				)
				(= cycles 1)
			)
			(10
				(global120 setCycle: Beg)
				(gMaid2 setCycle: Beg self)
				(global122 setCycle: Beg self)
			)
			(11)
			(12
				(global120 setCycle: 0 signal: 257)
				(gMaid2 setCycle: 0 signal: 257)
				(global122 setCycle: 0 signal: 257)
				(proc0_16 0)
				(= cycles 1)
			)
			(13
				(if local0
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(14
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 1 loop: -1 play:)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(HandsOn)
				)
				(self dispose:)
				(DisposeScript 978)
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
				(= cycles 3)
			)
			(1
				(global109
					setLoop: 1
					setCel: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 58 97 self
				)
			)
			(2
				(self setScript: waterIt self 72)
			)
			(3
				(self setScript: waterIt self 87)
			)
			(4
				(self setScript: waterIt self 102)
			)
			(5
				(self setScript: waterIt self 118)
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
					cycleSpeed: 4
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
					cycleSpeed: 4
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
					cycleSpeed: 0
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

