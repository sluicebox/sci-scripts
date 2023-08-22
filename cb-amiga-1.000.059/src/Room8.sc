;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use Wander)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room8 0
)

(synonyms
	(bayou water)
)

(local
	local0
	local1
	local2
	local3
)

(instance Room8 of Rm
	(properties
		picture 8
	)

	(method (init)
		(= horizon 120)
		(= south 30)
		(= north 7)
		(super init:)
		(gAddToPics add: limb gator1 eachElementDo: #init doit:)
		(self setRegions: 205 setFeatures: gator1) ; swampReg
		(LoadMany rsVIEW 3 35 650)
		(Load rsSOUND 10 82)
		(if gDetailLevel
			(ripple1 ignoreActors: 1 cycleSpeed: 1 setCycle: Fwd init:)
			(ripple2 ignoreActors: 1 cycleSpeed: 1 setCycle: Fwd init:)
			(flyCage left: 160 right: 321 bottom: 191 top: 100 init:)
			(Fly
				setLoop: 6
				cel: 0
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(Fly2
				setLoop: 6
				cel: 1
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(Fly3
				setLoop: 6
				cel: 2
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(Fly4
				setLoop: 6
				cel: 3
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(Fly5
				setLoop: 6
				cel: 4
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
		)
		(= local1 0)
		(if (and (== gAct 3) (< gJeevesChoresState 4))
			(self setRegions: 203) ; clarwand
		)
		(switch gPrevRoomNum
			(18
				(gEgo posn: 1 130)
			)
			(24
				(gEgo posn: 1 170)
			)
			(30
				(gEgo posn: (gEgo x:) 188)
			)
			(else
				(gEgo posn: 5 125)
			)
		)
		(gEgo view: 0 init:)
		(Gator cycleSpeed: 1 init: stopUpd: setScript: gatorScript)
		(HandsOn)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 8 0) ; "Misty bayou waters surround this old plantation, cutting it off from the rest of the world. Better watch your step around here!"
		)
		(cond
			((< (gEgo y:) 141)
				(= local3 1)
			)
			((> (gEgo y:) 176)
				(= local3 2)
			)
			((and (< (gEgo y:) 167) (> (gEgo y:) 151))
				(= local3 3)
			)
			(else
				(= local3 0)
			)
		)
		(if (and (& (gEgo onControl: 1) $0002) (not local2) (not local0))
			(= local2 1)
			(self setScript: sink)
		)
		(if (== (gEgo edgeHit:) EDGE_LEFT)
			(if (< (gEgo y:) 165)
				(gCurRoom newRoom: 18)
			else
				(gCurRoom newRoom: 24)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 976)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(== (event type:) evSAID)
				(Said 'look>')
				(Said '[<around,at][/room]')
			)
			(Print 8 0) ; "Misty bayou waters surround this old plantation, cutting it off from the rest of the world. Better watch your step around here!"
		)
	)
)

(instance gatorScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (== (Gator cel:) 3))
			(myMusic number: 82 loop: 1 play:)
		)
		(if (> state 1)
			(cond
				(local3
					(if local1
						(= cycles 1)
					)
				)
				((not local1)
					(= cycles 1)
				)
			)
			(if
				(and
					(< (gEgo distanceTo: Gator) 21)
					(== local1 0)
					(not local0)
					(& (gEgo onControl: 1) $0002)
				)
				(= local0 1)
				(self changeState: 6)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(Gator cycleSpeed: 2 setCycle: End self)
			)
			(2
				(= local1 1)
			)
			(3
				(= local1 0)
				(Gator
					illegalBits: -32671
					posn:
						(switch local3
							(1 105)
							(2 259)
							(3 167)
						)
						(switch local3
							(1 133)
							(2 173)
							(3 159)
						)
					loop: 5
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(4
				(Gator loop: 6 setCycle: Fwd)
			)
			(5
				(= local1 (= state 1))
				(Gator loop: 5 cel: 3 setCycle: Beg self)
			)
			(6
				(HandsOff)
				(gConMusic stop:)
				(myMusic number: 10 loop: 1 play:)
				(if (== local3 1)
					(Gator setPri: 9)
				)
				(Gator
					view: 3
					loop: 0
					cel: 3
					illegalBits: 0
					posn: (- (gEgo x:) 3) (+ (gEgo y:) 4)
					setCycle: End self
					init:
				)
				(gEgo hide:)
			)
			(7
				(= seconds 3)
			)
			(8
				(myMusic stop:)
				(deathIcon view: 650 loop: 0)
				(= temp0 (deathIcon lastCel:))
				(= global128 deathIcon)
				(= global129 0)
				(= global130 temp0)
				(EgoDead 8 1) ; "You certainly made a succulent meal for that hungry 'gator!"
			)
		)
	)
)

(instance sink of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (> (gEgo cel:) 1))
			(= local0 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Room8 south: 0 north: 0)
				(HandsOff)
				(gConMusic stop:)
				(myMusic number: 82 loop: 1 play:)
				(gEgo
					view: 35
					cel: 0
					cycleSpeed: 3
					xStep: 3
					setMotion:
						MoveTo
						(switch (gEgo loop:)
							(0
								(+ (gEgo x:) 10)
							)
							(1
								(- (gEgo x:) 10)
							)
							(else
								(gEgo x:)
							)
						)
						(switch (gEgo loop:)
							(2
								(+ (gEgo y:) 3)
							)
							(3
								(- (gEgo y:) 3)
							)
							(else
								(gEgo y:)
							)
						)
					setCycle: End self
				)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(if (== (Gator loop:) 0)
					(myMusic stop:)
					(client setScript: 0)
				else
					(deathIcon view: 13 loop: 5 cel: 0)
					(= global128 deathIcon)
					(= global129 5)
					(= global130 0)
					(= global132 1)
					(EgoDead 8 2) ; "You've got that sinking feeling."
				)
			)
		)
	)
)

(instance Gator of Act
	(properties
		y 148
		x 275
		view 108
		loop 2
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/alligator'))
				(event claimed: 1)
				(Print 8 3) ; "Vicious 'gators inhabit the swamp surrounding the island."
			)
			((Said '/alligator>')
				(cond
					((Said 'get,capture/alligator')
						(Print 8 4) ; "You MUST be kidding!"
					)
					((Said 'pat/alligator')
						(Print 8 5) ; "You can't be SERIOUS!"
					)
					((Said 'talk/alligator')
						(Print 8 6) ; "'Gators don't talk!"
					)
					((Said 'kiss/alligator')
						(Print 8 7) ; "Be reasonable!!"
					)
					((Said 'kill/alligator')
						(Print 8 8) ; "You couldn't hurt a big 'gator."
					)
				)
			)
			(
				(or
					(Said 'feed,give/alligator')
					(Said 'feed,give/*/alligator')
					(Said 'feed,give/*<alligator')
				)
				(if global219
					(if global224
						(Print 8 9) ; "These alligators prefer fresh meat. Heh, heh."
					else
						(DontHave) ; "You don't have it."
					)
				else
					(Print 8 9) ; "These alligators prefer fresh meat. Heh, heh."
				)
			)
		)
	)
)

(instance ripple1 of Prop
	(properties
		y 110
		x 306
		view 108
	)
)

(instance ripple2 of Prop
	(properties
		y 140
		x 263
		view 108
		loop 1
	)
)

(instance myMusic of Sound
	(properties
		number 10
		loop 0
	)
)

(instance limb of RPicView
	(properties
		y 144
		x 148
		view 108
		loop 8
	)
)

(instance gator1 of RPicView
	(properties
		y 78
		x 265
		view 108
		loop 8
		cel 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 8 3) ; "Vicious 'gators inhabit the swamp surrounding the island."
		)
	)
)

(instance deathIcon of DCIcon
	(properties)

	(method (init)
		((= cycler (End new:)) init: self)
	)
)

(instance Fly of Act
	(properties
		y 123
		x 274
		view 130
	)
)

(instance Fly2 of Act
	(properties
		y 179
		x 297
		view 130
	)
)

(instance Fly3 of Act
	(properties
		y 139
		x 287
		view 130
	)
)

(instance Fly4 of Act
	(properties
		y 179
		x 257
		view 130
	)
)

(instance Fly5 of Act
	(properties
		y 139
		x 197
		view 130
	)
)

(instance flyCage of Cage
	(properties)
)

