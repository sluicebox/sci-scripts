;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 435)
(include sci.sh)
(use Main)
(use rm71)
(use Interface)
(use Game)
(use System)

(public
	rm435 0
)

(local
	readyForDeed
	seenMsg
)

(instance rm435 of Rm
	(properties
		picture 435
	)

	(method (init)
		(super init:)
		(self setRegions: 71 setLocales: 70 setScript: RoomScript) ; rm71
		(Notify 71 1 149 45)
		(Notify 71 2 180 45)
		(Notify 71 3 149 42)
		(Notify 71 4 178 42)
		(Notify 71 5 163 61)
		(Notify 71 6 164 78)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event &tmp theObj)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'fuck,fuck')
				(Print 435 0) ; "You think to yourself, "I bet I'd love the taste of a piece of this `Cherry Tart!'""
				(PrintP 435 1) ; ""Why, Larry! Shame on you! I can tell just what you're thinking!"%"
				(React 4 4)
			)
			((or (Said '/land,deed,dowry') (Said '//land,deed,dowry'))
				(HandsOff)
				(PrintL 435 2) ; "You know, I think I have some land coming to me from a recent, (cough, cough) uh, legal development. I really have no use for it. Would you like a few acres?"
				(PrintP 435 3) ; ""Do I? Why, Larry, I'd do ANYTHING for a little piece of land. But I must run; I still must get ready for the next show."%"
				(= readyForDeed 1)
				(React 2 33)
				(= state 0)
				(= cycles 22)
			)
			(
				(or
					(Said '(out<go),dance,dance,show,show,date,date/')
					(Said 'get/woman,woman,cheri/building')
					(Said 'ask/woman,woman,cheri/date,date')
					(Said
						'go/area,drop,drop,comedian,club,date,date,exit,walk,bar,show,show,dance,dance'
					)
				)
				(PrintL 435 4) ; "What if we split this scene and go back to my place, Cherri?"
				(PrintP 435 5) ; ""From what I've heard, Larry, you no longer have a place!"%"
			)
			((Said 'talk,talk/woman,cheri,woman')
				(if (not seenMsg)
					(= seenMsg 1)
					(PrintL 435 6) ; "So, Cherri; tell me what you want to do with your life."
					(PrintP 435 7) ; ""I'd love to quit show business, get a little farm some place far out in the country where I could be alone, and raise organically-grown vegetables, fruits and herbs."%"
				else
					(PrintL 435 8) ; "Well, Cherri, I'm just the opposite. I have hundreds of acres of land coming into my possession soon but I'd love to be in show business."
					(PrintP 435 9) ; ""Oh, Larry! You're so lucky! How I wish I had some land."%"
				)
				(React 2 20)
			)
			((Said 'show,show/ball')
				(PrintL 435 10) ; "Hey, Cherri! Take a look at this, baby!"
				(PrintP 435 11) ; ""Gee, that's too bad, Larry."%"
				(React 2 20)
			)
			((or (Said 'enjoy,love/you') (Said '/enjoy,love/you'))
				(PrintL 435 12) ; "Baby, I thinks I loves ya!"
				(PrintP 435 13) ; ""I'm sure you would!"%"
				(React 5 44)
			)
			(
				(or
					(Said 'stop/look,look')
					(Said 'look,look<stop')
					(Said 'look,look/area')
					(Said 'done,bye,exit,exit,done,exit,walk,go')
				)
				(self changeState: 1)
			)
			((Said '/building,land,farm,farm')
				(PrintP 435 14) ; ""Oh, yes, Larry. That's my goal, you know: to quit show biz and move to the country to pursue my dream: slash and burn, pillage and rape agriculture!"%"
			)
			((Said '/dance,dance,show,show')
				(PrintL 435 15) ; "I certainly enjoyed your dancing, Cherri! I'm somewhat of a dancer myself, you know."
				(PrintP 435 16) ; ""I'll bet you are, but you seem to have lost your dancer's physique!"%"
			)
			((Said 'look,look>')
				(cond
					((Said '/calf')
						(PrintP 435 17) ; ""Oh, Larry!" smiles Cherri. "Stop looking at me like that!"%"
						(React 3 22)
					)
					((Said '/ear')
						(Print 435 18) ; "They look delicious."
					)
					((Said '/boob')
						(Print 435 19) ; ""Perhaps we'll see more of you two later," you think to yourself."
						(PrintP 435 20) ; ""Oh, Larry!" smiles Cherri. "Stop looking at me there!"%"
						(React 6 12)
					)
					((Said '[/area,casino,hotel,cheri,woman]')
						(Print 435 21) ; "You are talking with Cherri Tart, the headline dancer in the casino showroom."
						(PrintP 435 22) ; ""Hello," she says with a smile.%"
						(React 2 33)
					)
				)
			)
			((Said 'give>')
				(= theObj (gInventory saidMe:))
				(event claimed: 0)
				(cond
					((Said '[/!*]')
						(Print 435 23) ; "What did you want to give her?"
					)
					((not theObj)
						(Print 435 24) ; "It's not yours to give."
					)
					((not (theObj ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					((== theObj (gInventory at: 8)) ; Beach_Towel
						(PrintP 435 25) ; ""Gosh, Larry. This towel would be perfect for my new home in the country... if I can ever get out of show business. Thanks!"%"
						(PutInRoom 8)
						(gGame changeScore: -10)
						(React 2)
					)
					((== theObj (gInventory at: 5)) ; Soap-On-A-Rope
						(PrintP 435 26) ; ""If I ever get my own place in the country, I'll need soap like this to clean up."%"
						(PutInRoom 5)
						(gGame changeScore: -10)
						(React 2)
					)
					((== theObj (gInventory at: 2)) ; Ginsu_Knife
						(PrintP 435 27) ; ""I've dreamed of moving to a place, way out in the jungle; just a little place with anacondas and a picket fence. A good sharp ginsu knife will come in handy!"%"
						(PutInRoom 2)
						(gGame changeScore: -10)
						(React 2)
					)
					((== theObj (gInventory at: 11)) ; some_Orchids
						(PrintP 435 28) ; ""Oh, I just love orchids, but unfortunately, I'm allergic!"%"
						(React 4)
					)
					(else
						(PrintP 435 29) ; ""Why, thank you, honey," says Cherri, "but what I really need is just a little place I can call my own!"%"
					)
				)
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(if readyForDeed
					(if (!= gShowroomState 3)
						(= gShowroomState 3)
						(= gLawyerState 1)
						(= gNewspaperState 2)
						(gGame changeScore: 25)
					)
				else
					(PrintL 435 30) ; "I hope you find what you're seeking, Cherri"
					(PrintP 435 31) ; ""Thanks, Larry!"%"
				)
				(React 2 55)
				(= cycles 33)
			)
			(2
				(gCurRoom newRoom: 420)
			)
		)
	)
)

