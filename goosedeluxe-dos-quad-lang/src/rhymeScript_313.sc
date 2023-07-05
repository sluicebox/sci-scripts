;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 313)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use PFollow)
(use PolyPath)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	[local0 5] = [157 100 120 120 32768]
	[local5 5] = [157 100 179 94 32768]
	local10
)

(instance tPath of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance tPath2 of Path
	(properties)

	(method (at param1)
		(return [local5 param1])
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local10 0)
				(teacher
					init:
					setLoop: 5 1
					ignoreControl: -1
					ignoreActors: 1
					hide:
				)
				(= cycles 1)
			)
			(1
				(gLongSong stop:)
				(= ticks 30)
			)
			(2
				(gMessager say: 1 0 0 13 0 400) ; "MARY HAD A LITTLE LAMB"
				(proc0_9)
				(gLongSong stop:)
				(rhymeSync init: 400 1 0 0 13)
				(gEgo
					ignoreActors: 1
					setMotion:
						MoveTo
						(+ (global109 x:) 100)
						(global109 y:)
						watch
				)
				(self setScript: words)
				(= cycles 2)
			)
			(3
				(global129
					moveSpeed: 2
					setMotion:
						MoveTo
						(+ (global109 x:) 25)
						(+ (global109 y:) 10)
						self
				)
			)
			(4
				(global129 setLoop: 1 1 setCycle: CT 0 -1 self)
			)
			(5
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
					(= cycles 1)
				else
					(teacher show: setCycle: Walk setMotion: tPath self)
				)
			)
			(6
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(teacher loop: 7 1 cycleSpeed: 8 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(8
				(= cycles 1)
			)
			(9
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(global110 dispose:)
					(global109
						setLoop: 0 1
						cel: 0
						cycleSpeed: 6
						setMotion: MoveTo (+ 7 (global109 x:)) (global109 y:)
						setCycle: End self
					)
				)
			)
			(10
				(= cycles 1)
			)
			(11
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
					(= cycles 1)
				else
					(global109
						setLoop: 4 1
						setCycle: Walk
						setMotion: MoveTo 131 125 self
					)
					(global129
						setLoop: -1 1
						setCycle: Walk
						setMotion: PFollow global109 15
					)
				)
			)
			(12
				(global109 setCycle: Walk setMotion: PolyPath 182 94 self)
				(teacher loop: 8 1 cel: 0 setCycle: End)
				(global129 cel: 0 setMotion: 0)
			)
			(13
				(global109 posn: 400 1 hide:)
				(= cycles 1)
			)
			(14
				(if (< (rhymeSync prevSignal:) 60)
					(-- state)
					(= cycles 1)
				else
					(teacher
						setCycle: Walk
						setLoop: 9 1
						cycleSpeed: 9
						setMotion: tPath2 self
					)
					(global129 setCycle: Walk setMotion: PFollow teacher 15)
				)
			)
			(15
				(if (< (rhymeSync prevSignal:) 70)
					(-- state)
				else
					(teacher dispose:)
					(global129 ignoreControl: -1 setMotion: MoveTo 182 94)
					(haha init:)
				)
				(= cycles 1)
			)
			(16
				(if (or script (rhymeSync playing:))
					(-- state)
					(= cycles 1)
				else
					(haha dispose:)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				)
			)
			(17
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(= local10 1)
			)
		)
		(if local10
			(if (>= gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			)
			(self dispose:)
		)
	)
)

(instance words of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(cond
					((< (rhymeSync prevSignal:) 10)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {Mar^a ten^a un corderito.}))
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {Eh, dis-moi donc berg1re}))
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {Schlaf, Kindlein schlaf!}))
					)
					(else
						(proc0_16 (temp0 format: {Mary had a little lamb,}))
					)
				)
				(= cycles 1)
			)
			(1
				(cond
					((< (rhymeSync prevSignal:) 20)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {Su lana era blanca como la nieve,})
						)
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {A qui est ce mouton?}))
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {Der Vater h9t' die Schaf,}))
					)
					(else
						(proc0_16
							(temp0 format: {Its fleece was white as snow;})
						)
					)
				)
				(= cycles 1)
			)
			(2
				(cond
					((< (rhymeSync prevSignal:) 30)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {y a todas partes que iba Mar^a,})
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format:
									{Et par ma foi, Madame, A ceux qui le gardions.}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {die Mutter sch9ttelt's B5umelein,})
						)
					)
					(else
						(proc0_16 (temp0 format: {Everywhere that Mary went}))
					)
				)
				(= cycles 1)
			)
			(3
				(cond
					((< (rhymeSync prevSignal:) 40)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {el corderito la acompa+aba.}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {Et tralala deridera, et tralala})
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {da f5llt herab ein Tr5umelein.})
						)
					)
					(else
						(proc0_16 (temp0 format: {The lamb was sure to go.}))
					)
				)
				(= cycles 1)
			)
			(4
				(cond
					((< (rhymeSync prevSignal:) 50)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {La sigui& un d^a a la escuela,})
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format:
									{eh, dis-moi donc berg1re, combien as-tu de moutons}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {Schlaf, Kindlein schlaf!}))
					)
					(else
						(proc0_16
							(temp0 format: {It followed her to school one day;})
						)
					)
				)
				(= cycles 1)
			)
			(5
				(cond
					((< (rhymeSync prevSignal:) 60)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0
								format: {lo que iba en contra de las reglas.}
							)
						)
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {et par ma foi Madame}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0
								format:
									{Schlaf, Kindlein schlaf!\nSo schenk' ich dir ein Schaf}
							)
						)
					)
					(else
						(proc0_16 (temp0 format: {That was against the rule;}))
					)
				)
				(= cycles 1)
			)
			(6
				(cond
					((< (rhymeSync prevSignal:) 70)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {Hizo re^r y jugar a los ni+os,})
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {il faut que je les comptions})
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {mit einer goldnen Schelle fein,})
						)
					)
					(else
						(proc0_16
							(temp0
								format: {It made the children laugh and play}
							)
						)
					)
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 80)
					(-- state)
					(= cycles 1)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0
									format:
										{cuando vieron un corderito en la escuela.}
								)
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0
									format: {et tralala deridera, et tralala.}
								)
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{das soll dein Spielgeselle sein.\nSchlaf, Kindlein schlaf!}
								)
							)
						)
						(else
							(proc0_16
								(temp0 format: {To see a lamb at school.})
							)
						)
					)
					(self dispose:)
				)
			)
		)
		(temp0 dispose:)
	)
)

(instance haha of Prop
	(properties)

	(method (init)
		(self
			view: 69
			setLoop: 13
			cel: 0
			cycleSpeed: 6
			setCycle: Fwd
			setPri: 255
		)
		(super init:)
	)

	(method (doit)
		(if (== (self cel:) 0)
			(self x: (Random 104 220) y: (Random 30 90))
		)
		(super doit:)
	)
)

(instance watch of Script
	(properties)

	(method (cue)
		(proc0_7 gEgo global109)
		(gEgo ignoreActors: 1)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance teacher of Actor
	(properties
		x 179
		y 94
		view 69
		loop 5
		yStep 3
		moveSpeed 7
	)
)

