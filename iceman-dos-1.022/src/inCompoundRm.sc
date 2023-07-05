;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 87)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use n821)
(use n824)
(use n828)
(use n954)
(use LoadMany)
(use DPath)
(use Follow)
(use Grooper)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	inCompoundRm 0
)

(local
	local0
	local1
)

(instance inCompoundRm of Rm
	(properties
		picture 87
		vanishingX 117
		vanishingY 21
	)

	(method (init)
		(super init:)
		(HandsOn)
		(User canControl: 0)
		(LoadMany rsVIEW 85 684 187 287 387 487 687 787 887 987)
		(LoadMany rsSOUND 23 223 27 227 81 90)
		(gunShot number: (proc0_5 27))
		(machineGun number: (proc0_5 23))
		(gEgo
			view: 85
			posn: 126 179
			loop: 3
			setLoop: -1
			ignoreActors: 0
			cycleSpeed: 0
			init:
			setCycle: Walk
		)
		(gAddToPics add: table mosaicPic eachElementDo: #init doit:)
		(self setScript: messageScript)
		(proc824_0)
		(backGuard init:)
		(westGuard
			init:
			setCycle: Walk
			setLoop: Grooper
			setScript: westGuardScript
		)
		(ambassador init: setScript: ambassScript)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'load/gun')
				(cond
					((not (gEgo has: 8)) ; Sub: Device | Tunisia: Tranquilizer_Gun
						(event claimed: 0)
					)
					((== (backGuard view:) 287)
						(Print 87 0) ; "You don't have any ammo."
					)
					(else
						(Print 87 1) ; "It's already loaded."
					)
				)
			)
			((or (Said 'exit[/room]') (Said 'go<out'))
				(Print 87 2) ; "Leaving now would doom the Ambassador."
			)
			((Said 'throw/food')
				(Print 87 3) ; "That's not going to get the job done."
			)
			((Said 'kill/man,guard')
				(Print 87 4) ; "The tranquilizer gun will not kill anyone."
			)
			((Said 'shoot,fire[/guard,gun]')
				(cond
					((gEgo script:)
						(event claimed: 0)
					)
					((== (backGuard view:) 287)
						(Print 87 0) ; "You don't have any ammo."
					)
					(else
						(Print 87 5) ; "You don't have the weapon handy."
					)
				)
			)
			((Said 'look<out/shutter')
				(Print 87 6) ; "This is no time for sightseeing."
			)
			((Said 'get/gun<guard')
				(Print 87 7) ; "Don't bother."
			)
		)
	)
)

(instance messageScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(Print 87 8 #at 10 10) ; "After entering the room, the second guard stands near the seated Ambassador."
				(Print 87 9 #at 10 10) ; "You start to perspire as you think to yourself, "I'm gonna have to move fast for sure!""
				(self dispose:)
			)
		)
	)
)

(instance ambassScript of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/ambassador,man>')
				(cond
					((Said 'talk')
						(if (== (backGuard view:) 487)
							(Print 87 10) ; "After taking a look at the guards, you decide against it."
						else
							(Print 87 11) ; "You calm the Ambassador and tell him who you are."
						)
					)
					((Said 'clear,untie')
						(if (== (backGuard view:) 487)
							(Print 87 12) ; "Not with the guards watching you."
						else
							(client setScript: freeAmbassadorScript)
						)
					)
					((Said 'look')
						(Print 87 13) ; "He's all tied up at the moment."
					)
				)
			)
		)
	)
)

(instance westGuardScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: MoveTo 97 136 self)
			)
			(1
				(client heading: 180)
				((client looper:) doit: (client) (client heading:))
				(= seconds 15)
			)
			(2
				(if (not (gEgo script:))
					(= cycles 2)
				)
			)
			(3
				(HandsOff)
				(Print 87 14 #at 10 10) ; "In a stern voice the guard says, "Just give the man his food and get on with your business!""
				(if (not (gEgo script:))
					(self setScript: forcedOutScript self)
				else
					(= cycles 2)
				)
			)
			(4
				(gEgo setAvoider: Avoid setMotion: MoveTo 126 179 self)
			)
			(5
				(westGuard illegalBits: 0 setMotion: MoveTo 106 178 self)
				(gEgo illegalBits: 0 setMotion: MoveTo 126 225)
			)
			(6
				(EgoDead 970 1 0 87 15) ; "Your hesitation has brought this mission to a premature end."
			)
		)
	)
)

(instance walkToEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(Print 87 14 #at 10 10) ; "In a stern voice the guard says, "Just give the man his food and get on with your business!""
				(westGuard setMotion: MoveTo 155 139)
			)
		)
	)
)

(instance forcedOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: -1
					setAvoider: Avoid
					setMotion: MoveTo (- (table x:) 40) (- (table y:) 3) self
				)
			)
			(1
				(if (not global55)
					(Print 87 16 #at 10 10) ; "You carefully place the food on the table."
				)
				(gEgo
					view: 187
					loop: 1
					ignoreControl: -32768
					heading: 90
					ignoreActors:
					setCycle: End self
				)
			)
			(2
				(if global55
					(self dispose:)
				)
				(foodView init:)
				(gEgo
					view: 684
					loop: 0
					setLoop: -1
					setCycle: Walk
					observeControl: -32768
					setAvoider: 0
					put: 13 ; Sub: Vernier_Caliper | Tunisia: Food_Platter
				)
				(self dispose:)
			)
		)
	)
)

(instance setDownFoodScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceKeyDownHandler add: self)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setLoop: -1
					setAvoider: Avoid
					setMotion: MoveTo (- (table x:) 40) (- (table y:) 3) self
				)
			)
			(1
				(if (not global55)
					(Print 87 16 #at 10 10) ; "You carefully place the food on the table."
				)
				(gEgo
					view: 187
					loop: 1
					ignoreControl: -32768
					heading: 90
					ignoreActors:
					setCycle: End self
				)
			)
			(2
				(if global55
					(self dispose:)
				)
				(User canInput: 1)
				(foodView init:)
				(gEgo
					view: 684
					loop: 0
					setLoop: -1
					setCycle: Walk
					illegalBits: -32768
					setAvoider: 0
					ignoreActors: 0
				)
				(= register 100)
			)
			(3
				(HandsOff)
				(foodView setCel: 3)
				(gEgo
					view: 187
					loop: 2
					cel: 0
					heading: 90
					setAvoider: 0
					illegalBits: 0
					ignoreActors: 1
					setCycle: End self
				)
			)
			(4
				(foodLidView init:)
				(HandsOn)
				(gEgo illegalBits: -32768 ignoreActors: 0)
				(User canControl: 0)
				(westGuard setScript: walkToEgoScript)
			)
			(5
				(Print 87 17 #at 10 10) ; "Quickly you grab the gun and point it at the nearest guard."
				(= local1 1)
				(gEgo view: 687 cel: 0 loop: 0 setCycle: End)
				(= local0 westGuard)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((< state 2))
			(register
				(-- register)
			)
			(else
				(westGuardScript cue:)
				(= register 30000)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_F10))
					(Said 'shoot,fire[/guard,gun,man]')
				)
				(cond
					((== local0 westGuard)
						(if
							(and
								(== (westGuard x:) 155)
								(== (westGuard y:) 139)
							)
							(westGuard setScript: westShootEgoScript)
						else
							(westGuard setScript: westGetsShotScript)
							(gunShot play:)
							(gIceGlobalSound number: 81 play:)
						)
					)
					((== local0 backGuard)
						(backGuard setScript: backGetsShotScript)
					)
				)
				(event claimed: 1)
			)
			((Said '[/lid,cover]>')
				(if (Said 'move,open,detach,(get<off)')
					(if (gCast contains: foodLidView)
						(Print 87 18) ; "You already did that."
					else
						(self cue:)
					)
				)
			)
			((Said 'uncover/food,tray')
				(if (gCast contains: foodLidView)
					(Print 87 18) ; "You already did that."
				else
					(self cue:)
				)
			)
			((Said 'get/gun<guard')
				(Print 87 7) ; "Don't bother."
			)
			((Said 'get/gun')
				(if (== state 4)
					(self cue:)
				else
					(Print 87 19) ; "You'll have to remove the lid first."
				)
			)
		)
	)
)

(instance westShootEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 187 setLoop: 0 setCel: 0 setCycle: CT 4 1 self)
				(machineGun play:)
			)
			(1
				(gEgo
					view: 687
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End
					setScript: 0
				)
				(client setCycle: End)
				(= seconds 4)
			)
			(2
				(EgoDead 970 1 0 87 20) ; "Due to of your slow reaction-time, the guard fires his automatic weapon at you and fills you full of holes."
			)
		)
	)
)

(instance westGetsShotScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 287
					setMotion: 0
					setLoop: 1
					cycleSpeed: 1
					cel: 0
					setCycle: End
				)
				(gEgo setCycle: Beg)
				(backGuard setScript: backShootEgoScript)
				(= local0 backGuard)
			)
		)
	)
)

(instance backShootEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 20)
			)
			(1
				(gEgo setScript: 0)
				(setDownFoodScript dispose:)
				(client view: 187 setLoop: 6 setCel: 0 setCycle: CT 4 1 self)
				(machineGun play:)
			)
			(2
				(gEgo view: 687 loop: 2 cel: 0 cycleSpeed: 1 setCycle: End)
				(client setCycle: End)
				(= seconds 4)
			)
			(3
				(EgoDead 970 1 0 87 20) ; "Due to of your slow reaction-time, the guard fires his automatic weapon at you and fills you full of holes."
			)
		)
	)
)

(instance backGetsShotScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 687
					cel: 0
					loop: 0
					setScript: 0
					setCycle: End self
				)
				(setDownFoodScript dispose:)
				(= local0 0)
				(gunShot play:)
				(gIceGlobalSound number: 90 play:)
			)
			(1
				(client
					view: 287
					setMotion: 0
					setLoop: 0
					cycleSpeed: 1
					cel: 0
					setCycle: End
				)
				(gEgo setCycle: Beg)
				(= seconds 3)
			)
			(2
				(Print 87 21 #at 10 10) ; "You fire a second tranquilizer dart at the remaining guard."
				(Print 87 22 #at 10 10) ; "The fast-acting drug takes effect as he clutches his chest and slumps to the floor."
				(gGame changeScore: 5)
				(HandsOn)
				(gEgo
					view: 684
					setCycle: Walk
					heading: 270
					loop: 1
					setLoop: Grooper
				)
			)
		)
	)
)

(instance freeAmbassadorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(backGuard ignoreActors: 1)
				(gEgo setAvoider: Avoid setCycle: Walk)
				(if (< (gEgo y:) (+ (ambassador y:) 10))
					(gEgo setMotion: MoveTo 79 116 self)
				else
					(gEgo setMotion: DPath 97 128 97 110 79 110 79 116 self)
				)
			)
			(1
				(gEgo view: 187 loop: 7 setCycle: End self)
			)
			(2
				(gEgo setAvoider: 0)
				(ambassador setCycle: 0 view: 187 setLoop: 5 cel: 0)
				(= seconds 2)
			)
			(3
				(Print 87 23 #at 10 10) ; "You calm the Ambassador as you explain to him your identity."
				(Print 87 24 #at 10 10) ; "Oh my God, man! You don't know how happy I am to see you."
				(gEgo
					view: 684
					loop: 2
					setCycle: Walk
					setMotion: DPath 97 116 97 124 82 124 self
				)
			)
			(4
				(gEgo view: 187 loop: 8 setCycle: End self)
			)
			(5
				(ambassador cel: 1)
				(gEgo view: 684 loop: 3 setCycle: Walk)
				(HandsOn)
				(User canControl: 0)
				(= seconds 3)
			)
			(6
				(chairView init:)
				(ambassador setCycle: End self)
			)
			(7
				(ambassador view: 287 loop: 4)
				(Print 87 25 #at 10 10) ; "He continues, "I was beginning to think this day would never come!""
				(Print 87 26 #at 10 10) ; "Truly," he says, "You are a real American hero!"
				(= seconds 4)
			)
			(8
				(Print 87 27 #at 10 10) ; "The Ambassador says, "I'll be so glad to see my family again.""
				(= seconds 4)
			)
			(9
				(Print 87 28 #at 10 10) ; "John, my boy," he continues, "I am personally going to see to it that you are decorated for bravery!"
				(= seconds 4)
			)
			(10
				(Print 87 29 #at 10 10) ; "That was ssssome tricky shooting, Mr. Westland!"
				(= seconds 3)
			)
			(11
				(client setScript: tookTooLongScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'change<tell<ambassador,man[/clothes]')
					(Said 'change,wear,detach,(get<off)/clothes')
				)
				(client setScript: changeClothesScript)
				(self dispose:)
			)
			((Said 'talk/man,ambassador')
				(= seconds 0)
				(self cue:)
			)
			((Said 'bind/man,guard')
				(Print 87 30) ; "No need to do that. They're out cold."
			)
			((Said 'untie/guard')
				(Print 87 31) ; "They aren't tied."
			)
		)
	)
)

(instance moveToGuard of MoveTo
	(properties)

	(method (onTarget)
		(return (or (super onTarget:) (client isBlocked:)))
	)
)

(instance changeClothesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15))
				(ambassador
					view: 287
					setLoop: 4
					ignoreActors: 1
					illegalBits: 0
					setMotion: moveToGuard 120 130 self
					setCycle: Walk
				)
			)
			(1
				(ambassador
					setMotion:
						moveToGuard
						(+ (westGuard x:) 20)
						(+ (westGuard y:) 5)
						self
				)
			)
			(2
				(ambassador
					view: 287
					setLoop: 2
					cycleSpeed: 2
					ignoreActors: 0
					setCel: 0
					setCycle: CT 3 1 self
				)
			)
			(3
				(ambassador setCycle: End self)
				(westGuard
					view: 287
					loop: 3
					cel: 0
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(4)
			(5
				(ambassador view: 887 loop: 3 setLoop: -1)
				(= seconds 10)
			)
			(6
				(client setScript: tookTooLongScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'exit[/room]') (Said 'go<out'))
				(if (< state 5)
					(Print 87 32) ; "Hold on," the Ambassador says, "I'm not done."
				else
					(gCurRoom setScript: leaveRoomScript)
					(client setScript: 0)
				)
			)
			((Said 'talk/man,ambassador')
				(if (< state 5)
					(Print 87 33) ; "Hold on," the Ambassador says, "I'm almost done."
				else
					(Print 87 34) ; ""Shouldn't we be going," he asks with concern."
				)
			)
		)
	)
)

(instance leaveRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 87 35 #at 10 10) ; ""We'd better get out of here quick,!" you urge the Ambassador."
				(HandsOff)
				(gEgo setMotion: MoveTo 104 175 self)
				(ambassador
					cycleSpeed: 0
					setCycle: Walk
					setMotion: Follow gEgo
				)
			)
			(1
				(gCurRoom newRoom: 86) ; compoundHallwayRm
			)
		)
	)
)

(instance tookTooLongScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(backGuard view: 987 setLoop: 0 setCel: 0 setCycle: CT 3 1 self)
			)
			(1
				(Print 87 36 #at 10 10) ; "The Ambassador screams, "WATCH OUT FOR THE GUARD!""
				(backGuard setCycle: CT 4 1 self)
			)
			(2
				(gEgo view: 687 setLoop: 3 setCel: 0 setCycle: End)
				(backGuard setCycle: End)
				(machineGun play:)
				(= seconds 3)
			)
			(3
				(EgoDead 970 1 0 87 37) ; "While you were wasting time, one of the guards revived and took your life."
			)
		)
	)
)

(instance foodView of View
	(properties
		view 187
		loop 3
	)

	(method (init)
		(super init:)
		(self posn: (- (table x:) 28) (table y:) 20)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]/platter,food')
				(cond
					(local1
						(Print 87 38) ; "Cold food."
					)
					((gCast contains: foodLidView)
						(Print 87 39) ; "Your gun is lying on the platter."
					)
					(else
						(Print 87 40) ; "The platter has its lid on."
					)
				)
			)
			((Said 'get/gun')
				(cond
					(local1
						(proc0_35) ; "You already took that."
					)
					((not (gCast contains: foodLidView))
						(Print 87 41) ; "You'll have to remove the lid first"
					)
					(else
						(proc0_37) ; "You can't do that."
					)
				)
			)
		)
	)
)

(instance foodLidView of View
	(properties
		view 187
		loop 3
	)

	(method (init)
		(super init:)
		(self
			posn: (+ (foodView x:) 3) (+ (foodView y:) 3) (foodView z:)
			setPri: (foodView priority:)
			addToPic:
		)
	)
)

(instance westGuard of Act
	(properties
		y 178
		x 106
		heading 360
		view 787
		loop 3
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'talk/man,guard')
				(self cue:)
			)
			((Said 'look/man,guard')
				(if (== view 787)
					(Print 87 42) ; "He looks pretty ruthless."
				else
					(Print 87 43) ; "Even unconcious, he looks pretty tough."
					(Print 87 44 #icon 387 0 0) ; "You notice he's wearing a ring with a KGB symbol.  "So," you think, "our friends the Russians are in on this!""
					(SetScore tunisia 413 8 3)
				)
			)
			((Said 'look/ring')
				(if (== view 787)
					(proc0_40) ; "You don't see that."
				else
					(Print 87 45 #icon 387 0 0) ; "It has a KGB symbol on it."
				)
			)
			((Said 'get/ring')
				(proc0_39) ; "You don't need to do that."
			)
		)
	)
)

(instance backGuard of Act
	(properties
		y 110
		x 160
		heading 180
		view 487
		loop 2
	)
)

(instance ambassador of Act
	(properties
		y 118
		x 79
		view 187
		loop 4
	)
)

(instance chairView of View
	(properties
		view 187
		loop 3
		cel 2
		signal 16400
	)

	(method (init)
		(self
			priority: (- (ambassador priority:) 1)
			x: (ambassador x:)
			y: (ambassador y:)
		)
		(super init:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'sit/chair')
				(proc0_39) ; "You don't need to do that."
			)
		)
	)
)

(instance table of RPicView
	(properties
		y 152
		x 220
		view 187
		loop 3
		cel 1
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'give,adjust,drop/tray,food[/table]')
				(if (gCast contains: foodView)
					(Print 87 46) ; "It's already on the table."
				else
					(gEgo setScript: setDownFoodScript)
				)
			)
			((Said 'look[<at][/table]')
				(Print 87 47) ; "It's just a wooden table."
			)
		)
	)
)

(instance mosaicPic of RPicView
	(properties
		y 77
		x 177
		view 187
		loop 3
		cel 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/wall,painting,mosaic]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 87 48) ; "You see a mosaic on the wall."
					)
				)
			)
		)
	)
)

(instance gunShot of Sound
	(properties
		priority 3
	)
)

(instance machineGun of Sound
	(properties
		priority 3
	)
)

