;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use n001)
(use Talker)
(use PolyPath)
(use StopWalk)
(use System)

(public
	fred 0
)

(local
	[townspeopleViews 20] = [357 351 358 352 359 353 83 0 83 1 83 2 83 3 83 4 83 5 83 6]
)

(procedure (AnyoneAt merch)
	(return
		(or
			(IsAt gEgo merch)
			(IsAt fred merch)
			(IsAt (ScriptID 89 1) merch) ; dayPlazaGuard
		)
	)
)

(procedure (IsAt walker merch)
	(return
		(and
			(!= walker self)
			(or
				(<= (walker distanceTo: merch) 50)
				(and
					(walker respondsTo: #curMerchant)
					(== merch (walker curMerchant:))
				)
			)
		)
	)
)

(class PlazaTalker of Talker
	(properties)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (respond event question &tmp [temp0 2])
		(if (== question 32)
			(self showSelf:)
		else
			(super respond: event question &rest)
		)
	)

	(method (initTalk)
		(gEgo setMotion: 0)
		(super initTalk:)
	)

	(method (endTalk)
		(self stopUpd:)
		(super endTalk:)
	)

	(method (handleEvent)
		(if (& signal $0088)
			(return 0)
		else
			(super handleEvent: &rest)
			(return)
		)
	)
)

(class PlazaWalker of PlazaTalker
	(properties
		signal 8192
		illegalBits 0
		merchantsVisited 0
		curMerchant 0
		doorEntered 0
		doorExiting 0
		pwSeconds 0
		pwLastSeconds 0
		pwState 0
		oldMover 0
		walkingView 0
		stoppedView 0
	)

	(method (init)
		(super init:)
		((= merchantsVisited (List new:)) add:)
		(= baseSetter (theBaseSetter new:))
		(self beOutOfRoom:)
	)

	(method (initTalk)
		(if oldMover
			(oldMover dispose:)
		)
		(= oldMover mover)
		(self view: stoppedView cel: 0 mover: 0 setCycle: 0)
		(Face self gEgo)
		(super initTalk:)
	)

	(method (endTalk &tmp saveView)
		(super endTalk:)
		(if oldMover
			((= mover oldMover) init:)
			(= oldMover 0)
		)
		(= saveView view)
		(self view: walkingView setCycle: StopWalk stoppedView view: saveView)
	)

	(method (cue)
		(if (< state 0)
			(super cue:)
			(return)
		)
		(switch pwState
			(0
				(if (not (= doorEntered (gCurRoom findUnblockedDoor:)))
					(= pwSeconds 5)
					(self stopUpd:)
				else
					(self
						posn: (gCurRoom xOut:) (gCurRoom yOut:)
						setMotion: PolyPath (gCurRoom xIn:) (gCurRoom yIn:) self
						show:
					)
					(= pwState 1)
				)
			)
			(1
				(= pwState 2)
				(self cue:)
			)
			(2
				(self goto:)
			)
			(3
				(Face self curMerchant)
				(= pwSeconds (Random 5 30))
				(= pwState 4)
			)
			(4
				(self goto:)
			)
			(5
				(self setMotion: PolyPath (gCurRoom xOut:) (gCurRoom yOut:) self)
				(= pwState 6)
			)
			(6
				(self beOutOfRoom:)
			)
		)
	)

	(method (doit &tmp thisSeconds)
		(if (and (not tCount) pwSeconds)
			(= thisSeconds (GetTime 1)) ; SysTime12
			(if (!= pwLastSeconds thisSeconds)
				(= pwLastSeconds thisSeconds)
				(if (not (-- pwSeconds))
					(self cue:)
				)
			)
		)
		(super doit:)
	)

	(method (goto &tmp merchs nMerchs nVisited nTimes)
		(= merchs (gCurRoom merchants:))
		(= nMerchs (merchs size:))
		(= nVisited (merchantsVisited size:))
		(if
			(and
				nMerchs
				(or (not nVisited) (and (!= (Random 1 4) 1) (!= nMerchs nVisited)))
			)
			(= nTimes 0)
			(repeat
				(= curMerchant (merchs at: (Random 0 (- nMerchs 1))))
				(if
					(and
						(not (merchantsVisited contains: curMerchant))
						(not (AnyoneAt curMerchant))
					)
					(break)
				)
				(if (> (++ nTimes) 30)
					(self leave:)
					(return)
				)
			)
			(merchantsVisited add: curMerchant)
			(self setMotion: PolyPath (curMerchant x:) (curMerchant y:) self)
			(= pwState 3)
		else
			(self leave:)
		)
	)

	(method (leave &tmp door)
		(if
			(or
				(not (= door (gCurRoom findUnblockedDoor:)))
				(and (== door doorEntered) (not (merchantsVisited size:)))
			)
			(= pwSeconds 1)
		else
			(self
				doorExiting: door
				setMotion: PolyPath (gCurRoom xIn:) (gCurRoom yIn:) self
			)
			(= pwState 5)
		)
	)

	(method (beOutOfRoom)
		(merchantsVisited release:)
		(self hide: setCycle: StopWalk stoppedView)
		(= pwSeconds (Random 1 30))
		(= pwState 0)
	)

	(method (dispose)
		(if oldMover
			(oldMover dispose:)
			(= oldMover 0)
		)
		(merchantsVisited release: dispose:)
		(super dispose:)
	)
)

(instance fred of PlazaWalker
	(properties
		tLoop -1
		color 15
		back 1
	)

	(method (init)
		(= title {Townsperson:})
		(= lookStr {A local townsperson.})
		(= myName '//man,woman,townsperson,people')
		(= description {the townsperson})
		(super init:)
	)

	(method (respond event)
		(Say self 83 7) ; "Ma fhimt."
		(event claimed: 1)
	)

	(method (endTalk)
		(super endTalk:)
		(TimePrint 3 83 8) ; "The townsperson doesn't seem to understand you."
	)

	(method (beOutOfRoom &tmp peopleIx)
		(= peopleIx (* (Random 0 2) 2))
		(= palette (Random 1 3))
		(= walkingView (= view [townspeopleViews peopleIx]))
		(= stoppedView [townspeopleViews (+ peopleIx 1)])
		(super beOutOfRoom:)
	)
)

(instance theBaseSetter of Code
	(properties)

	(method (doit theActor &tmp theX theY)
		(= theX (theActor x:))
		(= theY (theActor y:))
		(theActor
			brTop: (- theY 1)
			brBottom: (+ theY 1)
			brLeft: (- theX 6)
			brRight: (+ theX 10)
		)
	)
)

