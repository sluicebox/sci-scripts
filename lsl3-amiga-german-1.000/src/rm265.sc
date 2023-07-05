;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 265)
(include sci.sh)
(use Main)
(use rm71)
(use Interface)
(use Game)
(use Inventory)
(use System)

(public
	rm265 0
)

(local
	work
)

(instance rm265 of Rm
	(properties
		picture 265
	)

	(method (init)
		(if (gEgo has: 1) ; Credit_Card
			(Load rsVIEW 1)
		)
		(super init:)
		(self setRegions: 71 setLocales: 70 setScript: RoomScript) ; rm71
		(Notify 71 1 115 77)
		(Notify 71 2 171 82)
		(Notify 71 3 114 82)
		(Notify 71 4 169 87)
		(Notify 71 5 139 121)
		(Notify 71 6 140 136)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event &tmp theObj)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'go,get//center,shopping')
					(Said 'go,get/shopping,center')
				)
				(PrintL 265 0) ; "Say, babe, why don't I take you shopping down at the famous Nontoonyt Mall?"
				(PrintP 265 1) ; "I don't need you to take me `malling.'"
			)
			(
				(or
					(Said '(go<out),date,date/maller')
					(Said 'make/enjoy,love,date,date')
					(Said 'let<make/enjoy,love,date,date')
					(Said '/make/enjoy,love')
					(Said
						'ask,get,go/area,drop,drop,comedian,club,date,date,exit,walk,bar,show,show,building,dance,dance'
					)
					(Said
						'ask,get,go//area,drop,drop,comedian,club,date,date,exit,walk,bar,show,show,building,dance,dance'
					)
				)
				(PrintL 265 2) ; "What do you say, Tawni? Don't all you beach girls have a thing for older, pudgy formerly-bald guys?"
				(PrintP 265 3) ; "Ha, ha. You really have a sense of humor! What would make me interested in you?"
			)
			((Said 'sell')
				(PrintP 265 4) ; "I don't want to buy from an American like you when I could purchase native island souvenirs."
				(React 2 20)
			)
			((Said '/souvenir')
				(PrintL 265 5) ; "Tawni, do you recommend the souvenirs here on the beach?"
				(PrintP 265 6) ; "Boy, do I! Larry, I bet I've bought something from every native vendor that's appeared here!"
			)
			((Said '/swim,bay,water')
				(PrintL 265 7) ; "So, Tawni, how do you like swimming in the water here?"
				(PrintP 265 8) ; "It's wonderful, but my suit does get strange stains!"
			)
			(
				(or
					(Said 'stop/look,look')
					(Said 'look,look<stop')
					(Said 'rise,(rise,nightstand<up),(get,get<off,up)')
					(Said 'look,look/beach,area')
					(Said 'done,exit,exit,done,exit,walk,go')
				)
				(self changeState: 2)
			)
			((Said 'fuck,fuck')
				(PrintP 265 9 global304 global305) ; "%s Shame on you!"
				(React 4 8)
			)
			((Said 'show,show/ball')
				(PrintL 265 10) ; "Hey, Tawni! Bet you don't have one of these!"
				(PrintP 265 11) ; "Gee, Larry, you almost don't have one either!"
				(React 2 20)
			)
			((Said '/weather')
				(PrintP 265 12) ; "Everybody talks about it but you don't do a thing about it -- oh, wait! Did you say weather?"
			)
			((Said 'make/joke')
				(Print 265 13) ; "You attempt to make a lame joke."
				(Print 265 14 #at -1 144) ; "(You succeed.)"
				(PrintP 265 15) ; "Hey, Larry! This is what I think of that joke!"
				(React 7 22)
			)
			((Said 'enjoy,love/you')
				(PrintL 265 16) ; "Tawni, could this be love?"
				(PrintP 265 17) ; "No, but it might be like!"
				(React 5 44)
			)
			(
				(or
					(Said '(out<go),dance,dance,date,date/')
					(Said 'get/(maller,woman)/building')
					(Said 'ask/(maller,woman)/date,date')
					(Said
						'go/area,drop,drop,comedian,club,date,date,exit,walk,bar,show,show,dance,dance'
					)
				)
				(PrintL 265 18) ; "Would you care to leave this beach and go somewhere where we could be alone?"
				(PrintP 265 19) ; "Only to Nordstrom's!"
			)
			((Said '/center')
				(PrintL 265 20) ; "What's the story on that downtown Nontoonyt Mall, Tawni? I can't seem to find it -- anywhere on the island!"
				(PrintP 265 21) ; "If I knew, would I be here on this towel?"
			)
			((Said 'talk,talk')
				(switch (Random 1 3)
					(1
						(PrintL 265 22) ; "Have you been to that new downtown Nontoonyt Mall?"
						(PrintP 265 23) ; "No, but if I ever find it, I bet I could spend my whole vacation there!"
					)
					(2
						(PrintL 265 24) ; "Have I mentioned to you that I will soon be coming into a major real-estate holding?"
						(PrintP 265 25) ; "Is it a shopping mall?"
					)
					(else
						(PrintL 265 26) ; "What would it take for you to date an, um, `older man' like me?"
						(PrintP 265 27) ; "Larry, I guess I'm just a `material girl!'"
					)
				)
			)
			((Said 'look,look>')
				(cond
					((Said '/calf')
						(Print 265 28) ; "Those legs reach all the way to her beachhead!"
						(PrintP 265 29) ; "Oh, Larry!" smiles Tawni. "Stop looking at me like that!"
						(React 3 22)
					)
					((Said '/skin')
						(Print 265 30) ; "It's gorgeous."
						(Print 265 31 #at -1 144) ; "(And you can see almost all of it!)"
					)
					((Said '/boob')
						(if (>= gFilthLevel 3)
							(Print 265 32) ; "They are sweet, aren't they?"
							(PrintP 265 33) ; "Oh, Larry!" smiles Tawni, noticing your glance. "You really enjoy staring at breasts, don't you?"
						else
							(Print 265 34) ; "You think she seemed slow to cover them when she stood up!"
							(PrintP 265 35) ; "Oh, Larry!" smiles Tawni, noticing your glance. "Stop looking at me there!"
						)
						(React 6 12)
					)
					((Said '/eye')
						(Print 265 36) ; "Her blue eyes show the effects of too many hours spent "malling.""
					)
					((Said '/nose')
						(Print 265 37) ; "Tawni's pert little nose has years of experience sniffing out bargains."
					)
					((Said '/ear')
						(Print 265 38) ; "24k gold"
						(Print 265 39 #at -1 144) ; "(You have extremely sharp vision!)"
					)
					((Said '/lip')
						(Print 265 40) ; "Her mouth is just beneath her nose."
					)
					((Said '/dicklicker')
						(Print 265 41) ; "Her tongue is scarred with paper cuts from licking too many credit card envelopes."
					)
					((Said '/face,eye')
						(Print 265 42) ; "Tawni's face is framed with blond hair."
					)
					((Said '/hair')
						(Print 265 43) ; "Tawni's hair shows the effects of the many hours she devotes to sunbathing."
					)
					((Said '/ass,bottom')
						(Print 265 44) ; "It's barely covered by that string bikini."
					)
					((Said '/clit')
						(Print 265 45) ; "There may indeed be faint outlines visible through that knit bikini..."
						(PrintP 265 46) ; "Oh, Larry!" smiles Tawni. "Stop looking at me there!"
						(React 6 12)
					)
					((Said '[/area,beach,woman,maller]')
						(Print 265 47) ; "Her magnificent blond hair haunts you."
						(Print 265 48 #at -1 144) ; "(Too bad there's no one home within it!)"
						(React 2 33)
					)
				)
			)
			((Said 'show,show>')
				(= theObj (gInventory saidMe:))
				(event claimed: 0)
				(cond
					((Said '[/!*]')
						(Print 265 49) ; "What did you want to show her?"
					)
					((or (not theObj) (not (theObj ownedBy: gEgo)))
						(DontHave) ; "You don't have it."
					)
					((== theObj (gInventory at: 3)) ; Granadilla_Wood
						(PrintP 265 50) ; "Geez, Larry, how nice! A stupid old hunk of wood?!"
						(React 4)
					)
					((== theObj (gInventory at: 5)) ; Soap-On-A-Rope
						(PrintP 265 51) ; "Golly, gee, a REAL bar of soap! You're so lucky to have a real bar of soap."
						(React 4)
					)
					((== theObj (gInventory at: 11)) ; some_Orchids
						(PrintP 265 52) ; "Lovely bunch of wildflowers, Larry. You know those grow wild all over this island?"
						(React 4)
					)
					((== theObj (gInventory at: 1)) ; Credit_Card
						(PrintP 265 53) ; "OOOOHHHH! Now there's something that `earns my interest!'"
					)
					(else
						(PrintP 265 54) ; "Why, Larry," says Tawni, "isn't that special?"
					)
				)
				(event claimed: 1)
			)
			((Said 'give>')
				(= theObj (gInventory saidMe:))
				(event claimed: 0)
				(cond
					((Said '[/!*]')
						(Print 265 55) ; "What did you want to give her?"
					)
					((not theObj)
						(Print 265 56) ; "It's not yours to give."
					)
					((not (theObj ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					((== theObj (gInventory at: 3)) ; Granadilla_Wood
						(PrintP 265 57) ; "Geez, Larry, I've always wanted a stupid old hunk of wood. Is this from the Neiman-Marcus catalog... ...of 1812?!"
						(React 4)
					)
					((== theObj (gInventory at: 5)) ; Soap-On-A-Rope
						(PrintP 265 58) ; "Golly, gee, a REAL bar of soap! In all my days of shopping, I've never seen a bar of soap before."
						(React 4)
					)
					((== theObj (gInventory at: 11)) ; some_Orchids
						(PrintP 265 59) ; "Lovely bunch of wildflowers, Larry. You're a regular little Merlin Olsen!"
						(React 4)
					)
					((== theObj (gInventory at: 1)) ; Credit_Card
						(if (not (gEgo has: 1)) ; Credit_Card
							(DontHave) ; "You don't have it."
						else
							(self changeState: 1)
						)
					)
					(else
						(PrintP 265 60) ; "Why, thank you, honey," says Tawni, "but I need something I can spend!"
					)
				)
				(event claimed: 1)
			)
			((Said 'get,get')
				(PrintP 265 61) ; "Honey, I'm not interested in giving. It's GETTING I enjoy!"
				(React 2 22)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(PrintL 265 62 82 1 0 0) ; "Here, Tawni," you say, "I can see how you enjoy shopping. I'd like you to have my credit card."
				(gGame changeScore: 50)
				((Inv at: 1) owner: -1) ; Credit_Card
				(PrintP 265 63) ; "Oh, Larry," cries Tawni, "it's the perfect gift; the right size, the right shape, and the right color: gold! And I think I know the perfect way to express my appreciation to you, too. Come here, big boy!"
				(= gEgoState 1)
				(++ state)
				(React 2 99)
				(= cycles 50)
			)
			(2
				(Print 265 64) ; "As much as you hate to, you stop looking at the beautiful Tawni."
				(React 2 55)
				(= cycles 50)
			)
			(3
				(gCurRoom newRoom: 260)
			)
		)
	)
)

