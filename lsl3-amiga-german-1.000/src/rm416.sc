;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 416)
(include sci.sh)
(use Main)
(use n021)
(use Extra)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm416 0
)

(instance rm416 of Rm
	(properties
		picture 416
		east 450
		west 410
	)

	(method (init)
		(Load rsVIEW 415)
		(Load rsVIEW 416)
		(Load rsVIEW 417)
		(Load rsVIEW 418)
		(Load rsVIEW 419)
		(super init:)
		(self setRegions: 417) ; regCasino
		(cond
			((== gPrevRoomNum 410)
				(gEgo posn: 1 143)
			)
			((or (== gEgoState 11) (> (gEgo yLast:) 180))
				(gEgo posn: 315 136)
			)
			(else
				(gEgo posn: 290 122)
			)
		)
		(NormalEgo)
		(gEgo init:)
		(aCraps init: isExtra: 1)
		(aCard init: isExtra: 1)
		(if (> gMachineSpeed 16)
			(aWalker init:)
			(aAlterEgo init:)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(or
				(& (gEgo onControl:) $0002)
				(and (== gEgoState 11) (& (gEgo onControl:) $0004))
			)
			(gCurRoom newRoom: 450)
		)
	)
)

(instance aAlterEgo of Actor
	(properties
		view 700
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self
			view: (gEgo view:)
			setPri: 4
			posn: (gEgo x:) 122
			ignoreHorizon:
			ignoreActors:
		)
	)

	(method (doit)
		(aAlterEgo
			view: (gEgo view:)
			loop:
				(switch (gEgo loop:)
					(3 2)
					(2 3)
					(else
						(gEgo loop:)
					)
				)
			cel: (gEgo cel:)
			x: (gEgo x:)
			y: (- 125 (/ (- (gEgo y:) 127) 2))
		)
		(super doit:)
	)
)

(instance aCraps of Extra
	(properties
		x 122
		y 60
		view 414
		loop 3
		cel 11
		cycleSpeed 0
		cycleType 1
		hesitation 11
		pauseCel 11
		minPause 22
		maxPause 111
	)
)

(instance aCard of Extra
	(properties
		x 160
		y 60
		view 414
		loop 1
		minPause 11
		maxPause 55
		minCycles 15
		maxCycles 44
	)
)

(instance aWalker of Actor
	(properties
		x 119
		y 15
		view 415
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self ignoreActors: setCycle: Walk setStep: 2 1 setScript: WalkerScript)
	)
)

(instance WalkerScript of Script
	(properties)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0
				(= seconds (Random 2 6))
			)
			(1
				(switch (Random 0 6)
					(0
						(aWalker
							view: (Random 415 419)
							posn: 72 15
							setPri: 1
							setMotion: MoveTo 198 15 self
						)
					)
					(1
						(aWalker
							view: (Random 415 419)
							posn: 198 15
							setPri: 1
							setMotion: MoveTo 72 15 self
						)
					)
					(2
						(aWalker
							view: 415
							posn: 132 32
							setPri: 0
							setMotion: MoveTo 132 142 self
						)
					)
					(3
						(aWalker
							view: 415
							posn: 132 142
							setPri: 0
							setMotion: MoveTo 132 32 self
						)
					)
					(else
						(= seconds 2)
					)
				)
				(= state -1)
			)
		)
	)
)

