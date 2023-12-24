;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 483)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm483 0
)

(local
	[string 200]
)

(procedure (Print483 &tmp t)
	(= t (PrintDelay @string))
	(Print
		@string
		#at
		10
		5
		#width
		290
		#mode
		1
		#time
		(LangSwitch t t (+ t t) (+ t t))
		#dispose
	)
	(return (+ 3 (LangSwitch t t (+ t t) (+ t t))))
)

(instance rm483 of Rm
	(properties
		picture 490
	)

	(method (init)
		(HandsOff)
		(Load rsSOUND 489)
		(Load rsSOUND 490)
		(Load rsSOUND 491)
		(Load rsSOUND 492)
		(super init:)
		(gMusic number: 489 loop: 2 play:)
		(gAddToPics add: atpTelescope doit:)
		(self setScript: RoomScript)
		(aPatti setPri: 15 init:)
		(gEgo
			get: 12 ; Penthouse_Key
			illegalBits: 0
			ignoreActors:
			view: 491
			posn: 173 1116
			setPri: 5
			setStep: 1 1
			cycleSpeed: 1
			moveSpeed: 1
			init:
		)
		(gTheWindow color: 7 back: 0)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(gGame setSpeed: 6)
	)

	(method (handleEvent event)
		(if
			(and
				(== (event type:) evKEYBOARD)
				(== (event claimed:) 0)
				(== (event message:) KEY_F8)
			)
			(Print 483 0) ; "Skipping ahead..."
			(SetFlag 69) ; tookShortcut
			(gCurRoom newRoom: 484)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aPatti setCycle: End self)
			)
			(1
				(= seconds 3)
			)
			(2
				(Format @string 483 1) ; ""He's gone. He's really gone!"%"
				(= seconds (Print483))
				(aPatti cycleSpeed: 2 loop: 1 cel: 0 setCycle: End)
			)
			(3
				(Format @string 483 2) ; ""Where could he go at this time of night?"%"
				(= seconds (Print483))
			)
			(4
				(Format @string 483 3) ; ""Why would he leave? Am I blind? How could I let him slip through my fingers?"%"
				(= seconds (Print483))
				(aPatti setCycle: Beg)
			)
			(5
				(aSparkle init: ignoreActors: setCycle: End)
				(= seconds 2)
			)
			(6
				(Format @string 483 4) ; ""Wait! What's that? Off in the distance. Way over there at the point! Was that a flash of white polyester?"%"
				(= seconds (Print483))
			)
			(7
				(aPatti loop: 2 cel: 0 setCycle: End self)
			)
			(8
				(aPatti stopUpd:)
				(= seconds 3)
			)
			(9
				(aHole0 setPri: 6 ignoreActors: init:)
				(aHole1 setPri: 5 ignoreActors: init:)
				(aHole2 setPri: 4 ignoreActors: init:)
				(= seconds 3)
			)
			(10
				(gEgo posn: 173 116 setMotion: MoveTo 212 116 self)
				(= cycles 11)
			)
			(11
				(gMusic number: 490 loop: 2 play:)
				(Format @string 483 5) ; ""IT'S HIM!!"%"
				(Print483)
			)
			(12
				(gEgo setPri: 4 setMotion: MoveTo 212 110 self)
			)
			(13
				(Format @string 483 6) ; ""But, where is he going? There's nothing that way but uncharted bamboo forest!"%"
				(= seconds (Print483))
				(gEgo setMotion: MoveTo 192 110)
			)
			(14
				(= cycles 11)
			)
			(15
				(Format @string 483 7) ; ""He's gone! But it had to be Larry. His pulsating pectorals are recognizable anywhere!!"%"
				(= seconds (Print483))
			)
			(16
				(gEgo hide:)
				(aHole0 dispose:)
				(aHole1 dispose:)
				(aHole2 dispose:)
				(aPatti cycleSpeed: 2 setCycle: Beg self)
			)
			(17
				(= seconds 3)
			)
			(18
				(gMusic number: 491 loop: 2 play:)
				(Format @string 483 8) ; ""Suddenly, everything seems so obvious, so simple. I MUST give up everything and find my man. I know my quest -- to find Larry Laffer!"%"
				(= seconds (Print483))
			)
			(19
				(= seconds 5)
			)
			(20
				(gMusic fade:)
				(gTheWindow color: gTextColor back: gBackgroundColor)
				(TheMenuBar draw: state: 1)
				(SL enable:)
				(ClearFlag 4) ; preventAutoSave
				(ClearFlag 5) ; noCursor
				(gCurRoom newRoom: 484)
			)
		)
	)
)

(instance aPatti of Act
	(properties
		y 189
		x 170
		view 492
		cycleSpeed 1
	)
)

(instance atpTelescope of PV
	(properties
		y 189
		x 160
		view 490
		priority 4
		signal 16384
	)
)

(instance aHole0 of View
	(properties
		y 92
		x 179
		view 490
		loop 1
	)
)

(instance aHole1 of View
	(properties
		y 92
		x 179
		view 490
		loop 1
		cel 1
	)
)

(instance aHole2 of View
	(properties
		y 92
		x 178
		view 490
		loop 1
		cel 2
	)
)

(instance aSparkle of Prop
	(properties
		y 9
		x 216
		view 490
		loop 2
	)
)

