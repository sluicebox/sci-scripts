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

(instance cloudRoom of Room
	(properties
		picture 65
	)

	(method (init)
		(super init:)
		(proc0_2)
		(gooseRider
			view: (+ global114 21)
			setCycle: Fwd
			setLoop: 1
			x: 280
			init:
			setMotion: MoveTo 28 110 self
		)
		(proc0_8)
	)

	(method (cue &tmp temp0)
		(gLongSong fade: 0 10 3 1)
		(gCurRoom newRoom: 94) ; morning
		(= global176 1)
		(gCast eachElementDo: #dispose)
		(= global107 1)
	)
)

(instance gooseRider of Actor
	(properties
		x -20
		y 90
		cycleSpeed 4
		xStep 1
		moveSpeed 1
	)
)

