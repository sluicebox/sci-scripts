;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm38 0
)

(local
	seenMessage
	numClouds
)

(instance rm38 of Rm
	(properties
		picture 38
		east 31
	)

	(method (init &tmp i cloud)
		(Load rsVIEW gCurrentEgoView)
		(Load rsVIEW 141)
		(Load rsVIEW 620)
		(super init:)
		(cond
			((> gMachineSpeed 60)
				(= numClouds 3)
			)
			((> gMachineSpeed 40)
				(= numClouds 2)
			)
			((> gMachineSpeed 20)
				(= numClouds 1)
			)
		)
		(if (not gLoweredLifeboats)
			(for ((= i 0)) (< i numClouds) ((++ i))
				((Act new:)
					view: 620
					setLoop: 0
					setPri: 1
					setStep: 1 1
					cel: (Random 0 10)
					ignoreHorizon:
					ignoreActors:
					illegalBits: 0
					setScript: (cloudScript new:)
				)
			)
		)
		(NormalEgo)
		(gEgo posn: 318 107 init:)
		(self setRegions: 300 setScript: rm38Script) ; rm300
	)
)

(instance rm38Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and gLoweredLifeboats (< (gEgo x:) 300) (not seenMessage))
			(= seenMessage 1)
			(gEgo observeControl: 16384)
			(Print 38 0) ; "Look! The ship has come to a standstill in the water. They must be preparing for the lifeboat drill!"
			(Print 38 1) ; "You'd better not leave this area!"
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'explore,(look<in)/boat')
			(cond
				((== gCurrentStatus 1009)
					(Print 38 2) ; "You delve through the lifeboat's contents, but find nothing that will help you through your current predicament."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(else
					(Print 38 3) ; "You are too far from the lifeboat to examine it carefully. Perhaps you should climb in."
				)
			)
		)
		(if
			(or
				(Said 'cut/bathing')
				(Said 'apply/apparatus')
				(Said 'boat,decrease/boat')
			)
			(Print 38 4) ; "A good idea."
			(Print 38 5) ; "But you find nothing here to help you do that."
		)
		(if (Said 'look>')
			(if (Said '/lagoon,water,lagoon')
				(Print 38 6) ; "While no whitecaps are visible here, the rolling motion of the ship makes you briefly consider throwing something overboard."
				(Print 38 7 #at -1 152) ; "(Where "something" is defined as your lunch!)"
			)
			(if (Said '/chain')
				(Print 38 8) ; "It's there to prevent people like you from falling overboard."
			)
			(if (Said '/boat,apparatus')
				(Print 38 9) ; "It is firmly attached to its mooring apparatus by ropes. There is a chain preventing you from falling over the side of the ship."
			)
			(if (Said '[/airport]')
				(Print 38 10) ; "The upper deck of the ship stretches away in all directions. There is a lifeboat hanging around here."
			)
		)
		(if (Said 'get,pull,(get<off),drain/door,chain')
			(Print 38 11) ; "No way! You might fall overboard. You're not coordinated enough to balance on this heaving deck."
		)
		(if (Said 'crawl/chain,balcony')
			(Print 38 12) ; "Good idea."
			(gEgo hide:)
			(Print 38 13 #draw) ; "You crawl under the chain. As you plummet to the water you think to yourself, "Gee, aren't we hundreds of miles from shore?""
			(Print 38 14 #at -1 152) ; "(Yes!)"
			(= gCurrentStatus 1001)
		)
		(if (Said '(hop<off),dive,hop/overboard,craft')
			(Print 38 12) ; "Good idea."
			(gEgo hide:)
			(Print 38 15 #draw) ; "You rapidly race for the railing and fling yourself over the ship's railing. As you plummet to the water you think to yourself, "Gee, aren't we hundreds of miles from shore?""
			(Print 38 14 #at -1 152) ; "(Yes!)"
			(= gCurrentStatus 1001)
		)
		(if
			(and
				(== gCurrentStatus 1009)
				(or
					(Said 'hop,new,new[/down,boat,barstool]')
					(Said 'disembark,board')
					(Said 'climb,new,get<off,up')
				)
			)
			(Ok) ; "Ok."
			(self changeState: 10)
		)
		(if
			(or
				(Said 'hop,bath[/down,boat,barstool]')
				(Said 'climb/chain')
				(Said 'get,climb<in/boat')
				(Said 'board/boat')
			)
			(cond
				((!= gCurrentEgoView 100)
					(Print 38 16) ; "Not dressed like that!"
				)
				((== gCurrentStatus 1009)
					(Print 38 17) ; "You are already in the lifeboat."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not (gEgo inRect: 128 99 217 122))
					(NotClose) ; "You're not close enough."
				)
				(else
					(if (not gScoredLifeboat)
						(= gScoredLifeboat 1)
						(gGame changeScore: 2)
					)
					(Ok) ; "Ok."
					(self changeState: 2)
				)
			)
		)
		(if (Said 'get/boat')
			(Print 38 18) ; "Right. You'll never get THAT thing to fold up into your pocket!"
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(2
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 165 111 self)
			)
			(3
				(gEgo view: 141 setLoop: 0 cel: 0 setCycle: Fwd)
				(= cycles (* 3 (NumCels gEgo)))
			)
			(4
				(gEgo setLoop: 1 setCycle: Fwd)
				(= cycles (* 3 (NumCels gEgo)))
			)
			(5
				(gEgo setLoop: 2 cel: 0 posn: 157 79 setCycle: CT 3 1 self)
			)
			(6
				(gEgo setPri: 0 setCycle: End self)
			)
			(7
				(if gLoweredLifeboats
					(gCurRoom newRoom: 131)
				else
					(User canInput: 1)
					(= gCurrentStatus 1009)
					(= seconds 7)
				)
			)
			(8
				(Print 38 19 #at -1 152) ; "(Gee. This is exciting.)"
				(= seconds 7)
			)
			(9
				(Print 38 20 #at -1 152) ; "(Are we having fun yet?)"
			)
			(10
				(User canInput: 0)
				(= cycles (= seconds 0))
				(gEgo setCel: 255 setCycle: CT 3 -1 self)
			)
			(11
				(gEgo setPri: -1 setCycle: Beg self)
			)
			(12
				(gEgo posn: 165 111)
				(NormalEgo 3)
			)
		)
	)
)

(instance cloudScript of Script
	(properties)

	(method (changeState newState &tmp tmpY tmpCel)
		(switch (= state newState)
			(0
				(client posn: (Random 0 270) (Random 3 35) init:)
				(self changeState: 2)
			)
			(1
				(= tmpY (Random 3 35))
				(= tmpCel (Random 0 10))
				(client setCel: tmpCel posn: 321 tmpY)
				(self changeState: 2)
			)
			(2
				(client
					moveSpeed: (Random 0 3)
					setMotion:
						MoveTo
						(- 1 (CelWide 620 0 tmpCel)) ; UNINIT
						(client y:)
						self
				)
				(= state 0)
			)
		)
	)
)

