;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 534)
(include sci.sh)
(use Main)
(use n013)
(use RTEyeCycle)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Harry 0
)

(local
	[local0 9] = [541 0 2 4 22 31 25 23 5]
	[local9 4] = [1534 1 1 0]
	[local13 4] = [1534 16 1 0]
	[local17 4] = [1534 17 1 0]
	[local21 6] = [1534 13 2 1 2 0]
	[local27 4] = [1534 12 1 0]
	[local31 9] = [1534 2 1 2 2 2 2 1 0]
	[local40 5] = [1534 10 2 1 0]
	[local45 5] = [1534 8 2 1 0]
	[local50 4] = [1534 30 1 0]
	[local54 6] = [1534 23 2 1 2 0]
	[local60 4] = [1534 18 1 0]
	[local64 6] = [1534 19 1 2 1 0]
	[local70 4] = [1534 22 1 0]
	[local74 4] = [1534 27 1 0]
	[local78 4] = [1534 29 1 0]
	[local82 4] = [1534 28 1 0]
	local86
)

(instance Harry of Prop
	(properties
		x 248
		y 183
		approachX 190
		approachY 175
		view 537
		priority 15
		signal 18448
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setScript: hDrink approachVerbs: 5 4 3) ; Talk, Inventory, Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1534 0) ; "This poor old fellow looks as though he's led a hard life and seeks to forget it with a jug or two of nut-brown ale."
			)
			(5 ; Talk
				(cond
					((gEgo has: 14) ; amethyst
						(Converse @local13 @local0) ; "No more games. Ye've won enough from me."
					)
					((IsFlag 124)
						(Converse @local17 @local0) ; "Go away, Monk. I don't like ye and I'm not a'playin' no Morris with ye."
					)
					((== gPrevRoomNum 540)
						(if local86
							(Converse @local21 999 @local0 self) ; "Make up yer mind. Ye're becomin' a bloody nuisance hangin' about."
						else
							(= local86 1)
							(Converse @local27 @local0) ; "No need to run off, Monk. I'm ready t'play ye again, if ye've coins to wager."
						)
					)
					(local86
						(Converse @local40 999 @local0 self) ; "You still 'considering', Monk?"
					)
					((IsFlag 167)
						(Converse @local45 999 @local0 self) ; "Found the courage for a game this time, Monk?"
					)
					(else
						(= local86 1)
						(SetFlag 167)
						(Converse @local31 999 @local0) ; "You've the look of a man who's been to foreign lands."
					)
				)
			)
			(3 ; Do
				(cond
					((gEgo has: 14) ; amethyst
						(Converse @local13 @local0) ; "No more games. Ye've won enough from me."
					)
					((IsFlag 124)
						(Converse @local17 @local0) ; "Go away, Monk. I don't like ye and I'm not a'playin' no Morris with ye."
					)
					(else
						(Converse @local9 @local0) ; "This is my seat. Go sit over there, if you've a mind to play Morris wit'me."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(cond
							((gEgo has: 14) ; amethyst
								(Converse @local13 @local0) ; "No more games. Ye've won enough from me."
							)
							((IsFlag 124)
								(Converse @local60 @local0) ; "I don't want your silver, Monk. Leave me be."
							)
							(else
								(Converse @local64 @local0 999) ; "If you mean to wager a game of Morris, come and sit down."
							)
						)
					)
					(11 ; cask
						(if (IsFlag 124)
							(Converse @local50 @local0) ; "I want nothing from you, Monk. Leave me be."
						else
							(Converse @local54 999 @local0) ; "That's the Innkeeper's and he'll be wanting it back when you're done with it."
						)
					)
					(2 ; halfHeart
						(if (IsFlag 124)
							(Converse @local50 @local0) ; "I want nothing from you, Monk. Leave me be."
						else
							(Converse @local70 @local0) ; "If you've somethin' to wager, sit down and let's do this proper like."
						)
					)
					(14 ; amethyst
						(Converse @local74 @local0) ; "Don't be a fool. Ye've won it fair enough. I'll not take it back as charity or as a wager."
					)
					(13 ; robes
						(Converse @local78 @local0) ; "Ye'll never get me to take the vows."
					)
					(12 ; puzzleBox
						(Converse @local82 @local0) ; "I don't need no fancy box."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (cue)
		(gCurRoom newRoom: 540)
	)
)

(instance hDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 18))
			)
			(1
				(Harry setCycle: End self)
			)
			(2
				(= ticks (Random 20 60))
			)
			(3
				(Harry setCycle: Beg self)
			)
			(4
				(mugSound play:)
				(= cycles 1)
				(= state -1)
			)
		)
	)
)

(instance mugSound of Sound
	(properties
		flags 1
		number 457
	)
)

