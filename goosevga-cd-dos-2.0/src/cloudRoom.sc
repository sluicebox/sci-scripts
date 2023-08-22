;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	cloudRoom 0
)

(instance cloudRoom of Rm
	(properties
		picture 65
		style 0
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gooseRider
			view: (+ global114 21)
			init:
			setCycle: Walk
			setMotion: MoveTo 280 110 self
		)
		(if (== gPrevRoomNum 92) ; endScene
			(gooseRider setLoop: 1 x: 280 setMotion: MoveTo 28 110 self)
		)
		(proc0_8)
	)

	(method (cue &tmp temp0)
		(gCurRoom newRoom: (if (== gPrevRoomNum 92) 94 else 32)) ; endScene
		(= global176 1)
		(for ((= temp0 100)) (>= temp0 0) ((-= temp0 4))
			(Palette palSET_INTENSITY 0 255 temp0)
			(Wait 2)
		)
		(gCast eachElementDo: #dispose)
		(Animate (gCast elements:) 0)
		(= global107 1)
	)
)

(instance gooseRider of Act
	(properties
		y 90
		x -20
		signal 2048
		cycleSpeed 3
		xStep 1
	)
)

