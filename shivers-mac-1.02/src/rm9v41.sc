;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9410)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v41 0
)

(instance rm9v41 of ShiversRoom
	(properties
		picture 9410
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(pFountain init:)
		(if (IsFlag 42)
			(if (and (IsFlag 42) (== gPrevRoomNum 9440)) ; rm9v44
				(gSounds fade: 10908 26 15 8 0 0)
			)
			(if (proc951_11 0 9000)
				(gSounds fade: 20903 0 10 16 1 0)
				(gSounds stop: 20908)
				(proc951_9 20908)
				(gSounds play: 20908 -1 50 0)
			)
			((Prop new:)
				view: 9410
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9410 setPri: 5 1 loop: 0 init:)
		)
		(if (IsFlag 43)
			(gSounds play: 10930 0 82 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 9390) (IsFlag 42) (proc951_11 0 9000)) ; rm9v39
			(gSounds fade: 20908 0 10 16 1 0)
			(gSounds stop: 20903)
			(proc951_9 20903)
			(gSounds play: 20903 -1 0 0)
			(gSounds fade: 20903 42 10 16 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9420
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9400
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9390
	)

	(method (init)
		(self
			createPoly:
				167
				141
				167
				132
				172
				127
				173
				117
				169
				112
				147
				105
				147
				101
				144
				96
				146
				95
				146
				94
				142
				91
				134
				89
				122
				88
				113
				88
				113
				85
				110
				85
				109
				84
				109
				80
				105
				77
				107
				71
				108
				69
				105
				62
				105
				59
				103
				57
				101
				56
				98
				56
				99
				53
				94
				52
				94
				48
				92
				46
				90
				45
				84
				47
				83
				47
				82
				46
				78
				50
				74
				45
				69
				43
				67
				43
				65
				47
				65
				49
				64
				54
				59
				54
				55
				55
				50
				57
				50
				61
				54
				64
				55
				65
				51
				69
				53
				70
				49
				75
				48
				77
				52
				79
				59
				79
				59
				84
				60
				88
				60
				90
				45
				90
				33
				95
				26
				98
				23
				101
				9
				112
				9
				141
				167
				142
		)
		(super init: &rest)
	)
)

(instance pFountain of ShiversProp
	(properties
		priority 3
		fixPriority 1
		view 9410
	)
)

