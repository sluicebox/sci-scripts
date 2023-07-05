;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Polygon)
(use Motion)
(use System)

(public
	rm075 0
)

(instance rm075 of SQRoom
	(properties
		picture 75
		east 80
		south 90
		picAngle 70
		vanishingX 319
		vanishingY -40
	)

	(method (init)
		(sewer roomVer: 11491)
		(Load rsVIEW 80)
		(switch gPrevRoomNum
			(east
				(HandsOn)
				(gEgo y: 100)
				(self style: 40)
			)
			(else
				(HandsOff)
				(if (and (== (sewer status:) 3) (== (sewer location:) 75))
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 120 116
						setLoop: 0
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
				)
				(self setScript: enterScript style: 30)
			)
		)
		(gEgo init:)
		(super init:)
		((ScriptID 702 2) show:) ; theSlime
		(self
			setRegions: 702 ; sewer
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 153 95 36 189 0 189 0 0 319 0 319 95
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 101 319 189 50 189 159 101
					yourself:
				)
		)
		(if (and (!= (sewer location:) 75) (!= gPrevRoomNum 90))
			(sewer status: 1)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) 3)
				(HandsOff)
				(gCurRoom setScript: exitScript)
			)
		)
		(super doit: &rest)
		(if (and (> (gEgo y:) 180) (== (sewer status:) 1))
			(sewer status: 2)
			((ScriptID 702 3) init: setScript: dripScript) ; theDrip
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: -16 y: 246 setLoop: 6 setMotion: MoveTo 50 181 self)
			)
			(1
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 5 setMotion: MoveTo -16 246 self)
			)
			(1
				(HandsOff)
				(if (== (sewer status:) 2)
					(sewer status: 3)
				)
				(gCurRoom newRoom: 90)
			)
		)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLongSong2 play:)
				((ScriptID 702 2) init: hide:) ; theSlime
				(sewer location: 75)
				((ScriptID 702 3) ; theDrip
					setLoop: 5
					posn: 82 90
					cel: 0
					cycleSpeed: 2
					setCycle: CT 9 1 self
				)
				(gLongSong fade: 80 10 10 0)
				(gLongSong2 number: 806 loop: 1 play:)
			)
			(1
				((ScriptID 702 3) setCycle: End) ; theDrip
				((ScriptID 702 2) ; theSlime
					show:
					setLoop: 7
					cycleSpeed: 1
					setCycle: End self
					posn: 109 125
				)
			)
			(2
				(gLongSong2 number: 819 loop: -1 play:)
				(sewer status: 3)
				((ScriptID 702 2) ; theSlime
					setLoop: 0
					setCycle: Fwd
					cycleSpeed: 0
					setScript: (ScriptID 702 4) ; theSlimeScript
				)
				(self dispose:)
			)
		)
	)
)

