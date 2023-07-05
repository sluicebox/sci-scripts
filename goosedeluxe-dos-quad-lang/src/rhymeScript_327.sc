;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 327)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use ROsc)
(use Osc)
(use PolyPath)
(use Motion)
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
				(global109 setLoop: 1 cel: 4)
				(gEgo ignoreActors: 1)
				(global110 hide:)
				(gEgo setMotion: PolyPath 160 140 self)
			)
			(1
				(gEgo ignoreActors: 1)
				(global129 setMotion: PolyPath 117 140)
				(gLongSong stop:)
				(proc0_7 gEgo global109)
				(global109
					setLoop: 8
					setCel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(global129 setScript: dogScript)
				(gMessager say: 1 0 0 12 0 400) ; "THAT LITTLE BOY WHO LOST HIS DOG"
				(rhymeSync init: 400 1 0 0 12)
			)
			(2
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
					(= cycles 1)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0
									format:
										{=Oh! /d&nde?, =Oh! /d&nde se ha ido mi perrito?}
								)
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0 format: {M$dor, M$dor, M$dor o2 es-tu?})
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{Als unser Mops ein M8pschen war,\nda konnt' er freundlich sein;}
								)
							)
						)
						(else
							(proc0_16
								(temp0
									format:
										{Oh where, oh where has my \nlittle dog gone?}
								)
							)
						)
					)
					(gEgo setLoop: 3 0)
					((gGoals at: 3) egoReturned: 1)
					(global109
						cycleSpeed: 8
						setLoop: 9
						cel: 0
						setCycle: CT 4 1 self
					)
				)
			)
			(3
				(global109 setCycle: ROsc 2 5 9 self)
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
									format:
										{=Oh! /d&nde?, =Oh! /d&nde puede estar?}
								)
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0 format: {M$dor, M$dor o2 cours-tu?})
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{jetzt brummt er alle Tage\nund bellt noch obendrein;}
								)
							)
						)
						(else
							(proc0_16
								(temp0
									format: {Oh where, oh where \ncan he be?}
								)
							)
						)
					)
					(global109
						setLoop: 8
						setCel: 7
						cycleSpeed: 8
						setCycle: Beg self
					)
				)
			)
			(5
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
					(= cycles 1)
				else
					(cond
						((== gLanguage 1)
							(proc0_16 (temp0 format: {Con sus orejas cortas,}))
						)
						((== gLanguage 2)
							(proc0_16 (temp0 format: {Je pleure mon chien}))
						)
						((== gLanguage 3)
							(proc0_16
								(temp0 format: {hei-du, hei-du, heida la la la})
							)
						)
						(else
							(proc0_16 (temp0 format: {With his ears cut short}))
						)
					)
					(global110 show:)
					(global109
						cycleSpeed: 6
						setLoop: 0
						setCel: 0
						setCycle: CT 4 1 self
					)
				)
			)
			(6
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(cond
						((== gLanguage 1)
							(proc0_16 (temp0 format: {y su cola larga,}))
						)
						((== gLanguage 2)
							(proc0_16 (temp0 format: {car je t'ai perdu}))
						)
						((== gLanguage 3)
							(proc0_16
								(temp0 format: {und bellt noch obendrein;})
							)
						)
						(else
							(proc0_16 (temp0 format: {And his tail cut long,}))
						)
					)
					(global109 setCycle: CT 1 -1 self)
				)
			)
			(7
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
					(= cycles 1)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0
									format:
										{=Oh! /d&nde?, =Oh! /d&nde puede estar?}
								)
							)
						)
						((== gLanguage 2)
							(proc0_16 (temp0 format: {M$dor, M$dor o2 es-tu?}))
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{jetzt brummt er alle Tage\nund bellt noch obendrein.}
								)
							)
						)
						(else
							(proc0_16
								(temp0
									format: {Oh where, oh where \ncan he be?}
								)
							)
						)
					)
					(global109
						setLoop: 8
						setCel: 0
						cycleSpeed: 6
						setCycle: End self
					)
					(global110 hide:)
				)
			)
			(8
				(if (!= (global129 script:) 0)
					(-- state)
					(= cycles 1)
				else
					(global109
						cycleSpeed: 6
						setLoop: 10
						cel: 0
						setCycle: CT 3 1 self
					)
				)
			)
			(9
				(global129 setCycle: Walk setMotion: PolyPath 140 121 self)
			)
			(10
				(global129 hide:)
				(global109 cel: 4 setCycle: End self)
			)
			(11
				(global109 setLoop: 11 cel: 0 setCycle: ROsc 3 0 3 self)
			)
			(12
				(global109 setLoop: 12 cel: 0 setCycle: End self)
			)
			(13
				(if (rhymeSync playing:)
					(-- state)
				)
				(= cycles 1)
			)
			(14
				(proc0_16 0)
				(proc0_10)
				(global110 show:)
				(global109 cel: 0 setLoop: 5)
				(global111 init:)
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

(instance dogScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global129
					setCycle: Walk
					moveSpeed: 6
					setMotion: PolyPath 125 134 self
				)
			)
			(1
				(global129 setLoop: 5 setCycle: Osc -1)
				(= seconds 4)
			)
			(2
				(if (< (rhymeSync prevSignal:) 50)
					(global129 setCycle: Walk setMotion: PolyPath 133 110 self)
				else
					(= state 4)
					(= cycles 1)
				)
			)
			(3
				(if (< (rhymeSync prevSignal:) 50)
					(global129 setMotion: PolyPath 80 146 self)
				else
					(= state 4)
					(= cycles 1)
				)
			)
			(4
				(if (< (rhymeSync prevSignal:) 50)
					(global129 setLoop: 4 setCycle: Fwd)
					(= seconds 4)
				else
					(= cycles 1)
				)
			)
			(5
				(global129 setCycle: Walk setMotion: PolyPath 185 134 self)
			)
			(6
				(global129 setLoop: 5 cycleSpeed: 6 setCycle: Fwd)
				(= seconds 2)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

