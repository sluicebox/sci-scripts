;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 341)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use PolyPath)
(use Path)
(use Motion)
(use System)

(public
	rhymeScript 0
)

(local
	[local0 13] = [119 38 116 44 116 89 119 93 70 113 52 114 32768]
	local13
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local13 0)
				(Load rsSCRIPT 64983)
				(self cue:)
			)
			(1
				(proc0_9)
				(global129
					view: 64
					setStep: 2 2
					moveSpeed: 4
					illegalBits: 0
					ignoreActors: 1
				)
				(gEgo ignoreActors: 1 setMotion: MoveTo 125 116 self)
			)
			(2
				(proc0_7 gEgo global109)
				(gEgo ignoreActors: 1)
				(global109 setLoop: 1 cel: 0)
				(gLongSong stop:)
				(gMessager say: 1 0 0 5 0 400) ; "HICKORY DICKORY DOCK"
				(rhymeSync init: 400 1 0 0 5)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
					(= cycles 1)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0 format: {=Hickory, Dickory, Dock!})
							)
						)
						((== gLanguage 2)
							(proc0_16 (temp0 format: {Cric, crac, croc!}))
						)
						((== gLanguage 3)
							(proc0_16 (temp0 format: {Gro~e Uhren gehen}))
						)
						(else
							(proc0_16 (temp0 format: {Hickory, dickory, dock!}))
						)
					)
					(global129 setCycle: Walk setMotion: MoveTo 152 95 self)
				)
			)
			(4
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
					(= cycles 1)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0
									format: {El rat&n subi& encima del reloj,}
								)
							)
						)
						((== gLanguage 2)
							(proc0_16 (temp0 format: {la souris qui grignote}))
						)
						((== gLanguage 3)
							(proc0_16 (temp0 format: {tick, tack, tick, tack.}))
						)
						(else
							(proc0_16
								(temp0 format: {The mouse ran up the clock;})
							)
						)
					)
					(global129 setMotion: MoveTo 146 92 self)
				)
			)
			(5
				(global129 setMotion: MoveTo 147 65 self)
			)
			(6
				(global129 setMotion: MoveTo 146 57 self)
			)
			(7
				(global129 setMotion: MoveTo 146 47 self)
			)
			(8
				(global129 setMotion: MoveTo 147 40 self)
			)
			(9
				(global129 setMotion: MoveTo 130 38 self)
			)
			(10
				(global129 setCel: 0)
				(= cycles 1)
			)
			(11
				(cond
					((< (rhymeSync prevSignal:) 30)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {El reloj dio la una,}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {dame Pendule sonne un coup (dong)})
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0
								format:
									{Kleine Uhren gehen ticke, tacke, ticke, tacke.}
							)
						)
					)
					(else
						(proc0_16 (temp0 format: {The clock struck one,}))
					)
				)
				(= cycles 1)
			)
			(12
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(global109 setLoop: 1 setCel: 1)
					(global129
						setLoop: 4
						setCel: 0
						cycleSpeed: 6
						setCycle: End self
					)
				)
			)
			(13
				(global129 setMotion: MoveTo 130 38 self)
			)
			(14
				(global129 setCycle: Walk cycleSpeed: 4 setLoop: 1)
				(= cycles 1)
			)
			(15
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				)
				(= cycles 1)
			)
			(16
				(cond
					((== gLanguage 1)
						(proc0_16 (temp0 format: {y el rat&n baj&.}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format:
									{dame pendule sonne deux coups (dong) (dong)}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Und die kleinen Taschenuhren})
						)
					)
					(else
						(proc0_16 (temp0 format: {The mouse ran down,}))
					)
				)
				(global129
					fixPriority: 1
					priority: 99
					setLoop: -1
					setMotion: runDown
				)
				(= ticks 75)
			)
			(17
				(global109 cel: 3)
				(= cycles 1)
			)
			(18
				(cond
					((< (rhymeSync prevSignal:) 60)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {=Hickory, Dickory, Dock!}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {tic, tac, tic, tac, tic, tac, toc!})
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0
								format:
									{ticke, tacke, tacke, tacke - ticke, tacke, tacke, tacke.}
							)
						)
					)
					(else
						(proc0_16 (temp0 format: {Hickory, dickory, dock!}))
					)
				)
				(= cycles 1)
			)
			(19
				(if (or (rhymeSync playing:) (global129 mover:))
					(-- state)
					(= cycles 1)
				else
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				)
			)
			(20
				(gEgo setMotion: 0 setLoop: -1)
				(global109 setLoop: 3 cel: 0)
				(if (== gScore gPossibleScore)
					(gEgo setMotion: MoveTo 209 103)
				)
				(gLongSong number: 601 loop: -1 play:)
				(DisposeScript 64983)
				(= local13 1)
			)
		)
		(temp0 dispose:)
		(if local13
			(if (>= gScore gPossibleScore)
				(gEgo setMotion: PolyPath 235 105)
			)
			(self dispose:)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance runDown of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

