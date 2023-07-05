;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 892)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	sCutPanel2 0
)

(instance sCutPanel2 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 99 0)
				(= cycles 2)
			)
			(1
				(Palette 2 0 255 100) ; PalIntensity
				(gCurRoom drawPic: 655 0)
				(maliaFall init: setCycle: End self)
			)
			(2
				(v2 init:)
				(= seconds 4)
			)
			(3
				(v3 init:)
				(lava1 init: setCycle: Fwd)
				(lava2 init: setCycle: Fwd)
				(mFace init:)
				(= seconds 2)
			)
			(4
				(mFace setCycle: End)
				(gMessager say: 7 12 26 3 self 900) ; "(MALIA/TETELO IS NOW HANGING OVER CRACK IN FLOOR)Go ahead! Destroy her! Destroy me! You are truly your father's son, Witch-hunter!"
			)
			(5
				(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
					(Palette 2 0 255 temp0) ; PalIntensity
				)
				(v2 dispose:)
				(v3 dispose:)
				(maliaFall dispose:)
				(lava1 dispose:)
				(lava2 dispose:)
				(mFace dispose:)
				(= cycles 1)
			)
			(6
				(gCurRoom drawPic: 99 0)
				(self dispose:)
				(DisposeScript 892)
			)
		)
	)
)

(instance v2 of View
	(properties
		x 149
		y 22
		view 655
	)
)

(instance v3 of View
	(properties
		x 173
		y 22
		view 655
		loop 1
	)
)

(instance maliaFall of Prop
	(properties
		x 31
		y 50
		view 656
		cycleSpeed 12
	)
)

(instance lava1 of Prop
	(properties
		x 189
		y 105
		view 657
	)
)

(instance lava2 of Prop
	(properties
		x 257
		y 26
		view 657
		loop 1
		signal 16417
		cycleSpeed 8
	)
)

(instance mFace of Prop
	(properties
		x 220
		y 62
		view 658
		loop 1
		cycleSpeed 12
	)
)

