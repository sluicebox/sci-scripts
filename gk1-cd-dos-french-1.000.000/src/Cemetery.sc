;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use n013)
(use PolyPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Cemetery 0
	xKeeper 1
	sKeeperStuff 2
	trashCan 3
	sStopTalkingToKeeper 4
)

(local
	local0
)

(class Cemetery of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= initialized 0)
		(= keep (OneOf newRoomNumber 300 310 320 302))
		(if (and (!= gCurRoomNum 302) (gGk1Exits size:))
			(gGk1Exits eachElementDo: #dispose)
			(gGk1Exits dispose:)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(if (not (== gCurRoomNum 302))
			((= gGk1Exits gk1Exits) add:)
		)
		(if (and (!= gPrevRoomNum 50) (!= gPrevRoomNum 302) (!= gCurRoomNum 302)) ; interrogation
			(ClearFlag 364)
		)
		(super init:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(return
			(cond
				((Message msgGET modNum noun theVerb 0 1)
					(gMessager say: noun theVerb 0 0 0 modNum)
					1
				)
				((Message msgGET modNum noun 0 0 1)
					(gMessager say: noun 0 0 0 0 modNum)
					1
				)
				(else
					(gMessager say: 0 theVerb 0 0 0 0)
					1
				)
			)
		)
	)

	(method (doit)
		(if
			(and
				(!= gCurRoomNum 302)
				(gGk1Exits size:)
				(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
			)
			(gGk1Exits eachElementDo: #doit)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance gk1Exits of EventHandler
	(properties)
)

(instance sStopTalkingToKeeper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gEgo ignoreActors: 0)
				(xKeeper
					view: 305
					setCel: 4
					setLoop: 0
					setCycle: 0
					setScript: sKeeperStuff
				)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToKeeper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					ignoreActors: 1
					setMotion:
						PolyPath
						(- (xKeeper x:) 57)
						(+ (xKeeper y:) 5)
						self
						301
				)
			)
			(1
				(Face gEgo xKeeper)
				(xKeeper view: 305 setCel: 0 setLoop: 0 setCycle: End self)
				(trashCan cel: 0)
			)
			(2
				(if (IsFlag 364)
					(= cycles 1)
				else
					(gMessager say: 6 0 2 (Random 1 4) self 301)
				)
			)
			(3
				(if (IsFlag 364)
					(= cycles 1)
				else
					(xKeeper setCel: 0 setLoop: 1 setCycle: Fwd)
					(gMessager say: 6 0 4 (Random 1 3) self 301)
					(SetFlag 364)
				)
			)
			(4
				(xKeeper setCel: 4 setLoop: 0 setCycle: 0)
				(switch register
					(10
						(self changeState: 7)
					)
					(11
						(self changeState: 5)
					)
					(else
						(self changeState: 10)
					)
				)
			)
			(5
				(gMessager say: 5 11 (Random 6 9) 0 self 301)
			)
			(6
				(client setScript: sStopTalkingToKeeper)
			)
			(7
				(gMessager say: 5 10 0 1 self 301) ; "Mind if I pick your brain a minute?"
			)
			(8
				(xKeeper setCel: 0 setLoop: 1 setCycle: Fwd)
				(gMessager say: 5 10 0 2 self 301) ; "(RRCC. SLOW DRAWL)Go ahead. These folks aren't in any hurry."
			)
			(9
				(xKeeper setCel: 4 setLoop: 0 setCycle: 0)
				(= global178 32)
				(gCurRoom newRoom: 50) ; interrogation
			)
			(10
				(gEgo
					view: 904
					cel: 0
					setLoop: 0
					cycleSpeed: 12
					setCycle: End
				)
				(if (and gMsgType (Message msgGET 301 5 register 0 1))
					(gMessager say: 5 register 0 0 self 301)
				else
					(gMessager say: 5 0 0 0 self 301) ; "Does this mean anything to you?"
				)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo normalize: 0)
				(client setScript: sStopTalkingToKeeper)
			)
		)
	)
)

(instance sWipeHead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(xKeeper view: 303 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(1
				(xKeeper setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(xKeeper setCycle: Beg self)
			)
			(3
				(xKeeper setCel: 0 setLoop: 2 setCycle: End self)
			)
			(4
				(xKeeper setCel: 0 setLoop: 3 setCycle: End self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sGetLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(xKeeper view: 302 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(1
				(xKeeper setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(xKeeper setCel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(xKeeper setCel: 0 setLoop: 3 setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sRake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(xKeeper view: 301 setCel: 0 setLoop: 0 setCycle: Fwd)
				(= seconds (Random 2 4))
			)
			(1
				(xKeeper setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(xKeeper setCel: 0 setLoop: 2 setCycle: Fwd)
				(= seconds (Random 2 4))
			)
			(3
				(xKeeper setCel: 1 setLoop: 1 setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sWeed of Script ; UNUSED
	(properties)

	(method (dispose)
		(trashCan cel: 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(xKeeper view: 300 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(1
				(xKeeper setCel: 0 setLoop: 1 setCycle: CT 1 1 self)
			)
			(2
				(trashCan setCel: 1)
				(xKeeper setCycle: End self)
			)
			(3
				(xKeeper setCel: 0 setLoop: 2 setCycle: End self)
			)
			(4
				(xKeeper setCel: 0 setLoop: 3 setCycle: CT 3 1 self)
			)
			(5
				(trashCan setCel: 0)
				(xKeeper setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sKeeperStuff of Script
	(properties)

	(method (doit)
		(if
			(and
				(< (- (xKeeper x:) 45) (gEgo x:) (+ (xKeeper x:) 10))
				(< (- (xKeeper y:) 8) (gEgo y:) (+ (xKeeper y:) 10))
			)
			(if script
				(script dispose:)
				(xKeeper view: 305 setCel: 0 setLoop: 0 setCycle: End)
			)
		else
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 1 100))
				(= cycles 1)
			)
			(1
				(cond
					((<= register 80)
						(self setScript: sRake self)
					)
					((<= 85 register 95)
						(self setScript: sGetLeaves self)
					)
					(else
						(self setScript: sWipeHead self)
					)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance keeperBaseSetter of Code ; UNUSED
	(properties)

	(method (doit param1)
		(param1
			brLeft: (- (param1 x:) 10)
			brRight: (+ (param1 x:) 10)
			brTop: (- (param1 y:) 2)
			brBottom: (param1 y:)
		)
	)
)

(instance trashCan of View
	(properties
		noun 7
		modNum 301
		x 123
		y 123
		view 300
		loop 4
	)
)

(class xKeeper of Actor
	(properties
		noun 5
		modNum 301
		view 300
		signal 4129
		cycleSpeed 12
		moveSpeed 12
		room 300
	)

	(method (init)
		(super init:)
		(trashCan posn: (+ (xKeeper x:) 23) (+ (xKeeper y:) 3) init:)
		(if (not (== gPrevRoomNum 50)) ; interrogation
			(self setScript: sKeeperStuff)
		)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(self setScript: sTalkToKeeper 0 theVerb)
			(return 1)
		else
			(switch theVerb
				(10 ; Ask
					(self setScript: sTalkToKeeper 0 theVerb)
					(return 1)
				)
				(11 ; Talk
					(self setScript: sTalkToKeeper 0 theVerb)
					(return 1)
				)
				(7 ; Look
					(Face gEgo xKeeper)
					(super doVerb: theVerb)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

