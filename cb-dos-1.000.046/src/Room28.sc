;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room28 0
)

(local
	local0
)

(instance Room28 of Rm
	(properties
		picture 28
	)

	(method (init)
		(super init:)
		(= horizon 124)
		(= east 29)
		(= west 27)
		(= north 22)
		(= south 1)
		(gAddToPics add: Sign Bird1 Bird2 eachElementDo: #init doit:)
		(self setRegions: 206 207 setFeatures: Sign House Statue Bird1 Bird2) ; houseOReg, fenceReg
		(Load rsVIEW 9)
		(Thunder number: 17 loop: 0)
		(if gDetailLevel
			(smoke1 cycleSpeed: 2 setCycle: Fwd init:)
			(smoke2 cycleSpeed: 2 setCycle: Fwd init:)
			(light1 init:)
			(light2 init: setScript: showers)
		)
		(switch gPrevRoomNum
			(1
				(gEgo loop: 3 posn: 157 188)
			)
			(22
				(gEgo posn: 160 127)
			)
			(29
				(if (< (gEgo y:) 129)
					(gEgo y: 129)
				)
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
			(Print 28 0) ; "You are standing at the south edge of the bayou island looking towards the great old plantation house. An old road runs alongside the plantation's front wrought iron fence."
		)
		(if (and (& (gEgo onControl: 0) $0004) (== local0 0))
			(= local0 1)
			(= north (= south 0))
			(self setScript: falling)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 28 0) ; "You are standing at the south edge of the bayou island looking towards the great old plantation house. An old road runs alongside the plantation's front wrought iron fence."
						)
						((Said '/path')
							(Print 28 1) ; "A stone path runs toward a interesting statue and then on to the mansion."
						)
						((Said '<below/dock')
							(Print 28 2) ; "All you see under the dock is swamp water."
						)
						((Said '/dock')
							(Print 28 3) ; "A weathered dock runs out into the alligator-infested bayou."
						)
						((Said '/door,(ignite[<gallery])')
							(Print 28 4) ; "Porch lights highlight the mansion's front door."
						)
						((Said '/smoke,chimney')
							(Print 28 5) ; "Smoke wafts up into the night air from the mansion's two chimneys."
						)
					)
				)
				(
					(or
						(Said 'bathe,dive,wade')
						(Said 'enter,go,hop,dive,(get<in)/water,brook')
					)
					(Print 28 6) ; "Go ahead. Just enter the water."
				)
			)
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
				(= cycles 7)
			)
			(2
				(light1 setCycle: End)
				(light2 setCycle: End self)
			)
			(3
				(Thunder loop: 1 play: self)
			)
			(4
				(if (< (Random 1 100) 15)
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

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 9 setLoop: 0 setCycle: End self)
			)
			(1
				(gEgo setLoop: 1 setCycle: Fwd)
				(= cycles 3)
			)
			(2
				(gEgo
					setLoop: 2
					setPri: 15
					setCycle: End self
					illegalBits: 0
				)
			)
			(3
				(gEgo
					setCel: 9
					setCycle: 0
					setStep: 10 10
					setMotion: MoveTo (gEgo x:) 200 self
				)
			)
			(4
				(Splash play:)
				(gEgo posn: (gEgo x:) 190 setLoop: 6 setCycle: End self)
			)
			(5
				(gEgo hide:)
				(= global128 myIcon)
				(= global129 0)
				(= global130 0)
				(= global132 1)
				(EgoDead 28 7) ; "The thick muck was too much for you."
			)
		)
	)
)

(instance light1 of Prop
	(properties
		y 42
		x 86
		view 128
		loop 2
		cel 1
	)
)

(instance light2 of Prop
	(properties
		y 51
		x 157
		view 128
		loop 3
		cel 1
	)
)

(instance smoke1 of Prop
	(properties
		y 25
		x 142
		view 128
		loop 8
		cel 2
	)
)

(instance smoke2 of Prop
	(properties
		y 25
		x 179
		view 128
		loop 8
	)
)

(instance Sign of RPicView
	(properties
		y 135
		x 145
		view 128
		loop 1
		cel 1
		priority 12
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((Said 'get/sign')
				(Print 28 8) ; "The old sign is firmly attached to the gate."
			)
			((or (MousedOn self event 3) (Said 'look,read/sign'))
				(if (> (gEgo y:) 160)
					(Print 28 9) ; "The rusted sign on the front gate reads "Misty Acres." That must be the name of the old plantation!"
				else
					(Print 28 10) ; "You can't read a sign from behind it."
				)
				(event claimed: 1)
			)
		)
	)
)

(instance Bird1 of RPicView
	(properties
		y 103
		x 111
		view 128
		loop 1
		priority 12
	)

	(method (handleEvent event)
		(cond
			((Said 'get,detach/bird')
				(Print 28 11) ; "The eagles are for decoration only."
			)
			((or (MousedOn self event 3) (Said 'look/bird'))
				(event claimed: 1)
				(Print 28 12) ; "A pair of iron eagles decorate the top of the gate posts."
			)
		)
	)
)

(instance Bird2 of RPicView
	(properties
		y 103
		x 207
		view 128
		loop 1
		priority 12
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 28 12) ; "A pair of iron eagles decorate the top of the gate posts."
		)
	)
)

(instance House of RFeature
	(properties
		nsTop 34
		nsLeft 96
		nsBottom 82
		nsRight 226
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {house})
		)
	)
)

(instance Statue of RFeature
	(properties
		nsTop 80
		nsLeft 157
		nsBottom 96
		nsRight 163
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/monument'))
			(event claimed: 1)
			(Print 28 13) ; "You can barely see the statue from here."
		)
	)
)

(instance myIcon of DCIcon
	(properties
		view 652
	)

	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
)

(instance Thunder of Sound
	(properties)
)

(instance Splash of Sound
	(properties
		number 82
	)
)

