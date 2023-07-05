;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 894)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	sCutPanel4 0
)

(instance sCutPanel4 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 99 0)
				(= cycles 2)
			)
			(1
				(Palette 2 0 255 100) ; PalIntensity
				(gCurRoom drawPic: 665 0)
				(= seconds 2)
			)
			(2
				(v2 init:)
				(gMessager say: 13 0 33 2 self 900) ; "(TERRIBLE. BITTER)It's not over yet...my love! If I go...you go."
			)
			(3
				(v3 init:)
				(gGkMusic1
					number: 904
					setLoop: 1
					stop:
					setVol: (gGkMusic1 musicVolume:)
					play: self
				)
			)
			(4
				(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
					(Palette 2 0 255 temp0) ; PalIntensity
				)
				(v2 dispose:)
				(v3 dispose:)
				(= cycles 1)
			)
			(5
				(gCurRoom drawPic: 99 0)
				(self dispose:)
				(DisposeScript 894)
			)
		)
	)
)

(instance v2 of View
	(properties
		x 104
		y 22
		view 665
	)
)

(instance v3 of View
	(properties
		x 203
		y 22
		view 665
		loop 1
	)
)

