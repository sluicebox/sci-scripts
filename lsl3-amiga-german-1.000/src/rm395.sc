;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 395)
(include sci.sh)
(use Main)
(use rm71)
(use Interface)
(use Game)
(use System)

(public
	rm395 0
)

(local
	talkCount
	[string 150]
)

(instance rm395 of Rm
	(properties
		picture 395
	)

	(method (init)
		(super init:)
		(self setRegions: 71 setLocales: 70 setScript: RoomScript) ; rm71
		(Notify 71 1 111 47)
		(Notify 71 2 174 85)
		(Notify 71 3 98 60)
		(Notify 71 4 165 96)
		(Notify 71 5 93 104)
		(Notify 71 6 90 111)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event &tmp theObj)
		(if
			(and
				(not (super handleEvent: event))
				(not (event claimed:))
				gModelessDialog
				(== (event message:) KEY_RETURN)
				(== (event type:) evKEYBOARD)
			)
			(event claimed: 1)
			(cls)
			(self cue:)
		)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'give>')
				(= theObj (gInventory saidMe:))
				(event claimed: 0)
				(cond
					((Said '[/!*]')
						(Print 395 0) ; "What did you want to give her?"
					)
					((not theObj)
						(Print 395 1) ; "It's not yours to give."
					)
					((not (theObj ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					((== theObj (gInventory at: 9)) ; Spa_Keycard
						(PrintP 395 2) ; "Geez, Larry, I have one of those! I DO work here, you know!"
						(React 4)
					)
					((== theObj (gInventory at: 5)) ; Soap-On-A-Rope
						(PrintP 395 3) ; "What's that hole from, Larry?"
						(React 4)
					)
					((== theObj (gInventory at: 10)) ; Divorce_Decree
						(PrintL 395 4) ; "Look, Bambi! I'm a single guy."
						(PrintP 395 5) ; "So?"
						(React 4 6)
					)
					((== theObj (gInventory at: 2)) ; Ginsu_Knife
						(PrintP 395 6) ; "Hey! Put that thing away!! I have no use for that!"
						(React 4)
					)
					((== theObj (gInventory at: 11)) ; some_Orchids
						(PrintP 395 7) ; "Those do grow here, don't they? But orchids won't help me with this video!"
						(React 4)
					)
					((== theObj (gInventory at: 8)) ; Beach_Towel
						(PrintP 395 8) ; "I'm perfectly capable of bringing my own towel to work, Larry!"
						(React 4)
					)
					(else
						(PrintP 395 9) ; "Why, thank you, honey," says Bambi, "but I don't need `things,' I need help with this damn video project of mine!!"
						(React 4)
					)
				)
			)
			((Said 'fuck,fuck')
				(Print 395 10) ; "You wonder if you are fit enough to handle this one."
				(PrintP 395 11) ; "Larry! Shame on you! Your face is an open book!"
				(React 4 4)
			)
			((or (Said 'aid,aid//tape') (Said 'aid,aid/tape'))
				(if (not gEgoIsHunk)
					(PrintL 395 12) ; "Would you like some help with your video project, Bambi?"
					(PrintP 395 13) ; "Not from you, Mr. Husky! What could a tub-o like you know about fitness?"
					(React 4 22)
				else
					(self changeState: 7)
				)
			)
			((or (Said 'aid,aid') (Said '/aid,aid') (Said '//aid,aid'))
				(if (Random 0 1)
					(Print 395 14) ; "How would you help her?"
				else
					(Print 395 15) ; "Help her with what?"
				)
			)
			((or (Said 'ask//tape') (Said 'ask/tape'))
				(PrintL 395 16) ; "How is your video doing?"
				(PrintP 395 17) ; "Not well. With so many workout tapes in today's marketplace, I'm having trouble coming up with that certain little something that will make mine different, establishing my competitive edge!"
				(React 4 11)
			)
			(
				(or
					(Said 'exercise,(work<out)')
					(Said '/exercise,class,(work<out)')
					(Said '//exercise,class,(work<out)')
				)
				(PrintL 395 18) ; "Could I work out with you, Bambi?"
				(PrintP 395 19) ; "Maybe after I finish this aerobics video project, Larry."
				(React 4 4)
			)
			((or (Said '/tan,booth,booth') (Said '//tan,booth,booth'))
				(PrintL 395 20) ; "What's the story on that locked door out in the lobby, Bambi?"
				(PrintP 395 21) ; "Oh, that old thing? Why, that old tanning booth hasn't worked since the late eighties!"
			)
			((or (Said '/attendant') (Said '//attendant'))
				(PrintL 395 22) ; "What's the story on that man at the front desk?"
				(PrintP 395 23) ; "He's only there for appearances, Larry."
				(React 6 5)
			)
			((Said 'show,show/ball')
				(PrintL 395 24) ; "Hey, Bambi! Take a look at this, baby!"
				(PrintP 395 25) ; "War injury, Larry?"
				(React 2 20)
			)
			((Said 'make/joke')
				(PrintL 395 26) ; "You attempt to make a lame joke."
				(PrintL 395 27 67 -1 144) ; "(You succeed.)"
				(PrintP 395 28) ; "Hey, Larry! This is what I think of that joke!"
				(React 7 22)
			)
			(
				(or
					(Said '(out<go),dance,dance,show,show,date,date/')
					(Said 'get/woman,bambi,woman/building')
					(Said
						'ask,go//area,drop,drop,comedian,club,date,date,exit,walk,bar,show,show,dance,dance'
					)
					(Said
						'ask,go/area,drop,drop,comedian,club,date,date,exit,walk,bar,show,show,dance,dance'
					)
				)
				(PrintL 395 29) ; "Bambi, would you like to see the town with me?"
				(PrintP 395 30) ; "I've seen this town, Larry and it ain't that much!"
				(React 4 11)
			)
			((Said '/equipment,camera,camera')
				(PrintL 395 31) ; "Why all this video equipment for a simple aerobics room?"
				(PrintP 395 32) ; "Oh, that's not for my classes. I'm working on a new videotape for worldwide distribution."
				(React 2 20)
			)
			((Said 'talk,talk/woman,woman,bambi')
				(cond
					((not gEgoIsHunk)
						(PrintL (Format @string 395 33 global386 global387)) ; ""Hello, beautiful," you say, %s"
						(PrintP 395 34) ; "My, my! Your body is certainly ready for one of my workouts!"
					)
					((TestFlag 8)
						(Printf 395 33 global386 global387) ; ""Hello, beautiful," you say, %s"
						(PrintP 395 35) ; "Phewww! You smell like you've been working out and didn't bother to shower. How crude!"
						(React 4 11)
					)
					((TestFlag 10)
						(Printf 395 33 global386 global387) ; ""Hello, beautiful," you say, %s"
						(PrintP 395 36) ; "Phewww! You smell like you've been working out and showered without using soap. How crude!"
						(React 4 11)
					)
					((TestFlag 62)
						(Printf 395 33 global386 global387) ; ""Hello, beautiful," you say, %s"
						(PrintP 395 37) ; "Phewww! You smell like you've been working out, showered but didn't use a deodorant. How crude!"
						(React 4 11)
					)
					(else
						(React 2 20)
						(switch (++ talkCount)
							(1
								(PrintL 395 38) ; "Why all the elaborate video equipment for a simple aerobics class?"
								(PrintP 395 39) ; "Oh, that's not for my classes. I'm working on a new videotape for worldwide distribution."
							)
							(2
								(PrintL 395 40) ; "So? How's it going?"
								(PrintP 395 17) ; "Not well. With so many workout tapes in today's marketplace, I'm having trouble coming up with that certain little something that will make mine different, establishing my competitive edge!"
							)
							(else
								(PrintL 395 41) ; "Say, I used to be in marketing. Perhaps I could help you?"
								(PrintP 395 42) ; "Gosh, Larry! That would be wonderful. If you could, I'd be eternally grateful!"
							)
						)
					)
				)
			)
			((or (Said 'enjoy,love') (Said '/enjoy,love/you'))
				(PrintL 395 43) ; "Baby, I thinks I loves ya!"
				(PrintP 395 44) ; "I'm sure you would!"
				(React 5 44)
			)
			(
				(or
					(Said 'stop/look,look')
					(Said 'look,look<stop')
					(Said 'look,look/area')
					(Said 'done,exit,exit,done,exit,walk,go')
					(Said 'rise,(rise,nightstand<up),(get,get<off,up)')
				)
				(self changeState: 11)
			)
			((Said 'look,look>')
				(cond
					((Said '/calf')
						(PrintP 395 45) ; "Oh, Larry!" smiles Bambi. "Stop looking at me like that!"
						(React 3 22)
					)
					((Said '/bracelet')
						(Print 395 46) ; "Her pearly white wrist passes through an expensive golden bracelet."
					)
					((Said '/ear')
						(Print 395 47) ; "You predict there is little or nothing between Bambi's ears."
					)
					((or (Said '/tape') (Said '//tape'))
						(PrintL 395 48) ; "Bambi, is there any way I could see what you've done so far?"
						(PrintP 395 49) ; "Not really, Larry. I haven't yet figured out the hook that will make my tape different from all the others on the market."
					)
					((Said '/boob')
						(Print 395 50) ; ""My, what a tasty little pair of hooters!" you think to yourself."
						(PrintP 395 51) ; "Oh, Larry!" smiles Bambi. "Stop looking at me there!"
						(React 6 12)
					)
					((Said '[/area,woman,bambi]')
						(Print 395 52) ; "You feel certain you could learn to fawn over Bambi."
						(PrintP 395 53) ; ""Hello," says Bambi with her doe-eyed smile."
						(React 2 33)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(7
				(HandsOff)
				(PrintL 395 54) ; "Bambi! I've got it! I know just the angle that will sell that video of yours!"
				(PrintP 395 55) ; "Oh, really? What could that be, Larry?"
				(React 2 22)
				(= cycles 22)
			)
			(8
				(gGame changeScore: 99)
				(PrintL 395 56) ; "SEX!"
				(PrintP 395 57) ; "Of course! Why didn't I think of that? If sex sells toothpaste, it surely should sell aerobics!"
				(React 2 22)
				(= cycles 22)
			)
			(9
				(PrintL 395 58) ; "We'll be the first aerobics video to use sexual positions for our exercises. Can you do it, Bambi? Can you make it interesting?"
				(PrintP 395 59) ; "Interesting?! I should say! Watch this!!"
				(React 2 22)
				(= cycles 22)
				(gMusic fade:)
			)
			(10
				(= gEgoState 1)
				(gMusic stop:)
				(gCurRoom newRoom: 390)
			)
			(11
				(PrintL 395 60) ; "I can't wait to see you work out again, Bambi!"
				(PrintP 395 61) ; "Come back when you feel helpful, Larry!"
				(React 2 33)
				(= cycles 22)
			)
			(12
				(gCurRoom newRoom: 390)
			)
		)
	)
)

