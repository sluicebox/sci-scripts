;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use Interface)
(use Chase)
(use Avoid)
(use Motion)
(use System)

(public
	SorcStuff 0
)

(instance SorcStuff of Script
	(properties)

	(method (init)
		(super init: &rest)
		(Print 800 0) ; "Be careful! There's a sorcerer lurking nearby, just waiting to try out his newest incantation."
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (Said 'look,look/sorcerer,man') (MousedOn gMenace event 3))
				(Print 800 1) ; "The sorcerer wants to cast his brand-new Paralysis Spell on you."
				(event claimed: 1)
			)
			((Said 'talk,talk[/sorcerer]')
				(Print 800 2) ; "This sorcerer is a man of few words and many dangerous spells."
			)
			((Said 'kill/sorcerer,man')
				(Print 800 3) ; "Unfortunately, there's nothing in Daventry more dangerous than an angry Sorcerer. Best to avoid this evil magician than do anything that could cause him to retaliate!"
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 23) number: 34 loop: -1 play:) ; backSound
				(gMenace
					view: 100
					setAvoider: Avoid
					setCycle: Walk
					setCel: -1
					illegalBits: -28672
					setStep: 4 3
					init:
				)
				(switch gPrevRoomNum
					((gCurRoom west:)
						(gMenace posn: 330 158 setMotion: MoveTo 314 155 self)
					)
					((gCurRoom east:)
						(gMenace posn: -10 147 setMotion: MoveTo 6 143 self)
					)
					(else
						(if (Random 0 1)
							(gMenace
								posn: 330 158
								setMotion: MoveTo 314 155 self
							)
						else
							(gMenace
								posn: -10 147
								setMotion: MoveTo 46 143 self
							)
						)
					)
				)
			)
			(1
				(gMenace setMotion: Chase gEgo 30 self)
			)
			(2
				(if (and (not (IsFlag 44)) (== gNewRoomNum gCurRoomNum))
					(HandsOff)
					(if (== (gEgo view:) (if (IsFlag 0) 23 else 16))
						(SetMenu 769 113 0 110 { Duck} 109 'duck')
					)
					(proc0_15 gMenace gEgo)
					((ScriptID 0 21) number: 26 loop: 1 play:) ; gameSound
					(gMenace
						setMotion: 0
						view: 101
						cel: 0
						cycleSpeed: 1
						setCycle: End self
					)
					(if (IsFlag 1)
						(Print 800 4) ; "Unfortunately, the sorcerer is immune to the magic ring's invisibility spell."
					)
				else
					(self dispose:)
				)
			)
			(3
				(gEgo
					cycleSpeed: 1
					view: 28
					cel: 0
					loop: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(4
				(Print 800 5) ; "The sorcerer casts his Paralysis Spell, freezing you to the spot. Satisfied with his deviltry, he departs, leaving you at the mercy of the forest creatures. Let's hope there are no dangerous creatures skulking about until the spell wears off."
				((ScriptID 0 21) number: 90 loop: -1 play:) ; gameSound
				(gMenace view: 102 cel: 11 setCycle: Beg)
				(gEgo loop: 1 cel: 0 cycleSpeed: 2 setCycle: End)
				(if (IsFlag 1)
					(Print 800 6) ; "The powerful spell has counteracted your own magic and removed your invisibility."
					(ClearFlag 1)
				)
				(if global138
					(gEgo setScript: (ScriptID 602 2)) ; waitAFew
					(if (== global138 803)
						(self dispose:)
					)
				else
					(= seconds 12)
				)
			)
			(5
				((ScriptID 0 23) stop:) ; backSound
				(gEgo loop: 2 cel: 0 cycleSpeed: 40 setCycle: End self)
				(gMenace setCycle: 0 hide:)
			)
			(6
				((ScriptID 0 21) loop: 1 fade:) ; gameSound
				(proc0_1)
				(gEgo loop: 2)
				(= cycles 5)
			)
			(7
				(Print 800 7) ; "The Paralysis Spell has worn off. You're free to move about again, but beware of the Sorcerer's return."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

