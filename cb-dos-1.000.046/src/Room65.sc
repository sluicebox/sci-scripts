;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room65 0
)

(synonyms
	(monument monument)
	(room garden)
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(if (& (gEgo onControl: 0) $0004)
		(= local0 1)
		(Room65 setScript: bend)
	else
		(NotClose) ; "You're not close enough."
	)
)

(procedure (localproc_1)
	(SetFlag 48)
	(= global146 1)
	(Drop1 loop: 7 x: 161 y: 125 z: 2 setCycle: Fwd setScript: 0)
	(if gDetailLevel
		(water1 cycleSpeed: 1 setCycle: Fwd)
		(water2 cycleSpeed: 1 setCycle: Fwd)
	)
)

(procedure (localproc_2)
	(ClearFlag 48)
	(= global146 0)
	(Drop1 loop: 9 cel: 0 x: 152 y: 125 z: 2)
	(if gDetailLevel
		(Drop1 cycleSpeed: 1 setScript: dripping)
		(water1 setPri: 3 cycleSpeed: 4)
		(water2 setPri: 3 cycleSpeed: 4)
	)
)

(instance Room65 of Rm
	(properties
		picture 65
	)

	(method (init)
		(= south 18)
		(super init:)
		(gConMusic stop:)
		(LoadMany rsSOUND 78 125)
		(fountain init: stopUpd:)
		(gAddToPics add: urn urn1 eachElementDo: #init doit:)
		(self setFeatures: urn urn1)
		(Splash1 ignoreActors: 1 init: hide:)
		(Splash2 ignoreActors: 1 init: hide:)
		(Drop1 init:)
		(water1 init:)
		(water2 init:)
		(if (IsFlag 48)
			(localproc_1)
		else
			(localproc_2)
		)
		(Trap ignoreActors: 1 init:)
		(if ((gInventory at: 13) ownedBy: 65) ; valve_handle
			(shaft setPri: 8 ignoreActors: 1 init: stopUpd:)
		)
		(statue setPri: 7 ignoreActors: 1 init: stopUpd:)
		(gEgo view: 0 illegalBits: -32768 init:)
		(if (== gPrevRoomNum 51)
			(gEgo posn: 273 138)
		else
			(gEgo posn: 50 186)
		)
		(if global147
			(Trap cel: (- (NumCels Trap) 1) setPri: 9 stopUpd:)
			(statue cel: 2)
			(gEgo observeControl: 2 64)
		else
			(Trap setPri: 4)
		)
		(if (== gAct 7)
			(self setRegions: 280) ; Dlill
			(gEgo observeControl: 256)
		)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 65 0) ; "This hedge garden is very strange! In the center you see a small fountain while a nearby statue overlooks it. Perhaps, at one time, this was someone's place of quiet contemplation."
		)
		(if (and global147 (& (gEgo onControl: 1) $0008) (not script))
			(gEgo ignoreControl: 64)
			(self setScript: goDown)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0010)
				(!= (gEgo mover:) 0)
				gDetailLevel
			)
			(switch (gEgo loop:)
				(2
					(if (== (gEgo cel:) 2)
						(Splash1
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 5)
						(Splash2
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
				(3
					(if (== (gEgo cel:) 2)
						(Splash1
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 5)
						(Splash2
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
				(else
					(if (== (gEgo cel:) 0)
						(Splash1
							posn: (- (gEgo x:) 2) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 4)
						(Splash2
							posn: (- (gEgo x:) 2) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 51)
			(gConMusic stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 65 0) ; "This hedge garden is very strange! In the center you see a small fountain while a nearby statue overlooks it. Perhaps, at one time, this was someone's place of quiet contemplation."
						)
						((Said '/archway')
							(Print 65 1) ; "The arched gateway leads outside."
						)
						((Said '/water')
							(Print 65 2) ; "Dirty, green water fills the little fountain."
						)
						((Said '/bush,bush')
							(Print 65 3) ; "A tall hedge completely surrounds this small garden area."
						)
						((Said '/stair')
							(if global147
								(Print 65 4) ; "The rickety stairs lead into total darkness."
							else
								(Print 65 5) ; "You don't see anything!"
							)
						)
						((Said '/passage')
							(if global147
								(Print 65 6) ; "There might be a passage down there."
							else
								(Print 65 5) ; "You don't see anything!"
							)
						)
						((Said '/shaft')
							(if (gEgo inRect: 205 111 276 200)
								(if (== (gInventory at: 13) 65) ; valve_handle
									(Print 65 7) ; "There is a metal valve handle attached to the valve stem at the base of the statue."
								else
									(Print 65 8) ; "The small, square shaft attracts your curiosity."
								)
							else
								(NotClose) ; "You're not close enough."
							)
						)
					)
				)
				((Said 'attach,attach,attach/control/shaft')
					(if (gEgo has: 20) ; crank
						(Print 65 9) ; "The crank doesn't fit on the shaft."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'attach,attach/valve,handle/shaft')
					(if (gEgo has: 13) ; valve_handle
						(if (& (gEgo onControl: 0) $0004)
							(= local1 1)
							(self setScript: bend)
							((gInventory at: 13) moveTo: gCurRoomNum) ; valve_handle
						else
							(NotClose) ; "You're not close enough."
						)
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'attach,attach/control/shaft')
					(if (gEgo has: 20) ; crank
						(if (& (gEgo onControl: 0) $0004)
							(Print 65 10) ; "The crank doesn't fit the shaft."
						else
							(NotClose) ; "You're not close enough."
						)
					else
						(DontHave) ; "You don't have it."
					)
				)
				((and (gEgo has: 13) (Said 'rotate,rotate/valve,handle')) ; valve_handle
					(Print 65 11) ; "Turning the valve handle in your hand you see the other side of it."
				)
				((Said 'rotate,rotate/valve,handle')
					(if (== ((gInventory at: 13) owner:) 65) ; valve_handle
						(localproc_0)
					else
						(DontHave) ; "You don't have it."
					)
				)
				((or (Said 'rotate<on/fountain') (Said 'rotate/fountain<on'))
					(cond
						((IsFlag 48)
							(Print 65 12) ; "It is already on!"
						)
						((== ((gInventory at: 13) owner:) 65) ; valve_handle
							(localproc_0)
						)
						(else
							(Print 65 13) ; "You don't know how."
						)
					)
				)
				((or (Said 'rotate<off/fountain') (Said 'rotate/fountain<off'))
					(cond
						((not (IsFlag 48))
							(Print 65 14) ; "It is already off!"
						)
						((== ((gInventory at: 13) owner:) 65) ; valve_handle
							(localproc_0)
						)
						(else
							(Print 65 13) ; "You don't know how."
						)
					)
				)
				((Said 'feel,(attach<give)/fountain,water')
					(if (gEgo inRect: 101 99 241 165)
						(Print 65 15) ; "You reach into the fountain, but don't feel anything special."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'move,press,pull,rotate/fountain')
					(Print 65 16) ; "The fountain doesn't move."
				)
				((Said 'close/archway')
					(Print 65 17) ; "There is no need to do that."
				)
				((Said 'open/archway')
					(Print 65 18) ; "The gate is already open."
				)
				((Said 'enter,go,(get<in),wade,climb/water,fountain')
					(Print 65 19) ; "There is no reason to get your feet wet!"
				)
				((Said 'get/water')
					(Print 65 20) ; "You have no reason to carry water."
				)
				((Said 'get/shaft')
					(if (& (gEgo onControl: 0) $0004)
						(Print 65 21) ; "The metal shaft can't be taken."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'press,move,pull/shaft,square')
					(if (& (gEgo onControl: 0) $0004)
						(Print 65 22) ; "The metal shaft doesn't move."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'rotate,rotate,spin,rotate/shaft')
					(if (& (gEgo onControl: 0) $0004)
						(Print 65 23) ; "The metal shaft won't turn by itself."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'get,detach/valve,handle')
					(cond
						((== ((gInventory at: 13) owner:) 65) ; valve_handle
							(Print 65 24) ; "You don't need it anymore."
						)
						((gEgo has: 13) ; valve_handle
							(Print 65 25) ; "You already have it."
						)
						(else
							(Print 65 26) ; "What are you talking about?"
						)
					)
				)
				((or (Said 'drink/water,fountain') (Said 'get/drink'))
					(Print 65 27) ; "You're not thirsty."
				)
				((Said 'oil/shaft')
					(if (gEgo has: 3) ; oilcan
						(Print 65 28) ; "That won't help. It's not rusty."
					else
						(Print 65 29) ; "Using what? Rudy's hair tonic?!"
					)
				)
				((Said 'force/shaft')
					(if (gEgo has: 7) ; crowbar
						(Print 65 30) ; "The shaft isn't loose."
					else
						(Print 65 31) ; "With your bare hands?"
					)
				)
			)
		)
	)
)

(instance goDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 260 133 self)
			)
			(1
				(gCurRoom newRoom: 51)
			)
		)
	)
)

(instance dripping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Drop1 cel: 0 setCycle: End self)
			)
			(1
				(water1 cel: 0 setCycle: End)
				(water2 cel: 0 setCycle: End self)
			)
			(2
				(if (not (IsFlag 48))
					(= state -1)
					(= seconds 2)
				else
					(client setScript: 0)
				)
			)
		)
	)
)

(instance bend of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 250 116 self)
			)
			(1
				(gEgo view: 165 cel: 0 loop: 6)
				(= seconds 2)
			)
			(2
				(if local0
					(= local0 0)
					(shaft hide:)
					(gEgo setCycle: End self)
					(myMusic number: 125 loop: 1 play:)
					(if (not global146)
						(Print 65 32) ; "Upon turning the valve handle, you hear a click and the fountain comes to life."
						(localproc_1)
					else
						(Print 65 33) ; "The fountain flow subsides when you turn the valve handle back."
						(localproc_2)
					)
				)
				(if local1
					(Print 65 34) ; "The metal valve handle is now attached to the valve stem at the base of the statue."
					(shaft setPri: 8 ignoreActors: 1 init: stopUpd:)
					(= local1 0)
					(= cycles 1)
				)
			)
			(3
				(shaft show:)
				(gEgo view: 0 illegalBits: -32768 loop: 1 setCycle: Walk)
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
				(HandsOff)
				(if global147
					(gEgo
						illegalBits: 0
						setAvoider: (Avoid new:)
						setMotion: MoveTo 237 91 self
					)
				else
					(gEgo
						illegalBits: 0
						setAvoider: (Avoid new:)
						setMotion: MoveTo 202 90 self
					)
				)
			)
			(1
				(gEgo loop: 2 hide:)
				(if global147
					(statue loop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
					(Trap setPri: 9 cycleSpeed: 1 setCycle: End)
				else
					(statue loop: 8 cel: 0 cycleSpeed: 1 setCycle: End self)
					(Trap cycleSpeed: 1 setCycle: Beg)
				)
				(myMusic number: 78 loop: 1 play:)
			)
			(2
				(if global147
					(statue loop: 2 cel: 2 stopUpd:)
				else
					(statue loop: 2 cel: 1 stopUpd:)
				)
				(gEgo
					show:
					view: 165
					loop: 5
					cel: 0
					illegalBits: -32768
					setCycle: End self
				)
			)
			(3
				(if global147
					(Print 65 35) ; "You grab the statue and find it turns easily. As you turn it, you notice a hidden trapdoor in the ground opening simultaneously."
					(gEgo
						view: 0
						loop: 2
						setCycle: Walk
						setAvoider: 0
						observeControl: 2 64
					)
					(= global147 1)
				else
					(gEgo
						view: 0
						loop: 2
						setCycle: Walk
						setAvoider: 0
						ignoreControl: 2
					)
					(Trap cel: 0 setPri: 4 ignoreActors: 1 init: stopUpd:)
					(= global147 0)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance Trap of Prop
	(properties
		y 128
		x 282
		view 165
		cel 4
	)

	(method (handleEvent event)
		(cond
			((Said 'close/trapdoor')
				(if global147
					(Print 65 36) ; "Turn the statue to close it."
				else
					(Print 65 37) ; "What?!"
				)
			)
			((Said 'open/trapdoor')
				(if global147
					(AlreadyOpen) ; "It is already open."
				else
					(Print 65 37) ; "What?!"
				)
			)
			((Said 'look<(in,down)/trapdoor')
				(if global147
					(if (< (gEgo distanceTo: Trap) 60)
						(Print 65 38) ; "You see steep rickety stairs leading down into...darkness!"
					else
						(NotClose) ; "You're not close enough."
					)
				else
					(Print 65 5) ; "You don't see anything!"
				)
			)
			((Said 'look<down')
				(if (and global147 (< (gEgo distanceTo: Trap) 60))
					(Print 65 38) ; "You see steep rickety stairs leading down into...darkness!"
				else
					(event claimed: 0)
				)
			)
			((or (Said 'look,find/trapdoor') (MousedOn self event 3))
				(event claimed: 1)
				(if global147
					(Print 65 39) ; "You see an open trapdoor in the ground."
				else
					(Print 65 5) ; "You don't see anything!"
				)
			)
		)
	)
)

(instance statue of Prop
	(properties
		y 78
		x 224
		view 165
		loop 2
		cel 1
	)

	(method (handleEvent event)
		(cond
			((Said 'lift,get/monument')
				(Print 65 40) ; "You can't carry around a statue!"
			)
			((Said 'move,press,pull,rotate,rotate/monument')
				(if (& (gEgo onControl: 0) $0020)
					(if (== global146 1)
						(if (not global147)
							(= global147 1)
						else
							(= global147 0)
						)
						(statue setScript: myDoor)
					else
						(Print 65 41) ; "Despite your bulging muscles, you cannot move the statue."
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/base,monument,monument'))
				(event claimed: 1)
				(if (gEgo inRect: 205 111 276 200)
					(if (== ((gInventory at: 13) owner:) gCurRoomNum) ; valve_handle
						(Printf 65 42 65 7) ; "A statue of a dancing nymph overlooks the fountain. %s"
					else
						(Printf 65 42 65 43) ; "A statue of a dancing nymph overlooks the fountain. %s"
					)
				else
					(Printf 65 42 65 44) ; "A statue of a dancing nymph overlooks the fountain. %s"
				)
			)
		)
	)
)

(instance urn of RPicView
	(properties
		y 46
		x 98
		view 165
		loop 2
		priority 3
	)

	(method (handleEvent event)
		(cond
			((Said 'get/urn')
				(Print 65 45) ; "The urns are much too heavy to carry around."
			)
			((Said 'move/urn')
				(Print 65 46) ; "Even your bugling muscles couldn't move those heavy urns."
			)
			((Said 'look<in/urn')
				(cond
					((< (gEgo distanceTo: urn) 30)
						(Print 65 47) ; "The urn is empty."
					)
					((< (gEgo distanceTo: urn1) 25)
						(Print 65 47) ; "The urn is empty."
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
			)
			((or (MousedOn self event 3) (Said 'look/urn,pedestal'))
				(event claimed: 1)
				(Print 65 48) ; "You spy two marble urns in opposite corners of the garden."
			)
		)
	)
)

(instance urn1 of RPicView
	(properties
		y 153
		x 286
		view 165
		loop 2
		priority 14
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 65 48) ; "You spy two marble urns in opposite corners of the garden."
		)
	)
)

(instance fountain of Prop
	(properties
		y 124
		x 161
		view 165
		loop 2
		cel 4
	)

	(method (handleEvent event)
		(cond
			((Said 'look<in/fountain,water')
				(if (gEgo inRect: 75 89 251 166)
					(Print 65 49) ; "You see nothing but dirty, green water in the fountain."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/fountain'))
				(Print 65 50) ; "The fountain sits forlornly in the center of the garden."
				(event claimed: 1)
			)
		)
	)
)

(instance Drop1 of Prop
	(properties
		y 125
		x 152
		z 2
		view 165
		loop 9
	)
)

(instance water1 of Prop
	(properties
		y 132
		x 162
		view 165
		loop 3
	)
)

(instance water2 of Prop
	(properties
		y 132
		x 162
		view 165
		loop 4
	)
)

(instance Splash1 of Prop
	(properties
		view 1
		loop 6
	)
)

(instance Splash2 of Prop
	(properties
		view 1
		loop 6
	)
)

(instance shaft of Prop
	(properties
		y 95
		x 243
		view 165
		loop 2
		cel 3
	)
)

(instance myMusic of Sound
	(properties)
)

