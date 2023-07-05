;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Door)
(use Interface)
(use Extra)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm15 0
)

(local
	storeOpen
	thisIsIt
	lclWindow
	aCar
	aSignal
	aHench
	aDoorWest
	aDoorEast
)

(instance rm15 of Rm
	(properties
		picture 15
		horizon 77
		north 11
		east 16
		south 19
	)

	(method (init)
		(Load rsVIEW 220)
		(Load rsVIEW 223)
		(super init:)
		(NormalEgo)
		(self setRegions: 200 setScript: rm15Script) ; rm200
		((View new:) view: 220 loop: 2 cel: 0 posn: 116 93 setPri: 8 addToPic:)
		(if (and (== gLAhenchAfterEgo 0) (gEgo has: 10)) ; Onklunk
			(= thisIsIt 1)
		)
		(if (and gLAhaircut (not (gEgo has: 10))) ; Onklunk
			(= storeOpen 1)
		)
		(if (or thisIsIt storeOpen)
			((= aDoorWest (AutoDoor new:))
				view: 220
				setLoop: 0
				posn: 43 115
				entranceTo: (and (!= gPrevRoomNum 115) 115)
				msgLook:
					{A sign in the window says, "Now OPEN for business. Please come in!"}
				msgCloser:
					{The entrance door is to the left. Just walk near it.}
				init:
			)
		else
			((View new:) view: 220 ignoreActors: posn: 43 115 addToPic:)
			(gEgo observeControl: 16384)
		)
		(if (== gPrevRoomNum 115)
			((= aDoorEast (Prop new:))
				view: 220
				setLoop: 1
				setCel: 255
				posn: 262 81
				cycleSpeed: 2
				init:
				setCycle: Beg
			)
		else
			((View new:)
				view: 220
				ignoreActors:
				setLoop: 1
				posn: 262 81
				addToPic:
			)
		)
		(if thisIsIt
			(= gLAhenchAfterEgo 1)
			(= gCurrentStatus 1)
			(rm15Script changeState: 2)
			(Load rsVIEW 223)
			(gCurRoom east: 0)
			((View new:)
				view: 220
				loop: 3
				cel: 0
				posn: 27 64
				setPri: 15
				addToPic:
			)
			((= aCar (Extra new:))
				view: 220
				setLoop: 4
				setPri: 8
				posn: 20 172
				cycleSpeed: 0
				init:
			)
			((= aHench (Act new:))
				view: 223
				loop: 0
				posn: 10 174
				setCycle: Walk
				stopUpd:
				init:
			)
			(gEgo posn: 253 89 init:)
			(HandsOff)
		else
			((= aSignal (Prop new:))
				view: 220
				loop: 3
				setCel: 0
				posn: 27 64
				setPri: 15
				stopUpd:
				init:
				setScript: trafficSignalScript
			)
			(cond
				((== gPrevRoomNum 0)
					(gEgo posn: 302 81)
				)
				((== gPrevRoomNum 11)
					(gEgo posn: 302 81)
				)
				((== gPrevRoomNum 19)
					(gEgo posn: 8 188)
				)
				((== gPrevRoomNum 115)
					(gEgo posn: 253 89)
				)
			)
			(gEgo init:)
		)
	)
)

(instance rm15Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (and lclWindow (== state 4))
			(event claimed: 1)
			(= lclWindow 0)
			(cls)
			(self cue:)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(if (Said '/door,sign')
			(cond
				(storeOpen
					(Print 15 0) ; "A sign in the window says "GRAND OPENING -- TODAY!""
				)
				((gEgo has: 10) ; Onklunk
					(Print 15 1) ; "It appears that both doors are locked, since there is a sign that says "WATCH FOR OUR BIG GOING OUT OF BUSINESS SALE!""
				)
				(else
					(Print 15 2) ; "It appears that both doors are locked, since there is a sign that says "WATCH FOR OUR GRAND OPENING -- REAL SOON NOW!""
				)
			)
			(if (< (gEgo x:) 155)
				(Print 15 3) ; "The door nearest you is labeled "ENTER.""
			else
				(Print 15 4) ; "The door nearest you is labeled "EXIT.""
			)
		)
		(if (Said '/pole,burn,(burn<stop),(sign<stop)')
			(Print 15 5) ; "The stoplight seems unnecessary here, since there aren't any cars here!"
		)
		(if
			(and
				(Said 'look>')
				(Said '[/building,(building<music),building,sign,airport]')
			)
			(Print 15 6) ; "You are outside the famous LA landmark "Ye Olde Ethno- Musicology Shoppe." You are familiar with them from their many advertisements on late-night cable television."
			(Print 15 7) ; "Does this town have specialized stores or what!?"
			(if storeOpen
				(Print 15 0) ; "A sign in the window says "GRAND OPENING -- TODAY!""
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 30)
			)
			(1
				(if (and storeOpen (!= gPrevRoomNum 115))
					(Print 15 8) ; "Say, look! This store is finally open for business."
				)
				(if (== gPrevRoomNum 115)
					(aDoorWest entranceTo: 115)
				)
			)
			(2
				(= cycles 0)
				(= seconds 3)
			)
			(3
				(gEgo setMotion: MoveTo 262 140 self)
			)
			(4
				(= lclWindow (Print 15 9 #at -1 20 #dispose)) ; "Say, what an interesting car," you think to yourself. "How does he make it do that?"
			)
			(5
				(gEgo setMotion: MoveTo 262 170 self)
				(aDoorEast stopUpd:)
			)
			(6
				(aDoorWest locked: 0)
				(Print 15 10) ; "You are so distracted by the low-rider that you fail to notice the unusual little man lurking beside the car."
				(Print 15 11) ; "He, however, DOESN'T fail to notice you!"
				(gEgo setMotion: MoveTo 350 170 self)
			)
			(7
				(Print 15 12) ; "The little guy in the trench coat gives you a short head-start then follows you. Larry, be careful! This guy's up to no good!"
				(aHench setMotion: MoveTo 333 (aHench y:) self)
			)
			(8
				(aHench dispose:)
				(= seconds 4)
			)
			(9
				(= gCurrentStatus 3)
				(aDoorWest entranceTo: 115)
				(gEgo
					posn: -30 126
					setMotion: MoveTo 49 119 self
					illegalBits: 0
				)
			)
			(10
				(Print 15 13) ; "Wait a minute! What's this?!"
				(Print 15 14) ; "How can you be at the door to the music store, when you just walked off screen to the right?"
				(Print 15 15) ; "That must be someone who just looks like you! Something strange is going on here. Let's follow him into the music shop to see what we can learn!"
				(gEgo setMotion: MoveTo 78 105 self)
			)
		)
	)
)

(instance trafficSignalScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
			)
			(1
				(aSignal setCel: 1)
				(= seconds 4)
			)
			(2
				(aSignal setCel: 2)
				(= seconds 13)
			)
			(3
				(aSignal setCel: 0)
				(= seconds 13)
				(= state 0)
			)
		)
	)
)

