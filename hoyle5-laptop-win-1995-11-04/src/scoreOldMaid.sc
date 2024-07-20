;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use h5Messager)
(use oldMaid)
(use GameControls)
(use User)
(use System)

(public
	scoreOldMaid 0
)

(local
	local0
	[local1 18] = [8 4 2 3 1 5 6 7 0 13 15 9 16 12 10 14 11 17]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(gGame setCursor: 999)
	((= gGameControls oldMaidScore)
		plane: oldMaidScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor
			x: (+ (/ (- gScreenWidth 376) 2) (iconOK nsLeft:) 20)
			y: (+ (/ (- gScreenHeight 258) 2) (iconOK nsTop:) 13)
		)
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreOldMaid of Code
	(properties)

	(method (doit)
		(proc17_2)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
		)
		(localproc_0)
		(PlaySong play: 0)
		(proc64996_0)
	)
)

(instance oldMaidScoreWindow of InvisibleWindow
	(properties)

	(method (init &tmp temp0 temp1 [temp2 4])
		(= top (/ (- gScreenHeight 258) 2))
		(= left (/ (- gScreenWidth 376) 2))
		(= bottom (+ (/ (- gScreenHeight 258) 2) 258))
		(= right (+ (/ (- gScreenWidth 376) 2) 376))
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= priority 15)
		(super init:)
		(proc0_10 280 0 0 0 0 15 self)
		(= temp1 (proc200_3 ((global117 at: 1) owner:)))
		(if global916
			(-= temp1 1400)
		)
		(proc0_10 280 (if global916 2 else 1) temp1 165 66 15 self {score})
		(drawMaids doit: temp1 1 33)
		(= temp1 (proc200_3 ((global117 at: 2) owner:)))
		(if global916
			(-= temp1 1400)
		)
		(proc0_10 280 (if global916 2 else 1) temp1 165 107 15 self {score})
		(drawMaids doit: temp1 2 74)
		(= temp1 (proc200_3 ((global117 at: 3) owner:)))
		(if global916
			(-= temp1 1400)
		)
		(proc0_10 280 (if global916 2 else 1) temp1 165 148 15 self {score})
		(drawMaids doit: temp1 3 115)
		(proc0_10 280 3 0 165 188 15 self {score})
		(drawMaids doit: 99 0 156)
	)
)

(instance drawMaids of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1)
		(for
			((= temp0 0))
			(< temp0 ((global117 at: param2) total:))
			((++ temp0))
			
			(proc0_10
				280
				4
				0
				(+ (* temp0 38) 212)
				param3
				15
				oldMaidScoreWindow
				{score}
			)
		)
	)
)

(instance oldMaidScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 189
		nsTop 199
		x 189
		y 199
		signal 387
		mainView 280
		mainLoop 5
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

