;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use n013)
(use RTEyeCycle)
(use Grooper)
(use Actor)

(public
	Alan 0
)

(local
	local0
	[local1 4] = [1021 2 1 0]
	[local5 4] = [1021 3 1 0]
	[local9 4] = [1021 4 1 0]
	[local13 4] = [1021 5 1 0]
	[local17 4] = [1021 6 1 0]
	[local21 4] = [1021 7 1 0]
	[local25 4] = [1021 8 1 0]
	[local29 4] = [1021 9 1 0]
	[local33 4] = [1021 10 1 0]
	[local37 4] = [1021 11 1 0]
	[local41 4] = [1021 12 1 0]
	[local45 4] = [1021 13 1 0]
	[local49 4] = [1021 14 1 0]
	[local53 4] = [1021 15 1 0]
	[local57 4] = [1021 16 1 0]
	[local61 4] = [1021 17 1 0]
	[local65 4] = [1021 18 1 0]
	[local69 4] = [1021 19 1 0]
	[local73 4] = [1021 20 1 0]
	[local77 4] = [1021 21 1 0]
	[local81 4] = [1021 22 1 0]
	[local85 4] = [1021 23 1 0]
	[local89 4] = [1021 24 1 0]
	[local93 5] = [1021 25 1 1 0]
	[local98 4] = [1021 27 1 0]
)

(instance Alan of Actor
	(properties
		description {Alan-a-dale}
		view 157
	)

	(method (init)
		(self setLoop: alanGroop)
		(super init:)
	)

	(method (dispose)
		(self setCycle: 0 setMotion: 0 actions: 0)
		(super dispose:)
		(self delete:)
		(DisposeScript 21)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if local0
					(SetMessageColor 0)
					(Say 1021 0) ; "Alan-a-dale"
				else
					(= local0 1)
					(SetMessageColor 0)
					(Say 1021 1) ; "Our bard, a lad of lively wit and golden voice, Alan-a-dale."
				)
			)
			(3 ; Do
				(Converse 1 @local1 16 0) ; "Oh, did you want to play my lute? Nay, Master, the tune you play upon one string is music enough."
			)
			(5 ; Talk
				(switch gDisguiseNum
					(1 ; beggar
						(Converse 1 @local5 16 0) ; "Ah, Master Hood, if this bit of adventure goes well, what a fine song I can make of it."
					)
					(5 ; abbey monk
						(Converse 1 @local9 16 0) ; "Remember to look solemn and don't go around singing bawdy songs."
					)
					(6 ; fens monk
						(Converse 1 @local9 16 0) ; "Remember to look solemn and don't go around singing bawdy songs."
					)
					(4 ; yeoman
						(switch gDay
							(8
								(Converse 1 @local13 16 0) ; "You've a great day of adventure before you. Why do you waste it here?"
							)
							(else
								(Converse 1 @local17 16 0) ; "Is this a reminder to compose my lyrics of your exploits as "Puck"?"
							)
						)
					)
					(2 ; jewler (no rouge)
						(Converse 1 @local21 16 0) ; "You look ready Robin. The question is -- ready for what?"
					)
					(3 ; jewler (rouge)
						(Converse 1 @local21 16 0) ; "You look ready Robin. The question is -- ready for what?"
					)
					(else
						(Converse 1 @local25 16 0) ; "You can take the maid out of the maidenhead, but man will always be in woman."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(Converse 1 @local29 16 0) ; "Horn isn't my instrument. My lips are made for singing and kissing."
					)
					(0 ; bucks
						(Converse 1 @local33 16 0) ; "No need to pay me, Robin. I can always busk in town for a few coins, if I'm in need."
					)
					(2 ; halfHeart
						(Converse 1 @local37 16 0) ; "If such a lady gives you a part of her heart, methinks you should keep it close to your own."
					)
					(3 ; slipper
						(Converse 1 @local41 16 0) ; "Merry thanks, but it doesn't match my outfit."
					)
					(15 ; comb
						(Converse 1 @local45 16 0) ; "This silver comb best belongs in raven tresses."
					)
					(11 ; cask
						(Converse 1 @local49 16 0) ; "Nay, keep it. I prefer wine."
					)
					(14 ; amethyst
						(Converse 1 @local53 16 0) ; "This would keep me out of my cups! But you may need it more than I."
					)
					(12 ; puzzleBox
						(Converse 1 @local57 16 0) ; "This is a pretty puzzle indeed. I'll give it some thought, but I've enough to carry around as it is."
					)
					(10 ; fireRing
						(Converse 1 @local61 16 0) ; "It would sparkle well upon my finger, but sit uneasily upon my thoughts. Keep it."
					)
					(18 ; waterRing
						(Converse 1 @local61 16 0) ; "It would sparkle well upon my finger, but sit uneasily upon my thoughts. Keep it."
					)
					(13 ; robes
						(Converse 1 @local65 16 0) ; "Wouldn't I look funny, the Singing Monk! Nay, I'll keep my own plumage."
					)
					(5 ; pipe
						(Converse 1 @local69 16 0) ; "It's not a true musical instrument, just a poor bit of a noisemaker."
					)
					(6 ; gems
						(Converse 1 @local73 16 0) ; "They're lovely stones. Maybe the Monks barter with them. I'll stick to bartering with my music, thanks just the same."
					)
					(17 ; handScroll
						(Converse 1 @local77 16 0) ; "Nay, I'll not lay hands upon it."
					)
					(16 ; fulkScroll
						(Converse 1 @local81 16 0) ; "His rhyme fails to inspire me. Keep those if you want. I'd prefer to write my own."
					)
					(4 ; net
						(Converse 1 @local85 16 0) ; "Enmesh me not in yon net, or I'll be nettled."
					)
					(7 ; jewels
						(Converse 1 @local89 16 0) ; "By my troth, these jewels look the part. And so do you. And isn't it time for these jewels to part another fool from his money?"
					)
					(8 ; rouge
						(Converse 1 @local93 16 0) ; "Red were my true love's lips the day she left me, red the colour of the rose and red the blood where it pricked me. Red the nose of the drunkard--"
					)
					(9 ; message
						(Converse 1 @local98 16 0) ; "You'll find a good use for it before I will, Robin."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(10 ; Longbow
				(Say 1021 28) ; "Shoot my own man? That would be madness."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance alanGroop of Grooper
	(properties)
)

