;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 141)
(include sci.sh)
(use Main)
(use TalkObj)
(use RFeature)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm141 0
)

(local
	local0
	local1
	local2
)

(instance baronWin of SysWindow
	(properties
		color 1
		title {Baron von Spielburg says:}
	)

	(method (open &tmp temp0)
		(= temp0 (- 188 bottom))
		(+= top temp0)
		(+= bottom temp0)
		(super open: &rest)
	)
)

(instance sonWin of SysWindow
	(properties
		color 8
		title {The Baronet says:}
	)

	(method (open &tmp temp0)
		(= temp0 (- 188 bottom))
		(+= top temp0)
		(+= bottom temp0)
		(super open: &rest)
	)
)

(instance baronTalk of TalkObj
	(properties
		tLoop 3
		cSpeed 2
		isHead 1
	)
)

(instance sonTalk of TalkObj
	(properties
		tLoop 5
		cSpeed 2
		isHead 1
	)
)

(instance baron of Act
	(properties
		y 65
		x 159
		view 141
		loop 2
		cel 1
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'look/baron,dad') (MouseClaimed self event 3))
				(LowPrint 141 0) ; "The Baron von Spielburg looks like he was once a strong man, but sorrow has aged him greatly."
			)
		)
	)
)

(instance son of Act
	(properties
		y 85
		x 234
		view 141
		loop 4
		cel 2
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'look/barnard,barnard,bear,barnard')
					(MouseClaimed self event 3)
				)
				(LowPrint 141 1) ; "The Baronet looks his usual haughty self, although his clothes are a little neater than the last time you saw him."
			)
		)
	)
)

(instance egoHead of View
	(properties
		y 79
		x 160
		view 508
		loop 1
	)
)

(instance baronHead of Prop
	(properties
		y 54
		x 159
		view 141
		loop 3
		cycleSpeed 2
	)

	(method (doit)
		(baronTalk doit:)
		(super doit:)
	)

	(method (handleEvent event)
		(baronTalk handleEvent: event)
	)
)

(instance sonHead of Prop
	(properties
		y 51
		x 234
		view 141
		loop 5
		cycleSpeed 2
	)

	(method (doit)
		(sonTalk doit:)
		(super doit:)
	)

	(method (handleEvent event)
		(sonTalk handleEvent: event)
	)
)

(instance cupboard of PV
	(properties
		y 67
		x 68
		view 141
		priority 3
	)
)

(instance onCupboard of RFeature
	(properties
		nsTop 37
		nsLeft 41
		nsBottom 84
		nsRight 96
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'look/cabinet') (MouseClaimed self event 3))
				(LowPrint 141 2) ; "The cupboard contains a variety of dishware and eating utensils."
			)
		)
	)
)

(instance arms of PV
	(properties
		y 47
		x 159
		view 141
		cel 1
		priority 1
	)
)

(instance onArms of RFeature
	(properties
		nsTop 33
		nsLeft 135
		nsBottom 49
		nsRight 183
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'look/(arm[<coat]),design,crest')
					(MouseClaimed self event 3)
				)
				(LowPrint 141 3) ; "The von Spielburg coat of arms: Twin Saurus guarding, Winged Chevron, on a field Azure."
			)
		)
	)
)

(instance grate of PV
	(properties
		y 79
		x 245
		view 141
		cel 2
		priority 4
	)
)

(instance onGrate of RFeature
	(properties
		nsTop 42
		nsLeft 224
		nsBottom 80
		nsRight 264
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'look/grate,fire,chimney') (MouseClaimed self event 3))
				(LowPrint 141 4) ; "The fireplace is cold and lifeless, the grate in front now only an ornament."
			)
		)
	)
)

(instance lGuard of PV
	(properties
		y 73
		x 106
		view 141
		loop 1
		priority 3
	)
)

(instance onLGuard of RFeature
	(properties
		nsTop 30
		nsLeft 97
		nsBottom 74
		nsRight 113
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'look/guard')
					(MouseClaimed self event 3)
					(MouseClaimed onRGuard event 3)
				)
				(LowPrint 141 5) ; "The guards stand stiffly at attention behind the Baron's table."
			)
		)
	)
)

(instance rGuard of PV
	(properties
		y 73
		x 213
		view 141
		loop 1
		cel 1
		priority 3
	)
)

(instance onRGuard of RFeature
	(properties
		nsTop 30
		nsLeft 204
		nsBottom 74
		nsRight 220
	)
)

(instance onTable1 of RFeature
	(properties
		nsTop 63
		nsLeft 107
		nsBottom 85
		nsRight 210
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'look/table,bench')
					(MouseClaimed self event 3)
					(MouseClaimed onTable2 event 3)
					(MouseClaimed onTable3 event 3)
				)
				(LowPrint 141 6) ; "The long tables are covered with dusty tablecloths."
			)
		)
	)
)

(instance onTable2 of RFeature
	(properties
		nsTop 102
		nsLeft 84
		nsBottom 152
		nsRight 129
	)
)

(instance onTable3 of RFeature
	(properties
		nsTop 102
		nsLeft 182
		nsBottom 152
		nsRight 250
	)
)

(instance onDoor of RFeature
	(properties
		nsTop 50
		nsLeft 2
		nsBottom 96
		nsRight 16
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'look/door') (MouseClaimed self event 3))
				(LowPrint 141 7) ; "Through the door, you can see the hallway through which you entered, and the stairs leading down to the main entrance."
			)
		)
	)
)

(instance rm141 of Rm
	(properties
		picture 141
		style 8
	)

	(method (init)
		(Load rsVIEW 141)
		(super init:)
		(SolvePuzzle 663 10)
		(SL enable:)
		(gMouseHandler add: self baronHead sonHead)
		(gKeyHandler add: baronHead sonHead)
		(gAddToPics
			add: cupboard arms grate lGuard rGuard
			eachElementDo: #init
			doit:
		)
		(self setFeatures: onDoor onLGuard onArms onCupboard onGrate onTable1)
		(baron setPri: 5 init:)
		(son setPri: 5 init:)
		(baronHead
			setPri: (+ (baron priority:) 1)
			ignoreActors:
			init:
			stopUpd:
			hide:
		)
		(sonHead
			setPri: (+ (son priority:) 1)
			ignoreActors:
			init:
			stopUpd:
			hide:
		)
		(EgoGait 0 0) ; walking
		(egoHead hide:)
		(baronTalk tWindow: baronWin actor: baronHead init:)
		(sonTalk tWindow: sonWin actor: sonHead init:)
		(if (< global211 16)
			(sonWin color: 4)
		)
		(= gFreeMeals 1)
		(self setScript: egoEnters)
	)

	(method (handleEvent event)
		(clr)
		(cond
			((super handleEvent: event))
			((== (event type:) evSAID)
				(cond
					((or (Said '[use]/stealth') (Said 'run,sneak'))
						(LowPrint 141 8) ; "That would be inappropriate behavior here."
					)
					((Said 'kill,fight,cut,hit,damage,cast')
						(LowPrint 141 9) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
					)
					((Said 'look/floor')
						(LowPrint 141 10) ; "The floor has not been cleaned in some time."
					)
					((Said 'look[<at,around][/!*,room,building,hall]')
						(LowPrint 141 11) ; "The Great Hall of Spielburg Castle is not very impressive. The room is plain, with scuffed floors and grimy plastered walls."
					)
				)
			)
			((and (== (event type:) evMOUSEBUTTON) (MouseClaimed gEgo event 3))
				(LowPrint 141 12) ; "You are less than awed by Baron von Spielburg's Great Hall. You'd think a Baron could keep his home a little cleaner. You try to hide your disappointment."
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: posn: 0 108 setMotion: MoveTo 154 108 self)
			)
			(1
				(LookAt gEgo baron)
				(= seconds 3)
			)
			(2
				(gEgo
					view: 508
					loop: 0
					cel: 0
					cycleSpeed: 2
					forceUpd:
					setCycle: End
				)
				(= seconds 2)
			)
			(3
				(egoHead
					ignoreActors:
					setPri: (+ (gEgo priority:) 1)
					init:
					hide:
				)
				(client setScript: openingSpeech)
			)
		)
	)
)

(instance openingSpeech of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baronTalk caller: self)
				(sonTalk caller: self)
				(baron setCel: 1)
				(egoHead hide:)
				(Say baronTalk 141 13 141 14 141 15) ; "Words cannot express the gratitude I have towards you."
			)
			(1
				(= seconds 2)
			)
			(2
				(egoHead hide:)
				(baron setCel: 0)
				(Say baronTalk 141 16) ; "Barnard."
			)
			(3
				(egoHead show:)
				(son setCel: 1)
				(Say sonTalk 141 17) ; "We, er, that is, I, am appreciative of your efforts upon my behalf."
			)
			(4
				(if (IsFlag 150)
					(egoHead hide:)
					(baron setCel: 2)
					(Say baronTalk 141 18 141 19) ; "Furthermore, I understand you have rid our valley of a dangerous Kobold Magic User in order to free the Baronet von Spielburg."
				else
					(client setScript: becomeHero)
				)
			)
			(5
				(= seconds 2)
			)
			(6
				(egoHead hide:)
				(baron setCel: 0)
				(Say baronTalk 141 16) ; "Barnard."
			)
			(7
				(egoHead show:)
				(son setCel: 0)
				(Say sonTalk 141 20) ; "I'm pleased you managed to kill the Kobold."
			)
			(8
				(client setScript: becomeHero)
			)
		)
	)
)

(instance becomeHero of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baronTalk caller: self)
				(sonTalk caller: self)
				(egoHead hide:)
				(baron setCel: 2)
				(Say baronTalk 141 21 141 22) ; "I sincerely hope you will continue on your valiant adventures in our land. If anyone can rid the land of the brigands, it will be you."
			)
			(1
				(= seconds 2)
			)
			(2
				(egoHead hide:)
				(baron setCel: 0)
				(Say baronTalk 141 16) ; "Barnard."
			)
			(3
				(egoHead show:)
				(son setCel: 2)
				(Say sonTalk 141 23) ; "It would be nice if someone could finally defeat the brigands and claim the title."
			)
			(4
				(egoHead hide:)
				(baron setCel: 1)
				(Say baronTalk 141 24 141 25) ; "As you leave the castle tomorrow, you will receive the reward money I long ago posted for the safe return of my son, as a token of my thanks."
			)
			(5
				(gContMusic fade:)
				(= seconds 2)
			)
			(6
				(egoHead hide:)
				(Say baronTalk 141 26) ; "Do you have any questions?"
			)
			(7
				(client setScript: answerQs)
			)
		)
	)
)

(instance answerQs of Script
	(properties)

	(method (init)
		(baronTalk caller: self)
		(sonTalk caller: self)
		(egoHead dispose: delete:)
		(NormalEgo)
		(LookAt gEgo baron)
		(HandsOn)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 1) $0200)
			(client setScript: leaveRoom)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(if (not local1)
					(self changeState: 0)
				else
					(client setScript: leaveRoom)
				)
			)
		)
	)

	(method (handleEvent event)
		(clr)
		(cond
			(local1
				(baronTalk endTalk:)
				(client setScript: leaveRoom)
			)
			((super handleEvent: event))
			((Said 'talk,yes,please')
				(Say baronTalk 141 27) ; "Just ask about anything you wish to know."
			)
			((Said 'no,nap,rest,done')
				(HandsOff)
				(Say baronTalk 141 28) ; "I see that it is getting late."
				(= local1 1)
			)
			((Said 'ask>')
				(= local2 1)
				(cond
					((Said '//curse')
						(Say baronTalk 141 29 141 30 141 31) ; "Some years back, I tried to force the Ogress Baba Yaga to leave our valley, and she put a curse upon me that I should lose everything I held dear."
					)
					((Said '//prediction,countercurse')
						(Say baronTalk 141 32 141 33) ; "The prophecy stated,   Comes a hero from the East,   Free the man from in the beast;   Bring the child from out the band;   Drive the curser from the land."
					)
					((Said '//ogress,baba,baba,baba')
						(Say baronTalk 141 34) ; "I have attempted everything in my power to get her to go away. I fear it will take some sort of magic to be able to counteract her evil magic."
					)
					((Said '//magic,wizard,zara,erasmus,erana')
						(Say baronTalk 141 35) ; "I know very little of magic, much to my sorrow. Perhaps you should talk to the wizards -- Zara in the town, or Erasmus on Zauberberg."
					)
					((Said '//hill,zauberberg')
						(Say baronTalk 141 36) ; "Zauberberg, the 'magic mountain', is the home of Erasmus, a kindly, but rather eccentric, wizard. Zauberberg is directly east of here."
					)
					((Said '//elsa,girl,daughter')
						(Say baronTalk 141 37 141 38 141 39) ; "My beautiful little daughter was stolen away ten years ago by Baba Yaga's magic."
					)
					((Said '//baroness,wife')
						(Say baronTalk 141 40 141 41) ; "My wife has been gone for many years."
					)
					((Said '//bandit')
						(Say baronTalk 141 42 141 43 141 44 141 45) ; "If I had more guards, I would wipe the brigands out myself, now that I have my son at my side."
					)
					((Said '//yorick,jester')
						(Say baronTalk 141 46) ; "Yorick was my court jester, a man of infinite jest. He went off to find my daughter, but alas, poor Yorick never returned."
					)
					((Said '//prize')
						(Say baronTalk 141 47) ; "I have offered substantial rewards for the return of my son and my daughter, as well as for capturing or killing the leader and warlock of the brigands."
					)
					((Said '//leader')
						(Say baronTalk 141 48 141 49) ; "There have always been brigands around, but until their new leader and the warlock showed up a few years ago, they were not much of a problem."
					)
					((Said '//warlock')
						(Say baronTalk 141 50) ; "As if this valley hasn't been plagued with enough evil magic users! From what I have heard, his magic isn't powerful, but he uses it effectively."
					)
					((Said '//castle')
						(Say baronTalk 141 51) ; "This castle has been in the family for two centuries now. It was a gift from King Siegfried the Third."
					)
					((Said '//kobold,cave')
						(son setCel: 1)
						(Say sonTalk 141 52 141 53 141 54 141 55) ; "I rode off one morning with my men in search of monsters to fight. I got separated from my men when I came across the entrance to the cave."
					)
					((Said '//bear')
						(son setCel: 0)
						(Say sonTalk 141 56) ; "I would prefer not to talk about that."
					)
					((Said '//barnard,barnard,barnard')
						(Say baronTalk 141 57) ; "As you can plainly see, Barnard is back to his old self, thanks to you."
					)
					(else
						(= local2 0)
						(event claimed: 1)
						(switch (++ local0)
							(1
								(Say baronTalk 141 58) ; "Now that my son is back, I have much to do. Kindly restrict your questions to matters of import."
							)
							(2
								(Say baronTalk 141 59) ; "That is of no importance to your quest, and time is short."
							)
							(else
								(HandsOff)
								(Say baronTalk 141 28) ; "I see that it is getting late."
								(= local1 1)
							)
						)
					)
				)
				(if (and local2 (event claimed:))
					(SolvePuzzle 664 3)
				)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(baronTalk caller: self)
				(+= [gInvNum 2] 50) ; gold
				(Say baronTalk 141 60) ; "A servant is awaiting you outside to show you to your quarters. We will see you at supper later."
			)
			(1
				(= gClock 2800)
				(gCurRoom newRoom: 41)
			)
		)
	)
)

