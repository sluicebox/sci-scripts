;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm20 0
)

(local
	aPlane
	aJogger
)

(instance rm20 of Rm
	(properties
		picture 20
		horizon 1
		east 21
		south 24
		west 19
	)

	(method (init)
		(Load rsVIEW 251)
		(super init:)
		((= aJogger (Act new:))
			view: 251
			setLoop: 0
			setPri: 4
			moveSpeed: 3
			setStep: 1 1
			illegalBits: 0
			ignoreActors:
			init:
			hide:
			setCycle: Walk
		)
		((= aPlane (Act new:))
			view: 251
			setLoop: 1
			posn: 274 8
			setPri: 0
			illegalBits: 0
			ignoreActors:
			init:
			hide:
		)
		(if (or (== gPrevRoomNum 0) (== gPrevRoomNum 16))
			(gEgo posn: 309 133)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 200 setScript: rm20Script) ; rm200
	)
)

(instance rm20Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 1) $0002)
			(gCurRoom newRoom: 16)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/airline')
				(Print 20 0) ; "Stand here long enough, and you get the feeling he's practicing "touch-and-goes.""
			)
			(if (Said '/children,man,woman')
				(if (or (== state 3) (== state 4))
					(if (not gScoredJogger)
						(= gScoredJogger 1)
						(gGame changeScore: 1)
					)
					(Print 20 1) ; "You make a vow to get more exercise."
					(Print 20 2 #at -1 152) ; "(Right after you back up your hard disk!)"
				else
					(Print 20 3) ; "Where?"
				)
			)
			(if (Said '/hotel,building')
				(Print 20 4) ; "Inside that large hotel hundreds of people are being kept awake by that one airplane."
			)
			(if (Said '[/angeles,airport]')
				(Print 20 5) ; "This place looks like it belongs in "Space Quest IV, (The Coarsegold Encounter).""
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 14))
			)
			(1
				(aPlane posn: 287 8 show: setMotion: MoveTo -30 8 self)
			)
			(2
				(aPlane hide:)
				(= seconds (Random 2 9))
			)
			(3
				(aJogger posn: 61 121 show: setMotion: MoveTo 112 116 self)
			)
			(4
				(aJogger setMotion: MoveTo 150 125 self)
			)
			(5
				(aJogger hide:)
				(self changeState: 0)
			)
		)
	)
)

