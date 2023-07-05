;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 891)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	sCutPanel1 0
)

(instance sCutPanel1 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 99 0)
				(= cycles 2)
			)
			(1
				(Palette 2 0 255 100) ; PalIntensity
				(gCurRoom drawPic: 650 14)
				(= cycles 1)
			)
			(2
				(gGkMusic1
					number: 901
					setLoop: 1
					stop:
					setVol: (gGkMusic1 musicVolume:)
					play:
				)
				(gGkSound1 setLoop: 1 number: 908 play: self)
			)
			(3
				(v2 init:)
				(= seconds 1)
				(gGkMusic1
					number: 902
					setLoop: -1
					stop:
					setVol: (gGkMusic1 musicVolume:)
					play:
				)
			)
			(4
				(gGkSound1 setLoop: 1 number: 916 play:)
				(v2 view: 651 setLoop: 0 setCel: 0)
				(gMessager say: 9 124 43 1 self 900) ; "(GROUP SCREAM OF CONFUSION AND FEAR AS DR JOHN IS SHOT)Ahhh!"
			)
			(5
				(v3 init:)
				(blood init: setCycle: End)
				(gMessager say: 9 124 43 2 self 900) ; "(TO THE OTHER CULTISTS)Get OUT! All of you!"
			)
			(6
				(v4 init:)
				(smoke init: setCycle: End)
				(= seconds 4)
			)
			(7
				(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
					(Palette 2 0 255 temp0) ; PalIntensity
				)
				(v2 dispose:)
				(v3 dispose:)
				(v4 dispose:)
				(blood dispose:)
				(smoke dispose:)
				(= cycles 1)
			)
			(8
				(gCurRoom drawPic: 99 0)
				(self dispose:)
				(DisposeScript 891)
			)
		)
	)
)

(instance v2 of View
	(properties
		x 127
		y 22
		priority 1
		fixPriority 1
		view 650
	)
)

(instance v3 of View
	(properties
		x 85
		y 61
		priority 1
		fixPriority 1
		view 650
		loop 1
	)
)

(instance v4 of View
	(properties
		x 212
		y 22
		priority 1
		fixPriority 1
		view 650
		loop 2
	)
)

(instance blood of Prop
	(properties
		x 85
		y 61
		priority 3
		fixPriority 1
		view 652
		loop 1
		signal 16417
		cycleSpeed 12
	)
)

(instance smoke of Prop
	(properties
		x 212
		y 22
		view 653
		loop 2
		signal 16417
		cycleSpeed 12
	)
)

