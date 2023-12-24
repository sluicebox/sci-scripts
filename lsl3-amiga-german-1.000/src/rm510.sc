;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm510 0
)

(local
	drownCount
)

(instance rm510 of Rm
	(properties
		picture 510
		horizon 65
		north 520
		south 500
	)

	(method (init)
		(SetFlag 37) ; beenIn510
		(Load rsVIEW 511)
		(Load rsVIEW 812)
		(Load rsSOUND 6)
		(super init:)
		(self setScript: RoomScript)
		(aRock1 init:)
		(aRock2 init:)
		(aRock3 init:)
		(aRock4 init:)
		(aRock5 init:)
		(if (== gPrevRoomNum 520)
			(gEgo posn: 275 79 loop: 2)
		else
			(gEgo posn: 284 188)
		)
		(NormalEgo)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (& (gEgo onControl: 1) $0200) (== gEgoState 0))
				(self changeState: 2)
			)
			((and (== gEgoState 12) (< 8 (++ drownCount)))
				(= drownCount 0)
				(gEgo setLoop: (+ (Random 0 1) (* 2 (< (gEgo y:) 87))))
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'get,get/drink,drink,water')
					(Said 'drink,drink')
					(Said 'drink,drink/water')
				)
				(cond
					((TestFlag 6)
						(Print 510 0) ; "Your thirst is sufficiently quenched now, Patti."
					)
					((not (& (gEgo onControl:) $0200))
						(NotClose) ; "You're not close enough."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(self changeState: 6)
					)
				)
			)
			((Said 'make/lasso,hemp')
				(Print 510 1) ; "Bamboo will not make a rope."
			)
			((or (Said 'make/boat') (Said 'climb,get,get,use/bamboo'))
				(Print 510 2) ; "The bamboo plants will do you no good."
			)
			((or (Said 'go<swim') (Said 'swim'))
				(Print 510 3) ; "Just walk into the water, Patti."
			)
			((Said 'look,look>')
				(cond
					((Said '/palm')
						(Print 510 4) ; "These trees bring back fond memories of your youth spent back on the plains of Mora, Minnesota."
					)
					((Said '/boulder,boob')
						(Print 510 5) ; "This island is just filled with unusual rock formations, isn't it?"
					)
					((Said '/bamboo')
						(Print 510 6) ; "To the south lies the final remnants of the bamboo forest. You're thankful you have no need to reenter that place!"
					)
					((Said '/cascade,creek')
						(Print 510 7) ; "The river here sweeps down from the mountains, swiftly disappearing into the jungle ahead. Vicious rapids roil its surface."
						(Print 510 8 #at -1 144) ; "(At least the water is clean!)"
					)
					((Said '[/area]')
						(Print 510 9) ; "You find yourself clear of the bamboo maze at last! You are standing beside a swift, cold, mountain stream, filled with beautiful clear water."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(2
				(= gEgoState 12)
				(HandsOff)
				(rm510 horizon: 1)
				(gEgo
					view: 812
					setLoop: 0
					setStep: 1 3
					setCycle: Fwd
					illegalBits: 0
					posn: (- (gEgo x:) 20) (gEgo y:)
					setMotion: MoveTo 160 104 self
				)
				(gMusic number: 6 loop: -1 play:)
			)
			(3
				(gEgo setMotion: MoveTo 179 87 self)
			)
			(4
				(gEgo setMotion: MoveTo 200 54 self)
			)
			(5
				(gCurRoom newRoom: 520)
			)
			(6
				(HandsOff)
				(= gEgoState 3)
				(gEgo
					view: 511
					cycleSpeed: 2
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(7
				(gEgo setLoop: 1 setCycle: Fwd)
				(= cycles (* 2 (gEgo cycleSpeed:) 4 (- (NumCels gEgo) 1)))
			)
			(8
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(9
				(= seconds 2)
			)
			(10
				(gGame changeScore: 42)
				(SetFlag 6) ; drankRiverWater
				(NormalEgo 1)
				(= gEgoState 0)
				(Print 510 10) ; "You find the stream's water remarkably refreshing, without a trace of caffeine."
			)
		)
	)
)

(instance aRock1 of Prop
	(properties
		x 49
		y 177
		view 520
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock2 of Prop
	(properties
		x 169
		y 170
		view 520
		loop 1
		cel 1
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock3 of Prop
	(properties
		x 157
		y 189
		view 520
		loop 1
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock4 of Prop
	(properties
		x 52
		y 143
		view 520
		loop 2
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock5 of Prop
	(properties
		x 111
		y 104
		view 520
		loop 2
		cel 1
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

