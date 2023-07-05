;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use Main)
(use Str)
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
	local1
	local2
	local3
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local2 0)
				(= local0 0)
				(= local1 97)
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
				(global152 hide:)
				(global109
					view: 84
					setLoop: 0 1
					setCycle: CT 1 1
					ignoreActors: 1
				)
				(gEgo setMotion: PolyPath 139 93 self)
			)
			(1
				(gLongSong stop:)
				(proc0_9)
				(Load rsVIEW 84)
				(Load rsSCRIPT 64969)
				(gMessager say: 1 0 0 2 0 400) ; "MARY QUITE CONTRARY"
				(rhymeSync init: 400 1 0 0 2)
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
				(cond
					((< (rhymeSync prevSignal:) 10)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0
								format:
									{Meriaria, Meriaria,\ntan contradictoria.}
							)
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format:
									{Savez-vous planter les choux, 0 la mode, 0 la mode,}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {Die B5urin, die M5gde,}))
					)
					(else
						(proc0_16 (temp0 format: {Mary, Mary, quite contrary,}))
					)
				)
				(= cycles 1)
			)
			(4
				(cond
					((< (rhymeSync prevSignal:) 20)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {/C&mo crece tu jard^n?}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format:
									{savez-vous planter les choux, 0 la mode de chez nous.}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {sie d9rfen nicht ruhn,}))
					)
					(else
						(proc0_16 (temp0 format: {How does your garden grow?}))
					)
				)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(global110 setCycle: Fwd)
					(global111 setCycle: Fwd)
					(global112 setCycle: Fwd)
					(global113 setCycle: Fwd)
					(cond
						((== gLanguage 1)
							(proc0_16 (temp0 format: {Con campanas plateadas,}))
						)
						((== gLanguage 2)
							(proc0_16
								(temp0
									format:
										{On les plante avec le doigt, 0 la mode, 0 la mode,}
								)
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{sie haben im Haus und im Garten zu tun,}
								)
							)
						)
						(else
							(proc0_16 (temp0 format: {With silver bells,}))
						)
					)
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(cond
						((== gLanguage 1)
							(proc0_16 (temp0 format: {conchas de berberecho,}))
						)
						((== gLanguage 2)
							(proc0_16
								(temp0 format: {on les plante avec le doigt,})
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{sie graben und rechen und singen ein Lied}
								)
							)
						)
						(else
							(proc0_16 (temp0 format: {And cockleshells,}))
						)
					)
					(global110 setCycle: 0)
					(global111 setCycle: 0)
					(global112 setCycle: 0)
					(global113 setCycle: 0)
					(global133 setCel: 4 setCycle: Fwd)
					(gShell2 setCel: 3 setCycle: Fwd)
					(gShell3 setCel: 2 setCycle: Fwd)
					(gShell4 setCel: 1 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0
									format:
										{y lindas doncellas, todas en una hilera.}
								)
							)
						)
						((== gLanguage 2)
							(proc0_16 (temp0 format: {0 la mode de chez nous.}))
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{und freun sich, wenn alles sch8n gr9net und bl9ht.}
								)
							)
						)
						(else
							(proc0_16
								(temp0 format: {And pretty maids all in a row.})
							)
						)
					)
					(global133 setCycle: 0 cel: 0)
					(gShell2 setCycle: 0 cel: 0)
					(gShell3 setCycle: 0 cel: 0)
					(gShell4 setCycle: 0 cel: 0)
					(global120 setCycle: Fwd)
					(global121 setCycle: Fwd)
					(global122 setCycle: Fwd)
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
				(global121 setCycle: Beg self)
				(global122 setCycle: Beg self)
			)
			(10)
			(11
				(global120 setCycle: 0)
				(global121 setCycle: 0)
				(global122 setCycle: 0)
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
				(DisposeScript 64969)
				(= local2 1)
			)
		)
		(temp0 dispose:)
		(if local2
			(if (>= gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			)
			(self dispose:)
		)
	)
)

(instance watering of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global109 cel: 3)
				((= register (View new:))
					view: 84
					setLoop: 0 1
					cel: 2
					posn: 136 99
					init:
				)
				(= ticks 10)
			)
			(1
				(global109
					setLoop: 1 1
					cel: 0
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
				(global109 cel: 0)
				(= seconds 3)
			)
			(8
				(global109
					cycleSpeed: 12
					setLoop: 0 1
					cel: 1
					setCycle: Beg self
				)
				(register dispose:)
			)
			(9
				(global109 view: 74 setLoop: 3 1 cel: 255 ignoreActors: 1)
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
					setLoop: 3 1
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(global109 setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(2
				(global109 setLoop: 3 1 cel: 255 setCycle: Beg self)
			)
			(3
				(global109
					setLoop: 1 1
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

