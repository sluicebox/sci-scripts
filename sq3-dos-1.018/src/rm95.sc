;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use Interface)
(use Wander)
(use Follow)
(use Chase)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm95 0
)

(local
	local0
)

(instance rm95 of Rm
	(properties
		picture 95
		style 4
	)

	(method (init)
		(SL enable:)
		(HandsOn)
		(Load rsVIEW 901)
		(Load rsVIEW 126)
		(Load rsVIEW 127)
		(Load rsVIEW 128)
		(Load rsVIEW 210)
		(Load rsVIEW 113)
		(Load rsVIEW 114)
		(Load rsVIEW 88)
		(Load rsVIEW 116)
		(Load rsVIEW 118)
		(Load rsSOUND 44)
		(Load rsSOUND 45)
		(Load rsSOUND 48)
		(Load rsSOUND 50)
		(super init:)
		(self setScript: rmScript)
	)

	(method (newRoom newRoomNumber)
		(gTimers eachElementDo: #dispose 84)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((or (Said 'look<down') (Said 'look/pit,deck,dirt'))
						(Print 95 0) ; "Looking down the deep shaft makes you giddy."
					)
					((Said 'look/pedestal,aisle,aisle,ramp')
						(Print 95 1) ; "The only visible means of access to the detention platform is by means of retractable bridges."
					)
					((Said 'look/door,entrance')
						(Print 95 2) ; "Massive doors feed into the detention chamber from parts unknown."
					)
					((Said 'look/crack,crack')
						(Print 95 3) ; "The lines warn you to watch your step!"
					)
					((Said 'look/partition')
						(Print 95 4) ; "Other than the tightly sealed doors, the walls reveal no exits."
					)
					((or (Said 'look<up') (Said 'look/pane'))
						(Print 95 5) ; "You notice several darkened observation windows high above. You hope no one is observing you now."
					)
					((Said 'look/control,console,button')
						(Print 95 6) ; "An array of control buttons adjoins each door."
					)
					((Said 'jump[/*]')
						(Print 95 7) ; "Jesse Owens you ain't."
					)
					((Said 'press,press,hit,feel,use/control,console,button')
						(if (gEgo inRect: 0 180 320 190)
							(gEgo setScript: buttonScript)
						else
							(Print 95 8) ; "There is not a button in your reach."
						)
					)
					((<= (captureScript state:) 3)
						(cond
							((Said 'look[/area,left,right]')
								(Print 95 9) ; "You cautiously enter a darkened chamber. A seemingly bottomless shaft drops off into a black abyss. On a platform in the center of the chamber, the Two Guys from Andromeda wiggle helplessly in lime jello. The platform can only be reached by the four retractable bridges at each entrance."
							)
							((Said 'look,talk/man,folk')
								(Print 95 10) ; "'HELPH!' they slurp from their jello-encased captivity."
							)
							((Said 'free,release/man[<2]')
								(Print 95 11) ; "Good idea! But how?"
							)
							((Said 'look/gel')
								(Print 95 12) ; "This is not your ordinary store-bought jello."
							)
							((Said 'melt/gel')
								(Print 95 13) ; "Think again."
							)
							((Said 'eat/gel')
								(Print 95 14) ; "Yuck! You hate lime jello!"
							)
							(
								(or
									(Said 'blast[/gel]')
									(Said 'use/mrgarbage')
									(Said 'use/garbage<mr')
								)
								(if
									(and
										(gEgo inRect: 140 102 176 110)
										(>= (gEgo loop:) 2)
									)
									(gEgo setScript: captureScript)
								else
									(Print 95 15) ; "From where you stand, it couldn't be done."
								)
							)
							((Said 'blast/*')
								(Print 95 16) ; "Horrors!"
							)
							((Said '*/gel')
								(if (gEgo inRect: 140 102 176 110)
									(Print 95 17) ; "The resilient jello resists your attempts."
								else
									(Print 95 15) ; "From where you stand, it couldn't be done."
								)
							)
						)
					)
					((Said 'look/gel')
						(Print 95 18) ; "The jello exists no more."
					)
					((Said 'blast/gel')
						(Print 95 19) ; "It's been vaporized into oblivion."
					)
					((Said '*/gel')
						(Print 95 20) ; "It's a bit late for that now!"
					)
					((Said 'blast[/*]')
						(Print 95 21) ; "Your puny vaporizer is ineffective."
					)
					((Said 'kill,combat,escape')
						(Print 95 22) ; "How now?"
					)
					((Said 'look[/area,left,right]')
						(Print 95 23) ; "Good news: you have freed the two guys from Andromeda!"
						(Print 95 24) ; "Bad news: you have been discovered meddling about."
					)
					((Said '*/man<2')
						(Print 95 25) ; "The two guys look to you for direction."
					)
					((Said 'look/guard')
						(Print 95 26) ; "The guards are looking at you."
					)
					((>= (captureScript state:) 16)
						(cond
							(
								(Said
									'look/pane,man,guard,folk,accountant,eightprong'
								)
								(Print 95 27) ; "Your every move is being observed."
							)
							((Said 'look/elmo,elmo,boy,(man<little)')
								(Print 95 28) ; "Elmo Pug, the president of ScumSoft, is in charge here."
							)
							((Said 'talk/*')
								(Print 95 29) ; "Elmo Pug is doing all the talking now."
							)
						)
					)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (User canControl:)
			(if (>= (gEgo y:) 190)
				(gCurRoom setScript: exitHallScript)
			)
			(cond
				((& (= temp0 (gEgo onControl: -1)) $0010)
					(gEgo setPri: 5)
					(if (and (< 120 (gEgo x:) 200) (>= (gEgo loop:) 2))
						(gEgo
							posn:
								(if (< (gEgo x:) 160) 120 else 200)
								(gEgo y:)
						)
					)
				)
				((& temp0 $0004)
					(gEgo setPri: 4)
				)
				((& temp0 $0080)
					(gEgo setPri: 5)
				)
				((& temp0 $0008)
					(if (!= (bridgeFront cel:) (bridgeFront lastCel:))
						(gEgo setPri: 5)
					else
						(return)
					)
				)
				(else
					(return)
				)
			)
			(gCurRoom setScript: gonner)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(mrMark init:)
		(mrScott init:)
		(doorLeft init:)
		(doorRear init:)
		(doorRight init:)
		(bridgeLeft init:)
		(bridgeFront init:)
		(bridgeRight init:)
		(windowLeft init:)
		(windowCenter init:)
		(windowRight init:)
		(elmoPug init:)
		(jelloSound init:)
		(fallSound init:)
		(doorSound init:)
		(bridgeSound init:)
		(machineSound init:)
		(gEgo init:)
		(gAddToPics add: progsLeft progsRear progsRight)
		(gAddToPics doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(machineSound play:)
				(gEgo
					view: 113
					posn: 158 190
					setCel: -1
					setLoop: -1
					ignoreActors: 0
					setStep: 3 2
					setPri: 7
					setMotion: MoveTo 158 188 self
				)
			)
			(1
				(rm95 south: 90)
				(HandsOn)
			)
		)
	)
)

(instance buttonScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rm95 south: 0)
				(gEgo setMotion: MoveTo 125 188 self)
			)
			(1
				(gEgo setMotion: MoveTo 120 207 self)
			)
			(2
				(gEgo setMotion: MoveTo (- (gEgo x:) 1) (gEgo y:) self)
			)
			(3
				(if global238
					(= global238 0)
					(bridgeFront setCycle: Beg self)
				else
					(= global238 1)
					(bridgeFront setCycle: End self)
				)
				(bridgeSound play:)
			)
			(4
				(bridgeFront stopUpd:)
				(gEgo setMotion: MoveTo 158 (gEgo y:) self)
			)
			(5
				(gEgo setMotion: MoveTo 158 188 self)
			)
			(6
				(rm95 south: 90)
				(HandsOn)
			)
			(else
				(self changeState: 0)
			)
		)
	)
)

(instance gonner of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(captureScript changeState: 99)
				(gEgo
					view: 88
					ignoreActors: 1
					illegalBits: 0
					setStep: 3 12
					setLoop: (gEgo loop:)
					setCycle: End self
				)
			)
			(1
				(rm95 south: 0)
				(gEgo setCycle: 0 setMotion: MoveTo (gEgo x:) 220 self)
				(machineSound stop:)
				(fallSound play:)
			)
			(2
				(if (!= (fallSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(self cue:)
				)
			)
			(3
				(EgoDead 901 0 0 10)
			)
		)
	)
)

(instance exitHallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 190 self)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 90)
			)
		)
	)
)

(instance captureScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(machineSound stop:)
				(jelloSound play:)
				(gEgo view: 114 setCel: 0 setCycle: End self)
			)
			(1
				(if (!= (jelloSound prevSignal:) -1)
					(-- state)
					(gEgo setCel: 0 setCycle: End self)
				else
					(jelloSound dispose:)
					(self cue:)
				)
			)
			(2
				(gEgo view: 113 setCycle: Walk)
				(mrMark
					view: 126
					setPri: (gEgo priority:)
					setLoop: -1
					setCel: -1
					setCycle: Walk
					observeControl: 28
					setMotion: Wander
				)
				(Timer setCycle: self 2)
			)
			(3
				(mrScott
					view: 127
					setPri: (gEgo priority:)
					setLoop: -1
					setCel: -1
					setCycle: Walk
					observeControl: 28
					setMotion: Wander
				)
				(= local0 gScore)
				(= gScore gPossibleScore)
				(gGame changeScore: -1)
				(HandsOn)
				(Timer setCycle: self 1)
			)
			(4
				(Print 95 30) ; "You successfully free the two guys from their slimey confines and they begin to speak:"
				(Print 95 31 #at -1 20 #width 280) ; "Thanks dude! It's great to be out of that green stuff. Hey, what's your name?"
				(Print 95 32) ; ""Roger Wilco," you admit."
				(Print 95 33 #at -1 20 #width 280) ; "They discovered our distress message we coded into the Astro Chicken game and sent us here as punishment. Let's get out of here before we're discovered!"
				(bridgeFront setCycle: Beg self)
				(bridgeSound play:)
			)
			(5
				(if (!= (bridgeSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(bridgeFront addToPic:)
					(self cue:)
				)
			)
			(6
				(Timer setReal: self 10)
			)
			(7
				(Print 95 34 #at -1 20 #width 280) ; "So... what's your plan for getting us out of here, Wilco?"
				(doorSound play:)
				(doorRear setCycle: End self)
			)
			(8
				(if (!= (doorSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorRear stopUpd:)
					(self cue:)
				)
			)
			(9
				(doorSound play:)
				(doorLeft setCycle: End self)
			)
			(10
				(if (!= (doorSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorLeft stopUpd:)
					(self cue:)
				)
			)
			(11
				(guardLeft init:)
				(guardLeft setMotion: MoveTo 49 110 self)
			)
			(12
				(guardLeft stopUpd:)
				(doorSound play:)
				(doorRight setCycle: End self)
			)
			(13
				(if (!= (doorSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorRight stopUpd:)
					(self cue:)
				)
			)
			(14
				(guardRight init:)
				(guardRight setMotion: MoveTo 271 110 self)
			)
			(15
				(guardRight stopUpd:)
				(windowLeft dispose:)
				(windowCenter dispose:)
				(windowRight dispose:)
				(Timer setReal: self 3)
			)
			(16
				(mrMark setLoop: 3 setCel: 0 setMotion: 0)
				(mrScott setLoop: 3 setCel: 0 setMotion: 0)
				(elmoPug setCycle: Fwd)
				(Timer setReal: self 5)
			)
			(17
				(elmoPug setCel: 1 forceUpd:)
				(Print 95 35 #at -1 130 #width 280) ; "Nobody's going anywhere... heh, heh, heh! You must have thought you were pretty clever, Mr. Wilco, disguising yourself as a janitor."
				(Print 95 36 #at -1 130 #width 280) ; "Unfortunately for you, my boys found your sorry excuse for a ship in the woods. Escort this gentleman to the ARENA. You boys haven't seen a good fight in quite a while."
				(Print 95 37 #at -1 130 #width 280) ; "And do away with those two Andromedans. They have been more trouble than they're worth. TAKE THEM AWAY!"
				(elmoPug setCel: 0 addToPic:)
				(HandsOff)
				(= gScore local0)
				(gGame changeScore: 10)
				(fallSound dispose:)
				(bridgeLeft setCycle: End self)
				(bridgeSound play:)
			)
			(18
				(if (!= (bridgeSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(bridgeLeft addToPic:)
					(self cue:)
				)
			)
			(19
				(doorSound play:)
				(doorLeft setCycle: Beg self)
			)
			(20
				(if (!= (doorSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorLeft addToPic:)
					(self cue:)
				)
			)
			(21
				(guardLeft setMotion: MoveTo 90 110 self)
			)
			(22
				(mrMark
					setLoop: -1
					setCel: -1
					ignoreActors: 1
					ignoreControl: -1
					setMotion: Follow gEgo 2
				)
				(mrScott
					setLoop: -1
					setCel: -1
					ignoreActors: 1
					ignoreControl: -1
					setMotion: Follow mrMark 2
				)
				(guardLeft setMotion: Follow gEgo 30)
				(bridgeRight setCycle: End self)
				(bridgeSound play:)
			)
			(23
				(if (!= (bridgeSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(bridgeRight addToPic:)
					(self cue:)
				)
			)
			(24
				(gEgo
					setPri: 6
					ignoreActors: 1
					setMotion: MoveTo 205 110 self
				)
				(mrMark setPri: 6)
				(mrScott setPri: 6)
			)
			(25
				(guardRight setLoop: 1 setMotion: MoveTo 320 110)
				(gEgo setMotion: Follow guardRight 0)
				(guardLeft setMotion: Chase gEgo 0 self)
			)
			(26
				(guardRight dispose:)
				(guardLeft dispose:)
				(mrMark dispose:)
				(mrScott dispose:)
				(doorSound play:)
				(doorRight setCycle: Beg self)
			)
			(27
				(if (!= (doorSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorRight addToPic:)
					(self cue:)
				)
			)
			(28
				(doorSound play:)
				(doorRear setCycle: Beg self)
			)
			(29
				(if (!= (doorSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorRear addToPic:)
					(doorSound dispose:)
					(self cue:)
				)
			)
			(30
				(windowLeft init:)
				(windowCenter init:)
				(windowRight init:)
				(Timer setReal: self 1)
			)
			(31
				(gEgo put: 12 -1 put: 13 -1 put: 11 -1 put: 15 -1) ; Coveralls, Vaporizer, Keycard, a_copy_of_Elmo_s_picture
				(gCurRoom newRoom: 121)
			)
		)
	)
)

(instance bridgeLeft of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			setPri: 4
			view: 118
			loop: 1
			cel: 0
			posn: 84 121
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance bridgeFront of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			cycleSpeed: 1
			setPri: 6
			view: 118
			loop: 0
			cel: (if global238 6 else 0)
			posn: 160 180
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance bridgeRight of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			setPri: 4
			view: 118
			loop: 2
			cel: 0
			posn: 233 121
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance doorLeft of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			cycleSpeed: 1
			setPri: 3
			view: 118
			loop: 4
			cel: 0
			posn: 54 125
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance doorRear of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			cycleSpeed: 1
			setPri: 3
			view: 118
			loop: 3
			cel: 0
			posn: 159 84
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance doorRight of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			cycleSpeed: 1
			setPri: 3
			view: 118
			loop: 5
			cel: 0
			posn: 266 124
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance windowLeft of Prop
	(properties)

	(method (init)
		(super init:)
		(self setPri: 5 view: 116 loop: 0 cel: 0 posn: 80 32 stopUpd:)
	)
)

(instance windowCenter of Prop
	(properties)

	(method (init)
		(super init:)
		(self setPri: 5 view: 116 loop: 0 cel: 1 posn: 160 26 stopUpd:)
	)
)

(instance windowRight of Prop
	(properties)

	(method (init)
		(super init:)
		(self setPri: 5 view: 116 loop: 0 cel: 2 posn: 239 32 stopUpd:)
	)
)

(instance progsLeft of PV
	(properties
		y 30
		x 61
		view 116
		loop 1
	)
)

(instance progsRear of PV
	(properties
		y 21
		x 152
		view 116
		loop 1
		cel 1
	)
)

(instance progsRight of PV
	(properties
		y 29
		x 251
		view 116
		loop 1
		cel 2
	)
)

(instance guardLeft of Act
	(properties)

	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			ignoreControl: 1
			setPri: 6
			view: 210
			setLoop: 1
			cel: 0
			posn: 10 110
			setCycle: Walk
		)
	)
)

(instance elmoPug of Prop
	(properties)

	(method (init)
		(super init:)
		(self setPri: 4 view: 116 loop: 2 cel: 0 posn: 156 27 stopUpd:)
	)
)

(instance guardRight of Act
	(properties)

	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			ignoreControl: 1
			setPri: 6
			view: 210
			setLoop: 0
			cel: 0
			posn: 300 110
			setCycle: Walk
		)
	)
)

(instance mrMark of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 128
			setLoop: 0
			setCel: 0
			posn: 148 106
			setPri: 7
			setCycle: Fwd
		)
	)
)

(instance mrScott of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 128
			setLoop: 1
			setCel: 2
			posn: 169 106
			setPri: 7
			setCycle: Fwd
		)
	)
)

(instance jelloSound of Sound
	(properties
		number 44
		priority 1
	)
)

(instance fallSound of Sound
	(properties
		number 45
		priority 2
	)
)

(instance doorSound of Sound
	(properties
		number 48
		priority 1
	)
)

(instance bridgeSound of Sound
	(properties
		number 48
		priority 1
	)
)

(instance machineSound of Sound
	(properties
		number 50
		loop -1
	)
)

