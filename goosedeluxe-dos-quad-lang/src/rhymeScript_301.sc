;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
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
				(if (< (gEgo y:) 108)
					(if (< (gEgo x:) 125)
						(gEgo setMotion: PolyPath 83 107 self)
					else
						(gEgo setMotion: PolyPath 165 107 self)
					)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 134 121 self)
			)
			(2
				(global109 x: (+ (global109 x:) 12) loop: 8 1)
				(global110 hide:)
				(global112 hide:)
				(global111 hide:)
				(proc0_9)
				(Load rsVIEW 61)
				(gLongSong stop:)
				(gMessager say: 1 0 0 18 0 400) ; "JACK AND JILL"
				(rhymeSync init: 400 1 0 0 18)
				(gEgo setMotion: MoveTo 183 142 self)
			)
			(3
				(proc0_7 gEgo global109)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0 format: {Jack y Jill subieron la colina})
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0
									format: {Avec quoi faut-y chercher l'eau}
								)
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{Wenn der Topf aber nun 'n Loch hat, \nlieber Jack, lieber Jack?}
								)
							)
						)
						(else
							(proc0_16
								(temp0
									format: {Jack and Jill went up the hill,}
								)
							)
						)
					)
					(global109
						setLoop: 9 1
						cycleSpeed: 4
						setCycle: Walk
						moveSpeed: 6
						setMotion: MoveTo 118 50
					)
				)
				(= cycles 1)
			)
			(5
				(cond
					((< (rhymeSync prevSignal:) 20)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {para llenar el balde de agua.})
						)
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {ch1re Elise, ch1re Elise}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0
								format:
									{Stopf es zu, liebe, liebe Jill, \nliebe Jill, stopf es zu!}
							)
						)
					)
					(else
						(proc0_16 (temp0 format: {To fetch a pail of water;}))
					)
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(cond
						((== gLanguage 1)
							(proc0_16 (temp0 format: {Jack se cay&,}))
						)
						((== gLanguage 2)
							(proc0_16
								(temp0
									format: {avec quoi faut-y chercher l'eau}
								)
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{Womit soll ich denn das Wasser holen,\nlieber Jack, lieber Jack?}
								)
							)
						)
						(else
							(proc0_16 (temp0 format: {Jack fell down,}))
						)
					)
					(global109 setScript: jackFall)
				)
				(= cycles 1)
			)
			(7
				(cond
					((< (rhymeSync prevSignal:) 40)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {y se rompi& la cabeza}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {avec un seau mon cher Eug1ne})
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Mit dem Topf, liebe, liebe Jill,})
						)
					)
					(else
						(proc0_16 (temp0 format: {And broke his crown,}))
					)
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
					(= cycles 1)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0 format: {y Jill baj& rodando despu$s.})
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0 format: {cher Eug1ne avec un seau.})
							)
						)
						((== gLanguage 3)
							(proc0_16 (temp0 format: {liebe Jill, mit'm Topf!}))
						)
						(else
							(proc0_16
								(temp0 format: {And Jill came tumbling after.})
							)
						)
					)
					(global110 cycleSpeed: 3 setCycle: End self)
				)
			)
			(9
				(global110
					setLoop: 3 1
					yStep: 2
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo (global110 x:) (global109 y:) self
				)
			)
			(10
				(global110 setLoop: 6 1 cycleSpeed: 6 cel: 2 setCycle: Fwd)
				(= cycles 21)
			)
			(11
				(if (== (rhymeSync playing:) 0)
					(global110 setLoop: 8 1 setCycle: 0)
					(global109 setLoop: 7 1 setCycle: 0 cel: 0)
					(global111 show:)
					(global112 show:)
					(bucket dispose:)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(12
				(global109 setScript: 0)
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

(instance bucket of Actor
	(properties
		x 118
		y 52
		view 61
		loop 4
	)
)

(instance jackFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global109
					setMotion: 0
					setLoop: 10 1
					cel: 0
					moveSpeed: 3
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(1
				(global109
					view: 61
					x: (- (global109 x:) 8)
					setLoop: 0 1
					setCycle: End self
				)
				(global110
					view: 61
					setLoop: 1 1
					cel: 0
					posn: (+ (global109 x:) 20) (global109 y:)
					show:
				)
			)
			(2
				(bucket
					y: (+ (global110 y:) 2)
					setLoop: 4 1
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo (bucket x:) 200
					init:
				)
				(global109 setLoop: 2 1 cel: 0)
				(= cycles 1)
			)
			(3
				(global109 setCycle: Fwd yStep: 3 setMotion: MoveTo 99 140 self)
			)
			(4
				(global109 setLoop: 5 1 cel: 2 cycleSpeed: 8 setCycle: Fwd)
				(= cycles 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

