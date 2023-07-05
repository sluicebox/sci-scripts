;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm31 0
)

(local
	numClouds
	seenMessage
)

(instance rm31 of Rm
	(properties
		picture 31
		horizon 1
	)

	(method (init &tmp i cloud)
		(Load rsVIEW 300)
		(Load rsVIEW 130)
		(Load rsVIEW 301)
		(Load rsVIEW 620)
		(super init:)
		(gAddToPics add: aView1 aView2 aView3 aView4 aView5 aView6 doit:)
		(aHorizonBow setCycle: Fwd cycleSpeed: 2 isExtra: 1 init:)
		(aHorizonStern setCycle: Fwd cycleSpeed: 2 isExtra: 1 init:)
		(aBar setCycle: Fwd cycleSpeed: 30 isExtra: 1 init:)
		(aFlag setCycle: Fwd cycleSpeed: 3 isExtra: 1 init:)
		(aWakeRear setCycle: Fwd cycleSpeed: 3 isExtra: 1 init:)
		(aWakeFront setCycle: Fwd cycleSpeed: 4 isExtra: 1 init:)
		(cond
			((> gMachineSpeed 60)
				(= numClouds 3)
			)
			((> gMachineSpeed 40)
				(= numClouds 2)
			)
			((> gMachineSpeed 20)
				(= numClouds 1)
			)
		)
		(for ((= i 0)) (< i numClouds) ((++ i))
			((Act new:)
				view: 620
				ignoreHorizon:
				ignoreActors:
				illegalBits: 0
				setScript: (cloudScript new:)
			)
		)
		(if (== (= gCurrentEgoView (gEgo view:)) 132)
			(gEgo view: 129)
		else
			(gEgo view: 130)
		)
		(gEgo
			setLoop: 0
			setPri: 14
			setCycle: Walk
			setStep: 1 1
			illegalBits: -32768
		)
		(cond
			((== gPrevRoomNum 38)
				(gEgo posn: 179 74)
			)
			((== gPrevRoomNum 37)
				(gEgo posn: 97 85)
			)
			((== gPrevRoomNum 36)
				(gEgo posn: 112 62)
			)
			((== gPrevRoomNum 35)
				(gEgo posn: 215 50)
			)
			((== gPrevRoomNum 34)
				(gEgo posn: 299 85)
			)
			(else
				(gEgo posn: 280 113)
			)
		)
		(gEgo init:)
		(User canControl: 1 canInput: 1)
		(= gCurrentStatus 0)
		(self setRegions: 300 setScript: rm31Script) ; rm300
	)
)

(instance rm31Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (== gCurrentEgoView 132) (& (gEgo onControl:) $00e0))
				(if (== seenMessage 0)
					(Print 31 0) ; "Swimwear is not allowed there. Try the pool instead."
					(= seenMessage 1)
				)
			)
			((& (gEgo onControl:) $0100)
				(gCurRoom newRoom: 38)
			)
			((& (gEgo onControl:) $0080)
				(gCurRoom newRoom: 37)
			)
			((& (gEgo onControl:) $0040)
				(gCurRoom newRoom: 36)
			)
			((& (gEgo onControl:) $0020)
				(gCurRoom newRoom: 35)
			)
			((& (gEgo onControl:) $0010)
				(gCurRoom newRoom: 34)
			)
			((& (gEgo onControl:) $0002)
				(gCurRoom newRoom: 32)
			)
			(else
				(= seenMessage 0)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'climb/stair')
			(Print 31 1) ; "I suggest using the cursor keys for that!"
		)
		(if
			(or
				(Said 'open/door')
				(Said 'board,(board<to),explore/cabin,airport')
			)
			(Print 31 2) ; "Your cabin is all the way to the rear of the ship, on the lowest level... remember?"
		)
		(if (Said 'look>')
			(if (Said '/corridor')
				(Print 31 3) ; "The hallways aren't that large; it's you that's small!"
			)
			(if (Said '/stair')
				(Print 31 4) ; "They are perfect for moving between decks."
			)
			(if (Said '/flag')
				(Print 31 5) ; "Oh-ho, say, can you sea?"
			)
			(if (Said '[/craft,boat,cloud,airport]')
				(Print 31 6) ; "Scud scuds past the ship, messing up an otherwise clear blue sky."
			)
		)
	)
)

(instance cloudScript of Script
	(properties)

	(method (changeState newState &tmp tmpY tmpCel)
		(switch (= state newState)
			(0
				(client posn: (Random 0 270) (Random 10 65) init:)
				(self changeState: 2)
			)
			(1
				(= tmpY (Random 1 80))
				(= tmpCel (Random 0 10))
				(client setCel: tmpCel posn: (- 1 (CelWide 620 0 tmpCel)) tmpY)
				(self changeState: 2)
			)
			(2
				(client
					setStep: (Random 1 3) -1
					setMotion: MoveTo 321 (client y:) self
				)
				(= state 0)
			)
		)
	)
)

(instance aView1 of PV
	(properties
		y 75
		x 159
		view 301
		priority 14
		signal 16384
	)
)

(instance aView2 of PV
	(properties
		y 75
		x 199
		view 301
		priority 14
		signal 16384
	)
)

(instance aView3 of PV
	(properties
		y 75
		x 217
		view 301
		priority 14
		signal 16384
	)
)

(instance aView4 of PV
	(properties
		y 75
		x 234
		view 301
		priority 14
		signal 16384
	)
)

(instance aView5 of PV
	(properties
		y 75
		x 251
		view 301
		priority 14
		signal 16384
	)
)

(instance aView6 of PV
	(properties
		y 75
		x 268
		view 301
		priority 14
		signal 16384
	)
)

(instance aHorizonBow of Prop
	(properties
		y 102
		x 8
		view 300
		loop 5
		priority 3
	)
)

(instance aHorizonStern of Prop
	(properties
		y 102
		x 317
		view 300
		loop 6
		priority 3
	)
)

(instance aBar of Prop
	(properties
		y 44
		x 216
		view 300
		priority 15
	)
)

(instance aFlag of Prop
	(properties
		y 22
		x 99
		view 300
		loop 1
		priority 1
	)
)

(instance aWakeRear of Prop
	(properties
		y 118
		x 267
		view 300
		loop 2
		priority 10
	)
)

(instance aWakeFront of Prop
	(properties
		y 119
		x 108
		view 300
		loop 3
		priority 10
	)
)

