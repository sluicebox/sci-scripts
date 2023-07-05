;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 323)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use ROsc)
(use PolyPath)
(use Motion)
(use System)

(public
	rhymeScript 0
)

(local
	local0
	local1
	[local2 6] = [60 120 90 60 120 105]
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local0 0)
				(proc0_9)
				(Load rsSCRIPT 64970)
				(= local1 6)
				(= seconds 2)
			)
			(1
				(= global164 1)
				(= cycles 1)
			)
			(2
				(gLongSong stop:)
				(gMessager say: 1 0 0 1 0 400) ; "LITTLE BO PEEP"
				(rhymeSync init: 400 1 0 0 1)
				(global110 setCycle: ROsc 1 0)
				(= ticks 30)
			)
			(3
				(if local1
					(-- local1)
					(-- state)
					(if (== local1 5)
						(global110 setCycle: ROsc 3 0)
					else
						(global110 setCycle: ROsc 1 0)
					)
					(= ticks [local2 local1])
					(if (== local1 3)
						(= global164 3)
					)
				else
					(global110 cel: 0 setCycle: 0)
					(= cycles 1)
				)
			)
			(4
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
					(= cycles 1)
				else
					(if gLanguage
						(proc0_16
							(temp0
								format: {Little Bo-Peep ha perdido sus ovejas,}
							)
						)
					else
						(proc0_16
							(temp0 format: {Little Bo Peep has lost her sheep})
						)
					)
					(= global164 5)
					(= seconds 1)
				)
			)
			(5
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
					(= cycles 1)
				else
					(if gLanguage
						(proc0_16
							(temp0 format: {Y no sabe donde encontrarlas;})
						)
					else
						(proc0_16
							(temp0 format: {And can't tell where to find them;})
						)
					)
					(= global164 7)
					(global109
						cel: (if (== (global109 cel:) 4) 3 else 1)
						setCycle: 0
					)
					(= seconds 2)
				)
			)
			(6
				(if (== (global133 loop:) 1)
					(global109 cel: 1)
				else
					(global109 cel: 3)
				)
				(= ticks 165)
			)
			(7
				(global110 setCycle: ROsc 1 0)
				(global109 cel: (if (== (global109 cel:) 1) 0 else 4))
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
					(= cycles 1)
				else
					(if gLanguage
						(proc0_16
							(temp0 format: {D$jalos solos y vendr#n a casa,})
						)
					else
						(proc0_16
							(temp0
								format:
									{Leave them alone and they'll come home,}
							)
						)
					)
					(++ global164)
					(= ticks 195)
				)
			)
			(9
				(global110 setCycle: ROsc 1 0)
				(= cycles 1)
			)
			(10
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(if gLanguage
						(proc0_16
							(temp0
								format: {Meniando sus colas detr#s de ellos.}
							)
						)
					else
						(proc0_16
							(temp0 format: {Wagging their tails behind them.})
						)
					)
					(= ticks 195)
				)
			)
			(11
				(global110 setCycle: ROsc 3 0)
				(= cycles 1)
			)
			(12
				(if (rhymeSync playing:)
					(-- state)
				else
					(global110 cel: 0 setCycle: 0)
					(proc0_16 0)
					(++ global164)
				)
				(= cycles 1)
			)
			(13
				(global133
					x: (proc0_13 5 (global133 x:) 250)
					y: (proc0_13 65 (global133 y:) 150)
					setLoop: 8
					cel: 0
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
				)
				(if (> (global133 x:) 174)
					(global133 setMotion: PolyPath 174 (global133 y:) self)
				else
					(= cycles 1)
				)
			)
			(14
				(global133 setMotion: PolyPath 164 110 self)
			)
			(15
				(global133 cel: 2 setPri: 112 1 setMotion: MoveTo 137 108 self)
			)
			(16
				(global133 cel: 0 setCycle: End self)
			)
			(17
				(global133 cel: 0 loop: 7 setCycle: 0)
				(global110 hide:)
				(global109 setLoop: 6 setCycle: Fwd)
				(= cycles 9)
			)
			(18
				(global109 setCycle: End self)
			)
			(19
				(global109 setCycle: Beg self)
			)
			(20
				(global109 setLoop: 5 cel: 255 setCycle: Beg self)
				(++ global164)
			)
			(21
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(proc0_10)
				(= local0 1)
				(= cycles 1)
			)
		)
		(temp0 dispose:)
		(if local0
			(if (>= gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			)
			(self dispose:)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance finish of Script ; UNUSED
	(properties)
)

