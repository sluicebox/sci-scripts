;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm85 0
)

(local
	[local0 3]
)

(instance rm85 of Rm
	(properties
		picture 95
		horizon 1
	)

	(method (init)
		(Load rsVIEW 829)
		(Load rsVIEW 197)
		(super init:)
		(gAddToPics add: aView1 aView2 aView3 aView4 aView5 doit:)
		(aDoor
			ignoreActors:
			illegalBits: 0
			setLoop: 6
			setStep: 1 1
			setPri: 14
			stopUpd:
			init:
		)
		(= gCurrentStatus 22)
		(gEgo
			view: 197
			setLoop: 0
			posn: 48 -2
			illegalBits: 0
			setStep: 5 5
			ignoreActors:
			setCycle: Fwd
			init:
		)
		(HandsOff)
		(self setScript: rm85Script)
	)
)

(instance rm85Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: -1 setMotion: MoveTo 149 144 self)
			)
			(1
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo view: 100 loop: 2 setLoop: -1)
				(= cycles 12)
			)
			(3
				(Print 85 0 #draw) ; "Thanks a lot for dropping me down the stairs!" you cry to the native women. "Hurry and get in the helicopter!"
				(Print 85 1) ; "No, thanks," they yell down the stairs, "we'll use the back door and take our chances with the glacier!"
				(gEgo
					setCycle: Walk
					setStep: 3 2
					setMotion: MoveTo 144 183 self
				)
			)
			(4
				(Print 85 2) ; "Come on, Big Laffer," says the pilot. "Climb aboard!"
				(gEgo setMotion: MoveTo 35 183 self)
			)
			(5
				(gEgo setMotion: MoveTo 32 153 self)
			)
			(6
				(aDoor setMotion: MoveTo 35 137 self)
			)
			(7
				(Print 85 3) ; ""Sorry, I had a little trouble with that fog machine!" you tell him."
				(= gIslandStatus 102)
				(gCurRoom newRoom: 92)
			)
		)
	)
)

(instance aView1 of PV
	(properties
		y 173
		x 35
		view 829
		loop 8
		priority 11
		signal 16384
	)
)

(instance aView2 of PV
	(properties
		y 151
		x 65
		view 829
		loop 5
		cel 1
		priority 13
	)
)

(instance aView3 of PV
	(properties
		y 68
		x 33
		view 829
		loop 7
		priority 1
	)
)

(instance aView4 of PV
	(properties
		y 68
		x 58
		view 829
		loop 7
		priority 1
	)
)

(instance aView5 of PV
	(properties
		y 214
		x 105
		view 829
		loop 9
		priority 5
	)
)

(instance aDoor of Act
	(properties
		y 137
		x 9
		view 829
	)
)

