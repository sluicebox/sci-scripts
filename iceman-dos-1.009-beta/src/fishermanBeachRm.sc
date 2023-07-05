;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use n316)
(use n802)
(use n954)
(use LoadMany)
(use Sight)
(use Extra)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	fishermanBeachRm 0
)

(local
	local0 = 1
	local1
	local2
	local3
)

(instance fishermanBeachRm of Rm
	(properties
		picture 70
		north 75
		east 71
		south 45
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 68 70 170 71 270)
		(if (== gPrevRoomNum 45) ; netBeachRm
			(gIceGlobalSound fade:)
		)
		(gEgo init: ignoreActors: observeControl: 64 cycleSpeed: 0)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 112 82 loop: 0)
			)
			(east
				(gEgo posn: 310 (gEgo y:) loop: 1)
			)
			(else
				(gEgo posn: 200 110 view: 71 loop: 3)
			)
		)
		(self setRegions: 310 306 setFeatures: rockFeatureRight rockFeatureLeft) ; tunisia, guardcReg
		(wave init:)
		((Clone wave) x: 97 y: 179 loop: 2 priority: 14 isExtra: 1 init:)
		((Clone wave) x: 37 y: 150 loop: 1 priority: 11 isExtra: 1 init:)
		((Clone wave) x: 177 y: 181 loop: 0 priority: 14 isExtra: 1 init:)
		(if (not (& (tunisia flags:) $0008))
			(fisherMan init:)
		)
		(proc316_0 gCurRoomNum 3)
	)

	(method (dispose)
		(gEgo ignoreControl: 64)
		(super dispose:)
	)

	(method (doit)
		(cond
			((and local0 (& (proc802_0 gEgo 3) $0040))
				(Print 70 0) ; "You don't have time to swim."
				(= local0 0)
			)
			((== (gEgo onControl: 1) 16384)
				(self newRoom: north)
			)
		)
		(super doit: &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(Print 70 1) ; "An arid but beautiful beach."
			)
		)
	)
)

(instance fisherMan of Prop
	(properties
		y 159
		x 80
		heading 180
		view 68
		loop 3
		priority 13
	)

	(method (init)
		(super init:)
		(self setScript: fisherManScript)
		(fisherMansHead init:)
	)
)

(instance fisherManScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(local1
				(client setCycle: 0)
				(= seconds 0)
				(gGame changeScore: 1)
				(= local1 0)
				(self setScript: acknowledgeScript self)
			)
			(local2
				(client setCycle: 0)
				(= local2 (= seconds 0))
				(self setScript: giveDirectionScript self)
			)
			(local3
				(client setCycle: 0)
				(= local3 (= seconds 0))
				(self setScript: wontTalkScript self)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 3 cycleSpeed: 3)
				(= seconds (Random 2 6))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(self init: client)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/man,iceman,(man<ice),disguise,fisherman]>')
				(cond
					((CantBeSeen client gEgo 270)
						(cond
							((Said 'look[<at]/man,fisherman')
								(Print 70 2) ; "Facing in that direction you see no one."
							)
							((Said 'talk')
								(Print 70 3) ; "Please face the fisherman before you speak!"
							)
							((Said '/iceman')
								(Print 70 4) ; "From here the fisherman does not hear you."
							)
						)
					)
					((Said 'look[<at]')
						(Print 70 5) ; "You see a solitary fisherman pulling in his net."
					)
					((> (gEgo distanceTo: fisherMan) 35)
						(Print 70 6) ; "Move in closer so you don't have to shout."
						(event claimed: 1)
					)
					((Said 'get/disguise')
						(if (proc316_1 gCurRoomNum 3)
							(Print 70 7) ; "The fisherman continues his work as if no one is near."
						else
							(= local2 1)
						)
					)
					((or (gEgo has: 3) (gEgo has: 4) (gEgo has: 5)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish, Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule, Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
						(Print 70 8) ; "The fisherman ignores you."
						(event claimed: 1)
					)
					((Said '/iceman,(man<ice)')
						(if (proc316_1 gCurRoomNum 3)
							(= local1 1)
						else
							(Print 70 9) ; "The fisherman ignores your additional references to the code name."
							(event claimed: 1)
						)
					)
					((Said 'talk[/man]')
						(= local3 1)
					)
				)
			)
		)
	)
)

(instance fisherMansHead of Prop
	(properties
		view 68
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self
			setPri: (+ (fisherMan priority:) 1)
			posn: (+ (fisherMan x:) 3) (- (fisherMan y:) 27)
			hide:
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance acknowledgeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc310_1 gEgo)
				(= seconds 3)
			)
			(1
				(proc310_2)
				(Print 70 10 #at 25 10) ; "Using the Arabic language, you mention code name "Iceman.""
				(Print 70 11 #at 25 10) ; "Without speaking, the fisherman acknowledges by shaking his head yes."
				(fisherMansHead show: loop: 1 setCycle: End self)
				(fisherMan loop: 2 setCel: 0)
			)
			(2
				(fisherMansHead setCycle: Beg self)
			)
			(3
				(fisherMansHead hide:)
				(fisherMan loop: 3)
				(= cycles 5)
			)
			(4
				(HandsOff)
				(gEgo view: 71)
				(if (< (gEgo y:) 137)
					(gEgo setMotion: MoveTo 113 137 self)
				else
					(= cycles 1)
				)
			)
			(5
				(if (< (gEgo y:) 152)
					(gEgo setMotion: MoveTo 109 154 self)
				else
					(= cycles 1)
				)
			)
			(6
				(gEgo ignoreControl: -32768 setMotion: MoveTo 108 157 self)
			)
			(7
				(gEgo heading: 270 cycleSpeed: 1)
				((gEgo looper:) doit: (gEgo) (gEgo heading:))
				(= cycles 1)
			)
			(8
				(Print 70 12) ; "He then hands you a fish."
				(fisherMansHead loop: 0 show: setCel: 0 setCycle: End)
				(fisherMan loop: 2 setCel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(9
				(gEgo view: 170 loop: 0 cycleSpeed: 0 setCycle: End self)
			)
			(10
				(gEgo
					get: 3 ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
					loop: 1
					setCel: 16
					cycleSpeed: 0
					setCycle: Beg self
				)
				(fisherMan loop: 4 cel: 0 cycleSpeed: 1 setCycle: End)
				(fisherMansHead hide:)
			)
			(11
				(fisherMan loop: 3 cel: 0 cycleSpeed: 3)
				(gEgo
					view: 71
					loop: 1
					setAvoider: 0
					cel: 0
					setCycle: Walk
					observeControl: -32768
				)
				(tunisia flags: (| (tunisia flags:) $0008))
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveDirectionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc310_1 gEgo)
				(= seconds 3)
			)
			(1
				(proc310_2)
				(= cycles 1)
				(Print 70 13 #at 25 10) ; "You ask the fisherman the whereabouts of your disguise, and..."
				(Print 70 14 #at 25 10) ; "Continuing in his silence, he turns and points toward the old abandoned dwellings."
			)
			(2
				(fisherMan
					view: 68
					loop: 4
					cycleSpeed: 1
					setCel: 16
					setCycle: Beg self
				)
			)
			(3
				(fisherMan setCycle: End self)
			)
			(4
				(= seconds 3)
			)
			(5
				(fisherMan
					view: 68
					loop: 3
					setCel: (fisherMan lastCel:)
					setCycle: Beg self
				)
				(self dispose:)
			)
		)
	)
)

(instance wontTalkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc310_1 gEgo)
				(= seconds 3)
			)
			(1
				(proc310_2)
				(Print 70 15 #at 25 10) ; "Speaking in good Arabic, you try striking up a conversation with the fishermen, but he ignores you."
				(self dispose:)
			)
		)
	)
)

(instance wave of Extra
	(properties
		y 126
		x 270
		view 70
		loop 3
		priority 8
		cycleSpeed 3
		cycleType 1
		minPause 5
		maxPause 5
		minCycles 2
		maxCycles 3
	)

	(method (init)
		(super init:)
		(self isExtra: 1)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/wave]>')
				(cond
					((TurnIfSaid self event 'look[<at]'))
					((Said 'look[<at]')
						(Print 70 16) ; "You see the waves coming to the shore."
					)
				)
			)
		)
	)
)

(instance rockFeatureRight of Feature
	(properties
		y 65
		x 290
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (Said 'look>') (Said '[<around][/room,beach]'))
				(Print 70 17) ; "You see large rocks on the shore and abandoned dwellings in the distance."
			)
		)
	)
)

(instance rockFeatureLeft of Feature
	(properties
		y 65
		x 95
	)

	(method (handleEvent event)
		(rockFeatureRight handleEvent: event)
	)
)

