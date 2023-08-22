;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm73 0
)

(local
	work
	aMonkey
)

(instance rm73 of Rm
	(properties
		picture 73
		horizon 50
		east 74
		south 74
		west 72
	)

	(method (init)
		(Load rsVIEW 175)
		(super init:)
		(if (== gPrevRoomNum 74)
			(gEgo posn: 318 188)
		else
			(gEgo posn: 2 153)
			((= aMonkey (Act new:)) view: 722 illegalBits: 0 posn: 221 169 init:)
		)
		(NormalEgo)
		(gEgo view: 175 setStep: 2 1 init:)
		(self setRegions: 700 setScript: rm73Script) ; rm700
	)
)

(instance rm73Script of Script
	(properties)

	(method (doit)
		(cond
			(
				(and
					(== gPastQuicksand 0)
					(or (== (gEgo edgeHit:) EDGE_RIGHT) (== (gEgo edgeHit:) EDGE_BOTTOM))
				)
				(= gPastQuicksand 1)
				(gGame changeScore: 5)
				(Print 73 0) ; "You made it!"
			)
			((and (== gCurrentStatus 0) (& (gEgo onControl:) $0040))
				(self changeState: 3)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said '/landscape')
			(Print 73 1) ; "The vines here are too high for you to reach."
		)
		(if (Said 'crawl,hop')
			(Print 73 2) ; "That won't help you here."
		)
		(if (Said 'new,stair,disembark,climb,apply/boulder')
			(Print 73 3) ; "The rocks are not the path to your success."
		)
		(if (and (gCast contains: aMonkey) (Said '/chimpanzee'))
			(Print 73 4) ; "Funny. He has no trouble whatsoever walking across this area."
		)
		(if (Said '/palm')
			(Print 73 5) ; "The trees here can't help you. You're going to have to plod through this one on your own."
		)
		(if (Said 'look>')
			(if (Said '/pattern')
				(Print 73 6) ; "The patterned area looks different from the rest of the ground here."
			)
			(if (Said '/quicksand')
				(Print 73 7) ; "It looks prepared to suck."
			)
			(if (Said '[/forest,carpet,airport]')
				(Print 73 8) ; "The ground here has a strange pattern to it."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= gPrevRoomNum 74)
					(aMonkey
						setStep: 1 1
						setMotion: MoveTo 223 181
						setCycle: End self
					)
				)
			)
			(1
				(aMonkey
					setStep: 4 3
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 334 189 self
				)
			)
			(2
				(aMonkey dispose:)
				(Print 73 9) ; "The jungle floor is soft and sticky here."
				(Print 73 10 #at -1 152) ; "(You fondly recall your first car's seat covers.)"
			)
			(3
				(= gCurrentStatus 1000)
				(HandsOff)
				(gEgo
					setLoop:
						(if
							(and
								(> (gEgo heading:) 89)
								(< (gEgo heading:) 271)
							)
							4
						else
							5
						)
					cycleSpeed: 3
					cel: 0
					setCycle: End self
				)
				(Print 73 11 #draw) ; "At least this quicksand is nice and soft."
			)
			(4
				(gEgo setLoop: 6 setCycle: Fwd cycleSpeed: 1)
				(= seconds 5)
			)
			(5
				(Print 73 12) ; "Once again, you're in over your head, Larry!"
				(Print 73 13) ; "In the future, you must be more observant!"
				(= gCurrentStatus 1001)
			)
		)
	)
)

