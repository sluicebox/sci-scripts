;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20311)
(include sci.sh)
(use Main)
(use n951)
(use Array)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm20v311 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 25) ((++ temp0))
		(if ((local0 at: temp0) cel:)
			(return 0)
		)
	)
	(return 1)
)

(instance rm20v311 of ShiversRoom
	(properties
		picture 20312
	)

	(method (init &tmp temp0 temp1 temp2)
		(= local2 0)
		(spPuzzle init:)
		(= local0 (IntArray new:))
		(for ((= temp0 0)) (< temp0 25) ((++ temp0))
			(= temp1 (+ 70 (* (/ temp0 5) 24)))
			(= temp2 (+ 20 (* (mod temp0 5) 20)))
			(local0
				at:
					temp0
					((spSquare new:)
						loop: temp0
						cel: (Random 0 3)
						posn: temp1 temp2
						init:
						yourself:
					)
			)
		)
		(efExitRight init: 8)
		(efExitLeft init: 8)
		(super init: &rest)
	)

	(method (newRoom)
		(if (== local2 1)
			(gSounds play: 12018 0 82 0)
		)
		(super newRoom: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 209
		nsTop 0
		nsRight 263
		nsBottom 143
		nextRoom 20310
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20310
	)

	(method (init)
		(self createPoly: 0 0 60 0 60 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance spPuzzle of ShiversProp
	(properties
		priority 200
		fixPriority 1
		view 20312
		cycleSpeed 9
	)

	(method (doVerb)
		(= local2 1)
		(self createPoly: -1 -1 -1 -1 -1 -1 setCycle: End)
		(gSounds play: 12017 0 82 0)
	)
)

(instance spSquare of ShiversProp
	(properties
		view 20313
	)

	(method (doVerb)
		(gSounds stop: 12002)
		(= cel (mod (++ cel) 4))
		(gSounds play: 12002 0 82 0)
		(UpdateScreenItem self)
		(FrameOut)
		(if (localproc_0)
			(gCurRoom setScript: sIsSolved)
		)
	)
)

(instance vCup of View
	(properties
		priority 175
		fixPriority 1
		view 20312
		loop 1
	)
)

(instance aBall of Actor
	(properties
		priority 170
		fixPriority 1
		view 20313
		loop 25
		signal 18433
		cycleSpeed 1
	)
)

(instance sIsSolved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc951_15 6750)
				(= seconds 1)
			)
			(1
				(spPuzzle hide:)
				(vCup init:)
				(SetFlag 18)
				(= local1 (IntArray new:))
				(local1
					at:
						0
						((aBall new:)
							posn: 80 13
							moveSpeed: 4
							setMotion:
								DPath
								80
								25
								86
								31
								94
								31
								97
								33
								98
								41
								91
								47
								78
								47
								78
								63
								82
								67
								101
								67
								109
								62
								123
								72
								111
								82
								104
								82
								95
								91
								84
								91
								77
								97
								77
								100
								86
								108
								110
								108
								122
								118
								121
								129
								self
							setCycle: Fwd
							init:
						)
				)
				(local1
					at:
						1
						((aBall new:)
							posn: 129 12
							moveSpeed: 4
							setMotion:
								DPath
								129
								24
								107
								44
								107
								47
								129
								65
								144
								53
								146
								53
								157
								62
								128
								88
								115
								88
								112
								92
								112
								98
								129
								113
								129
								129
								self
							setCycle: Fwd
							init:
						)
				)
				(local1
					at:
						2
						((aBall new:)
							posn: 178 13
							moveSpeed: 3
							setMotion:
								DPath
								177
								22
								167
								30
								138
								30
								130
								37
								126
								37
								122
								40
								122
								43
								130
								43
								131
								47
								157
								47
								173
								60
								174
								60
								179
								56
								186
								56
								186
								75
								176
								82
								165
								75
								154
								83
								169
								97
								186
								97
								186
								106
								171
								106
								165
								102
								155
								102
								148
								97
								141
								97
								136
								101
								136
								129
								self
							setCycle: Fwd
							init:
						)
				)
				(gSounds play: 12003 0 82 0)
			)
			(2)
			(3)
			(4
				(= ticks 15)
			)
			(5
				(spPuzzle show:)
				(gSounds play: 12018 0 82 0)
				(spPuzzle setCycle: Beg self)
			)
			(6
				(= local2 0)
				(gSounds play: 12004 0 82 self)
			)
			(7
				(gCurRoom newRoom: 20310) ; rm20v310
			)
		)
	)
)

