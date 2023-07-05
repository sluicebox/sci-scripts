;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room41 0
)

(synonyms
	(drawer chest dresser)
	(armoire armoire)
	(room bedroom)
)

(local
	local0
)

(instance Room41 of Rm
	(properties
		picture 41
	)

	(method (init)
		(= east 42)
		(super init:)
		(gAddToPics
			add: wardrobe chair1 chair2 dresser
			eachElementDo: #init
			doit:
		)
		(self setFeatures: lamp1 lamp2 wardrobe dresser chair1 chair2 Boxes)
		(cond
			((<= gAct 1)
				(bag init: stopUpd:)
				(ClearFlag 35)
			)
			(
				(and
					(>= gAct 6)
					(not (& gCorpseFlags $0020)) ; Clarence
					(not (& gCorpseFlags $0040)) ; Lillian
				)
				(cond
					((== global106 41)
						(++ local0)
						(self setRegions: 278) ; Dclar
					)
					((not (== global106 73))
						(switch (Random 1 2)
							(1
								(++ local0)
								(self setRegions: 278) ; Dclar
							)
							(2
								(= global106 73)
							)
						)
					)
				)
			)
		)
		(Bed cel: (if (IsFlag 35) 0 else 4) ignoreActors: 1 init: stopUpd:)
		(Load rsVIEW 30)
		(if gDetailLevel
			(lamp1 setCycle: Fwd init:)
			(lamp2 setCycle: Fwd init:)
		else
			(lamp1 init: stopUpd:)
			(lamp2 init: stopUpd:)
		)
		(gEgo view: 0 posn: 304 122 illegalBits: -32760 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 41 0) ; "It doesn't appear that this room has been used in a long time! However, it currently seems to be the guest room of Dr. Wilbur C. Feels."
		)
		(if (< (gEgo x:) 250)
			(= vertAngle 44)
		else
			(= vertAngle 0)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(DisposeScript 985)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said '*/blind,curtain')
					(Print 41 1) ; "Broken shutters mar the elegant French windows."
				)
				((Said 'look>')
					(cond
						((and (not (gCast contains: bag)) (Said '/bag'))
							(NotHere) ; "You don't see it here."
						)
						((Said '[<around,at][/room]')
							(Print 41 0) ; "It doesn't appear that this room has been used in a long time! However, it currently seems to be the guest room of Dr. Wilbur C. Feels."
						)
						((Said '/furniture[<covered]')
							(Print 41 2) ; "Several pieces of unused furniture have been covered against dust and cobwebs."
						)
						((Said '<in/closet')
							(Print 41 3) ; "There is only a bed in the closet."
						)
						((Said '/closet')
							(Print 41 4) ; "It's just your average armoire."
						)
						((Said '<below/cover[<furniture]')
							(Print 41 5) ; "It's just old furniture! There's nothing of interest there."
							(Print 41 6) ; "There is nothing interesting under the covers."
						)
					)
				)
				((Said 'get/cover[<furniture]')
					(Print 41 5) ; "It's just old furniture! There's nothing of interest there."
				)
				((Said 'open/closet')
					(Print 41 7) ; "There is nothing of interest in the armoire."
				)
				((or (Said 'uncover/furniture') (Said 'detach,get/cover'))
					(Print 41 5) ; "It's just old furniture! There's nothing of interest there."
				)
				(
					(or
						(Said 'open/(bed[<murphy]),door')
						(Said 'lower,pull/bed[<murphy]')
					)
					(if (IsFlag 35)
						(self setScript: myBed)
					else
						(AlreadyOpen) ; "It is already open."
					)
				)
				((Said 'close,lift,lift,attach,press/bed[<murphy,up,away]')
					(if (not (gCast contains: bag))
						(cond
							((and (== global106 41) (not (& gCorpseFlags $0020))) ; Clarence
								(Print 41 8) ; "That might be difficult with Clarence's body on it."
							)
							((not (IsFlag 35))
								(self setScript: myBed)
							)
							(else
								(AlreadyClosed) ; "It is already closed."
							)
						)
					else
						(SetFlag 31)
						(Print 41 9) ; "You can't. The doctor's bag is on the bed."
					)
				)
			)
		)
	)
)

(instance myBed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 35)
					(gEgo
						setAvoider: (Avoid new:)
						setMotion: MoveTo 243 90 self
					)
				else
					(gEgo
						setAvoider: (Avoid new:)
						setMotion: MoveTo 189 99 self
					)
				)
			)
			(1
				(if (IsFlag 35)
					(ClearFlag 35)
					(gEgo loop: 1 observeControl: 8)
					(Bed cycleSpeed: 3 setCycle: End self)
				else
					(SetFlag 35)
					(gEgo
						view: 30
						cel: 0
						loop: 1
						setCycle: End
						ignoreControl: 8
					)
					(Bed cycleSpeed: 3 setCycle: Beg self)
				)
			)
			(2
				(Bed stopUpd:)
				(if (IsFlag 35)
					(gEgo
						view: 0
						loop: 3
						posn: 179 99
						setAvoider: 0
						setCycle: Walk
					)
				)
				(HandsOn)
				(self setScript: 0)
			)
		)
	)
)

(instance wardrobe of RPicView
	(properties
		y 95
		x 112
		view 141
		loop 1
		priority 3
	)

	(method (handleEvent event)
		(cond
			((Said '(look<in),open/armoire')
				(Print 41 7) ; "There is nothing of interest in the armoire."
			)
			((or (MousedOn self event 3) (Said 'look/armoire'))
				(event claimed: 1)
				(Print 41 4) ; "It's just your average armoire."
			)
		)
	)
)

(instance chair1 of RPicView
	(properties
		y 90
		x 132
		view 141
		loop 1
		cel 3
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance dresser of RPicView
	(properties
		y 89
		x 292
		view 141
		loop 1
		cel 1
		priority 5
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look[<!*]/drawer'))
			(event claimed: 1)
			(Print 41 10) ; "You see an old dresser in the corner."
		)
	)
)

(instance chair2 of RPicView
	(properties
		y 113
		x 93
		view 141
		loop 1
		cel 2
		priority 7
	)

	(method (handleEvent event)
		(cond
			((MousedOn self event 3)
				(event claimed: 1)
				(DoLook {chair})
			)
			((Said '(look<in),open/box')
				(Print 41 11) ; "The crates are tightly sealed. Besides, there's nothing you would want in them."
			)
			((Said 'look/box')
				(Print 41 12) ; "Several old crates have been piled in the corner."
			)
			((Said 'move,get/box')
				(Print 41 13) ; "The boxes are much too heavy to move."
			)
		)
	)
)

(instance Bed of Prop
	(properties
		y 29
		x 232
		view 141
		loop 2
	)

	(method (handleEvent event)
		(cond
			((Said 'look<below/bed')
				(Print 41 14) ; "There is only dust under the bed."
			)
			((or (MousedOn self event 3) (Said 'look/bed[<murphy]'))
				(event claimed: 1)
				(cond
					(local0
						(Print 41 15) ; "Clarence's body lies slumped across the bed."
					)
					((== (Bed cel:) 0)
						(Print 41 16) ; "The bed has been put away in the wall."
					)
					((gCast contains: bag)
						(SetFlag 31)
						(Print 41 17) ; "The Murphy bed has been pulled down for Dr. Feels to sleep on. Upon it, you see his black doctor's bag."
					)
					(else
						(Print 41 18) ; "The Murphy bed has been pulled down for Dr. Feels to sleep on."
					)
				)
			)
		)
	)
)

(instance bag of Prop
	(properties
		y 79
		x 212
		view 141
		loop 1
		cel 4
	)

	(method (handleEvent event)
		(if (not (event claimed:))
			(cond
				((Said 'search,move,get,open,(look<in)/bag')
					(Print 41 19) ; "Since it belongs to Dr. Feels, you should leave it alone."
				)
				((or (MousedOn self event 3) (Said 'look/bag'))
					(event claimed: 1)
					(Print 41 20) ; "It is Dr. Feels' bag."
				)
			)
			(if (event claimed:)
				(SetFlag 31)
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 51
		x 89
		view 141
		priority 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lamp2 of Prop
	(properties
		y 63
		x 61
		view 141
		cel 1
		priority 2
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance Boxes of RFeature
	(properties
		nsTop 108
		nsLeft 50
		nsBottom 169
		nsRight 308
	)

	(method (handleEvent event)
		(cond
			((Said '(look<in),open/box')
				(Print 41 11) ; "The crates are tightly sealed. Besides, there's nothing you would want in them."
			)
			((Said 'move,get/box')
				(Print 41 13) ; "The boxes are much too heavy to move."
			)
			((or (MousedOn self event 3) (Said 'look/box'))
				(event claimed: 1)
				(Print 41 12) ; "Several old crates have been piled in the corner."
			)
		)
	)
)

