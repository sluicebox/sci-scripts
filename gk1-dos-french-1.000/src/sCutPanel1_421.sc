;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 421)
(include sci.sh)
(use Main)
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
				(gCurRoom style: 14 drawPic: 620)
				(gGkMusic2
					number: 341
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic2 musicVolume:) 5 10 0
				)
				(= seconds 4)
			)
			(1
				(v1 init:)
				(gMessager say: 6 11 0 3 self 420) ; "(HORRIBLY EVIL, HISSING)Stay away from Malia Gedde...."
			)
			(2
				(gMessager say: 6 11 0 4 self 420) ; "(HORRIBLY EVIL, HISSING)Or you shall pay with your LIFE!!!"
				(v2 init:)
			)
			(3
				(v3 init:)
				(= seconds 4)
			)
			(4
				(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
					(Palette 2 0 255 temp0) ; PalIntensity
				)
				(v1 dispose:)
				(v2 dispose:)
				(v3 dispose:)
				(= cycles 1)
			)
			(5
				(gGkMusic2
					number: 420
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic2 musicVolume:) 5 10 0
				)
				(self dispose:)
			)
		)
	)
)

(instance v1 of Actor
	(properties
		x 67
		y 22
		view 620
	)
)

(instance v2 of Actor
	(properties
		x 67
		y 97
		view 620
		cel 1
	)
)

(instance v3 of Actor
	(properties
		x 192
		y 21
		view 620
		cel 2
	)
)

