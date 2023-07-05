;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use n013)
(use RTEyeCycle)
(use Grooper)
(use Actor)

(public
	Tuck 0
)

(local
	local0
	local1
	[local2 4] = [1023 2 1 0]
	[local6 4] = [1023 3 1 0]
	[local10 4] = [1023 4 1 0]
	[local14 4] = [1023 5 1 0]
	[local18 4] = [1023 6 1 0]
	[local22 4] = [1023 7 1 0]
	[local26 4] = [1023 8 1 0]
	[local30 4] = [1023 9 1 0]
	[local34 4] = [1023 10 1 0]
	[local38 4] = [1023 11 1 0]
	[local42 4] = [1023 12 1 0]
	[local46 4] = [1023 13 1 0]
	[local50 4] = [1023 14 1 0]
	[local54 4] = [1023 15 1 0]
	[local58 4] = [1023 16 1 0]
	[local62 4] = [1023 17 1 0]
	[local66 4] = [1023 18 1 0]
	[local70 4] = [1023 19 1 0]
	[local74 4] = [1023 20 1 0]
	[local78 5] = [1023 21 1 1 0]
	[local83 4] = [1023 23 1 0]
	[local87 4] = [1023 24 1 0]
	[local91 4] = [1023 25 1 0]
	[local95 4] = [1023 26 1 0]
	[local99 4] = [1023 27 1 0]
	[local103 4] = [1023 28 1 0]
	[local107 4] = [1023 29 1 0]
	[local111 4] = [1023 30 1 0]
	[local115 4] = [1023 31 1 0]
)

(instance Tuck of Actor
	(properties
		description {Friar Tuck}
		view 154
	)

	(method (init)
		(self setLoop: tuckGroop)
		(super init:)
	)

	(method (dispose)
		(self setCycle: 0 setMotion: 0 actions: 0)
		(super dispose:)
		(self delete:)
		(DisposeScript 23)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if local0
					(SetMessageColor 0)
					(Say 1023 0) ; "Friar Tuck"
				else
					(= local0 1)
					(SetMessageColor 0)
					(Say 1023 1) ; "The redoubtable Tuck, though a curtal Friar and therefore a man of God, is renowned for his skill with the sword."
				)
			)
			(3 ; Do
				(cond
					(local1
						(= local1 0)
						(Converse 1 @local2 15 0) ; "Do you want the box back? Here."
						(gEgo get: 12) ; puzzleBox
					)
					((== ((gInventory at: 12) owner:) self) ; puzzleBox
						(Converse 1 @local6 15 0) ; "If you're looking for the puzzle box, I've put it inside your chest for safekeeping."
					)
					(else
						(switch gDisguiseNum
							(1 ; beggar
								(Converse 1 @local10 15 0) ; "Your disguise is most convincing, Robin. But why do you waste time here?"
							)
							(6 ; fens monk
								(Converse 1 @local14 15 0) ; "Now try to look pious and get that sparkle out of your eye if you want to fool the other monks."
							)
							(5 ; abbey monk
								(Converse 1 @local14 15 0) ; "Now try to look pious and get that sparkle out of your eye if you want to fool the other monks."
							)
							(4 ; yeoman
								(switch gDay
									(8
										(Converse 1 @local18 15 0) ; "Eh? Weren't you on the way to the Fair?"
									)
									(9
										(Converse 1 @local22 15 0) ; "Having fun as "Puck", are we?"
									)
									(else
										(Converse 1 @local26 15 0) ; "Paululum sursum et dextrorsum."
									)
								)
							)
							(2 ; jewler (no rouge)
								(Converse 1 @local30 15 0) ; "Did you forget something, Robin? I can't imagine what."
							)
							(3 ; jewler (rouge)
								(Converse 1 @local34 15 0) ; "Robin! I barely recognized you with that red beard."
							)
							(else
								(Converse 1 @local26 15 0) ; "Paululum sursum et dextrorsum."
							)
						)
					)
				)
			)
			(5 ; Talk
				(cond
					(local1
						(= local1 0)
						(Converse 1 @local2 15 0) ; "Do you want the box back? Here."
					)
					((== ((gInventory at: 12) owner:) self) ; puzzleBox
						(Converse 1 @local6 15 0) ; "If you're looking for the puzzle box, I've put it inside your chest for safekeeping."
					)
					(else
						(Converse 1 @local38 15 0) ; "Domine dirige nos."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(Converse 1 @local42 15 0) ; "How will you call us without it?"
					)
					(0 ; bucks
						(Converse 1 @local46 15 0) ; "I wouldn't return that to the Treasury just yet. You may want it."
					)
					(2 ; halfHeart
						(Converse 1 @local50 15 0) ; "I could put it in the Treasury, but I believe you are meant to keep it close to you, Robin."
					)
					(3 ; slipper
						(Converse 1 @local54 15 0) ; "Well, Lobb said he wanted a lady's slipper. But it's not me he wants to see, it's you."
					)
					(15 ; comb
						(Converse 1 @local58 15 0) ; "It's worth a penny or two, but you've another use for it."
					)
					(11 ; cask
						(Converse 1 @local62 15 0) ; "Ah, this will be very useful around the camp."
						(gEgo put: 11 self) ; cask
					)
					(14 ; amethyst
						(Converse 1 @local66 15 0) ; "Keep it. Put this into a mug or goblet, and it'll keep you sober, no matter how much you drink."
					)
					(12 ; puzzleBox
						(Converse 1 @local70 15 0) ; "It is a clumsy sort of thing to carry around, isn't it? I'll take care of it for you."
						(gEgo put: 12 self) ; puzzleBox
						(= local1 1)
					)
					(10 ; fireRing
						(Converse 1 @local74 15 0) ; "I could put it into the Treasury, but I think you should keep it on your person for protection."
					)
					(18 ; waterRing
						(Converse 1 @local74 15 0) ; "I could put it into the Treasury, but I think you should keep it on your person for protection."
					)
					(13 ; robes
						(if (< gDay 7)
							(Converse 1 @local78 15 0) ; "I'm not of that Order, but such good fabric could make useful clothing for poorer folk."
						else
							(Converse 1 @local83 15 0) ; "This material will make good clothes for some poor folk,"
							(gEgo put: 13) ; robes
						)
					)
					(5 ; pipe
						(Converse 1 @local87 15 0) ; "Better take it with you, just in case."
					)
					(6 ; gems
						(Converse 1 @local91 15 0) ; "It has a small value, but I suggest you keep it for the time being."
					)
					(17 ; handScroll
						(Converse 1 @local95 15 0) ; "You know better than I what to do with this."
					)
					(16 ; fulkScroll
						(Converse 1 @local99 15 0) ; "If Fulk wanted you to have his verses, then you should have them."
					)
					(4 ; net
						(Converse 1 @local103 15 0) ; "Nay, it was given to you, but when you catch the imp, ask it to bring King Richard back to us."
					)
					(7 ; jewels
						(Converse 1 @local107 15 0) ; "Too bad they're only bits of glass, convincing as they are. They'd have made a fine addition to the Treasury otherwise."
					)
					(8 ; rouge
						(Converse 1 @local111 15 0) ; "I suppose I could find a use for it, but I'd rather you kept it for now."
					)
					(9 ; message
						(Converse 1 @local115 15 0) ; "Keep it safe. Prince John would not be happy to learn the outlaws of Sherwood Forest had such a paper."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(10 ; Longbow
				(Say 1023 32) ; "Shoot my own man? That would be madness."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tuckGroop of Grooper
	(properties)
)

