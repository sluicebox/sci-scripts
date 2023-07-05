;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 415)
(include sci.sh)
(use Main)
(use n021)
(use Extra)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm415 0
)

(instance rm415 of Rm
	(properties
		picture 415
		east 410
		west 420
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
				(gEgo posn: 318 143)
			)
			((or (== gEgoState 11) (> (gEgo y:) 180))
				(gEgo posn: 1 143)
			)
			(else
				(gEgo posn: 31 122)
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
			(gCurRoom newRoom: 420)
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
		x 198
		y 62
		view 414
		loop 2
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
		y 59
		view 414
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
		view 414
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
							posn: 251 15
							setPri: 1
							setMotion: MoveTo 119 15 self
						)
					)
					(1
						(aWalker
							view: (Random 415 419)
							posn: 119 15
							setPri: 1
							setMotion: MoveTo 251 15 self
						)
					)
					(2
						(aWalker
							view: 415
							posn: 186 33
							setPri: 0
							setMotion: MoveTo 186 142 self
						)
					)
					(3
						(aWalker
							view: 415
							posn: 186 142
							setPri: 0
							setMotion: MoveTo 186 33 self
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

