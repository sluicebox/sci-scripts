;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 337)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
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
				(Load rsVIEW 81)
				(Load rsSCRIPT 64970)
				(gEgo setMotion: MoveTo 133 90 self)
			)
			(1
				(global129 dispose:)
				(proc0_9)
				(global110 hide:)
				(global109 setLoop: 2 1 cel: 0 cycleSpeed: 9 setCycle: End self)
				(gEgo setMotion: MoveTo 133 118)
			)
			(2
				(proc0_7 gEgo global109)
				(= cycles 2)
			)
			(3
				(gLongSong stop:)
				(gMessager say: 1 0 0 3 0 400) ; "OLD KING COLE"
				(rhymeSync init: 400 1 0 0 3 prevSignal: 0)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(cond
					((== gLanguage 1)
						(proc0_16
							(temp0
								format:
									{El anciano Rey Cole ten^a un alma buena,}
							)
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format: {J'ai du bon tabac dans ma tabati1re,}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Froh zu sein bedarf es wenig,})
						)
					)
					(else
						(proc0_16
							(temp0
								format: {Old King Cole was a merry \nold soul,}
							)
						)
					)
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				)
				(= cycles 1)
			)
			(7
				(cond
					((== gLanguage 1)
						(proc0_16 (temp0 format: {Un alma buena era $l.}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format: {j'ai du bon tabac, tu n'en auras pas.}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {und wer froh ist, \nist ein K8nig.})
						)
					)
					(else
						(proc0_16
							(temp0 format: {And a merry old soul \nwas he;})
						)
					)
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(cond
					((== gLanguage 1)
						(proc0_16 (temp0 format: {Pidi& su pipa,}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format:
									{J'en ai du fin et du bien rXp$ mais ce n'est pas pour ton vilain nez.}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Froh zu sein bedarf es wenig,})
						)
					)
					(else
						(proc0_16 (temp0 format: {He called for his pipe,}))
					)
				)
				(= cycles 1)
			)
			(10
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				)
				(= cycles 1)
			)
			(11
				(cond
					((== gLanguage 1)
						(proc0_16 (temp0 format: {pidi& su copa,}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format: {J'ai du bon tabac dans ma tabati1re,}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {und wer froh ist, }))
					)
					(else
						(proc0_16 (temp0 format: {And he called for his bowl,}))
					)
				)
				(global109 setLoop: 3 1 cel: 0 cycleSpeed: 9 setCycle: End)
				(= cycles 1)
			)
			(12
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				)
				(= cycles 1)
			)
			(13
				(cond
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {y llam& a sus tres violinistas.})
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format: {j'ai du bon tabac, tu n'en auras pas.}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {ist ein K8nig.}))
					)
					(else
						(proc0_16
							(temp0
								format:
									{And he called for his \nfiddlers three.}
							)
						)
					)
				)
				(if (== gLanguage 3)
					(= ticks 100)
				else
					(= cycles 1)
				)
			)
			(14
				(if (== gLanguage 3)
					(proc0_16
						(temp0
							format:
								{Froh zu sein, bedarf es\nes wenig,\nund wer froh, wer froh ist,\nist ein K8nig.}
						)
					)
				)
				(= cycles 1)
			)
			(15
				(fiddler1 init: setCycle: End self)
				(global109 view: 81 setLoop: 3 1 cel: 4)
				(fiddler2 init: setCycle: End)
				(fiddler3 init: setCycle: End)
			)
			(16
				(fiddler1 setLoop: 4 1 cycleSpeed: 8 setCycle: Fwd)
				(fiddler2 setLoop: 5 1 cycleSpeed: 8 setCycle: Fwd)
				(fiddler3 setLoop: 6 1 cycleSpeed: 8 setCycle: Fwd)
				(= cycles 1)
			)
			(17
				(global109
					view: 80
					setLoop: 4 1
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(18
				(global109 setLoop: 5 1 cel: 0 setCycle: End self)
			)
			(19
				(global109 setLoop: 6 1 cel: 0 setCycle: End self)
			)
			(20
				(global109 setLoop: 7 1 cel: 0 setCycle: End self)
			)
			(21
				(global109 setLoop: 9 1 cel: 0 setCycle: End self)
			)
			(22
				(Bubble1
					init:
					ignoreActors: 1
					setPri: 150
					setLoop: 10 1
					setCycle: End
					setMotion: Wander 100
					ignoreActors: 1
				)
				(Bubble2
					init:
					ignoreActors: 1
					setPri: 150
					setLoop: 10 1
					setCycle: End
					setMotion: Wander 100
					ignoreActors: 1
				)
				(Bubble3
					init:
					ignoreActors: 1
					setPri: 150
					setLoop: 10 1
					setCycle: End
					setMotion: Wander 100
					ignoreActors: 1
				)
				(Bubble4
					init:
					ignoreActors: 1
					setCycle: End
					setLoop: 10 1
					setMotion: Wander 50
					setPri: 151
					ignoreActors: 1
				)
				(if (< (+= local0 4) 3)
					(-= state 2)
					(= cycles 8)
				else
					(global109 setLoop: 6 1 cel: 2 setCycle: Beg)
					(= cycles 3)
				)
				(++ local0)
			)
			(23
				(global110 show:)
				(Bubble4 setMotion: MoveTo (gEgo x:) (gEgo y:) self)
			)
			(24
				(gEgo hide:)
				(egoCage init:)
				(Bubble4
					setLoop: 11 1
					setCycle: 0
					observeBlocks: egoCage
					cel: global114
					setMotion: Wander 50
				)
				(= seconds 5)
			)
			(25
				(if (not (rhymeSync playing:))
					(fiddler1 setLoop: 0 1 cel: 8 setCycle: Beg)
					(fiddler2 setLoop: 1 1 cel: 8 setCycle: Beg)
					(Bubble1 dispose:)
					(Bubble2 dispose:)
					(Bubble3 dispose:)
					(fiddler3 setLoop: 2 1 cel: 8 setCycle: Beg self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(26
				(Bubble4 setMotion: MoveTo (gEgo x:) (gEgo y:) self)
			)
			(27
				(fiddler1 dispose:)
				(fiddler2 dispose:)
				(fiddler3 dispose:)
				(Bubble4 dispose:)
				(proc0_16 0)
				(DisposeScript 64970)
				(gEgo show: setMotion: 0 setLoop: -1)
				(proc0_10)
				(gLongSong number: 600 loop: -1 play:)
				(= local1 1)
				(= cycles 2)
			)
		)
		(temp0 dispose:)
		(if local1
			(DisposeScript rhymeSync)
			(if (>= gScore gPossibleScore)
				(gEgo setMotion: MoveTo 134 175)
			)
			(self dispose:)
		)
	)
)

(instance Bubble1 of Actor
	(properties
		x 114
		y 49
		view 80
		loop 10
		cycleSpeed 13
	)
)

(instance Bubble2 of Actor
	(properties
		x 114
		y 49
		view 80
		loop 10
		cel 1
		cycleSpeed 13
	)
)

(instance Bubble3 of Actor
	(properties
		x 114
		y 49
		view 80
		loop 10
		cycleSpeed 15
	)
)

(instance Bubble4 of Actor
	(properties
		x 114
		y 49
		view 80
		loop 10
		cel 1
		cycleSpeed 10
	)
)

(instance fiddler1 of Prop
	(properties
		x 80
		y 102
		view 81
		cycleSpeed 9
	)
)

(instance fiddler2 of Prop
	(properties
		x 130
		y 102
		view 81
		loop 1
	)
)

(instance fiddler3 of Prop
	(properties
		x 205
		y 102
		view 81
		loop 2
	)
)

(instance egoCage of Cage
	(properties
		left 60
		top 50
		right 200
		bottom 144
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

