;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 306)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	readBook 0
	readNote 1
)

(instance readBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(Print 306 0 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "In thy face I see The map of honor, truth, and loyalty."
			)
			(2
				(Print 306 1 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "Forbear to judge, for we are sinners all. Close up his eyes and draw the curtain close; And let us all to meditation."
			)
			(3
				(Print 306 2 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "No beast so fierce but knows some touch of pity."
			)
			(4
				(Print 306 3 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "Look, how my ring encompasseth thy finger, Even so thy breast encloseth my poor heart; Wear both of them, for both of them are thine."
			)
			(5
				(Print 306 4 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "The world is grown so bad, That wrens make prey where eagles dare not perch."
			)
			(6
				(Print 306 5 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "O, I have passed a miserable night, So full of ugly sights, of ghastly dreams, That, as I am a Christian faithful man, I would not spend another such a night, Though 'twere to buy a world of happy days."
			)
			(7
				(Print 306 6 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "Is the chair empty? Is the sword unswayed? Is the king dead? The empire unpossessed?"
			)
			(8
				(Print 306 7 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "A horse! A horse! My kingdom for a horse!"
			)
			(9
				(Print 306 8 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "Tut! I have done a thousand dreadful things As willingly as one would kill a fly."
			)
			(10
				(Print 306 9 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "Kiss me, Kate, we will be married o' Sunday."
			)
			(11
				(Print 306 10 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "He jests at scars, that never felt a wound. But, soft! what light through yonder window breaks? It is the east, and Juliet is the sun!"
			)
			(12
				(Print 306 11 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "See! how she leans her cheek upon her hand: O! that I were a glove upon that hand, That I might touch that cheek."
			)
			(13
				(Print 306 12 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "O Romeo, Romeo! wherefore art thou Romeo? Deny thy father, and refuse thy name; Or, if thou wilt not, be but sworn my love, And I'll no longer be a Capulet."
			)
			(14
				(Print 306 13 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "What's in a name? That which we call a rose by any other name would smell as sweet."
			)
			(15
				(Print 306 14 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "This bud of love, by summer's ripening breath, May prove a beauteous flower when next we meet."
			)
			(16
				(Print 306 15 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "Good night, good night! Parting is such sweet sorrow, That I shall say good night till it be morrow."
			)
			(17
				(Print 306 16 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "Of comfort no man speak: Let's talk of graves, of worms, and epitaphs; Make dust our paper, and with rainy eyes Write sorrow on the bosom of the earth; Let's choose executors and talk of wills."
			)
			(18
				(Print 306 17 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "You may my glories and my state depose, But not my griefs; still am I king of those."
			)
			(19
				(Print 306 18 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "How sour sweet music is when time is broke and no proportion kept! So is it in the music of men's lives."
			)
			(20
				(Print 306 19 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "Love looks not with the eyes, but with the mind, And therefore is winged Cupid painted blind."
			)
			(21
				(Print 306 20 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "I am that merry wanderer of the night. I jest to Oberon, and make him smile When I a fat and bean-fed horse beguile, Neighing in likeness of a filly foal: And sometimes lurk I in a gossip's bowl, In very likeness of a roasted crab."
			)
			(22
				(Print 306 21 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "You spotted snakes with double tongue, Thorny hedge-hogs, be not seen; Newts, and blind-worms, do no wrong; Come not near our fairy queen."
			)
			(23
				(Print 306 22 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "How oft the sight of means to do ill deeds Makes ill deeds done!"
			)
			(24
				(Print 306 23 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "I am amazed, methinks, and lose my way Among the thorns and dangers of this world."
			)
			(25
				(Print 306 24 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "The day shall not be up so soon as I, To try the fair adventure of tomorrow."
			)
			(26
				(Print 306 25 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "How far that little candle throws his beams! So shines a good deed in a naughty world!"
			)
			(27
				(Print 306 26 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "Bell, book and candle shall not drive me back."
			)
			(28
				(Print 306 27 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "To hold, as 'twere, the mirror up to nature; to show virtue her own feature, scorn her own image, and the very age and body of the time his form and pressure."
			)
			(29
				(Print 306 28 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "The lady doth protest too much, methinks."
			)
			(30
				(Print 306 29 #font gSmallFont #mode 1 #at -1 15 #width 290) ; "'Tis now the very witching time of night, When churchyards yawn and hell itself breathes out Contagion to this world."
			)
		)
		(DisposeScript 306)
	)
)

(instance readNote of Script
	(properties)

	(method (cue)
		(switch (Random 1 9)
			(1
				(Print 306 30) ; "Help! The girls in "Leisure-Suit Larry in the Land of the Lounge Lizards" are mighty uncooperative. Give me some help here, guys!"
			)
			(2
				(Print 306 31) ; "I see a beautiful mermaid in "King's Quest II," but she won't help me! Tell me what to do!"
			)
			(3
				(Print 306 32) ; "Anybody out there! I had a condor drop this bottle in the nearest ocean to beg for help with "King's Quest I." Help me fight this fire-breathing dragon!"
			)
			(4
				(Print 306 33) ; "Help! I'm about to get blasted by evil Sariens in "Space Quest!" Anybody have a handy ray gun out there?!"
			)
			(5
				(Print 306 34) ; "Sludge Vohaul is holding me prisoner in "Space Quest II!" Help me out of this jam!"
			)
			(6
				(Print 306 35) ; "Drug dealers are terrorizing the city of Lytton! I need a partner to help put away these bad guys in "Police Quest!""
			)
			(7
				(Print 306 36) ; "Hey, I need help here! The wicked Horned King has had me thrown into his dungeon! If I don't get out of here, then evil will rule the world in "The Black Cauldron!""
			)
			(8
				(Print 306 37) ; "Help me! I'm lost at sea in "King's Quest III!" I'm with a bunch of nasty pirates who want to feed me to the sharks! If you can, come quick!"
			)
			(9
				(Print 306 38) ; "I'm a little kid, and my name's Tommy. I'm having trouble with Old King Cole and Humpty Dumpty in "Mixed-Up Mother Goose!" Come and help me!"
			)
			(10
				(Print 306 39) ; "Oh, no! Help me!! I'm stranded on an airplane with a guy named Ken, being chased by the KGB and an evil army of henchettes, former church secretaries, game show hostesses, and bimbos. Buy "Leisure Suit Larry Goes Looking For Love (in Several Wrong Places.)""
			)
		)
		(DisposeScript 306)
	)
)

