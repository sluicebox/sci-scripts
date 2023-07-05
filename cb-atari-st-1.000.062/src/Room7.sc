;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
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
	Room7 0
)

(local
	local0
)

(instance Room7 of Rm
	(properties
		picture 7
	)

	(method (init)
		(= south 8)
		(= west 6)
		(= horizon 86)
		(super init:)
		(LoadMany rsVIEW 5 13 35)
		(LoadMany rsSOUND 67 82 92)
		(self setRegions: 205) ; swampReg
		(self setFeatures: Bridge)
		(if gDetailLevel
			(wave1 setPri: 1 cycleSpeed: 2 ignoreActors: 1 setCycle: Fwd init:)
			(wave2 setPri: 1 cycleSpeed: 2 ignoreActors: 1 setCycle: Fwd init:)
			(flyCage init:)
			(Fly
				setLoop: 5
				cel: 0
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				cycleSpeed: 2
				setCycle: Fwd
				setMotion: Wander 5
				init:
			)
			(Fly2
				setLoop: 5
				cel: 1
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				cycleSpeed: 2
				setCycle: Fwd
				setMotion: Wander 5
				init:
			)
			(Fly3
				setLoop: 5
				cel: 2
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				cycleSpeed: 2
				setCycle: Fwd
				setMotion: Wander 5
				init:
			)
			(Fly4
				setLoop: 5
				cel: 3
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				cycleSpeed: 2
				setCycle: Fwd
				setMotion: Wander 5
				init:
			)
			(Fly5
				setLoop: 5
				cel: 4
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				cycleSpeed: 2
				setCycle: Fwd
				setMotion: Wander 5
				init:
			)
		)
		(if (and (== gAct 3) (< gJeevesChoresState 3))
			(self setRegions: 203) ; clarwand
		)
		(if (== gPrevRoomNum 6)
			(gEgo posn: 1 188)
		else
			(gEgo posn: 35 188)
		)
		(gEgo view: 0 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 7 0) ; "A broken, arched bridge crosses a large stream at the swamp's edge."
		)
		(if (and (& (gEgo onControl: 1) $0002) (== local0 0))
			(= local0 1)
			(self setScript: sink)
		)
		(if (and (& (gEgo onControl: 1) $0008) (== local0 0))
			(= local0 1)
			(myMusic number: 67 loop: 1 play:)
			(self setScript: falling)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 976)
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
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '<(below,below)/bridge')
							(Print 7 1) ; "There is nothing but water under the bridge."
						)
						((Said '<(across,on)/brook,water')
							(Print 7 2) ; "There is only more swamp on the other side of the large stream."
						)
						((Said '/brook,water')
							(Print 7 3) ; "A broken bridge crosses the large stream."
						)
						((Said '<down')
							(DoLook {ground})
						)
						((Said '[/bridge,room,around]')
							(Print 7 0) ; "A broken, arched bridge crosses a large stream at the swamp's edge."
						)
					)
				)
				((or (Said 'cross/bridge') (Said 'go<(above,across)/bridge'))
					(Print 7 4) ; "The bridge is broken. You can't cross it."
				)
				((Said 'climb[<(across,above)]/oak,log')
					(Print 7 5) ; "You can't quite reach it."
				)
				((Said 'hop[<(across,above)][/bridge,brook]')
					(Print 7 6) ; "You can't jump that far."
				)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 5
					setLoop: 0
					cel: 0
					setCycle: End
					yStep: 5
					illegalBits: 0
					setMotion: MoveTo 115 130 self
				)
			)
			(1
				(myMusic number: 82 loop: 1 play:)
				(gEgo loop: 2 posn: 116 149 cel: 0 setCycle: End self)
			)
			(2
				(gEgo view: 13 loop: 0 posn: 92 157 setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(gEgo view: 13 loop: 2 setCycle: End self)
			)
			(4
				(= seconds 3)
			)
			(5
				(= global128 myIcon)
				(= global129 5)
				(= global130 0)
				(= global132 1)
				(EgoDead 7 7) ; "You've got that sinking feeling."
			)
		)
	)
)

(instance sink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(myMusic number: 92 loop: 1 play:)
				(gEgo
					view: 35
					cel: 0
					cycleSpeed: 3
					setMotion: MoveTo (+ (gEgo x:) 30) (gEgo y:)
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
				(EgoDead 7 7) ; "You've got that sinking feeling."
			)
		)
	)
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

(instance myMusic of Sound
	(properties)
)

(instance wave1 of Prop
	(properties
		y 173
		x 235
		view 207
	)
)

(instance wave2 of Prop
	(properties
		y 166
		x 104
		view 207
		loop 1
	)
)

(instance Fly of Act
	(properties
		y 123
		x 274
		view 5
		cel 1
	)
)

(instance Fly2 of Act
	(properties
		y 179
		x 297
		view 5
		cel 1
	)
)

(instance Fly3 of Act
	(properties
		y 139
		x 207
		view 5
	)
)

(instance Fly4 of Act
	(properties
		y 179
		x 197
		view 5
	)
)

(instance Fly5 of Act
	(properties
		y 139
		x 217
		view 5
	)
)

(instance flyCage of Cage
	(properties
		top 120
		left 135
		bottom 202
		right 322
	)
)

(instance Bridge of RFeature
	(properties
		nsTop 106
		nsLeft 40
		nsBottom 180
		nsRight 155
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/bridge'))
			(event claimed: 1)
			(Print 7 0) ; "A broken, arched bridge crosses a large stream at the swamp's edge."
		)
	)
)

