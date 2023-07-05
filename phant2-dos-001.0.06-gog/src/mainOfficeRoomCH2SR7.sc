;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3372)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)
(use Cycle)
(use Jump)

(public
	mainOfficeRoomCH2SR7 0
)

(local
	local0 = 7
	local1 = 10
	[local2 5] = [180 40 220 270 0]
)

(instance mainOfficeRoomCH2SR7 of P2Room
	(properties
		picture 171
	)

	(method (init)
		(super init: &rest)
		(allieProp init:)
		(curtis init:)
		(allieFeature init: allieProp)
		(sInterrogation init:)
		(ClearFlag 1001)
		(gGame handsOn: 1)
	)

	(method (newRoom)
		(SetFlag 264)
		(super newRoom: &rest)
	)

	(method (dispose)
		(gP2SongPlyr fadeOut: 0)
		(super dispose: &rest)
		(SetFlag 1001)
	)
)

(instance curtis of P2Fidget
	(properties
		x 495
		y 335
		view 11710
		loop 1
		initStart 2
		initFinish 4
		cycleFinish 8
	)
)

(instance sInterrogation of Script
	(properties)

	(method (changeState newState)
		(= global211 (= global212 1))
		(switch (= state newState)
			(0
				(allieProp setCycle: (allieCycle new:) sInterrogation)
				(gCast delete: self)
			)
			(1
				(proc63002_7 5730)
				(allieProp setCycle: (allieCycle new:) sInterrogation)
				(doorwayFeature
					init: [local2 0] [local2 1] [local2 2] [local2 3]
				)
			)
			(2
				(proc63002_7 5740)
				(allieProp setCycle: (allieCycle new:) sInterrogation)
			)
			(3
				(= global212 0)
				(= global209 5750)
				(gCurRoom newRoom: 7002) ; dreamingTreeRoomCH2
			)
		)
	)
)

(instance allieProp of Prop
	(properties
		x 348
		y 336
		view 11710
	)
)

(instance allieCycle of End
	(properties)

	(method (init)
		(super init: &rest)
		(client cel: 0)
		(= scratch (GetTime 1)) ; SysTime12
	)

	(method (nextCel)
		(if
			(or
				(and (== (client cel:) local0) (== cycleDir -1))
				(and
					(== (client cel:) local1)
					(== cycleDir 1)
					(<= (Abs (- (GetTime 1) scratch)) 4) ; SysTime12
				)
			)
			(= cycleDir (if (== cycleDir 1) -1 else 1))
		)
		(super nextCel:)
	)
)

(instance allieFeature of P2Feature
	(properties
		scene 5770
		sceneScored 1
		doneFlag 8
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(allieProp setCycle: (allieCycle new:) sInterrogation)
		)
	)

	(method (dispose)
		(= target 0)
		(super dispose:)
	)
)

(instance doorwayFeature of P2Feature
	(properties
		scene 5790
		doneFlag 9
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(gP2SongPlyr fadeIn: 3372)
			(secondDoorwayFeature
				init: [local2 0] [local2 1] [local2 2] [local2 3]
			)
			(allieProp setCycle: (allieCycle new:) sInterrogation)
		)
	)
)

(instance secondDoorwayFeature of ExitFeature
	(properties
		doneFlag 10
		nextRoom 7002
		exitScene 5810
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(allieProp setCycle: 0)
		)
	)
)

