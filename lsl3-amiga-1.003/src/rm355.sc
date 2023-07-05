;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 355)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm355 0
)

(instance rm355 of Rm
	(properties
		picture 355
	)

	(method (init)
		(Load rsVIEW 352)
		(Load rsVIEW 356)
		(super init:)
		(gAddToPics
			add: atpComputer
			add: atpPaper
			add: atpPhone
			add: atpSign
			doit:
		)
		(if (> gMachineSpeed 16)
			(aFountain setCycle: Fwd isExtra: 1 init:)
		)
		(aKen init:)
		(gEgo illegalBits: 0 posn: 290 141 init:)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 214 146 self)
				(= cycles 22)
			)
			(1
				(aKen setCycle: Fwd)
			)
			(2
				(Print 355 0) ; "Good morning, Mr. Laffer," Chairman Kenneth growls, "it's so nice of you to fit a little time into your busy day to drop by and see us here at `Natives, Inc.' Please, have a seat..."
				(aKen setCel: 0)
				(gEgo setMotion: MoveTo 269 165 self)
				(= cycles 22)
			)
			(3
				(aKen setCycle: Fwd)
			)
			(4
				(Print 355 1) ; ""...anywhere but on my couch!" he concludes."
				(aKen setCel: 0)
				(gEgo view: 356 loop: 0 cel: 0 cycleSpeed: 1 setCycle: End)
				(= cycles 33)
			)
			(5
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(6
				(gEgo loop: 1 cel: 0 setCycle: End)
				(= cycles 33)
			)
			(7
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(8
				(gEgo
					view: gNormalEgoView
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 161 165 self
				)
			)
			(9
				(gEgo setMotion: MoveTo 165 149 self)
			)
			(10
				(gEgo view: 356 loop: 2 cel: 0 setCycle: End self)
			)
			(11
				(gEgo
					cycleSpeed: 1
					setLoop: 3
					cel: 0
					setCycle: End
					setMotion: MoveTo 146 154 self
				)
			)
			(12
				(Print 355 2) ; "Oops!"
				(= seconds 2)
			)
			(13
				(aKen setCycle: Fwd)
				(= seconds 3)
			)
			(14
				(Print 355 3) ; "Perhaps you're wondering why I summoned you here, Laffer?" begins Ken. "It has nothing to do with that recent ad campaign of yours, although by its appearance you didn't have a hell of a lot to do with it yourself!"
				(aKen viewer: tiradeCycler loop: 1)
				(= seconds 3)
			)
			(15
				(Print 355 4 #at -1 144) ; "(Oops. This isn't going that well, is it, Larry?)"
				(= seconds 2)
			)
			(16
				(Print 355 5) ; "Since you are no longer married to my daughter and your marketing skills are non-existent, I can't for the life of me think of a reason why I should keep you on here!"
				(aKen loop: 2)
				(= seconds 3)
			)
			(17
				(Print 355 6) ; "In fact, I've been waiting for this moment for quite a long time. I know the perfect way to handle this situation..."
				(AddActorToPic gEgo)
				(gEgo
					view: 355
					loop: 3
					posn: (aKen x:) (aKen y:)
					setPri: 5
					stopUpd:
				)
				(NormalActor aKen 3 352)
				(aKen
					illegalBits: 0
					viewer: 0
					posn: 30 140
					setPri: 3
					setMotion: MoveTo 30 132 self
				)
			)
			(18
				(aKen setMotion: MoveTo 40 128 self)
			)
			(19
				(Print 355 7 #at -1 144) ; "(How you hate it when he gets that look in his eye...)"
				(aKen setMotion: MoveTo 109 128 self)
			)
			(20
				(Print 355 8) ; "Perhaps I could introduce you to a favorite hobby of mine..."
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance aFountain of Prop
	(properties
		y 104
		x 157
		view 350
		loop 3
	)
)

(instance aKen of Act
	(properties
		y 139
		x 33
		view 355
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 10 stopUpd:)
	)
)

(instance tiradeCycler of Code
	(properties)

	(method (doit)
		(if (not (Random 0 4))
			(aKen cycleSpeed: (Random 0 2))
		)
	)
)

(instance atpComputer of PV
	(properties
		y 149
		x 33
		view 355
		loop 4
		priority 11
		signal 16384
	)
)

(instance atpPaper of PV
	(properties
		y 128
		x 67
		view 355
		loop 4
		cel 1
		priority 12
		signal 16384
	)
)

(instance atpPhone of PV
	(properties
		y 124
		x 57
		view 355
		loop 4
		cel 2
		priority 12
		signal 16384
	)
)

(instance atpSign of PV
	(properties
		y 142
		x 63
		view 355
		loop 4
		cel 3
		priority 12
		signal 16384
	)
)

