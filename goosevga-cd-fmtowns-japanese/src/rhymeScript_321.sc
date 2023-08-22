;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)
(use Sync)
(use Path)
(use Avoid)
(use Motion)
(use System)

(public
	rhymeScript 0
)

(local
	local0 = 63
	[local1 7] = [203 100 196 86 182 86 -32768]
	local8
)

(instance goInside of Path
	(properties)

	(method (at param1)
		(return [local1 param1])
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_9)
				(Load rsVIEW 78)
				(Load rsSCRIPT 985)
				(Load rsSCRIPT 983)
				(Load rsCURSOR 69)
				(gLongSong stop:)
				(rhymeSync init: 16)
				(gEgo setScript: egoGive)
				(= cycles 1)
			)
			(1
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(proc0_16 (Format @global300 321 0)) ; "There was an old woman"
				)
				(= cycles 1)
			)
			(2
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 321 1)) ; "Who lived in a shoe."
				)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 321 2)) ; "had so many children"
				)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 321 3)) ; "didn't know what to do."
				)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(proc0_16 (Format @global300 321 4)) ; "She gave them some broth,"
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 60)
					(-- state)
				else
					(proc0_16 (Format @global300 321 5)) ; "Without any bread,"
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 70)
					(-- state)
				else
					(proc0_16 (Format @global300 321 6)) ; "Then kissed them all soundly,"
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 80)
					(-- state)
				else
					(proc0_16 (Format @global300 321 7)) ; "And put them to bed."
				)
				(= cycles 1)
			)
			(9
				(if local0
					(-- state)
				)
				(= cycles 1)
			)
			(10
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
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
				(DisposeScript 983)
				(= local8 1)
			)
		)
		(if local8
			(DisposeScript 321)
		)
	)
)

(instance egoGive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					observeControl: 4
					setAvoider: (Avoid new:)
					setMotion: MoveTo 225 132 self
				)
			)
			(1
				(global109 setScript: feed)
				(gEgo setAvoider: 0 setMotion: MoveTo 200 145 self)
				(DisposeScript 985)
			)
			(2
				(gEgo setMotion: MoveTo 140 150 self)
			)
			(3
				(proc0_7 gEgo global109)
				(gEgo ignoreControl: 4)
				(self dispose:)
				(&= local0 $001f)
			)
		)
	)
)

(instance feed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global109 view: 78 setLoop: 8 cel: 0 setPri: 9 setCycle: End)
				(global110 setScript: kid0Script)
				(global111 setScript: kid1Script)
				(global112 setScript: kid2Script)
				(global113 setScript: kid3Script)
				(= seconds 3)
			)
			(1
				(global109 setCycle: Beg)
			)
			(2
				(global109 setLoop: 9 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(global109 setCycle: Beg self)
			)
			(4
				(global109 setLoop: 10 cel: 0 setCycle: CT 4 1 self)
			)
			(5
				(global109 setCycle: Beg self)
			)
			(6
				(kid0Script cue:)
				(kid1Script cue:)
				(kid2Script cue:)
				(kid3Script cue:)
			)
			(7
				(global109 setLoop: 9 cel: 0 setCycle: CT 3 1 self)
			)
			(8
				(global109 setCycle: Beg self)
			)
			(9
				(global109 setLoop: 10 cel: 0 setCycle: End self)
			)
			(10
				(global109 setCycle: Beg self)
			)
			(11
				(kid0Script cue:)
				(kid1Script cue:)
				(kid3Script cue:)
			)
			(12
				(global109 setLoop: 9 cel: 0 setCycle: End self)
			)
			(13
				(global109 setCycle: Beg self)
			)
			(14
				(global109 setLoop: 10 cel: 0 setCycle: End self)
			)
			(15
				(global109 setCycle: Beg self)
			)
			(16
				(kid0Script cue:)
				(kid3Script cue:)
			)
			(17
				(global109 setLoop: 10 cel: 0 setCycle: End self)
			)
			(18
				(global109 setLoop: 11 cel: 0 setCycle: CT 2 1 self)
			)
			(19
				(global109 setCycle: End self)
				(kid0Script cue:)
			)
			(20
				(global109 setLoop: 12 cel: 0 setCycle: End self)
			)
			(21
				(global109
					setLoop: 13
					cycleSpeed: 0
					setCycle: Walk
					setPri: -1
					setMotion: goInside self self
				)
			)
			(22
				(global109 setLoop: 14)
			)
			(23)
			(24
				(global122 setCycle: Beg self)
			)
			(25
				(self dispose:)
				(global109 dispose:)
				(&= local0 $002f)
			)
		)
	)
)

(instance kid0Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global110 signal: (& (global110 signal:) $feff))
				(= cycles 10)
			)
			(1
				(global110
					startUpd:
					view: 78
					setLoop: 4
					cycleSpeed: 0
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 92 116 self
				)
			)
			(2
				(global110 setLoop: 0 setMotion: MoveTo 161 129)
			)
			(3
				(global110 setMotion: MoveTo 181 128)
			)
			(4
				(global110 setMotion: MoveTo 205 128)
			)
			(5
				(global110 setMotion: MoveTo 219 124 feed)
			)
			(6
				(self dispose:)
				(global110 dispose:)
				(&= local0 $003e)
			)
		)
	)
)

(instance kid1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 8)
			)
			(1
				(global111
					view: 78
					setLoop: 1
					cycleSpeed: 0
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 205 128
				)
			)
			(2
				(global111 setMotion: MoveTo 222 124 feed)
			)
			(3
				(global111 setLoop: 5 setMotion: (goInside new:) self)
			)
			(4
				(self dispose:)
				(global111 dispose:)
				(&= local0 $003d)
			)
		)
	)
)

(instance kid2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global112
					signal: (& (global112 signal:) $feff)
					startUpd:
					view: 78
					cycleSpeed: 0
					ignoreActors:
					y: 116
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 220 127 feed
				)
			)
			(1
				(global112 setLoop: 6 setMotion: (goInside new:) self self)
			)
			(2
				(global122 setCycle: End)
			)
			(3)
			(4
				(self dispose:)
				(global112 dispose:)
				(&= local0 $003b)
			)
		)
	)
)

(instance kid3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(global113
					view: 78
					setLoop: 3
					cycleSpeed: 0
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 181 128
				)
			)
			(2
				(global113 setMotion: MoveTo 205 128)
			)
			(3
				(global113 setMotion: MoveTo 217 123 feed)
			)
			(4
				(global113 setLoop: 7 setMotion: goInside self)
			)
			(5
				(self dispose:)
				(global113 dispose:)
				(&= local0 $0037)
			)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

