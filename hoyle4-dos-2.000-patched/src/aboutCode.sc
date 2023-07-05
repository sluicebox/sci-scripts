;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Print)
(use File)
(use System)

(public
	aboutCode 0
)

(local
	[local0 50]
	[local50 50]
	[local100 50]
	[local150 50]
)

(instance aboutCode of Code
	(properties)

	(method (init &tmp [temp0 500] [temp500 500] [temp1000 100])
		(version doit:)
		(phone_txt doit:)
		(= global122 4)
		(Message msgGET 4 0 0 0 1 @temp500) ; "Welcome to  |f2||c2|Hoyle Classic Card Games|f||c|"
		(StrCat @temp500 @local0)
		(if (Print addText: @temp500 init:)
			(Message msgGET 4 0 0 0 2 @temp500) ; "For those who love board games, |f2||c3|Hoyle Book of Games, Volume 3|f||c| will satisfy the entire family. Play Backgammon on a beautiful marble board. Have a game of Checkers against some very worthy opponents from other Sierra games. The kids will love using frogs as Checkers pieces. Also included are Pachisi, Yacht,  Dominoes, and for the very young Snakes and Ladders."
			(if (Print addText: @temp500 init:)
				(Message msgGET 4 0 0 0 3 @temp500) ; "We can't give you one solitairy reason for buying |f2||c3|Hoyle Book of Games, Volume 2: Solitaire|f||c| We can give you 28! All of the standard solitaires are included: Klondike, Canfield, Pyramid, Golf and many, many more. Also included in Hoyle 2 Solitaire are two completely original solitaires that can only be found in this collection: Bowling and Slide."
				(if (Print addText: @temp500 init:)
					(Message msgGET 4 0 0 0 4 @temp500) ; "To order either  Hoyle Volume 2: Solitaire, or Hoyle Volume 3: Board Games, call Sierra at"
					(StrCat @temp500 @local50)
					(StrCat @temp500 {\n})
					(Message msgGET 4 0 0 0 19 @temp1000) ; "Outside U.S.A call"
					(StrCat @temp500 @temp1000)
					(StrCat @temp500 @local100)
					(if (Print addText: @temp500 init:)
						(Message msgGET 4 0 0 0 5 @temp500) ; "|f2||c2|Check out The Sierra Network!|f||c| TSN is an on-line, multi-player game network with high-end graphics and the kind of quality gameplay you'd expect from Sierra. TSN lets people from all over the country get together to play over 20 games, chat, or make new friends |f2||c3|in real-time|f||c|. For information, call"
						(StrCat @temp500 @local150)
						(if (Print addText: @temp500 init:)
							(Message msgGET 4 0 0 0 8 @temp500) ; "|f2||c2|Introducing the Creators of Hoyle Classic Card Games:|f||c|"
							(Message msgGET 4 0 0 0 7 @temp0) ; "|f2||c3|Robert Holmes|f||c| is the baby of the family here at Sierra. He WAS just a musician but now he is something to be stepped on also (The Project Manager). His daughter Raleigh makes an appearance in Hoyle Classic Card Games as "Scout"."
							(StrCat @temp500 @temp0)
							(if (Print addText: @temp500 init:)
								(Message msgGET 4 0 0 0 9 @temp500) ; "|f2||c3|Cindy Walker|f||c| was the underlying force behind all of the juvenile nonsense that has gone on during the months of development for this project. Oh, and by the way, she did some of the art."
								(Message msgGET 4 0 0 0 6 @temp0) ; "|f2||c3|Warren Schwader|f||c| has worked for Sierra since 1981 as a Designer and Programmer, and makes a cameo appearance in Hoyle Classic Card Games as "Crazy Jack". He lives with his wife and daughter in Central California."
								(StrCat @temp500 @temp0)
								(if (Print addText: @temp500 init:)
									(Message msgGET 4 0 0 0 12 @temp500) ; "|f2||c3|Tom DeSalvo|f||c| was forced to work on Hoyle Volume 3, Quest for Glory I, and now Hoyle Classic Card Games. He plans on getting married soon (although he wasn't forced to do this)."
									(Message msgGET 4 0 0 0 13 @temp0) ; "|f2||c3|Gloria Garland|f||c| is the type of person who has a lava lamp on her desk and wants to be Annie Mame when she grows up. She is already well on her way to achieving this goal since she is the Old Maid in Hoyle Classic Card Games. She claims that the lava lamp sends off artistic vibes and inspires her."
									(StrCat @temp500 @temp0)
									(if (Print addText: @temp500 init:)
										(Message msgGET 4 0 0 0 10 @temp500) ; "|f2||c3|Donald Waller|f||c| is a quiet guy who wears headphones and twiddles pixels all day long. No one really knows anything else about him except that he bears a striking resemblance to the "Billy Joe" character in Hoyle Classic Card Games."
										(Message msgGET 4 0 0 0 11 @temp0) ; "|f2||c3|Richard Aronson|f||c| started playing bridge and programming computers 20 years ago. Opinions are mixed as to how much improvement he's shown since then. We're told the glassy gaze and drooling will go away now that Hoyle Classic: Bridge is done."
										(StrCat @temp500 @temp0)
										(if (Print addText: @temp500 init:)
											(Message msgGET 4 0 0 0 14 @temp500) ; "|f2||c3|Jerry Shaw|f||c| was hijacked from another project and was coerced into working on the Bridge strategies. He now suffers from insomnia and hallucinations."
											(Message msgGET 4 0 0 0 15 @temp0) ; "|f2||c3|Judy Crites|f||c| is the person responsible for this whole thing. She forces everyone else to do their jobs right. She's ruthless and is the only one who gets to go home at night and forget about life for a while. She wants to go where everybody knows her name."
											(StrCat @temp500 @temp0)
											(if (Print addText: @temp500 init:)
												(Message msgGET 4 0 0 0 16 @temp500) ; "|f2||c3|Greg Tomko-Pavia|f||c| is the first rocket scientist at Sierra. He has been on the cutting-edge of technology ever since. Some day he hopes to be just a normal person like the rest of us."
												(Message msgGET 4 0 0 0 17 @temp0) ; "|f2||c3|Randy MacNeill|f||c| was a hopeless adventure game programmer until we saved him and snatched him up for Hoyle Classic Card Games. Now, he is a hopeless card game programmer and lovin' every minute of it."
												(StrCat @temp500 @temp0)
												(Print addText: @temp500 init:)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(= global122 1)
		(DisposeScript 4)
	)
)

(instance version of File
	(properties)

	(method (doit &tmp [temp0 50])
		(if (self open: 1)
			(self readString: @temp0 6 close:)
			(Message msgGET 4 1 0 0 1 @local0) ; "Version"
			(StrCat @local0 @temp0)
		else
			(Message msgGET 4 2 0 0 1 @local0) ; "No version file found."
		)
	)
)

(instance phone_txt of File
	(properties
		name {phone.txt}
	)

	(method (doit)
		(if (self open: 1)
			(self
				readString: @local50 15
				readString: @local100 15
				readString: @local150 14
				close:
			)
		else
			(Message msgGET 4 0 0 0 20 @local50) ; "1-800-326-6654"
			(Message msgGET 4 0 0 0 21 @local100) ; "1-209-683-4468"
			(Message msgGET 4 0 0 0 22 @local150) ; "1-800-SIERRA1"
		)
	)
)

