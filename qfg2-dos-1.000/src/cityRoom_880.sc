;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 880)
(include sci.sh)
(use Main)
(use n001)
(use Stage)
(use Actor)
(use System)

(public
	cityRoom 0
)

(instance cityRoom of Stage
	(properties
		picture 780
		style 8
		horizon 120
		north 380
		east 665
		south 665
		west 665
		topExit 3
		bottomExit 1
		rightFromY 180
		rightExit 4
		rightToY 180
		leftFromY 180
		leftExit 2
		leftToY 180
	)

	(method (init)
		(SetFlag 82)
		(gEgo init:)
		(if (or (== gPrevRoomNum 380) (IsFlag 28))
			(= gPrevRoomNum 380)
			(= inOut 3)
			(if (gEgo has: 50) ; Saurus
				(EgoGait 3 0) ; riding
			)
		)
		(self setRegions: 660) ; desertReg
		(super init: &rest)
		(if gNight
			(raseir loop: 1 cel: 0)
			(InitAddToPics stellar1 stellar2)
		)
		(InitAddToPics raseir)
		(if (== gPrevRoomNum 380)
			(gEgo posn: 150 97 setScript: (ScriptID 660 8)) ; twoDunesIn
			(if (and (gEgo has: 50) (not (IsFlag 89))) ; Saurus
				(SetFlag 89)
				(self setScript: delayedMessage)
			)
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

(instance raseir of PicView
	(properties
		x 135
		y 90
		noun '/city,city,wall,raseir'
		description {the city of Raseir}
		lookStr {The city of Raseir is dark with despair.}
		view 780
		loop 2
		cel 1
		priority 0
		signal 16400
	)
)

(instance stellar1 of PicView
	(properties
		x 208
		y 62
		noun '/star,constellation<dragon'
		description {the Dragon constellation}
		lookStr {The star pattern known as the Dragon.}
		view 660
		loop 2
		priority 0
		signal 24592
	)
)

(instance stellar2 of PicView
	(properties
		x 86
		y 26
		noun '/star,constellation<scorpion'
		description {the Scorpion constellation}
		lookStr {The sign of the Scorpion.}
		view 660
		loop 2
		cel 1
		priority 0
		signal 24592
	)
)

(instance delayedMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 20)
			)
			(1
				(HighPrint 880 0) ; "The saurus is an amazing beast. This steed must have remained at the gate, awaiting your future need, while you carried on your business in Raseir."
				(self dispose:)
			)
		)
	)
)

