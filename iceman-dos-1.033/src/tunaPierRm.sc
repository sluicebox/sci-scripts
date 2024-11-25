;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	tunaPierRm 0
)

(instance tunaPierRm of Rm
	(properties
		picture 61
		north 72
		east 51
		south 46
		west 46
	)

	(method (init)
		(super init:)
		(self setRegions: 305) ; scubaRg
		(gEgo init:)
		(gAddToPics add: shadow fLeg bLeg doit:)
		(switch gPrevRoomNum
			(46 ; netToPierRm
				(gEgo
					illegalBits: $8000
					observeControl: 4096
					loop: 0
					posn: 10 145
					setMotion: MoveTo 325 145
				)
			)
			(else
				(gEgo
					illegalBits: $8000
					observeControl: 4096
					loop: 0
					posn: 315 100
					setMotion: MoveTo -5 100
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'bind,hide,adjust,drop,park/vehicle,diver')
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(gEgo setScript: hideVehicle)
				else
					(Print 47 0) ; "You don't have it!"
				)
			)
			((Said 'get/vehicle,diver')
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(Print 47 1) ; "You have it!"
				else
					(Print 47 2) ; "You don't need it."
				)
			)
			((Said 'look')
				(Print 47 3) ; "Rocks, plants and an old wooden pier that casts a shadow down into the rocks."
			)
		)
	)
)

(instance shadow of PV
	(properties
		y 158
		x 108
		view 61
		priority 0
		signal 16384
	)
)

(instance fLeg of PV
	(properties
		y 133
		x 87
		view 61
		loop 1
		priority 8
		signal 16384
	)
)

(instance bLeg of PV
	(properties
		y 94
		x 211
		view 61
		loop 1
		cel 1
		priority 3
		signal 16384
	)
)

(instance hideVehicle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 148 (gEgo y:) self)
			)
			(1
				(gEgo setMotion: MoveTo 148 98 self)
			)
			(2
				(gEgo illegalBits: $9000 setMotion: MoveTo 10 98 self)
			)
			(3
				(gEgo
					view: 154
					put: 6 gCurRoomNum ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					setMotion: MoveTo 148 98 self
				)
				(gGame changeScore: 3)
			)
			(4
				(HandsOn)
				(gEgo setMotion: MoveTo 148 133 self)
			)
			(5
				(gEgo setMotion: MoveTo -5 133 self)
			)
		)
	)
)

