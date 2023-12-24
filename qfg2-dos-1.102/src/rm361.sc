;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 361)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use HandsOffScript)
(use TargActor)
(use Motion)
(use Game)

(public
	rm361 0
)

(local
	theCount = 3
)

(instance rm361 of Rm
	(properties
		picture 361
		style 6
	)

	(method (init &tmp theCost)
		(super init:)
		(gEgo view: 361 setLoop: 6 setCel: 0 posn: 216 129 init:)
		(SetFlag 166) ; f361
		(if (IsFlag 99) ; fThiefShown
			(= theCost 500)
		else
			(= theCost 1000)
		)
		(if (== (CheckFunds theCost) 2)
			(GiveMoney theCost)
		else
			(HighPrint 361 0) ; "You hear cursing and grumbling nearby."
			(= [gInvNum 1] 0) ; Centime
			(= [gInvNum 2] 0) ; Dinar
			(= [gInvNum 17] 0) ; Gold
		)
		(mouse init:)
		(self setScript: tugOWar)
	)
)

(instance tugOWar of HandsOffScript
	(properties
		seconds 5
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(mouse
					setLoop: 7
					posn: 39 138
					xStep: 4
					setPri: 8
					setCycle: Walk
					setMotion: MoveTo 166 134 self
				)
			)
			(2
				(= cycles 12)
			)
			(3
				(mouse setLoop: 8 setMotion: MoveTo 66 126 self)
			)
			(4
				(= cycles 12)
			)
			(5
				(mouse setLoop: 7 setPri: -1 setMotion: MoveTo 130 138 self)
				(gEgo cycleSpeed: 1)
			)
			(6
				(mouse setMotion: MoveTo 138 140 self)
			)
			(7
				(mouse posn: 134 140)
				(gEgo setCel: 1)
				(= cycles 2)
			)
			(8
				(mouse posn: 117 140)
				(gEgo setCel: 2)
				(= cycles 20)
			)
			(9
				(gEgo setCycle: CT 0 1)
				(= cycles 10)
			)
			(10
				(if (-- theCount)
					(self changeState: 6)
				else
					(EgoSleeps 7 0)
					(gCurRoom newRoom: 360)
				)
			)
		)
	)
)

(instance mouse of TargActor
	(properties
		noun '/fenrus,fenrus'
		description {mouse}
		lookStr {It's a mouse!}
		view 361
	)
)

