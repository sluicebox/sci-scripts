;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Follow)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm610 0
)

(instance rm610 of Rm
	(properties
		picture 610
		east 620
	)

	(method (init)
		(HandsOff)
		(SetFlag 3) ; cantSave
		(SetFlag 5) ; noCursor
		(SetFlag 4) ; preventAutoSave
		(= gOldGameSpeed (gGame setSpeed: 6))
		(= gEgoIsPatti 1)
		(= gNormalEgoView 801)
		(= gEgoName (Format @gEgoNameBuffer 610 0)) ; "Patti"
		(super init:)
		(gAddToPics
			add: atpSign
			add: atpStencil1
			add: atpStencil2
			add: atpHouse1
			add: atpHouse2
			add: atpHouse3
			add: atpHouse4
			add: atpHouse5
			add: atpHouse6
			add: atpHouse7
			doit:
		)
		(self setScript: RoomScript)
		(HandsOff)
		(Load rsSOUND 4)
		(Load rsSOUND 5)
		(Load rsSOUND 6)
		(Load rsSOUND 12)
		(Load rsSOUND 611)
		(Load rsSOUND 699)
		(aMan1 init:)
		(aMan2 init:)
		(aCar1 init:)
		(aCar2 init:)
		(aTowers init:)
		(aHole init:)
		(aCamera init:)
		(gEgo
			illegalBits: 0
			posn: 171 -50
			view: 804
			setLoop: 0
			setPri: 14
			setCycle: Walk
			setStep: 1 11
			init:
		)
		(aLarry
			ignoreHorizon:
			illegalBits: 0
			posn: 73 -70
			view: 631
			setLoop: 1
			setPri: 9
			setCycle: Walk
			setStep: 1 11
			init:
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 620)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(cond
				((Said '/door,wall,awning,exit')
					(Print 610 1) ; "A sign on the rear wall of the studio mentions that Studio C is off to the upper right."
				)
				((Said '/gravestone')
					(Print 610 2) ; "It says, "Here lies Al Lowe, `the Pride of St. Louis.'""
				)
				((Said '[/drop,buffet,backstage,area]')
					(Print 610 3) ; "You are backstage at the Sierra Studios. From the looks of things, they are filming another in the series of "Police Quest" games."
					(Print 610 4 #at -1 144) ; "(Or they were until you two "dropped in!")"
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 5 2)
		(switch (= state newState)
			(0
				(if (< gPrevRoomNum gCurRoomNum)
					(= seconds 3)
				)
			)
			(1
				(Print 610 5 #at 10 40 #width 290) ; "Meanwhile, back at the Sierra Studios, workers are busy filming yet another exciting episode in the never-ending saga of Sonny Bonds and the citizens of Lytton, California, U.S.A."
				(= seconds 3)
			)
			(2
				(Print 610 6) ; "Quiet on the set, please."
				(= seconds 2)
			)
			(3
				(Print 610 7) ; "Music!"
				(gMusic number: 610 loop: 1 play: self)
				(= seconds 3)
			)
			(4
				(Print 610 8 #time 2) ; "Lights!"
				(= seconds 3)
			)
			(5
				(Print 610 9 #time 2) ; "Camera!"
				(aCamera setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(Print 610 10 #time 2) ; "Action!"
				(= seconds 3)
			)
			(7
				(aCamera setMotion: MoveTo 0 0 setCycle: Fwd)
				(aCar1 setMotion: MoveTo 0 129)
				(aMan1 setMotion: MoveTo 0 143)
				(Man2Script cue:)
			)
			(8
				(cls)
				(Print 610 11) ; "Craig! Look out! Get outta here!!"
				(gMusic number: 4 loop: 1 play:)
				(aMan1
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 5 5
					setMotion: MoveTo -20 (aMan1 y:)
				)
				(aMan2
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 5 5
					setMotion: MoveTo (aMan2 x:) 222
				)
				(aCar1 stopUpd:)
				(aCar2 stopUpd:)
				(aCamera stopUpd:)
				(gEgo setMotion: MoveTo 171 119 self)
			)
			(9
				(aHole dispose:)
				(gMusic number: 12 loop: 1 play:)
				(gEgo
					posn: 171 143
					setPri: 12
					setMotion: MoveTo 175 186 self
				)
			)
			(10
				(gEgo loop: 1 cel: 0 stopUpd:)
				(Animate (gCast elements:) 0)
				(gMusic number: 5 loop: 1 play:)
				(ShakeScreen 2 ssUPDOWN)
				(= cycles 33)
			)
			(11
				(cls)
				(gMusic number: 4 loop: 1 play:)
				(aLarry setMotion: MoveTo 73 73 self)
			)
			(12
				(aLarry posn: 73 89 view: 611 setLoop: 0 setStep: 2 1)
				(gMusic number: 12 loop: 1 play:)
				(Animate (gCast elements:) 0)
				(ShakeScreen 1 ssUPDOWN)
				(Print 610 12 #at -1 10 #dispose) ; "UGH!"
				(= cycles 11)
			)
			(13
				(gMusic number: 6 loop: -1 play:)
				(cls)
				(Print 610 13 #at 100 22 #dispose) ; "Watch out, Godzilla Larry, or you'll destroy the City of Lytton!!"
				(aLarry setMotion: MoveTo 169 109 self)
			)
			(14
				(aMan1 dispose:)
				(aMan2 dispose:)
				(gMusic number: 611 loop: -1 play:)
				(aLarry setLoop: 1 setCycle: Fwd)
				(aTowers cycleSpeed: 1 setCycle: End self)
			)
			(15
				(aTowers setLoop: 4 cycleSpeed: 0 setCycle: Fwd)
				(= cycles 33)
			)
			(16
				(cls)
				(aLarry setMotion: MoveTo 167 110 self)
			)
			(17
				(gMusic number: 4 loop: 1 play:)
				(aLarry setPri: 10 setLoop: 2 cel: 0 setCycle: End self)
			)
			(18
				(aLarry posn: 165 180 setPri: 12 setLoop: 3 cel: 0)
				(= cycles 15)
			)
			(19
				(gMusic number: 5 loop: 1 play: self)
			)
			(20
				(Print 610 14) ; "Wow! Some guys really know how to make an entrance!"
				(= seconds 3)
			)
			(21
				(Print 610 15) ; "Staggering to his feet, Larry surveys your new surroundings."
				(= cycles 11)
			)
			(22
				(aLarry setCycle: End self)
			)
			(23
				(NormalActor aLarry 2 720)
				(aLarry illegalBits: 0)
				(= cycles 22)
			)
			(24
				(Print 610 16) ; "Larry spots you lying motionless on the floor beneath the miniature city of Lytton. "Patti! Are you ok?" he cries."
				(= seconds 2)
			)
			(25
				(gEgo setCycle: End self)
			)
			(26
				(NormalEgo 3 gNormalEgoView)
				(gEgo illegalBits: 0)
				(HandsOff)
				(= cycles 22)
			)
			(27
				(Print 610 17) ; "I guess so," you reply. "But if I keep doing my own stunts like this, I'm going to end up flat-chested!"
				(Print 610 18) ; "Come on, Larry," you say, "let's get out from under here."
				(gEgo setMotion: MoveTo 308 183 self)
				(= cycles 11)
			)
			(28
				(aLarry setMotion: MoveTo 276 185 self)
			)
			(29
				(gEgo loop: 1)
			)
			(30
				(ClearFlag 3) ; cantSave
				(ClearFlag 5) ; noCursor
				(ClearFlag 4) ; preventAutoSave
				(gGame setSpeed: gOldGameSpeed)
				(NormalEgo 1)
				(gEgo setPri: 7)
				(aLarry
					setPri: 7
					illegalBits: $8000
					setMotion: Follow gEgo 28
				)
				(Print 610 19) ; ""But what is this place, Larry?" you ask."
				(= seconds 2)
			)
			(31
				(Print 610 20) ; "Good question," he replies. "Although it does seem familiar!"
				(Print 610 21) ; "You take the lead, Patti. Let's explore!"
				(gMusic number: 699 loop: gBgMusicLoops play:)
			)
		)
	)
)

(instance atpSign of PV
	(properties
		y 46
		x 285
		view 610
		loop 2
	)
)

(instance atpStencil1 of PV
	(properties
		y 143
		view 610
		loop 2
		cel 1
		priority 15
		signal 16384
	)
)

(instance atpStencil2 of PV
	(properties
		y 142
		x 173
		view 610
		loop 2
		cel 1
		priority 15
		signal 16384
	)
)

(instance atpHouse1 of PV
	(properties
		y 126
		x 91
		view 610
		priority 9
	)
)

(instance atpHouse2 of PV
	(properties
		y 104
		x 5
		view 610
		cel 1
		priority 9
	)
)

(instance atpHouse3 of PV
	(properties
		y 126
		x 41
		view 610
		cel 1
		priority 9
	)
)

(instance atpHouse4 of PV
	(properties
		y 99
		x 57
		view 610
		cel 3
		priority 9
	)
)

(instance atpHouse5 of PV
	(properties
		y 97
		x 95
		view 610
		cel 4
		priority 9
	)
)

(instance atpHouse6 of PV
	(properties
		y 116
		x 128
		view 610
		cel 4
		priority 9
	)
)

(instance atpHouse7 of PV
	(properties
		y 109
		x 123
		view 610
		cel 3
		priority 9
	)
)

(instance aHole of View
	(properties
		y 120
		x 156
		view 610
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 13 ignoreActors: stopUpd:)
	)
)

(instance aCamera of Act
	(properties
		x 145
		view 616
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self ignoreHorizon: ignoreActors: setStep: 1 1)
	)
)

(instance aCar1 of Act
	(properties
		y 129
		x 145
		view 614
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 9 setStep: 1 1 setLoop: 1 setCycle: Walk)
	)
)

(instance aMan1 of Act
	(properties
		y 143
		x 145
		view 613
		cycleSpeed 2
		illegalBits 0
		moveSpeed 2
	)

	(method (init)
		(super init:)
		(self ignoreActors: setLoop: 1 setCycle: Walk)
	)
)

(instance aCar2 of Act
	(properties
		y 127
		x 130
		view 614
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 9 setStep: 1 1 setLoop: 2 setCycle: Walk)
	)
)

(instance aMan2 of Act
	(properties
		y 141
		x 130
		view 613
		cycleSpeed 1
		illegalBits 0
		moveSpeed 1
	)

	(method (init)
		(super init:)
		(self
			ignoreActors:
			setStep: 2 2
			setLoop: 3
			setCycle: Walk
			setScript: Man2Script
		)
	)
)

(instance Man2Script of Script
	(properties)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(aCar2 setMotion: MoveTo 88 102)
				(aMan2 setMotion: MoveTo 88 116 self)
			)
			(2
				(aCar2 setMotion: MoveTo 130 127)
				(aMan2 setLoop: 2 setMotion: MoveTo 130 141)
			)
			(3
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance aTowers of Prop
	(properties
		y 109
		x 170
		view 610
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 10 stopUpd: ignoreActors:)
	)
)

(instance aLarry of Act
	(properties)
)

