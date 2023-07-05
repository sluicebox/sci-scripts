;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use n013)
(use RTEyeCycle)
(use Grooper)
(use Actor)

(public
	Much 0
)

(local
	local0
	local1
	[local2 4] = [1022 2 1 0]
	[local6 4] = [1022 3 1 0]
	[local10 4] = [1022 4 1 0]
	[local14 4] = [1022 5 1 0]
	[local18 4] = [1022 6 1 0]
	[local22 4] = [1022 7 1 0]
	[local26 4] = [1022 8 1 0]
	[local30 4] = [1022 9 1 0]
	[local34 4] = [1022 10 1 0]
	[local38 4] = [1022 11 1 0]
	[local42 4] = [1022 12 1 0]
	[local46 4] = [1022 13 1 0]
	[local50 4] = [1022 14 1 0]
	[local54 4] = [1022 15 1 0]
	[local58 4] = [1022 16 1 0]
	[local62 4] = [1022 17 1 0]
	[local66 4] = [1022 18 1 0]
	[local70 4] = [1022 19 1 0]
	[local74 4] = [1022 20 1 0]
	[local78 4] = [1022 21 1 0]
	[local82 4] = [1022 22 1 0]
	[local86 4] = [1022 23 1 0]
	[local90 4] = [1022 24 1 0]
	[local94 4] = [1022 25 1 0]
	[local98 4] = [1022 26 1 0]
)

(instance Much of Actor
	(properties
		description {Much}
		view 163
	)

	(method (init)
		(self setLoop: muchGroop)
		(super init:)
	)

	(method (dispose)
		(self setCycle: 0 setMotion: 0 actions: 0)
		(super dispose:)
		(self delete:)
		(DisposeScript 22)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if local0
					(SetMessageColor 0)
					(Say 1022 0) ; "Much"
				else
					(SetMessageColor 0)
					(Say 1022 1) ; "Much the Miller's son is second in strength only to Little John. Not an overly bright lad, but brave and true."
					(= local0 1)
				)
			)
			(3 ; Do
				(Converse 1 @local2 17 0) ; "Did you want something? I don't understand."
			)
			(5 ; Talk
				(switch gDisguiseNum
					(1 ; beggar
						(Converse 1 @local6 17 0) ; "If I didn't know it was you, I'd give you money."
					)
					(5 ; abbey monk
						(if local1
							(Converse 1 @local18 17 0) ; "You don't fool me. I know it's you."
						else
							(= local1 1)
							(Converse 1 @local10 17 0) ; "Oh, it's you. Um...you're not wearing that for good, are you?"
						)
					)
					(6 ; fens monk
						(if local1
							(Converse 1 @local18 17 0) ; "You don't fool me. I know it's you."
						else
							(= local1 1)
							(Converse 1 @local10 17 0) ; "Oh, it's you. Um...you're not wearing that for good, are you?"
						)
					)
					(4 ; yeoman
						(if (and (== gDay 8) (not local1))
							(= local1 1)
							(Converse 1 @local14 17 0) ; "Ho, stranger, what're you -- oh, Robin. Sorry, I forgot that was you."
						else
							(Converse 1 @local18 17 0) ; "You don't fool me. I know it's you."
						)
					)
					(2 ; jewler (no rouge)
						(Converse 1 @local22 17 0) ; "When you're done with those, I'd sure like to give them to my family."
					)
					(3 ; jewler (rouge)
						(Converse 1 @local22 17 0) ; "When you're done with those, I'd sure like to give them to my family."
					)
					(else
						(Converse 1 @local26 17 0) ; "Umm...er...can't think of anything to say, sir."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(Converse 1 @local30 17 0) ; "Aw, nay, I can't take that."
					)
					(0 ; bucks
						(if (> (gMoney doit:) 0)
							(Converse 1 @local34 17 0) ; "Oh, Thank you, sir. I'll take it to my family."
						)
					)
					(2 ; halfHeart
						(Converse 1 @local38 17 0) ; "Nay, I couldn't take such a thing."
					)
					(3 ; slipper
						(Converse 1 @local42 17 0) ; "Um...no thanks."
					)
					(15 ; comb
						(Converse 1 @local46 17 0) ; "Uh..I could give it to my sister...but I better not."
					)
					(11 ; cask
						(Converse 1 @local50 17 0) ; "My father does do a little brewin' on the side. I'll take it to him."
						(gEgo put: 11 self) ; cask
					)
					(14 ; amethyst
						(Converse 1 @local54 17 0) ; "Nay, I couldn't take it."
					)
					(12 ; puzzleBox
						(Converse 1 @local58 17 0) ; "Umm...I wouldn't know what to do with it. I mean I can't even open it like a regular box."
					)
					(10 ; fireRing
						(Converse 1 @local62 17 0) ; "That's much too fine a thing for me to touch."
					)
					(18 ; waterRing
						(Converse 1 @local62 17 0) ; "That's much too fine a thing for me to touch."
					)
					(13 ; robes
						(Converse 1 @local66 17 0) ; "I wouldn't know what to do with monks' robes!"
					)
					(5 ; pipe
						(Converse 1 @local70 17 0) ; "Don't seem of much use to me."
					)
					(6 ; gems
						(Converse 1 @local74 17 0) ; "Maybe the Monks use them in slingshots. Here, you keep it."
					)
					(17 ; handScroll
						(Converse 1 @local78 17 0) ; "Can't think what I'd do with it."
					)
					(16 ; fulkScroll
						(Converse 1 @local82 17 0) ; "Nay, I don't know how to read."
					)
					(4 ; net
						(Converse 1 @local86 17 0) ; "Oh, I couldn't take it."
					)
					(7 ; jewels
						(Converse 1 @local90 17 0) ; "My sisters sure would like such pretty stuff. Maybe when you're done with them, then I could have them."
					)
					(8 ; rouge
						(Converse 1 @local94 17 0) ; "Uh..well...no thanks."
					)
					(9 ; message
						(Converse 1 @local98 17 0) ; "Don't give it to me! I wouldn't know what to do with it."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(10 ; Longbow
				(Say 1022 27) ; "Shoot my own man? That would be madness."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance muchGroop of Grooper
	(properties)
)

