;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use n013)
(use RTEyeCycle)
(use Grooper)
(use Actor)

(public
	John 0
)

(local
	local0
	[local1 4] = [1019 2 1 0]
	[local5 4] = [1019 3 1 0]
	[local9 4] = [1019 4 1 0]
	[local13 4] = [1019 5 1 0]
	[local17 4] = [1019 6 1 0]
	[local21 4] = [1019 7 1 0]
	[local25 4] = [1019 8 1 0]
	[local29 4] = [1019 9 1 0]
	[local33 4] = [1019 10 1 0]
	[local37 4] = [1019 11 1 0]
	[local41 4] = [1019 12 1 0]
	[local45 4] = [1019 13 1 0]
	[local49 4] = [1019 14 1 0]
	[local53 4] = [1019 15 1 0]
	[local57 4] = [1019 16 1 0]
	[local61 4] = [1019 17 1 0]
	[local65 4] = [1019 18 1 0]
	[local69 4] = [1019 19 1 0]
	[local73 4] = [1019 20 1 0]
	[local77 4] = [1019 21 1 0]
	[local81 4] = [1019 22 1 0]
	[local85 4] = [1019 23 1 0]
	[local89 4] = [1019 24 1 0]
	[local93 4] = [1019 25 1 0]
	[local97 4] = [1019 26 1 0]
	[local101 4] = [1019 27 1 0]
)

(instance John of Actor
	(properties
		description {Little John}
		view 151
	)

	(method (init)
		(self setLoop: johnGroop)
		(super init:)
	)

	(method (dispose)
		(self setCycle: 0 setMotion: 0 actions: 0)
		(super dispose:)
		(self delete:)
		(DisposeScript 19)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if local0
					(SetMessageColor 0)
					(Say 1019 0) ; "Little John"
				else
					(= local0 1)
					(SetMessageColor 0)
					(Say 1019 1) ; "Little John is my stoutest comrade, fearless and loyal."
				)
			)
			(3 ; Do
				(Converse 1 @local1 13 0) ; "I'm here. What more do you want?"
			)
			(5 ; Talk
				(switch gDisguiseNum
					(0 ; outlaw
						(Converse 1 @local5 13 0) ; "A mug of grog would go down nicely."
					)
					(1 ; beggar
						(Converse 1 @local9 13 0) ; "I said you made a fine beggar, but of what use is such a disguise here?"
					)
					(6 ; fens monk
						(Converse 1 @local13 13 0) ; "I'd be careful wandering around the forest in that robe, Master. We might shoot first and question later."
					)
					(5 ; abbey monk
						(Converse 1 @local13 13 0) ; "I'd be careful wandering around the forest in that robe, Master. We might shoot first and question later."
					)
					(4 ; yeoman
						(switch gDay
							(8
								(Converse 1 @local17 13 0) ; "You'll have quite a challenge if you try to shoot with that eyepatch, Master. None but you could do it."
							)
							(9
								(Converse 1 @local21 13 0) ; "Eh, What's with this disguise again?"
							)
							(else
								(Converse 1 @local25 13 0) ; "A mug of grog would go down nicely."
							)
						)
					)
					(2 ; jewler (no rouge)
						(Converse 1 @local29 13 0) ; "I thought you'd be gone by now. You did take these clothes for more than a lark, didn't you?"
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(Converse 1 @local33 13 0) ; "Nay, that's yours."
					)
					(0 ; bucks
						(Converse 1 @local37 13 0) ; "I've enough of my own."
					)
					(2 ; halfHeart
						(Converse 1 @local41 13 0) ; "Isn't that the enchanted stone the Lady gave you? I wouldn't dare touch it!"
					)
					(3 ; slipper
						(Converse 1 @local45 13 0) ; "I've no use for it, Master. Aren't you going to take it to Lobb the Cobbler?"
					)
					(15 ; comb
						(Converse 1 @local49 13 0) ; "Last night you said you were to take this to the Lady Marian."
					)
					(11 ; cask
						(Converse 1 @local53 13 0) ; "I like a cask as much as any man."
						(gEgo put: 11 self) ; cask
					)
					(14 ; amethyst
						(Converse 1 @local57 13 0) ; "That's a useful thing to keep."
					)
					(12 ; puzzleBox
						(Converse 1 @local61 13 0) ; "I might give the puzzle a try around the fire tonight, if you don't mind, but not just now."
					)
					(10 ; fireRing
						(Converse 1 @local65 13 0) ; "Nay, I beg you to keep it safe. I will feel better knowing you have its protection."
					)
					(18 ; waterRing
						(Converse 1 @local65 13 0) ; "Nay, I beg you to keep it safe. I will feel better knowing you have its protection."
					)
					(13 ; robes
						(Converse 1 @local69 13 0) ; "I couldn't fit into such a little robe, even if I had a mind to, which I don't."
					)
					(5 ; pipe
						(Converse 1 @local73 13 0) ; "I'd imagine the Monk had some reason for carrying it. Best you keep it."
					)
					(6 ; gems
						(Converse 1 @local77 13 0) ; "Wonder why the Monk was carrying this around? You'd better hang on to it."
					)
					(17 ; handScroll
						(Converse 1 @local81 13 0) ; "You'd better not give this away, Robin me lad."
					)
					(16 ; fulkScroll
						(Converse 1 @local85 13 0) ; "I can't make the least sense of them. Maybe the dwarf is just mad. At any rate, I don't want his ravings."
					)
					(4 ; net
						(Converse 1 @local89 13 0) ; "This was a fine gift the Widow gave you. I don't think she'd like you giving it to anyone else."
					)
					(7 ; jewels
						(Converse 1 @local93 13 0) ; "Don't be a fool Robin! You'd better have jewelry, even fake jewelry, if you're to play the part of a jeweler."
					)
					(8 ; rouge
						(Converse 1 @local97 13 0) ; "Couldn't hurt to keep it Robin. A man should be ready for anything."
					)
					(9 ; message
						(Converse 1 @local101 13 0) ; "This is clear proof of the Prince's treachery. Y'want my advice? Give it to the Queen's knight if you ever find him."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(10 ; Longbow
				(Say 1019 28) ; "Shoot my own man? That would be madness."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance johnGroop of Grooper
	(properties)
)

