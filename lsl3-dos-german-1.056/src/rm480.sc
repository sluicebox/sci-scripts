;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use FileSelector)
(use Motion)
(use Game)
(use Inventory)
(use Menu)
(use Actor)
(use System)

(public
	rm480 0
)

(local
	drinkCounter
	[string 225]
)

(procedure (PrintPatti &tmp t)
	(= t (PrintDelay @string))
	(Print
		@string
		#at
		10
		10
		#title
		{Patti says...}
		#width
		140
		#mode
		1
		#time
		(LangSwitch t t (+ t t) (+ t t))
		#dispose
	)
	(return (+ 3 (LangSwitch t t (+ t t) (+ t t))))
)

(procedure (PrintLarry &tmp t)
	(= t (PrintDelay @string))
	(Print
		@string
		#at
		160
		10
		#title
		{You say...}
		#width
		140
		#mode
		1
		#time
		(LangSwitch t t (+ t t) (+ t t))
		#dispose
	)
	(return (+ 3 (LangSwitch t t (+ t t) (+ t t))))
)

(instance aWine of View
	(properties
		y 115
		x 162
		view 480
		loop 4
		cel 3
	)

	(method (init)
		(super init:)
		(self setPri: 10 setCel: 3 ignoreActors: stopUpd:)
	)
)

(instance aDoor of Prop
	(properties
		y 65
		x 159
		view 480
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 3 ignoreActors: stopUpd:)
	)
)

(instance aPanties of View
	(properties
		y 131
		x 63
		view 480
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aBra of View
	(properties
		y 131
		x 63
		view 480
		loop 1
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aPantyhose of View
	(properties
		y 141
		x 63
		view 480
		loop 1
		cel 2
	)

	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aDress of Prop
	(properties
		y 107
		x 39
		view 480
		loop 2
	)

	(method (init)
		(super init:)
		(self
			setPri: 11
			setCel: (if (InRoom 17 484) 0 else 255)
			ignoreActors:
			stopUpd:
		)
	)
)

(instance atpTelescope of PV
	(properties
		y 50
		x 160
		view 480
		loop 3
		priority 1
		signal 16384
	)
)

(instance rm480 of Rm
	(properties
		picture 480
		south 470
	)

	(method (init)
		(gMusic fade:)
		(Load rsSCRIPT 969)
		(if (gEgo has: 13) ; Bottle_of_Wine
			(Load rsPIC 99)
			(Load rsVIEW 481)
			(Load rsSOUND 480)
			(Load rsSOUND 481)
			(Load rsSOUND 483)
		else
			(Load rsSOUND 9)
		)
		(super init:)
		(aWine init:)
		(aDoor init:)
		(aPanties init:)
		(aBra init:)
		(aPantyhose init:)
		(aDress init:)
		(gAddToPics add: atpTelescope doit:)
		(self setScript: RoomScript)
		(aPatti init:)
		(NormalEgo)
		(HandsOff)
		(gEgo posn: 159 188 loop: 3 observeControl: 16384 init:)
		(if (gEgo has: 13) ; Bottle_of_Wine
			(RoomScript changeState: 1)
		else
			(RoomScript changeState: 43)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (>= state 10)
			(gGame setSpeed: 6)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(== (event type:) evKEYBOARD)
				(== (event claimed:) 0)
				(== (event message:) KEY_F8)
				(>= state 9)
			)
			(Print 480 0) ; "Skipping ahead..."
			(SetFlag 69)
			(gCurRoom newRoom: 484)
		)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'make/enjoy,love')
					(Said 'fuck,fuck')
					(Said 'go,(climb<in,on),(get,get<in)/bed')
					(Said 'strip')
					(Said 'get,get/naked')
					(Said 'drain,give,drop/beer')
					(Said 'wear/nothing')
				)
				(if
					(and
						(not (& (gEgo onControl: 1) $0200))
						(not (& (gEgo onControl: 1) $0400))
						(not (& (gEgo onControl: 1) $0800))
						(not (& (gEgo onControl: 1) $1000))
					)
					(NotClose) ; "You're not close enough."
				else
					(self changeState: 4)
				)
			)
			((Said 'talk,talk')
				(Print 480 1) ; "Talk, talk, talk. Doesn't anybody..."
			)
			((Said 'open/door')
				(Print 480 2) ; "The door isn't what you're interested in here, Larry!"
			)
			((Said 'get,get')
				(Print 480 3) ; "You're here to get something, but not that!"
			)
			((Said 'look,look>')
				(cond
					((Said '/balcony,camp,bay,air,cup')
						(Print 480 4) ; "The view from her window is spectacular!"
					)
					((Said '/bed')
						(Print 480 5) ; "It (and she) is ready and waiting for you, Larry."
					)
					((Said '/entertainer,woman')
						(Print 480 6) ; "Is that all you came up here to do: look?!"
					)
					((Said '/cloth')
						(Print 480 7) ; "Patti's clothes are lying on a table by her dressing screen."
					)
					((Said '/keyboard')
						(Print 480 8) ; "Practice makes perfect."
					)
					((Said '/binocular')
						(Print 480 9) ; "From her balcony, Patti has a perfect view into the Fat City locker room window."
					)
					((Said '/burn,burn')
						(Print 480 10) ; "Lamps hang suspended from the ceiling casting a dull glow to the surroundings."
					)
					((Said '/plant,bush')
						(Print 480 11) ; "You didn't come here for botany!"
					)
					((Said '/buffet')
						(Print 480 12) ; "A table at the foot of her bed holds two empty wine glasses. There is a table near her dressing screen that holds her clothes."
					)
					((Said '[/area]')
						(Print 480 13) ; "Passionate Patti's penthouse suite is gorgeous. Too bad you couldn't negotiate a contract as sweet as hers!"
					)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(= seconds 3)
			)
			(2
				(if (TestFlag 66)
					(Print 480 14) ; ""I brought the wine again, Patti," you announce."
				else
					(Print 480 15) ; ""I remembered to bring the wine, Patti," you announce."
				)
				(= seconds 3)
			)
			(3
				(if (TestFlag 66)
					(Print 480 16) ; ""Where the hell did you go?" she asks."
				else
					(SetFlag 66)
					(Print 480 17) ; ""And I remembered to wear your lei, Larry!" she smiles."
				)
				(= gEgoState 0)
				(NormalEgo)
				(gEgo observeControl: 16384)
			)
			(4
				(HandsOff)
				(Ok) ; "O.K."
				(gGame changeScore: 500)
				(Print 480 18) ; "You decide to place the bottle of wine on the silver tray resting on the table at the foot of the circular bed, beside the two glasses Patti has thoughtfully provided for the occasion."
				(self cue:)
			)
			(5
				(cond
					((>= (gEgo y:) 140)
						(= temp0 158)
						(= temp1 140)
					)
					((& (gEgo onControl: 1) $0800)
						(= temp0 (gEgo x:))
						(= temp1 140)
						(-- state)
					)
					((& (gEgo onControl: 1) $1000)
						(= temp0 (gEgo x:))
						(= temp1 140)
						(-- state)
					)
					((& (gEgo onControl: 1) $0200)
						(= temp0 95)
						(if (> (gEgo x:) 95)
							(= temp1 (gEgo y:))
						else
							(= temp1 120)
						)
						(-- state)
					)
					((& (gEgo onControl: 1) $0400)
						(= temp0 231)
						(if (< (gEgo x:) 231)
							(= temp1 (gEgo y:))
						else
							(= temp1 120)
						)
						(-- state)
					)
					(else
						(Print 480 19) ; "error"
					)
				)
				(gEgo setMotion: MoveTo temp0 temp1 self)
			)
			(6
				(PutInRoom 13 484)
				((Inv at: 13) view: 28) ; Bottle_of_Wine
				(Format ((Inv at: 13) name:) 480 20) ; "Empty Bottle%", Bottle_of_Wine
				(gEgo loop: 3)
				(aWine setCel: 4 stopUpd:)
				(= cycles 11)
			)
			(7
				(gEgo setMotion: MoveTo 194 140 self)
			)
			(8
				(gEgo setMotion: MoveTo 194 132 self)
			)
			(9
				(= gOldGameSpeed (gGame setSpeed: 6))
				(gMusic number: 480 loop: -1 play:)
				(SL disable:)
				(TheMenuBar hide: state: 0)
				(SetFlag 5)
				(SetFlag 4)
				(Format @string 480 21) ; ""Perhaps I should explain... I have a history of not finishing what I begin. Just don't be surprised if something happens before we finish!"%"
				(= seconds (PrintLarry))
				(gEgo loop: 2)
				(SaveSubLang)
				(Display 480 22 dsCOORD 0 180 dsCOLOR 4 dsWIDTH 280 dsFONT gUserFont) ; "F8 will bypass this scene."
				(RestoreSubLang)
			)
			(10
				(gEgo
					posn: 176 92
					cycleSpeed: 1
					view: 481
					setPri: 8
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(11
				(Format @string 480 23) ; ""Rest assured, Honey; I promise you: something will happen!"%"
				(= seconds (PrintPatti))
			)
			(12
				(Format @string 480 24) ; ""Would you care for a glass of wine?"%"
				(= seconds (PrintLarry))
			)
			(13
				(Format @string 480 25) ; ""I thought you'd never ask."%"
				(= seconds (PrintPatti))
			)
			(14
				(cls)
				(gEgo loop: 1 cel: 0 setCycle: CT 7 1 self)
			)
			(15
				(aWine setCel: 3 stopUpd:)
				(gEgo setCycle: End self)
			)
			(16
				(Format @string 480 26) ; ""Say when."%"
				(= seconds (PrintLarry))
				(gEgo loop: 2 cel: 0 setCycle: Fwd)
			)
			(17
				(Format @string 480 27) ; ""Right after this drink, Larry!"%"
				(= seconds (PrintPatti))
				(gEgo loop: 3 cel: 0 setCycle: Fwd)
			)
			(18
				(cls)
				(aPatti setCycle: End)
				(gEgo loop: 4 cel: 0 setCycle: CT 5 1 self)
			)
			(19
				(aWine setCel: 2 stopUpd:)
				(gEgo setCycle: End self)
			)
			(20
				(aPatti loop: 1 cel: 0)
				(aWine setCel: 1 stopUpd:)
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(21
				(aPatti setCycle: End)
				(gEgo view: 483 loop: 0 cel: 0 setCycle: End)
				(= cycles 22)
			)
			(22
				(aPatti setCycle: Beg)
				(gEgo setCycle: Beg)
				(= cycles 22)
				(if (> 3 (++ drinkCounter))
					(-= state 2)
				)
			)
			(23
				(Format @string 480 28) ; ""So, Patti, how did you get started in the music business?"%"
				(= seconds (- (PrintLarry) 1))
			)
			(24
				(Format @string 480 29) ; ""Shut up, Larry!"%"
				(= seconds (PrintPatti))
				(gEgo hide:)
				(aPatti loop: 2 cel: 0 setCycle: End)
				(gMusic number: 481 loop: 2 play:)
			)
			(25
				(aPatti setCycle: CT 3 -1)
				(= cycles 22)
			)
			(26
				(Format @string 480 30) ; ""Oh, Patti."%"
				(= seconds (PrintLarry))
			)
			(27
				(Format @string 480 31) ; ""Oh, Larry!"%"
				(= seconds (PrintPatti))
			)
			(28
				(aPatti setCycle: End)
				(= cycles 44)
			)
			(29
				(aPatti setCycle: CT 3 -1)
				(= cycles 8)
			)
			(30
				(Format @string 480 32) ; ""Wherever did you learn to kiss like that?"%"
				(= seconds (PrintPatti))
			)
			(31
				(Format @string 480 33) ; ""Well, when I was younger I DID play trumpet in a mariachi band..."%"
				(= seconds (PrintLarry))
			)
			(32
				(aPatti loop: 3 cel: 0 setCycle: End)
				(= cycles 33)
			)
			(33
				(cls)
				(gCurRoom drawPic: 99 6)
				(gTheWindow color: 12 back: 8)
				(gMusic number: 483 loop: 2 play:)
				(= cycles 30)
			)
			(34
				(Format @string 480 34) ; ""OH, LARRY!"%"
				(= seconds (PrintPatti))
			)
			(35
				(Format @string 480 35) ; ""Oh! (mmmmmhhh)! Ah."%"
				(= seconds (PrintPatti))
			)
			(36
				(Format @string 480 36) ; ""Ohhhhh! (aaaaahhh)!"%"
				(= seconds (- (PrintPatti) 1))
			)
			(37
				(Format @string 480 37) ; ""Larry, (oooh) you're the first man (aaaahhh) who's ever made me feel (mmmmmhhh) THAT!"%"
				(= seconds (- (PrintPatti) 1))
			)
			(38
				(Format @string 480 38) ; ""Where did (ooohh) you learn (oooohhhhhh) to do (uuuhhhh) that?!"%"
				(= seconds (- (PrintPatti) 1))
			)
			(39
				(Format @string 480 39) ; ""And that!"%"
				(= seconds (- (PrintPatti) 2))
			)
			(40
				(Format @string 480 40) ; ""And, oh yes, THAT! Yes, THAT!! Please, more of that!!"%"
				(= seconds (- (PrintPatti) 2))
			)
			(41
				(cls)
				(Format @string 480 41) ; "Well, well, Larry. Perhaps you learned more from Kalalau than you realized.%"
				(= temp2 (PrintDelay @string))
				(Print
					@string
					#time
					(LangSwitch temp2 temp2 (+ temp2 temp2) (+ temp2 temp2))
				)
				(Format @string 480 42) ; "No longer is our Larry Laffer the Laugher Lover!%"
				(= temp2 (PrintDelay @string))
				(Print
					@string
					#time
					(LangSwitch temp2 temp2 (+ temp2 temp2) (+ temp2 temp2))
				)
				(= seconds
					(+
						3
						(LangSwitch temp2 temp2 (+ temp2 temp2) (+ temp2 temp2))
					)
				)
			)
			(42
				(gCurRoom newRoom: 481)
			)
			(43
				(gEgo setMotion: MoveTo (gEgo x:) 180 self)
			)
			(44
				(Print 480 43 #at 10 5 #width 290) ; "Oh, Larry, I'm so glad you came. As you can see, I slipped into something more comfortable -- my bed! But, I'm not naked: I'm wearing your lei!"
				(Print 480 44 #at -1 144) ; "(All right, Larry! You're on, big guy!)"
				(= seconds 3)
			)
			(45
				(Print 480 45 #at 10 5 #width 290) ; "Did you bring the wine?" Patti asks softly. "I'd love a drink right now."
				(gMusic number: 9 loop: 1 play: self)
				(Printf 480 46 global304 global305) ; ""%s" you reply, "I knew there was something I was supposed to do! I'll be right back!! Don't move!"%"
			)
			(46
				(gEgo setMotion: MoveTo (gEgo x:) 192)
			)
		)
	)
)

(instance aPatti of Prop
	(properties
		y 101
		x 151
		view 483
		loop 4
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 8 stopUpd:)
	)
)

