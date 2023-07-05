;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use ROsc)
(use PolyPath)
(use Path)
(use Motion)
(use System)

(public
	rhymeScript 0
)

(local
	local0
	[local1 7] = [198 112 183 103 181 98 32768]
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

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local8 0)
				(= local0 63)
				(Load rsVIEW 78)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 225 132 self)
			)
			(2
				(gLongSong stop:)
				(proc0_7 gEgo global109)
				(gMessager say: 1 0 0 17 0 400) ; "WOMAN IN A SHOE"
				(global129 dispose:)
				(proc0_9)
				(rhymeSync init: 400 1 0 0 17)
				(= ticks 60)
			)
			(3
				(global133 setCycle: ROsc 200 0)
				(= ticks 420)
			)
			(4
				(global109 setScript: feed)
				(global133 dispose:)
				(gEgo setMotion: MoveTo 140 147)
				(&= local0 $001f)
				(= cycles 1)
			)
			(5
				(cond
					((< (rhymeSync prevSignal:) 10)
						(-- state)
					)
					(gLanguage
						(proc0_16 (temp0 format: {Hab(a una vieja,}))
					)
					(else
						(proc0_16 (temp0 format: {There was an old woman}))
					)
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(if gLanguage
						(proc0_16 (temp0 format: {Que viv(a en un zapato}))
					else
						(proc0_16 (temp0 format: {Who lived in a shoe.}))
					)
					(proc0_7 gEgo global109)
					(gEgo setMotion: 0)
				)
				(= cycles 1)
			)
			(7
				(cond
					((< (rhymeSync prevSignal:) 30)
						(-- state)
					)
					(gLanguage
						(proc0_16 (temp0 format: {Ten(a tantos ni+os,}))
					)
					(else
						(proc0_16 (temp0 format: {She had so many children,}))
					)
				)
				(= cycles 1)
			)
			(8
				(cond
					((< (rhymeSync prevSignal:) 40)
						(-- state)
					)
					(gLanguage
						(proc0_16 (temp0 format: {Que no sab(a que hacer.}))
					)
					(else
						(proc0_16 (temp0 format: {She didn't know what to do.}))
					)
				)
				(= cycles 1)
			)
			(9
				(cond
					((< (rhymeSync prevSignal:) 50)
						(-- state)
					)
					(gLanguage
						(proc0_16 (temp0 format: {Les di& un poco de consom$,}))
					)
					(else
						(proc0_16 (temp0 format: {She gave them some broth,}))
					)
				)
				(= cycles 1)
			)
			(10
				(cond
					((< (rhymeSync prevSignal:) 60)
						(-- state)
					)
					(gLanguage
						(proc0_16 (temp0 format: {Sin pan,}))
					)
					(else
						(proc0_16 (temp0 format: {Without any bread,}))
					)
				)
				(= cycles 1)
			)
			(11
				(cond
					((< (rhymeSync prevSignal:) 70)
						(-- state)
					)
					(gLanguage
						(proc0_16 (temp0 format: {Y los bes& muy dulcemente,}))
					)
					(else
						(proc0_16
							(temp0 format: {And kissed them all sweetly,})
						)
					)
				)
				(= cycles 1)
			)
			(12
				(cond
					((< (rhymeSync prevSignal:) 80)
						(-- state)
					)
					(gLanguage
						(proc0_16 (temp0 format: {Y los puso a dormir.}))
					)
					(else
						(proc0_16 (temp0 format: {And put them to bed.}))
					)
				)
				(= cycles 1)
			)
			(13
				(if local0
					(-- state)
				)
				(= cycles 1)
			)
			(14
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(15
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(= local8 1)
				(DisposeScript 64983)
			)
		)
		(temp0 dispose:)
		(if local8
			(if (>= gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			)
			(self dispose:)
		)
	)
)

(instance feed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global109 view: 78 setLoop: 8 1 cel: 0 setPri: 9 setCycle: 0)
				(global110 setScript: kid0Script)
				(global111 setScript: kid1Script)
				(global112 setScript: kid2Script)
				(global113 setScript: kid3Script)
			)
			(1
				(global109 setLoop: 10 1 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(global109 setCycle: Beg self)
			)
			(3
				(global109 setLoop: 11 1 cel: 0 setCycle: CT 4 1 self)
			)
			(4
				(global109 setCycle: Beg self)
			)
			(5
				(kid0Script cue:)
				(kid1Script cue:)
				(kid2Script cue:)
				(kid3Script cue:)
			)
			(6
				(global109 setLoop: 10 1 cel: 0 setCycle: CT 3 1 self)
			)
			(7
				(global109 setCycle: Beg self)
			)
			(8
				(global109 setLoop: 11 1 cel: 0 setCycle: End self)
			)
			(9
				(global109 setCycle: Beg self)
			)
			(10
				(kid0Script cue:)
				(kid1Script cue:)
				(kid3Script cue:)
			)
			(11
				(global109 setLoop: 10 1 cel: 0 setCycle: End self)
			)
			(12
				(global109 setCycle: Beg self)
			)
			(13
				(global109 setLoop: 11 1 cel: 0 setCycle: End self)
			)
			(14
				(global109 setCycle: Beg self)
			)
			(15
				(kid0Script cue:)
				(kid3Script cue:)
			)
			(16
				(global109 setLoop: 12 1 cel: 0 setCycle: CT 2 1 self)
			)
			(17
				(global109 setCycle: End self)
				(kid0Script cue:)
			)
			(18
				(global109 setLoop: 13 1 cel: 0 setCycle: End self)
			)
			(19
				(global109
					setLoop: 14 1
					cycleSpeed: 3
					setCycle: Walk
					setPri: -1
					setMotion: goInside self self
				)
			)
			(20
				(global109 setLoop: 15)
			)
			(21
				(global122 setCycle: Beg self)
			)
			(22
				(&= local0 $002f)
				(global109 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance kid0Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(global110
					view: 78
					setLoop: 4 1
					cycleSpeed: 3
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 92 116 self
				)
			)
			(2
				(global110 setLoop: 0 1 setMotion: MoveTo 161 129)
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
				(&= local0 $003e)
				(self dispose:)
				(global110 dispose:)
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
					setLoop: 1 1
					cycleSpeed: 3
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 205 128
				)
			)
			(2
				(global111 setMotion: MoveTo 222 122 feed)
			)
			(3
				(global111 setLoop: 5 1 setMotion: (goInside new:) self)
			)
			(4
				(&= local0 $003d)
				(self dispose:)
				(global111 dispose:)
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
					view: 78
					cycleSpeed: 3
					ignoreActors:
					y: 116
					setLoop: 2 1
					setCycle: Walk
					setMotion: MoveTo 219 126 feed
				)
			)
			(1
				(global112 setLoop: 6 1 setMotion: (goInside new:) self self)
			)
			(2
				(global122 setCycle: End)
			)
			(3)
			(4
				(&= local0 $003b)
				(self dispose:)
				(global112 dispose:)
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
					setLoop: 3 1
					cycleSpeed: 3
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
				(global113 setLoop: 7 1 setMotion: (goInside new:) self)
			)
			(5
				(&= local0 $0037)
				(self dispose:)
				(global113 dispose:)
			)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

