;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room53 0
)

(synonyms
	(cracker box)
	(room bedroom)
)

(local
	[local0 2]
	local2
	local3
)

(instance Room53 of Rm
	(properties
		picture 53
	)

	(method (init)
		(= horizon 60)
		(= north 12)
		(super init:)
		(Load rsVIEW 910)
		(gAddToPics
			add: bed chair sofa chest dresser1 sink toilet
			eachElementDo: #init
			doit:
		)
		(self
			setRegions: 246 ; jeevroom
			setFeatures: bed chest sink toilet sofa chair dresser1
		)
		(if gDetailLevel
			(lamp1 setCycle: Fwd init:)
		else
			(lamp1 init: stopUpd:)
		)
		(door1 init: stopUpd:)
		(door2 init: stopUpd:)
		(if (not (gEgo has: 11)) ; crackers
			(crackerBox setPri: 10 init: stopUpd:)
		)
		(gEgo view: 0 illegalBits: -32768 posn: 155 64 init:)
		(self setScript: stairWell)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 53 0) ; "This must be the butler's room. Actually, it's not too bad considering it's down in the cellar."
		)
		(super doit:)
		(if
			(and
				(& (gEgo onControl:) $0002)
				(== (gEgo loop:) 0)
				(== local2 0)
			)
			(= local2 1)
			(self setScript: stairWell)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 53 0) ; "This must be the butler's room. Actually, it's not too bad considering it's down in the cellar."
						)
						((Said '/brick')
							(Print 53 1) ; "Yep. That's a brick wall, all right."
						)
						((Said '/stair,upstair')
							(Print 53 2) ; "The stairs lead to the outside."
						)
						((Said '/wall')
							(Print 53 3) ; "A portion of the back wall looks different than the rest. It appears to have been bricked up."
						)
						((Said '<in/closet')
							(Print 53 4) ; "You really are a snoop, Laura. There's nothing here for you."
						)
						((Said '/closet')
							(Print 53 5) ; "You see a large closet under the stairs."
						)
					)
				)
				((Said 'open>')
					(cond
						((Said '/dresser')
							(Print 53 6) ; "There is nothing of interest in the dresser."
						)
						((Said '/closet')
							(Print 53 4) ; "You really are a snoop, Laura. There's nothing here for you."
						)
					)
				)
				((Said 'get/brick')
					(Print 53 7) ; "None of the bricks are loose. This wall is solidly built."
				)
				((Said 'get/drink')
					(Print 53 8) ; "You're not thirsty."
				)
				((Said 'get,move/carpet')
					(Print 53 9) ; "There is nothing but dust under the rug."
				)
				((Said 'sit,go,use/bathroom,toilet')
					(Print 53 10) ; "That is Jeeves'. Use the one upstairs."
				)
			)
		)
	)
)

(instance dresser1 of RPicView
	(properties
		y 131
		x 271
		view 153
		loop 1
		cel 2
		priority 9
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 53 11) ; "You see a small dresser here."
		)
	)
)

(instance bed of RPicView
	(properties
		y 162
		x 254
		view 153
		loop 1
		priority 12
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look[<at]/bed'))
			(cond
				((== gAct 4)
					(Print 53 12) ; "There is a beautiful bouquet of flowers on Jeeves' bed."
				)
				((== gAct 4)
					(Print 53 13) ; "Jeeves is lying on his bed. He must be trying to take a nap."
				)
				(else
					(Print 53 14) ; "The beds are old and lumpy. Oh, well. You're not going to be doing much sleeping tonight, anyway."
				)
			)
			(event claimed: 1)
		)
	)
)

(instance chair of RPicView
	(properties
		y 120
		x 260
		view 153
		loop 1
		cel 3
		priority 8
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/chair'))
			(event claimed: 1)
			(Print 53 15) ; "The chair looks pretty old!"
		)
	)
)

(instance sofa of RPicView
	(properties
		y 162
		x 94
		view 153
		loop 1
		cel 4
		priority 12
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/couch'))
			(event claimed: 1)
			(Print 53 16) ; "The sofa looks very old, dusty, and uncomfortable."
		)
	)
)

(instance chest of RPicView
	(properties
		y 96
		x 189
		view 153
		loop 1
		cel 1
		priority 6
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/nightstand')
				(Print 53 17) ; "The nightstand doesn't open."
			)
			((Said 'look/nightstand')
				(if (gEgo has: 11) ; crackers
					(Print 53 18) ; "You see a little nightstand by Jeeves' bed."
				else
					(event claimed: 0)
				)
			)
			((Said 'look<in/dresser')
				(Print 53 6) ; "There is nothing of interest in the dresser."
			)
			((or (MousedOn self event 3) (Said 'look/dresser'))
				(event claimed: 1)
				(Print 53 11) ; "You see a small dresser here."
			)
		)
	)
)

(instance sink of RPicView
	(properties
		y 160
		x 35
		view 153
		cel 4
		priority 15
	)

	(method (handleEvent event)
		(cond
			((or (Said 'scrub,rotate/give,water') (Said 'scrub'))
				(Print 53 19) ; "Go upstairs if you want to do that."
			)
			((Said 'look<in/sink')
				(Print 53 20) ; "There is nothing in the sink."
			)
			((or (MousedOn self event 3) (Said 'look/sink'))
				(event claimed: 1)
				(Print 53 21) ; "It appears that Jeeves has a sink here, too."
			)
		)
	)
)

(instance toilet of RPicView
	(properties
		y 115
		x 78
		view 153
		cel 5
		priority 7
	)

	(method (handleEvent event)
		(cond
			((Said 'look/bathroom')
				(Print 53 22) ; "Jeeves has a small bathroom tucked away in an alcove."
			)
			((or (Said 'flush,use/toilet,bathroom') (Said 'pull/chain,handle'))
				(Print 53 23) ; "That's Jeeves' toilet. If you need to use one, go upstairs."
			)
			((Said 'open,(look<in)/toilet')
				(Print 53 24) ; "Puhleeeese, Laura!"
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/toilet')
					(Said 'sit/toilet')
				)
				(event claimed: 1)
				(Print 53 23) ; "That's Jeeves' toilet. If you need to use one, go upstairs."
			)
		)
	)
)

(instance door1 of Prop
	(properties
		y 89
		x 216
		view 153
		cel 2
		priority 5
	)
)

(instance door2 of Prop
	(properties
		y 89
		x 238
		view 153
		cel 2
		priority 5
	)
)

(instance lamp1 of Prop
	(properties
		y 86
		x 282
		view 153
		loop 5
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/lamp'))
			(event claimed: 1)
			(Print 53 25) ; "All you see are kerosene lamps. Seems as if the Colonel's too cheap to put in electric lights!"
		)
	)
)

(instance crackerBox of Prop
	(properties
		y 117
		x 270
		view 153
		loop 3
	)

	(method (handleEvent event)
		(cond
			((not (gEgo has: 11)) ; crackers
				(cond
					((or (MousedOn self event 3) (Said 'look/cracker'))
						(event claimed: 1)
						(Print 53 26) ; "A box of crackers is sitting on the nightstand next to Jeeves' bed."
					)
					((Said 'ask/butler/cracker<for')
						(= global213 11)
						(Say 1 53 27) ; "Go ahead. I don't want them. They're stale, anyway."
						(++ local3)
					)
					((Said 'get/cracker')
						(if (< (gEgo distanceTo: crackerBox) 30)
							(if (not local3)
								(Print 53 28) ; "You ask Jeeves if you can have the crackers. He nods his head in approval."
							)
							(= global182 1)
							(gEgo get: 11) ; crackers
							(crackerBox dispose:)
						else
							(NotClose) ; "You're not close enough."
						)
					)
					((Said 'look/nightstand')
						(Print 53 29) ; "You see a box of crackers on the nightstand next to Jeeves' bed."
					)
				)
			)
			((Said 'get/cracker')
				(Print 53 30) ; "You already have the box of crackers."
			)
		)
	)
)

(instance stairWell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local2
					(gEgo illegalBits: 0 setMotion: MoveTo 187 37 self)
				else
					(gEgo setMotion: MoveTo 121 82 self)
				)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

