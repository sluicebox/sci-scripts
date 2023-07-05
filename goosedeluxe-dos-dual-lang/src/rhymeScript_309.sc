;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 309)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	local0
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local0 0)
				(proc0_9)
				(Load rsVIEW 68)
				(= cycles 1)
			)
			(1
				(gLongSong stop:)
				(= ticks 30)
			)
			(2
				(gMessager say: 1 0 0 16 0 400) ; "LITTLE MISS MUFFETT"
				(rhymeSync init: 400 1 0 0 16)
				(global129 moveSpeed: 5 setMotion: PolyPath 151 114 self)
			)
			(3
				(global129 setMotion: MoveTo 151 107 self)
			)
			(4
				(global129
					view: 68
					cel: 0
					setLoop: 0 1
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(5
				(cond
					((< (rhymeSync prevSignal:) 10)
						(-- state)
					)
					(gLanguage
						(proc0_16
							(temp0
								format:
									{La peque+a Miss Muffet, Se sent& en un tufo,}
							)
						)
					)
					(else
						(proc0_16
							(temp0
								format: {Little Miss Muffet sat on a tuffet,}
							)
						)
					)
				)
				(= cycles 1)
			)
			(6
				(cond
					((< (rhymeSync prevSignal:) 20)
						(-- state)
					)
					(gLanguage
						(proc0_16
							(temp0 format: {Comiendo sus cuajadas y suero;})
						)
					)
					(else
						(proc0_16 (temp0 format: {Eating her curds and whey;}))
					)
				)
				(= cycles 1)
			)
			(7
				(global129
					view: 68
					setLoop: 1 1
					cel: 0
					cycleSpeed: 6
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(if gLanguage
						(proc0_16 (temp0 format: {Vino una ara+a,}))
					else
						(proc0_16 (temp0 format: {Along came a spider,}))
					)
					(spider init: setMotion: MoveTo 131 85)
				)
				(= cycles 1)
			)
			(9
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(if gLanguage
						(proc0_16
							(temp0 format: {Quien se sent& al lado de ella,})
						)
					else
						(proc0_16 (temp0 format: {And sat down beside her,}))
					)
					(global129 setLoop: 2 1 cel: 0 setCycle: End dumpCurds)
				)
				(= cycles 1)
			)
			(10
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
					(= cycles 1)
				else
					(if gLanguage
						(proc0_16 (temp0 format: {Y ahuyent& a Miss Muffet.}))
					else
						(proc0_16
							(temp0 format: {And frightened Miss Muffet away.})
						)
					)
					(global129 cel: 0 setLoop: 5 1 setCycle: End self)
				)
			)
			(11
				(global129
					setLoop: 6 1
					setCycle: Walk
					xStep: 2
					moveSpeed: 3
					cycleSpeed: 2
					x: 163
					setMotion: MoveTo 207 62 self
				)
			)
			(12
				(global129 setPri: 0 setMotion: MoveTo 214 95 self)
			)
			(13
				(global129 hide:)
				(spider setMotion: MoveTo 131 44 self)
			)
			(14
				(if (== (rhymeSync playing:) 0)
					(spider dispose:)
					(web dispose:)
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
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				)
				(self dispose:)
				(= local0 1)
			)
		)
		(= global166 0)
		(temp0 dispose:)
		(if local0
			(DisposeScript 309)
		)
	)
)

(instance spider of Actor
	(properties
		x 131
		y 44
		view 68
		loop 4
		cycleSpeed 4
	)

	(method (init)
		(super init:)
		(self setPri: 96 setLoop: 4 1 setCycle: Fwd)
		(web init:)
	)
)

(instance web of Prop
	(properties
		view 68
		loop 8
	)

	(method (doit)
		(self setPri: (- (spider priority:) 1))
		(= x (spider x:))
		(= y (spider y:))
		(= z (CelHigh (spider view:) (spider loop:) (spider cel:)))
		(super doit:)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance dumpCurds of Script
	(properties)

	(method (cue)
		(global109 init: setCycle: End)
		(global129 setLoop: 3 1 setCycle: Fwd)
	)
)

