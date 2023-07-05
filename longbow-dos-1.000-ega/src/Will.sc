;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use n013)
(use RTEyeCycle)
(use Grooper)
(use Actor)

(public
	Will 0
)

(local
	local0
	[local1 4] = [1020 2 1 0]
	[local5 4] = [1020 3 1 0]
	[local9 4] = [1020 4 1 0]
	[local13 4] = [1020 5 1 0]
	[local17 4] = [1020 6 1 0]
	[local21 4] = [1020 7 1 0]
	[local25 4] = [1020 8 1 0]
	[local29 4] = [1020 9 1 0]
	[local33 4] = [1020 10 1 0]
	[local37 4] = [1020 11 1 0]
	[local41 4] = [1020 12 1 0]
	[local45 4] = [1020 13 1 0]
	[local49 4] = [1020 14 1 0]
	[local53 4] = [1020 15 1 0]
	[local57 4] = [1020 16 1 0]
	[local61 4] = [1020 17 1 0]
	[local65 4] = [1020 18 1 0]
	[local69 4] = [1020 19 1 0]
	[local73 4] = [1020 20 1 0]
	[local77 4] = [1020 21 1 0]
	[local81 4] = [1020 22 1 0]
	[local85 4] = [1020 23 1 0]
	[local89 4] = [1020 24 1 0]
	[local93 4] = [1020 25 1 0]
	[local97 4] = [1020 26 1 0]
)

(instance Will of Actor
	(properties
		description {Will Scarlet}
		view 160
	)

	(method (init)
		(self setLoop: willGroop)
		(super init:)
	)

	(method (dispose)
		(self setCycle: 0 setMotion: 0 actions: 0)
		(super dispose:)
		(self delete:)
		(DisposeScript 20)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if local0
					(SetMessageColor 0)
					(Say 1020 0) ; "Will Scarlet"
				else
					(SetMessageColor 0)
					(Say 1020 1) ; "Will Scarlet is an old and experienced outlaw, knows forest lore better than any of us, and is a formidable bowman."
					(= local0 1)
				)
			)
			(3 ; Do
				(Converse 1 @local1 14 0) ; "If you need my help, you'll have it."
			)
			(5 ; Talk
				(switch gDisguiseNum
					(1 ; beggar
						(Converse 1 @local5 14 0) ; "Most amusing...for a while. It seems to me you had more important things to do."
					)
					(5 ; abbey monk
						(Converse 1 @local9 14 0) ; "I know you need the disguise, Robin, but the sooner you're done with it the better. Tuck's the only monk I've meet that was worth a farthing."
					)
					(6 ; fens monk
						(Converse 1 @local9 14 0) ; "I know you need the disguise, Robin, but the sooner you're done with it the better. Tuck's the only monk I've meet that was worth a farthing."
					)
					(4 ; yeoman
						(switch gDay
							(8
								(Converse 1 @local13 14 0) ; "Why're you wandering around here, Master "Puck"?"
							)
							(9
								(Converse 1 @local17 14 0) ; "Why're you wearing that again?"
							)
						)
					)
					(2 ; jewler (no rouge)
						(Converse 1 @local21 14 0) ; "Time's a wasting. You'll not get much done in those clothes around here."
					)
					(else
						(Converse 1 @local25 14 0) ; "A haunch of venison would taste good about now."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(Converse 1 @local29 14 0) ; "I've my own horn, Robin. You'll need yours."
					)
					(0 ; bucks
						(Converse 1 @local33 14 0) ; "Be generous to those in greater need than me."
					)
					(2 ; halfHeart
						(Converse 1 @local37 14 0) ; "I've no wish to touch something that came out of a dream."
					)
					(3 ; slipper
						(Converse 1 @local41 14 0) ; "One slipper isn't worth much....except to Lobb the Cobbler."
					)
					(15 ; comb
						(Converse 1 @local45 14 0) ; "Lobb said you are to take it to Marian. Not me."
					)
					(11 ; cask
						(Converse 1 @local49 14 0) ; "No need to give it to me. Friar Tuck sees to such things."
					)
					(14 ; amethyst
						(Converse 1 @local53 14 0) ; "I don't much care to touch magical things."
					)
					(12 ; puzzleBox
						(Converse 1 @local57 14 0) ; "Not the sort of thing I want to carry around, Robin."
					)
					(10 ; fireRing
						(Converse 1 @local61 14 0) ; "I've no wish to have such an ensorcelled thing. But it's good that you have it, for you may have need of it."
					)
					(18 ; waterRing
						(Converse 1 @local61 14 0) ; "I've no wish to have such an ensorcelled thing. But it's good that you have it, for you may have need of it."
					)
					(13 ; robes
						(Converse 1 @local65 14 0) ; "Fie, You'd never catch me in a monk's robe. I'd feel a fool. Uh, no offense meant, Robin."
					)
					(5 ; pipe
						(Converse 1 @local69 14 0) ; "Nay, I've no use for it. Wonder why the monk had it?"
					)
					(6 ; gems
						(Converse 1 @local73 14 0) ; "Keep the stones. They must have a use. Those Monks don't seem to carry anything unless it has a use."
					)
					(17 ; handScroll
						(Converse 1 @local77 14 0) ; "Best do as the Lady instructed you, Robin."
					)
					(16 ; fulkScroll
						(Converse 1 @local81 14 0) ; "I've enough gear to worry about without carrying some jester's doggerel around."
					)
					(4 ; net
						(Converse 1 @local85 14 0) ; "The widow had good reason to give you the net and not me, so let it be."
					)
					(7 ; jewels
						(Converse 1 @local89 14 0) ; "Gaudy bits of rubbish, they are. I'm sure you can find a better use for them than giving them to me."
					)
					(8 ; rouge
						(Converse 1 @local93 14 0) ; "Wonder how well it'd work on cleaning arowwheads? If you've any left over later, I'll give it a try."
					)
					(9 ; message
						(Converse 1 @local97 14 0) ; "Beware who else you show this letter. Keep it hidden until the right moment, is my advise."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(10 ; Longbow
				(Say 1020 27) ; "Shoot my own man? That would be madness."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance willGroop of Grooper
	(properties)
)

