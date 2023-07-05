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
	baba 1
	babaHead 2
	bat 3
	spider 4
	TP 5
	noBringDeath 6
	babaTalk 7
	teleport 8
	endGame 9
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
		y 51
		x 205
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
			((or (MouseClaimed self event 3) (Said 'look/baba,ogress'))
				(HighPrint 21 0) ; "That's one mean Ogress!"
			)
			((Said 'ask,talk/baba,ogress')
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
		(LoadMany rsSCRIPT 967 293 294)
		(super init:)
		(SolvePuzzle 652 2)
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
			((or (Said 'look/bat') (MouseClaimed bat event 3))
				(HighPrint 21 2) ; "There is a bat, all folded up within his wings, hanging on the wall."
			)
			((or (Said 'look/spider') (MouseClaimed spider event 3))
				(HighPrint 21 3) ; "Is that a SMILE on that spider's face?"
			)
			((or (Said 'look/web') (MouseClaimed web event 3))
				(HighPrint 21 4) ; "You HATE houses with cobwebs in the corners, especially when there's an immense spider squatting cheerily in the middle of the cobweb."
			)
			((or (Said 'look/window') (MouseClaimed hutWindow event 3))
				(HighPrint 21 5) ; "The glass seems to distort the view of the outside world."
			)
			((or (Said 'look/caldron,pan') (MouseClaimed cauldron event 3))
				(HighPrint 21 6) ; "There's a lot of SOMETHING cooking away in the huge black cauldron."
				(HighPrint 21 7) ; "The smell is awful, the color is sickening, and you don't even want to know what's being prepared for dinner."
			)
			((or (Said 'look/fire') (MouseClaimed fire event 3))
				(HighPrint 21 8) ; "The fire burns hot under the kettle."
			)
			((or (Said 'look/chimney') (MouseClaimed chimney event 3))
				(HighPrint 21 9) ; "The stone hearth and chimney radiates too much heat."
			)
			((or (Said 'look/cabinet') (MouseClaimed cupboard event 3))
				(HighPrint 21 10) ; "It's a plain wooden kitchen cupboard."
			)
			((or (Said 'look/dagger,implement') (MouseClaimed knives event 3))
				(HighPrint 21 11) ; "The kitchen knives look old but sharp."
			)
			((or (Said 'look/hay,bed,blanket') (MouseClaimed blanket event 3))
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
								(self setScript: (ScriptID 294 0)) ; nextWitch
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
							(self setScript: (ScriptID 294 0)) ; nextWitch
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
							(Said '[get,use,show,hold,prepare]/mirror[<magic]')
							(Said 'reflect[/spell]')
						)
						(if (gEgo has: 40) ; mirror
							(HighPrint 21 13) ; "You furtively grasp the Magic Mirror."
							(SetFlag 325)
						else
							(DontHave)
						)
					)
					((Said 'get')
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
									(self setScript: (ScriptID 294 0)) ; nextWitch
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
					((Said 'talk/baba')
						(HighPrint 21 15) ; "You cannot see the witch anywhere."
					)
					((Said 'talk')
						(HighPrint 21 16) ; "You might as well be talking to yourself."
					)
					((Said 'cast')
						(HighPrint 21 17) ; "Your magic is useless here."
					)
					((Said 'look>')
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
				((ScriptID 293 0) cue:) ; firstTalk
			)
			((and (== (event type:) evSAID) (> global114 1))
				(cond
					((Said 'yes,please')
						(baba setScript: 0)
						(= global114 0)
						(cond
							((<= global324 2)
								(User canInput: 0)
								((ScriptID 293 0) cue:) ; firstTalk
							)
							((== global324 3)
								(User canInput: 0)
								((ScriptID 294 0) cue:) ; nextWitch
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
				(TimePrint 6 21 21) ; "Look pets...we have a visitor!"
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
				(Print 21 22 #at -1 8 #width 125 #mode 1 #dispose #time 8) ; "Powers of Night, Shadows of Day Heed now my Words! Henceforth you STAY!"
				(= seconds 6)
			)
			(5
				(= local1 0)
				(baba setLoop: 6 setCycle: End)
				(= seconds 2)
			)
			(6
				(TimePrint 7 21 23) ; "Your body is frozen by the power of the witch's spell."
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
				(TimePrint 6 21 24) ; "Well Dearies! What shall we have for supper today?"
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
				(TimePrint 7 21 25) ; "Hero sandwiches? I had something more formal in mind."
				(= seconds 7)
			)
			(12
				(TimePrint 6 21 26) ; "Ah...that's it! Frog Legs Fricassee."
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(= seconds 6)
			)
			(13
				(babaHead setLoop: 5)
				(TimePrint 6 21 27) ; "Now how does that spell go.....?"
				(bat setCycle: 0)
				(spider setCycle: 0)
				(= seconds 6)
			)
			(14
				(babaHead setLoop: 4)
				(Print 21 28 #at -1 12 #width 125 #mode 1 #dispose #time 8) ; "Hear me, oh Powers Of Klatha and Mana! Turn now my guest Into species called Rana!"
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
				(TimePrint 8 21 29) ; "I learned that spell from Erasmus, kids. Doesn't it look delicious?"
				(= seconds 8)
			)
			(21
				(= local1 0)
				(spider setCycle: 0)
				(bat setCycle: 0)
				(babaHead stopUpd: hide:)
				(rm21 setScript: (ScriptID 293 0)) ; firstTalk
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
				(TimePrint 3 21 30) ; "Stubborn, aren't you?"
				(= seconds 3)
			)
			(1
				(TimePrint 5 21 31) ; "Well, you won't be so tough after you've simmered in a little wine sauce."
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(= seconds 5)
			)
			(2
				(baba setCel: 1)
				(babaHead setLoop: 5)
				(TimePrint 4 21 32) ; "Bon appetit, Dearies!"
				(= seconds 4)
			)
			(3
				(babaHead hide:)
				(EgoDead ; "Next time you are asked a question by someone who has just turned you into a frog, perhaps you should be more polite. It's better than being fricasseed!"
					21
					33
					80
					{ Now you're really in the soup! }
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
				(TimePrint 4 21 34) ; "It's just as well. I'd lose my dinner if you were brave."
				(= seconds 4)
			)
			(1
				(baba setCel: 1)
				(babaHead setLoop: 4)
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(TimePrint 5 21 35) ; "Lovies, it's about time we dine."
				(= seconds 4)
			)
			(2
				(babaHead hide:)
				(EgoDead 21 36 80 { Shame on you! } 82 myIcon 0 0) ; "Didn't anyone ever tell you that a hero is supposed to be brave even when he isn't? Looks like you found the coward's way out...sauteed in wine sauce."
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
				(TimePrint 4 21 37) ; "Well, if you won't be a sweet, then you'll be my meat!"
				(= seconds 4)
			)
			(1
				(baba setCel: 1)
				(babaHead setLoop: 4)
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(TimePrint 4 21 38) ; "Nothin' says lovin' like frog legs in the oven."
				(= seconds 4)
			)
			(2
				(babaHead hide:)
				(EgoDead 21 39 80 { Of all the lazy....! } 82 myIcon 0 0) ; "It seems a shame to have such a promising career go up in flames (assuming she decides to flambe you).  Wouldn't it have been better just to do a small favor for such a sweet little old Ogress?"
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
				(TimePrint 6 21 40) ; "No mandrake for me, eh? What a waste of spells you turned out to be."
				(= seconds 6)
			)
			(1
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(TimePrint 8 21 41) ; "Actually, since it's my breakfast time, we'll have some amphibian omelette with bacon and legs."
				(= seconds 6)
			)
			(2
				(babaHead hide:)
				(EgoDead 21 42 80 {Breakfast of Champions?} 82 myIcon 0 0) ; "At least you could have said "Yes" before you croaked!"
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
					(TimePrint 4 21 43) ; "You again?"
				else
					(TimePrint 4 21 44) ; "Hello, Hero."
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
				(Print 21 45 #at -1 12 #width 135 #mode 1 #dispose #time 10) ; "Powers that rule Over regions soggy: Change this creature Back into a froggy!"
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
				(TimePrint 6 21 46) ; "Ooooh...yummy! I'm glad you returned."
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
				(TimePrint 3 21 48) ; "The witch is hopping mad."
				(= seconds 3)
			)
			(4
				(TimePrint 8 21 49) ; "What have you DONE to me? How DARE you use my own spell against me? I'll, I'll....Oh oh!"
				(= seconds 8)
			)
			(5
				(NormalEgo)
				(LookAt gEgo baba)
				(TimePrint 10 21 50) ; "Hear me, Oh Element of Air and Wind. Give me the power to save my own skin."
				(= seconds 8)
			)
			(6
				((ScriptID 21 8) play:) ; teleport
				((ScriptID 21 5) ; TP
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
				((ScriptID 21 5) setCycle: End self) ; TP
			)
			(8
				((ScriptID 21 5) dispose:) ; TP
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

