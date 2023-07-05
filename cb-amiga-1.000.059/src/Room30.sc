;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
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
	Room30 0
)

(local
	local0
)

(instance Room30 of Rm
	(properties
		picture 30
	)

	(method (init)
		(= horizon 84)
		(= west 29)
		(= north 8)
		(super init:)
		(Load rsSOUND 82)
		(self setRegions: 205 207 setFeatures: House) ; swampReg, fenceReg
		(Load rsVIEW 35)
		(Thunder number: 17 loop: 0)
		(if gDetailLevel
			(reflect1 cycleSpeed: 1 setCycle: Fwd init:)
			(reflect2 ignoreActors: 1 cycleSpeed: 1 setCycle: Fwd init:)
			(light1 init: setScript: showers)
			(light2 init:)
			(light3 init:)
			(light4 init:)
			(flyCage left: 160 right: 321 bottom: 191 top: 100 init:)
			(Fly
				setLoop: 6
				cel: 0
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly2
				setLoop: 6
				cel: 1
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly3
				setLoop: 6
				cel: 2
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly4
				setLoop: 6
				cel: 3
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly5
				setLoop: 6
				cel: 4
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
		else
			(reflect1 addToPic:)
			(reflect2 addToPic:)
		)
		(if (and (== gAct 3) (< gJeevesChoresState 5))
			(self setRegions: 203) ; clarwand
		)
		(switch gPrevRoomNum
			(24
				(gEgo posn: 26 112)
			)
			(8
				(gEgo posn: 122 112 loop: 2)
			)
		)
		(gEgo view: 0 init:)
		(HandsOn)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 30 0) ; "You are at the southeast edge of the bayou island. The old road and fence have been taken over by the flooding swamp water."
		)
		(if (& (gEgo onControl: 0) $0008)
			(gCurRoom newRoom: 24)
		)
		(if (and (& (gEgo onControl: 1) $0002) (== local0 0))
			(= local0 1)
			(self setScript: sink)
		)
		(if (and (& (gEgo onControl: 0) $0004) (== local0 0))
			(gCurRoom newRoom: 8)
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
				(Said '[<around,at][/room][/!*]')
			)
			(Print 30 0) ; "You are at the southeast edge of the bayou island. The old road and fence have been taken over by the flooding swamp water."
		)
	)
)

(instance showers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (= state 3))
			)
			(1
				(light1 setCycle: Fwd)
				(light2 setCycle: Fwd)
				(light3 setCycle: Fwd)
				(light4 setCycle: Fwd)
				(= cycles 7)
			)
			(2
				(light1 setCycle: End)
				(light2 setCycle: End)
				(light3 setCycle: End)
				(light4 setCycle: End self)
			)
			(3
				(Thunder loop: 1 play: self)
			)
			(4
				(if (< (Random 1 100) 25)
					(= state 0)
				)
				(= cycles 7)
			)
			(5
				(= state 3)
				(= seconds 5)
			)
		)
	)
)

(instance sink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Room30 south: 0 north: 0)
				(HandsOff)
				(myMusic number: 82 loop: 1 play:)
				(gEgo
					view: 35
					cel: 0
					xStep: 1
					cycleSpeed: 3
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
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(= global128 myIcon)
				(= global129 5)
				(= global130 0)
				(= global132 1)
				(EgoDead 30 1) ; "You've got that sinking feeling."
			)
		)
	)
)

(instance light1 of Prop
	(properties
		y 55
		x 296
		view 130
		loop 2
		cel 1
	)
)

(instance light2 of Prop
	(properties
		y 102
		x 294
		view 130
		loop 3
		cel 1
	)
)

(instance light3 of Prop
	(properties
		y 45
		x 21
		view 130
		loop 4
		cel 1
	)
)

(instance light4 of Prop
	(properties
		y 77
		x 53
		view 130
		loop 5
		cel 1
	)
)

(instance reflect1 of Prop
	(properties
		y 94
		x 224
		view 130
	)
)

(instance reflect2 of Prop
	(properties
		y 186
		x 226
		view 130
		loop 1
	)
)

(instance Thunder of Sound
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance myIcon of DCIcon
	(properties
		view 13
		loop 5
	)

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
		x 217
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

(instance House of RFeature
	(properties
		nsTop 34
		nsBottom 79
		nsRight 34
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/gazebo'))
			(event claimed: 1)
			(Print 30 2) ; "You notice a gazebo in the distance to the north."
		)
	)
)

