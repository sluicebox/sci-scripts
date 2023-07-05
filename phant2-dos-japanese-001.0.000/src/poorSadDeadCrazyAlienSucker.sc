;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 999)
(include sci.sh)
(use Main)
(use n63002)
(use ControlPanel)
(use Plane)
(use Room)
(use PolyEdit)
(use TextField)
(use System)

(public
	poorSadDeadCrazyAlienSucker 0
)

(local
	local0
	local1 = 60
	local2
	local3 = -1
)

(instance poorSadDeadCrazyAlienSucker of Room
	(properties
		picture 9000
	)

	(method (init)
		(= local2 local1)
		(= gVerb 4) ; Do
		(= local0 (gP2SongPlyr volPercent:))
		(gP2SongPlyr fadeOut: 1)
		(if global209
			(proc63002_7 global209)
			(= global209 0)
		)
		((= plane (Plane new: 0 0 639 479)) init: setPri: 4000)
		(gPlanes plane: plane)
		(super init: &rest)
		(FrameOut)
		(proc63002_11 0 0 0 2 1)
		(deathRoomButton new: againCode 0 1 75 23)
		(deathRoomButton new: loadCode 1 2 75 73)
		(deathRoomButton new: quitCode 2 3 407 328)
		(gGame handsOn:)
	)

	(method (dispose)
		((plane cast:) delete: self)
		(plane dispose:)
		(gPlanes plane: (= plane 0))
		(gP2SongPlyr pause: 0)
		(if local0
			(gP2SongPlyr fadeTo: local0)
		else
			(gP2SongPlyr stop:)
		)
		(super dispose: &rest)
	)
)

(instance deathRoomButton of View
	(properties
		view 9000
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
		(return temp0)
	)

	(method (init param1 param2 param3)
		(|= signal $1000)
		(= loop param2)
		(super init: (gCurRoom plane:))
		(self posn: &rest)
		(= responder param1)
		(self update:)
		(self setRect:)
		(self hide:)
		(deathRmTxt new: param3 self)
	)

	(method (handleEvent event)
		(if (& signal $0008)
			(if (& (event type:) evMOUSEBUTTON)
				(self show:)
				((gUser hogs:) push: self 1)
				(event claimed: self)
			)
		else
			(event localize: plane)
			(if (& (event type:) evMOUSERELEASE)
				((gUser hogs:) pop:)
				(if (self onMe: event)
					(gP2SoundFX play: 62999)
					(SendMany new: responder 9)
				)
				(self hide:)
				(event claimed: self)
			)
		)
		(event claimed:)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 2)
			(= temp0 param1)
			(= temp1 param2)
		else
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		)
		(return (and (<= left temp0 right) (<= top temp1 bottom)))
	)

	(method (setRect)
		(super setRect: &rest)
		(super setRect: left top (+ left (- bottom top)) bottom)
	)
)

(instance deathRmTxt of TextView
	(properties)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
		(return temp0)
	)

	(method (init param1 param2)
		(self setText: 0 0 0 19 param1)
		(self setSize:)
		(super init: (gCurRoom plane:))
		(self hide:)
		((gUser mousers:) add: self)
		(= target param2)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(event localize: plane)
		(cond
			((target onMe: event)
				(if (and (& signal $0008) (!= local3 (= temp2 (GetTime))))
					(= local3 temp2)
					(if (not (-- local2))
						(= local2 local1)
						(= temp0 (- (event x:) (/ celWidth 2)))
						(= temp1
							(+
								(event y:)
								(-
									(CelHigh
										(gTheCursor view:)
										(gTheCursor loop:)
										(gTheCursor cel:)
									)
									(CelInfo
										1 ; GetOrigY
										(gTheCursor view:)
										(gTheCursor loop:)
										(gTheCursor cel:)
									)
								)
								1
							)
						)
						(self
							posn:
								(Max
									0
									(Min (- 639 (/ celWidth 2)) temp0)
								)
								(Max
									0
									(Min (- 479 celHeight) temp1)
								)
						)
						(self show:)
					)
				)
			)
			((not (& signal $0008))
				(self hide:)
				(= local2 local1)
			)
		)
	)

	(method (dispose)
		(= target 0)
		((gUser mousers:) delete: self)
		(super dispose: &rest)
	)
)

(instance againCode of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 gPrevRoomNum)
		(if (OneOf temp0 3006 30061 3007 3008)
			(= temp0 3006)
		)
		(switch temp0
			(5025
				(ClearFlag 728)
				(ClearFlag 729)
				(ClearFlag 730)
				(ClearFlag 731)
				(= local0 0)
				(gCurRoom newRoom: 5015) ; harburgCH5SR1
			)
			(6506
				(ClearFlag 1504)
				(= local0 0)
				(gCurRoom newRoom: 6506) ; backYard
			)
			(6406
				(ClearFlag 1505)
				(= local0 0)
				(gCurRoom newRoom: 6406) ; blEndGame
			)
			(1006
				(ClearFlag 1506)
				(= local0 0)
				(gCurRoom newRoom: 1006) ; mhEndGame
			)
			(1016
				(ClearFlag 1506)
				(= local0 0)
				(gCurRoom newRoom: 1006) ; mhEndGame
			)
			(7006
				(ClearFlag 1508)
				(= local0 0)
				(gCurRoom newRoom: 7006) ; dreamingTreeRoomENDGAME
			)
			(3006
				(ClearFlag 1500)
				(ClearFlag 1501)
				(ClearFlag 1503)
				(ClearFlag 1502)
				(gP2SongPlyr number: 0)
				(gEgo put: 2) ; cardKeyI
				(= local0 0)
				(gCurRoom newRoom: 3006) ; mainHallRoomENDGAME
			)
			(3486
				(gCurRoom newRoom: 3486) ; threshLock
			)
			(9020
				(gCurRoom newRoom: 9000) ; threshCompRm
			)
			(else
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance quitCode of Code
	(properties)

	(method (doit)
		(= local0 0)
		(gCurRoom newRoom: 62999) ; p2IntroRm
	)
)

(instance loadCode of Code
	(properties)

	(method (doit)
		(Palette 2 2 31 100) ; PalIntensity
		(gGame panelSend: ControlPanel 5)
	)
)

