;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room61 0
)

(synonyms
	(room cabin)
)

(local
	local0
	local1
)

(instance Room61 of Rm
	(properties
		picture 61
	)

	(method (init)
		(super init:)
		(if (= local0 (== ((gInventory at: 3) owner:) 61)) ; oilcan
			(OilCan init: stopUpd:)
		)
		(gAddToPics
			add: anchor harness preserver minnow
			eachElementDo: #init
			doit:
		)
		(self setFeatures: harness anchor preserver Car Box Boat Table)
		(Load rsVIEW 60)
		(if (and (>= gAct 4) (not (& gCorpseFlags $0040)) (!= gEthelState 101)) ; Lillian
			(cond
				((== gEthelCorpseRoomNum 61)
					(self setRegions: 268) ; Dethe
					(= local1 1)
				)
				((not (== gEthelCorpseRoomNum 5))
					(switch (Random 1 2)
						(1
							(= local1 1)
							(self setRegions: 268) ; Dethe
						)
						(2
							(= gEthelCorpseRoomNum 5)
						)
					)
				)
			)
		)
		(gEgo view: 0 illegalBits: -32768 posn: 102 173 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 61 0) ; "You peer through the gloom of the old carriage house. Parts of a decrepit carriage lie in the right corner and a small rowboat, named MINNOW, rests in the left corner."
		)
		(if (& (gEgo onControl: 1) $0002)
			(gCurRoom newRoom: 20)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 61 0) ; "You peer through the gloom of the old carriage house. Parts of a decrepit carriage lie in the right corner and a small rowboat, named MINNOW, rests in the left corner."
						)
						((or (Said '/dirt') (Said '<down'))
							(Print 61 1) ; "The floor is very dusty."
						)
						((Said '/wall')
							(Print 61 2) ; "You look carefully at the walls around you, but see nothing special about them."
						)
						((or (Said '/ceiling') (Said '<up'))
							(Print 61 3) ; "You look up at the ceiling but see nothing of interest."
						)
						((Said '<(out,through)/window')
							(Print 61 4) ; "You see nothing but darkness out the windows."
						)
						((Said '/window')
							(Print 61 5) ; "The carriage house has many large windows."
						)
						((Said '/door')
							(Print 61 6) ; "You see two, large carriage doors."
						)
						((Said '<below/nightstand')
							(Print 61 7) ; "There is nothing of interest under the table."
						)
					)
				)
				((Said 'break/window')
					(Print 61 8) ; "There is no reason to do that."
				)
				((Said 'open/window')
					(Print 61 9) ; "The windows do not open."
				)
				((Said 'open/door')
					(Print 61 10) ; "The door is already open."
				)
				((Said 'get/crowbar')
					(if (& (gEgo onControl: 0) $0004)
						(if (== ((gInventory at: 7) owner:) 61) ; crowbar
							(self setScript: getBar)
						else
							(Print 61 11) ; "You peek inside the old carriage but find it empty."
						)
					else
						(NotClose) ; "You're not close enough."
					)
				)
			)
		)
	)
)

(instance getBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 173 129 self)
			)
			(1
				(Print 61 12) ; "You look inside the decrepit carriage and find a crowbar. Thinking it might come in handy, you take it with you."
				(gEgo get: 7 view: 60 cel: 0 setCycle: End self) ; crowbar
			)
			(2
				(= global182 1)
				(gEgo view: 0 loop: 0 setCycle: Walk illegalBits: -32768)
				(HandsOn)
			)
		)
	)
)

(instance anchor of RPicView
	(properties
		y 110
		x 26
		view 161
		priority 7
	)

	(method (handleEvent event)
		(cond
			((Said 'get/anchor')
				(Print 61 13) ; "You have no use for an anchor."
			)
			((or (MousedOn self event 3) (Said 'look/anchor'))
				(event claimed: 1)
				(Print 61 14) ; "An old anchor hangs on the wall."
			)
		)
	)
)

(instance harness of RPicView
	(properties
		y 79
		x 301
		view 161
		cel 1
		priority 4
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/bit'))
			(event claimed: 1)
			(Print 61 15) ; "You see an old horse harness."
		)
	)
)

(instance preserver of RPicView
	(properties
		y 75
		x 23
		view 161
		cel 2
		priority 4
	)

	(method (handleEvent event)
		(cond
			((Said 'get/preserver[<life]')
				(Print 61 16) ; "You have no use for a life preserver."
			)
			((or (MousedOn self event 3) (Said 'look/preserver[<life]'))
				(event claimed: 1)
				(Print 61 17) ; "You see a life preserver on the wall."
			)
		)
	)
)

(instance minnow of PV
	(properties
		y 141
		x 69
		view 161
		cel 3
		priority 11
	)
)

(instance Boat of RFeature
	(properties
		nsTop 120
		nsBottom 156
		nsRight 88
	)

	(method (handleEvent event)
		(cond
			((or (Said '(sit,go,climb,get)<in/boat') (Said 'enter/boat'))
				(Print 61 18) ; "There is no reason to climb into a dirty old boat."
			)
			((Said 'get/boat')
				(Print 61 19) ; "There is no way for you to take the boat."
			)
			((Said 'look<below/boat,buggy')
				(Print 61 20) ; "You see nothing there."
			)
			((Said 'search,(look<in)/boat')
				(if (& (gEgo onControl: 0) $0008)
					(if local1
						(Print 61 21) ; "You see poor Ethel lying in the boat."
					else
						(Print 61 22) ; "You look in the small rowboat but do not see anything of interest."
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/boat'))
				(event claimed: 1)
				(Print 61 23) ; "There is a small rowboat, named MINNOW, in the left corner."
			)
		)
	)
)

(instance Box of RFeature
	(properties
		nsTop 89
		nsLeft 243
		nsBottom 142
		nsRight 308
	)

	(method (handleEvent event)
		(cond
			((Said 'look,get/oar')
				(Print 61 24) ; "You can't see any oars."
			)
			((Said 'open/box,box')
				(Print 61 25) ; "There is nothing you would want in any of the boxes."
			)
			((Said 'get,move/box,box')
				(Print 61 26) ; "The crates are too big and heavy to carry."
			)
			((Said 'look<in/box')
				(Print 61 25) ; "There is nothing you would want in any of the boxes."
			)
			((or (MousedOn self event 3) (Said 'look/box'))
				(event claimed: 1)
				(Print 61 27) ; "You see old boxes here and there."
			)
		)
	)
)

(instance Car of RFeature
	(properties
		nsTop 73
		nsLeft 170
		nsBottom 120
		nsRight 227
	)

	(method (handleEvent event)
		(cond
			((or (Said '(go,sit,climb,get)<in/buggy') (Said 'enter/buggy'))
				(Print 61 28) ; "You have no reason to get into the old carriage."
			)
			((Said 'get/buggy')
				(Print 61 29) ; "There is no way for you to take the old carriage."
			)
			((Said 'search,(look<in)/buggy')
				(if (& (gEgo onControl: 0) $0004)
					(if (== ((gInventory at: 7) owner:) 61) ; crowbar
						(Room61 setScript: getBar)
					else
						(Print 61 11) ; "You peek inside the old carriage but find it empty."
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/buggy'))
				(event claimed: 1)
				(Print 61 30) ; "You see parts of an old carriage in the right corner."
			)
		)
	)
)

(instance OilCan of Prop
	(properties
		y 100
		x 90
		view 161
		cel 4
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/can'))
				(event claimed: 1)
				(Print 61 31) ; "You see an old oilcan sitting on the workbench."
			)
			((Said 'get/can')
				(if (& (gEgo onControl: 1) $0010)
					(Ok) ; "Okay."
					(gEgo get: 3) ; oilcan
					(= local0 0)
					(= global182 1)
					(OilCan dispose:)
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance myMusic of Sound ; UNUSED
	(properties)
)

(instance Table of RFeature
	(properties
		nsTop 92
		nsLeft 65
		nsBottom 103
		nsRight 134
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/nightstand'))
			(if local0
				(Print 61 32) ; "There is an oilcan on the table."
			else
				(Print 61 33) ; "There is only dust on the table."
			)
			(event claimed: 1)
		)
	)
)

