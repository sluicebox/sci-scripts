;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 336)
(include sci.sh)
(use Main)
(use LeapTo)
(use Str)
(use Sync)
(use ROsc)
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
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local2 0)
				(= local1 2)
				(Load rsSCRIPT 106)
				(gEgo setMotion: MoveTo 132 116 self)
			)
			(1
				(global112
					init:
					setLoop: 1 1
					setPri: (- (global109 priority:) 1)
					cel: 0
				)
				(global129 dispose:)
				(proc0_9)
				(gEgo setMotion: MoveTo 132 122 self)
			)
			(2
				(proc0_7 gEgo global112)
				(= cycles 1)
			)
			(3
				(gLongSong stop:)
				(gMessager say: 1 0 0 14 0 400) ; "JACK SPRAT"
				(rhymeSync init: 400 1 0 0 14)
				(= ticks 100)
			)
			(4
				(if (and (!= gLanguage 2) (!= gLanguage 3))
					(global120 setCycle: ROsc 200 0)
					(= ticks 170)
				else
					(= ticks 1)
				)
			)
			(5
				(if (and (!= gLanguage 2) (!= gLanguage 3))
					(global120 setCycle: 0 cel: 0)
					(= ticks 10)
				else
					(= ticks 1)
				)
			)
			(6
				(if (and (!= gLanguage 2) (!= gLanguage 3))
					(global121 setCycle: ROsc 200 0)
					(= ticks 170)
				else
					(= ticks 1)
				)
			)
			(7
				(if (and (!= gLanguage 2) (!= gLanguage 3))
					(global121 setCycle: 0 cel: 0)
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(cond
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {Jack Sprat no pod^a comer grasa,})
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format:
									{Mon mari vous 3tes vraiment trop gros,\nj'peux plus manger de gXteaux,}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {La~t uns nun den Schinken essen,})
						)
					)
					(else
						(proc0_16
							(temp0 format: {Jack Sprat could eat no fat.})
						)
					)
				)
				(global109 setScript: jackEat)
				(= cycles 1)
			)
			(10
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0
									format:
										{su esposa no pod^a comer carne magra,}
								)
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0 format: {j'peux plus manger de gigot})
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{was uns bedr9ckt vergessen\nund uns des guten Mahls erfreun.}
								)
							)
						)
						(else
							(proc0_16
								(temp0 format: {His wife could eat no lean;})
							)
						)
					)
					(global110 setScript: wifeEat)
				)
				(= cycles 1)
			)
			(11
				(cond
					((< (rhymeSync prevSignal:) 30)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {y as^ entre los dos}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format:
									{j'ai pas le droit aux bonbons, je suis vraiment trop gros}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {La~t uns nun den Schinken essen,})
						)
					)
					(else
						(proc0_16 (temp0 format: {And so, between them both,}))
					)
				)
				(= cycles 1)
			)
			(12
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
					(= cycles 1)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0 format: {dejaron el plato limpio.})
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0
									format:
										{tant pis je ne mangerai qu'un peu de saucisson,\net dix-huit tranches de ce magnifique jambon.}
								)
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{was uns bedr9ckt vergessen\nund uns des guten Mahls erfreun.}
								)
							)
						)
						(else
							(proc0_16
								(temp0 format: {They licked the platter clean.})
							)
						)
					)
					(= ticks 270)
				)
			)
			(13
				(if local1
					(-- state)
				)
				(= cycles 1)
			)
			(14
				(global121 setCycle: End self)
			)
			(15
				(if (!= gLanguage 2)
					(global121 loop: 4 setCycle: ROsc 200 0)
					(= ticks 30)
				else
					(= ticks 1)
				)
			)
			(16
				(if (== (rhymeSync playing:) 0)
					(global121 setCycle: Beg)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
					(DisposeScript 106)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(17
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(= local2 1)
			)
		)
		(temp0 dispose:)
		(if local2
			(if (>= gScore gPossibleScore)
				(gEgo setMotion: MoveTo 125 133)
			)
			(self dispose:)
		)
	)
)

(instance jackEat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global120 setLoop: 1 1 cel: 255 setCycle: Beg self)
			)
			(1
				(global120 hide:)
				(global109
					view: 652
					cycleSpeed: 15
					setLoop: 1 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(global109 setLoop: 5 1 cel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(3
				(if (< (global112 cel:) 8)
					(= state 1)
					(global112 cel: (+ 1 (global112 cel:)))
					(= ticks (Random 50 90))
				else
					(global109 setLoop: 10 1 cel: 0 cycleSpeed: 3 setCycle: End)
					(global112 cel: (+ 1 (global112 cel:)))
					(= cycles 2)
				)
			)
			(4
				(theBone
					init:
					ignoreActors: 1
					setLoop: 9 1
					setCycle: Fwd
					setStep: 2 2
					posn: 135 98 22
					setMotion: LeapTo 68 118 10
				)
				(= cycles 2)
			)
			(5
				(global109 setLoop: 1 1 cel: 255 cycleSpeed: 14 setCycle: Beg)
				(= cycles 1)
			)
			(6
				(global111
					view: 652
					setLoop: 7 1
					cycleSpeed: 6
					cel: 0
					setCycle: End self
				)
				(global113 setCycle: Fwd)
			)
			(7
				(global111 view: 652 setLoop: 8 1 cel: 0 setCycle: CT 5 1 self)
			)
			(8
				(if (> (theBone x:) 69)
					(-- state)
					(= cycles 1)
				else
					(global111 setCycle: End self)
					(theBone dispose:)
				)
			)
			(9
				(DisposeScript 106)
				(global109 view: 651 setLoop: 8 1 cel: 0)
				(global120 show:)
				(-- local1)
				(self dispose:)
			)
		)
	)
)

(instance theBone of Actor
	(properties
		view 652
		loop 15
		cel 1
		cycleSpeed 3
		illegalBits 0
		moveSpeed 3
	)
)

(instance wifeEat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global121 setLoop: 3 1 cel: 255 setCycle: Beg self)
			)
			(1
				(global121 hide:)
				(global110
					view: 652
					cycleSpeed: 10
					setLoop: 0 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(global110 setLoop: 3 1 cel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(3
				(if (< (global112 cel:) 8)
					(= state 1)
					(global112 cel: (+ 1 (global112 cel:)))
					(= ticks (Random 44 80))
				else
					(global110 setLoop: 0 1 cel: 255 setCycle: Beg self)
				)
			)
			(4
				(global110 view: 651 setLoop: 9 1 cel: 0)
				(global121 show:)
				(-- local1)
				(self dispose:)
			)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

