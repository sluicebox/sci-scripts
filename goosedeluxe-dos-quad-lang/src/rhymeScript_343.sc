;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 343)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
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
				(gEgo setMotion: MoveTo 169 121 self)
			)
			(1
				(gLongSong stop:)
				(global111 stop:)
				(gMessager say: 1 0 0 4 0 400) ; "LITTLE JACK HORNER"
				(rhymeSync init: 400 1 0 0 4)
				(global109 setScript: jackEat)
				(gEgo setMotion: MoveTo 136 135 self)
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
						(proc0_16 (temp0 format: {El peque+o Jack Horner}))
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {J'aime la galette}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Dann stell' ich den Teller auf,})
						)
					)
					(else
						(proc0_16 (temp0 format: {Little Jack Horner}))
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
						(proc0_16 (temp0 format: {se sent& en un rinc&n,}))
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {savez-vous comment?}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Niklaus legt gewi~ was drauf.})
						)
					)
					(else
						(proc0_16 (temp0 format: {Sat in a corner}))
					)
				)
				(= cycles 1)
			)
			(5
				(cond
					((< (rhymeSync prevSignal:) 30)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {para comer pastel de Navidad.})
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format:
									{Quand elle est bien faite avec du beurre dedans}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Lustig, lustig, tralleralala,})
						)
					)
					(else
						(proc0_16 (temp0 format: {Eating his Christmas pie;}))
					)
				)
				(= cycles 1)
			)
			(6
				(cond
					((< (rhymeSync prevSignal:) 40)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {Meti& el dedo,}))
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {Tralalala.}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Lustig, lustig, tralleralala,})
						)
					)
					(else
						(proc0_16 (temp0 format: {He put in his thumb,}))
					)
				)
				(= cycles 1)
			)
			(7
				(cond
					((< (rhymeSync prevSignal:) 50)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {sac& una ciruela,}))
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {Lalalalalala.}))
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {bald ist Niklausabend da,}))
					)
					(else
						(proc0_16 (temp0 format: {And pulled out a plum,}))
					)
				)
				(= cycles 1)
			)
			(8
				(cond
					((< (rhymeSync prevSignal:) 60)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {y dijo, "=Qu$ buen muchacho soy!"})
						)
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {lalalalala.}))
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {bald ist Niklausabend da,}))
					)
					(else
						(proc0_16
							(temp0 format: {And said, "What a good boy am I!"})
						)
					)
				)
				(= cycles 1)
			)
			(9
				(if (or (rhymeSync playing:) (global109 script:))
					(-- state)
					(= cycles 1)
				else
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				)
			)
			(10
				(global109 cycleSpeed: 6 setCycle: Beg self)
			)
			(11
				(global109 setLoop: 13 1 setCycle: Fwd)
				(gEgo setMotion: 0 setLoop: -1)
				(if (== gScore gPossibleScore)
					(gEgo setMotion: MoveTo 139 146)
				)
				(gLongSong number: 600 loop: -1 play:)
				(global111 play:)
				(= local0 1)
			)
		)
		(temp0 dispose:)
		(if local0
			(if (>= gScore gPossibleScore)
				(gEgo setMotion: PolyPath 126 144)
			)
			(self dispose:)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance jackEat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global110 dispose:)
				(global109
					setLoop: 7 1
					cel: 2
					cycleSpeed: 9
					setCycle: Walk
					moveSpeed: 6
					setMotion: MoveTo 76 101 self
				)
			)
			(1
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
					(= cycles 1)
				else
					(global109
						setLoop: 8 1
						cel: 0
						cycleSpeed: 10
						setCycle: End self
					)
				)
			)
			(2
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
					(= cycles 1)
				else
					(global109 setLoop: 9 1 cel: 0 setCycle: End self)
				)
			)
			(3
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(global109 setLoop: 13 1 cel: 0 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(global109 setLoop: 10 1 cel: 0 setCycle: End self)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

