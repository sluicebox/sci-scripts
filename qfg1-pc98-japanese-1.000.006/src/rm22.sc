;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use n802)
(use LoadMany)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm22 0
	hut 1
	walkEm 2
	flyAway 3
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 &tmp [temp0 4] [temp4 400])
	(clr)
	(Format @temp4 &rest)
	(TextSize @[temp0 0] @temp4 gUserFont 0)
	(Print
		@temp4
		#at
		-1
		130
		#width
		(if (> [temp0 2] 24) 300 else 0)
		#mode
		1
		#dispose
		#time
		param1
	)
)

(procedure (localproc_1)
	(HighPrint 22 0) ; "Looking around, you get the feeling that this is not a very friendly place to be."
)

(procedure (localproc_2)
	(HighPrint 22 1) ; "All the other skulls have glowing eyes. But me?....noooo! I don't need lovely glowing eyes! Just open and close the gate, that's all I'm good for."
	(HighPrint 22 2) ; "But if you can give me a glowing gem for my eyes, then I'll let you in the gate."
	(HighPrint 22 3) ; "Well, is it a deal or isn't it?"
	(= global114 100)
)

(procedure (localproc_3)
	(HighPrint 22 4) ; "You know the deal! Get me a glowing gem for my eyes, and I'll let you in."
	(HighPrint 22 5) ; "Do you agree to the deal?"
	(= global114 100)
)

(instance wing1 of Act
	(properties
		yStep 4
		view 22
		loop 8
		illegalBits 0
		xStep 6
	)
)

(instance wing2 of Act
	(properties
		yStep 4
		view 22
		loop 9
		illegalBits 0
		xStep 6
	)
)

(instance hut of Act
	(properties
		yStep 4
		view 22
		loop 4
		illegalBits 0
		xStep 6
	)
)

(instance hutDoor of Act
	(properties
		view 22
		loop 5
		cycleSpeed 1
		illegalBits 0
	)
)

(instance frontLeg of Act
	(properties
		yStep 4
		view 22
		illegalBits 0
		xStep 6
	)
)

(instance frontFoot of Act
	(properties
		yStep 4
		view 22
		loop 1
		cel 1
		illegalBits 0
		xStep 6
	)
)

(instance backLeg of Act
	(properties
		yStep 4
		view 22
		loop 2
		illegalBits 0
		xStep 6
	)
)

(instance backFoot of Act
	(properties
		yStep 4
		view 22
		loop 3
		cel 1
		illegalBits 0
		xStep 6
	)
)

(instance gate of Act
	(properties
		y 158
		x 191
		view 23
		illegalBits 0
	)
)

(instance dirt of Act
	(properties
		y 156
		x 191
		view 23
		loop 1
		illegalBits 0
	)
)

(instance eyes of Act
	(properties
		y 130
		x 189
		z 2
		view 23
		loop 3
		cycleSpeed 1
		illegalBits 0
	)
)

(instance skull1 of Extra
	(properties
		y 88
		x 117
		view 23
		loop 4
		cycleType 1
		minPause 40
		maxPause 80
		minCycles 2
		maxCycles 4
	)
)

(instance skull2 of Extra
	(properties
		y 89
		x 251
		view 23
		loop 4
		cycleType 1
		minPause 40
		maxPause 80
		minCycles 2
		maxCycles 4
	)
)

(instance skull3 of Extra
	(properties
		y 88
		x 72
		view 23
		loop 6
		cycleType 1
		minPause 40
		maxPause 80
		minCycles 2
		maxCycles 4
	)
)

(instance skull4 of Extra
	(properties
		y 85
		x 14
		view 23
		loop 5
		cycleType 1
		minPause 40
		maxPause 80
		minCycles 2
		maxCycles 4
	)
)

(instance skull5 of Extra
	(properties
		y 82
		x 295
		view 23
		loop 5
		cycleType 1
		minPause 40
		maxPause 80
		minCycles 2
		maxCycles 4
	)
)

(instance TP of Act
	(properties
		y 160
		x 152
		view 531
		cycleSpeed 1
		illegalBits 0
	)
)

(instance tpSound of Sound
	(properties
		number 28
		priority 1
	)
)

(instance tromp of Sound
	(properties
		number 66
		priority 1
	)
)

(instance rm22 of Rm
	(properties
		picture 22
		style 0
		south 33
	)

	(method (dispose)
		(ClearFlag 171)
		(SetFlag 12)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 22 23 19 531 516)
		(LoadMany rsSOUND 23 (SoundFX 28) (SoundFX 66))
		(super init:)
		(gKeyHandler add: self)
		(SL enable:)
		(NormalEgo)
		(= global114 0)
		(gContMusic number: 23 loop: -1 play:)
		(if (not (IsFlag 173))
			(if (IsFlag 172)
				(= local0 167)
				(= local1 96)
				(hut
					setLoop: 4
					ignoreActors:
					posn: local0 96
					setPri: 4
					init:
					stopUpd:
				)
				(frontFoot
					setLoop: 1
					setPri: 3
					ignoreActors:
					posn: (- local0 27) (- local1 7)
					init:
					stopUpd:
				)
				(backFoot
					setLoop: 3
					setPri: 2
					ignoreActors:
					posn: (+ local0 38) (- local1 8)
					init:
					stopUpd:
				)
			else
				(= local0 143)
				(= local1 40)
				(frontLeg
					setLoop: 0
					setPri: 3
					ignoreActors:
					posn: (- local0 20) local1
					init:
					stopUpd:
				)
				(backLeg
					setLoop: 2
					setPri: 2
					ignoreActors:
					posn: (+ local0 40) local1
					init:
					stopUpd:
				)
				(frontFoot
					setLoop: 1
					setPri: 3
					ignoreActors:
					posn: (- local0 27) (+ local1 31)
					init:
					stopUpd:
				)
				(backFoot
					setLoop: 3
					setPri: 2
					ignoreActors:
					posn: (+ local0 38) (+ local1 32)
					init:
					stopUpd:
				)
				(gate setLoop: 0 setPri: 11 init: stopUpd:)
				(dirt ignoreActors: setPri: 11 init: stopUpd: hide:)
				(bonehead ignoreActors: setCycle: Fwd setPri: 11 init: stopUpd:)
				(eyes ignoreActors: setPri: 12 init: setCycle: Fwd)
				(if (< global323 4)
					(eyes stopUpd: hide:)
				)
				(hut
					setLoop: 4
					ignoreActors:
					posn: local0 local1
					setPri: 4
					init:
					stopUpd:
				)
			)
		)
		(skull1 ignoreActors: setPri: 12 init:)
		(skull2 ignoreActors: setPri: 12 init:)
		(skull3 ignoreActors: setPri: 12 init:)
		(skull4 ignoreActors: setPri: 12 init:)
		(skull5 ignoreActors: setPri: 12 init:)
		(if (IsFlag 173)
			(skull1 stopUpd:)
			(skull2 stopUpd:)
			(skull3 stopUpd:)
			(skull4 stopUpd:)
			(skull5 stopUpd:)
		)
		(if (== gPrevRoomNum 21)
			(cond
				((< global324 3)
					(gEgo
						view: 19
						loop: 2
						cel: 7
						posn: 152 160
						ignoreActors:
					)
					(TP ignoreActors: setPri: 15 init: setScript: frogIn)
				)
				((== global324 4)
					(hut setScript: flyAway)
				)
				(else
					(gEgo posn: 152 160 loop: 2)
					(TP ignoreActors: setPri: 15 init: setScript: frogIn)
				)
			)
		else
			(gEgo posn: 225 189 init: setMotion: MoveTo 230 180)
		)
	)

	(method (doit)
		(if
			(and
				(gEgo inRect: 179 0 191 102)
				(IsFlag 172)
				(not local3)
				(< global324 4)
			)
			(ClearFlag 172)
			(gCurRoom newRoom: 21)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(proc802_2
					event
					(switch (gGame parseLang:)
						(81 {\c1\ac\b2\db\c9 \ba\d4})
						(else {hut of brown})
					)
				)
				(cond
					((or (not local2) (IsFlag 172))
						(HighPrint 22 6) ; "Nothing happens."
					)
					(
						(proc802_1
							(User inputLineAddr:)
							(switch (gGame parseLang:)
								(81 {\bb\b1 \bd\dc\da})
								(else {now sit down})
							)
						)
						(SolvePuzzle 657 7)
						(if (not (hut script:))
							(hut setScript: walkEm)
						else
							(Print 22 7 #title {HUT%j\ba\d4} #at -1 20) ; "I'm moving as fast as I can!"
						)
					)
					(else
						(HighPrint 22 6) ; "Nothing happens."
					)
				)
			)
			((== (event type:) evSAID)
				(cond
					((Said 'look,look>')
						(cond
							((Said '[<at,around][/!*]')
								(localproc_1)
							)
							((Said '/hut,house')
								(HighPrint 22 8) ; "The hut is a strange little house perched on chicken legs."
							)
							((Said '/leg,feet')
								(HighPrint 22 9) ; "Those are the biggest chicken legs you've ever seen."
							)
							((Said '/fence,fence')
								(HighPrint 22 10) ; "The sharp ends of the fence are covered with some nasty-looking green slime."
							)
							((Said '/gate')
								(if local2
									(HighPrint 22 11) ; "The gate's gone."
								else
									(HighPrint 22 12) ; "The large skull on the gate seems to stare vacantly at you."
								)
							)
							((Said '/goo')
								(if (IsFlag 98)
									(HighPrint 22 13) ; "It looks a lot like the slime that was eating away the barstool at the tavern."
								else
									(HighPrint 22 14) ; "You've never seen anything like it. It looks quite unhealthy."
								)
							)
							((Said '/skull,head')
								(HighPrint 22 15) ; "The skulls on top of the fence have eerily glowing eyes."
								(if (not local2)
									(if (< global323 4)
										(HighPrint 22 12) ; "The large skull on the gate seems to stare vacantly at you."
									else
										(HighPrint 22 16) ; "The eyes of the large skull on the gate flash merrily away at you."
									)
								)
							)
							((Said '/window')
								(HighPrint 22 17) ; "You can see nothing through the windows of the hut."
							)
							((Said '/door')
								(if (IsFlag 172)
									(HighPrint 22 18) ; "The door is open, but hardly inviting."
								else
									(HighPrint 22 19) ; "The door of the hut is ornately decorated."
								)
							)
							((or (Said '/tree,bush,boulder') (Said '<up,down'))
								(HighPrint 22 20) ; "Your eyes are drawn to the incredible hut on chicken legs."
							)
						)
					)
					((Said 'nap,nap,rest,rest')
						(if (== (gEgo view:) 19)
							(HighPrint 22 21) ; "Now???"
						else
							(event claimed: 0)
						)
					)
					((Said 'japaneseclimbup,climb,climb>')
						(cond
							((Said '/fence,fence,gate')
								(HighPrint 22 22) ; "The green slime dripping off of the fence top makes you realize that climbing is not a good idea."
							)
							((Said '/hut,leg,chicken')
								(cond
									((IsFlag 172)
										(HighPrint 22 23) ; "What's to climb?"
									)
									(local2
										(HighPrint 22 24) ; "You have second thoughts, and you decide not to attempt such a potentially dangerous excursion."
									)
									(else
										(HighPrint 22 25) ; "You have to get there, first."
									)
								)
							)
							((Said '/boulder,cliff')
								(HighPrint 22 26) ; "Too much work."
							)
						)
					)
					((Said 'yes,no,please')
						(HighPrint 22 27) ; "Huh?"
					)
					((Said 'say,recite,talk,talk/rhyme,hut')
						(HighPrint 22 28) ; "Ok, go ahead and say the rhyme."
					)
				)
			)
		)
	)
)

(instance bonehead of Act
	(properties
		y 137
		x 190
		z 1
		view 23
		loop 2
		illegalBits 0
	)

	(method (doit)
		(if (and (== (gEgo onControl: 1) 16384) (not (IsFlag 171)))
			(SetFlag 171)
			(bonehead setScript: boneTalk)
		)
		(if (> global114 1)
			(-- global114)
		)
		(if (== global114 1)
			(= global114 0)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(if (> global114 1)
					(cond
						(
							(or
								(Said 'yes,please,deal,deal')
								(Said 'make/deal,deal')
							)
							(= global114 0)
							(switch global323
								(0
									(HighPrint 22 27) ; "Huh?"
								)
								(1
									(HighPrint 22 29) ; "The deal is made, then. A glowing gem in exchange for an opportunity to see Baba Yaga herself."
									(= global323 3)
									(SolvePuzzle 655 2)
								)
								(3
									(HighPrint 22 30) ; "Give me my gem!!"
								)
								(4
									(HighPrint 22 31) ; "Hey, it's your life!"
									(gate setScript: openGate)
								)
							)
						)
						((Said 'no')
							(= global114 0)
							(switch global323
								(0
									(HighPrint 22 27) ; "Huh?"
								)
								(1
									(HighPrint 22 32) ; "No gem, no entry. That's the deal."
									(= global323 2)
								)
								(2
									(HighPrint 22 32) ; "No gem, no entry. That's the deal."
								)
								(3
									(HighPrint 22 33) ; "What kind of hero are you? Can't even find a little glowing gem for me to see with!"
								)
								(4
									(HighPrint 22 31) ; "Hey, it's your life!"
								)
							)
						)
						(else
							(= global114 80)
							(HighPrint 22 34) ; "Just answer the question, will ya?"
							(switch global323
								(0
									(HighPrint 22 27) ; "Huh?"
								)
								(3
									(HighPrint 22 35) ; "Do you have my gem?"
								)
								(4
									(HighPrint 22 36) ; "Do you want back in?"
								)
								(else
									(HighPrint 22 37) ; "Is it a deal or not?"
								)
							)
							(event claimed: 1)
						)
					)
				)
				(cond
					((Said 'talk,talk')
						(bonehead setScript: boneTalk)
					)
					((Said 'open,open,open[<gate]')
						(if (== global323 4)
							(HighPrint 22 38) ; "Right!"
							(gate setScript: openGate)
						else
							(HighPrint 22 39) ; "Not until you get my gem!"
						)
					)
					((Said 'ask>')
						(cond
							((== global323 0)
								(event claimed: 1)
								(HighPrint 22 40) ; "Hey! Where's your manners? Let me tell you something, here!"
								(bonehead setScript: boneTalk)
							)
							((Said '//deal,deal')
								(switch global323
									(0
										(HighPrint 22 41) ; "Wait a minute...I'll get around to that."
										(bonehead setScript: boneTalk)
									)
									(1
										(localproc_2)
									)
									(2
										(localproc_3)
									)
									(3
										(localproc_3)
									)
									(4
										(HighPrint 22 42) ; "You kept your end of the deal, all right!"
									)
								)
							)
							((Said '//baba')
								(if (IsFlag 11)
									(HighPrint 22 43) ; "What's to tell? You've seen her for yourself."
								else
									(HighPrint 22 44) ; "Baba Yaga is the most powerful Ogress around. If you have any brains (and it looks like you don't), you'll stay away from her."
								)
							)
							((Said '//ogress')
								(HighPrint 22 45) ; "Some hero YOU are! Don't know what an Ogre is. Just check out Baba Yaga!"
							)
							((Said '//gem')
								(switch global323
									(0
										(bonehead setScript: boneTalk)
									)
									(1
										(localproc_2)
									)
									(2
										(localproc_3)
									)
									(3
										(HighPrint 22 46) ; "All I ask for is a little gem or jewel that glows in the dark.  You're the big hero, so go find one."
									)
									(else
										(HighPrint 22 47) ; "It's just the right color!"
									)
								)
							)
							((Said '//eye')
								(if (< global323 4)
									(HighPrint 22 48) ; "I wish I had some."
								else
									(HighPrint 22 49) ; "I'm thrilled to have some!"
								)
							)
							((Said '//skull')
								(HighPrint 22 50) ; "The bone brains on top of the fence are Baba Yaga's spies. That's why THEY have glowing eyes."
							)
							((Said '//gate')
								(HighPrint 22 51) ; "It's not much, but I call it home."
							)
							((Said '//fence,fence')
								(HighPrint 22 52) ; "You've seen one, you've seen them all, I say."
								(HighPrint 22 53) ; "Of course, most fences aren't poisoned on top!"
							)
							((Said '//hut,house')
								(HighPrint 22 54) ; "Baba Yaga's hut will squat down if you say the rhyme."
							)
							((Said '//rhyme')
								(HighPrint 22 55) ; "The rhyme is: 'Hut of brown, now sit down'."
								(SetFlag 356)
							)
							(else
								(HighPrint 22 56) ; "My time is important, and I'm very busy, as you can well see. Ask me about something important."
								(event claimed: 1)
							)
						)
					)
					((Said 'give[/eye,gem,skull][/skull,gem,eye]')
						(if (gEgo has: 13) ; magic gem
							(if (== (gEgo onControl: 1) 16384)
								(SolvePuzzle 656 10)
								(bonehead setScript: putEyes)
							else
								(NotClose)
							)
						else
							(DontHave)
						)
					)
				)
			)
		)
	)
)

(instance putEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(EgoGait 0 0) ; walking
				(gEgo illegalBits: 0 setMotion: MoveTo 189 165 self)
			)
			(1
				(gEgo loop: 3 forceUpd:)
				(= cycles 2)
			)
			(2
				(HighPrint 22 57 25 4) ; "You place the glowing gem inside the skull."
				(gEgo use: 13) ; magic gem
				(eyes startUpd: show:)
				(= global323 4)
				(self cue:)
			)
			(3
				(gEgo setMotion: MoveTo 200 175 self)
			)
			(4
				(NormalEgo)
				(gEgo loop: 3 forceUpd:)
				(= seconds 4)
			)
			(5
				(SetFlag 336)
				(HighPrint 22 58) ; "I can see! I have eyes again!!"
				(HighPrint 22 59) ; "Yeccchhh! Is THAT what you look like???"
				(HighPrint 22 60) ; "Oh well! Have fun visiting Baba Yaga. And good luck....you'll need it!"
				(self cue:)
			)
			(6
				(gate setScript: openGate)
			)
		)
	)
)

(instance opener of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(if (or (not (IsFlag 12)) (!= gPrevRoomNum 0))
					(localproc_1)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance boneTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bonehead startUpd:)
				(= cycles 10)
			)
			(1
				(switch global323
					(0
						(= global323 1)
						(HighPrint 22 61) ; "Baba Yaga does not welcome strangers! You have to deal with me before you can enter."
					)
					(1
						(HighPrint 22 62) ; "Baba Yaga is one tough magic user. If you're so stupid that you want to enter, perhaps we can make a deal."
					)
					(2
						(HighPrint 22 63) ; "So you're back! Changed your mind about making a little deal, hero?"
						(= global114 100)
					)
					(3
						(HighPrint 22 64) ; "Did you get it? Did you get my glowing gem???"
						(= global114 100)
					)
					(else
						(if (and (IsFlag 11) (gEgo has: 4)) ; mandrake
							(HighPrint 22 65) ; "So you made it back, did you? She is expecting you."
							(gate setScript: openGate)
						else
							(HighPrint 22 66) ; "You again?? Do you really want to go back in there?"
							(= global114 100)
						)
					)
				)
				(self cue:)
			)
			(2
				(= cycles 10)
			)
			(3
				(HandsOn)
				(bonehead cel: 0 stopUpd: setScript: 0)
				(if (and (gEgo has: 4) (IsFlag 336)) ; mandrake
					(gate setScript: openGate)
				)
			)
		)
	)
)

(instance openGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bonehead dispose:)
				(eyes dispose:)
				(gate ignoreActors: setPri: 1 setMotion: MoveTo 191 230)
				(dirt show: setCycle: Fwd startUpd:)
				(= cycles 10)
			)
			(1
				(if (not (IsFlag 11))
					(HighPrint 22 67) ; "I hope you can remember the rhyme."
				else
					(HighPrint 22 68) ; "Bye!"
				)
				(self cue:)
			)
			(2
				(gate setMotion: MoveTo 191 230 self)
			)
			(3
				(gate stopUpd:)
				(= local2 1)
				(dirt setCycle: 0 setCel: 0 stopUpd:)
				(HandsOn)
			)
		)
	)
)

(instance walkEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(frontLeg setCel: 1)
				(frontFoot
					setCel: 0
					posn: (+ (frontFoot x:) 5) (- (frontFoot y:) 5)
				)
				(= cycles 2)
			)
			(1
				(frontLeg
					setMotion:
						MoveTo
						(+ (frontLeg x:) 12)
						(+ (frontLeg y:) 8)
						self
				)
				(frontFoot
					setMotion: MoveTo (+ (frontFoot x:) 12) (+ (frontFoot y:) 8)
				)
			)
			(2
				(frontLeg
					setMotion:
						MoveTo
						(+ (frontLeg x:) 12)
						(+ (frontLeg y:) 8)
						self
				)
				(frontFoot
					setMotion: MoveTo (+ (frontFoot x:) 12) (+ (frontFoot y:) 8)
				)
				(hut setMotion: MoveTo (+ (hut x:) 12) (+ (hut y:) 8))
			)
			(3
				(frontLeg setCel: 0)
				(frontFoot
					setCel: 1
					posn: (- (frontFoot x:) 5) (+ (frontFoot y:) 5)
				)
				(hut setMotion: MoveTo (+ (hut x:) 12) (+ (hut y:) 8))
				(backLeg setCel: 1)
				(backFoot
					setCel: 0
					posn: (+ (backFoot x:) 5) (- (backFoot y:) 5)
				)
				(if (gEgo inRect: 123 0 235 103)
					(HandsOff)
					(gEgo
						view: 516
						setLoop: 3
						cel: 0
						cycleSpeed: 1
						setCycle: End
					)
					(= local3 1)
				)
				(= cycles 2)
			)
			(4
				(tromp number: (SoundFX 66) init: play:)
				(ShakeScreen 3)
				(backLeg
					setMotion:
						MoveTo
						(+ (backLeg x:) 24)
						(+ (backLeg y:) 16)
						self
				)
				(backFoot
					setMotion: MoveTo (+ (backFoot x:) 24) (+ (backFoot y:) 16)
				)
			)
			(5
				(backLeg setCel: 0)
				(backFoot
					setCel: 1
					posn: (- (backFoot x:) 5) (+ (backFoot y:) 5)
				)
				(= cycles 2)
			)
			(6
				(tromp play:)
				(ShakeScreen 3)
				(= cycles 2)
			)
			(7
				(frontLeg
					setCel: 1
					posn: (- (frontLeg x:) 5) (+ (frontLeg y:) 5)
				)
				(backLeg setCel: 1 posn: (- (backLeg x:) 5) (+ (backLeg y:) 5))
				(hut posn: (hut x:) (+ (hut y:) 10))
				(= cycles 1)
			)
			(8
				(frontLeg
					setCel: 2
					posn: (- (frontLeg x:) 2) (+ (frontLeg y:) 10)
				)
				(backLeg setCel: 2 posn: (- (backLeg x:) 3) (+ (backLeg y:) 9))
				(hut posn: (hut x:) (+ (hut y:) 10))
				(= cycles 1)
			)
			(9
				(frontLeg
					setCel: 2
					posn: (- (frontLeg x:) 1) (+ (frontLeg y:) 2)
				)
				(backLeg setCel: 2 posn: (- (backLeg x:) 1) (+ (backLeg y:) 2))
				(hut posn: (hut x:) (+ (hut y:) 10))
				(if local3
					(gEgo setPri: 3)
				)
				(= cycles 1)
			)
			(10
				(hut posn: (hut x:) (+ (hut y:) 10))
				(self cue:)
			)
			(11
				(= local0 (hut x:))
				(= local1 (hut y:))
				(hut stopUpd: ignoreActors: 0)
				(frontLeg dispose:)
				(backLeg dispose:)
				(frontFoot stopUpd:)
				(backFoot stopUpd:)
				(if local3
					(gEgo dispose:)
				)
				(= cycles 1)
			)
			(12
				(SetFlag 172)
				(tromp play:)
				(ShakeScreen 6 ssFULL_SHAKE)
				(= cycles 6)
			)
			(13
				(hutDoor
					ignoreActors:
					posn: (+ (hut x:) 17) (- (hut y:) 5)
					cel: 0
					init:
					setCycle: End self
				)
			)
			(14
				(HandsOn)
				(hutDoor stopUpd:)
				(hut setScript: 0)
				(if local3
					(EgoDead ; "You really brought down the house! Too bad you were under it at the time."
						22
						69
						80
						{ Bad strategy! %j\d6\b8\c5\b2\c0\b2\bb\b8\c0\de!}
						82
						516
						3
						7
					)
				)
			)
		)
	)
)

(instance flyAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(skull1 stopUpd: addToPic:)
				(skull2 stopUpd: addToPic:)
				(skull3 stopUpd: addToPic:)
				(skull4 stopUpd: addToPic:)
				(skull5 stopUpd: addToPic:)
				(if (gCast contains: gate)
					(gate addToPic:)
				)
				(if (gCast contains: dirt)
					(dirt addToPic:)
				)
				(if (gCast contains: bonehead)
					(bonehead addToPic:)
				)
				(if (gCast contains: eyes)
					(eyes addToPic:)
				)
				(TP
					ignoreActors:
					setPri: 15
					posn: 187 130
					init:
					setCycle: CT 6 1 self
				)
			)
			(1
				(tpSound number: (SoundFX 28) init: play:)
				(TP setCycle: End)
				(gEgo posn: 187 130 init:)
				(hutDoor
					ignoreActors:
					posn: (+ (hut x:) 17) (- (hut y:) 5)
					cel: 2
					init:
					setPri: 4
					setCycle: Beg self
				)
				(LookAt gEgo hutDoor)
			)
			(2
				(wing1
					ignoreActors:
					ignoreHorizon:
					setPri: 10
					posn: (- local0 36) (- local1 57)
					init:
					setCycle: End
				)
				(wing2
					ignoreActors:
					ignoreHorizon:
					posn: (+ local0 46) (- local1 52)
					init:
					setCycle: End self
				)
			)
			(3
				(hutDoor dispose:)
				(wing1 setLoop: 6 setCycle: Fwd)
				(wing2 setLoop: 7 setCycle: Fwd)
				(= cycles 12)
			)
			(4
				(gEgo loop: 3 forceUpd:)
				(localproc_0 8 22 70)
				(hut setMotion: MoveTo local0 -100)
				(wing1 setMotion: MoveTo (wing1 x:) -43)
				(wing2 setMotion: MoveTo (wing2 x:) -58)
				(frontFoot ignoreHorizon: setMotion: MoveTo (frontFoot x:) -58)
				(backFoot ignoreHorizon: setMotion: MoveTo (backFoot x:) -58)
				(= seconds 8)
			)
			(5
				(SetFlag 173)
				(ClearFlag 172)
				(wing1 dispose:)
				(wing2 dispose:)
				(frontFoot dispose:)
				(backFoot dispose:)
				(hut dispose:)
				(gCurRoom newRoom: 600) ; EndGame
			)
		)
	)
)

(instance frogIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(TP setCycle: CT 6 1 self)
			)
			(1
				(tpSound number: (SoundFX 28) init: play:)
				(gEgo init:)
				(TP setCycle: End)
				(= cycles 10)
			)
			(2
				(if (>= global324 3)
					(self changeState: 5)
				else
					(HighPrint 22 71) ; "From a distance, you hear the witch intone:"
					(HighPrint 22 72) ; "Oops! I very nearly forgot..."
					(Print 22 73 #at -1 12 #width 145 #mode 1 #time 8) ; "Hear me, oh Powers Of Mana and More: Turn this fool back As he was before."
					(= seconds 3)
				)
			)
			(3
				(tpSound play:)
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo)
				(gEgo loop: 1)
				(= cycles 10)
			)
			(5
				(HandsOn)
				(switch global324
					(2
						(HighPrint 22 74) ; "As you contemplate the occurrences of the last few minutes, you conclude that you'd better find her mandrake root...and fast!"
						(SetFlag 326)
						(= global112 gDay)
					)
					(3
						(HighPrint 22 75) ; "What an awful creature, to turn me into a FROG!", you say to yourself. "Someday, I must return the favor."
					)
				)
				(TP dispose:)
			)
		)
	)
)

