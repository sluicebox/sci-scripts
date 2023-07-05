;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 625)
(include sci.sh)
(use Main)
(use verseScript)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use LoadMany)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Monastery 0
	chip 1
	prior 2
	wGateTimer 7
)

(local
	local0
	local1
	[local2 4] = [1625 1 1 0]
	[local6 4] = [1625 2 1 0]
	[local10 20] = [1625 3 1 0 1625 4 1 0 1625 5 1 0 1625 7 1 0 1625 6 1 0]
	[local30 4] = [1625 9 1 0]
	[local34 4] = [1625 10 1 0]
	[local38 8] = [1625 11 2 1 2 1 2 0]
	[local46 6] = [1625 16 2 1 2 0]
	[local52 7] = [1625 19 2 1 2 2 0]
	[local59 6] = [1625 23 2 1 2 0]
	[local65 4] = [1625 26 1 0]
	[local69 4] = [1625 27 1 0]
	[local73 4] = [1625 28 1 0]
	[local77 9] = [673 0 2 4 19 33 21 20 21]
	[local86 9] = [43 0 2 4 25 37 21 26 28]
)

(class Monastery of Rgn
	(properties
		keep 1
		givePriorMoney 0
		wherePrior 0
		fulkStatus 0
		whichDoor 0
		gobletTipped 0
		backFromJewels 0
		waterDie 0
		firstTimeTalk 1
		noPriorExperience 1
		moneyThree 0
		firstTimeEnter 0
		stairMessage 0
		stairsMessage 0
		deathReason 0
		roomToDie 0
		monkGroop 0
		tFULK 0
		tPRIOR 0
	)

	(method (init)
		(= monkGroop chipGroop)
		(super init:)
		(LoadMany rsVIEW 16 641)
		(Load rsSCRIPT 985)
		(= tFULK @local77)
		(= tPRIOR @local86)
	)

	(method (newRoom newRoomNumber)
		(cond
			((not (OneOf newRoomNumber 620 630 640 650 660 670 680 690 695)) ; monDeath
				(self keep: 0)
			)
			((== newRoomNumber 680)
				(= deathReason 1)
				(if (not script)
					(Monastery setScript: wGateTimer)
				)
			)
		)
	)

	(method (dispose)
		(gTheIconBar enable: 2 3 6 7)
		(self setScript: 0)
		(super dispose:)
	)
)

(instance chipGroop of Grooper
	(properties)
)

(instance chip of Actor
	(properties
		view 16
	)

	(method (init)
		(super init:)
		(self approachVerbs: 3 4) ; Do, Inventory
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= local0 (event message:))
				(= local1
					(if (and gTheIconBar (== (event message:) JOY_DOWNRIGHT) gInventory)
						(gInventory indexOf: (gTheIconBar curInvIcon:))
					)
				)
				(event claimed: 1)
				(if (== local0 JOY_UPRIGHT)
					(self doVerb: local0)
				else
					(self setScript: walkToActor)
				)
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb invItem)
		(if (== gCurRoomNum 620)
			((ScriptID 620 1) doit: theVerb invItem &rest) ; fenMonkVerb
		else
			(switch theVerb
				(5 ; Talk
					(Converse @local2 11 0) ; "Silence is better than talk, Brother."
				)
				(3 ; Do
					(Converse @local6 11 0) ; "Keep your hands to yourself, Brother."
				)
				(4 ; Inventory
					(switch invItem
						(0 ; bucks
							(if (> (gMoney doit:) 0)
								(gCurRoom setScript: monkeyMoney)
							)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance prior of Actor
	(properties
		description {the Prior.}
		lookStr 8
		view 641
	)

	(method (init)
		(super init:)
		(self approachVerbs: 3 4) ; Do, Inventory
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= local0 (event message:))
				(= local1
					(if (and gTheIconBar (== (event message:) JOY_DOWNRIGHT) gInventory)
						(gInventory indexOf: (gTheIconBar curInvIcon:))
					)
				)
				(event claimed: 1)
				(if (== local0 JOY_UPRIGHT)
					(self doVerb: local0)
				else
					(self setScript: walkToActor)
				)
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Converse @local30 (Monastery tPRIOR:) 0) ; "Have you forgotten your vows? We speak only at need here. Contemplate the virtues of silence...immediately."
			)
			(3 ; Do
				(Converse @local34 (Monastery tPRIOR:) 0) ; "Watch what you're doing, Brother Eustace! I'm not one of those Abbey Monks, you know."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(switch (Monastery givePriorMoney:)
							(0
								(if (> (gMoney doit:) 0)
									(gCurRoom setScript: notYetMoney)
								)
							)
							(1
								(if (> (gMoney doit:) 0)
									(gCurRoom setScript: onceMoney)
								)
							)
							(2
								(if (> (gMoney doit:) 0)
									(gCurRoom setScript: twiceMoney)
								)
							)
						)
					)
					(2 ; halfHeart
						(Converse @local59 8 (Monastery tPRIOR:)) ; "This emerald has been cut by a master. How did you come by it?"
						(gEgo put: 2 -1) ; halfHeart
						(SetScore -200)
					)
					(14 ; amethyst
						(Converse @local65 (Monastery tPRIOR:) 0) ; "An amethyst. A most useful stone. I commend you for bringing it to me, Brother Eustace."
						(gEgo put: 14 -1) ; amethyst
						(SetScore -50)
					)
					(17 ; handScroll
						(Converse @local69 (Monastery tPRIOR:) 0) ; "Do I look like a librarian? Put it back where it belongs and stop bothering me."
					)
					(16 ; fulkScroll
						(gEgo put: 16 -1) ; fulkScroll
						(Converse @local73 (Monastery tPRIOR:) 0) ; "*** No response given by designer."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance walkToActor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(or
						(< local0 3)
						(> local0 4)
						(<= (gEgo distanceTo: client) 30)
					)
					(= cycles 1)
				else
					(gEgo setMotion: PChase client 25 self)
				)
			)
			(1
				(if
					(<=
						(-
							(= temp0
								(GetAngle
									(gEgo x:)
									(gEgo y:)
									(client x:)
									(client y:)
								)
							)
							15
						)
						(gEgo heading:)
						(+ temp0 15)
					)
					(= cycles 2)
				else
					(Face gEgo client)
					(= cycles (if (> temp0 120) 6 else 4))
				)
			)
			(2
				(client doVerb: local0 local1)
				(HandsOn)
				(if (== gCurRoom 640)
					(gTheIconBar disable: 5)
				)
				(self dispose:)
			)
		)
	)
)

(instance ringed of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gCurRoomNum
					(650
						(gEgo setMotion: PolyPath 143 143)
						((ScriptID 625 1) ; chip
							view: 16
							posn: 27 140
							loop: 0
							cel: 0
							init:
							setCycle: Walk
							setMotion: PolyPath 127 144
						)
						(= ticks 400)
					)
					(else
						(= ticks 6)
					)
				)
			)
			(1
				(gCurRoom newRoom: 695) ; monDeath
			)
		)
	)
)

(instance notYetMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMoney doit:)
				(= seconds 5)
			)
			(1
				(Monastery givePriorMoney: 1)
				(Converse @local38 8 (Monastery tPRIOR:) self) ; "How came you by this money, Brother Eustace?"
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance onceMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMoney doit:)
				(= seconds 5)
			)
			(1
				(Monastery givePriorMoney: 2)
				(Converse @local46 8 (Monastery tPRIOR:) self) ; "Brother Eustace, you were ordered to give me all your money the first time. This is a serious breach of your vows."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance twiceMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMoney doit:)
				(= seconds 5)
			)
			(1
				(Monastery moneyThree: 1)
				(Converse @local52 8 (Monastery tPRIOR:)) ; "More money you've willfully withheld. This time your disobedience may not be overlooked.  You will go to the southeast tower and receive twenty lashes."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance monkeyMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMoney doit:)
				(= seconds 5)
			)
			(1
				(Converse @local10 11 2 0 self) ; "Have you forgotten our vows of Poverty and Obedience? You should have turned this money over to the Prior."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance wGateTimer of Script
	(properties
		seconds 180
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(Monastery waterDie: 1)
				(self dispose:)
			)
		)
	)
)

