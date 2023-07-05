;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm075 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm075 of Rm
	(properties
		picture 75
	)

	(method (init &tmp [temp0 50])
		(User canInput: 1 canControl: 1)
		(self setRegions: 600) ; ortega
		(Load rsVIEW (LangSwitch 94 320))
		(Load rsVIEW 99)
		(Load rsVIEW 100)
		(Load rsSOUND 33)
		(Load rsSOUND 45)
		(Load rsSOUND 71)
		(Load rsSOUND 50)
		(super init:)
		(gLongSong number: 50 loop: -1 priority: 0 play:)
		(gCurRoom setScript: UpLadder)
	)

	(method (newRoom newRoomNumber)
		(if (not script)
			(if global256
				(++ global593)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit &tmp temp0 [temp1 50])
		(super doit:)
		(if local0
			(self newRoom: 74)
		)
		(if
			(and
				(or (== (gEgo onControl:) 8) (== (gEgo onControl:) 24))
				(not (gCurRoom script:))
				(== (gEgo x:) local4)
				(== (gEgo y:) local5)
				(not local1)
			)
			(= local1 1)
			(gEgo setMotion: MoveTo (+ (gEgo x:) 20) 229)
		)
		(= local4 (gEgo x:))
		(= local5 (gEgo y:))
		(if (== (gCurRoom script:) 0)
			(= temp0 (gEgo onControl:))
			(self
				setScript:
					(cond
						((== temp0 4) walkGreen)
						((== temp0 8) walkCyan)
						((== temp0 16) fallRed)
						((or (== temp0 2) (== temp0 66)) fallBlue)
						((or (== temp0 40) (== temp0 56)) TopLadder)
						(else 0)
					)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look,look>')
				(cond
					((Said '[/area,around]')
						(if global256
							(PrintSplit 75 0) ; "While trying to catch your breath you take in the panoramic view. Below, you can see your ship off in the distance, and volcanoes stretching out over the horizon. There is a large circular opening here at the top of this building. This is where the beam originated, but you blew it up. Nice going Wilco."
						else
							(PrintSplit 75 1) ; "While trying to catch your breath you take in the panoramic view. Below, you can see your ship off in the distance, and volcanoes stretching out over the horizon. There is a large circular opening here at the top of the generator. This must be where the beam originates. Watch your step up here."
						)
					)
					((Said '/down,cavity,edge')
						(if (== (gEgo onControl:) 64)
							(if global256
								(Print 75 2) ; "Cautiously, you peer down into the generator.  It's too dark to make out anything, but the drone of the generator has stopped. It appears to be out of commission."
							else
								(Print 75 3) ; "Cautiously, you peer down into the generator.  It's too dark to make out anything, but the drone of the generator tells you that something is definitely happening."
							)
						else
							(Print 75 4) ; "You can't quite see over the edge from here."
						)
					)
					((Said '/moon,pestulon')
						(Print 75 5) ; "Looks like your typical moon."
					)
					((Said '/ladder')
						(Print 75 6) ; "The ladder leads back down the curvature of the generator."
					)
					((Said '/machine,building,generator')
						(cond
							((not global256)
								(if global170
									(Print 75 7) ; "It's pointing to a small moon high in the Ortegian sky.  Pulsating circular energy fields are being emitted into space toward the moon."
								else
									(Print 75 8) ; "It's pointing into the Ortegian sky. Pulsating circular energy fields are being emitted into space."
								)
							)
							(global170
								(Print 75 9) ; "It's pointing to a small moon high in the Ortegian sky.  The beam is no longer being emitted."
							)
							(else
								(Print 75 10) ; "It's pointing into the Ortegian sky. The beam is no longer being emitted."
							)
						)
					)
					((Said '/beam')
						(if (not global256)
							(if global170
								(Print 75 11) ; "The pulsating energy field is being emitted into space toward Pestulon."
							else
								(Print 75 12) ; "The pulsating energy field is being emitted into space."
							)
						else
							(Print 75 13) ; "It's no longer beaming."
						)
					)
					((Said '/lava')
						(Print 75 14) ; "There's not too much lava around here. This is one of the few stable spots on the surface of Ortega."
					)
				)
			)
			((Said 'jump,jump,enter,go/generator,cavity')
				(Print 75 15) ; "Go right ahead!"
			)
			((Said '(climb[<up]),ladder')
				(Print 75 16) ; "You can't!"
			)
			((Said 'down,descend,(climb[<down])[/ladder]')
				(if (gEgo inRect: 157 98 183 106)
					(gCurRoom setScript: DownLadder)
				else
					(Print 75 17) ; "You're not close enough to the ladder."
				)
			)
			((Said 'throw,drop/detonator,bomb')
				(cond
					(global256
						(AlreadyTook) ; "You've accomplished that task."
					)
					((not (gEgo has: 10)) ; Thermal_Detonator
						(Print 75 18) ; "You don't have one."
					)
					(
						(or
							(== (gEgo onControl:) 64)
							(== (gEgo onControl:) 66)
						)
						(gCurRoom setScript: DropBomb)
					)
					(else
						(Print 75 19) ; "It wouldn't do any good to do that here. Besides, you'll probably just blow your own foot off."
					)
				)
			)
		)
	)
)

(instance UpLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global159 1)
				(gEgo
					illegalBits: 0
					posn: 313 219
					view: 99
					setStep: 3 2
					setLoop: 0
					setMotion: MoveTo 173 113 self
					init:
				)
			)
			(1
				(gEgo
					view: 0
					illegalBits: -32768
					posn: 169 105
					setStep: 3 2
					setLoop: -1
				)
				(= cycles 2)
			)
			(2
				(gEgo loop: 1)
				(HandsOn)
				(= global159 0)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance TopLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global159 1)
				(gEgo illegalBits: 0 setMotion: MoveTo 173 113 self)
			)
			(1
				(gEgo
					view: 0
					illegalBits: -32768
					posn: 169 105
					setStep: 3 2
					setLoop: -1
				)
				(= cycles 2)
			)
			(2
				(gEgo loop: 1)
				(= local2 0)
				(= local3 1)
				(HandsOn)
				(= global159 0)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance DownLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global159 1)
				(gEgo illegalBits: 0 setMotion: MoveTo 169 105 self)
			)
			(1
				(gEgo
					posn: 173 113
					view: 99
					setLoop: 0
					setMotion: MoveTo 313 219 self
				)
			)
			(2
				(= local0 1)
				(gCurRoom setScript: 0)
				(= global159 0)
				(HandsOn)
			)
		)
	)
)

(instance walkCyan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local2)
					(= local2 1)
					(= local3 0)
					(= local1 0)
					(gEgo view: 99 setAvoider: Avoid setLoop: 0)
				)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance walkGreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local3)
					(= local3 1)
					(= local2 0)
					(gEgo
						view: 0
						setAvoider: 0
						loop:
							(switch (gEgo heading:)
								(0 3)
								(45 0)
								(90 0)
								(135 0)
								(180 2)
								(225 1)
								(270 1)
								(315 1)
							)
					)
				)
				(RedrawCast)
				(gEgo setLoop: -1)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance fallRed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global159 1)
				(falling play:)
				(gEgo
					view: 99
					setLoop: 1
					setStep: 6 12
					setCycle: 0
					posn: (gEgo x:) (gEgo y:)
					illegalBits: 0
				)
				(if (> (gEgo x:) 180)
					(gEgo setStep: 12 12 setCel: 1 setMotion: MoveTo 340 189)
				else
					(gEgo
						setCel: 0
						setMotion: MoveTo (+ (gEgo x:) 20) 229
					)
				)
				(ohnoScript changeState: 0)
			)
			(1
				(EgoDead 0 0 0 1)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not (gEgo mover:)) (== (falling prevSignal:) -1))
			(self changeState: 1)
		)
	)
)

(instance fallBlue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(falling play:)
				(gEgo
					setLoop:
					setCel:
					setStep: 6 12
					setCycle: 0
					setPri: 2
					illegalBits: 0
				)
				(RedrawCast)
				(gEgo setMotion: MoveTo (gEgo x:) 229)
				(ohnoScript changeState: 0)
			)
			(1
				(EgoDead 0 0 0 1)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (falling prevSignal:) -1)
			(self changeState: 1)
		)
	)
)

(instance ohnoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(OhNo init: setCycle: End self)
			)
			(1
				(OhNo dispose:)
			)
		)
	)
)

(instance DropBomb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global159 1)
				(gEgo view: 100 setLoop: 0 setCel: 0)
				(bomb init:)
				(= cycles 10)
				(gEgo put: 10) ; Thermal_Detonator
			)
			(1
				(gEgo setCel: 1)
				(bomb setMotion: MoveTo (bomb x:) 150 self)
			)
			(2
				(gEgo setCel: 2)
				(bomb dispose:)
				(blowUp play:)
				(flash init: setCycle: End self)
			)
			(3
				(ShakeScreen 20 ssFULL_SHAKE)
				(blowUp play:)
				(flash setCycle: End self)
			)
			(4
				(ShakeScreen 20 ssFULL_SHAKE)
				(gLongSong stop:)
				(RedrawCast)
				(gLongSong number: 71 loop: -1 priority: 0 play:)
				(if global170
					(Print 75 20) ; "The explosion disables the force field generator. You may now travel safely to Pestulon."
				else
					(Print 75 21) ; "The explosion has shut off the beam that was shooting out from this thing. Someone's gonna be really sore at you for this."
				)
				(gEgo view: 0 setLoop: -1 setCel: -1 cel: 0 loop: 1)
				(gGame changeScore: 20)
				(= global256 1)
				(= global257 300)
				(HandsOn)
				(= global159 0)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance OhNo of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: (LangSwitch 94 320)
			setLoop: 0
			setCel: 0
			cycleSpeed: 1
			setPri: (gEgo priority:)
			posn: (gEgo x:) (- (gEgo y:) 50)
			ignoreActors: 1
		)
	)
)

(instance bomb of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 100
			setLoop: 0
			setCel: 3
			setPri: 2
			posn: (- (gEgo x:) 10) (- (gEgo y:) 21)
			setStep: 1 4
			ignoreControl: 1
			ignoreActors: 1
			illegalBits: 0
		)
	)
)

(instance flash of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 100
			setLoop: 1
			setCel: 0
			setPri: 3
			posn: 82 79
			ignoreActors: 1
		)
	)
)

(instance falling of Sound
	(properties
		number 45
		priority 1
	)
)

(instance blowUp of Sound
	(properties
		number 33
		priority 1
	)
)

