;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm13 0
)

(local
	[unused 2]
	tookApiss
)

(instance mPiss2 of Sound
	(properties
		number 26
		priority -1
	)
)

(instance rm13 of Rm
	(properties
		picture 13
		horizon 50
		east 14
		south 17
		west 12
	)

	(method (init)
		(Load rsVIEW 242)
		(Load rsSOUND 26)
		(super init:)
		(mPiss2 init:)
		(aView1 loop: 0 cel: 0 setPri: 1 ignoreActors: addToPic:)
		(self setRegions: 200 setScript: rm13Script) ; rm200
		(aPuddle
			setLoop: 2
			setCel: 0
			setPri: 6
			cycleSpeed: 3
			ignoreActors:
			init:
		)
		(if (== 3 (Random 1 3))
			(rm13Script changeState: 1)
			(aHead setLoop: 1 setCel: 0 setPri: 3 cycleSpeed: 1 init:)
		)
		(cond
			((== gPrevRoomNum 0)
				(gEgo posn: 198 187)
			)
			((== gPrevRoomNum 17)
				(gEgo posn: 198 187)
			)
		)
		(NormalEgo)
		(gEgo init:)
	)
)

(instance rm13Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(gEgo inRect: 254 112 258 115)
				(not tookApiss)
				(== (gEgo loop:) 0)
			)
			(= tookApiss 1)
			(gEgo setScript: pissScript)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said '(look<in),open,increase/lid,barrel,barrel')
			(if (not (gEgo inRect: 230 115 284 137))
				(NotClose) ; "You're not close enough."
			else
				(Print 13 0) ; "You quickly open the lid, search through all the rubbish, find nothing, and close the lid."
				(Print 13 1 #at -1 130) ; "(What did you expect? A passport?)"
			)
		)
		(if (Said 'look/barrel,barrel')
			(Print 13 2) ; "There are insults written in many languages on the side of the garbage bin."
		)
		(if (Said 'look/fence')
			(Print 13 3) ; "There is nothing interesting about that fence."
			(Print 13 4 #at -1 130) ; "(Unless you find that knothole interesting.)"
		)
		(if (or (Said 'look<in,through/fence') (Said 'look/hole'))
			(if (not (gEgo inRect: 192 96 203 108))
				(NotClose) ; "You're not close enough."
			else
				(Print 13 5) ; "You bend over and peer through the knothole in the fence. On the other side, you see people playing "Police Quest!" How you wish you were one of them!"
				(if (not gScoredKnothole)
					(= gScoredKnothole 1)
					(gGame changeScore: 1)
				)
			)
		)
		(if (or (Said '//hole,fence') (Said '/hole,fence'))
			(Print 13 6) ; "Stop spending so much time worrying about holes and get on with the game!"
		)
		(if (Said 'look>')
			(if (Said '/graffiti')
				(Print 13 7) ; "It says a lot of dirty stuff."
			)
			(if (Said '/sign')
				(Print 13 8) ; "LIQUOR"
			)
			(if (Said '[/barrel,alley,barrel,building,airport]')
				(Print 13 9) ; "This looks exactly like the dark alley in "Leisure Suit Larry in the Land of the Lounge Lizards.""
				(Print 13 10) ; "(But where's your friend?)"
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds (Random 10 20))
			)
			(2
				(aHead posn: 198 73 setCycle: End self)
			)
			(3
				(aHead setCel: 0 posn: 198 1034)
				(= state 0)
				(= seconds (Random 30 90))
			)
		)
	)
)

(instance pissScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(mPiss2 play:)
				(aPuddle posn: 243 117 setCycle: End self)
			)
			(1
				(NormalEgo)
				(aPuddle dispose:)
				(Print 13 11 #draw) ; "Ahhh."
			)
		)
	)
)

(instance aView1 of View
	(properties
		y 34
		x 276
		view 242
	)
)

(instance aPuddle of Prop
	(properties
		y 1117
		x 243
		view 242
	)
)

(instance aHead of Prop
	(properties
		y 1073
		x 198
		view 242
	)
)

