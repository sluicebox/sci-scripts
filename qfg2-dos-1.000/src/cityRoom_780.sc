;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
(include sci.sh)
(use Main)
(use n001)
(use Stage)
(use Actor)

(public
	cityRoom 0
)

(instance cityRoom of Stage
	(properties
		picture 780
		style 8
		horizon 120
		north 290
		east 665
		south 665
		west 665
		rightFromY 180
		rightToY 180
		leftFromY 180
		leftToY 180
	)

	(method (init)
		(SetFlag 82)
		(ClearFlag 16)
		(gEgo init:)
		(if (or (== gPrevRoomNum 290) (IsFlag 28))
			(= gPrevRoomNum 290)
			(= inOut 3)
		)
		(self setRegions: 660) ; desertReg
		(super init: &rest)
		(if gNight
			(shapeir loop: 0 cel: 0)
			(saurusLot cel: 1)
			(InitAddToPics stellar1 stellar2)
		)
		(InitAddToPics shapeir saurusLot)
		(if (== gPrevRoomNum 290)
			(gEgo posn: 150 97 setScript: (ScriptID 660 8)) ; twoDunesIn
		)
	)

	(method (doit)
		(if (and (not (gEgo script:)) (& (gEgo onControl:) $0004))
			(gEgo setScript: (ScriptID 660 9)) ; twoDunesOut
		else
			(super doit:)
		)
	)
)

(instance shapeir of PicView
	(properties
		x 145
		y 90
		noun '/city,city,wall,shapeir'
		description {the city of Shapeir}
		view 780
		loop 2
		priority 0
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if gNight
				(HighPrint 780 0) ; "The city of Shapeir shines in the moonlight."
			else
				(HighPrint 780 1) ; "The sun reflects off Shapeir's many towers."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance saurusLot of PicView
	(properties
		x 123
		y 94
		noun '/grass,corral,pen'
		description {the saurus lot}
		lookStr {The saurus lot looks empty from this distance.}
		view 780
		loop 3
		priority 1
		signal 16
	)
)

(instance stellar1 of PicView
	(properties
		x 67
		y 23
		noun '/star,constellation[<saurii]'
		description {the Saurus constellation}
		lookStr {This constellation is said to resemble a Saurus.}
		view 660
		loop 2
		cel 3
		priority 0
		signal 24592
	)
)

(instance stellar2 of PicView
	(properties
		x 273
		y 45
		noun '/star,constellation[<hand]'
		description {the Dark Hand constellation}
		lookStr {The stars here appear to form a Dark Hand.}
		view 660
		loop 2
		cel 2
		priority 0
		signal 24592
	)
)

