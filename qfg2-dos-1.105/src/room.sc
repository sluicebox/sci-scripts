;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 429)
(include sci.sh)
(use Main)
(use n001)
(use Stage)
(use LoadMany)
(use Motion)
(use Actor)

(public
	room 0
)

(instance room of Stage
	(properties
		picture 700
		style 9
		south 703
		west 430
		bottomFromX 158
		bottomFromY 179
		bottomExit 4
		bottomToX 158
		bottomToY 147
		leftFromX 73
		leftFromY 147
		leftExit 1
		leftToX 140
		leftToY 147
	)

	(method (init)
		(= global61 2)
		(LoadMany rsVIEW 700 701)
		(gEgo init:)
		(NormalEgo)
		(super init:)
		(door init:)
		(if (or (== gPrevRoomNum 430) (IsFlag 142))
			(door cel: 2)
		)
		(= saveIllegal -384)
		(if (IsFlag 142)
			(&= saveIllegal $f7ff)
		)
		(InitAddToPics barricade)
	)

	(method (cue)
		(if (== inOut 1)
			(cond
				((== gPrevRoomNum 430)
					(door setCycle: Beg)
				)
				((IsFlag 142)
					(&= saveIllegal $f7ff)
					(HighPrint 429 0) ; "You see an open doorway."
					(TimePrint
						5
						{Please, enter quickly before the guards come!}
						80
						{Woman}
						103
					)
				)
			)
		)
		(super cue:)
	)

	(method (dispose)
		(= global61 0)
		(super dispose:)
	)

	(method (doit)
		(if (== inOut 3)
			(cond
				((& (gEgo onControl:) $0800)
					(= edgeHit 4)
				)
				((>= (gEgo y:) 179)
					(= edgeHit 3)
				)
			)
		)
		(super doit:)
	)
)

(instance barricade of PicView
	(properties
		x 160
		y 79
		noun '/sign,barricade'
		description {barricade}
		lookStr {This street has been barricaded off.  The sign reads 'Road closed by order of Khaveen'.}
		view 700
		loop 6
		cel 3
		palette 3
	)

	(method (handleEvent event)
		(if (Said 'read/sign')
			(self doVerb: 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance door of Prop
	(properties
		x 100
		y 160
		noun '/door'
		description {the door}
		view 701
		loop 6
		priority 9
		signal 16400
		palette 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (== (door cel:) 2)
					(HighPrint 429 1) ; "The door is already open."
				else
					(HighPrint 429 2) ; "The door is securely barred from the inside."
				)
			)
			(1
				(if (== (door cel:) 2)
					(HighPrint 429 3) ; "You see an open door."
				else
					(HighPrint 429 4) ; "There is an uninteresting-looking door here."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

