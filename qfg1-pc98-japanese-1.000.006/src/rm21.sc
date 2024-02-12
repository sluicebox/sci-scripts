;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use Interface)
(use n802)
(use LoadMany)
(use DCIcon)
(use Chase)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm21 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(User canInput: 0)
	(switch global324
		(0
			(rm21 setScript: nameDeath)
		)
		(1
			(rm21 setScript: braveDeath)
		)
		(2
			(rm21 setScript: noFetchDeath)
		)
		(3
			(rm21 setScript: noBringDeath)
		)
	)
)

(instance myIcon of DCIcon
	(properties
		view 20
		loop 9
		cycleSpeed 8
	)
)

(instance teleport of Sound
	(properties
		priority 15
	)
)

(instance bubbleMusic of Sound
	(properties
		number 51
		priority 5
		loop -1
	)
)

(instance reflection of Prop
	(properties
		view 122
		loop 1
		cycleSpeed 1
	)
)

(instance babaHead of Prop
	(properties
		view 20
		loop 4
		cycleSpeed 1
	)
)

(instance spider of Prop
	(properties
		y 89
		x 245
		view 21
		cycleSpeed 1
	)
)

(instance bat of Prop
	(properties
		y 85
		x 215
		view 21
		loop 1
		cycleSpeed 1
	)
)

(instance TP of Prop
	(properties
		view 531
		cycleSpeed 1
	)
)

(instance cauldron of Prop
	(properties
		y 130
		x 86
		view 21
		loop 2
	)
)

(instance fire of Prop
	(properties
		y 133
		x 86
		view 21
		loop 3
	)
)

(instance blanket of View
	(properties
		y 151
		x 212
		view 21
		loop 4
	)
)

(instance baba of Act
	(properties
		yStep 1
		view 20
		cycleSpeed 2
		xStep 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed self event 3) (Said 'look,look/baba,ogress'))
				(HighPrint 21 0) ; "That's one mean Ogress!"
			)
			((Said 'ask,talk,talk/baba,ogress')
				(HighPrint 21 1) ; "There's no time for idle chatter."
			)
		)
	)
)

(instance rm21 of Rm
	(properties
		picture 21
		style 1
	)

	(method (dispose)
		(SetFlag 11)
		(myIcon dispose:)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 20 21 19 531 122)
		(LoadMany rsSOUND 51 (SoundFX 28))
		(LoadMany rsSCRIPT 967)
		(super init:)
		(SolvePuzzle 652 2)
		(if (gEgo has: 4) ; mandrake
			(ClearFlag 326)
		)
		(gContMusic fade:)
		(teleport number: (SoundFX 28) init:)
		(gKeyHandler add: self)
		(gMouseHandler addToFront: self)
		(gDirHandler add: self)
		(SL enable:)
		(ClearFlag 172)
		(bubbleMusic init: play:)
		(NormalEgo)
		(= global114 0)
		(gEgo loop: 1 posn: 202 165 init:)
		(spider setCycle: Fwd init: stopUpd:)
		(bat init:)
		(cauldron setPri: 10 setCycle: Fwd init:)
		(fire setCycle: Fwd init:)
		(blanket setPri: 2 ignoreActors: init: stopUpd: addToPic:)
	)

	(method (doit)
		(if (> global114 1)
			(-- global114)
		)
		(if (== global114 1)
			(= global114 0)
			(localproc_0)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'look,look/bat') (MouseClaimed bat event 3))
				(HighPrint 21 2) ; "There is a bat, all folded up within his wings, hanging on the wall."
			)
			((or (Said 'look,look/spider') (MouseClaimed spider event 3))
				(HighPrint 21 3) ; "Is that a SMILE on that spider's face?"
			)
			((or (Said 'look,look/web') (MouseClaimed web event 3))
				(HighPrint 21 4) ; "You HATE houses with cobwebs in the corners, especially when there's an immense spider squatting cheerily in the middle of the cobweb."
			)
			((or (Said 'look,look/window') (MouseClaimed hutWindow event 3))
				(HighPrint 21 5) ; "The glass seems to distort the view of the outside world."
			)
			((or (Said 'look,look/caldron,pan') (MouseClaimed cauldron event 3))
				(HighPrint 21 6) ; "There's a lot of SOMETHING cooking away in the huge black cauldron."
				(HighPrint 21 7) ; "The smell is awful, the color is sickening, and you don't even want to know what's being prepared for dinner."
			)
			((or (Said 'look,look/fire') (MouseClaimed fire event 3))
				(HighPrint 21 8) ; "The fire burns hot under the kettle."
			)
			((or (Said 'look,look/chimney') (MouseClaimed chimney event 3))
				(HighPrint 21 9) ; "The stone hearth and chimney radiates too much heat."
			)
			((or (Said 'look,look/cabinet') (MouseClaimed cupboard event 3))
				(HighPrint 21 10) ; "It's a plain wooden kitchen cupboard."
			)
			((or (Said 'look,look/dagger,implement') (MouseClaimed knives event 3))
				(HighPrint 21 11) ; "The kitchen knives look old but sharp."
			)
			((or (Said 'look,look/hay,bed,blanket') (MouseClaimed blanket event 3))
				(HighPrint 21 12) ; "The pile of straw covered by a blanket must be the occupant's bed."
			)
			((== (event type:) evMOUSEBUTTON)
				(if (not (& (event modifiers:) emSHIFT))
					(if (not local0)
						(= local0 1)
						(cond
							((gEgo has: 40) ; mirror
								(= global324 4)
								(self setScript: lastWitch)
							)
							((not (IsFlag 11))
								(self setScript: firstWitch)
							)
							((== global324 2)
								(= global324 3)
								(self setScript: nextWitch)
							)
							((== global324 3)
								(= global324 4)
								(self setScript: lastWitch)
							)
						)
					else
						(event claimed: 1)
					)
				)
			)
			((== (event type:) $0040) ; direction
				(if (not local0)
					(= local0 1)
					(cond
						((gEgo has: 40) ; mirror
							(= global324 4)
							(self setScript: lastWitch)
						)
						((not (IsFlag 11))
							(self setScript: firstWitch)
						)
						((== global324 2)
							(= global324 3)
							(self setScript: nextWitch)
						)
						((== global324 3)
							(= global324 4)
							(self setScript: lastWitch)
						)
					)
				else
					(event claimed: 1)
				)
			)
			((== (event type:) evSAID)
				(cond
					(
						(or
							(Said
								'[get,get,use,show,hold,prepare]/mirror[<magic]'
							)
							(Said 'reflect[/spell]')
						)
						(if (gEgo has: 40) ; mirror
							(HighPrint 21 13) ; "You furtively grasp the Magic Mirror."
							(SetFlag 325)
						else
							(DontHave)
						)
					)
					((Said 'get,get')
						(HighPrint 21 14) ; "You don't seem to be able to move."
						(if (not local0)
							(= local0 1)
							(cond
								((gEgo has: 40) ; mirror
									(= global324 4)
									(self setScript: lastWitch)
								)
								((not (IsFlag 11))
									(self setScript: firstWitch)
								)
								((== global324 2)
									(= global324 3)
									(self setScript: nextWitch)
								)
								((== global324 3)
									(= global324 4)
									(self setScript: lastWitch)
								)
							)
						else
							(event claimed: 1)
						)
					)
					((Said 'talk,talk/baba')
						(HighPrint 21 15) ; "You cannot see the witch anywhere."
					)
					((Said 'talk,talk')
						(HighPrint 21 16) ; "You might as well be talking to yourself."
					)
					((Said 'cast')
						(HighPrint 21 17) ; "Your magic is useless here."
					)
					((Said 'look,look>')
						(cond
							((Said '[<at,around][/hut,house,room]')
								(HighPrint 21 18) ; "A quick look around shows that this is a creepy place, despite the pot (cauldron?) simmering briskly on the fire. Look at the size of that spider!"
							)
							((Said '/baba,ogress')
								(HighPrint 21 15) ; "You cannot see the witch anywhere."
							)
							((or (Said '<up') (Said '/ceiling,roof'))
								(HighPrint 21 19) ; "The small hut has a beamed ceiling."
							)
							((or (Said '<down') (Said '/floor'))
								(HighPrint 21 20) ; "The floor is tidy, with a pile of straw in one corner."
							)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance babaTalk of Script
	(properties)

	(method (dispose)
		(gKeyHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(super init: &rest)
		(gKeyHandler add: self)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (> global114 0) (== global324 0) (proc802_2 event @global401))
				(= global114 0)
				(baba setScript: 0)
				(User canInput: 0)
				(firstTalk cue:)
			)
			((and (== (event type:) evSAID) (> global114 1))
				(cond
					((Said 'yes,please')
						(baba setScript: 0)
						(= global114 0)
						(cond
							((<= global324 2)
								(User canInput: 0)
								(firstTalk cue:)
							)
							((== global324 3)
								(User canInput: 0)
								(nextWitch cue:)
							)
						)
					)
					((Said 'no')
						(localproc_0)
					)
					(else
						(event claimed: 1)
						(localproc_0)
					)
				)
			)
		)
	)
)

(instance firstWitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 143 152 self)
			)
			(1
				(baba posn: 188 125 setLoop: 6 init:)
				(babaHead
					setLoop: 5
					setPri: 15
					posn: 188 91
					init:
					setCycle: Fwd
				)
				(teleport play:)
				(= cycles 5)
			)
			(2
				(gEgo loop: 0)
				(bat setCycle: End)
				(spider startUpd:)
				(= local1 1)
				(TimePrint 6 21 21 107) ; "Look pets...we have a visitor!"
				(= seconds 5)
			)
			(3
				(bat setLoop: 5 setCycle: End)
				(= local1 0)
				(babaHead setCycle: 0 hide:)
				(= cycles 10)
			)
			(4
				(babaHead setLoop: 4 setCycle: Fwd show:)
				(spider setCycle: 0)
				(= local1 1)
				(TimePrint 8 21 22 107) ; "Powers of Night, Shadows of Day Heed now my Words! Henceforth you STAY!"
				(= seconds 6)
			)
			(5
				(= local1 0)
				(baba setLoop: 6 setCycle: End)
				(= seconds 2)
			)
			(6
				(TimePrint 7 21 23 107) ; "Your body is frozen by the power of the witch's spell."
				(babaHead setCycle: 0 hide:)
				(= cycles 15)
			)
			(7
				(baba setLoop: 8 setCycle: Fwd setMotion: Chase gEgo 20 self)
			)
			(8
				(baba setCycle: 0)
				(babaHead
					setLoop: 5
					setCycle: Fwd
					posn: (baba x:) (- (baba y:) 34)
					setPri: (+ (baba priority:) 1)
					show:
				)
				(= cycles 2)
			)
			(9
				(= local1 1)
				(TimePrint 6 21 24 107) ; "Well Dearies! What shall we have for supper today?"
				(= seconds 4)
			)
			(10
				(babaHead setCycle: 0)
				(spider setCycle: Fwd)
				(bat cycleSpeed: 2 setCycle: Fwd)
				(= seconds 4)
			)
			(11
				(babaHead setLoop: 4 setCycle: Fwd)
				(bat setCycle: 0)
				(spider setCycle: 0)
				(TimePrint 7 21 25 107) ; "Hero sandwiches? I had something more formal in mind."
				(= seconds 7)
			)
			(12
				(TimePrint 6 21 26 107) ; "Ah...that's it! Frog Legs Fricassee."
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(= seconds 6)
			)
			(13
				(babaHead setLoop: 5)
				(TimePrint 6 21 27 107) ; "Now how does that spell go.....?"
				(bat setCycle: 0)
				(spider setCycle: 0)
				(= seconds 6)
			)
			(14
				(babaHead setLoop: 4)
				(TimePrint 8 21 28 107) ; "Hear me, oh Powers, Of Klatha and Mana! Turn now my guest, Into species called Rana!"
				(= seconds 6)
			)
			(15
				(= local1 0)
				(babaHead stopUpd: hide:)
				(baba setLoop: 6 setCycle: End)
				(= cycles 12)
			)
			(16
				(gEgo view: 19 loop: 3 cel: 0 setCycle: End)
				(teleport play:)
				(= cycles 10)
			)
			(17
				(baba setLoop: 8 setMotion: MoveTo 160 148 self)
			)
			(18
				(baba view: 20 setLoop: 7 setCycle: CT 3 1 self)
			)
			(19
				(gEgo ignoreActors: hide:)
				(baba setCycle: End self)
			)
			(20
				(babaHead
					setLoop: 5
					posn: (- (baba x:) 1) (- (baba y:) 32)
					setPri: (+ (baba priority:) 1)
					startUpd:
					show:
				)
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(= local1 1)
				(TimePrint 8 21 29 107) ; "I learned that spell from Erasmus, kids. Doesn't it look delicious?"
				(= seconds 8)
			)
			(21
				(= local1 0)
				(spider setCycle: 0)
				(bat setCycle: 0)
				(babaHead stopUpd: hide:)
				(rm21 setScript: firstTalk)
			)
		)
	)
)

(instance nameDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baba setScript: 0)
				(= global114 0)
				(babaHead setCycle: Fwd)
				(TimePrint 3 21 30 107) ; "Stubborn, aren't you?"
				(= seconds 3)
			)
			(1
				(TimePrint 5 21 31 107) ; "Well, you won't be so tough after you've simmered in a little wine sauce."
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(= seconds 5)
			)
			(2
				(baba setCel: 1)
				(babaHead setLoop: 5)
				(TimePrint 4 21 32 107) ; "Bon appetit, Dearies!"
				(= seconds 4)
			)
			(3
				(babaHead hide:)
				(EgoDead ; "Next time you are asked a question by someone who has just turned you into a frog, perhaps you should be more polite. It's better than being fricasseed!"
					21
					33
					80
					{ Now you're really in the soup!}
					82
					myIcon
					0
					0
				)
			)
		)
	)
)

(instance braveDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baba setScript: 0)
				(= global114 0)
				(babaHead setCycle: Fwd)
				(TimePrint 4 21 34 107) ; "It's just as well. I'd lose my dinner if you were brave."
				(= seconds 4)
			)
			(1
				(baba setCel: 1)
				(babaHead setLoop: 4)
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(TimePrint 5 21 35 107) ; "Lovies, it's about time we dine."
				(= seconds 4)
			)
			(2
				(babaHead hide:)
				(EgoDead ; "Didn't anyone ever tell you that a hero is supposed to be brave even when he isn't? Looks like you found the coward's way out...sauteed in wine sauce."
					21
					36
					80
					{ Shame on you!}
					82
					myIcon
					0
					0
				)
			)
		)
	)
)

(instance noFetchDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baba setScript: 0)
				(= global114 0)
				(babaHead setCycle: Fwd)
				(TimePrint 4 21 37 107) ; "Well, if you won't be a sweet, then you'll be my meat!"
				(= seconds 4)
			)
			(1
				(baba setCel: 1)
				(babaHead setLoop: 4)
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(TimePrint 4 21 38 107) ; "Nothin' says lovin' like frog legs in the oven."
				(= seconds 4)
			)
			(2
				(babaHead hide:)
				(EgoDead ; "It seems a shame to have such a promising career go up in flames (assuming she decides to flambe you).  Wouldn't it have been better just to do a small favor for such a sweet little old Ogress?"
					21
					39
					80
					{ Of all the lazy....!}
					82
					myIcon
					0
					0
				)
			)
		)
	)
)

(instance noBringDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baba setScript: 0)
				(= global114 0)
				(babaHead setCycle: Fwd)
				(TimePrint 6 21 40 107) ; "No mandrake for me, eh? What a waste of spells you turned out to be."
				(= seconds 6)
			)
			(1
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(TimePrint 8 21 41 107) ; "Actually, since it's my breakfast time, we'll have some amphibian omelette with bacon and legs."
				(= seconds 6)
			)
			(2
				(babaHead hide:)
				(EgoDead ; "At least you could have said "Yes" before you croaked!"
					21
					42
					80
					{Breakfast of Champions?}
					82
					myIcon
					0
					0
				)
			)
		)
	)
)

(instance lastWitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 120 152 self)
			)
			(1
				(baba setLoop: 6 posn: 168 122 init:)
				(babaHead
					posn: (baba x:) (- (baba y:) 34)
					init:
					setPri: 15
					setCycle: Fwd
				)
				(= cycles 5)
			)
			(2
				(if (IsFlag 11)
					(TimePrint 4 21 43 107) ; "You again?"
				else
					(TimePrint 4 21 44 107) ; "Hello, Hero."
				)
				(bat setCycle: End)
				(spider startUpd:)
				(= local1 1)
				(= seconds 2)
			)
			(3
				(= seconds 0)
				(gEgo loop: 0)
				(= local1 0)
				(babaHead setCycle: 0)
				(User canInput: 1)
				(= seconds 8)
			)
			(4
				(bat setCycle: 0)
				(spider setCycle: 0)
				(User canInput: 0)
				(= local1 1)
				(TimePrint 10 21 45 107) ; "Powers that rule, Over regions soggy: Change this creature, Back into a froggy!"
				(babaHead setCycle: Fwd)
				(= seconds 7)
			)
			(5
				(if (IsFlag 325)
					(client setScript: endGame)
				else
					(= local1 0)
					(babaHead setCycle: 0 hide:)
					(baba setCycle: End)
					(= seconds 2)
				)
			)
			(6
				(gEgo view: 19 loop: 3 cel: 0 setCycle: End)
				(babaHead setCycle: 0 hide:)
				(= cycles 15)
			)
			(7
				(spider setCycle: 0)
				(baba setLoop: 8 setCycle: Fwd setMotion: Chase gEgo 20 self)
			)
			(8
				(= local1 1)
				(babaHead
					posn: (baba x:) (- (baba y:) 34)
					setPri: 15
					setCycle: Fwd
					show:
				)
				(TimePrint 6 21 46 107) ; "Ooooh...yummy! I'm glad you returned."
				(= seconds 4)
			)
			(9
				(baba setLoop: 6 setCycle: 0)
				(EgoDead ; "Before you confront someone who is obviously more powerful than you are, give yourself a chance to reflect."
					21
					47
					80
					{Baba Yaga says you have good taste.}
					82
					myIcon
					0
					0
				)
			)
		)
	)
)

(instance endGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global324 4)
				(babaHead hide:)
				(baba view: 20 setLoop: 6 cycleSpeed: 1 setCycle: CT 3 1 self)
				(gEgo
					view: 122
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
			)
			(1
				(baba setCycle: End)
				(reflection
					setLoop: 1
					cel: 0
					posn: (+ (gEgo x:) 13) (- (gEgo y:) 33)
					init:
					setCycle: End self
				)
			)
			(2
				(baba view: 19 setLoop: 0 cel: 0 setCycle: End self)
				(gEgo setCycle: Beg)
			)
			(3
				(baba setLoop: 1 cycleSpeed: 0 setCycle: Fwd)
				(SolvePuzzle 653 50)
				(TimePrint 3 21 48 107) ; "The witch is hopping mad."
				(= seconds 3)
			)
			(4
				(TimePrint 8 21 49 107) ; "What have you DONE to me? How DARE you use my own spell against me? I'll, I'll....Oh oh!"
				(= seconds 8)
			)
			(5
				(NormalEgo)
				(LookAt gEgo baba)
				(TimePrint 10 21 50 107) ; "Hear me, Oh Element of Air and Wind. Give me the power to save my own skin."
				(= seconds 8)
			)
			(6
				(teleport play:)
				(TP
					posn: (gEgo x:) (gEgo y:)
					setPri: 15
					cel: 0
					cycleSpeed: 4
					init:
					setCycle: CT 6 1 self
				)
			)
			(7
				(gEgo dispose:)
				(TP setCycle: End self)
			)
			(8
				(TP dispose:)
				(SetFlag 172)
				(gCurRoom newRoom: 22)
			)
		)
	)
)

(instance web of RFeature
	(properties
		nsTop 70
		nsLeft 228
		nsBottom 117
		nsRight 255
	)
)

(instance hutWindow of RFeature
	(properties
		nsTop 67
		nsLeft 205
		nsBottom 100
		nsRight 227
	)
)

(instance chimney of RFeature
	(properties
		nsTop 57
		nsLeft 56
		nsBottom 142
		nsRight 113
	)
)

(instance cupboard of RFeature
	(properties
		nsTop 61
		nsLeft 111
		nsBottom 127
		nsRight 147
	)
)

(instance knives of RFeature
	(properties
		nsTop 65
		nsLeft 145
		nsBottom 86
		nsRight 165
	)
)

(instance firstTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baba setLoop: 0 setCycle: Fwd setMotion: MoveTo 119 136 self)
			)
			(1
				(baba setLoop: 1 setCycle: 0 cel: 0)
				(gEgo
					view: 20
					setLoop: 2
					cel: 0
					cycleSpeed: 1
					posn: (- (baba x:) 13) (- (baba y:) 25)
					setPri: (+ (baba priority:) 1)
					show:
				)
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(= local1 1)
				(TimePrint 4 21 51 107) ; "BE STILL!"
				(baba setCel: 1)
				(babaHead
					setLoop: 5
					posn: (baba x:) (- (baba y:) 34)
					setPri: (+ (baba priority:) 1)
					setCycle: Fwd
					show:
				)
				(= seconds 2)
			)
			(3
				(spider setCycle: 0)
				(bat setLoop: 1 cel: 4 setCycle: Beg)
				(= seconds 2)
			)
			(4
				(TimePrint 6 21 52 107) ; "Critics! We can't all be gourmands, I suppose."
				(babaHead setLoop: 4)
				(= seconds 4)
			)
			(5
				(babaHead setCycle: 0)
				(= seconds 2)
			)
			(6
				(baba setCel: 0)
				(babaHead setLoop: 3 setCycle: Fwd)
				(TimePrint 7 21 53 107) ; "Now, Oh-Soon-To-Be-Supper... I don't suppose you have a name?""
				(= seconds 5)
			)
			(7
				(= local1 (= seconds 0))
				(babaHead setCycle: 0)
				(baba setScript: babaTalk)
				(= global114 100)
				(User canInput: 1)
			)
			(8
				(gEgo setCycle: Fwd)
				(= local1 1)
				(Print 21 54 #at -1 160 #width 305 #mode 1 #time 8) ; "You try your best to croak out your name, or at least let the witch know that you do indeed have one."
				(= seconds 8)
			)
			(9
				(gEgo setCycle: 0)
				(babaHead setCycle: Fwd)
				(= local1 1)
				(TimePrint 9 21 55 107) ; "So you're the one who's trying to be a hero around here. The only good hero's a dead hero, I always say!"
				(= seconds 7)
			)
			(10
				(babaHead setCycle: 0)
				(= seconds 2)
			)
			(11
				(TimePrint 6 21 56 107) ; "But I do have a need for a brave fool. Are you brave?"
				(= global324 1)
				(babaHead setCycle: Fwd)
				(= seconds 4)
			)
			(12
				(= local1 (= seconds 0))
				(babaHead setCycle: 0)
				(baba setScript: babaTalk)
				(= global114 100)
				(User canInput: 1)
			)
			(13
				(gEgo setCycle: Fwd)
				(= local1 1)
				(Print 21 57 #at -1 160 #width 305 #mode 1 #time 7) ; "You make little froggy sounds, trying your best to indicate your agreement."
				(= seconds 7)
			)
			(14
				(gEgo setCycle: 0)
				(TimePrint 2 21 58 107) ; "Wellll..."
				(= seconds 2)
			)
			(15
				(babaHead setCycle: Fwd)
				(TimePrint 8 21 59 107) ; "If you're willing to do a small little teensy favor for me, I might reconsider having you for supper."
				(= seconds 6)
			)
			(16
				(babaHead setCycle: 0)
				(= seconds 2)
			)
			(17
				(babaHead setCycle: Fwd)
				(TimePrint 7 21 60 107) ; "I need the root of a mandrake plant that grows in the graveyard. Will you be a sweet and fetch me some?"
				(= seconds 8)
			)
			(18
				(= local1 (= seconds 0))
				(= global324 2)
				(babaHead setCycle: 0)
				(baba setScript: babaTalk)
				(= global114 100)
				(User canInput: 1)
			)
			(19
				(gEgo setCycle: Fwd)
				(= local1 1)
				(Print 21 61 #at -1 160 #width 305 #mode 1 #time 7) ; ""Anything but Frog Legs Fricassee!", you think.  You croak your agreement to the task."
				(= seconds 7)
			)
			(20
				(gEgo setCycle: 0)
				(spider setCycle: Fwd)
				(bat setLoop: 5 setCycle: Fwd)
				(baba setCel: 1)
				(babaHead setLoop: 4 setCycle: Fwd)
				(TimePrint 6 21 62 107) ; "And I had my mouth watering for frog. Oh well!"
				(= seconds 4)
			)
			(21
				(baba setCel: 0)
				(babaHead setCycle: 0 setLoop: 3)
				(= seconds 3)
			)
			(22
				(spider setCycle: 0)
				(bat setCycle: 0)
				(babaHead setCycle: Fwd)
				(TimePrint 9 21 63 107) ; "Hear what I say, And hear me right: Mandrake must be pulled, At precisely Midnight!"
				(= seconds 9)
			)
			(23
				(TimePrint 9 21 64 107) ; "This I tell you, And this I say: Return with the root, Ere the break of next day."
				(= seconds 9)
			)
			(24
				(TimePrint 9 21 65 107) ; "Hear what I say, And know I don't lie: Bring back the root, Or else you will die!!"
				(= seconds 9)
			)
			(25
				(= local1 0)
				(babaHead hide:)
				(gEgo hide:)
				(baba setLoop: 0 setCycle: Beg setMotion: MoveTo 140 136 self)
			)
			(26
				(baba setLoop: 7 cel: 5 setCycle: CT 3 -1 self)
			)
			(27
				(gEgo
					view: 19
					setLoop: 3
					cel: 7
					posn: (- (baba x:) 17) (+ (baba y:) 4)
					show:
				)
				(baba setCycle: Beg self)
			)
			(28
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(baba setLoop: 6 cel: 0 setCycle: End self)
				(babaHead
					setLoop: 4
					posn: (baba x:) (- (baba y:) 34)
					setPri: (+ (baba priority:) 1)
					show:
					setCycle: Fwd
				)
				(TimePrint 4 21 66 107) ; "You, Shoo!"
			)
			(29
				(babaHead hide:)
				(TP
					posn: (gEgo x:) (gEgo y:)
					setPri: 15
					init:
					setCycle: CT 5 1 self
				)
				(teleport play:)
			)
			(30
				(gEgo hide:)
				(TP setCycle: End)
				(= cycles 10)
			)
			(31
				(gCurRoom newRoom: 22)
			)
		)
	)
)

(instance nextWitch of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 120 152 self)
			)
			(1
				(baba setLoop: 6 posn: 168 122 init:)
				(babaHead
					posn: (baba x:) (- (baba y:) 34)
					init:
					setPri: 15
					setCycle: Fwd
				)
				(teleport play:)
				(= cycles 5)
			)
			(2
				(TimePrint 5 21 67 107) ; "Back so soon?"
				(bat setCycle: End)
				(spider startUpd:)
				(= local1 1)
				(= seconds 3)
			)
			(3
				(gEgo loop: 0)
				(babaHead setCycle: 0)
				(= seconds 2)
			)
			(4
				(bat setCycle: 0)
				(spider setCycle: 0)
				(TimePrint 10 21 68 107) ; "Spirits of Mist, And Creatures of Bog: Transform my guest, To the shape of a Frog."
				(babaHead setCycle: Fwd)
				(= seconds 7)
			)
			(5
				(= local1 0)
				(baba setCycle: End)
				(= seconds 2)
			)
			(6
				(gEgo view: 19 loop: 3 cel: 0 setCycle: End)
				(teleport play:)
				(babaHead setCycle: 0 hide:)
				(= cycles 15)
			)
			(7
				(spider setCycle: 0)
				(baba setLoop: 8 setCycle: Fwd setMotion: Chase gEgo 20 self)
			)
			(8
				(baba setCycle: 0)
				(babaHead
					posn: (baba x:) (- (baba y:) 34)
					setPri: (+ (baba priority:) 1)
					setCycle: Fwd
					show:
				)
				(= cycles 2)
			)
			(9
				(= local1 1)
				(TimePrint 7 21 69 107) ; "This I vow: Stay there now!"
				(= seconds 4)
			)
			(10
				(= local1 0)
				(babaHead setCycle: 0)
				(baba setLoop: 6 cel: 0 setCycle: End)
				(= seconds 3)
			)
			(11
				(= local1 1)
				(TimePrint 8 21 70 107) ; "Once again you're a frog, and once again you can't move. You find it very exasperating!"
				(= seconds 8)
			)
			(12
				(babaHead setCycle: Fwd)
				(TimePrint 6 21 71 107) ; "Yum, Yum. Froggie Frappe!"
				(= seconds 5)
			)
			(13
				(babaHead setCycle: 0)
				(bat setLoop: 5 setCycle: Fwd)
				(spider setCycle: Fwd)
				(= seconds 4)
			)
			(14
				(bat setCycle: 0)
				(spider setCycle: 0)
				(babaHead setCycle: Fwd)
				(TimePrint 8 21 72 107) ; "Did you bring me my mandrake like you promised?"
				(= seconds 5)
			)
			(15
				(= local1 (= seconds 0))
				(= global324 3)
				(babaHead setCycle: 0)
				(baba setScript: babaTalk)
				(= global114 100)
				(User canInput: 1)
			)
			(16
				(= local1 1)
				(Print 21 73 #at -1 160 #width 305 #mode 1 #time 8) ; "As you make a feeble croaking sound, you try to nod your head."
				(= seconds 8)
			)
			(17
				(babaHead setCycle: Fwd)
				(TimePrint 5 21 74 107) ; "Well? Where is it?"
				(= seconds 3)
			)
			(18
				(babaHead setCycle: 0)
				(= seconds 5)
			)
			(19
				(babaHead setLoop: 5 setCycle: Fwd)
				(TimePrint 7 21 75 107) ; "What's the matter? Got a frog in your throat?"
				(= seconds 5)
			)
			(20
				(bat setCycle: Fwd)
				(spider setCycle: Fwd)
				(babaHead setCycle: 0)
				(= seconds 3)
			)
			(21
				(bat setCycle: 0)
				(spider setCycle: 0)
				(babaHead setLoop: 4 setCycle: Fwd)
				(TimePrint 14 21 76 107) ; "I suppose I'll have to turn you back into whatever it is that you were. Pity! You're much more appetizing this way."
				(= seconds 12)
			)
			(22
				(babaHead setCycle: 0)
				(= seconds 2)
			)
			(23
				(babaHead setCycle: Fwd)
				(TimePrint 12 21 77 107) ; "Creatures of Bog, And Spirits of Fog: Return the true form, To this rather dumb Frog."
				(= seconds 9)
			)
			(24
				(= local1 0)
				(babaHead setCycle: 0)
				(baba setCycle: End)
				(= seconds 3)
			)
			(25
				(teleport play:)
				(gEgo setCycle: Beg self)
			)
			(26
				(NormalEgo)
				(gEgo loop: 0)
				(babaHead setCycle: Fwd)
				(= local1 1)
				(TimePrint 6 21 78 107) ; "Now, did you put it in your backpack?"
				(= seconds 5)
			)
			(27
				(= local1 0)
				(babaHead hide:)
				(baba setMotion: Chase gEgo 10)
				(= cycles 5)
			)
			(28
				(if (gEgo has: 4) ; mandrake
					(baba setPri: 9)
					(babaHead
						posn: (baba x:) (- (baba y:) 34)
						setPri: 10
						setCycle: Fwd
						show:
					)
					(= local1 1)
					(SolvePuzzle 654 3)
					(TimePrint 5 21 79 107) ; "Ah! Here it is."
					(gEgo use: 4) ; mandrake
					(ClearFlag 326)
					(= seconds 5)
				else
					(rm21 setScript: noBringDeath)
				)
			)
			(29
				(bat setCycle: Fwd)
				(spider setCycle: Fwd)
				(babaHead setLoop: 5)
				(TimePrint 5 21 80 107) ; "Kids! We have it!"
				(= seconds 4)
			)
			(30
				(= local1 0)
				(babaHead setCycle: 0)
				(= seconds 2)
			)
			(31
				(bat setCycle: 0)
				(spider setCycle: 0)
				(babaHead hide:)
				(baba
					setPri: -1
					setMotion: MoveTo (+ (baba x:) 10) (- (baba y:) 5) self
				)
			)
			(32
				(babaHead
					posn: (baba x:) (- (baba y:) 34)
					setPri: (+ (baba priority:) 1)
					setLoop: 4
					setCycle: Fwd
					show:
				)
				(= local1 1)
				(TimePrint 10 21 81 107) ; "That's it! The final ingredient. Now we can make our greatest creation..."
				(= seconds 10)
			)
			(33
				(bat setCycle: Fwd)
				(spider setCycle: Fwd)
				(babaHead setLoop: 5)
				(TimePrint 4 21 82 107) ; "MANDRAKE MOUSSE!"
				(= seconds 4)
			)
			(34
				(babaHead setCycle: 0)
				(= seconds 3)
			)
			(35
				(babaHead setCycle: Fwd)
				(TimePrint 10 21 83 107) ; "What's that, children? You think we should reward our lackey here?"
				(= seconds 12)
			)
			(36
				(babaHead setLoop: 4)
				(TimePrint 10 21 84 107) ; "Very well, ex-frog. I'll let you live this time. Next time, though, it's frog legs for sure!"
				(= seconds 8)
			)
			(37
				(babaHead setCycle: 0 hide:)
				(= seconds 2)
			)
			(38
				(= local1 0)
				(baba setLoop: 6 cel: 0 setCycle: End self)
				(babaHead
					setLoop: 4
					posn: (baba x:) (- (baba y:) 34)
					setPri: (+ (baba priority:) 1)
					show:
					setCycle: Fwd
				)
				(TimePrint 4 21 85 107) ; "So...Go!"
			)
			(39
				(babaHead hide:)
				(TP
					posn: (gEgo x:) (gEgo y:)
					setPri: 15
					init:
					setCycle: CT 6 1 self
				)
				(teleport play:)
			)
			(40
				(gEgo hide:)
				(TP setCycle: End)
				(= cycles 15)
			)
			(41
				(client setScript: 0)
				(gCurRoom newRoom: 22)
			)
		)
	)
)

