;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 471)
(include sci.sh)
(use Main)
(use Interface)
(use Actor)
(use System)

(public
	postCard 0
)

(instance postCard of Code
	(properties)

	(method (init)
		(Load rsVIEW 73)
		(super init:)
	)

	(method (doit)
		(switch global600
			(1
				(Print 471 0 #icon 73 0 2 #button {Read Back} 1 #width 100) ; "You examine one of the many interesting post cards."
				(Print
					{             Arrakis                                          Place\nA great spot for winter travel,                Stamp\nArrakis holds many delights for                Here\nthe adventurous vacationer.\nNothing can compare with a\nblinding dust storm, or being\ncrushed by a sandworm.\n\n}
					#font
					4
					#font
					999
					#width
					225
				)
			)
			(2
				(Print 471 0 #icon 73 1 1 #button {Read Back} 1 #width 100) ; "You examine one of the many interesting post cards."
				(Print
					{     Black Hole Bertha                                Place\nLike a giant interstellar                          Stamp\nvacuum, Black Hole Bertha                       Here\ncomes sweeping through the\ngalaxy. All travelers are\nadvised to stay away from Bertha.\nJust buy the post card, then\ntell everyone you went there.\n\n}
					#font
					4
					#font
					999
					#width
					225
				)
			)
			(3
				(Print 471 0 #icon 73 0 0 #button {Read Back} 1 #width 100) ; "You examine one of the many interesting post cards."
				(Print
					{             Ortega                                           Place\nThe volcanoes of Ortega are                    Stamp\nconstantly reshaping its                            Here\nsurface. Dressed in heat\nresistant underwear, the hearty\ntraveler can find a lava lovers\nparadise on this starkly\nenjoyable planet.\n\n}
					#font
					4
					#font
					999
					#width
					225
				)
			)
			(4
				(Print 471 0 #icon 73 0 3 #button {Read Back} 1 #width 100) ; "You examine one of the many interesting post cards."
				(Print
					{         RobertaLand                                    Place\nCome join the fun at the                         Stamp\nfunpark of the future!                              Here\nSee characters from your\nfavorite stories come to\nlife again and again.\nRecently revised, so don't\nmiss a single thrilling scene.\n\n}
					#font
					4
					#font
					999
					#width
					225
				)
			)
			(5
				(Print 471 0 #icon 73 1 0 #button {Read Back} 1 #width 100) ; "You examine one of the many interesting post cards."
				(Print
					{   Beta Alpha Starless Region                   Place\nLooking for some real                             Stamp\nsolitude? Come to a place                        Here\nthat's so far from everything\nthat you can't even see stars.\nMind-numbing boredom greets\nyou as you drift aimlessly\nthrough nothing. A must for the\nbrain-dead!\n\n}
					#font
					4
					#font
					999
					#width
					225
				)
			)
			(6
				(Print 471 0 #icon 73 0 1 #button {Read Back} 1 #width 100) ; "You examine one of the many interesting post cards."
				(Print
					{             Achoron                                        Place\nThe friendly creatures of                         Stamp\nAchoron are a delight for                          Here\nyoung and old alike. Tame\nenough to come right up and\ncaress you, yet wild enough to\nslash you to shreds if provoked.\n\n}
					#font
					4
					#font
					999
					#width
					225
				)
			)
		)
		(DisposeScript 471)
	)
)

(instance card of Prop ; UNUSED
	(properties)

	(method (init)
		(super init:)
		(self view: 73 setLoop: 0 setCel: 1 setPri: 15 posn: 100 53)
	)
)

