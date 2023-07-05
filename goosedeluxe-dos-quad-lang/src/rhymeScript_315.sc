;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 315)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use PChase)
(use PFollow)
(use ROsc)
(use PolyPath)
(use Blk)
(use Wander)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	local0
	local1
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local1 0)
				(= local0 0)
				(gEgo
					setMotion:
						PolyPath
						(global109 x:)
						(+ (global109 y:) 15)
						self
				)
			)
			(1
				(proc0_9)
				(Load rsVIEW 44)
				(Load rsSCRIPT 64970)
				(Load rsSCRIPT 64972)
				(gEgo
					setMotion:
						PolyPath
						(- (gEgo x:) 10)
						(+ (gEgo y:) 5)
						self
				)
			)
			(2
				(proc0_7 gEgo global109)
				(global109 setCycle: Walk setScript: manActions)
				(if (and (!= gLanguage 2) (!= gLanguage 3))
					(global111 setCycle: ROsc 200 0)
				)
				(gLongSong stop:)
				(gMessager say: 1 0 0 7 0 400) ; "CROOKED MAN"
				(rhymeSync init: 400 1 0 0 7)
				(= cycles 1)
			)
			(3
				(cond
					((< (rhymeSync prevSignal:) 10)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {Hab^a un hombre torcido,}))
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {Il $tait un vieil homme}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Taler, Taler, Du mu~t wandern,})
						)
					)
					(else
						(proc0_16 (temp0 format: {There was a crooked man,}))
					)
				)
				(= cycles 1)
			)
			(4
				(manActions cue:)
				(= cycles 1)
			)
			(5
				(cond
					((< (rhymeSync prevSignal:) 20)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {Que recorri& una milla torcida.})
						)
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {qui avait une vieille canne}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {von der einen Hand zur andern.})
						)
					)
					(else
						(proc0_16 (temp0 format: {Who went a crooked mile,}))
					)
				)
				(= cycles 1)
			)
			(6
				(cond
					((< (rhymeSync prevSignal:) 30)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {Encontr& seis peniques torcidos,})
						)
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {il trouva une vieille pi1ce}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Das ist sch8n, das ist sch8n,})
						)
					)
					(else
						(proc0_16
							(temp0 format: {He found a crooked sixpence,})
						)
					)
				)
				(= cycles 1)
			)
			(7
				(cond
					((< (rhymeSync prevSignal:) 40)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {cerca de un portillo torcido.})
						)
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {0 c4t$ d'une vieille cabane}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Taler la~ Dich nur nicht sehn.})
						)
					)
					(else
						(proc0_16 (temp0 format: {Along a crooked stile;}))
					)
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(cond
						((== gLanguage 1)
							(proc0_16 (temp0 format: {Compr& un gato torcido,}))
						)
						((== gLanguage 2)
							(proc0_16 (temp0 format: {il acheta un vieux chat}))
						)
						((== gLanguage 3)
							(proc0_16
								(temp0 format: {Opa, Opa steht vor'm Haus,})
							)
						)
						(else
							(proc0_16 (temp0 format: {He bought a crooked cat}))
						)
					)
					(= local0 1)
				)
				(= cycles 1)
			)
			(9
				(if (< (rhymeSync prevSignal:) 60)
					(-- state)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0 format: {Que atrap& un rat&n torcido,})
							)
						)
						((== gLanguage 2)
							(proc0_16 (temp0 format: {attrapa un vieux rat}))
						)
						((== gLanguage 3)
							(proc0_16
								(temp0 format: {vor dem alten Bauernhaus,})
							)
						)
						(else
							(proc0_16
								(temp0 format: {Which caught a crooked mouse,})
							)
						)
					)
					(= local0 2)
				)
				(= cycles 1)
			)
			(10
				(cond
					((< (rhymeSync prevSignal:) 70)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {Y vivieron todos juntos}))
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {et v$curent tous ensemble}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {der kriegt Geld, der kriegt Geld,})
						)
					)
					(else
						(proc0_16 (temp0 format: {And they all lived together}))
					)
				)
				(= cycles 1)
			)
			(11
				(cond
					((< (rhymeSync prevSignal:) 80)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {En una peque+a casa torcida.})
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {dans une vieille maison de bois.})
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {und dann reist er um die Welt.})
						)
					)
					(else
						(proc0_16 (temp0 format: {In a little crooked house.}))
					)
				)
				(= cycles 1)
			)
			(12
				(if (or (rhymeSync playing:) (global109 script:))
					(-- state)
					(= cycles 1)
				else
					(global109 dispose:)
					(global111 dispose:)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				)
			)
			(13
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(DisposeScript 64970)
				(DisposeScript 64972)
				(= local1 1)
			)
		)
		(temp0 dispose:)
		(if local1
			(if (>= gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			)
			(self dispose:)
		)
	)
)

(instance manActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(global109 setLoop: 1 1 setMotion: MoveTo 156 115 self)
				(global111 hide:)
			)
			(2
				(global110 setCycle: End self)
			)
			(3
				(theMouse init: setScript: mouseActions self)
				(global109 setLoop: 0 1 setMotion: MoveTo 273 149 self)
			)
			(4)
			(5
				(if (not local0)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(theMouse ignoreBlocks: mouseCage setMotion: MoveTo 194 141)
				(theCat init:)
				(global109 setLoop: 1 1 setMotion: MoveTo 219 128 self)
			)
			(7
				(if (< local0 2)
					(-- state)
				)
				(= cycles 1)
			)
			(8
				(theMouse setMotion: MoveTo 160 120)
				(theCat
					xStep: 3
					ignoreBlocks: 1
					setMotion: PChase theMouse 9 self
				)
			)
			(9
				(theMouse dispose:)
				(theCat setLoop: 8 1 cel: 0 setCycle: End self)
			)
			(10
				(theCat setScript: enterHouse self)
			)
			(11
				(theCat dispose:)
				(global109 hide:)
				(self dispose:)
			)
		)
	)
)

(instance mouseActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMouse setMotion: MoveTo 150 103 self)
			)
			(1
				(theMouse setMotion: MoveTo 168 133 self)
			)
			(2
				(mouseCage init:)
				(theMouse observeBlocks: mouseCage setMotion: Wander)
				(self dispose:)
			)
		)
	)
)

(instance enterHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theCat
					setPri: 0 1
					setLoop: 9 1
					setCycle: Walk
					setMotion: MoveTo 127 100 self
				)
				(global109 setMotion: MoveTo 160 120)
			)
			(1
				(theCat setMotion: MoveTo 104 97)
				(global109 setMotion: MoveTo 152 108 self)
			)
			(2
				(global109
					setPri: 0 1
					setLoop: 14 1
					cel: 0
					setCycle: End
					setMotion: MoveTo 110 100 self
				)
			)
			(3
				(global110 setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance theMouse of Actor
	(properties
		x 129
		y 103
		view 44
		yStep 1
		cycleSpeed 3
		xStep 1
	)

	(method (init)
		(super init:)
		(self setCycle: Walk setPri: 20 1)
	)
)

(instance theCat of Actor
	(properties
		x 275
		y 110
		view 83
		loop 7
		cycleSpeed 3
		xStep 4
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 7 1 setCycle: Fwd)
		(self setMotion: PFollow global109 7)
	)
)

(instance mouseCage of Cage
	(properties
		left 150
		top 110
		right 200
		bottom 140
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

