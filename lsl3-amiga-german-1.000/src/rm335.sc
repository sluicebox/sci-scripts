;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 335)
(include sci.sh)
(use Main)
(use rm71)
(use Interface)
(use Game)
(use Inventory)
(use System)

(public
	rm335 0
)

(local
	sawWaterClue
	sawBraClue
	sawPantyhoseClue
)

(instance rm335 of Rm
	(properties
		picture 335
	)

	(method (init)
		(super init:)
		(self setRegions: 71 setScript: RoomScript) ; rm71
		(Notify 71 1 154 78)
		(Notify 71 2 188 81)
		(Notify 71 3 152 78)
		(Notify 71 4 187 81)
		(Notify 71 5 170 106)
		(Notify 71 6 168 114)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said '(go<out),date,date')
					(Said 'fuck,fuck')
					(Said 'get/anyword/building')
					(Said 'ask/anyword/date,date')
					(Said 'ask,get,get/date,date')
					(Said '(let<make),make/enjoy,love')
					(Said 'anyword/make/enjoy,love')
					(Said 'go/bed,penthouse')
					(Said 'give/job<blow,blow')
					(Said 'give/blow,blow<job')
					(Said 'give/head')
					(Said 'give/head<job')
					(Said
						'eat,eat,blow,blow,eat,eat/man,dale,dale,ball,coconut,ball'
					)
				)
				(PrintP 335 0) ; "No way, Patti! I know your reputation. As soon as you show me a clean bill of health I'll consider your offer!"
				(React 4 4)
			)
			((Said '/bill,health')
				(Print 335 1) ; "Who cares about Bill's health?"
			)
			((or (Said 'show,show/ball/entertainer') (Said 'show,show/ball'))
				(PrintL 335 2) ; "Hey, Dale. Word has it you're the warden of a considerable penal colony! How about a tour?"
				(PrintL 335 3) ; "Oh my Gawd!!"
				(React 2 20)
			)
			(
				(or
					(Said 'aid,aid')
					(Said '/aid,aid')
					(Said '//larry')
					(Said '/larry')
				)
				(PrintL 335 4) ; "Dale, I simply have to find Larry; Larry Laffer. Is there anyway you could help me?"
				(PrintP 335 5) ; "Patti, I'm no pathfinder, but I know this: the answer doesn't lie with anyone here in this village!"
			)
			((or (Said '/maze,farm,art,bamboo') (Said '//maze,farm,art,bamboo'))
				(PrintP 335 6) ; "I've heard about that bamboo forest being like a maze. I do know this, when all else fails: read the manual!"
			)
			((Said '/bar,blackboard,drink,drink,club,dance,dance')
				(PrintP 335 7) ; "I've been meaning to do something about the poor service here!"
			)
			((Said 'give')
				(if (InRoom 14 330)
					(PrintP 335 8) ; "Honey, that little pair of panties you gave me is all I need from you!"
				else
					(PrintP 335 9) ; "Honey, I'd like to help you in your quest, but I just can't."
				)
			)
			((Said 'talk,talk')
				(cond
					((and (not sawPantyhoseClue) (not (gEgo has: 15))) ; Pantyhose
						(= sawPantyhoseClue 1)
						(PrintP 335 10) ; "I notice you don't wear hosiery, Patti. Your bare legs look wonderful!"
					)
					((and (not sawBraClue) (not (gEgo has: 16))) ; Bra
						(= sawBraClue 1)
						(PrintP 335 11) ; "I see you don't believe in wearing needless undergarments, Patti. I could tell from the moment I saw you sitting out there in the audience you were a girl after my own heart."
					)
					(
						(and
							(not sawWaterClue)
							(or
								(not (gEgo has: 13)) ; Bottle_of_Wine
								(!= ((Inv at: 13) view:) 29) ; Bottle_of_Wine
							)
						)
						(= sawWaterClue 1)
						(PrintP 335 12) ; "I know my motto: don't get caught without a drink in your hand!"
					)
					(else
						(PrintL 335 13) ; "So, Dale, is there any way through that treacherous bamboo forest that lies to the north of the village?"
						(PrintP 335 14) ; "Patti, all I can say is: when all else fails, read your manual!"
					)
				)
			)
			((Said 'make/joke')
				(PrintL 335 15) ; "You attempt to make a lame joke."
				(PrintL 335 16 67 -1 144) ; "(You succeed.)"
				(PrintP 335 17) ; "Hey, Patti! This is what I think of that joke!"
				(React 7 22)
			)
			((Said 'enjoy,love')
				(PrintL 335 18) ; "Baby, I thinks I loves ya!"
				(PrintP 335 19) ; "I'm sure you would!"
				(React 5 44)
			)
			(
				(or
					(Said 'stop/look,look')
					(Said 'look,look<stop')
					(Said 'look,look/area')
					(Said 'done,exit,exit,done,exit,walk,go')
				)
				(self changeState: 1)
			)
			((Said 'embrace,embrace,embrace')
				(Print 335 20) ; "That's ONE thing you're hoping for!"
			)
			((Said '/beard')
				(Print 335 21) ; "All the sexiest men have beards."
				(Print 335 22 #at -1 144) ; "(See box cover.)"
			)
			((Said '/ass')
				(Print 335 23) ; "Tight butts drive you nuts!"
			)
			((Said '/bracelet')
				(Print 335 24) ; "His hands are large and powerful but it's not his hands you're interested in!"
			)
			((Said '/cloth')
				(Print 335 25) ; "He looks even sexier dressed!"
			)
			((Said '/body')
				(Print 335 26) ; "He has the body of a dancer!"
			)
			((Said '/ankle')
				(Print 335 27) ; "Is your latent foot fetish cropping up again, Patti?"
			)
			((Said '/hair')
				(Print 335 28) ; "You feel balding men are more attractive!"
			)
			((Said '/ear')
				(Print 335 29) ; "Dale's ears are not what attracted you to him."
			)
			((Said '/nose')
				(Print 335 30) ; "He has a nice rhythm to his breathing."
			)
			((Said '/lip,lip')
				(Print 335 31) ; "Doesn't he have the cutest smile!"
			)
			((Said '/eye')
				(Print 335 32) ; "You stare deeply into his eyes. You see no signs of life."
			)
			((or (Said 'caress,grab,caress') (Said '/ball,ball,coconut'))
				(PrintL 335 33) ; "What do you think of this, Dale?"
				(PrintP 335 34) ; "Oooh! So it's true! You are `The Passionate One!'"
				(React 5 44)
			)
			((Said '/dicklicker')
				(Print 335 35) ; "Just think of the tales that tongue could tell..."
			)
			((Said 'look,look>')
				(cond
					((Said '/calf')
						(PrintP 335 36) ; "Oh, Patti!" smiles Dale. "Keep looking at me like that!"
						(React 3 22)
					)
					((Said '/bracelet')
						(Print 335 37) ; "Dale is wearing an excellent knockoff of an expensive, imported gold watch."
					)
					((Said '/ear')
						(Print 335 38) ; "His delicate ears have heard a cacophony of shrieking women."
					)
					((Said '/boob')
						(Print 335 39) ; ""My, what a manly chest he has!" you think to yourself."
						(PrintP 335 40) ; "Oh, Patti!" smiles Dale. "Please keep looking at me there!"
						(React 6 12)
					)
					((Said '[/area,man,dale]')
						(Print 335 41) ; "Before you sits Dale the Male Stripper and co-owner of "Chip 'n' Dale's." You hope he may be able to help you find Larry."
						(PrintP 335 42) ; ""Hello," he says with a smile."
						(React 2 33)
					)
				)
			)
			(
				(or
					(Said '(out<go),dance,dance,show,show,date,date/')
					(Said 'get/man,dale,dale/building')
					(Said 'ask/man,dale,dale/date,date')
					(Said
						'go/area,drop,drop,comedian,club,date,date,exit,walk,bar,show,show,dance,dance'
					)
				)
				(PrintL 335 43) ; "Dale, if I had met you a few days ago, I would have asked you out on a date. But now, I'm only interested in Larry; Larry Laffer."
				(PrintP 335 44) ; "I hope you find him, Patti."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(PrintL 335 45) ; "It's been a pleasure talking with you, Dale"
				(PrintP 335 46) ; "Hope you get your man, Patti!"
				(React 2 55)
				(= cycles 50)
			)
			(2
				(gCurRoom newRoom: 330)
			)
		)
	)
)

