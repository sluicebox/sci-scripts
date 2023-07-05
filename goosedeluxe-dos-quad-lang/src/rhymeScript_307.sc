;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 307)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use PolyPath)
(use Jump)
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
				(gEgo
					ignoreBlocks: 1
					ignoreActors: 1
					setMotion: PolyPath 131 123 self
				)
			)
			(1
				(proc0_9)
				(global109 setLoop: 14 1 cel: 1 cycleSpeed: 6 setCycle: End)
				((gGoals at: 5) egoReturned: 1)
				(gEgo posn: 131 123 setMotion: PolyPath 160 130 self)
			)
			(2
				(global113 hide:)
				(proc0_7 gEgo global109)
				(= cycles 1)
			)
			(3
				(gLongSong stop:)
				(= ticks 30)
			)
			(4
				(gLongSong stop:)
				(gMessager say: 1 0 0 9 0 400) ; "HEY DIDDLE DIDDLE"
				(rhymeSync init: 400 1 0 0 9)
				(global109 cycleSpeed: 6 setLoop: 4 1 setCycle: Fwd)
				(= cycles 1)
			)
			(5
				(cond
					((< (rhymeSync prevSignal:) 10)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {=Hey Diddle, Diddle!}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {C'est Gugusse avec son violon})
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {A, B, C, die Katze schreit jucheh!})
						)
					)
					(else
						(proc0_16 (temp0 format: {Hey, diddle diddle!}))
					)
				)
				(= cycles 1)
			)
			(6
				(cond
					((< (rhymeSync prevSignal:) 20)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {El gato y el viol^n,}))
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {qui fait danser les filles}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Sie spielt auf ihrer Fiedel,})
						)
					)
					(else
						(proc0_16 (temp0 format: {The cat and the fiddle,}))
					)
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0 format: {La vaca salt& sobre la luna.})
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0 format: {qui fait danser les filles})
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0 format: {ein lustig liebes Liedel,})
							)
						)
						(else
							(proc0_16
								(temp0 format: {The cow jumped over the moon;})
							)
						)
					)
					(self setScript: cowJump)
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0
									format:
										{El perrito se ri& al ver tal juego,}
								)
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0 format: {c'est Gugusse avec son violon})
							)
						)
						((== gLanguage 3)
							(proc0_16 (temp0 format: {Oh jemine, oh jemine, }))
						)
						(else
							(proc0_16
								(temp0
									format:
										{The little dog laughed to see such sport,}
								)
							)
						)
					)
					(global111
						setLoop: 10 1
						cycleSpeed: 9
						cel: 0
						setCycle: End self
					)
				)
			)
			(9
				(global111 setLoop: 11 1 cel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(10
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
					(= cycles 1)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0
									format: {Y el plato se fug& con la cuchara.}
								)
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0
									format:
										{qui fait danser les filles et les gar@ons.}
								)
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{Die Kuh springt in die H8h',\nA, B, C, die Katze schreit jucheh!}
								)
							)
						)
						(else
							(proc0_16
								(temp0
									format:
										{And the dish ran away with the spoon.}
								)
							)
						)
					)
					(plate init: setMotion: MoveTo 164 69 self)
					(global111 loop: 13 1 cel: 0 setCycle: End)
				)
			)
			(11
				(plate
					cycleSpeed: 5
					setCycle: End
					setMotion: JumpTo 194 60 self
				)
			)
			(12
				(plate dispose:)
				(self cue:)
			)
			(13
				(if (or (rhymeSync playing:) script)
					(-- state)
					(= cycles 1)
				else
					(global111 setLoop: 9 1 setCycle: Fwd)
					(global109 setLoop: 14 1 cel: 3 setCycle: CT 1 -1 self)
					(global113 show:)
				)
			)
			(14
				(proc0_16 0)
				(proc0_10)
				(= seconds 2)
			)
			(15
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(= local0 1)
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

(instance plate of Actor
	(properties
		view 86
		cycleSpeed 4
		xStep 4
		moveSpeed 4
	)

	(method (init)
		(super init:)
		(self
			setLoop: 12 1
			posn: 10 137
			ignoreControl: -1
			ignoreActors: 1
			setCycle: Fwd
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance cowJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global110
					ignoreActors: 1
					setLoop: 6 1
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(1
				(global110 setLoop: 7 1 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(2
				(global110
					setLoop: 8 1
					cel: 0
					setCycle: 0
					moveSpeed: 3
					setMotion: MoveTo 137 0 self
				)
			)
			(3
				(= cycles 5)
			)
			(4
				(global110
					setPri: 0
					posn: 105 0
					xStep: 2
					yStep: 2
					cel: 1
					setMotion: MoveTo 75 47 self
				)
			)
			(5
				(global110 dispose:)
				(= global110 0)
				(self dispose:)
			)
		)
	)
)

