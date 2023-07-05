;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room31 0
)

(synonyms
	(room read)
)

(local
	local0
	local1
	[local2 2]
	local4
	local5
	local6
	local7
	local8
	local9
)

(instance Room31 of Rm
	(properties
		picture 31
	)

	(method (init)
		(= east 32)
		(super init:)
		(= local8 (IsFirstTimeInRoom))
		(gAddToPics
			add:
				crossbow
				rhino
				tomahawk
				aligator
				hawk
				globe
				firetools
				logs
				bookcase
				sofa
				wingback
				chair
				table1
				table2
			eachElementDo: #init
			doit:
		)
		(LoadMany rsSOUND 43 44)
		(self
			setRegions: 213 ; fireReg
			setFeatures:
				crossbow
				rhino
				logs
				sofa
				wingback
				chair
				table1
				table2
				lamp1
				lamp2
				aligator
				hawk
				globe
				tomahawk
				Desk
				Spear
				Window1
				Window2
		)
		(if gDetailLevel
			(lamp1 setPri: 5 setCycle: Fwd init:)
			(lamp2 setPri: 11 setCycle: Fwd init:)
		else
			(lamp1 setPri: 5 init: stopUpd:)
			(lamp2 setPri: 11 init: stopUpd:)
		)
		(derringer
			cel: (if (< gAct 6) 3 else 4)
			setPri: 11
			ignoreActors: 1
			init:
			stopUpd:
		)
		(Fdoor
			cel: (if (== gPrevRoomNum 10) 2 else 0)
			priority: 7
			ignoreActors: 1
			init:
			stopUpd:
		)
		(Bdoor
			cel: (if (== gPrevRoomNum 10) 2 else 0)
			ignoreActors: 1
			init:
			stopUpd:
		)
		(= global374 Fdoor)
		(= global375 Bdoor)
		(sphere setPri: 13 init: stopUpd:)
		(gundoor cel: (if (IsFlag 47) 1 else 0) setPri: 5 init: stopUpd:)
		(= global373 gundoor)
		(cabDoor setPri: 5 init: stopUpd:)
		(switch gAct
			(0
				(if (or (== [gCycleTimers 3] 1) (== global124 1))
					(self setRegions: 380) ; dustAct1
				)
			)
			(1
				(if (== gClarenceWilburState 1)
					(self setRegions: 384) ; WCAct2
				)
			)
			(3
				(if (not (& gMustDos $0002))
					(HandsOff)
					(self setRegions: 264) ; lillGun
					(gundoor cel: 1)
					(= local6 1)
				)
			)
		)
		(if (and (<= (Random 1 100) 35) (> gAct 0) (< gAct 7))
			(if local6
				(= local0 0)
			else
				(Shadow illegalBits: 0 posn: 133 82 setPri: 2 init:)
				(Shadow setScript: shadowWalk)
			)
		)
		(if (== gPrevRoomNum 32)
			(gEgo posn: 310 123)
		else
			(gEgo posn: 84 124)
			(if (not local8)
				(Fdoor setScript: closeDoor)
			)
		)
		(gEgo view: 0 illegalBits: -32764 init:)
	)

	(method (doit)
		(if local8
			(Print 31 0) ; "This appears to be the Colonel's study as a large desk dominates the room. Upon the desk you notice a small glass case. At the back of the room two large cabinets also catch your attention."
			(if (== gPrevRoomNum 10)
				(Fdoor setScript: closeDoor)
			)
			(= local8 0)
		)
		(if
			(and
				(& (gEgo onControl: 0) $0010)
				(== (gEgo loop:) 1)
				(not script)
			)
			(HandsOff)
			(self setScript: myDoor)
		)
		(if (gEgo inRect: 235 102 267 118)
			(gEgo setPri: 8)
		else
			(gEgo setPri: -1)
		)
		(if (& (gEgo onControl: 1) $0004)
			(gCurRoom newRoom: 10)
			(if (or (== gClarenceWilburState 1) (== gClarenceWilburState 2))
				(= gClarenceWilburState 3)
			)
		)
		(if (< (gEgo x:) 190)
			(= vertAngle 44)
		else
			(= vertAngle 0)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 974)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(DisposeScript 990)
		(if (== (event type:) evSAID)
			(if
				(and
					global208
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(DisposeScript 990)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return)
				)
			)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 31 0) ; "This appears to be the Colonel's study as a large desk dominates the room. Upon the desk you notice a small glass case. At the back of the room two large cabinets also catch your attention."
						)
						((Said '/boomerang[<australian]')
							(if (< (gEgo distanceTo: gundoor) 30)
								(= local4 1)
								(gundoor setScript: cabinetDrawer)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said '/cutlass[<steel]')
							(if (< (gEgo distanceTo: gundoor) 30)
								(= local4 2)
								(gundoor setScript: cabinetDrawer)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said '/mace[<antique]')
							(if (< (gEgo distanceTo: gundoor) 30)
								(= local4 3)
								(gundoor setScript: cabinetDrawer)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said '/dagger[<pearl]')
							(if (< (gEgo distanceTo: gundoor) 30)
								(if (>= gAct 5)
									(= local4 5)
								else
									(= local4 4)
								)
								(gundoor setScript: cabinetDrawer)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said '/rifle')
							(if (< (gEgo distanceTo: cabDoor) 30)
								(= local5 1)
								(cabDoor setScript: cabinetDrawer)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said '/top/armoire')
							(if (< (gEgo x:) 160)
								(Print 31 1) ; "You see a stuffed alligator on top of one cabinet."
							else
								(Print 31 2) ; "You see a stuffed eagle on top of one cabinet."
							)
						)
						((Said '/armoire')
							(cond
								((< (gEgo distanceTo: gundoor) 80)
									(if (IsFlag 47)
										(Print 31 3) ; "The leaded glass cabinet is wide open!"
									else
										(Print 31 4) ; "You see a fancy cabinet with leaded glass doors."
									)
								)
								((< (gEgo distanceTo: cabDoor) 80)
									(Print 31 5) ; "This is a large cabinet with plain glass doors."
								)
								(else
									(NotClose) ; "You're not close enough."
								)
							)
						)
						((Said '/weapon')
							(Print 31 6) ; "You wonder about the Colonel's strange fascination with weapons."
						)
						((Said '/door')
							(Print 31 7) ; "The French doors lead outside."
						)
						((Said '<above,above/fireplace')
							(Print 31 8) ; "A huge rhino head hangs above the fireplace. Two African spears cross beneath it."
						)
						((Said '/mantel')
							(Print 31 9) ; "There is nothing of interest on the fireplace mantel."
						)
					)
				)
				((Said 'move/case')
					(Print 31 10) ; "There's no reason to move it."
				)
				((Said 'open/case')
					(if (< gAct 6)
						(Print 31 11) ; "The glass case is locked."
					else
						(Print 31 12) ; "You might cut yourself on the glass shards if you tried that."
					)
				)
				((Said 'unbar/case')
					(if (< gAct 6)
						(Print 31 13) ; "You can't. You don't have the key."
					else
						(Print 31 14) ; "It's already broken."
					)
				)
				((Said 'get>')
					(cond
						((Said '/weapon')
							(Print 31 15) ; "You were never good with weapons!"
						)
						((Said '/boomerang[<australian]')
							(Print 31 16) ; "You wouldn't know how to use it."
						)
						((Said '/cutlass[<steel]')
							(Print 31 16) ; "You wouldn't know how to use it."
						)
						((Said '/mace[<antique]')
							(Print 31 16) ; "You wouldn't know how to use it."
						)
						((Said '/dagger[<pearl]')
							(if (>= gAct 5)
								(SetFlag 28)
								(Print 31 17) ; "It's gone!"
							else
								(SetFlag 27)
								(Print 31 16) ; "You wouldn't know how to use it."
							)
						)
						((Said '/rifle')
							(Print 31 18) ; "You don't know how to use a rifle. Anyway, they're not loaded."
						)
						((Said '/derringer')
							(if (< gAct 6)
								(SetFlag 25)
								(Print 31 19) ; "You can't. The glass case is locked."
							else
								(SetFlag 26)
								(Print 31 17) ; "It's gone!"
							)
						)
					)
				)
			)
		)
	)
)

(instance spin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 1)
				(sphere cycleSpeed: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(1
				(sphere cycleSpeed: 1)
				(= seconds 2)
			)
			(2
				(sphere cycleSpeed: 2)
				(= seconds 2)
			)
			(3
				(sphere setCycle: 0 stopUpd:)
				(Print 31 20) ; "Gee! You feel a little dizzy now!"
				(= local0 0)
				(HandsOn)
				(sphere setScript: 0)
			)
		)
	)
)

(instance shadowWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(Shadow setMotion: MoveTo 295 82 self)
			)
			(2
				(Shadow dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance cabinetDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local6
					(= global213 6)
					(switch local7
						(0
							(Say 1 31 21) ; "Stay out of there, Laura! Those weapons belong to my uncle!"
						)
						(else
							(Say 1 31 22) ; "Leave the weapons alone!"
						)
					)
					(++ local7)
					(client setScript: 0)
				else
					(HandsOff)
					(gEgo loop: 3)
					(cond
						(local9
							(= state 2)
							(= cycles 1)
						)
						((not (IsFlag 47))
							(client setCycle: End self)
						)
						(else
							(= cycles (= state 1))
						)
					)
				)
			)
			(1
				(= cycles 8)
			)
			(2
				(cond
					((< (gEgo x:) 160)
						(switch local4
							(1
								(Print 31 23) ; "It looks like an average boomerang!"
							)
							(2
								(Print 31 24) ; "It sure looks sharp!"
							)
							(3
								(Print 31 25) ; "The mace looks rusted. Quite usable, though."
							)
							(4
								(SetFlag 27)
								(Print 31 26) ; "The handle is inlaid with beautiful mother-of-pearl."
							)
							(5
								(SetFlag 28)
								(Print 31 17) ; "It's gone!"
							)
							(0
								(Printf ; "Cautiously, you peek inside the open door of the cabinet. Not surprisingly, part of the Colonel's weapons collection is housed there. Within the cabinet, you see an Australian boomerang, a steel cutlass%s a mace, and an antique crossbow."
									31
									27
									(if (>= gAct 5)
										{,}
									else
										{, a pearl-handled dagger,}
									)
								)
								(if (>= gAct 5)
									(SetFlag 28)
								else
									(SetFlag 27)
								)
							)
						)
					)
					(local5
						(Print 31 28) ; "None of the rifles are loaded."
						(= local5 0)
					)
					(else
						(Print 31 29) ; "You carefully open the glass door of the cabinet and look inside. Stored within it is the Colonel's rifle collection."
					)
				)
				(= cycles 1)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(client stopUpd:)
				(= local9 (= local1 0))
				(ClearFlag 47)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance myDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0)
				(= cycles 2)
			)
			(1
				(if (< (gEgo x:) 87)
					(gEgo setMotion: MoveTo 95 121 self)
				else
					(= cycles 1)
				)
			)
			(2
				(Bdoor cycleSpeed: 1 ignoreActors: 1 setCycle: End)
				(Fdoor cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(mySound number: 43 play:)
			)
			(3
				(gEgo setMotion: MoveTo (- (gEgo x:) 50) 121)
			)
		)
	)
)

(instance rhino of RPicView
	(properties
		y 32
		x 207
		view 131
		priority 5
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look<in/rhino,head')
				(Print 31 30) ; "There is nothing in the rhino head."
			)
			((or (MousedOn self event 3) (Said 'look/rhino,head'))
				(event claimed: 1)
				(Print 31 8) ; "A huge rhino head hangs above the fireplace. Two African spears cross beneath it."
			)
			((Said 'get/rhino,head')
				(Print 31 31) ; "You couldn't get that down!"
			)
		)
	)
)

(instance firetools of PV
	(properties
		y 87
		x 226
		view 131
		cel 10
		priority 5
	)
)

(instance logs of RPicView
	(properties
		y 86
		x 206
		view 131
		cel 9
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {fireplace})
		)
	)
)

(instance bookcase of PV
	(properties
		y 114
		x 88
		view 131
		cel 6
		priority 7
		signal 16384
	)
)

(instance aligator of RPicView
	(properties
		y 42
		x 127
		view 131
		cel 1
		priority 5
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MousedOn self event 3) (Said 'look/alligator'))
				(event claimed: 1)
				(Print 31 1) ; "You see a stuffed alligator on top of one cabinet."
			)
			((Said 'get/bird,alligator')
				(Print 31 32) ; "You don't want to carry that old thing around with you!"
			)
		)
	)
)

(instance sofa of RPicView
	(properties
		y 118
		x 263
		view 131
		loop 1
		cel 1
		priority 8
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance wingback of RPicView
	(properties
		y 112
		x 138
		view 131
		loop 1
		cel 2
		priority 7
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair of RPicView
	(properties
		y 165
		x 169
		view 131
		loop 1
		priority 12
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance table1 of RPicView
	(properties
		y 105
		x 167
		view 131
		cel 5
		priority 7
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 105
		x 241
		view 131
		cel 5
		priority 6
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance hawk of RPicView
	(properties
		y 43
		x 295
		view 131
		cel 2
		priority 5
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MousedOn self event 3) (Said 'look/bird'))
				(event claimed: 1)
				(Print 31 2) ; "You see a stuffed eagle on top of one cabinet."
			)
		)
	)
)

(instance globe of RPicView
	(properties
		y 166
		x 35
		view 131
		cel 8
		priority 13
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'move/globe')
				(Print 31 33) ; "It's too heavy to move."
			)
			((Said 'look<below/globe')
				(Print 31 34) ; "You see nothing there."
			)
			((Said 'look<in/globe')
				(Print 31 35) ; "It's just an empty globe."
			)
			((or (MousedOn self event 3) (Said 'look/globe'))
				(event claimed: 1)
				(Print 31 36) ; "You see a large globe in the corner of the study."
			)
			((Said 'get/globe')
				(Print 31 37) ; "It's too heavy to carry."
			)
			((Said 'open/globe')
				(Print 31 35) ; "It's just an empty globe."
			)
			((Said 'rotate,spin/globe')
				(if (== local0 0)
					(if (< (gEgo distanceTo: sphere) 30)
						(sphere setScript: spin)
					else
						(NotClose) ; "You're not close enough."
					)
				else
					(Print 31 38) ; "It is already spinning ."
				)
			)
		)
	)
)

(instance crossbow of RPicView
	(properties
		y 77
		x 85
		view 131
		cel 3
		priority 7
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MousedOn self event 3) (Said 'look/crossbow[<antique]'))
				(event claimed: 1)
				(Print 31 39) ; "The crossbow looks several hundred years old!"
			)
			((Said 'get/crossbow[<antique]')
				(Print 31 16) ; "You wouldn't know how to use it."
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 53
		x 87
		view 131
		loop 2
		priority 5
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
		y 65
		x 63
		view 131
		loop 2
		priority 11
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance tomahawk of RPicView
	(properties
		y 89
		x 59
		view 131
		cel 4
		priority 9
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MousedOn self event 3) (Said 'look/ax[<feathered]'))
				(event claimed: 1)
				(Print 31 40) ; "Pretty feathers hang from the handle of the tomahawk."
			)
			((Said 'get/ax[<feathered]')
				(Print 31 16) ; "You wouldn't know how to use it."
			)
		)
	)
)

(instance Spear of RFeature
	(properties
		nsTop 29
		nsLeft 186
		nsBottom 49
		nsRight 232
	)

	(method (handleEvent event)
		(cond
			((Said 'get/spear')
				(Print 31 41) ; "You wouldn't know how to use a spear."
			)
			((or (MousedOn self event 3) (Said 'look/spear'))
				(event claimed: 1)
				(Print 31 42) ; "Two African spears hang crossed above the fireplace."
			)
		)
	)
)

(instance Desk of RFeature
	(properties
		nsTop 118
		nsLeft 146
		nsBottom 150
		nsRight 208
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/desk,(drawer[<desk])')
				(Print 31 43) ; "There is nothing you need in the desk."
			)
			((or (MousedOn self event 3) (Said 'look/desk'))
				(event claimed: 1)
				(if (< gAct 6)
					(Print 31 44) ; "The large, oak desk sits in the center of the room. Atop it, you see a small, glass case."
				else
					(Print 31 45) ; "The large, oak desk sits in the center of the room. Atop it, you see a small, glass case which has been broken."
				)
			)
		)
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 20
		nsLeft 146
		nsBottom 85
		nsRight 178
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 20
		nsLeft 247
		nsBottom 85
		nsRight 277
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance Bdoor of Prop
	(properties
		y 127
		x 66
		view 201
		loop 2
		priority 9
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {door})
		)
	)
)

(instance Fdoor of Prop
	(properties
		y 116
		x 76
		view 201
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {door})
		)
	)
)

(instance sphere of Prop
	(properties
		y 154
		x 36
		view 131
		loop 3
	)
)

(instance gundoor of Prop
	(properties
		y 83
		x 131
		view 131
		loop 4
	)

	(method (handleEvent event)
		(cond
			((Said 'move/armoire')
				(Print 31 46) ; "It's much too heavy."
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(if (IsFlag 47)
					(Print 31 3) ; "The leaded glass cabinet is wide open!"
				else
					(Print 31 4) ; "You see a fancy cabinet with leaded glass doors."
				)
			)
		)
	)
)

(instance cabDoor of Prop
	(properties
		y 89
		x 286
		view 131
		loop 5
	)

	(method (handleEvent event)
		(cond
			((Said '(look<in),open/armoire,(door<armoire)>')
				(= local4 0)
				(cond
					((< (gEgo distanceTo: gundoor) 30)
						(if (and (Said 'open') (IsFlag 47))
							(AlreadyOpen) ; "It is already open."
						else
							(gundoor setScript: cabinetDrawer)
						)
					)
					((< (gEgo distanceTo: cabDoor) 30)
						(cabDoor setScript: cabinetDrawer)
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
				(event claimed: 1)
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(Print 31 5) ; "This is a large cabinet with plain glass doors."
			)
			((Said 'close/armoire,(door<armoire)')
				(cond
					(
						(or
							(< (gEgo distanceTo: cabDoor) 30)
							(not (IsFlag 47))
						)
						(AlreadyClosed) ; "It is already closed."
					)
					((< (gEgo distanceTo: gundoor) 30)
						(= local9 1)
						(gundoor setScript: cabinetDrawer)
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
			)
		)
	)
)

(instance derringer of Prop
	(properties
		y 124
		x 195
		view 131
		loop 1
		cel 3
	)

	(method (handleEvent event)
		(cond
			((Said 'break/glass,case')
				(if (< gAct 6)
					(SetFlag 25)
					(Print 31 47) ; "It would look suspicious if the derringer were to suddenly disappear. Better leave it there."
				else
					(SetFlag 26)
					(Print 31 14) ; "It's already broken."
				)
			)
			((Said 'feel<in/case')
				(SetFlag 25)
				(Print 31 48) ; "There's nothing there."
			)
			((Said 'get/glass,case')
				(if (< gAct 6)
					(SetFlag 25)
					(Print 31 49) ; "It would be too heavy and conspicuous to carry around."
				else
					(Print 31 50) ; "You might cut yourself carrying around a piece of glass."
				)
			)
			((or (MousedOn self event 3) (Said 'look/case[<glass]'))
				(event claimed: 1)
				(if (< gAct 6)
					(SetFlag 25)
					(Print 31 51) ; "You look through the small, glass case and notice a little, silver derringer mounted upon a blue velvet backing."
				else
					(SetFlag 26)
					(Print 31 52) ; "Oh, oh! Someone broke the glass case and took the silver derringer!"
				)
			)
			((Said 'find,look/derringer')
				(if (< gAct 6)
					(SetFlag 25)
					(Print 31 53) ; "The small, silver derringer is inside the glass case."
				else
					(SetFlag 26)
					(Print 31 17) ; "It's gone!"
				)
			)
		)
	)
)

(instance Shadow of Act
	(properties
		view 110
	)
)

(instance mySound of Sound
	(properties
		number 43
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 3)
			)
			(1
				(gEgo ignoreActors: 0 setMotion: MoveTo 99 122)
				(Fdoor setCycle: Beg)
				(Bdoor setCycle: Beg self)
				(mySound number: 44 play:)
			)
			(2
				(if (and (!= gClarenceWilburState 1) (not local6))
					(User canInput: 1)
				)
				(User canControl: 1)
				(Bdoor stopUpd:)
				(Fdoor stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

