;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use Interface)
(use Follow)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm94 0
)

(local
	local0
	local1
)

(instance rm94 of Rm
	(properties
		picture 94
		style 0
	)

	(method (init)
		(User canInput: 1 canControl: 1)
		(Load rsVIEW 68)
		(Load rsVIEW 102)
		(Load rsVIEW 195)
		(Load rsVIEW 196)
		(super init:)
		(ship init: stopUpd:)
		(ramp init: stopUpd:)
		(switch gPrevRoomNum
			(93
				(gAddToPics add: ship1 ship2 ship3 ship4 ship5)
				(gAddToPics doit:)
				(gEgo
					view: 68
					posn: 67 121
					init:
					setMotion: MoveTo 300 121 self
				)
			)
			(120
				(User canInput: 0 canControl: 0)
				(= global159 1)
				(Load rsSOUND 38)
				(Load rsSOUND 40)
				(gAddToPics add: ship1 ship2 ship3 ship4 ship5 robo)
				(gAddToPics doit:)
				(gEgo
					view: 68
					setLoop: -1
					setCel: -1
					setStep: 6 3
					setPri: 14
					posn: 52 176
					init:
				)
				(Scott init: setScript: ScottScript)
				(Mark init: setMotion: Follow Scott 10)
				(self setScript: RunAway)
			)
			(else
				(User canInput: 0 canControl: 0)
				(= global159 1)
				(Load rsSOUND 38)
				(Load rsSOUND 40)
				(gAddToPics add: ship1 ship2 ship3 ship4 ship5 robo)
				(gAddToPics doit:)
				(gEgo
					view: 68
					setLoop: -1
					setCel: -1
					setStep: 6 3
					setPri: 14
					posn: 52 176
					init:
				)
				(Scott init: setScript: ScottScript)
				(Mark init: setMotion: Follow Scott 10)
				(self setScript: RunAway)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '[/area]')
								(Print 94 0) ; "You stand on a platform overlooking the Scum Soft vehicle bay. In the center of the hangar sits your ship surrounded by rows of short-range skull fighters. Now how will you ever get out of here?"
							)
							((Said '/craft,aluminum')
								(Print 94 1) ; "Your ship doesn't appear to have been tampered with. You realize that it's only a matter of time before you are found as well. Better get on to the business at hand: finding those Two Guys."
							)
							((Said '/bow')
								(Print 94 2) ; "The short-range fighters are well armed and ready for action. Even if you do manage to escape, they'll no doubt send these babies after you."
							)
							((Said '/air')
								(Print 94 3) ; "The opened hangar doors reveal the Pestulonian sky above."
							)
						)
					)
					((Said 'climb[/down,up]')
						(Print 94 4) ; "Forget it!"
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(if (== (gEgo onControl:) 3)
			(gCurRoom newRoom: 93)
		)
		(super doit:)
	)
)

(instance RunAway of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 200 182 self)
			)
			(1
				(balloon init: stopUpd:)
				(gEgo setMotion: MoveTo 261 182 self)
			)
			(2
				(gEgo setMotion: MoveTo 269 174 self)
			)
			(3
				(gEgo dispose:)
			)
			(4
				(liftOff play:)
				(ramp dispose:)
				(Scott dispose:)
				(Mark dispose:)
				(ship setCel: 1)
				(= seconds 5)
			)
			(5
				(ship setMotion: MoveTo 228 115 self)
			)
			(6
				(ship setCel: 2 setMotion: MoveTo 228 45 self)
			)
			(7
				(ship setCel: 3 setMotion: MoveTo 228 -11 self)
			)
			(8
				(= local0 1)
				(balloon dispose:)
			)
			(9
				(warpOut play:)
				(ship
					setLoop: 5
					setCel: 0
					posn: 279 -14
					setStep: 4 6
					setMotion: MoveTo 243 15 self
				)
			)
			(10
				(ship setCycle: End setMotion: MoveTo 215 43 self)
			)
			(11
				(ship setMotion: MoveTo 215 -5 self)
			)
			(12
				(= local0 2)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== local0 1) (== (liftOff prevSignal:) -1))
			(= local0 0)
			(self changeState: 9)
		)
		(if (and (== local0 2) (== (warpOut prevSignal:) -1))
			(gCurRoom newRoom: 14)
		)
	)
)

(instance ScottScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(Scott setMotion: MoveTo 261 150 self)
			)
			(2
				(Scott setMotion: MoveTo 269 142 self)
			)
			(3
				(RunAway changeState: 4)
			)
		)
	)
)

(instance Scott of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 195
			loop: 0
			posn: 52 144
			setCycle: Walk
			setStep: 6 3
			setPri: 14
			illegalBits: 0
			ignoreActors: 1
		)
	)
)

(instance Mark of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 196
			loop: 0
			posn: 52 144
			setCycle: Walk
			setStep: 6 3
			setPri: 14
			illegalBits: 0
			ignoreActors: 1
		)
	)
)

(instance ship of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 102
			setLoop: 0
			setCel: 0
			posn: 228 165
			setStep: 6 6
			setPri: 15
			illegalBits: 0
			ignoreHorizon: 1
			ignoreActors: 1
		)
	)
)

(instance ramp of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 102
			setLoop: 1
			setCel: 0
			posn: 266 182
			setPri: 13
			setCycle: 0
			ignoreActors: 1
		)
	)
)

(instance balloon of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 102
			setLoop: 4
			setCel: 1
			posn: 79 162
			setPri: 15
			setCycle: 0
			ignoreActors: 1
		)
	)
)

(instance ship1 of PV
	(properties
		y 176
		x 146
		view 102
		loop 2
		signal 16384
	)
)

(instance ship2 of PV
	(properties
		y 157
		x 176
		view 102
		loop 2
		cel 1
		signal 16384
	)
)

(instance ship3 of PV
	(properties
		y 140
		x 204
		view 102
		loop 2
		cel 2
		signal 16384
	)
)

(instance ship4 of PV
	(properties
		y 139
		x 263
		view 102
		loop 3
		signal 16384
	)
)

(instance ship5 of PV
	(properties
		y 139
		x 312
		view 102
		loop 3
		signal 16384
	)
)

(instance robo of PV
	(properties
		y 179
		x 41
		view 102
		loop 4
		priority 15
		signal 16384
	)
)

(instance warpOut of Sound
	(properties
		number 38
		priority 1
	)
)

(instance liftOff of Sound
	(properties
		number 40
		priority 1
	)
)

